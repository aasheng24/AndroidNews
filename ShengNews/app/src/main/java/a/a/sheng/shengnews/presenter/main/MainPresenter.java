package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.MainContract;
import a.a.sheng.shengnews.core.DataManager;

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter{

    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    private void registerEvent() {
        //TBD
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    @Override
    public void setCurrentPage(int page) {
        mDataManager.setCurrentPage(page);
    }

    @Override
    public void setNightModeState(boolean b) {
        mDataManager.setNightModeState(b);
    }

    @Override
    public void logout() {
        //TBD
    }
}
