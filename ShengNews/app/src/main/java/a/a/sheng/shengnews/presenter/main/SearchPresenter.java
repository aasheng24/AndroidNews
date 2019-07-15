package a.a.sheng.shengnews.presenter.main;

import java.util.List;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.BasePresenter;
import a.a.sheng.shengnews.contract.main.SearchContract;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.dao.HistoryData;

public class SearchPresenter extends BasePresenter<SearchContract.View>
        implements SearchContract.Presenter{

    private DataManager mDataManager;

    @Inject
    SearchPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return null;
    }

    @Override
    public void addHistoryData(String data) {

    }

    @Override
    public void getTopSearchData() {

    }

    @Override
    public void clearHistoryData() {

    }
}
