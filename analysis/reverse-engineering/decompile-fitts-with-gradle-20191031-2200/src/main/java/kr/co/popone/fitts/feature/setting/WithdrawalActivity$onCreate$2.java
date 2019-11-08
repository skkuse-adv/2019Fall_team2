package kr.co.popone.fitts.feature.setting;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class WithdrawalActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ WithdrawalActivity this$0;

    WithdrawalActivity$onCreate$2(WithdrawalActivity withdrawalActivity) {
        this.this$0 = withdrawalActivity;
    }

    public final void onClick(View view) {
        final Dialog dialog = new Dialog(this.this$0);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0013R$layout.custom_dialog);
        View findViewById = dialog.findViewById(C0010R$id.dialog_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "dialog.findViewById<TextView>(R.id.dialog_title)");
        ((TextView) findViewById).setText("탈퇴하기");
        View findViewById2 = dialog.findViewById(C0010R$id.dialog_sub);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "dialog.findViewById<TextView>(R.id.dialog_sub)");
        ((TextView) findViewById2).setText("핏츠를 탈퇴하시겠습니까?");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.findViewById(C0010R$id.ok).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WithdrawalActivity$onCreate$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                dialog.dismiss();
                View currentFocus = this.this$0.this$0.getCurrentFocus();
                if (currentFocus != null) {
                    Object systemService = this.this$0.this$0.getSystemService("input_method");
                    if (systemService != null) {
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    }
                }
                if (this.this$0.this$0.deleteUserRequest == null) {
                    ProgressBar progressBar = (ProgressBar) this.this$0.this$0._$_findCachedViewById(C0010R$id.loading);
                    Intrinsics.checkExpressionValueIsNotNull(progressBar, "loading");
                    progressBar.setVisibility(0);
                    LinearLayout linearLayout = (LinearLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.contentLayout);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, "contentLayout");
                    linearLayout.setVisibility(8);
                    Disposable access$getDeleteUserRequest$p = this.this$0.this$0.deleteUserRequest;
                    if (access$getDeleteUserRequest$p != null) {
                        access$getDeleteUserRequest$p.dispose();
                    }
                    WithdrawalActivity withdrawalActivity = this.this$0.this$0;
                    withdrawalActivity.deleteUserRequest = withdrawalActivity.getUserAPI$app_productionFittsRelease().deleteUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void accept(String str, Throwable th) {
                            this.this$0.this$0.this$0.deleteUserRequest = null;
                            String str2 = "contentLayout";
                            String str3 = "loading";
                            if (str != null) {
                                this.this$0.this$0.this$0.getSessionManager$app_productionFittsRelease().logout();
                                if (AccessToken.getCurrentAccessToken() != null) {
                                    LoginManager.getInstance().logOut();
                                }
                                Intent intent = new Intent(this.this$0.this$0.this$0, IntroActivity.class);
                                intent.addFlags(32768);
                                intent.addFlags(268435456);
                                ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0.this$0.this$0, C0001R$anim.fade_in, C0001R$anim.fade_out);
                                Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…fade_in, R.anim.fade_out)");
                                this.this$0.this$0.this$0.startActivity(intent, makeCustomAnimation.toBundle());
                                ProgressBar progressBar = (ProgressBar) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.loading);
                                Intrinsics.checkExpressionValueIsNotNull(progressBar, str3);
                                progressBar.setVisibility(8);
                                LinearLayout linearLayout = (LinearLayout) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.contentLayout);
                                Intrinsics.checkExpressionValueIsNotNull(linearLayout, str2);
                                linearLayout.setVisibility(0);
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("error occured ");
                            sb.append(th);
                            Logger.d(sb.toString(), new Object[0]);
                            Snackbar.Companion.showMessage(this.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                            ProgressBar progressBar2 = (ProgressBar) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.loading);
                            Intrinsics.checkExpressionValueIsNotNull(progressBar2, str3);
                            progressBar2.setVisibility(8);
                            LinearLayout linearLayout2 = (LinearLayout) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.contentLayout);
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str2);
                            linearLayout2.setVisibility(0);
                            if ((th instanceof HttpException) && ((HttpException) th).code() == 401) {
                                Intent intent2 = new Intent(this.this$0.this$0.this$0, IntroActivity.class);
                                intent2.addFlags(32768);
                                intent2.addFlags(268435456);
                                this.this$0.this$0.this$0.startActivity(intent2, null);
                            }
                        }
                    });
                }
            }
        });
        dialog.findViewById(C0010R$id.cancel).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
