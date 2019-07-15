package a.a.sheng.shengnews.presenter.wx;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.wx.WxContract;
import a.a.sheng.shengnews.core.DataManager;

public class WxArticlePresenter extends BasePresenter<WxContract.View>
        implements WxContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public WxArticlePresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getWxAuthorListData() {

    }
}
