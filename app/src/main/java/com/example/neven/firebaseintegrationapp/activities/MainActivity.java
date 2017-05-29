package com.example.neven.firebaseintegrationapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.neven.firebaseintegrationapp.MyApplication;
import com.example.neven.firebaseintegrationapp.R;
import com.example.neven.firebaseintegrationapp.dagger.modules.FirebaseModule;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.presenters.FirebasePresenter;
import com.example.neven.firebaseintegrationapp.utils.MainUtils;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements FirebaseView {

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.bLogin)
    Button bLogin;

    @BindView(R.id.bRegister)
    Button bRegister;

    @BindView(R.id.tvForgotPassword)
    TextView tvForgotPassword;

    @Inject
    FirebasePresenter presenter;

    @Inject
    User user;

    @Inject
    MainUtils mainUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().newFirebaseSubComponent(new FirebaseModule(this, this)).inject(this);
        presenter.onReceiveNotification();


    }

    @OnClick(R.id.bRegister)
    void registerUser() {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "fill in the fields", Toast.LENGTH_SHORT).show();
        } else {
            user.email = email;
            user.password = password;
            presenter.createUser(user);
        }


    }

    @OnClick(R.id.bLogin)
    void loginUser() {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "fill in the fields", Toast.LENGTH_SHORT).show();
        } else {
            user.email = email;
            user.password = password;
            presenter.loginUser(user);
        }


    }

    @OnClick(R.id.tvForgotPassword)
    void resetPassword() {

        startActivity(new Intent(getBaseContext(), ResetPasswordActivity.class));


    }

    @Override
    public void showResponse(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mainUtils.appIsNotInBackground();
        presenter.setupNotifications();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainUtils.appIsInBackground();
        presenter.unregisterNotificationReceiver();

    }
}
