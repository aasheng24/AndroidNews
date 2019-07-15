package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.LoginContract;
import a.a.sheng.shengnews.core.DataManager;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void getLoginData(String username, String password) {

    }
}
