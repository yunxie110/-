package com.example.administrator.qqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText userName;
    EditText userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button) findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=(EditText)findViewById(R.id.userName);
                userPwd=(EditText)findViewById(R.id.userPwd);

                boolean flag=false; //用于标记是否成功登录
                String index=""; //用于保存头像编号的变量

                //通过遍历数据的形式判断输入的帐号和密码是否正确
                for (int i=0;i<Data.User.length;i++){
                    if (userName.equals(Data.User[i][0])){ //判断帐号是否正确
                        if (userPwd.equals(Data.User[i][1])){ //判断密码是否正确
                            index=Data.User[i][2]; //获取头像编号
                            flag=true;  //表示成功登录
                            break; //跳出for循环
                        }
                    }
                }
                if (flag){
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    //创建要显示Activity对应的Intent对象
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle(); //创建一个Bundle的对象bundle
                    bundle.putInt("index",Integer.parseInt(index)); //保存头像编号
                    intent.putExtras(bundle); //将数据包添加到intent对象中

                    startActivity(intent); //开启一个新的Activity，进行页面的跳转
                }else {
                    Toast toast=Toast.makeText(LoginActivity.this, "您输入的帐号或密码有误", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0); //设置对齐方式
                    toast.show(); //显示对话框

                }




            }
        });

    }
}
