package com.example.dell.newscenter.myview.InfoActivity.userinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.newscenter.R;
import com.example.dell.newscenter.bean.User;
import com.example.dell.newscenter.myview.InfoActivity.attention.MyAttentionActivity;
import com.example.dell.newscenter.myview.InfoActivity.collection.MyCollectionActivity;
import com.example.dell.newscenter.myview.InfoActivity.dynamic.MyDynamicActivity;
import com.example.dell.newscenter.myview.InfoActivity.fans.MyFansActivity;
import com.example.dell.newscenter.myview.base.CircleImageView;
import com.example.dell.newscenter.myview.base.FloatInfoMenu;
import com.example.dell.newscenter.utils.ActivityUtil;
import com.example.dell.newscenter.utils.ApplicationUtil;

public class UserInfoActivity extends AppCompatActivity {
private CircleImageView  userInfoHeadCV  = null;
private TextView userInfoNameTV = null;
private ImageView userInfoGenderIV = null;
private FloatInfoMenu floatInfoMenu = null;
private Button inforEditorBtn = null;
private  boolean  isEditAble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    // 获取  intent 中的   user对象
        Intent intent = this.getIntent();

        final User user = (User)intent.getParcelableExtra("user");
        boolean isEditAble = intent.getBooleanExtra("isEditAble",false);



        userInfoHeadCV = findViewById(R.id.userInfoHeadCV);
        Glide.with(UserInfoActivity.this).load(user.getHeadUrl()).fitCenter().into(userInfoHeadCV);
        userInfoNameTV = findViewById(R.id.userInfoNameTV);
        userInfoNameTV.setText(user.getName());
        userInfoGenderIV = findViewById(R.id.userInfoGenderIV);
        userInfoGenderIV.setImageResource(ApplicationUtil.genderId[user.getGender()]);




        inforEditorBtn = findViewById(R.id.infoEditorBtn);
        if (isEditAble){
            inforEditorBtn.setText("编辑资料");
            inforEditorBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UserInfoActivity.this,InfoEditActivity.class);
                    startActivity(intent);
                }
            });
        }else {
            inforEditorBtn.setText("关注");
            inforEditorBtn.setClickable(isEditAble);
            inforEditorBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  发送网络请求  关注
                    inforEditorBtn.setText("取消关注");
                }
            });
        }

        floatInfoMenu = findViewById(R.id.floatInfoMenu);
        floatInfoMenu.setOnItemMenuClickListener(new FloatInfoMenu.OnItemMenuClickListener(){
            @Override
            public void onItemMenuClick(View view, int position) {
                Intent intent  = new Intent();
                intent.putExtra("user",user);
                switch (position){
                    case 0: intent.setClass(UserInfoActivity.this,MyCollectionActivity.class);break;
                    case 1: intent.setClass(UserInfoActivity.this,MyFansActivity.class);break;
                    case 2: intent.setClass(UserInfoActivity.this,MyAttentionActivity.class);break;
                    case 3: intent.setClass(UserInfoActivity.this,MyDynamicActivity.class);break;
                }
                startActivity(intent);
            }
        });

    }
}
