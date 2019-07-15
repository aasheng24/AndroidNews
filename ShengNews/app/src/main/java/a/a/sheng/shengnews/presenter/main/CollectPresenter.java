package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.CollectContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class CollectPresenter extends BasePresenter<CollectContract.View> implements CollectContract.Presenter {
    private DataManager mDataManager;

    @Inject
    CollectPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void getCollectList(int page, boolean isShowError) {

    }

    @Override
    public void cancelCollectPageArticle(int position, FeedArticleData feedArticleData) {

    }
}
