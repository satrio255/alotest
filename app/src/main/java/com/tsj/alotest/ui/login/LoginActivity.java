package com.tsj.alotest.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.silvestrpredko.dotprogressbar.DotProgressBar;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.tsj.alotest.R;
import com.tsj.alotest.preferences.AppPrefHelper;
import com.tsj.alotest.preferences.PrefKey;
import com.tsj.alotest.ui.BaseActivity;
import com.tsj.alotest.ui.home.HomeActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by tunggul.jati on 09/10/2018.
 */

public class LoginActivity extends BaseActivity implements Validator.ValidationListener {

    @Bind(R.id.input_nama)
    @NotEmpty(message = "Harap isi data valid")
    EditText input_nama;

    @Bind(R.id.input_password)
    @Password(min = 3, message = "Minimum password 3 karakter")
    EditText input_password;

    @Bind(R.id.btnLogin)
    Button btnLogin;

    @Bind(R.id.login_rl_progressstatus)
    RelativeLayout rl_progressstatus;

    @Bind(R.id.llProgress)
    LinearLayout llProgress;

    @Bind(R.id.llLogin)
    LinearLayout llLogin;

    private Validator validator;
    private boolean flag;

    @Override
    protected int getLayout() {
        return R.layout.a_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validator = new Validator(this);
        validator.setValidationListener(this);
        flag = AppPrefHelper.getBoolean(PrefKey.IS_LOGIN);
        uiInit();
        handler();
    }

    private void handler(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag){
                    Log.d("run: ","menu");
                    HomeActivity.startActivity((BaseActivity) LoginActivity.this);
                    finish();
                } else {
                    uiLogin();
                    Log.d("run: ","login");
                }
            }
        },2000);
    }

    @OnClick(R.id.btnLogin)
    void in(){
        uiClicLogin();
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        AppPrefHelper.setBoolean(PrefKey.IS_LOGIN, true);
        AppPrefHelper.setString(PrefKey.USERNAME, input_nama.getText().toString());
        HomeActivity.startActivity((BaseActivity) LoginActivity.this);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT);
            }
        }
        uiLogin();
    }

    private void uiInit(){
        llProgress.setVisibility(View.VISIBLE);
        llLogin.setVisibility(View.GONE);
        btnLogin.setVisibility(View.VISIBLE);
        rl_progressstatus.setVisibility(View.GONE);
    }

    private void uiLogin(){
        llProgress.setVisibility(View.GONE);
        llLogin.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.VISIBLE);
        rl_progressstatus.setVisibility(View.GONE);
    }

    private void uiClicLogin(){
        llProgress.setVisibility(View.GONE);
        llLogin.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.GONE);
        rl_progressstatus.setVisibility(View.VISIBLE);
    }
}
