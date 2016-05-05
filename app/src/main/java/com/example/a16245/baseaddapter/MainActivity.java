package com.example.a16245.baseaddapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemBean> date=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            //使用假数据，展示相关的item
            date.add(new ItemBean(R.mipmap.ic_launcher,
                    "我是标题"+i,"我是内容"+i));
        }
        ListView lv= (ListView) findViewById(R.id.lv_show);
        lv.setAdapter(new MyAdapter(MainActivity.this,date));
    }
}
