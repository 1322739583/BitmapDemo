package com.example.utils;


import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public final class ScreenUtil {


    /**
     * 获取系统DisplayMetrics
     * @return 系统DisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(){
        return  Resources.getSystem().getDisplayMetrics();
    }

    /**
     * 获取手机屏幕分辨率
     * @return 返回dpi
     */
    public static double getScreenDPI() {
        DisplayMetrics metrics = getDisplayMetrics( );
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        double xInchs=widthPixels/metrics.xdpi;
        double yInchs=heightPixels/metrics.ydpi;
        double screenInch=Math.sqrt(Math.pow(xInchs,2)+Math.pow(yInchs,2));
        return  Math.sqrt(Math.pow(metrics.widthPixels,2)+Math.pow(metrics.heightPixels,2))/screenInch;
    }


    /**
     * 获取屏幕对角线尺寸
     * @return 对角线尺寸
     */
    public static double getScreenSize( ){
        DisplayMetrics metrics = getDisplayMetrics( );
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        double xInchs=widthPixels/metrics.xdpi;
        double yInchs=heightPixels/metrics.ydpi;
        return Math.sqrt(Math.pow(xInchs,2)+Math.pow(yInchs,2));
    }

    /**
     * 获取屏幕完整高度，包括statusBar和navBar的高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Service.WINDOW_SERVICE);
        Point point=new Point();
        if (wm==null){
            return -1;
        }
        wm.getDefaultDisplay().getSize(point);
        int navBarHeight = getNavBarHeight(context);
        //point.y已经包含statusBar的高度
        return point.y+navBarHeight;
    }

    /**
     *  获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Service.WINDOW_SERVICE);
        Point point=new Point();
        if (wm==null){
            return -1;
        }
        wm.getDefaultDisplay().getSize(point);
        //point.y已经包含statusBar的高度
        return point.x;
    }

    /**
     * 获取状态栏高度
     * @param
     * @return 状态栏高度
     */
    public static int getBarHeight(){
        Context context=ContextUtil.getApplication();

        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight =context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 获取底部导航高度
     * @param context
     * @return
     */
    public static int getNavBarHeight(Context context){
        int height=-1;
        int resourceId=context.getResources().getIdentifier("navigation_bar_height","dimen","android");
        if (resourceId>0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }


}
