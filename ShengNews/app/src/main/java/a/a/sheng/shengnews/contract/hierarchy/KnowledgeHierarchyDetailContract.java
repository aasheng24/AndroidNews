package a.a.sheng.shengnews.contract.hierarchy;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;

public interface KnowledgeHierarchyDetailContract {
    interface View extends AbstractView {
        void showSwitchProject();
        void showSwitchNavigation();
    }

    interface Presenter extends AbstractPresenter<View>{

    }
}
