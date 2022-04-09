package com.example.utils;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;


/**
 * 通过反射获取Context
 */
public class ContextUtil {

    private static Application app;

    public static Application getApplication() {
        if (app==null) {
            try {
                Class activityThread = Class.forName("android.app.ActivityThread");
               app= (Application) activityThread.getMethod("currentApplication").invoke(null, (Object[]) null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return app;
    }

}
