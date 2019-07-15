package a.a.sheng.shengnews.ui.hierarchy.fragment;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.hierarchy.KnowledgeHierarchyListContract;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.presenter.hierarchy.KnowledgeHierarchyListPresenter;

public class KnowledgeHierarchyListFragment extends BaseRootFragment<KnowledgeHierarchyListPresenter>
        implements KnowledgeHierarchyListContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge_hierarchy_list;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showKnowledgeHierarchyDetailData(FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showJumpTheTop() {

    }

    @Override
    public void showReloadDetailEvent() {

    }

    @Override
    public void useNightMode(boolean isNightMode) {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

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

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showSnackBar(String message) {

    }
}
