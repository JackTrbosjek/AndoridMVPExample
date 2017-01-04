package hr.mono.mvpexample;


public interface LoginView {
    void showUsernameError();
    void showPasswordError();
    void displayMessage(String message);
    void showProgress();
    void hideProgress();
    void navigateToMain();
}
