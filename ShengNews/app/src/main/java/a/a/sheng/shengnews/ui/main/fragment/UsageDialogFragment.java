package a.a.sheng.shengnews.ui.main.fragment;

import android.view.ViewTreeObserver;

import java.util.List;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.base.fragment.BaseDialogFragment;
import a.a.sheng.shengnews.contract.main.UsageDialogContract;
import a.a.sheng.shengnews.core.bean.main.search.UsefulSiteData;
import a.a.sheng.shengnews.presenter.main.UsageDialogPresenter;
import a.a.sheng.shengnews.widget.CircularRevealAnim;

public class UsageDialogFragment extends BaseDialogFragment<UsageDialogPresenter> implements
        UsageDialogContract.View,
        CircularRevealAnim.AnimListener,
        ViewTreeObserver.OnPreDrawListener {

    @Override
    protected int getLayout() {
        return R.layout.fragment_usage;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showUsefulSites(List<UsefulSiteData> usefulSiteDataList) {

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

    @Override
    public void onHideAnimationEnd() {

    }

    @Override
    public void onShowAnimationEnd() {

    }

    @Override
    public boolean onPreDraw() {
        return false;
    }
}
