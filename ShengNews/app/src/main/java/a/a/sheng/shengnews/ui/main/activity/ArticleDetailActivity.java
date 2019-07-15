package a.a.sheng.shengnews.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.contract.main.ArticleDetailContract;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.presenter.main.ArticleDetailPresenter;
import a.a.sheng.shengnews.utils.StatusBarUtil;
import butterknife.BindView;

public class ArticleDetailActivity extends BaseActivity<ArticleDetailPresenter> implements ArticleDetailContract.View {

    @BindView(R.id.article_detail_toolbar)
    Toolbar articleDetailToolbar;
    @BindView(R.id.article_detail_web_view)
    FrameLayout articleDetailWebView;
    @BindView(R.id.article_detail_group)
    LinearLayout articleDetailGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initToolbar() {
        getBundle();
        articleDetailToolbar.setTitle(title);
        setSupportActionBar(articleDetailToolbar);
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this,articleDetailToolbar);
        articleDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private Bundle bundle;
    private String articleUrl;
    private String title;

    private void getBundle() {
        bundle = getIntent().getExtras();
        articleUrl = bundle.getString(Constants.ARTICLE_LINK);
        title = bundle.getString(Constants.ARTICLE_TITLE);
    }

    private AgentWeb agentWeb;

    @Override
    protected void initEventAndData() {
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(articleDetailWebView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setMainFrameErrorView(R.layout.webview_error_view, -1)
                .createAgentWeb()
                .ready()
                .go(articleUrl);
        WebView webView = agentWeb.getWebCreator().getWebView();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        //不显示缩放按钮
        settings.setDisplayZoomControls(false);
        //设置自适应屏幕，两者合用
        //将图片调整到适合WebView的大小
        settings.setUseWideViewPort(true);
        //缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    public void showCollectArticleData(FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(FeedArticleListData feedArticleListData) {

    }

    @Override
    public void shareEvent() {

    }

    @Override
    public void shareError() {

    }

    @Override
    public void useNightMode(boolean isNightMode) {

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
}
