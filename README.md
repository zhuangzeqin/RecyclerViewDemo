# RecyclerViewDemo
打造一个RecyclerView 的万能适配器；支持不同item 布局显示

1 继承封装好的adapter抽象类即可

2 支持不同item 布局显示 需要根据不同itemViewType类型选择不同的item 布局

3 支持分组显示数据
***********************************以下给出部分代码实例***********************

![image](https://github.com/zhuangzeqin/RecyclerViewDemo/blob/master/device-2017-06-14-172141.png)

/**
 * 描述：显示3种不同的布局
 * 作者：zhuangzeqin
 * 时间: 2017/4/28-16:08
 * 邮箱：zzq@eeepay.cn
 */
public class TestRecyclerAdapter3 extends CommRecyclerBaseAdater<String> {

    public TestRecyclerAdapter3(@NonNull Context mContext, List<String> mDatas) {
        super(mContext, mDatas);
    }

    /**
     * 根据position 决定显示哪种布局
     * @param position
     * @return
     */
    @Override
	
    public int getViewType(int position) {
	
        if (position % 3 == 0) {
            return ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT;//第一种布局类型
			
        } else if (position % 3 == 1) {
            return ItemTypeDef.ITEM_TYPE_TEXT;//第二种布局类型
			
        } else if (position % 3 == 2) {
            return ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT2;//第三种布局类型
			
        } else {
            return -1;
        }
//        return position % 2 == 0 ? ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT : ItemTypeDef.ITEM_TYPE_TEXT;
    }

    /**
     * 根据不同的view 类型加载不同的布局
     * @param ViewType
     * @return
     */
    @Override
    public int getItemLayoutId(int ViewType) {
        if (ViewType == ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT) {
            return R.layout.item_image;
        } else if (ViewType == ItemTypeDef.ITEM_TYPE_TEXT) {
            return R.layout.item_recycler_layout;
        } else if (ViewType == ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT2) {
            return R.layout.item_image2;
        } else {
            return -1;
        }
    }

    /**
     * 根据view 类型；加载不同的布局文件
     * @param holder
     * @param item
     * @param position
     * @param viewType
     */
    @Override
    public void onBindView(CommonViewHolder holder, String item, int position, int viewType) {
        if (viewType == ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT) {
            onBindViewImgText(holder, item);
        } else if (viewType == ItemTypeDef.ITEM_TYPE_TEXT) {
            onBinViewText(holder, item);
        } else if (viewType == ItemTypeDef.ITEM_TYPE_IMAGEANDTEXT2) {
            onBindViewImgText2(holder, item);
        } else {
            //do someThing
        }
    }

    /**
     * 显示纯文本布局
     */
    private void onBinViewText(CommonViewHolder holder, String item) {
        holder.setText(R.id.item_tv, item);
    }

    /**
     * 显示文本图片布局
     */
    private void onBindViewImgText(CommonViewHolder holder, String item) {
        holder.setTextAndColor(R.id.text01, item, R.color.colorAccent);
        holder.setImage(R.id.image01, R.mipmap.ic_launcher_round);
    }

    /**
     * 显示文本图片2布局
     */
    private void onBindViewImgText2(CommonViewHolder holder, String item) {
        holder.setTextAndColor(R.id.text01, item, R.color.colorAccent);
        holder.setImage(R.id.image01, R.mipmap.ic_launcher_round);
    }
}

如果对你有用；不妨请小编我喝个咖啡；嘻嘻；你的动力；是我不懈努力

![image](https://github.com/zhuangzeqin/APPChannel/blob/master/TIM20171109141728.png)

Contact GitHub API Training Shop Blog About
© 2017 GitHub, Inc. Terms Privacy Security Status Help
