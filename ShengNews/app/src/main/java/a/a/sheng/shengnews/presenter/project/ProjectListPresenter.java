package a.a.sheng.shengnews.presenter.project;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.project.ProjectListContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class ProjectListPresenter extends BasePresenter<ProjectListContract.View>
        implements ProjectListContract.Presenter{

    private DataManager mDataManager;

    @Inject
    ProjectListPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getProjectListData(int page, int cid, boolean isShowError) {

    }

    @Override
    public void addCollectOutsideArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }
}
