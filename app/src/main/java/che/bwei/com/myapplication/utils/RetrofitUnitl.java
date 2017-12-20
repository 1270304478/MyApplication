package che.bwei.com.myapplication.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/20 12:15
 */
public class RetrofitUnitl {
    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;
    private static RetrofitUnitl mRetrofitManager;
    private RetrofitUnitl(String baseUrl,OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;
        initRetrofit();
    }
    public static synchronized RetrofitUnitl getInstance(String baseUrl,OkHttpClient client){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitUnitl(baseUrl,client);
        }
        return mRetrofitManager;
    }
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}
