package a.a.sheng.shengnews.base.view;

public interface AbstractView {

    void useNightMode(boolean isNightMode);

    void showErrorMsg(String errorMsg);

    void showNormal();

    void showError();

    void showLoading();

    void reload();

    void showLoginView();

    void showLogoutView();

    void showCollectSuccess();

    void showCancelCollectSuccess();

    void showToast(String message);

    void showSnackBar(String message);


}
