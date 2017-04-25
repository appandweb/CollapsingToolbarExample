package com.appandweb.collapsingtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by winecta on 25/04/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        if (hideToolbar()){
            getSupportActionBar().hide();
        }
    }

    public abstract int getLayoutId();

    public abstract boolean hideToolbar();

}
