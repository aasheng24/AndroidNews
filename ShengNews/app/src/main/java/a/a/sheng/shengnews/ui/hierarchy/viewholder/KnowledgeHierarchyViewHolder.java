package a.a.sheng.shengnews.ui.hierarchy.viewholder;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

import a.a.sheng.shengnews.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowledgeHierarchyViewHolder extends BaseViewHolder {

    @BindView(R.id.item_knowledge_hierarchy_title)
    TextView mTitle;
    @BindView(R.id.item_knowledge_hierarchy_content)
    TextView mContent;

    public KnowledgeHierarchyViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}