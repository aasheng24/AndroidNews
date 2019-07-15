package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.RegisterContract;
import a.a.sheng.shengnews.core.DataManager;

public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public RegisterPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getRegisterData(String username, String password, String rePassword) {

    }
}
