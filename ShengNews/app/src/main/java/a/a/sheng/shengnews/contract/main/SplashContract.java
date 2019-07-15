package a.a.sheng.shengnews.contract.main;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;

public class SplashContract {
    public interface View extends AbstractView {
        /**
         * after some time jump to main page
         */
        void jumpToMain();
    }

    public interface Presenter extends AbstractPresenter<View> {

    }
}
