package a.a.sheng.shengnews.ui.wx;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.wx.WxDetailContract;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.presenter.wx.WxDetailArticlePresenter;

public class WxDetailArticleFragment extends BaseRootFragment<WxDetailArticlePresenter>
        implements WxDetailContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wx_detail_article;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showWxSearchView(FeedArticleListData wxSearchData) {

    }

    @Override
    public void showWxDetailView(FeedArticleListData wxSumData) {

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
