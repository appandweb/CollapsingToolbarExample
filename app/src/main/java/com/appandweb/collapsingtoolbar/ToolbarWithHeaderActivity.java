package com.appandweb.collapsingtoolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;

public class ToolbarWithHeaderActivity extends BaseActivity {
    CollapsingToolbarLayout ctb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctb = (CollapsingToolbarLayout) findViewById(R.id.collapsing_lyt_toolbar);
        configurateToolbar();
    }

    private void configurateToolbar() {
        ctb.setCollapsedTitleTextColor(Color.WHITE);
        ctb.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        ctb.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
        ctb.setTitle(getResources().getString(R.string.app_name));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_collpasing;
    }

    @Override
    public boolean hideToolbar() {
        return true;
    }
}
