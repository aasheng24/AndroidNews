package a.a.sheng.shengnews.ui.hierarchy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import a.a.sheng.shengnews.core.bean.hierarchy.KnowledgeHierarchyData;
import a.a.sheng.shengnews.ui.hierarchy.viewholder.KnowledgeHierarchyViewHolder;

public class KnowledgeHierarchyAdapter extends BaseQuickAdapter<KnowledgeHierarchyData, KnowledgeHierarchyViewHolder> {

    public KnowledgeHierarchyAdapter(int layoutResId, @Nullable List<KnowledgeHierarchyData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(KnowledgeHierarchyViewHolder helper, KnowledgeHierarchyData item) {

    }
}
