package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.UsageDialogContract;
import a.a.sheng.shengnews.core.DataManager;

public class UsageDialogPresenter extends BasePresenter<UsageDialogContract.View>
        implements UsageDialogContract.Presenter{

    private DataManager mDataManager;

    @Inject
    UsageDialogPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void getUsefulSites() {

    }
}
