package cj.com.a1604kproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import cj.com.a1604kproject.bean.MyApplication;
import cj.com.a1604kproject.bean.User;
import cj.com.a1604kproject.bean.UserInfo;
import cj.com.a1604kproject.greendao.DaoMaster;
import cj.com.a1604kproject.greendao.DaoSession;
import cj.com.a1604kproject.greendao.UserDao;
import cj.com.a1604kproject.net.Api;
import cj.com.a1604kproject.net.HttpUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity{


    private ListView listView;
    private ArrayList<String> arrayList;
    private ExpandableListView expandableListView;
    private View footer;
    private String[] groupString;
    private String[][] childString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        initTestData();
        initTestData2();
        //computeListView();
        computeExpandableListView();
        Log.e("myMessage","ss");
        loadData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgress();
            }
        },5000);
    }

    private void loadData() {
        showProgress();
        //....
    }



    @Override
    int setSelfView() {
        return R.layout.activity_main;
    }

    private void computeExpandableListView() {
        expandableListView = findViewById(R.id.expandablelist);
        MyExpandableAdapter myExpandableAdapter = new MyExpandableAdapter();
        myExpandableAdapter.setDatas(groupString,childString);
        expandableListView.setAdapter(myExpandableAdapter);
    }

    private void computeListView() {
        listView = findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(this);
        myAdapter.setData(arrayList);
        listView.setAdapter(myAdapter);
        footer = LayoutInflater.from(this).inflate(R.layout.footview,null);
        listView.addFooterView(footer);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e("myMessage","firstVisibleItem = "+firstVisibleItem+"totalItemCount = "+ totalItemCount);
                if(firstVisibleItem + visibleItemCount == totalItemCount) {
                    footer.setVisibility(View.GONE);
                } else {
                    footer.setVisibility(View.GONE);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("myMessage","onItemClick "+position);
            }
        });
    }

    private void initTestData2() {
        groupString = new String[]{"射手", "辅助", "坦克", "法师"};
        childString = new String[][]{
               {"孙尚香", "后羿", "马可波罗", "狄仁杰"},
               {"孙膑", "蔡文姬", "鬼谷子", "杨玉环"},
               {"张飞", "廉颇", "牛魔", "项羽"},
               {"诸葛亮", "王昭君", "安琪拉", "干将"}
   };
    }

    private void initTestData() {
        arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add("name"+""+i);
        }
    }

}
