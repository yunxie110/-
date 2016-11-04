package com.example.administrator.qqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton image;
    ImageButton exit;

    int[] ico=new int[]{R.drawable.qq,R.drawable.ico1,R.drawable.ico2}; //该数组用于保存头像资源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent(); //获取Intent对象
        Bundle bundle=intent.getExtras(); //获取传递的数据包
         int index=bundle.getInt("index"); //获取传递过来的头像编号

        //获取用于显示当前登录用户的ImageButton组件
        image=(ImageButton)findViewById(R.id.qq);
        image.setImageResource(ico[index]); //显示头像

        exit=(ImageButton)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //关闭当前Activity
            }
        });

    }
}
