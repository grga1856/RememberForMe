package com.example.rememberforme.screens;

import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;

import androidx.fragment.app.Fragment;

public class ScreensNavigator {

    private final FragNavController mFragNavController;

    public ScreensNavigator(FragNavController fragNavController) {
        mFragNavController = fragNavController;
    }

    public void init(Bundle savedInstanceState) {
        mFragNavController.setRootFragmentListener(new FragNavController.RootFragmentListener() {
            @Override
            public int getNumberOfRootFragments() {
                return 1;
            }

            @Override
            public Fragment getRootFragment(int i) {
                //TODO : return root fragment
//                return ExampleFragment.newInstance();
                return null;
            }
        });

        mFragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    public boolean navigateBack() {
        if (mFragNavController.isRootFragment()) {
            return false;
        } else {
            mFragNavController.popFragment();
            return true;
        }
    }

    //TODO : add real navigation functions

    public void toExampleScreen() {
//        mFragNavController.pushFragment(ExampleFragment.newInstance());
    }

    public void toExampleDetailsScreen(long smsId) {
//        mFragNavController.pushFragment(ExampleDetailsFragment.newInstance(smsId));
    }
}
