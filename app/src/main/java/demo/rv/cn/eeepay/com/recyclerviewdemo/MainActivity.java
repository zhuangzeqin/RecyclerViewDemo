package demo.rv.cn.eeepay.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.CommRecyclerBaseAdater;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.TestRecyclerAdapter2;
import demo.rv.cn.eeepay.com.recyclerviewdemo.divider.DividerGridItemDecoration;
import demo.rv.cn.eeepay.com.recyclerviewdemo.divider.DividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        initLinearLayoutManager();
        initGridLayoutManger();
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
        //设置分割线
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        List<String> mTitles = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            int index = i + 1;
            mTitles.add("item" + index);
        }
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this,mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:"+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:"+item, Toast.LENGTH_SHORT).show();
            }
        });
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
        //添加默认的动画效果
        rvList.setItemAnimator(new DefaultItemAnimator());
        //设置分割线
        rvList.addItemDecoration(new DividerGridItemDecoration(this));
//        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        List<String> mTitles = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            int index = i + 1;
            mTitles.add("item" + index);
        }
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this,mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:"+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:"+item, Toast.LENGTH_SHORT).show();
            }
        });
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
        //添加默认的动画效果
        rvList.setItemAnimator(new DefaultItemAnimator());
//        TestRecyclerAdapter adapter= new TestRecyclerAdapter(this);
        List<String> mTitles = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            int index = i + 1;
            mTitles.add("item" + index);
        }
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this,mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:"+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:"+item, Toast.LENGTH_SHORT).show();
            }
        });
        rvList.setAdapter(adapter);
    }
}
