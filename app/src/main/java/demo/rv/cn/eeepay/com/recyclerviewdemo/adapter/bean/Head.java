package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean;

/**
 * 描述：头部信息
 * 作者：zhuangzeqin
 * 时间: 2017/6/15-9:21
 * 邮箱：zzq@eeepay.cn
 */
public class Head {
    private int count;//共几笔 2
    private String date;//日期  2017-05-11
    private double totalMoney;//统计金额 0.02
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Head(int count, String date, double totalMoney) {
        this.count = count;
        this.date = date;
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Head{" +
                "count=" + count +
                ", date='" + date + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
