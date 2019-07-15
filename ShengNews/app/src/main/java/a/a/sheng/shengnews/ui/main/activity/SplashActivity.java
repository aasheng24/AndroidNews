package a.a.sheng.shengnews.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.app.NewsApplication;
import a.a.sheng.shengnews.base.activity.BaseActivity;
import a.a.sheng.shengnews.contract.main.SplashContract;
import a.a.sheng.shengnews.presenter.main.SplashPresenter;
import a.a.sheng.shengnews.utils.StatusBarUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    private static final String TAG = "SplashActivity";

    @BindView(R.id.one_animation)
    LottieAnimationView oneAnimation;
    @BindView(R.id.two_animation)
    LottieAnimationView twoAnimation;
    @BindView(R.id.three_animation)
    LottieAnimationView threeAnimation;
    @BindView(R.id.four_animation)
    LottieAnimationView fourAnimation;
    @BindView(R.id.five_animation)
    LottieAnimationView fiveAnimation;
    @BindView(R.id.six_animation)
    LottieAnimationView sixAnimation;
    @BindView(R.id.seven_animation)
    LottieAnimationView sevenAnimation;
    @BindView(R.id.eight_animation)
    LottieAnimationView eightAnimation;
    @BindView(R.id.nine_animation)
    LottieAnimationView nineAnimation;
    @BindView(R.id.ten_animation)
    LottieAnimationView tenAnimation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {
        Log.i(TAG, "initToolbar");
        if (!NewsApplication.isFirstRun) {
            jumpToMain();
            return;
        }
        NewsApplication.isFirstRun = false;
        StatusBarUtil.immersive(this);
    }

    @Override
    protected void initEventAndData() {
        startAnimation(oneAnimation, "W.json");
        startAnimation(twoAnimation, "A.json");
        startAnimation(threeAnimation, "N.json");
        startAnimation(fourAnimation, "A.json");
        startAnimation(fiveAnimation, "N.json");
        startAnimation(sixAnimation, "D.json");
        startAnimation(sevenAnimation, "R.json");
        startAnimation(eightAnimation, "I.json");
        startAnimation(nineAnimation, "O.json");
        startAnimation(tenAnimation, "D.json");
    }

    @Override
    public void jumpToMain() {
        Log.i(TAG, "jumpToMain");
        startActivity(new Intent(this,MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        cancelAnimation();
        super.onDestroy();
    }

    private void cancelAnimation() {
        cancelAnimation(oneAnimation);
        cancelAnimation(twoAnimation);
        cancelAnimation(threeAnimation);
        cancelAnimation(fourAnimation);
        cancelAnimation(fiveAnimation);
        cancelAnimation(sixAnimation);
        cancelAnimation(sevenAnimation);
        cancelAnimation(eightAnimation);
        cancelAnimation(nineAnimation);
        cancelAnimation(tenAnimation);
    }

    private void startAnimation(LottieAnimationView lottieAnimationView, String name) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(name);
            lottieAnimationView.playAnimation();
        }
    }

    private void cancelAnimation(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
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
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }
}
