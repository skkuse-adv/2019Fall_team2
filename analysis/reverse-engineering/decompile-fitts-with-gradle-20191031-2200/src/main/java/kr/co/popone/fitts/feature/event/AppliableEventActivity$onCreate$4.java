package kr.co.popone.fitts.feature.event;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.message.template.MessageTemplateProtocol;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.orhanobut.logger.Logger;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;

final class AppliableEventActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ AppliableEventActivity this$0;

    AppliableEventActivity$onCreate$4(AppliableEventActivity appliableEventActivity) {
        this.this$0 = appliableEventActivity;
    }

    public final void onClick(View view) {
        final AppliableEventResponse access$getEventResponse$p = this.this$0.eventResponse;
        if (access$getEventResponse$p != null) {
            String sharedLink = access$getEventResponse$p.getSharedLink();
            if (!(sharedLink == null || StringsKt__StringsJVMKt.isBlank(sharedLink))) {
                StringBuilder sb = new StringBuilder();
                sb.append("show share UI with ");
                sb.append(access$getEventResponse$p.getSharedLink());
                Logger.d(sb.toString(), new Object[0]);
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.this$0);
                bottomSheetDialog.setContentView((int) C0013R$layout.post_bottom_dialog);
                View findViewById = bottomSheetDialog.findViewById(C0010R$id.deletePostLayout);
                if (findViewById == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "dialog.findViewById<View>(R.id.deletePostLayout)!!");
                findViewById.setVisibility(8);
                View findViewById2 = bottomSheetDialog.findViewById(C0010R$id.share_facebook);
                if (findViewById2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(findViewById2, "dialog.findViewById<View>(R.id.share_facebook)!!");
                findViewById2.setVisibility(8);
                View findViewById3 = bottomSheetDialog.findViewById(C0010R$id.declaration_post);
                if (findViewById3 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(findViewById3, "dialog.findViewById<View>(R.id.declaration_post)!!");
                findViewById3.setVisibility(8);
                View findViewById4 = bottomSheetDialog.findViewById(C0010R$id.share_link);
                if (findViewById4 == null) {
                    Intrinsics.throwNpe();
                }
                findViewById4.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AppliableEventActivity$onCreate$4 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(View view) {
                        DefaultImpls.logCustom$default(this.this$0.this$0.getEventTracker$app_productionFittsRelease(), "Tap Copy Link For Invitation", null, 2, null);
                        Object systemService = this.this$0.this$0.getSystemService("clipboard");
                        if (systemService != null) {
                            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(MessageTemplateProtocol.LINK, access$getEventResponse$p.getSharedLink()));
                            bottomSheetDialog.dismiss();
                            Snackbar.Companion.showMessage(this.this$0.this$0, "링크가 복사되었습니다");
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
                    }
                });
                View findViewById5 = bottomSheetDialog.findViewById(C0010R$id.share_kakao);
                if (findViewById5 == null) {
                    Intrinsics.throwNpe();
                }
                findViewById5.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AppliableEventActivity$onCreate$4 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(View view) {
                        DefaultImpls.logCustom$default(this.this$0.this$0.getEventTracker$app_productionFittsRelease(), "Tap KakaoTalk Share For Invitation", null, 2, null);
                        KakaoLinkService.getInstance().sendScrap(this.this$0.this$0, access$getEventResponse$p.getSharedLink(), new ResponseCallback<KakaoLinkResponse>(this) {
                            final /* synthetic */ AnonymousClass2 this$0;

                            public void onSuccess(@NotNull KakaoLinkResponse kakaoLinkResponse) {
                                Intrinsics.checkParameterIsNotNull(kakaoLinkResponse, "result");
                            }

                            {
                                this.this$0 = r1;
                            }

                            public void onFailure(@NotNull ErrorResult errorResult) {
                                Intrinsics.checkParameterIsNotNull(errorResult, "errorResult");
                                Logger.e(errorResult.toString(), new Object[0]);
                                bottomSheetDialog.dismiss();
                                Snackbar.Companion.showMessage(this.this$0.this$0.this$0, "카카오톡이 설치 되어 있지 않습니다.");
                            }
                        });
                    }
                });
                bottomSheetDialog.show();
            }
        }
    }
}
