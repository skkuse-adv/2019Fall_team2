package kr.co.popone.fitts.feature.post;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UserSizeInputActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable updateUserSizeRequest;
    @NotNull
    public UserAPI userAPI;

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

    public void onBackPressed() {
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
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_user_size_input);
        ((ImageButton) _$_findCachedViewById(C0010R$id.showSizeGuideButton)).setOnClickListener(new UserSizeInputActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new UserSizeInputActivity$onCreate$2(this));
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        String str = "topClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar, str);
        seekBar.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar2, str);
        seekBar2.setProgress(6);
        SeekBar seekBar3 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        String str2 = "bottomClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar3, str2);
        seekBar3.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar4 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar4, str2);
        seekBar4.setProgress(6);
        ((SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar)).setOnSeekBarChangeListener(new UserSizeInputActivity$onCreate$3(this));
        ((SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar)).setOnSeekBarChangeListener(new UserSizeInputActivity$onCreate$4(this));
    }

    /* access modifiers changed from: private */
    public final void updateUIEnabled(boolean z) {
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar, "topClothingSizeSeekBar");
        seekBar.setEnabled(z);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar2, "bottomClothingSizeSeekBar");
        seekBar2.setEnabled(z);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.shoeSizeInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shoeSizeInputEditText");
        editText.setEnabled(z);
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.footDescriptionInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "footDescriptionInputEditText");
        editText2.setEnabled(z);
        Button button = (Button) _$_findCachedViewById(C0010R$id.confirmButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "confirmButton");
        button.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.updateUserSizeRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final boolean validateFields() {
        boolean z;
        int color = ContextCompat.getColor(this, C0006R$color.neon_red);
        int color2 = ContextCompat.getColor(this, C0006R$color.gray6);
        int color3 = ContextCompat.getColor(this, C0006R$color.gray4);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.shoeSizeInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shoeSizeInputEditText");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(editText.getText().toString());
        String str = "shoeSizeInputDescription";
        String str2 = "shoeDescriptionLabel2";
        if (intOrNull == null || intOrNull.intValue() < 100 || intOrNull.intValue() > 400 || intOrNull.intValue() % 5 != 0) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.shoeDescriptionLabel2);
            Intrinsics.checkExpressionValueIsNotNull(textView, str2);
            Sdk27PropertiesKt.setTextColor(textView, color);
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputDescription);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            Sdk27PropertiesKt.setTextColor(textView2, color);
            z = false;
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.shoeDescriptionLabel2);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
            Sdk27PropertiesKt.setTextColor(textView3, color2);
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputDescription);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str);
            Sdk27PropertiesKt.setTextColor(textView4, color3);
            z = true;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.footDescriptionInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "footDescriptionInputEditText");
        String str3 = "footDescriptionInputLabel";
        if (editText2.getText().length() < 8) {
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.footDescriptionInputLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
            Sdk27PropertiesKt.setTextColor(textView5, color);
            return false;
        }
        TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.footDescriptionInputLabel);
        Intrinsics.checkExpressionValueIsNotNull(textView6, str3);
        Sdk27PropertiesKt.setTextColor(textView6, color2);
        return z;
    }
}
