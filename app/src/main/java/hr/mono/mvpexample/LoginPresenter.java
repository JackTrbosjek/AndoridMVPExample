package hr.mono.mvpexample;

public interface LoginPresenter {

    void authenticateUser(String username, String password);

    void onDestroy();

}
