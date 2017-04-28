package demo.rv.cn.eeepay.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.TestRecyclerAdapter;
import demo.rv.cn.eeepay.com.recyclerviewdemo.divider.DividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initLinearLayoutManager();
//        initGridLayoutManger();
//        initStaggeredGridLayoutManager();
    }

    /**
     *RecyclerView提供了三种内置的LayoutManager:
     */
    private void initLinearLayoutManager()
    {
        //设置固定大小
        rvList.setHasFixedSize(true);
        //创建线性布局
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
        rvList.setLayoutManager(mLayoutManager);
        //添加默认的动画效果
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        rvList.setAdapter(adapter);
    }

    private void initGridLayoutManger()
    {
        //设置固定大小
        rvList.setHasFixedSize(true);
        //创建线性布局
        GridLayoutManager mLayoutManager = new GridLayoutManager(this,4);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
        rvList.setLayoutManager(mLayoutManager);
        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        rvList.setAdapter(adapter);
    }

    private void initStaggeredGridLayoutManager()
    {
        //设置固定大小
        rvList.setHasFixedSize(false);
        //创建线性布局
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,OrientationHelper.VERTICAL);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
        rvList.setLayoutManager(mLayoutManager);
        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        rvList.setAdapter(adapter);
    }
}
