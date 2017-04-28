package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.rv.cn.eeepay.com.recyclerviewdemo.R;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-16:08
 * 邮箱：zzq@eeepay.cn
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private LayoutInflater mInflater;
    private String[] mTitles = null;

    private Context mContext;

    public TestRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mTitles = new String[20];
        for (int i = 0; i < 20; i++) {
            int index = i + 1;
            mTitles[i] = "item" + index;
        }
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_layout, parent, false);
        //view.setBackgroundColor(Color.RED);
        CommonViewHolder viewHolder = new CommonViewHolder(mContext,view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
//        holder.item_tv.setText(mTitles[position]);
        holder.setText(R.id.item_tv,mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles.length;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item_tv;
        public ViewHolder(View view) {
            super(view);
            item_tv = (TextView) view.findViewById(R.id.item_tv);
        }
    }
}
