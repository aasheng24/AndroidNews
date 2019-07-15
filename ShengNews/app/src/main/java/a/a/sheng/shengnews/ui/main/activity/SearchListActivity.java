package a.a.sheng.shengnews.ui.main.activity;

import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.contract.main.SearchListContract;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.presenter.main.SearchListPresenter;

public class SearchListActivity extends BaseActivity<SearchListPresenter>
        implements SearchListContract.View {

    @Override
    public void showSearchList(FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void useNightMode(boolean isNightMode) {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }
}
