package cj.com.a1604kproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<String> arrayList;
    private ExpandableListView expandableListView;
    private View footer;
    private String[] groupString;
    private String[][] childString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initTestData();
        initTestData2();
        computeListView();


        
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
