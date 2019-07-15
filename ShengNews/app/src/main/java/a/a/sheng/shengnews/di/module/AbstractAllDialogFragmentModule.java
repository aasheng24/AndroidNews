package a.a.sheng.shengnews.di.module;

import a.a.sheng.shengnews.di.component.BaseDialogFragmentComponent;
import a.a.sheng.shengnews.ui.main.fragment.SearchDialogFragment;
import a.a.sheng.shengnews.ui.main.fragment.UsageDialogFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseDialogFragmentComponent.class)
public abstract class AbstractAllDialogFragmentModule {

    @ContributesAndroidInjector(modules = SearchDialogFragmentModule.class)
    abstract SearchDialogFragment contributesSearchDialogFragmentInject();

    @ContributesAndroidInjector(modules = UsageDialogFragmentModule.class)
    abstract UsageDialogFragment contributesUsageDialogFragmentInject();

}
