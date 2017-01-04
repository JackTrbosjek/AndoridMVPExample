package hr.mono.mvpexample;

public class LoginInteractorImpl implements LoginInteractor{

    @Override
    public void login(String username, String password, OnLoginFinishListener listener) {
        //network call
        //if success
        listener.onSuccess();
        //if error
        listener.onError();
    }
}
