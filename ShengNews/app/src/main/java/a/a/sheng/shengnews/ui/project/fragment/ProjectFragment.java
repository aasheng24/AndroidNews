package a.a.sheng.shengnews.ui.project.fragment;

import android.os.Bundle;

import java.util.List;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.project.ProjectContract;
import a.a.sheng.shengnews.core.bean.project.ProjectClassifyData;
import a.a.sheng.shengnews.presenter.project.ProjectPresenter;

public class ProjectFragment extends BaseRootFragment<ProjectPresenter> implements ProjectContract.View{

    public static ProjectFragment getInstance(String param1, String param2) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();
        args.putString(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void jumpToTheTop() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showProjectClassifyData(List<ProjectClassifyData> projectClassifyDataList) {

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
