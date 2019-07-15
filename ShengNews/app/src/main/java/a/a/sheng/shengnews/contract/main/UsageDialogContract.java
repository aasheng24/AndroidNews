package a.a.sheng.shengnews.contract.main;

import java.util.List;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.main.search.UsefulSiteData;

public class UsageDialogContract {
    public interface View extends AbstractView {

        /**
         * Show useful sites
         *
         * @param usefulSiteDataList List<UsefulSiteData>
         */
        void showUsefulSites(List<UsefulSiteData> usefulSiteDataList);
    }

    public interface Presenter extends AbstractPresenter<View> {

        /**
         * 常用网站
         */
        void getUsefulSites();
    }
}
