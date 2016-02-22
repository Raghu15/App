package com.example.punit.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by punit on 16/12/2015.
 */
public class Photoeditor extends AppCompatActivity {

    private ImageView ivResult;

    public void imageEffects(View view){
        switch (view.getId()){
            case R.id.btnGrayScale:
                ivResult.buildDrawingCache();
                Bitmap bitmapOriginal = ivResult.getDrawingCache();
                Bitmap bitmapGrayScale = toGrayScale(bitmapOriginal);
                ivResult.setImageBitmap(bitmapGrayScale);
                break;

            case R.id.btnSophia:
                break;
        }
    }


    public Bitmap toGrayScale(Bitmap bmpOriginal){

        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoeditor);
        ivResult = (ImageView) findViewById(R.id.ivResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent incomingIntent = getIntent();
        Uri imageUri = (Uri) incomingIntent.getExtras().get(Intent.EXTRA_STREAM);

        ivResult.setImageURI(imageUri);
    }
}
