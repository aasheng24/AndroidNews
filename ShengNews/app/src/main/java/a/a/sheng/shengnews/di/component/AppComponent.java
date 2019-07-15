package a.a.sheng.shengnews.di.component;

import javax.inject.Singleton;

import a.a.sheng.shengnews.app.NewsApplication;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.di.module.AbstractAllActivityModule;
import a.a.sheng.shengnews.di.module.AbstractAllDialogFragmentModule;
import a.a.sheng.shengnews.di.module.AbstractAllFragmentModule;
import a.a.sheng.shengnews.di.module.AppModule;
import a.a.sheng.shengnews.di.module.HttpModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component (modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AbstractAllFragmentModule.class,
        AbstractAllDialogFragmentModule.class,
        AppModule.class,
        HttpModule.class})
public interface AppComponent {
    /**
     * NewsApplication
     *
     * @param NewsApplication NewsApplication
     */
    void inject(NewsApplication newsApplication);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    NewsApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
