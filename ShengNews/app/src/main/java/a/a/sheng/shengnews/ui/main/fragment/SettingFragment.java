package a.a.sheng.shengnews.ui.main.fragment;

import android.os.Bundle;
import android.widget.CompoundButton;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.fragment.BaseFragment;
import a.a.sheng.shengnews.contract.main.SettingContract;
import a.a.sheng.shengnews.presenter.main.SettingPresenter;

public class SettingFragment extends BaseFragment<SettingPresenter> implements
        SettingContract.View,
        CompoundButton.OnCheckedChangeListener{

    public static SettingFragment getInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initEventAndData() {

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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
