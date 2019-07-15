package a.a.sheng.shengnews.presenter.navigation;

import java.util.prefs.BackingStoreException;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.navigation.NavigationContract;
import a.a.sheng.shengnews.core.DataManager;

public class NavigationPresenter extends BasePresenter<NavigationContract.View>
        implements NavigationContract.Presenter{


    private DataManager mDataManager;

    @Inject
    NavigationPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getNavigationListData(boolean isShowError) {

    }
}
