package com.example.tyr.subway3.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;

import com.squareup.picasso.Transformation;

/**
 * Created by tyr on 2017/8/30.
 */
public class BlurTransformation implements Transformation{

    RenderScript rs;

    public BlurTransformation(Context context) {
        super();
        rs = RenderScript.create(context);
    }

    @SuppressLint("NewApi")
    @Override
    public Bitmap transform(Bitmap bitmap) {
        Bitmap blurredBitmap = bitmap.copy(Bitmap.Config.ARGB_8888,true);
        Allocation input = Allocation.createFromBitmap(rs, blurredBitmap
                , Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SHARED);
        Allocation output = Allocation.createTyped(rs, input.getType());
        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs,
                Element.U8_4(rs));
        script.setInput(input);

        script.setRadius(10);
        script.forEach(output);
        output.copyTo(blurredBitmap);
        bitmap.recycle();

        return blurredBitmap;
    }

    @Override
    public String key() {
        return "blur";
    }

}
