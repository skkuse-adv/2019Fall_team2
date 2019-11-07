package com.kakao.usermgmt;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kakao.auth.AuthType;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginButton extends FrameLayout {
    private Fragment fragment;
    private androidx.fragment.app.Fragment supportFragment;

    private static class Item {
        final AuthType authType;
        final int contentDescId;
        public final int icon;
        final int textId;

        Item(int i, Integer num, int i2, AuthType authType2) {
            this.textId = i;
            this.icon = num.intValue();
            this.contentDescId = i2;
            this.authType = authType2;
        }
    }

    public LoginButton(Context context) {
        super(context);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FrameLayout.inflate(getContext(), R.layout.kakao_login_layout, this);
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LoginButton.this.onClickLoginButton(LoginButton.this.getAuthTypes());
            }
        });
    }

    /* access modifiers changed from: private */
    public List<AuthType> getAuthTypes() {
        ArrayList arrayList = new ArrayList();
        if (Session.getCurrentSession().getAuthCodeManager().isTalkLoginAvailable()) {
            arrayList.add(AuthType.KAKAO_TALK);
            arrayList.add(AuthType.KAKAO_TALK_ONLY);
        }
        if (Session.getCurrentSession().getAuthCodeManager().isStoryLoginAvailable()) {
            arrayList.add(AuthType.KAKAO_STORY);
        }
        arrayList.add(AuthType.KAKAO_ACCOUNT);
        AuthType[] authTypes = KakaoSDK.getAdapter().getSessionConfig().getAuthTypes();
        if (authTypes == null || authTypes.length == 0 || (authTypes.length == 1 && authTypes[0] == AuthType.KAKAO_LOGIN_ALL)) {
            authTypes = AuthType.values();
        }
        arrayList.retainAll(Arrays.asList(authTypes));
        if (arrayList.contains(AuthType.KAKAO_TALK) && arrayList.contains(AuthType.KAKAO_TALK_ONLY)) {
            arrayList.remove(AuthType.KAKAO_TALK_ONLY);
        }
        if (arrayList.size() == 0) {
            arrayList.add(AuthType.KAKAO_ACCOUNT);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void onClickLoginButton(List<AuthType> list) {
        if (list.size() == 1) {
            openSession((AuthType) list.get(0));
            return;
        }
        Item[] createAuthItemArray = createAuthItemArray(list);
        showDialogWhilePreservingSystemVisibility(createLoginDialog(createAuthItemArray, createLoginAdapter(createAuthItemArray)));
    }

    private void showDialogWhilePreservingSystemVisibility(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            window.setFlags(8, 8);
        }
        dialog.show();
        if (!(getActivity() == null || window == null)) {
            window.getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility());
            window.clearFlags(8);
        }
    }

    private Item[] createAuthItemArray(List<AuthType> list) {
        ArrayList arrayList = new ArrayList();
        if (list.contains(AuthType.KAKAO_TALK)) {
            arrayList.add(new Item(R.string.com_kakao_kakaotalk_account, Integer.valueOf(R.drawable.talk), R.string.com_kakao_kakaotalk_account_tts, AuthType.KAKAO_TALK));
        }
        if (list.contains(AuthType.KAKAO_TALK_ONLY)) {
            arrayList.add(new Item(R.string.com_kakao_kakaotalk_account, Integer.valueOf(R.drawable.talk), R.string.com_kakao_kakaotalk_account_tts, AuthType.KAKAO_TALK_ONLY));
        }
        if (list.contains(AuthType.KAKAO_STORY)) {
            arrayList.add(new Item(R.string.com_kakao_kakaostory_account, Integer.valueOf(R.drawable.story), R.string.com_kakao_kakaostory_account_tts, AuthType.KAKAO_STORY));
        }
        if (list.contains(AuthType.KAKAO_ACCOUNT)) {
            arrayList.add(new Item(R.string.com_kakao_other_kakaoaccount, Integer.valueOf(R.drawable.account), R.string.com_kakao_other_kakaoaccount_tts, AuthType.KAKAO_ACCOUNT));
        }
        return (Item[]) arrayList.toArray(new Item[0]);
    }

    private ListAdapter createLoginAdapter(Item[] itemArr) {
        final Item[] itemArr2 = itemArr;
        AnonymousClass2 r0 = new ArrayAdapter<Item>(getContext(), 17367057, 16908308, itemArr) {
            @NonNull
            public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
                if (view == null) {
                    view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_login_item, viewGroup, false);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.login_method_icon);
                if (VERSION.SDK_INT >= 21) {
                    imageView.setImageDrawable(LoginButton.this.getResources().getDrawable(itemArr2[i].icon, getContext().getTheme()));
                } else {
                    imageView.setImageDrawable(LoginButton.this.getResources().getDrawable(itemArr2[i].icon));
                }
                ((TextView) view.findViewById(R.id.login_method_text)).setText(itemArr2[i].textId);
                return view;
            }
        };
        return r0;
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private void applyFullscreenOptions(Dialog dialog) {
        int i;
        Activity activity = getActivity();
        if (activity != null) {
            Window window = activity.getWindow();
            Window window2 = dialog.getWindow();
            if (!(window == null || window2 == null)) {
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                int i2 = window.getAttributes().flags;
                if (VERSION.SDK_INT < 28) {
                    i = 0;
                } else {
                    i = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
                }
                if (VERSION.SDK_INT < 16) {
                    window2.setFlags(1024, 1024);
                } else {
                    window2.getDecorView().setSystemUiVisibility(systemUiVisibility);
                    window2.addFlags(i2);
                    if (VERSION.SDK_INT >= 28) {
                        window2.getAttributes().layoutInDisplayCutoutMode = i;
                    }
                }
            }
        }
    }

    private Dialog createLoginDialog(final Item[] itemArr, ListAdapter listAdapter) {
        final Dialog dialog = new Dialog(getContext(), R.style.LoginDialog);
        dialog.requestWindowFeature(1);
        applyFullscreenOptions(dialog);
        dialog.setContentView(R.layout.layout_login_dialog);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setGravity(17);
        }
        ListView listView = (ListView) dialog.findViewById(R.id.login_list_view);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AuthType authType = itemArr[i].authType;
                if (authType != null) {
                    LoginButton.this.openSession(authType);
                }
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.login_close_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        return dialog;
    }

    public void openSession(AuthType authType) {
        if (getFragment() != null) {
            Session.getCurrentSession().open(authType, getFragment());
        } else if (getSupportFragment() != null) {
            Session.getCurrentSession().open(authType, getSupportFragment());
        } else {
            Session.getCurrentSession().open(authType, (Activity) getContext());
        }
    }

    public void setFragment(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public void setSuportFragment(androidx.fragment.app.Fragment fragment2) {
        this.supportFragment = fragment2;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }
}
