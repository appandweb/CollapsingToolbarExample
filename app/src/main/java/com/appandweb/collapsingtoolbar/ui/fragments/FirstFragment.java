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
package com.appandweb.collapsingtoolbar.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.appandweb.collapsingtoolbar.R;
import com.appandweb.collapsingtoolbar.ui.presenter.FirstPresenter;
import com.appandweb.collapsingtoolbar.ui.presenter.abs.AbsFirstPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class FirstFragment extends Fragment implements AdapterView.OnItemSelectedListener, AbsFirstPresenter.MVPView, AbsFirstPresenter.Navigator {

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    @Bind(R.id.first_spinner)
    Spinner spinner;
    @Bind(R.id.first_tv_text)
    TextView text;

    @BindString(R.string.text_all)
    String text_all;
    @BindString(R.string.text_most_recent)
    String text_most_recent;
    @BindString(R.string.text_favourite)
    String text_favourite;

    AbsFirstPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        ButterKnife.bind(this, view);

        initialize();

        return view;
    }

    private void initialize() {
        presenter = new FirstPresenter(this.getContext());
        presenter.setView(this);
        presenter.setNavigator(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, getValues());
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);

    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add("All");
        values.add("Most recent");
        values.add("Favourites");
        return values;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case FIRST:
                presenter.onFirstOptionSelected();
                break;
            case SECOND:
                presenter.onSecondOptionSelected();
                break;
            case THIRD:
                presenter.onThirdOptionSelected();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        presenter.onFirstOptionSelected();
    }

    @Override
    public void showFirstOptions() {
        text.setText(text_all);
    }

    @Override
    public void showSecondOptions() {
        text.setText(text_most_recent);
    }

    @Override
    public void showThirdOptions() {
        text.setText(text_favourite);
    }
}
