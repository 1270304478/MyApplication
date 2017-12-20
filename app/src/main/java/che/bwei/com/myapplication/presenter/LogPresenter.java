package che.bwei.com.myapplication.presenter;

import java.lang.ref.WeakReference;

import che.bwei.com.myapplication.bean.Bean;
import che.bwei.com.myapplication.model.LogModel;
import che.bwei.com.myapplication.view.ILogView;

/**
 * Created by 信徒° on 2017/12/6.
 */
public class LogPresenter implements LogModel.ScuMod{
    //弱引用解绑
    WeakReference<ILogView> view;
    LogModel model;

    public LogPresenter( ILogView view) {
        attach(view);
        model = new LogModel();
        model.setScuMod(this);
    }
    @Override
    public void MScus(Bean bean) {
        view.get().onSucc(bean);
    }
    //我们在写一个方法拿到我们的请求
    public void  ShowPer(String catalogId,int pnum){
        model.Succes(catalogId,pnum);
    }
    //绑定
    public void attach(ILogView views){
        view = new WeakReference(views);
    }
    //解绑方法
    public void detach(){
        view.clear();
    }
}
