package com.example.rememberforme.screens.common;

import androidx.fragment.app.Fragment;

import com.example.rememberforme.common.dependencyinjection.ActivityCompositionRoot;

public abstract class BaseFragment extends Fragment {

    protected ActivityCompositionRoot getCompositionRoot() {
        return ((MainActivity)requireActivity()).getCompositionRoot();
    }
}
