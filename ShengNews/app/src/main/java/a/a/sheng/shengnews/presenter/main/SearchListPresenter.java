package a.a.sheng.shengnews.presenter.main;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.SearchListContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class SearchListPresenter extends BasePresenter<SearchListContract.View>
        implements SearchListContract.Presenter{

    private DataManager mDataManager;

    @Inject
    SearchListPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }


    @Override
    public void getSearchList(int page, String k, boolean isShowError) {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }
}
