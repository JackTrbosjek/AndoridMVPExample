package hr.mono.mvpexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText etPassword,etUsername;
    private Button btnLogin;
    private ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        loginPresenter = new LoginPresenterImpl(this);
    }

    private void initComponents() {
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUsername = (EditText) findViewById(R.id.etUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClick();
            }
        });
        progressBar = new ProgressBar(this);
    }

    private void loginClick() {
        loginPresenter.authenticateUser(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @Override
    public void showUsernameError() {
        etUsername.setError("Username not correct!");
    }

    @Override
    public void showPasswordError() {
        etPassword.setError("Password not correct!");
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToMain() {
        //navigate to some other activity
        Intent i = new Intent();
        startActivity(i);
    }
}
