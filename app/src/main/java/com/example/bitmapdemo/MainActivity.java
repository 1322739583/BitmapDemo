package com.example.bitmapdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.example.utils.ScreenUtil;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double dpi = ScreenUtil.getScreenDPI();

        Log.d("MainActivity", "dpi:" + dpi);
        // sample1();
        //   sample2();

        testDisplayMetrics();
       // getWindowManager().getDefaultDisplay().getRealMetrics();


        //sample3
        BitmapFactory.Options options = new BitmapFactory.Options();
        // Log.d("MainActivity", "options:" + options);
        // options.inScaled=true;
        // options.inDensity=
        //Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.img1, options);
        InputStream inputStream = getResources().openRawResource(R.raw.img2);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        //  Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
        //   Log.d("MainActivity", "bitmap.getWidth():" + bitmap.getWidth());
        // Log.d("MainActivity", "bitmap.getHeight():" + bitmap.getHeight());

    }

    /**
     * 测试DisplayMetrics类
     * 能够被调用的就几个变量，非常简单
     */
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void testDisplayMetrics() {
        TextView  textView = findViewById(R.id.tvDesityDPI);
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            Log.d("MainActivity", "display.getState():" + display.getState());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("MainActivity", "display.getMode():" + display.getMode());
        }

        Log.d("MainActivity", "Resources.getSystem().getDisplayMetrics().densityDpi:" + Resources.getSystem().getDisplayMetrics().densityDpi);


        Log.d("MainActivity", "ScreenUtil.getScreenSize():" + ScreenUtil.getScreenSize());

        Point size=new Point();
        display.getSize(size);
        Log.d("MainActivity", "size:" + size);
        Log.d("MainActivity", display.toString());
        display.getRealMetrics(metrics);

      //  Log.d("MainActivity", "DisplayMetrics.DENSITY_DEVICE_STABLE:" + DisplayMetrics.DENSITY_DEVICE_STABLE);



        //android 720X1280模拟器结果： DisplayMetrics{density=2.0, width=720, height=1184, scaledDensity=2.0, xdpi=320.0, ydpi=320.0}
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        int densityDpi = metrics.densityDpi;
        textView.setText(densityDpi+"");


        Log.d("MainActivity", Build.DISPLAY);

        double xInchs=widthPixels/metrics.xdpi;
        double yInchs=heightPixels/metrics.ydpi;
        double screenInchs=Math.sqrt(Math.pow(xInchs,2)+Math.pow(yInchs,2));
        Log.d("MainActivity", "screenInchs:" + screenInchs);


     Log.d("MainActivity", "ScreenUtils.getAppScreenHeight():" + ScreenUtils.getAppScreenHeight());
     Log.d("MainActivity", "ScreenUtils.getScreenHeight():" + ScreenUtils.getScreenHeight());

        double screenInch = Math.sqrt(Math.pow(widthPixels, 2) + Math.pow(heightPixels, 2))/densityDpi;
       // Log.d("MainActivity", "screenInch:" + screenInch);
        //Log.d("MainActivity", metrics.toString());
       // Log.d("MainActivity", "metrics.densityDpi:" + metrics.densityDpi);
        Log.d("MainActivity", "ScreenUtil.getBarHeight(this):" + ScreenUtil.getBarHeight( ));

        Log.d("MainActivity", "ScreenUtil.getNavBarHeight(this):" + ScreenUtil.getNavBarHeight(this));
        Log.d("MainActivity", "ScreenUtil.getScreenHeight(this):" + ScreenUtil.getScreenHeight(this));
    }

    private void sample2() {
        //sample2
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.img1, options);
        if (img1 == null) {
            Log.d("MainActivity", "img1 is NULL");
        }

        Log.d("MainActivity", "options.outWidth:" + options.outWidth);
        Log.d("MainActivity", "options.outHeight:" + options.outHeight);
    }

    private void sample1() {
        //sample1
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
        Log.d("MainActivity", "bitmap.getWidth():" + bitmap.getWidth());
        Log.d("MainActivity", "bitmap.getHeight():" + bitmap.getHeight());
    }


}
