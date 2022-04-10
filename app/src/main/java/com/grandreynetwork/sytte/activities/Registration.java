package com.grandreynetwork.sytte.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grandreynetwork.sytte.Fragments.Registration.FragmentAccDetails;
import com.grandreynetwork.sytte.Fragments.Registration.FragmentCreateNewPass;
import com.grandreynetwork.sytte.Fragments.Registration.FragmentEnterPass;
import com.grandreynetwork.sytte.Fragments.Registration.FragmentRecoverPass;
import com.grandreynetwork.sytte.Fragments.Registration.FragmentVerifier;
import com.grandreynetwork.sytte.Fragments.Registration.FragmentSign;
import com.grandreynetwork.sytte.Fragments.Registration.Fragment_PickInterest;
import com.grandreynetwork.sytte.R;

public class Registration extends AppCompatActivity implements
        FragmentSign.OnFragmentInteractionListener,
        FragmentCreateNewPass.OnFragmentInteractionListener,
        FragmentRecoverPass.OnFragmentInteractionListener,
        FragmentEnterPass.OnFragmentInteractionListener,
        FragmentAccDetails.OnFragmentInteractionListener,
        FragmentVerifier.OnFragmentInteractionListener {
    private FragmentTransaction transaction;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistration);
        FragmentSign signing = new FragmentSign();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction().add(R.id.registration, signing, "FragmentSign");
        transaction.commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void openPlacesOfInterest() {
        startActivity(new Intent(Registration.this, StartingUpActivity.class));
        finish();
    }

    @Override
    public void proceed() {
        FragmentCreateNewPass fragmentCreateNewPass = new FragmentCreateNewPass();
        transaction = manager.beginTransaction().replace(R.id.registration, fragmentCreateNewPass, "FragmentCreateNewPass").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void loadAccDetail() {
        FragmentAccDetails fragmentAccDetails = new FragmentAccDetails();
        transaction = manager.beginTransaction().replace(R.id.registration, fragmentAccDetails, "FragmentAccDetails").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openEnterPass() {
        FragmentEnterPass fragmentEnterPass = new FragmentEnterPass();
        transaction = manager.beginTransaction().replace(R.id.registration, fragmentEnterPass, "FragmentEnterPass").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openVerification() {
        FragmentEnterPass fragmentEnterPass = FragmentEnterPass.newInstance(true);
        transaction = manager.beginTransaction().replace(R.id.registration, fragmentEnterPass, "FragmentEnterPass").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void whichbutton(int id) {
        switch (id) {
            case R.id.btn_goback:
                onBackPressed();
                break;
            case R.id.btn_reset:
                FragmentVerifier fragmentVerifier = new FragmentVerifier();
                transaction = manager.beginTransaction().replace(R.id.registration, fragmentVerifier, "FragmentVerifier").addToBackStack(null);
                transaction.commit();
                break;
        }
    }

    @Override
    public void forgetPass() {
        FragmentRecoverPass recoverPass = new FragmentRecoverPass();
        transaction = manager.beginTransaction().replace(R.id.registration, recoverPass, "FragmentRecoverPass").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void signup() {
        FragmentVerifier fragmentVerifier = FragmentVerifier.newInstance(true);
        transaction = manager.beginTransaction().replace(R.id.registration, fragmentVerifier, "FragmentVerifier").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
