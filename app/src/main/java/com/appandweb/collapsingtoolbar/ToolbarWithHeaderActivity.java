/*
 * Copyright (C) 2017 AppAndWeb INNOVA S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        return R.layout.activity_toolbar_with_header;
    }

    @Override
    public boolean hideToolbar() {
        return true;
    }
}
