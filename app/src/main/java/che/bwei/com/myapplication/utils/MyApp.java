package che.bwei.com.myapplication.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/20 19:32
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
