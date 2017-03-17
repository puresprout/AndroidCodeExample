package com.purestation.kotlincodeexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ListItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = makeListItems();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem item = items.get(position);
                startActivity(new Intent(MainActivity.this, item.clazz));
            }
        });
    }

    private List<ListItem> makeListItems() {
        items = new ArrayList<>();
        items.add(new ListItem("Synthetic Properties Test", SyntheticPropertiesActivity.class));

        return items;
    }

    class ListItem {
        public String title;
        public Class clazz;

        public ListItem(String title, Class clazz) {
            this.title = title;
            this.clazz = clazz;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
