package com.example.dell.newscenter.myview.InfoActivity.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.newscenter.R;
import com.example.dell.newscenter.bean.Project;
import com.example.dell.newscenter.myview.base.project.ProjectRecyclerViewLayout;

import java.util.ArrayList;
import java.util.List;

public class MyDynamicActivity extends AppCompatActivity{
    private ProjectRecyclerViewLayout myDynameicCV;
    private List<Project> projectList = new ArrayList<>();
    public void getDate() {
        String imageUrl = "http://img2.woyaogexing.com/2018/05/19/a7bbc2eebe60b832!400x400_big.jpg";
        String videoUrl ="http://ips.ifeng.com/video.ifeng.com/video04/2011/03/24/480x360_offline20110324.mp4";
        Project project = new Project(1,"ADWS",imageUrl,videoUrl,0,0,"ACSS");
        projectList.add(project);
        projectList.add(project);
        projectList.add(project);
        projectList.add(project);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydynamic);
        getDate();
        myDynameicCV = findViewById(R.id.myDynameicCV);
        myDynameicCV.getDate(projectList);
    }
}
