package a.a.sheng.shengnews.di.module;

import javax.inject.Singleton;

import a.a.sheng.shengnews.app.NewsApplication;
import a.a.sheng.shengnews.core.DataManager;
import a.a.sheng.shengnews.core.db.DbHelper;
import a.a.sheng.shengnews.core.db.DbHelperImpl;
import a.a.sheng.shengnews.core.http.HttpHelper;
import a.a.sheng.shengnews.core.http.HttpHelperImpl;
import a.a.sheng.shengnews.core.prefs.PreferenceHelper;
import a.a.sheng.shengnews.core.prefs.PreferenceHelperImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final NewsApplication application;

    public AppModule(NewsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    NewsApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(DbHelperImpl realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }
}
