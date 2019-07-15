package a.a.sheng.shengnews.ui.project.fragment;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.project.ProjectListContract;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.core.bean.project.ProjectListData;
import a.a.sheng.shengnews.presenter.project.ProjectListPresenter;

public class ProjectListFragment extends BaseRootFragment<ProjectListPresenter> implements ProjectListContract.View  {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showProjectListData(ProjectListData projectListData) {

    }

    @Override
    public void showCollectOutsideArticle(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showJumpToTheTop() {

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
