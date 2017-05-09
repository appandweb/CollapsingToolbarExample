package com.appandweb.collapsingtoolbar.ui.presenter;

/**
 * Created by winecta on 8/05/17.
 */

public abstract class Presenter<T1, T2> {

    public abstract void initialize();

    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();

    protected T1 view;

    protected T2 navigator;


    public void setView(T1 view) {
        this.view = view;
    }

    public void setNavigator(T2 navigator) {
        this.navigator = navigator;
    }

}
