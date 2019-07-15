package a.a.sheng.shengnews.base.activity;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import a.a.sheng.shengnews.component.ActivityCollector;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class AbstractSimpleActivity extends SupportActivity {
    private Unbinder unbinder;
    protected AbstractSimpleActivity mActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityCollector.getInstance().addActivity(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
            unbinder = null;
        }

    }

    protected abstract void onViewCreated();

    protected abstract int getLayoutId();

    protected abstract void initToolbar();

    protected abstract void initEventAndData();
}
