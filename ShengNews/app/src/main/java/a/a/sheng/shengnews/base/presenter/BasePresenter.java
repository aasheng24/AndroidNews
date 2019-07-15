package a.a.sheng.shengnews.base.presenter;

import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.DataManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {

    protected T mView;
    private CompositeDisposable compositeDisposable;
    private DataManager mDataManager;

    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {

    }

    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }

    @Override
    public int getCurrentPage() {
        return 0;
    }

    protected void addSubScribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
