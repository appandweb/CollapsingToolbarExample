package com.appandweb.collapsingtoolbar.ui.presenter.abs;

import com.appandweb.collapsingtoolbar.ui.presenter.Presenter;

/**
 * Created by winecta on 8/05/17.
 */

public abstract class AbsViewPagerPresenter extends Presenter<AbsViewPagerPresenter.MVPView, AbsViewPagerPresenter.Navigator> {

    public abstract void onMenuClicked();

    public abstract void onBackClicked();

    public interface MVPView {
        void showMenu();
    }

    public interface Navigator {
        void navigateToBack();

    }
}