package com.appandweb.collapsingtoolbar.ui.presenter;

import android.content.Context;

import com.appandweb.collapsingtoolbar.ui.presenter.abs.AbsSecondPresenter;

/**
 * Created by winecta on 8/05/17.
 */

public class SecondPresenter extends AbsSecondPresenter {
    Context context;

    public SecondPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onFirstOptionSelected() {
        view.showFirstOptions();
    }

    @Override
    public void onSecondOptionSelected() {
        view.showSecondOptions();
    }

    @Override
    public void onThirdOptionSelected() {
        view.showThirdOptions();
    }
}
