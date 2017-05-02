package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 描述：item 显示的布局类型；采用安卓系统提供的注解IntDef和StringDef
 * 作者：zhuangzeqin
 * 时间: 2017/5/2-15:19
 * 邮箱：zzq@eeepay.cn
 */
public class ItemTypeDef {
    /** 定义常量 int  注解**/
    public static final int ITEM_TYPE_TEXT = 0;//纯文本
    public static final int ITEM_TYPE_IMAGEANDTEXT = 1;//文本和图片
    public static final int ITEM_TYPE_IMAGEANDTEXT2 = 2;//文本和图片2
    @IntDef({ITEM_TYPE_TEXT,ITEM_TYPE_IMAGEANDTEXT,ITEM_TYPE_IMAGEANDTEXT2})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IitemType {}

    //string  注解
    public static final String AA = "AA";
    public static final String BB = "BB";
    public static final String CC= "CC" ;
    @StringDef({AA,BB,CC})
    public @interface testState{}


}
