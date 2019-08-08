package com.example.fashions.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fashions.MainActivity;
import com.example.fashions.R;
import com.example.fashions.base.BaseMActivity;
import com.example.fashions.fragment.MyFragment;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.login.LoginContract;
import com.example.fashions.model.bean.LoginBean;
import com.example.fashions.persenter.login.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMActivity implements LoginContract.view {

    @BindView(R.id.login_ed1)
    EditText loginEd1;
    @BindView(R.id.login_ed2)
    EditText loginEd2;
    @BindView(R.id.login_bt)
    Button loginBt;
    private String username;
    private String password;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return new LoginPresenter();
    }

    @Override
    public void getLogin(LoginBean loginBean) {
            if (loginBean.getData().getCode() == 200) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("username", loginBean.getData().getData().getUsername());
                startActivity(intent);
        }
    }

    @OnClick(R.id.login_bt)
    public void onViewClicked() {
        username = loginEd1.getText().toString();
        password = loginEd2.getText().toString();
        if (!username.equals("") && !password.equals("")) {
            ((LoginPresenter) persenter).getLoginp(username, password);
            Toast.makeText(context, "登陆成功!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
        }
    }
}
