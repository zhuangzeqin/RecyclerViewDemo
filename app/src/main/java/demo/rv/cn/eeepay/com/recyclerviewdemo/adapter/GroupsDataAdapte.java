package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;

import java.util.List;

import demo.rv.cn.eeepay.com.recyclerviewdemo.R;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean.ChildEntity;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean.GroupEntity;
import demo.rv.cn.eeepay.com.recyclerviewdemo.utils.MathUtil;
import demo.rv.cn.eeepay.com.recyclerviewdemo.utils.TransTypeCode;

/**
 * 描述：分组显示一组数据
 * https://github.com/donkingliang/GroupedRecyclerViewAdapter
 * GroupedRecyclerViewAdapter 第三方引用的一个封装库，直接继承GroupedRecyclerViewAdapter即可
 * 可以很方便的实现RecyclerView的分组显示，并且每个组都可以包含组头、组尾和子项；
 * 可以方便实现多种Type类型的列表，可以实现如QQ联系人的列表一样的列表展开收起功能等
 * 作者：zhuangzeqin
 * 时间: 2017/6/14-15:54
 * 邮箱：zzq@eeepay.cn
 */
public class GroupsDataAdapte extends GroupedRecyclerViewAdapter {
    List<GroupEntity> mDatas;
    public GroupsDataAdapte(Context context, List<GroupEntity> mDatas) {
        super(context);
        this.mDatas= mDatas;
    }

    /**
     * 添加一个集合的数据
     *
     * @param subDatas
     */
    public void addItemFromList(List<GroupEntity> subDatas) {
        if (subDatas != null) {
            mDatas.addAll(subDatas);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getGroupCount() {
        return  mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getChildrenCount(int i) {
        List<ChildEntity> children = mDatas.get(i).getChildEntityList();
        return children == null ? 0 : children.size();
    }

    @Override
    public boolean hasHeader(int i) {
        return true;
    }

    @Override
    public boolean hasFooter(int i) {
        return false;
    }

    @Override
    public int getHeaderLayout(int i) {
        return R.layout.item_record_title;
    }

    @Override
    public int getFooterLayout(int i) {
        return 0;
    }

    @Override
    public int getChildLayout(int i) {
        return R.layout.item_record;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder baseViewHolder, int i) {
        GroupEntity resultBean = mDatas.get(i);
        baseViewHolder.setText(R.id.tv_date,resultBean.getHead().getDate());
        baseViewHolder.setText(R.id.tv_t0,"共"+resultBean.getHead().getCount() + "笔  ￥"
                + MathUtil.twoNumber(resultBean.getHead().getTotalMoney()));
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder baseViewHolder, int i, int i1) {
        ChildEntity childEntity = mDatas.get(i).getChildEntityList().get(i1);
        if (TransTypeCode.SWIPER_PAYMETHOD.equals(childEntity.getPay_method()))
        {

            baseViewHolder.setImageResource(R.id.iv_head,R.drawable.shuaka_big_img);
        }else if (TransTypeCode.WECHAT_PAYMETHOD.equals(childEntity.getPay_method()))
        {
            baseViewHolder.setImageResource(R.id.iv_head,R.drawable.weixin_big_img);
        }else if (TransTypeCode.QUICK_PAYMETHOD.equals(childEntity.getPay_method()))
        {
            baseViewHolder.setImageResource(R.id.iv_head,R.drawable.quick_img);
        }else if (TransTypeCode.ALIPAY_PAYMETHOD.equals(childEntity.getPay_method()))
        {
            baseViewHolder.setImageResource(R.id.iv_head,R.drawable.alipay_120x120_icon);
        }
        baseViewHolder.setText(R.id.tv_item_record_time,childEntity.getTrans_time());
        baseViewHolder.setText(R.id.tv_item_record_name,childEntity.getName());
        baseViewHolder.setText(R.id.tv_affirm_code,childEntity.getNonce_str());
        baseViewHolder.setText(R.id.tv_item_record_amount,"￥" + MathUtil.twoNumber(childEntity.getTrans_amount()));
    }
}
