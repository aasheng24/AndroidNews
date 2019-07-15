package a.a.sheng.shengnews.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseDialogFragment<T extends AbstractPresenter> extends AbstractSimpleDialogFragment
        implements AbstractView {

    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
    }
}
