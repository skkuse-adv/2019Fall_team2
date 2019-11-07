package kr.co.popone.fitts.feature.intro.join;

import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.IdAvailable;
import kr.co.popone.fitts.utils.Snackbar;

final class JoinActivity$onCreate$9<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$9(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        if (this.this$0.fittsIdRexPattern.matcher(charSequence).matches()) {
            Disposable access$getIdDuplicationCheckRequest$p = this.this$0.idDuplicationCheckRequest;
            if (access$getIdDuplicationCheckRequest$p != null) {
                access$getIdDuplicationCheckRequest$p.dispose();
            }
            JoinActivity joinActivity = this.this$0;
            joinActivity.idDuplicationCheckRequest = joinActivity.getUserAPI$app_productionFittsRelease().requestIdAvailable(charSequence.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<IdAvailable>(this) {
                final /* synthetic */ JoinActivity$onCreate$9 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(IdAvailable idAvailable) {
                    this.this$0.this$0.idDuplicationCheckRequest = null;
                    String str = "IDTextView";
                    String str2 = "";
                    if (!idAvailable.is_available()) {
                        TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.IDTextView);
                        Intrinsics.checkExpressionValueIsNotNull(textView, str);
                        textView.setText("이미 사용중인 ID");
                        this.this$0.this$0.setFittsID(str2);
                        this.this$0.this$0.fittsIDObservable.onNext(str2);
                        return;
                    }
                    TextView textView2 = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.IDTextView);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    textView2.setText(str2);
                    this.this$0.this$0.setFittsID(idAvailable.getFittsid());
                    this.this$0.this$0.fittsIDObservable.onNext(idAvailable.getFittsid());
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ JoinActivity$onCreate$9 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    this.this$0.this$0.idDuplicationCheckRequest = null;
                    Logger.e(th.toString(), new Object[0]);
                    Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                }
            });
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "id");
        String str = "IDTextView";
        String str2 = "";
        if (!StringsKt__StringsJVMKt.isBlank(charSequence)) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.IDTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText("4~15자의 영어 또는 영어.숫자 조합");
            this.this$0.setFittsID(str2);
            this.this$0.fittsIDObservable.onNext(str2);
            return;
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.IDTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setText(str2);
        this.this$0.setFittsID(str2);
        this.this$0.fittsIDObservable.onNext(str2);
    }
}
