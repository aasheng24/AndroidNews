package a.a.sheng.shengnews.contract.navigation;

import java.util.List;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.navigation.NavigationListData;

public interface NavigationContract {
    interface View extends AbstractView {

        /**
         * Show navigation list data
         *
         * @param navigationDataList List<NavigationListData>
         */
        void showNavigationListData(List<NavigationListData> navigationDataList);

    }

    interface Presenter extends AbstractPresenter<View> {

        /**
         * Get navigation list data
         *
         * @param isShowError If show error
         */
        void getNavigationListData(boolean isShowError);
    }

}
