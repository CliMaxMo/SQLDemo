package com.example.sqldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqldemo.sql.StudentDao;
import com.example.sqldemo.sql.StudentInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddUserActivity extends AppCompatActivity {


    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.et_sex)
    EditText mEtSex;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.btn_add)
    Button mBtnAdd;

    public static void intentAddUserActivity(Context context, String name, int age, String sex) {
        context.startActivity(new Intent(context, AddUserActivity.class).putExtra("name", name)
                .putExtra("age", age).putExtra("sex", sex));
    }


    private StudentDao mStudentDao;
    private String name;
    private int age;
    private String sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        ButterKnife.bind(this);
        mStudentDao = new StudentDao(this);
        name = getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name)) {
            age = getIntent().getIntExtra("age", 0);
            sex = getIntent().getStringExtra("sex");
            mEtName.setText(name);
            mEtSex.setText(sex);
            mEtAge.setText(age + "");
            mBtnUpdate.setVisibility(View.VISIBLE);
            mBtnAdd.setVisibility(View.GONE);
        } else {
            mBtnUpdate.setVisibility(View.GONE);
            mBtnAdd.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.btn_update, R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                StudentInfoBean studentInfoBean1 = new StudentInfoBean();
                studentInfoBean1.setName(mEtName.getText().toString());
                studentInfoBean1.setAge(Integer.parseInt(mEtAge.getText().toString()));
                studentInfoBean1.setSex(mEtSex.getText().toString());
                mStudentDao.updateData(studentInfoBean1);
                finish();
                break;
            case R.id.btn_add:
                StudentInfoBean studentInfoBean = new StudentInfoBean();
                studentInfoBean.setName(mEtName.getText().toString());
                studentInfoBean.setAge(Integer.parseInt(mEtAge.getText().toString()));
                studentInfoBean.setSex(mEtSex.getText().toString());
                mStudentDao.addData(studentInfoBean);
                finish();
                break;
        }
    }
}
