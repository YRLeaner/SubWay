package com.example.tyr.subway3;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tyr.subway3.activity.VideoActivity;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class MyVideoView extends FrameLayout implements View.OnTouchListener, View.OnClickListener, Animator
        .AnimatorListener {
    private static final String TAG = "joshua";

    private static final int HANDLER_MSG_UPDATE_PROGRESS = 1;
    private static final int HANDLER_DEPLAY_UPDATE_PROGRESS = 1000; // 1s

    private Context context;
    private FrameLayout viewBox;
    private VideoView mVideoView;
    private LinearLayout videoPauseBtn;
    private LinearLayout screenSwitchBtn;
    private LinearLayout touchStatusView;
    private LinearLayout videoControllerLayout;
    private ImageView touchStatusImg;
    private ImageView videoPlayImg;
    private ImageView videoPauseImg;
    private TextView touchStatusTime;
    private TextView videoCurTimeText;
    private TextView videoTotalTimeText;
    private SeekBar mSeekBar;
    private ProgressBar progressBar;

    private float touchLastX;
    //定义用seekBar当前的位置，触摸快进的时候显示时间
    private int position;
    private int touchStep = 1000;//快进的时间，1秒
    private int touchPosition = -1;

    private boolean videoControllerShow = true;//底部状态栏的显示状态
    private boolean animation = false;
    private int timeTotal;
    private int timeCurrent;

    private String url;

    private Handler mMainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case HANDLER_MSG_UPDATE_PROGRESS:
                    int duration = mVideoView.getDuration();
                    int progress = mVideoView.getCurrentPosition();
                    Log.w("joshua", "handleMessage: duration: " + duration + "  progress " + progress);
                    if (duration > 0) {
                        mSeekBar.setMax(duration);
                        mSeekBar.setProgress(progress);

                        timeTotal = duration;
                        timeCurrent = progress;
                        videoCurTimeText.setText(ms2hms(timeCurrent));
                        videoTotalTimeText.setText(ms2hms(timeTotal));
                    }
                    mMainHandler.sendEmptyMessageDelayed(HANDLER_MSG_UPDATE_PROGRESS, HANDLER_DEPLAY_UPDATE_PROGRESS);
                    break;
                default:
                    break;
            }
        }
    };

    public MyVideoView(Context context) {
        this(context, null);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void start() {
        if (mVideoView != null)
            mVideoView.start();
        mMainHandler.sendEmptyMessageDelayed(HANDLER_MSG_UPDATE_PROGRESS, HANDLER_DEPLAY_UPDATE_PROGRESS);
    }

    public void destroy() {
        mMainHandler.removeCallbacksAndMessages(null);

        mVideoView = null;
    }

    public void pause() {
        if (null != mVideoView) {
            mVideoView.pause();
        }
        mMainHandler.removeMessages(HANDLER_MSG_UPDATE_PROGRESS);
    }

    public void setPlayData(String var1) {
        videoPauseBtn.setEnabled(true);
        url = var1;
        mVideoView.setVideoPath(var1);
       // mVideoView.setVideoURI(Uri.parse(var1));
        //设置回调，监听播放器状态
        mVideoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
    }



    public void setFullScreen() {
        touchStatusImg.setImageResource(R.mipmap.iconfont_exit);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mVideoView.requestLayout();
    }

    public void setNormalScreen() {
        touchStatusImg.setImageResource(R.mipmap.iconfont_enter_32);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
        mVideoView.requestLayout();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.common_video_view, null);
        viewBox = (FrameLayout) view.findViewById(R.id.viewBox);
        mVideoView = (VideoView) view.findViewById(R.id.videoView);
        videoPauseBtn = (LinearLayout) view.findViewById(R.id.videoPauseBtn);
        screenSwitchBtn = (LinearLayout) view.findViewById(R.id.screen_status_btn);
        videoControllerLayout = (LinearLayout) view.findViewById(R.id.videoControllerLayout);
        touchStatusView = (LinearLayout) view.findViewById(R.id.touch_view);
        touchStatusImg = (ImageView) view.findViewById(R.id.touchStatusImg);
        touchStatusTime = (TextView) view.findViewById(R.id.touch_time);
        videoCurTimeText = (TextView) view.findViewById(R.id.videoCurTime);
        videoTotalTimeText = (TextView) view.findViewById(R.id.videoTotalTime);
        videoPlayImg = (ImageView) view.findViewById(R.id.videoPlayImg);
        videoPlayImg.setVisibility(GONE);
        videoPauseImg = (ImageView) view.findViewById(R.id.videoPauseImg);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        videoPauseBtn.setOnClickListener(this);
        videoPauseBtn.setOnClickListener(this);
        screenSwitchBtn.setOnClickListener(this);
        videoPlayImg.setOnClickListener(this);
        //注册在设置或播放过程中发生错误时调用的回调函数。如果未指定回调函数，或回调函数返回false，mVideoView 会通知用户发生了错误。
        viewBox.setOnClickListener(this);
        viewBox.setOnTouchListener(this);
        addView(view);

        initSeekBar(view);
    }

    private void initSeekBar(View view) {
        mSeekBar = (SeekBar) view.findViewById(R.id.videoSeekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("TXT","move");
                //LogUtils.d(TAG, "onProgressChanged, progress = " + progress + ", fromUser = " + fromUser);
                if (fromUser) {
                    this.progress = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.w("joshua", "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mSeekBar.setProgress(progress);
                Log.w("joshua", "onStopTrackingTouch: seekTo " + progress);
                mVideoView.seekTo(progress);
                progressBar.setVisibility(View.VISIBLE);
                videoPlayImg.setVisibility(View.INVISIBLE);
                videoPauseImg.setImageResource(R.mipmap.icon_video_pause);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mVideoView.isPlaying()) {
                    return false;
                }
                float downX = event.getRawX();
                touchLastX = downX;
                Log.d("FilmDetailActivity", "downX" + downX);
                this.position = mVideoView.getCurrentPosition();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mVideoView.isPlaying()) {
                    return false;
                }
                float currentX = event.getRawX();
                float deltaX = currentX - touchLastX;
                float deltaXAbs = Math.abs(deltaX);
                if (deltaXAbs > 1) {
                    if (touchStatusView.getVisibility() != View.VISIBLE) {
                        touchStatusView.setVisibility(View.VISIBLE);
                    }
                    touchLastX = currentX;
                    Log.d("FilmDetailActivity", "deltaX" + deltaX);
                    if (deltaX > 1) {
                        position += touchStep;
                        if (position > timeTotal) {
                            position = timeTotal;
                        }
                        touchPosition = position;
                        touchStatusImg.setImageResource(R.mipmap.ic_fast_forward_white_24dp);
                        touchStatusTime.setText(ms2hms(timeCurrent) + "/" + ms2hms(timeTotal));
                    } else if (deltaX < -1) {
                        position -= touchStep;
                        if (position < 0) {
                            position = 0;
                        }
                        touchPosition = position;
                        touchStatusImg.setImageResource(R.mipmap.ic_fast_rewind_white_24dp);
                        touchStatusTime.setText(ms2hms(timeCurrent) + "/" + ms2hms(timeTotal));
                        mVideoView.seekTo(position);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (touchPosition != -1) {
                    mVideoView.seekTo(touchPosition);
                    touchStatusView.setVisibility(View.GONE);
                    touchPosition = -1;
                    if (videoControllerShow) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.videoPlayImg:
                mVideoView.start();
                videoPlayImg.setVisibility(View.INVISIBLE);
                videoPauseImg.setImageResource(R.mipmap.icon_video_pause);
                break;
            case R.id.videoPauseBtn:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    videoPauseImg.setImageResource(R.mipmap.icon_video_play);
                    videoPlayImg.setVisibility(View.VISIBLE);
                } else {
                    mVideoView.start();
                    videoPauseImg.setImageResource(R.mipmap.icon_video_pause);
                    videoPlayImg.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.viewBox:
                float curY = videoControllerLayout.getY();
                if (!animation && videoControllerShow) {
                    animation = true;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(videoControllerLayout, "y",
                            curY, curY + videoControllerLayout.getHeight());
                    animator.setDuration(200);
                    animator.start();
                    animator.addListener(this);
                } else if (!animation) {
                    animation = true;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(videoControllerLayout, "y",
                            curY, curY - videoControllerLayout.getHeight());
                    animator.setDuration(200);
                    animator.start();
                    animator.addListener(this);
                }
                break;
            case R.id.screen_status_btn:

                pause();
                Intent intent = new Intent(context, VideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("videoUrl",url);
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        this.animation = false;
        this.videoControllerShow = !this.videoControllerShow;
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    /**
     * Convert ms to hh:mm:ss
     *
     * @param millis
     * @return
     */
    private String ms2hms(int millis) {
        String result = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
        return result;
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener{
        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(getContext(),"播放完成",Toast.LENGTH_SHORT).show();
        }
    }

    private OnFullScreenListener onFullScreenListener;

    public void setOnFullScreenListener(OnFullScreenListener listener) {
        this.onFullScreenListener = listener;
    }

    public void seekTo(int currentPos) {
        mVideoView.seekTo(currentPos);
    }

    public interface OnFullScreenListener {
        void onFullScreen(int currentPosition);
    }
}
