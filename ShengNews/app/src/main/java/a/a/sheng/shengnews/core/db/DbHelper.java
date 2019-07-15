package a.a.sheng.shengnews.core.db;

import java.util.List;

import a.a.sheng.shengnews.core.dao.HistoryData;

public interface DbHelper {
    /**
     * 增加历史数据
     *
     * @param data  added string
     * @return  List<HistoryData>
     */
    List<HistoryData> addHistoryData(String data);

    /**
     * Clear search history data
     */
    void clearHistoryData();

    /**
     * Load all history data
     *
     * @return List<HistoryData>
     */
    List<HistoryData> loadAllHistoryData();
}
