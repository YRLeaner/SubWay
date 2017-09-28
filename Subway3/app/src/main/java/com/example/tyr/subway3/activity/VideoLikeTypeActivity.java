package com.example.tyr.subway3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.tyr.subway3.R;

/**
 * Created by tyr on 2017/5/31.
 */
public class VideoLikeTypeActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private StringBuilder sb;

    private ImageView like_back;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Button change_btn;
    int[] like = new int[6];
    String[] string = {"音乐MV", "卡通动漫", "游戏天地", "幽默搞笑", "鬼畜", "微电影"};
    private Toolbar like_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videotype_main);
        sharedPreferences = getSharedPreferences("videolike", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sb = new StringBuilder();

        initCheckBox();
        initDate();
        for (int i=0;i<6;i++){
            if (like[i]==1){
                changecheck(i);
            }
        }

        change_btn = (Button)findViewById(R.id.chgbtn2);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("videoliketype",sb.toString());
                editor.commit();
                finish();
            }
        });

    }

    private void changecheck(int n){
        switch (n){
            case 0:
                checkBox1.setChecked(true);
                break;
            case 1:
                checkBox2.setChecked(true);
                break;
            case 2:
                checkBox3.setChecked(true);
                break;
            case 3:
                checkBox4.setChecked(true);
                break;
            case 4:
                checkBox5.setChecked(true);
                break;
            case 5:
                checkBox6.setChecked(true);
                break;
        }
        sb.append(string[n]);
    }

    private void initDate() {
        like[0] = sharedPreferences.getInt("音乐MV", 0);
        like[1] = sharedPreferences.getInt("卡通动漫", 0);
        like[2] = sharedPreferences.getInt("游戏天地",0);
        like[3] = sharedPreferences.getInt("幽默搞笑",0);
        like[4] = sharedPreferences.getInt("鬼畜",0);
        like[5] = sharedPreferences.getInt("微电影",0);

    }

    private void initCheckBox() {
        checkBox1 = (CheckBox)findViewById(R.id.checkbox11);
        checkBox2 = (CheckBox)findViewById(R.id.checkbox21);
        checkBox3 = (CheckBox)findViewById(R.id.checkbox31);
        checkBox4 = (CheckBox)findViewById(R.id.checkbox41);
        checkBox5 = (CheckBox)findViewById(R.id.checkbox51);
        checkBox6 = (CheckBox)findViewById(R.id.checkbox61);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox1.isPressed()) {
                    editor.putInt("音乐MV", 1);
                } else if (!isChecked){
                    editor.putInt("音乐MV", 0);
                }
                editor.commit();
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox2.isPressed()){
                    editor.putInt("卡通动漫",1);
                }else if (!isChecked){
                    editor.putInt("卡通动漫",0);
                }
                editor.commit();
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox3.isPressed()){
                    editor.putInt("游戏天地",1);
                }else if (!isChecked){
                    editor.putInt("游戏天地",0);
                }
                editor.commit();
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox4.isPressed()) {
                    editor.putInt("幽默搞笑", 1);
                } else if (!isChecked){
                    editor.putInt("幽默搞笑", 0);
                }
                editor.commit();
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox5.isPressed()) {
                    editor.putInt("鬼畜", 1);
                } else if (!isChecked){
                    editor.putInt("鬼畜", 0);
                }
                editor.commit();
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox6.isPressed()) {
                    editor.putInt("微电影", 1);
                } else if (!isChecked&&checkBox6.isPressed()){
                    editor.putInt("微电影", 0);
                }
                editor.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        editor.putString("videoliketype",sb.toString());
        editor.commit();
        super.onBackPressed();
    }
}
