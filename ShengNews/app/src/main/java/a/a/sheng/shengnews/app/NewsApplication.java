package a.a.sheng.shengnews.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import a.a.sheng.shengnews.core.dao.DaoMaster;
import a.a.sheng.shengnews.core.dao.DaoSession;
import a.a.sheng.shengnews.di.component.AppComponent;
import a.a.sheng.shengnews.di.component.DaggerAppComponent;
import a.a.sheng.shengnews.di.module.AppModule;
import a.a.sheng.shengnews.di.module.HttpModule;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class NewsApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    private static NewsApplication instance;
    private RefWatcher refWatcher;
    public static boolean isFirstRun = true;
    private DaoSession mDaoSession;
    private static volatile AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
        instance = this;
        initGreenDao();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build();

        appComponent.inject(this);

    }

    public static synchronized NewsApplication getInstance() {
        return instance;
    }

    public static RefWatcher getRefWatcher(Context context) {
        NewsApplication application = (NewsApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
