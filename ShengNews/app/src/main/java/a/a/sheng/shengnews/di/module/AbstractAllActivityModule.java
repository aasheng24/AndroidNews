package a.a.sheng.shengnews.di.module;

import a.a.sheng.shengnews.di.component.BaseActivityComponent;
import a.a.sheng.shengnews.ui.hierarchy.activity.KnowledgeHierarchyDetailActivity;
import a.a.sheng.shengnews.ui.main.activity.AboutUsActivity;
import a.a.sheng.shengnews.ui.main.activity.ArticleDetailActivity;
import a.a.sheng.shengnews.ui.main.activity.LoginActivity;
import a.a.sheng.shengnews.ui.main.activity.MainActivity;
import a.a.sheng.shengnews.ui.main.activity.RegisterActivity;
import a.a.sheng.shengnews.ui.main.activity.SearchListActivity;
import a.a.sheng.shengnews.ui.main.activity.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity contributesSplashActivityInjector();

    @ContributesAndroidInjector(modules = ArticleDetailActivityModule.class)
    abstract ArticleDetailActivity contributesArticleDetailActivityInjector();

    @ContributesAndroidInjector(modules = KnowledgeHierarchyDetailActivityModule.class)
    abstract KnowledgeHierarchyDetailActivity contributesKnowledgeHierarchyDetailActivityInjector();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributesLoginActivityInjector();

    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributesRegisterActivityInjector();

    @ContributesAndroidInjector(modules = AboutUsActivityModule.class)
    abstract AboutUsActivity contributesAboutUsActivityInjector();

    @ContributesAndroidInjector(modules = SearchListActivityModule.class)
    abstract SearchListActivity contributesSearchListActivityInjector();


}
