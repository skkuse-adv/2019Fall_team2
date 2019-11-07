package kr.co.popone.fitts.feature.post.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.HttpException;

final class ReportPostActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ ReportPostActivity this$0;

    ReportPostActivity$onCreate$6(ReportPostActivity reportPostActivity) {
        this.this$0 = reportPostActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.reportReason != null) {
            Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.report_done_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "report_done_button");
            button.setClickable(false);
            final Intent intent = new Intent();
            Disposable access$getReportPostRequest$p = this.this$0.reportPostRequest;
            if (access$getReportPostRequest$p != null) {
                access$getReportPostRequest$p.dispose();
            }
            ReportPostActivity reportPostActivity = this.this$0;
            PostAPI postAPI = reportPostActivity.getPostAPI();
            long longExtra = this.this$0.getIntent().getLongExtra("post_id", -1);
            String access$getReportReason$p = this.this$0.reportReason;
            if (access$getReportReason$p == null) {
                Intrinsics.throwNpe();
            }
            reportPostActivity.reportPostRequest = postAPI.reportPost(longExtra, access$getReportReason$p).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                final /* synthetic */ ReportPostActivity$onCreate$6 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(String str, Throwable th) {
                    this.this$0.this$0.reportPostRequest = null;
                    Button button = (Button) this.this$0.this$0._$_findCachedViewById(C0010R$id.report_done_button);
                    Intrinsics.checkExpressionValueIsNotNull(button, "report_done_button");
                    button.setClickable(true);
                    if (str != null) {
                        this.this$0.this$0.setResult(-1, intent);
                        this.this$0.this$0.finish();
                        this.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
                        return;
                    }
                    Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                    if (th instanceof HttpException) {
                        HttpException httpException = (HttpException) th;
                        if (httpException.code() == 401) {
                            Intent intent = new Intent(this.this$0.this$0, IntroActivity.class);
                            intent.addFlags(32768);
                            intent.addFlags(268435456);
                            this.this$0.this$0.startActivity(intent, null);
                        }
                        ResponseBody errorBody = httpException.response().errorBody();
                        if (errorBody == null) {
                            Intrinsics.throwNpe();
                        }
                        byte[] bytes = errorBody.bytes();
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "throwable.response().errorBody()!!.bytes()");
                        new JSONObject(new String(bytes, Charsets.UTF_8));
                        intent.putExtra("retry", true);
                        this.this$0.this$0.setResult(0, intent);
                        this.this$0.this$0.finish();
                        this.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
                    }
                }
            });
        }
    }
}
