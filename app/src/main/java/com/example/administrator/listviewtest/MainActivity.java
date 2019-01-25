package com.example.administrator.listviewtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> person_list;
    private ListView listView;
    private MybaseAdapter adapter;

    static class ViewHolder {
        ImageView person_img;
        TextView person_name;
        TextView person_info;
        TextView person_area;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        person_list = new ArrayList<Person>();
        listView = findViewById(R.id.listView);
        System.out.println("debug: start listView empty");
        listView.setEmptyView(this.findViewById(R.id.empty));//如果listview无数据时的界面
        init();
        adapter = new MybaseAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击一次", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {
        Person person1 = new Person(" ", "chen", "nihao", "福州");
        Person person2 = new Person(" ", "sun", "nihao", "福州");
        Person person3 = new Person(" ", "lin", "nihao", "福州");
        Person person4= new Person(" ", "li", "nihao", "福州");

        person_list.add(person1);
        person_list.add(person2);
        person_list.add(person3);
        person_list.add(person4);


    }

    class MybaseAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MybaseAdapter() {
            inflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public int getCount() {
            return person_list.size();
        }

        @Override
        public Object getItem(int position) {
            return person_list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertview == null) {
                holder = new ViewHolder();
                convertview = inflater.inflate(R.layout.item, parent, false);
                holder.person_img = convertview.findViewById(R.id.person_img);
                holder.person_name = convertview.findViewById(R.id.person_name);
                holder.person_info = convertview.findViewById(R.id.person_intro);
                holder.person_area = convertview.findViewById(R.id.person_area);
                convertview.setTag(holder);
            } else {
                holder = (ViewHolder) convertview.getTag();
            }
            String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545733758353&di=9f5b075c137827151a7b2b698925a199&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201210%2F07%2F20121007194928_whKNM.jpeg";
            Picasso.with(MainActivity.this).load(url).placeholder(R.drawable.icon_none).into(holder.person_img);
            //  holder.store_img.(list.get(position).getStore_img());
            holder.person_name.setText(person_list.get(position).getName());
            holder.person_info.setText(person_list.get(position).getIntro());
            holder.person_area.setText(person_list.get(position).getArea());
            return convertview;
        }
    }

}
