package a.a.sheng.shengnews.contract.hierarchy;

import java.util.List;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.hierarchy.KnowledgeHierarchyData;

public interface KnowLedgeHierarchyContract {

    interface View extends AbstractView {
        void showKnowLedgeHierarchyData(List<KnowledgeHierarchyData> knowledgeHierarchyDataList);
    }

    interface Presenter extends AbstractPresenter<View> {
        void getKnowledgeHierarchyData(boolean isShowError);
    }
}
