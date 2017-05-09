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

package com.appandweb.collapsingtoolbar.ui.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.appandweb.collapsingtoolbar.R;
import com.appandweb.collapsingtoolbar.ui.presenter.ViewPagerPresenter;
import com.appandweb.collapsingtoolbar.ui.presenter.abs.AbsViewPagerPresenter;
import com.appandweb.collapsingtoolbar.ui.adaptor.ViewPagerAdapter;
import com.appandweb.collapsingtoolbar.ui.fragments.SecondFragment;
import com.appandweb.collapsingtoolbar.ui.fragments.ThirdFragment;
import com.appandweb.collapsingtoolbar.ui.fragments.FirstFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.OnClick;

public class ViewPagerActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, AbsViewPagerPresenter.MVPView, AbsViewPagerPresenter.Navigator, PopupMenu.OnMenuItemClickListener {
    @Bind(R.id.view_pager_ibtn_back)
    ImageButton btn_back;
    @Bind(R.id.view_pager_ibtn_menu)
    ImageButton btn_menu;
    @Bind(R.id.view_pager_tablayout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager_vp)
    ViewPager viewPager;
    @Bind(R.id.view_pager_tv_title)
    TextView title_header;

    @BindDrawable(R.drawable.home_dark)
    Drawable dwb_home;
    @BindDrawable(R.drawable.message_light)
    Drawable dwb_message;
    @BindDrawable(R.drawable.inbox_light)
    Drawable dwb_inbox;
    @BindColor(R.color.colorPrimaryDark)
    int ppColor;
    @BindColor(android.R.color.darker_gray)
    int ssColor;
    @BindString(R.string.first_fragment)
    String first_fragment;
    @BindString(R.string.second_fragment)
    String second_fragment;
    @BindString(R.string.third_fragment)
    String third_fragment;

    @OnClick(R.id.view_pager_ibtn_menu)
    public void onMenuClicked(View view) {
        presenter.onMenuClicked();
    }

    @OnClick(R.id.view_pager_ibtn_back)
    public void onBackPressed(View view) {

        presenter.onBackClicked();
    }

    AbsViewPagerPresenter presenter;
    ViewPagerAdapter adapter;
    PopupMenu menu;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        presenter = new ViewPagerPresenter(this);
        presenter.setNavigator(this);
        presenter.setView(this);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getViewPagerFragments());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.getTabAt(0).setIcon(dwb_message);
        tabLayout.getTabAt(1).setIcon(dwb_home);
        tabLayout.getTabAt(2).setIcon(dwb_inbox);
        viewPager.setCurrentItem(1);

        menu = new PopupMenu(this, btn_menu);
        menu.getMenuInflater().inflate(R.menu.menu_view_pager, menu.getMenu());
        menu.setOnMenuItemClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    @Override
    public boolean hideToolbar() {
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(ppColor, PorterDuff.Mode.SRC_IN);
        viewPager.setCurrentItem(tab.getPosition());
        switch (tab.getPosition()) {
            case FIRST:
                title_header.setText(first_fragment);
                break;
            case SECOND:
                title_header.setText(second_fragment);
                break;
            case THIRD:
                title_header.setText(third_fragment);
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(ssColor, PorterDuff.Mode.SRC_IN);
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(ppColor, PorterDuff.Mode.SRC_IN);
        viewPager.setCurrentItem(tab.getPosition());
    }

    public List<Fragment> getViewPagerFragments() {
        List<Fragment> viewPagerFragments = new ArrayList<Fragment>();
        viewPagerFragments.add(new FirstFragment());
        viewPagerFragments.add(new SecondFragment());
        viewPagerFragments.add(new ThirdFragment());
        return viewPagerFragments;
    }

    @Override
    public void showMenu() {

        menu.show();
    }

    @Override
    public void navigateToBack() {
        onBackPressed();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_vp_option1:
                Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_vp_option2:
                Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
