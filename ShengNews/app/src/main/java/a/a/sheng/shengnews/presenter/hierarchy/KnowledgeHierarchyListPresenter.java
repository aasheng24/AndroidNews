package a.a.sheng.shengnews.presenter.hierarchy;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.hierarchy.KnowledgeHierarchyListContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class KnowledgeHierarchyListPresenter extends BasePresenter<KnowledgeHierarchyListContract.View>
        implements KnowledgeHierarchyListContract.Presenter{

    private DataManager mDataManager;

    @Inject
    KnowledgeHierarchyListPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(KnowledgeHierarchyListContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        //TBD
    }

    @Override
    public void getKnowledgeHierarchyDetailData(int page, int cid, boolean isShowError) {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }
}
