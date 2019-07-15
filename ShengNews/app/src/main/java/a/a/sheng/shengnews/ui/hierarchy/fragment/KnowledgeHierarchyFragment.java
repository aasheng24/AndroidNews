package a.a.sheng.shengnews.ui.hierarchy.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.fragment.BaseRootFragment;
import a.a.sheng.shengnews.contract.hierarchy.KnowLedgeHierarchyContract;
import a.a.sheng.shengnews.core.bean.hierarchy.KnowledgeHierarchyData;
import a.a.sheng.shengnews.presenter.hierarchy.KnowledgeHierarchyPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class KnowledgeHierarchyFragment extends BaseRootFragment<KnowledgeHierarchyPresenter>
        implements KnowLedgeHierarchyContract.View {

    @BindView(R.id.knowledge_hierarchy_recycler_view)
    RecyclerView knowledgeHierarchyRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;
    Unbinder unbinder;

    public static KnowledgeHierarchyFragment getInstance(String param1, String param2) {
        KnowledgeHierarchyFragment fragment = new KnowledgeHierarchyFragment();
        Bundle args = new Bundle();
        args.putString(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void jumpToTheTop() {
        if (knowledgeHierarchyRecyclerView != null) {
            knowledgeHierarchyRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Override
    public void showKnowLedgeHierarchyData(List<KnowledgeHierarchyData> knowledgeHierarchyDataList) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge_hierarchy;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
