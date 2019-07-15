package a.a.sheng.shengnews.presenter.main;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.SplashContract;
import a.a.sheng.shengnews.core.DataManager;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(SplashContract.View view) {
        super.attachView(view);
        long splashTime = 2000;
        addSubScribe(io.reactivex.Observable.timer(splashTime,TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(aLong -> view.jumpToMain()));
    }
}
