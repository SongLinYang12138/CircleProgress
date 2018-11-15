package com.bondex.ysl.mytest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bondex.ysl.mytest.bean.User;
import com.bondex.ysl.mytest.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            binding.progressview.setCurrentValue(msg.what);

        }
    };

    int add = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final User user = new User("1222", "sdad");
        binding.setUser(user);


        binding.tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {


                        for (int i = 0; i <= 100; ++i) {


                            handler.sendEmptyMessage(i);

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                thread.setDaemon(true);
                thread.start();


                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
//                ++add;
//                user.setFirstName("add"+add);
            }
        });

        findViewById(R.id.tv_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });


        ArrayList<String> list = new ArrayList<>();

        list.add("2221232s");
        list.add("222sss");
        list.add("2wwwsada");
        list.add("wsdas2s");
        list.add("2sada");
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
//        binding.recyclerview.setLayoutManager(manager);
//        binding.recyclerview.setAdapter(new MyAdapter(list));


    }


}
