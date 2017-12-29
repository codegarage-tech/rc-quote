package com.reversecoder.attributionpresenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.reversecoder.attributionpresenter.R;
import com.reversecoder.attributionpresenter.adapter.AttributionAdapter;
import com.reversecoder.attributionpresenter.model.Attribution;
import com.reversecoder.attributionpresenter.model.Library;
import com.reversecoder.attributionpresenter.view.AnimatedImageView;
import com.reversecoder.attributionpresenter.view.AnimatedTextView;
import com.reversecoder.attributionpresenter.view.ArcView;

import java.util.ArrayList;

public class LicenseActivity extends AppCompatActivity {

    //toolbar
    ArcView arcMenuView;
    AnimatedImageView arcMenuImage;
    AnimatedTextView toolbarTitle;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        initView();
    }

    private void initView() {

        initToolBar();

        ListView lvLicense = (ListView) findViewById(R.id.list);
        AttributionAdapter attributionAdapter = new AttributionAdapter(LicenseActivity.this);
        lvLicense.setAdapter(attributionAdapter);
        attributionAdapter.setData(getAllAttributions());
    }

    private void initToolBar() {
        toolbarTitle = (AnimatedTextView) findViewById(R.id.toolbarTitle);
        arcMenuImage = (AnimatedImageView) findViewById(R.id.arcImage);
        arcMenuView = (ArcView) findViewById(R.id.arcView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbarTitle.setAnimatedText(getString(R.string.title_activity_third_party_notice), 0L);

        arcMenuImage.setAnimatedImage(R.drawable.arrow_left, 0L);
        arcMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private ArrayList<Attribution> getAllAttributions() {

        ArrayList<Attribution> attributions = new ArrayList<>();
        attributions.add(Library.ANDROID_ABOUT_BOX_EGGHEADGAMES.getAttribution());
        attributions.add(Library.MATERIAL_ABOUT_LIBRARY_DANIELSTONEUK.getAttribution());
        attributions.add(Library.ARC_LAYOUT_FLORENT37.getAttribution());
        attributions.add(Library.ATTRIBUTE_PRESENTER_FRANMONTIEL.getAttribution());
        attributions.add(Library.CARD_SLIDER_ANDROID_RAMOTION.getAttribution());
        attributions.add(Library.CONTEXT_MENU_ANDROID_YALANTIS.getAttribution());
        attributions.add(Library.COOKIEBAR2_AVIRANABADY.getAttribution());
        attributions.add(Library.EASY_RECYCLERVIEW_JUDE95.getAttribution());
        attributions.add(Library.ANDROID_FLIPVIEW_EMILSJOLANDER.getAttribution());
        attributions.add(Library.FOLDABLE_LAYOUT_ALEXVASILKOV.getAttribution());
        attributions.add(Library.GLAZY_VIEWPAGER_KANNANANBU.getAttribution());
        attributions.add(Library.KENBURNSVIEW_FLAVIOARFARIA.getAttribution());
        attributions.add(Library.LOCALE_CHANGER_FRANMONTIEL.getAttribution());
        attributions.add(Library.MULTI_COLOR_TEXTVIEW_HAYI.getAttribution());
        attributions.add(Library.RIBBLE_MENU_ARMCHA.getAttribution());
        attributions.add(Library.SHAPE_RIPPLE_POLDZ123.getAttribution());
        attributions.add(Library.SHERLOCK_AJITSING.getAttribution());
        attributions.add(Library.STICKY_INDEX_EDSILFER.getAttribution());
        attributions.add(Library.SUGAR_CHENNAIONE.getAttribution());
        attributions.add(Library.TUTORS_POPALAY.getAttribution());
        attributions.add(Library.UPDATE_CHECKER_KOBEUMUT.getAttribution());
        attributions.add(Library.VERTICAL_INTRO_ARMCHA.getAttribution());
        attributions.add(Library.WAVE_SIDEBAR_SOLARTISAN.getAttribution());

        return attributions;
    }
}