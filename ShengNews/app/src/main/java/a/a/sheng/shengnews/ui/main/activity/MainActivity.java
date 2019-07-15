package a.a.sheng.shengnews.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.squareup.haha.perflib.Main;

import java.lang.reflect.Field;
import java.util.ArrayList;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.Constants;
import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.base.fragment.BaseFragment;
import a.a.sheng.shengnews.contract.main.MainContract;
import a.a.sheng.shengnews.presenter.main.MainPresenter;
import a.a.sheng.shengnews.ui.hierarchy.fragment.KnowledgeHierarchyFragment;
import a.a.sheng.shengnews.ui.main.fragment.CollectFragment;
import a.a.sheng.shengnews.ui.main.fragment.SearchDialogFragment;
import a.a.sheng.shengnews.ui.main.fragment.SettingFragment;
import a.a.sheng.shengnews.ui.main.fragment.UsageDialogFragment;
import a.a.sheng.shengnews.ui.mainpaper.MainPagerFragment;
import a.a.sheng.shengnews.ui.navigation.NavigationFragment;
import a.a.sheng.shengnews.ui.project.fragment.ProjectFragment;
import a.a.sheng.shengnews.ui.wx.WxArticleFragment;
import a.a.sheng.shengnews.utils.CommonUtils;
import a.a.sheng.shengnews.utils.StatusBarUtil;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter>
        implements MainContract.View {
    private static final String TAG = "MainActivity";

    @BindView(R.id.common_toolbar_title_tv)
    TextView commonToolbarTitleTv;
    @BindView(R.id.common_toolbar)
    Toolbar commonToolbar;
    @BindView(R.id.fragment_group)
    FrameLayout fragmentGroup;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mainFloatingActionBtn;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ArrayList<BaseFragment> mFragments;
    private TextView mUsTv;
    private MainPagerFragment mainPagerFragment;
    private KnowledgeHierarchyFragment knowledgeHierarchyFragment;
    private WxArticleFragment wxArticleFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    private int lastFgIndex;
    private UsageDialogFragment usageDialogFragment;
    private SearchDialogFragment searchDialogFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(commonToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        commonToolbarTitleTv.setText(getString(R.string.home_pager));
        StatusBarUtil.setStatusColor(getWindow(),ContextCompat.getColor(this,R.color.main_status_bar_blue),1f);
        commonToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        if (savedInstanceState == null) {
            mPresenter.setNightModeState(false);
            initPaper(false, Constants.TYPE_MAIN_PAGER);
        } else {
            bottomNavigationView.setSelectedItemId(R.id.tab_main_pager);
            initPaper(true,Constants.TYPE_SETTING);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initPaper(boolean isRecreat, int position) {
        Log.i(TAG,"initPaper with position: "+position);
        mainPagerFragment = MainPagerFragment.getInstance(isRecreat, null);
        mFragments.add(mainPagerFragment);
        initFragments();
        init();
        switchFragment(position);
    }

    private void init() {
        mPresenter.setCurrentPage(Constants.TYPE_MAIN_PAGER);
        initBottomNavigationView();
        initNavigationView();
        initDrawerLayout();
    }

    private void initFragments() {
        knowledgeHierarchyFragment  = KnowledgeHierarchyFragment.getInstance(null, null);
        wxArticleFragment = WxArticleFragment.getInstance(null, null);
        navigationFragment = NavigationFragment.getInstance(null, null);
        projectFragment = ProjectFragment.getInstance(null, null);
        CollectFragment collectFragment = CollectFragment.getInstance(null, null);
        SettingFragment settingFragment = SettingFragment.getInstance(null, null);

        mFragments.add(knowledgeHierarchyFragment);
        mFragments.add(wxArticleFragment);
        mFragments.add(navigationFragment);
        mFragments.add(projectFragment);
        mFragments.add(collectFragment);
        mFragments.add(settingFragment);
    }

    private void switchFragment(int position) {
        if (position > Constants.TYPE_COLLECT) {
            mainFloatingActionBtn.setVisibility(View.INVISIBLE);
            bottomNavigationView.setVisibility(View.INVISIBLE);
        } else {
            mainFloatingActionBtn.setVisibility(View.VISIBLE);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
        if (position >= mFragments.size()) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(lastFgIndex);
        lastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commitAllowingStateLoss();
            ft.add(R.id.fragment_group, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();

    }

    private void initNavigationView() {
        mUsTv = navView.getHeaderView(0).findViewById(R.id.nav_header_login_tv);
        if (mPresenter.getLoginStatus()) {
            showLoginView();
        } else {
            showLogoutView();
        }
        navView.getMenu().findItem(R.id.nav_item_wan_android)
                .setOnMenuItemClickListener(item -> {
                    //startMainPager();
                    return true;
                });
        navView.getMenu().findItem(R.id.nav_item_my_collect)
                .setOnMenuItemClickListener(item -> {
                    if (mPresenter.getLoginStatus()) {
                        //startCollectFragment();
                        return true;
                    } else {
                        startActivity(new Intent(this, LoginActivity.class));
                        CommonUtils.showMessage(this, getString(R.string.login_tint));
                        return true;
                    }
                });
        navView.getMenu().findItem(R.id.nav_item_about_us)
                .setOnMenuItemClickListener(item -> {
                    startActivity(new Intent(this, AboutUsActivity.class));
                    return true;
                });
        navView.getMenu().findItem(R.id.nav_item_logout)
                .setOnMenuItemClickListener(item -> {
                    //logout();
                    return true;
                });
        navView.getMenu().findItem(R.id.nav_item_setting)
                .setOnMenuItemClickListener(item -> {
                    //startSettingFragment();
                    return true;
                });

    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, commonToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = drawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
    }

    private void initBottomNavigationView() {
        bottomNavigationView.setSelectedItemId(R.id.tab_main_pager);
        disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_main_pager:
                        loadPaper(getString(R.string.home_pager),0,mainPagerFragment,Constants.TYPE_MAIN_PAGER);
                        break;
                    case R.id.tab_knowledge_hierarchy:
                        loadPaper(getString(R.string.knowledge_hierarchy),1,knowledgeHierarchyFragment,Constants.TYPE_KNOWLEDGE);
                        break;
                    case R.id.tab_wx_article:
                        loadPaper(getString(R.string.wx_article),2,wxArticleFragment,Constants.TYPE_WX_ARTICLE);
                        break;
                    case R.id.tab_navigation:
                        loadPaper(getString(R.string.navigation),3,navigationFragment,Constants.TYPE_NAVIGATION);
                        break;
                    case R.id.tab_project:
                        loadPaper(getString(R.string.project),4,projectFragment,Constants.TYPE_PROJECT);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

    }

    private void disableShiftMode(BottomNavigationView bottomNavigationView) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                itemView.setShiftingMode(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }

        } catch (Exception e) {
            Log.e(TAG,"disableShiftMode error");
        }
    }

    private void loadPaper(String title, int position, BaseFragment fragment, int pagerType) {
        commonToolbarTitleTv.setText(title);
        switchFragment(position);
        fragment.reload();
        mPresenter.setCurrentPage(pagerType);
    }

    private void jumpToTheTop() {
        switch (mPresenter.getCurrentPage()) {
            case Constants.TYPE_MAIN_PAGER:
                if (mainPagerFragment != null) {
                    mainPagerFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_KNOWLEDGE:
                if (knowledgeHierarchyFragment != null) {
                    knowledgeHierarchyFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_WX_ARTICLE:
                if (wxArticleFragment != null) {
                    wxArticleFragment.jumpToTheTop();
                }
            case Constants.TYPE_NAVIGATION:
                if (navigationFragment != null) {
                    navigationFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_PROJECT:
                if (projectFragment != null) {
                    projectFragment.jumpToTheTop();
                }
                break;
            default:
                break;
        }
    }




    @Override
    public void showSwitchProject() {

    }

    @Override
    public void showSwitchNavigation() {

    }

    @Override
    public void showAutoLoginView() {

    }

    @Override
    public void showLogoutSuccess() {

    }

    @Override
    public void useNightMode(boolean isNightMode) {

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
}
