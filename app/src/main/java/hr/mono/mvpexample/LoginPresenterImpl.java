package hr.mono.mvpexample;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void authenticateUser(String username, String password) {
        if (loginView != null) {
            if (username == null || username.isEmpty())
                loginView.showUsernameError();
            if (password == null || password.isEmpty())
                loginView.showPasswordError();

            loginView.showProgress();
            loginInteractor.login(username, password, this);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onError() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.displayMessage("Login error!");
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.displayMessage("Login success!");
            loginView.navigateToMain();
        }
    }
}
