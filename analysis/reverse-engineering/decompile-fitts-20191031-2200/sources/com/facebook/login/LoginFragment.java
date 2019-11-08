package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.R$id;
import com.facebook.common.R$layout;
import com.facebook.login.LoginClient.OnCompletedListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;

public class LoginFragment extends Fragment {
    private String callingPackage;
    private LoginClient loginClient;
    private Request request;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable("loginClient");
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new OnCompletedListener() {
            public void onCompleted(Result result) {
                LoginFragment.this.onLoginClientCompleted(result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request");
                if (bundleExtra != null) {
                    this.request = (Request) bundleExtra.getParcelable("request");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    public void onDestroy() {
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R$id.com_facebook_login_fragment_progress_bar);
        this.loginClient.setBackgroundProcessingListener(new BackgroundProcessingListener(this) {
            public void onBackgroundProcessingStarted() {
                findViewById.setVisibility(0);
            }

            public void onBackgroundProcessingStopped() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public int getLayoutResId() {
        return R$layout.com_facebook_login_fragment;
    }

    /* access modifiers changed from: private */
    public void onLoginClientCompleted(Result result) {
        this.request = null;
        int i = result.code == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            getActivity().finish();
        } else {
            this.loginClient.startOrContinueAuth(this.request);
        }
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R$id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.loginClient.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.loginClient);
    }

    private void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: 0000 */
    public LoginClient getLoginClient() {
        return this.loginClient;
    }
}
