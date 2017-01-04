package hr.mono.mvpexample;

public interface LoginInteractor {
    public interface OnLoginFinishListener{
        void onError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishListener listener);
}
