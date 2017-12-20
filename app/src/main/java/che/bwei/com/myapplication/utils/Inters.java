package che.bwei.com.myapplication.utils;


import che.bwei.com.myapplication.bean.Bean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/20 19:29
 */
public interface Inters {
    @GET("columns/getVideoList.do")
    Observable<Bean> getBean(@Query("catalogId") String catalogId, @Query("pnum") int pnum);
}
