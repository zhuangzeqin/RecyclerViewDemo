package demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean;

import java.util.List;

/**
 * 描述：组数据的实体
 * 作者：zhuangzeqin
 * 时间: 2017/6/15-9:20
 * 邮箱：zzq@eeepay.cn
 */
public class GroupEntity {
    private Head head;//头部信息
    private List<ChildEntity> childEntityList;//子项的数据集合

    public GroupEntity(Head head, List<ChildEntity> childEntityList) {
        this.head = head;
        this.childEntityList = childEntityList;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<ChildEntity> getChildEntityList() {
        return childEntityList;
    }

    public void setChildEntityList(List<ChildEntity> childEntityList) {
        this.childEntityList = childEntityList;
    }

}
