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
import android.widget.Button;
import android.widget.Toast;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.CommRecyclerBaseAdater;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.GroupsDataAdapte;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.TestRecyclerAdapter2;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean.ChildEntity;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean.GroupEntity;
import demo.rv.cn.eeepay.com.recyclerviewdemo.adapter.bean.Head;
import demo.rv.cn.eeepay.com.recyclerviewdemo.divider.DividerGridItemDecoration;
import demo.rv.cn.eeepay.com.recyclerviewdemo.divider.DividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    final String jsonData = "{\"header\":{\"error\":null,\"errMsg\":null,\"succeed\":true},\"body\":{\"result\":[{\"recodeList\":[{\"order_no\":\"BK589092417690268288\",\"mobile_no\":\"17688966982\",\"pay_method\":\"3\",\"auth_code\":null,\"gather_code\":\"jhj6h61d78\",\"trans_amount\":0.01,\"nonce_str\":\"13381\",\"cashier\":null,\"name\":\"初始收银台\",\"trans_time\":\"2017-05-11 10:27:58\",\"trans_status\":\"交易成功\"},{\"order_no\":\"DK396829512362447927\",\"mobile_no\":\"17688966982\",\"pay_method\":\"3\",\"auth_code\":\"130135355515645488\",\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":null,\"trans_time\":\"2017-05-11 10:26:16\",\"trans_status\":\"交易成功\"}],\"count\":2,\"date\":\"2017-05-11\",\"totalMoney\":0.02},{\"recodeList\":[{\"order_no\":\"SK536755451141496838\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.30,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 19:57:20\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK389611137915923822\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.30,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 19:54:24\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK207442812775674524\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 15:50:50\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK177682305089404356\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 15:08:43\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK738234175939833212\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.10,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 15:00:38\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK484422349025903362\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.10,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 14:50:24\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK351087837366823064\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.10,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-28 14:43:03\",\"trans_status\":\"交易成功\"}],\"count\":7,\"date\":\"2017-04-28\",\"totalMoney\":0.92},{\"recodeList\":[{\"order_no\":\"SK141299335679264569\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.50,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-26 16:05:08\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK597269167775872559\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-26 15:03:13\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK347180652953625405\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-26 14:59:14\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK228173181453788529\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":0.01,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-26 14:46:23\",\"trans_status\":\"交易成功\"}],\"count\":4,\"date\":\"2017-04-26\",\"totalMoney\":0.53},{\"recodeList\":[{\"order_no\":\"SK113037644434869153\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":1.00,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-25 18:40:18\",\"trans_status\":\"交易成功\"},{\"order_no\":\"SK542869437194494945\",\"mobile_no\":\"17688966982\",\"pay_method\":\"1\",\"auth_code\":null,\"gather_code\":null,\"trans_amount\":59.00,\"nonce_str\":null,\"cashier\":null,\"name\":\"POS收款\",\"trans_time\":\"2017-04-25 16:50:36\",\"trans_status\":\"交易成功\"}],\"count\":2,\"date\":\"2017-04-25\",\"totalMoney\":60.00}],\"customer\":null}}";
    @BindView(R.id.btn_adddata)
    Button btnAdddata;

    private GroupsDataAdapte groupsDataAdapte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        initLinearLayoutManager();
//        initGridLayoutManger();

        initTest();
//        initStaggeredGridLayoutManager();
    }
    private void initTest() {
        Gson gson = new Gson();
        List<GroupEntity> groupEntities = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(jsonData);
            JSONObject body = object.getJSONObject("body");
            JSONArray array = body.getJSONArray("result");
            int arraySize = array.length();
            for (int i = 0; i < arraySize; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String tempDate = jsonObject.getString("date");
                String tempTotalMoney = jsonObject.getString("totalMoney");
                String tempCount = jsonObject.getString("count");
                Head head = new Head(Integer.parseInt(tempCount), tempDate, Double.parseDouble(tempTotalMoney));
                JSONArray listCount = jsonObject.getJSONArray("recodeList");
                int listCountSize = listCount.length();
                List<ChildEntity> childEntityList = new ArrayList<>();
                for (int j = 0; j < listCountSize; j++) {
                    String item = listCount.getJSONObject(j).toString();
                    ChildEntity childEntity = gson.fromJson(item, ChildEntity.class);
                    childEntityList.add(childEntity);
                }
                groupEntities.add(new GroupEntity(head, childEntityList));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
//        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        groupsDataAdapte = new GroupsDataAdapte(this, groupEntities);
        //StickyHeaderDecoration decor = new StickyHeaderDecoration(stickyTestAdapter);
//        rvList.addItemDecoration(decor);
        rvList.setAdapter(groupsDataAdapte);

        /** 头部的点击事件**/
        groupsDataAdapte.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter groupedRecyclerViewAdapter, BaseViewHolder baseViewHolder, int groupPosition) {
                Toast.makeText(MainActivity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();

            }
        });
        /** 子项的点击事件 **/
        groupsDataAdapte.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter groupedRecyclerViewAdapter, BaseViewHolder baseViewHolder, int groupPosition, int childPosition) {
                Toast.makeText(MainActivity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });



    }

    /**
     * 模拟添加数据
     * @return
     */
    private List<GroupEntity> addData() {
        Gson gson = new Gson();
        List<GroupEntity> groupEntities = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(jsonData);
            JSONObject body = object.getJSONObject("body");
            JSONArray array = body.getJSONArray("result");
            int arraySize = array.length();
            for (int i = 0; i < arraySize; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String tempDate = jsonObject.getString("date");
                String tempTotalMoney = jsonObject.getString("totalMoney");
                String tempCount = jsonObject.getString("count");
                Head head = new Head(Integer.parseInt(tempCount), tempDate, Double.parseDouble(tempTotalMoney));
                JSONArray listCount = jsonObject.getJSONArray("recodeList");
                int listCountSize = listCount.length();
                List<ChildEntity> childEntityList = new ArrayList<>();
                for (int j = 0; j < listCountSize; j++) {
                    String item = listCount.getJSONObject(j).toString();
                    ChildEntity childEntity = gson.fromJson(item, ChildEntity.class);
                    childEntityList.add(childEntity);
                }
                groupEntities.add(new GroupEntity(head, childEntityList));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return groupEntities;
    }

    /**
     * RecyclerView提供了三种内置的LayoutManager:
     */
    private void initLinearLayoutManager() {
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
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this, mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:" + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:" + item, Toast.LENGTH_SHORT).show();
            }
        });
        rvList.setAdapter(adapter);
    }

    private void initGridLayoutManger() {
        //设置固定大小
        rvList.setHasFixedSize(true);
        //创建线性布局
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 4);
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
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this, mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:" + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:" + item, Toast.LENGTH_SHORT).show();
            }
        });
        rvList.setAdapter(adapter);
    }

    private void initStaggeredGridLayoutManager() {
        //设置固定大小
        rvList.setHasFixedSize(false);
        //创建线性布局
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL);
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
        TestRecyclerAdapter2 adapter = new TestRecyclerAdapter2(this, mTitles);
        //设置监听事件
        adapter.setOnItemClickLitener(new CommRecyclerBaseAdater.OnItemClickLitener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemClick:" + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, String item, int position) {
                Toast.makeText(MainActivity.this, "onItemLongClick:" + item, Toast.LENGTH_SHORT).show();
            }
        });
        rvList.setAdapter(adapter);
    }

    @OnClick(R.id.btn_adddata)
    public void onViewClicked() {
        groupsDataAdapte.addItemFromList(addData());

    }
}
