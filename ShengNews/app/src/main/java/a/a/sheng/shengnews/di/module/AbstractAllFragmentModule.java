package a.a.sheng.shengnews.di.module;

import a.a.sheng.shengnews.di.component.BaseFragmentComponent;
import a.a.sheng.shengnews.ui.hierarchy.fragment.KnowledgeHierarchyFragment;
import a.a.sheng.shengnews.ui.hierarchy.fragment.KnowledgeHierarchyListFragment;
import a.a.sheng.shengnews.ui.main.fragment.CollectFragment;
import a.a.sheng.shengnews.ui.main.fragment.SettingFragment;
import a.a.sheng.shengnews.ui.mainpaper.MainPagerFragment;
import a.a.sheng.shengnews.ui.navigation.NavigationFragment;
import a.a.sheng.shengnews.ui.project.fragment.ProjectFragment;
import a.a.sheng.shengnews.ui.project.fragment.ProjectListFragment;
import a.a.sheng.shengnews.ui.wx.WxArticleFragment;
import a.a.sheng.shengnews.ui.wx.WxDetailArticleFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = CollectFragmentModule.class)
    abstract CollectFragment contributesCollectFragmentInject();

    @ContributesAndroidInjector(modules = KnowledgeFragmentModule.class)
    abstract KnowledgeHierarchyFragment contributesKnowledgeHierarchyFragmentInject();

    @ContributesAndroidInjector(modules = KnowledgeListFragmentModule.class)
    abstract KnowledgeHierarchyListFragment contributesKnowledgeHierarchyListFragmentInject();

    @ContributesAndroidInjector(modules = MainPagerFragmentModule.class)
    abstract MainPagerFragment contributesMainPagerFragmentInject();

    @ContributesAndroidInjector(modules = NavigationFragmentModule.class)
    abstract NavigationFragment contributesNavigationFragmentInject();

    @ContributesAndroidInjector(modules = WxArticleFragmentModule.class)
    abstract WxArticleFragment contributesWxArticleFragmentInject();

    @ContributesAndroidInjector(modules = WxDetailArticleFragmentModule.class)
    abstract WxDetailArticleFragment WxDetailArticleFragmentInject();

    @ContributesAndroidInjector(modules = ProjectFragmentModule.class)
    abstract ProjectFragment contributesProjectFragmentInject();

    @ContributesAndroidInjector(modules = ProjectListFragmentModule.class)
    abstract ProjectListFragment contributesProjectListFragmentInject();

    @ContributesAndroidInjector(modules = SettingFragmentModule.class)
    abstract SettingFragment contributesSettingFragmentInject();

}