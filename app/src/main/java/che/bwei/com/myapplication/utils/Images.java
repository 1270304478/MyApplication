package che.bwei.com.myapplication.utils;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/20 19:24
 */
public class Images extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
