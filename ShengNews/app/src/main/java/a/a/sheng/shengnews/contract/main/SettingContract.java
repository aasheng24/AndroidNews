package a.a.sheng.shengnews.contract.main;

import a.a.sheng.shengnews.base.presenter.AbstractPresenter;
import a.a.sheng.shengnews.base.view.AbstractView;

public class SettingContract {
    public interface View extends AbstractView {


    }

    public interface Presenter extends AbstractPresenter<View> {

        /**
         * Get auto cache state
         *
         * @return if auto cache state
         */
        boolean getAutoCacheState();

        /**
         * Get no image state
         *
         * @return if has image state
         */
        boolean getNoImageState();

        /**
         * Set night mode state
         *
         * @param b current night mode state
         */
        void setNightModeState(boolean b);

        /**
         * Set no image state
         *
         * @param b current no image state
         */
        void setNoImageState(boolean b);

        /**
         * Set auto cache state
         *
         * @param b current auto cache state
         */
        void setAutoCacheState(boolean b);
    }
}
