
package che.bwei.com.myapplication.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import che.bwei.com.myapplication.R;
import che.bwei.com.myapplication.bean.Bean;

/**
 * Created by 信徒° on 2017/12/6.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private Bean bean;

    public MyAdapter(Context context,Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //拿到我们自己定义的布局
        MyHolder holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.rv_litem, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        //加载文字
        holder.tv.setText(bean.getRet().getList().get(position).getTitle());
        holder.iv.setImageURI(bean.getRet().getList().get(position).getPic());

    }

    @Override
    public int getItemCount() {

        return bean.getRet().getList().size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView iv;
        TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}