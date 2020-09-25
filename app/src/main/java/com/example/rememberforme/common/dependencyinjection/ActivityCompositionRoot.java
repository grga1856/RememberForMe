package com.example.rememberforme.common.dependencyinjection;

import android.content.ContentResolver;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rememberforme.R;
import com.example.rememberforme.common.permissions.PermissionsHelper;
import com.example.rememberforme.screens.ScreensNavigator;
import com.example.rememberforme.screens.common.ViewMvcFactory;
import com.ncapdevi.fragnav.FragNavController;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

public class ActivityCompositionRoot {

    private final ApplicationCompositionRoot mApplicationCompositionRoot;
    private final AppCompatActivity mActivity;

    private PermissionsHelper mPermissionsHelper;
    private ScreensNavigator mScreensNavigator;

    public ActivityCompositionRoot(ApplicationCompositionRoot applicationCompositionRoot, AppCompatActivity activity) {
        mApplicationCompositionRoot = applicationCompositionRoot;
        mActivity = activity;
    }

    public PermissionsHelper getPermissionsHelper() {
        if (mPermissionsHelper == null) {
            mPermissionsHelper = new PermissionsHelper(mActivity);
        }
        return mPermissionsHelper;
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(LayoutInflater.from(mActivity));
    }

    private ContentResolver getContentResolver() {
        return mActivity.getContentResolver();
    }

    private BackgroundThreadPoster getBackgroundThreadPoster() {
        return mApplicationCompositionRoot.getBackgroundThreadPoster();
    }

    private UiThreadPoster getUiThreadPoster() {
        return mApplicationCompositionRoot.getUiThreadPoster();
    }

    public ScreensNavigator getScreenNavigator() {
        if (mScreensNavigator == null) {
            mScreensNavigator = new ScreensNavigator(
                    new FragNavController(mActivity.getSupportFragmentManager(), R.id.frame_contents)
            );
        }
        return mScreensNavigator;
    }

    //use case example
//    public FetchAllSmsUseCase getFetchAllSmsUseCase() {
//        return new FetchAllSmsUseCase(
//                getUiThreadPoster(),
//                getBackgroundThreadPoster(),
//                getFetchSmsUseCaseSync()
//        );
//    }
}
