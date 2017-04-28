package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 描述：抽象的 RecyclerBaseAdater 适配器
 * 1 增加监听事件
 * 2 抽象出来onBindView 由子类自己去实现
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-17:18
 * 邮箱：zzq@eeepay.cn
 */
public abstract class CommRecyclerBaseAdater<T> extends RecyclerView.Adapter<CommonViewHolder> {
    /**
     * 数据集合
     */
    private List<T> mDatas;
    /**
     * 上下文对象
     */
    private Context mContext;

    private LayoutInflater mInflater;

    /**
     * item 布局id
     **/
    private int layoutId;
    /*** 监听事件设置 **/
    private OnItemClickLitener<T> mOnItemClickLitener;

    protected CommRecyclerBaseAdater(@NonNull Context mContext, @IdRes int layoutId, List<T> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 设置监听事件
     **/
    public void setOnItemClickLitener(OnItemClickLitener<T> mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(layoutId, parent, false);
        CommonViewHolder viewHolder = new CommonViewHolder(mContext, itemView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 根据索引获得实体bean
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return mDatas.get(position);
    }

    /**
     * 将添加的数据放在列表的前面
     *
     * @param item
     */
    public void addFirstItem(T item) {
        mDatas.add(0, item);
        notifyItemInserted(0);
    }

    /**
     * 添加数据
     *
     * @param item
     */
    public void addItem(T item) {
        mDatas.add(item);
        notifyItemInserted(mDatas.size());
    }

    /**
     * 添加一个集合的数据
     *
     * @param subDatas
     */
    public void addItemFromList(List<T> subDatas) {
        if (subDatas != null) {
            mDatas.addAll(subDatas);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加一个集合的数据在列表的前面
     *
     * @param subDatas
     */
    public void addFirstItemFromList(List<T> subDatas) {
        if (subDatas != null) {
            mDatas.addAll(0, subDatas);
            notifyDataSetChanged();
        }
    }

    /**
     * 根据索引；删除集合里的元素
     * @param position
     */
    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 清除所有数据
     */
    public void clearAll() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        //绑定view
        onBindView(holder, getItem(position), position);
        //设置监听接口回调
        setmOnItemClickLitener(holder, getItem(position));
    }

    /**
     * 绑定view视图回调出去给外面实现
     **/
    public abstract void onBindView(CommonViewHolder holder, T item, int position);

    /**
     * 实现监听接口回调
     **/
    private void setmOnItemClickLitener(final CommonViewHolder holder, final T item) {
        if (mOnItemClickLitener != null) {
            //点击事件
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//position
                    mOnItemClickLitener.onItemClick(holder.getItemView(), item, pos);
                }
            });
            //长按事件
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();//position
                    mOnItemClickLitener.onItemLongClick(holder.getItemView(), item, pos);
                    return true;

                }
            });
        }
    }


    /**
     * 监听事件
     */
    public interface OnItemClickLitener<T> {
        /**
         * 点击事件
         **/
        void onItemClick(View view, T item, int position);

        /**
         * 长按事件
         **/
        void onItemLongClick(View view, T item, int position);
    }
}
