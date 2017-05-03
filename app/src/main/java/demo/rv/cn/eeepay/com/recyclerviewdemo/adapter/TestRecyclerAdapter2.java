package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import demo.rv.cn.eeepay.com.recyclerviewdemo.R;

/**
 * 描述：显示1种布局
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-16:08
 * 邮箱：zzq@eeepay.cn
 */
public class TestRecyclerAdapter2 extends CommRecyclerBaseAdater<String> {

    /**
     * 默认显示一种布局
     *
     * @param mContext
     * @param mDatas
     **/
    public TestRecyclerAdapter2(@NonNull Context mContext, List<String> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public int getItemLayoutId(int ViewType) {
        return R.layout.item_image;
    }

    @Override
    public void onBindView(CommonViewHolder holder, String item, int position, int viewType) {
        holder.setTextAndColor(R.id.text01,item, R.color.colorAccent);
        holder.setImage(R.id.image01,"https://img.gcall.com/dca5/M00/10/8E/wKhoNlggetaENWylAAAAAAAAAAA457.jpg");
    }

}
