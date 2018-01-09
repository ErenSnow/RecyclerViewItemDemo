package com.study.eren.recyclerviewitemdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

/**
 * 主界面
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] data = new String[]{"aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb", "aa", "bb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, data);
        recyclerView.setAdapter(myAdapter);
        //给条目设置分割线
        recyclerView.addItemDecoration(new MyDecoration(MainActivity.this, MyDecoration.VERTICAL_LIST));
        //条目点击事件
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "点击了第" + position + "个条目", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(MainActivity.this, "长按点击了第" + position + "个条目", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
