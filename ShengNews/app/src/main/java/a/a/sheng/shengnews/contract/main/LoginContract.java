package a.a.sheng.shengnews.contract.main;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;

public interface LoginContract {
    interface View extends AbstractView {

        /**
         * Show login data
         *
         */
        void showLoginSuccess();
    }

    interface Presenter extends AbstractPresenter<View> {

        /**
         * Get Login data
         *
         * @param username user name
         * @param password password
         */
        void getLoginData(String username, String password);
    }
}
