package a.a.sheng.shengnews.presenter.main;

import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.ArticleDetailContract;
import a.a.sheng.shengnews.core.DataManager;

public class ArticleDetailPresenter extends BasePresenter<ArticleDetailContract.View>
        implements ArticleDetailContract.Presenter{

    private DataManager mDataManager;

    @Inject
    ArticleDetailPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public boolean getAutoCacheState() {
        return false;
    }

    @Override
    public boolean getNoImageState() {
        return false;
    }

    @Override
    public void addCollectArticle(int id) {

    }

    @Override
    public void cancelCollectArticle(int id) {

    }

    @Override
    public void cancelCollectPageArticle(int id) {

    }

    @Override
    public void shareEventPermissionVerify(RxPermissions rxPermissions) {

    }
}
