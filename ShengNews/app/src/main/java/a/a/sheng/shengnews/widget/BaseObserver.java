package a.a.sheng.shengnews.widget;

import android.text.TextUtils;

import a.a.sheng.shengnews.R;
import a.a.sheng.shengnews.base.view.AbstractView;
import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends ResourceObserver<T> {
    private AbstractView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(AbstractView view){
        this.mView = view;
    }

    protected BaseObserver(AbstractView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(AbstractView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(AbstractView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
    }
}
