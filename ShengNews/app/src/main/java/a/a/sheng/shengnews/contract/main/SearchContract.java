package a.a.sheng.shengnews.contract.main;

import java.util.List;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.main.search.TopSearchData;
import a.a.sheng.shengnews.core.dao.HistoryData;

public interface SearchContract {
    interface View extends AbstractView {

        /**
         * Show history data
         *
         * @param historyDataList List<HistoryData>
         */
        void showHistoryData(List<HistoryData> historyDataList);

        /**
         * Show top search data
         *
         * @param topSearchDataList List<TopSearchData>
         */
        void showTopSearchData(List<TopSearchData> topSearchDataList);

        /**
         * Judge to the search list activity
         */
        void judgeToTheSearchListActivity();

    }

    interface Presenter extends AbstractPresenter<View> {

        /**
         * Load all history data
         *
         * @return all history data
         */
        List<HistoryData> loadAllHistoryData();

        /**
         * Add history data
         *
         * @param data history data
         */
        void addHistoryData(String data);

        /**
         * 热搜
         */
        void getTopSearchData();

        /**
         * Clear history data
         */
        void clearHistoryData();
    }
}
