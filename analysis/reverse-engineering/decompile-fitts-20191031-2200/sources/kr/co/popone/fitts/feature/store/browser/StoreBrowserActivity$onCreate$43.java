package kr.co.popone.fitts.feature.store.browser;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.WhenMappings;
import kr.co.popone.fitts.model.product.AffiliatesProductRestrictState;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserActivity$onCreate$43 implements OnClickListener {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$43(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().handleRestrictType(new Function1<AffiliatesProductRestrictState, Unit>(this) {
            final /* synthetic */ StoreBrowserActivity$onCreate$43 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AffiliatesProductRestrictState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull AffiliatesProductRestrictState affiliatesProductRestrictState) {
                Intrinsics.checkParameterIsNotNull(affiliatesProductRestrictState, "restrictType");
                int i = WhenMappings.$EnumSwitchMapping$0[affiliatesProductRestrictState.ordinal()];
                if (i == 1) {
                    this.this$0.this$0.getOptionSelectDialog().show();
                } else if (i == 2) {
                    DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "", "회차당 1개의 상품만 구매 가능합니다.", AnonymousClass1.INSTANCE, "확인");
                } else if (i == 3) {
                    this.this$0.this$0.hadleSchemeByBuildConfig("fitts://collection/84?type=mixed", "fitts://collection/268?type=mixed");
                } else if (i == 4) {
                    this.this$0.this$0.hadleSchemeByBuildConfig("fitts://collection/91?type=mixed", "fitts://collection/276?type=mixed");
                } else if (i == 5) {
                    DialogExtensions.INSTANCE.showConfirmDialog(this.this$0.this$0, "핏츠카드의 미션을 달성해주세요🏃‍♀️", "포스팅 미션을 달성하셔야\n참여하실 수 있어요!", AnonymousClass2.INSTANCE, new Function0<Unit>(this) {
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            this.this$0.this$0.this$0.getViewModel().handleScheme(this.this$0.this$0.this$0, "fitts://fittscard");
                        }
                    }, "확인", "미션 보러가기", ContextCompat.getColor(this.this$0.this$0, C0006R$color.point));
                }
            }
        });
    }
}
