package com.eapps.androidmvptemplate.ui.base;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import butterknife.Unbinder;
import com.eapps.androidmvptemplate.di.component.ActivityFragmentComponent;

public abstract class BaseFragment extends Fragment implements BaseMvpView {

    private BaseActivity mBaseActivity;

    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mBaseActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        mBaseActivity = null;
        super.onDetach();
    }

    public ActivityFragmentComponent getActivityFragmentComponent() {
        return mBaseActivity.getActivityFragmentComponent();
    }

    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    @Override
    public void hideKeyboard() {
        if (mBaseActivity != null) {
            mBaseActivity.hideKeyboard();
        }
    }

    @Override
    public void hideLoading() {
        if (mBaseActivity != null) {
            mBaseActivity.hideLoading();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return mBaseActivity != null && mBaseActivity.isNetworkConnected();
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mBaseActivity != null) {
            mBaseActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (mBaseActivity != null) {
            mBaseActivity.onError(message);
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnbinder = unBinder;
    }

    @Override
    public void showLoading() {
        if (mBaseActivity != null) {
            mBaseActivity.showLoading();
        }
    }

    protected abstract void init();
}
