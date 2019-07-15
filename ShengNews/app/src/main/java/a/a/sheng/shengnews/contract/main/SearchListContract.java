package a.a.sheng.shengnews.contract.main;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;

public class SearchListContract {
    public interface View extends AbstractView {

        /**
         * Show search list
         *
         * @param feedArticleListData FeedArticleListData
         */
        void showSearchList(FeedArticleListData feedArticleListData);

        /**
         * Show collect article data
         *
         * @param position Position
         * @param feedArticleData FeedArticleData
         * @param feedArticleListData FeedArticleListData
         */
        void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData);

        /**
         * Show cancel collect article data
         *
         * @param position Position
         * @param feedArticleData FeedArticleData
         * @param feedArticleListData FeedArticleListData
         */
        void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData);

    }

    public interface Presenter extends AbstractPresenter<View> {

        /**
         * 搜索
         * @param page page
         * @param k POST search key
         * @param isShowError If show error
         */
        void getSearchList(int page, String k, boolean isShowError);

        /**
         * Add collect article
         *
         * @param position Position
         * @param feedArticleData FeedArticleData
         */
        void addCollectArticle(int position, FeedArticleData feedArticleData);

        /**
         * Cancel collect article
         *
         * @param position Position
         * @param feedArticleData FeedArticleData
         */
        void cancelCollectArticle(int position, FeedArticleData feedArticleData);

    }
}
