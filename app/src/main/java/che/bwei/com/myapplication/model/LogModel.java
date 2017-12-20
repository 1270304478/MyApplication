package che.bwei.com.myapplication.model;

import che.bwei.com.myapplication.bean.Bean;
import che.bwei.com.myapplication.utils.Inters;
import che.bwei.com.myapplication.utils.RetrofitUnitl;
import okhttp3.OkHttpClient;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/20 12:17
 */
public class LogModel {
    ScuMod scuMod;
    public void setScuMod(ScuMod scuMod) {
        this.scuMod = scuMod;
    }
    public void Succes(String catalogId,int pnum){
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        RetrofitUnitl.getInstance("http://api.svipmovie.com/front/",ok)
                .setCreate(Inters.class)
                .getBean(catalogId,pnum)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Bean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(Bean bean) {
                        scuMod.MScus(bean);
                    }
                });
    }
    //定义一个接口
    public interface ScuMod{
        void MScus(Bean bean);
    }
}
