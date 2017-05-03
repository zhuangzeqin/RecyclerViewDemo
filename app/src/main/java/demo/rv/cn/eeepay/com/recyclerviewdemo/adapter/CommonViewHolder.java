package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 描述：抽象通用的一个ViewHolder
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-16:43
 * 邮箱：zzq@eeepay.cn
 */
public final class CommonViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mViews;// 用来保存所有的控件

    private final View itemView;//当前itemView

    private final Context mContext;//上下文对象

    private final int viewType;//显示类型

    public CommonViewHolder(@NonNull Context context, @LayoutRes View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.mContext = context;
        viewType = 0;
        mViews = new SparseArray<>();
    }

    public CommonViewHolder(@NonNull Context context, @LayoutRes View itemView, int viewType) {
        super(itemView);
        this.itemView = itemView;
        this.mContext = context;
        this.viewType = viewType;
        mViews = new SparseArray<>();
    }

    /**
     * 一些比较特殊页面的处理的；
     * 提供返回itemView 方法；外围自己操作
     *
     * @return
     */
    public View getItemView() {
        return itemView;
    }

    /**
     * 显示类型
     *
     * @return
     */
    public int getViewType() {
        return viewType;
    }

    /**
     * 通过控件的Id获取对应的控件，如果没有则加入views集合
     *
     * @param viewId
     * @param <T>
     * @return
     */
    private <T extends View> T getView(@IdRes int viewId) {
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
    public CommonViewHolder setTextAndColor(@IdRes int viewId, @Nullable CharSequence text, @ColorRes int colorID) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(colorID));
        view.setText(text);
        return this;
    }

    /**
     * TextView设置字符串
     *
     * @param viewId
     * @param resid  字符串id
     * @return
     */

    public CommonViewHolder setText(@IdRes int viewId, @StringRes int resid) {
        TextView view = getView(viewId);
        view.setText(resid);
        return this;
    }

    /**
     * 设置本地资源图片
     *
     * @param viewId
     * @param resid
     * @return
     */

    public CommonViewHolder setImage(@IdRes int viewId, @DrawableRes int resid) {
        ImageView imageView = getView(viewId);
        Glide.with(mContext).load(resid).crossFade().into(imageView);
        return this;
    }

    /**
     * 加载本地文件图片
     * 例如 File file = new File(Environment.getExternalStorageDirectory(), "test.png");
     *
     * @param file
     * @return
     */
    public CommonViewHolder setImage(@IdRes int viewId, File file) {
        ImageView imageView = getView(viewId);
        //加载图片
        Glide.with(mContext).load(file).into(imageView);
        return this;
    }

    /**
     * 加载网络图片
     * 例如:https://img.gcall.com/dca5/M00/10/8E/wKhoNlggetaENWylAAAAAAAAAAA457.jpg
     *
     * @param viewId
     * @param url
     * @return
     */
    public CommonViewHolder setImage(@IdRes int viewId, @NonNull String url) {
        ImageView imageView = getView(viewId);
        //加载图片
        Glide.with(mContext).load(url).override(50,50).bitmapTransform(new CropCircleTransformation(mContext)).placeholder(android.R.drawable.stat_sys_download).error(android.R.drawable.ic_delete).crossFade().into(imageView);
        // 设置占位图(placeholder) .placeholder(R.mipmap.place)
        // 设置错误图片(error) error(R.mipmap.icon_photo_error).
        // 设置动画(crossFade) crossFade(5000)
        // 取消动画(dontAnimate)
        // 用原图的1/10作为缩略图 thumbnail(0.1f)
        // 指定资源的优先加载顺序 priority(Priority.HIGH)
        // 禁止内存缓存：skipMemoryCache(true)
        // 清除内存缓存：Glide.get(context).clearMemory(); ******必须在UI线程中调用
        // 禁止磁盘缓存: diskCacheStrategy(DiskCacheStrategy.NONE)
        // 清除磁盘缓存：Glide.get(applicationContext).clearDiskCache();******* 必须在后台线程中调用，建议同时clearMemory()
        /**
         * //用其它图片作为缩略图
         DrawableRequestBuilder<Integer> thumbnailRequest = Glide
         .with(this)
         .load(R.drawable.news);
         Glide.with(this)
         .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
         .thumbnail(thumbnailRequest)
         .into(iv_0);
         */
        /**
         *  //圆形裁剪
         Glide.with(this)
         .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
         .bitmapTransform(new CropCircleTransformation(this))
         .into(iv_0);
         //圆角处理
         Glide.with(this)
         .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
         .bitmapTransform(new RoundedCornersTransformation(this,30,0, RoundedCornersTransformation.CornerType.ALL))
         .into(iv_0);
         //灰度处理
         Glide.with(this)
         .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
         .bitmapTransform(new GrayscaleTransformation(this))
         .into(iv_0);
         */
        /**
         * load SD卡资源：load("file://"+ Environment.getExternalStorageDirectory().getPath()+"/test.jpg")
         load assets资源：load("file:///android_asset/f003.gif")
         load raw资源：load("Android.resource://com.frank.glide/raw/raw_1")或load("android.resource://com.frank.glide/raw/"+R.raw.raw_1)
         load drawable资源：load("android.resource://com.frank.glide/drawable/news")或load("android.resource://com.frank.glide/drawable/"+R.drawable.news)
         load ContentProvider资源：load("content://media/external/images/media/139469")
         load http资源：load("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg")
         load https资源：load("https://img.alicdn.com/tps/TB1uyhoMpXXXXcLXVXXXXXXXXXX-476-538.jpg_240x5000q50.jpg_.webp")
         当然，load不限于String类型，还可以：
         load(Uri uri)，load(File file)，load(Integer resourceId)，load(URL url)，load(byte[] model)，load(T model)，loadFromMediaStore(Uri uri)。
         */
        return this;
    }

    /**
     * load 一个 byte 数组
     * @param viewId
     * @param date
     * @return
     */
    public CommonViewHolder setImage(@IdRes int viewId,@NonNull byte[] date)
    {
        ImageView imageView = getView(viewId);
        Glide.with(mContext).load(date).into(imageView);
        return this;
    }


}
