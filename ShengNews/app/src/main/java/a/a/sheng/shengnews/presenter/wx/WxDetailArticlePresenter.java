package a.a.sheng.shengnews.presenter.wx;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.wx.WxDetailContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class WxDetailArticlePresenter extends BasePresenter<WxDetailContract.View>
        implements WxDetailContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public WxDetailArticlePresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getWxSearchSumData(int id, int page, String k) {

    }

    @Override
    public void getWxDetailData(int id, int page, boolean isShowError) {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }
}
