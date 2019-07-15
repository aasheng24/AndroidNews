package a.a.sheng.shengnews.ui.navigation;

import android.os.Bundle;

import java.util.List;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.navigation.NavigationContract;
import a.a.sheng.shengnews.core.bean.navigation.NavigationListData;
import a.a.sheng.shengnews.presenter.navigation.NavigationPresenter;

public class NavigationFragment extends BaseRootFragment<NavigationPresenter> implements NavigationContract.View  {

    public static NavigationFragment getInstance(String param1, String param2) {
        NavigationFragment fragment = new NavigationFragment();
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
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showNavigationListData(List<NavigationListData> navigationDataList) {

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

