package com.doublefang.customview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mList = (ListView) findViewById(R.id.list);

        Integer[] ints = new Integer[100];
        Arrays.fill(ints, R.mipmap.ic_launcher);

        ArrayList<Map<String, Integer>> maps = new ArrayList<>();
        HashMap<String, Integer> map = null;
        for (int i = 0; i < 100; i++) {
            map = new HashMap<>();
            map.put("a", R.mipmap.ic_launcher);
            maps.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, maps, R.layout.item_limg, new String[]{"a"}, new int[]{R.id.item_img});

        mList.setAdapter(adapter);
    }
}
