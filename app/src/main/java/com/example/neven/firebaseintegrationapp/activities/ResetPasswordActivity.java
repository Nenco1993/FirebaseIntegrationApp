package com.example.neven.firebaseintegrationapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.neven.firebaseintegrationapp.MyApplication;
import com.example.neven.firebaseintegrationapp.R;
import com.example.neven.firebaseintegrationapp.dagger.modules.ResetPasswordModule;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.presenters.ResetPasswordPresenter;
import com.example.neven.firebaseintegrationapp.views.ResetPasswordView;

import javax.inject.Inject;

public class ResetPasswordActivity extends AppCompatActivity implements ResetPasswordView {

    @BindView(R.id.etResetPasswordEmail)
    EditText etEmail;

    @BindView(R.id.bResetPassword)
    Button bResetPassword;

    @Inject
    ResetPasswordPresenter presenter;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().newResetPasswordSubComponent(new ResetPasswordModule(this, this)).inject(this);
    }

    @OnClick(R.id.bResetPassword)
    void resetPassword() {

        String email = etEmail.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, "fill in the fields", Toast.LENGTH_SHORT).show();
        } else {
            user.email=email;

            presenter.resetPassword(user);
        }


    }

    @Override
    public void showResponse(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
}
