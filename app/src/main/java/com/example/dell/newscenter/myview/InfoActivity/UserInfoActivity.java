package com.example.dell.newscenter.myview.InfoActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.newscenter.R;
import com.example.dell.newscenter.bean.User;
import com.example.dell.newscenter.myview.base.FloatInfoMenu;

public class UserInfoActivity extends AppCompatActivity {
private FloatInfoMenu floatInfoMenu = null;
private Button inforEditorBtn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        inforEditorBtn = findViewById(R.id.infoEditorBtn);
        inforEditorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this,InfoEditActivity.class);
                startActivity(intent);
            }
        });
        floatInfoMenu = findViewById(R.id.floatInfoMenu);
        floatInfoMenu.setOnItemMenuClickListener(new FloatInfoMenu.OnItemMenuClickListener(){
            @Override
            public void onItemMenuClick(View view, int position) {
                Intent intent  = new Intent();
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
