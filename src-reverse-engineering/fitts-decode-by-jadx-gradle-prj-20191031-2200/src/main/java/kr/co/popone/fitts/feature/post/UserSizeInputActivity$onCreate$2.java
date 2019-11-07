package kr.co.popone.fitts.feature.post;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.DefaultImpls;

final class UserSizeInputActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ UserSizeInputActivity this$0;

    UserSizeInputActivity$onCreate$2(UserSizeInputActivity userSizeInputActivity) {
        this.this$0 = userSizeInputActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.validateFields() && this.this$0.updateUserSizeRequest == null) {
            this.this$0.updateUIEnabled(false);
            UserSizeInputActivity userSizeInputActivity = this.this$0;
            UserAPI userAPI$app_productionFittsRelease = userSizeInputActivity.getUserAPI$app_productionFittsRelease();
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.topClothingSizeTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "topClothingSizeTextView");
            String obj = textView.getText().toString();
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.bottomClothingSizeTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "bottomClothingSizeTextView");
            String obj2 = textView2.getText().toString();
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "shoeSizeInputEditText");
            Integer valueOf = Integer.valueOf(Integer.parseInt(editText.getText().toString()));
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.footDescriptionInputEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "footDescriptionInputEditText");
            userSizeInputActivity.updateUserSizeRequest = DefaultImpls.setUserInfo$default(userAPI$app_productionFittsRelease, null, null, null, null, obj, obj2, valueOf, editText2.getText().toString(), 15, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<MyInfo, Throwable>(this) {
                final /* synthetic */ UserSizeInputActivity$onCreate$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(MyInfo myInfo, Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{userInfoResult: ");
                    sb.append(myInfo);
                    sb.append(", error: ");
                    sb.append(th);
                    sb.append('}');
                    Logger.d(sb.toString(), new Object[0]);
                    this.this$0.this$0.updateUserSizeRequest = null;
                    if (myInfo != null) {
                        this.this$0.this$0.setResult(-1);
                        this.this$0.this$0.finish();
                        return;
                    }
                    this.this$0.this$0.updateUIEnabled(true);
                }
            });
        }
    }
}
