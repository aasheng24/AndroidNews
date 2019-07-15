package a.a.sheng.shengnews.ui.main.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import a.a.sheng.shengnews.core.dao.HistoryData;
import a.a.sheng.shengnews.ui.main.viewholder.SearchHistoryViewHolder;

public class HistorySearchAdapter extends BaseQuickAdapter<HistoryData, SearchHistoryViewHolder> {

    public HistorySearchAdapter(int layoutResId, @Nullable List<HistoryData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(SearchHistoryViewHolder helper, HistoryData item) {

    }
}
