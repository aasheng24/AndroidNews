package a.a.sheng.shengnews.contract.wx;

import java.util.List;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;
import a.a.sheng.shengnews.core.bean.wx.WxAuthor;

public interface WxContract {
    interface View extends AbstractView {

        /**
         * 显示公众号作者列表
         *
         * @param wxAuthors 公众号作者列表
         */
        void showWxAuthorListView(List<WxAuthor> wxAuthors);


    }

    interface Presenter extends AbstractPresenter<View> {

        /**
         * 获取公众号作者列表
         */
        void getWxAuthorListData();

    }
}
