package a.a.sheng.shengnews.presenter.hierarchy;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.hierarchy.KnowLedgeHierarchyContract;
import a.a.sheng.shengnews.core.DataManager;
import io.reactivex.disposables.Disposable;

public class KnowledgeHierarchyPresenter extends BasePresenter<KnowLedgeHierarchyContract.View>
        implements KnowLedgeHierarchyContract.Presenter{

    private DataManager mDataManager;

    @Inject
    KnowledgeHierarchyPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getKnowledgeHierarchyData(boolean isShowError) {

    }
}
