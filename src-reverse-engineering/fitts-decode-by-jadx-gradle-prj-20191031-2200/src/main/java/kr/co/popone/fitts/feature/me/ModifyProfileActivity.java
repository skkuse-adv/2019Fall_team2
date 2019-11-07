package kr.co.popone.fitts.feature.me;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import dagger.android.AndroidInjection;
import de.hdodenhof.circleimageview.CircleImageView;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.CreateImage;
import kr.co.popone.fitts.model.user.UserAPI;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;
import photopicker.view.ImageSelectorActivity;

public final class ModifyProfileActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable uploadProfileImageRequest;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Disposable userInfoRequest;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_modify_profile);
        EventBus.getDefault().register(this);
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setOnClickListener(new ModifyProfileActivity$onCreate$1(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.modify_profile_image_button)).setOnClickListener(new ModifyProfileActivity$onCreate$2(this));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.modify_body_button)).setOnClickListener(new ModifyProfileActivity$onCreate$3(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.modify_profile_user_info)).setOnClickListener(new ModifyProfileActivity$onCreate$4(this));
        initData();
    }

    private final void initData() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyProfileActivity$initData$1<Object,Object>(this));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1) {
            ArrayList stringArrayListExtra = intent != null ? intent.getStringArrayListExtra(ImageSelectorActivity.Companion.getREQUEST_OUTPUT()) : null;
            if (stringArrayListExtra != null && stringArrayListExtra.size() >= 1) {
                Disposable disposable = this.uploadProfileImageRequest;
                if (disposable != null) {
                    disposable.dispose();
                }
                UserAPI userAPI2 = this.userAPI;
                if (userAPI2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userAPI");
                }
                String str = (String) stringArrayListExtra.get(0);
                MediaType parse = MediaType.parse("image/jpeg");
                Object obj = stringArrayListExtra.get(0);
                Intrinsics.checkExpressionValueIsNotNull(obj, "image_uris[0]");
                Part createFormData = Part.createFormData("profile_image", str, RequestBody.create(parse, new CreateImage((String) obj).getFile()));
                Intrinsics.checkExpressionValueIsNotNull(createFormData, "MultipartBody.Part.creat…age(image_uris[0]).file))");
                this.uploadProfileImageRequest = userAPI2.uploadProfile(createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyProfileActivity$onActivityResult$1<Object,Object>(this));
            }
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "my_message")
    public final void onReceive(@NotNull Message message) {
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        int i = message.what;
        if (i == 4) {
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile_large)).error((int) C0008R$drawable.image_default_profile_large);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…ge_default_profile_large)");
            Intrinsics.checkExpressionValueIsNotNull(Glide.with((FragmentActivity) this).load(message.getData().getString("profileImageUrl")).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) (CircleImageView) _$_findCachedViewById(C0010R$id.profile_image)), "Glide.with(this).load( m…ions).into(profile_image)");
        } else if (i == 6) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.uploadProfileImageRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.uploadProfileImageRequest = null;
        this.userInfoRequest = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
