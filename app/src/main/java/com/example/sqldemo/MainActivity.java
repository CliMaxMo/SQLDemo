package com.example.sqldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sqldemo.sql.StudentDao;
import com.example.sqldemo.sql.StudentInfoBean;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;
    private Button tv_add;
    private StudentDao mStudentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStudentDao = new StudentDao(this);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        mMainAdapter = new MainAdapter();

        mRecyclerView.setAdapter(mMainAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tv_add = findViewById(R.id.tv_add);
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddUserActivity.intentAddUserActivity(MainActivity.this, "", 0, "");
            }
        });

        mMainAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                StudentInfoBean data= (StudentInfoBean) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.btn_update:
                        AddUserActivity.intentAddUserActivity(MainActivity.this, data.getName(), data.getAge(), data.getSex());
                        break;
                    case R.id.btn_delete:
                        mStudentDao.deleteData(data.getName());
                        mMainAdapter.getData().remove(position);
                        mMainAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainAdapter.setNewData(mStudentDao.queryData());

    }
}
