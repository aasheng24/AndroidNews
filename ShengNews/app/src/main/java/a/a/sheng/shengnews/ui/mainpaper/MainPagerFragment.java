package a.a.sheng.shengnews.ui.mainpaper;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.mainpaper.MainPagerContract;
import a.a.sheng.shengnews.core.bean.main.banner.BannerData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.presenter.mainpaper.MainPagerPresenter;
import a.a.sheng.shengnews.utils.CommonUtils;
import a.a.sheng.shengnews.utils.GlideImageLoader;
import a.a.sheng.shengnews.utils.JudgeUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainPagerFragment extends BaseRootFragment<MainPagerPresenter>
        implements MainPagerContract.View {

    private final String TAG = "MainPagerFragment";

    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mainPagerRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;
    Unbinder unbinder;

    private List<FeedArticleData> mFeedArticleDataList;
    private ArticleListAdapter mAdapter;

    private int articlePosition;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;
    private Banner mBanner;
    private boolean isRecreate;

    public static MainPagerFragment getInstance(boolean param1, String param2) {
        MainPagerFragment fragment = new MainPagerFragment();
        Bundle args = new Bundle();
        args.putBoolean(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        Log.i(TAG,"getLayoutId");
        return R.layout.fragment_main_pager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        isRecreate = getArguments().getBoolean(Constants.ARG_PARAM1);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
    }

    @Override
    protected void initView() {
        super.initView();
        initRecyclerView();
    }

    private boolean loggedAndNotRebuilt() {
        return !TextUtils.isEmpty(mPresenter.getLoginAccount())
                && !TextUtils.isEmpty(mPresenter.getLoginPassword())
                && !isRecreate;
    }

    private void initRecyclerView() {
        Log.i(TAG,"initRecyclerView");
        mFeedArticleDataList = new ArrayList<>();
        mAdapter = new ArticleListAdapter(R.layout.item_search_pager, mFeedArticleDataList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> startArticleDetailPager(view, position));
        mAdapter.setOnItemChildClickListener((adapter, view, position) -> clickChildEvent(view, position));
        mainPagerRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mainPagerRecyclerView.setHasFixedSize(true);
        //add head banner
        LinearLayout mHeaderGroup = ((LinearLayout) LayoutInflater.from(_mActivity).inflate(R.layout.head_banner, null));
        mBanner = mHeaderGroup.findViewById(R.id.head_banner);
        mHeaderGroup.removeView(mBanner);
        mAdapter.addHeaderView(mBanner);
        mainPagerRecyclerView.setAdapter(mAdapter);
    }

    private void clickChildEvent(View view, int position) {
        switch (view.getId()) {
            case R.id.item_search_pager_chapterName:
                //startSingleChapterKnowledgePager(position);
                break;
            case R.id.item_search_pager_like_iv:
                //likeEvent(position);
                break;
            case R.id.item_search_pager_tag_red_tv:
                //clickTag(position);
                break;
            default:
                break;
        }
    }


    private void startArticleDetailPager(View view, int position) {
        if (mAdapter.getData().size() <= 0 || mAdapter.getData().size() < position) {
            return;
        }
        //记录点击的文章位置，便于在文章内点击收藏返回到此界面时能展示正确的收藏状态
        articlePosition = position;
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(_mActivity, view, getString(R.string.share_view));
        JudgeUtils.startArticleDetailActivity(_mActivity,
                options,
                mAdapter.getData().get(position).getId(),
                mAdapter.getData().get(position).getTitle(),
                mAdapter.getData().get(position).getLink(),
                mAdapter.getData().get(position).isCollect(),
                false,
                false);
    }

    @Override
    protected void initEventAndData() {
        Log.i(TAG,"initEventAndData");
        super.initEventAndData();
        setRefresh();
        if (loggedAndNotRebuilt()) {
            mPresenter.loadMainPagerData();
        } else {
            mPresenter.autoRefresh(true);
        }
        if (CommonUtils.isNetworkConnected()) {
            showLoading();
        }
    }

    private void setRefresh() {
        normalView.setOnRefreshListener(refreshLayout -> {
            mPresenter.autoRefresh(false);
            refreshLayout.finishRefresh(1000);
        });
        normalView.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore();
            refreshLayout.finishLoadMore(1000);
        });
    }

    public void jumpToTheTop() {
        if (mainPagerRecyclerView != null) {
            mainPagerRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Override
    public void showAutoLoginSuccess() {

    }

    @Override
    public void showAutoLoginFail() {

    }

    @Override
    public void showArticleList(FeedArticleListData feedArticleListData, boolean isRefresh) {
        if (mPresenter.getCurrentPage() == Constants.TYPE_MAIN_PAGER) {
            mainPagerRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mainPagerRecyclerView.setVisibility(View.INVISIBLE);
        }
        if (mAdapter == null) {
            return;
        }
        if (isRefresh) {
            mFeedArticleDataList = feedArticleListData.getDatas();
            mAdapter.replaceData(feedArticleListData.getDatas());
        } else {
            mFeedArticleDataList.addAll(feedArticleListData.getDatas());
            mAdapter.addData(feedArticleListData.getDatas());
        }
        showNormal();
    }

    @Override
    public void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showBannerData(List<BannerData> bannerDataList) {
        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (BannerData bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            bannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());

            mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
            mBanner.setImageLoader(new GlideImageLoader());
            mBanner.setImages(bannerImageList);
            mBanner.setBannerAnimation(Transformer.DepthPage);
            //设置标题集合（当banner样式有显示title时）
            mBanner.setBannerTitles(mBannerTitleList);
            //设置自动轮播，默认为true
            mBanner.isAutoPlay(true);
            //设置轮播时间
            mBanner.setDelayTime(bannerDataList.size() * 400);
            //设置指示器位置（当banner模式中有指示器时）
            mBanner.setIndicatorGravity(BannerConfig.CENTER);
            mBanner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int i) {
                    JudgeUtils.startArticleDetailActivity(_mActivity, null,
                            0, mBannerTitleList.get(i), mBannerUrlList.get(i),
                            false, false, true);
                }
            });
            mBanner.start();


        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
