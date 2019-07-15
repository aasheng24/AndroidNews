package a.a.sheng.shengnews.presenter.project;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.project.ProjectContract;
import a.a.sheng.shengnews.core.DataManager;

public class ProjectPresenter extends BasePresenter<ProjectContract.View>
        implements ProjectContract.Presenter{

    private DataManager mDataManager;

    @Inject
    ProjectPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getProjectClassifyData() {

    }

    @Override
    public int getProjectCurrentPage() {
        return 0;
    }

    @Override
    public void setProjectCurrentPage(int page) {

    }
}
