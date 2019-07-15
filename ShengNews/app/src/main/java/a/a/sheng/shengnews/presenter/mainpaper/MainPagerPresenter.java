package a.a.sheng.shengnews.presenter.mainpaper;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.app.NewsApplication;
import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.mainpaper.MainPagerContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.BaseResponse;
import a.a.sheng.shengnews.core.bean.main.banner.BannerData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.core.bean.main.login.LoginData;
import a.a.sheng.shengnews.utils.CommonUtils;
import a.a.sheng.shengnews.utils.RxUtils;
import a.a.sheng.shengnews.widget.BaseObserver;
import io.reactivex.Observable;

public class MainPagerPresenter extends BasePresenter<MainPagerContract.View>
        implements MainPagerContract.Presenter{

    private final String TAG = "MainPagerPresenter";

    private DataManager mDataManager;
    private boolean isRefresh = true;
    private int mCurrentPage;

    @Inject
    MainPagerPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainPagerContract.View view) {
        super.attachView(view);
        regitsterEvent();
    }

    private void regitsterEvent() {

    }

    @Override
    public String getLoginAccount() {
        return super.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public void loadMainPagerData() {
        Log.i(TAG,"loadMainPagerData");
        Observable<BaseResponse<LoginData>> loginObservable = mDataManager.getLoginData(getLoginAccount(), getLoginPassword());
        Observable<BaseResponse<List<BannerData>>> bannerObservable = mDataManager.getBannerData();
        Observable<BaseResponse<FeedArticleListData>> articleObservable = mDataManager.getFeedArticleList(0);
        addSubScribe(Observable.zip(loginObservable, bannerObservable, articleObservable,this::createResponseMap)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObserver<HashMap<String, Object>>(mView){
                    @Override
                    public void onNext(HashMap<String, Object> stringObjectHashMap) {
                        BaseResponse<LoginData> loginResponse = CommonUtils.cast(stringObjectHashMap.get(Constants.LOGIN_DATA));
                        if (loginResponse.getErrorCode() == BaseResponse.SUCCESS) {

                        } else {}

                        BaseResponse<List<BannerData>> bannerResponse = CommonUtils.cast(stringObjectHashMap.get(Constants.BANNER_DATA));
                        if (bannerResponse != null) {

                        } else {}

                        BaseResponse<FeedArticleListData> articleResponse = CommonUtils.cast(stringObjectHashMap.get(Constants.ARTICLE_DATA));
                        if (articleResponse != null) {
                            mView.showArticleList(articleResponse.getData(), isRefresh);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showAutoLoginFail();
                    }
                }));

    }

    @NonNull
    private HashMap<String, Object> createResponseMap(BaseResponse<LoginData> loginResponse,
                                                      BaseResponse<List<BannerData>> bannerResponse,
                                                      BaseResponse<FeedArticleListData> feedArticleListResponse) {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put(Constants.LOGIN_DATA, loginResponse);
        map.put(Constants.BANNER_DATA, bannerResponse);
        map.put(Constants.ARTICLE_DATA, feedArticleListResponse);
        return map;
    }

    @Override
    public void getFeedArticleList(boolean isShowError) {
        addSubScribe(mDataManager.getFeedArticleList(mCurrentPage)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .filter(feedArticleListResponse -> mView != null)
                .subscribeWith(new BaseObserver<FeedArticleListData>(mView,
                        NewsApplication.getInstance().getString(R.string.failed_to_obtain_article_list),
                        isShowError) {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        mView.showArticleList(feedArticleListData, isRefresh);
                    }
                }));

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void getBannerData(boolean isShowError) {
        addSubScribe(mDataManager.getBannerData()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<List<BannerData>>(mView,
                        NewsApplication.getInstance().getString(R.string.failed_to_obtain_banner_data), isShowError) {
                    @Override
                    public void onNext(List<BannerData> bannerData) {
                        mView.showBannerData(bannerData);
                    }
                }));
    }

    @Override
    public void autoRefresh(boolean isShowError) {
        isRefresh = true;
        mCurrentPage = 0;
        getBannerData(isShowError);
        getFeedArticleList(isShowError);
    }

    @Override
    public void loadMore() {

    }
}
