package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * 描述：通用的一个ViewHolder
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-16:43
 * 邮箱：zzq@eeepay.cn
 */
public final class CommonViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mViews;// 用来保存所有的控件

    private final View itemView;

    private final Context mContext;

    public CommonViewHolder(Context context, View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.mContext = context;
        mViews = new SparseArray<>();
    }

    /**
     * 一些比较特殊页面的处理的；
     * 提供返回itemView 方法；外围自己操作
     * @return
     */
    public View getItemView() {
        return itemView;
    }

    /**
     * 通过控件的Id获取对应的控件，如果没有则加入views集合
     * @param viewId
     * @param <T>
     * @return
     */
    private  <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setText(@IdRes int viewId, @Nullable CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    /**
     * TextView设置字符串 并且设置颜色
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setTextAndColor(@IdRes int viewId, @Nullable CharSequence text,@ColorRes int colorID) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(colorID));
        view.setText(text);
        return this;
    }

    /**
     * TextView设置字符串
     * @param viewId
     * @param resid 字符串id
     * @return
     */

    public CommonViewHolder setText(@IdRes int viewId, @StringRes int resid)
    {
        TextView view = getView(viewId);
        view.setText(resid);
        return this;
    }
}
