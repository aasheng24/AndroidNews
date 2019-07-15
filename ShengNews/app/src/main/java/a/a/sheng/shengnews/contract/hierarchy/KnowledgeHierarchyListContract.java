package a.a.sheng.shengnews.contract.hierarchy;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;

public interface KnowledgeHierarchyListContract {
    interface View extends AbstractView {
        void showKnowledgeHierarchyDetailData(FeedArticleListData feedArticleListData);
        void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData);
        void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData);
        void showJumpTheTop();
        void showReloadDetailEvent();
    }

    interface Presenter extends AbstractPresenter<View> {
        void getKnowledgeHierarchyDetailData(int page, int cid, boolean isShowError);
        void addCollectArticle(int position, FeedArticleData feedArticleData);
        void cancelCollectArticle(int position, FeedArticleData feedArticleData);

    }
}
