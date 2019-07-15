package a.a.sheng.shengnews.presenter.hierarchy;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.hierarchy.KnowledgeHierarchyDetailContract;
import a.a.sheng.shengnews.core.DataManager;

public class KnowledgeHierarchyDetailPresenter extends BasePresenter<KnowledgeHierarchyDetailContract.View>
        implements KnowledgeHierarchyDetailContract.Presenter{

    @Inject
    KnowledgeHierarchyDetailPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(KnowledgeHierarchyDetailContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        //TBD
    }

}
