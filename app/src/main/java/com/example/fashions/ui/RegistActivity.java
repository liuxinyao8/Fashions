package com.example.fashions.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fashions.R;
import com.example.fashions.base.BaseMActivity;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.login.RegisterContract;
import com.example.fashions.model.bean.Register;
import com.example.fashions.persenter.login.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends BaseMActivity implements RegisterContract.view {

    @BindView(R.id.register_ed1)
    EditText registerEd1;
    @BindView(R.id.register_ed2)
    EditText registerEd2;
    @BindView(R.id.bt_register)
    Button btRegister;
    private String name;
    private String pass;

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return new RegisterPresenter();
    }

    @Override
    public void getregist(Register register) {
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
            finish();

    }

    @OnClick(R.id.bt_register)
    public void onViewClicked() {
        name = registerEd1.getText().toString();
        pass = registerEd2.getText().toString();
        if (!name.equals("") && !pass.equals("")) {
            ((RegisterPresenter) persenter).getRegisterp(name, pass);
            Toast.makeText(context, "注册成功!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(context, LoginActivity.class);
            startActivity(intent1);
        }
    }
}
