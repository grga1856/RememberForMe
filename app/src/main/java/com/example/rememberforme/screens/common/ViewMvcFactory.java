package com.example.rememberforme.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    // example of creating MvcImpl
//    public SmsAllViewMvc newSmsAllViewMvc(@Nullable ViewGroup parent) {
//        return new SmsAllViewMvcImpl(mLayoutInflater, parent, this);
//    }
}
