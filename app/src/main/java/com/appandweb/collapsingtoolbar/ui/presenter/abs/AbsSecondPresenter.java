package com.appandweb.collapsingtoolbar.ui.presenter.abs;

import com.appandweb.collapsingtoolbar.ui.presenter.Presenter;

/**
 * Created by winecta on 8/05/17.
 */

public abstract class AbsSecondPresenter extends Presenter<AbsSecondPresenter.MVPView, AbsSecondPresenter.Navigator> {


    public abstract void onFirstOptionSelected();

    public abstract void onSecondOptionSelected();

    public abstract void onThirdOptionSelected();

    public interface MVPView {

        void showFirstOptions();

        void showSecondOptions();

        void showThirdOptions();
    }

    public interface Navigator{
    }
}
