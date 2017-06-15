package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean;

/**
 * 描述：子项数据的实体类
 * 作者：zhuangzeqin
 * 时间: 2017/6/15-9:25
 * 邮箱：zzq@eeepay.cn
 */
public class ChildEntity {
    private String order_no;
    private String mobile_no;
    private String pay_method;
    private Object auth_code;
    private String gather_code;
    private double trans_amount;
    private String nonce_str;
    private Object cashier;
    private String name;
    private String trans_time;
    private String trans_status;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public Object getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(Object auth_code) {
        this.auth_code = auth_code;
    }

    public String getGather_code() {
        return gather_code;
    }

    public void setGather_code(String gather_code) {
        this.gather_code = gather_code;
    }

    public double getTrans_amount() {
        return trans_amount;
    }

    public void setTrans_amount(double trans_amount) {
        this.trans_amount = trans_amount;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public Object getCashier() {
        return cashier;
    }

    public void setCashier(Object cashier) {
        this.cashier = cashier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
    }

    public String getTrans_status() {
        return trans_status;
    }

    public void setTrans_status(String trans_status) {
        this.trans_status = trans_status;
    }

    public ChildEntity(String order_no, String mobile_no, String pay_method, Object auth_code, String gather_code, double trans_amount, String nonce_str, Object cashier, String name, String trans_time, String trans_status) {
        this.order_no = order_no;
        this.mobile_no = mobile_no;
        this.pay_method = pay_method;
        this.auth_code = auth_code;
        this.gather_code = gather_code;
        this.trans_amount = trans_amount;
        this.nonce_str = nonce_str;
        this.cashier = cashier;
        this.name = name;
        this.trans_time = trans_time;
        this.trans_status = trans_status;
    }

    @Override
    public String toString() {
        return "ChildEntity{" +
                "order_no='" + order_no + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", pay_method='" + pay_method + '\'' +
                ", auth_code=" + auth_code +
                ", gather_code='" + gather_code + '\'' +
                ", trans_amount=" + trans_amount +
                ", nonce_str='" + nonce_str + '\'' +
                ", cashier=" + cashier +
                ", name='" + name + '\'' +
                ", trans_time='" + trans_time + '\'' +
                ", trans_status='" + trans_status + '\'' +
                '}';
    }
}
