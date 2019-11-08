package kr.co.popone.fitts.feature.reward;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import retrofit2.HttpException;

final class RewardPointUseActivity$onCreate$5<T> implements Consumer<CharSequence> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$5(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(CharSequence charSequence) {
        Disposable access$getLinkInfoRequest$p = this.this$0.linkInfoRequest;
        if (access$getLinkInfoRequest$p != null) {
            access$getLinkInfoRequest$p.dispose();
        }
        this.this$0.linkInfoRequest = null;
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "it");
        if (charSequence.length() > 0) {
            RewardPointUseActivity rewardPointUseActivity = this.this$0;
            rewardPointUseActivity.linkInfoRequest = rewardPointUseActivity.getPostAPI$app_productionFittsRelease().requestLinkInfo(charSequence.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<LinkInfo, Throwable>(this) {
                final /* synthetic */ RewardPointUseActivity$onCreate$5 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(LinkInfo linkInfo, Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("linkInfoRequest ");
                    sb.append(linkInfo);
                    sb.append(' ');
                    sb.append(th);
                    Logger.d(sb.toString(), new Object[0]);
                    String str = "productLinkWarningTextView";
                    if (!(th instanceof HttpException) || ((HttpException) th).code() != 403) {
                        ((TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.productLinkAddressLabel)).setTextColor(ContextCompat.getColor(this.this$0.this$0, C0006R$color.gray6));
                        TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.productLinkWarningTextView);
                        Intrinsics.checkExpressionValueIsNotNull(textView, str);
                        textView.setVisibility(8);
                        return;
                    }
                    ((TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.productLinkAddressLabel)).setTextColor(ContextCompat.getColor(this.this$0.this$0, C0006R$color.neon_red));
                    TextView textView2 = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.productLinkWarningTextView);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    textView2.setVisibility(0);
                }
            });
        }
    }
}
