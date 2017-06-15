package demo.rv.cn.eeepay.com.recyclerviewdemo.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :xqf
 * @date :2017/3/24  上午11:55
 * @desc :交易相关代号;
 * @update :
 */
public class TransTypeCode {

    //交易类型
    public static final String ALL_PAYMETHOD = "0";//所有；查询用
    public static final String WECHAT_PAYMETHOD = "3";//微信支付
    public static final String ALIPAY_PAYMETHOD = "2";//支付宝支付
    public static final String SWIPER_PAYMETHOD = "1";//刷卡支付
    public static final String QUICK_PAYMETHOD = "1";//快捷支付

    //到账方式
    public static final String T0_SETTLETYPE = "1";//t0到账
    public static final String WITHDRAW_SETTLETYPE = "2";//手工提现
    public static final String T1_SETTLETYPE = "3";//t1到账
    public static final String T1_1_SETTLETYPE = "4";//t1到账,3,4都是t1到账

    //交易时间
    public static final String ONEWEEK_QUERY = "1";//一星期
    public static final String ONEMONTH_QUERY = "2";//一个月
    public static final String THREEMONTH_QUERY = "3";//三个月
    public static final String HALFYEAR_QUERY = "4";//半年


    @StringDef({WECHAT_PAYMETHOD, ALIPAY_PAYMETHOD, SWIPER_PAYMETHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PayMethodString {

    }
    @StringDef({T0_SETTLETYPE, WITHDRAW_SETTLETYPE, T1_SETTLETYPE,T1_1_SETTLETYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SettleTypeString {

    }
    /**
     * 过滤，指定需要的类型
     * @param paymethod
     * @return
     */
    public static String getPayMethod(@PayMethodString String paymethod) {
        return paymethod;
    }
    /**
     * 过滤，指定需要的类型
     * @param settletype
     * @return
     */
    public static String getSettleType(@SettleTypeString String settletype) {
        return settletype;
    }
}
