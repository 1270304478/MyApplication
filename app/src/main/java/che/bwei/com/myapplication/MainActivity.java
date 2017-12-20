package che.bwei.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import che.bwei.com.myapplication.adapter.MyAdapter;
import che.bwei.com.myapplication.bean.Bean;
import che.bwei.com.myapplication.presenter.LogPresenter;
import che.bwei.com.myapplication.utils.Images;
import che.bwei.com.myapplication.view.ILogView;

public class MainActivity extends Activity implements ILogView {
    @BindView(R.id.bnr)
    Banner bnr;
    @BindView(R.id.rv)
    RecyclerView rv;
    private LogPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //调用P层
        presenter = new LogPresenter(this);
        presenter.ShowPer("402834815584e463015584e539330016",getNextPage());
    }

    @Override
    public void onSucc(Bean bean) {
//轮播
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bean.getRet().getList().size(); i++) {
            list.add(bean.getRet().getList().get(i).getPic());
        }
        bnr.setImageLoader(new Images());
        bnr.setImages(list);
        bnr.start();
        //线性布局
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manager);
        //拿到适配器
        MyAdapter adapter = new MyAdapter(MainActivity.this,bean);
        rv.setAdapter(adapter);
    }
    private int getNextPage() {
        int page = getRandomNumber(1, 108);
        return page;
    }
    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }
    //调用P层的解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
