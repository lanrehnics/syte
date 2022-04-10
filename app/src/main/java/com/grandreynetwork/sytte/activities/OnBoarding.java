package com.grandreynetwork.sytte.activities;

import android.content.Intent;
import android.os.Bundle;

import com.grandreynetwork.sytte.R;
import com.grandreynetwork.sytte.onboarder.AhoyOnboarderActivity;
import com.grandreynetwork.sytte.onboarder.AhoyOnboarderCard;
import com.grandreynetwork.sytte.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("", getResources().getString(R.string.on1), R.drawable.on1);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("", getResources().getString(R.string.on2), R.drawable.on2);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("", getResources().getString(R.string.on3), R.drawable.on3);

        ahoyOnboarderCard1.setBackgroundColor(R.color.grey_300);
        ahoyOnboarderCard2.setBackgroundColor(R.color.grey_300);
        ahoyOnboarderCard3.setBackgroundColor(R.color.grey_300);


        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.black);
        }

        showNavigationControls(false);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.on_backgroung);
        colorList.add(R.color.on_backgroung);
        colorList.add(R.color.on_backgroung);

        setColorBackground(colorList);


        setOnboardPages(pages);
    }

    @Override
    public void onSignUpButtonPressed() {
        setUpFocusWindow(Constants.REG_WINDOS_SIGNUP);
    }

    @Override
    public void onSignInButtonPressed() {
        setUpFocusWindow(Constants.REG_WINDOS_SIGNUP);
    }

    private void setUpFocusWindow(String focusWindow) {
        Intent intent = new Intent(OnBoarding.this, Registration.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REG_FOCUS_WINDOW, focusWindow);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
