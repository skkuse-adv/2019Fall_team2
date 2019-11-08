package kr.co.popone.fitts.feature.event;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.event.ImagesAdapter.Delegate;
import org.jetbrains.annotations.NotNull;

final class MultiImageEventActivity$imagesAdapter$2 extends Lambda implements Function0<ImagesAdapter> {
    final /* synthetic */ MultiImageEventActivity this$0;

    MultiImageEventActivity$imagesAdapter$2(MultiImageEventActivity multiImageEventActivity) {
        this.this$0 = multiImageEventActivity;
        super(0);
    }

    @NotNull
    public final ImagesAdapter invoke() {
        MultiImageEventActivity multiImageEventActivity = this.this$0;
        return new ImagesAdapter(multiImageEventActivity, multiImageEventActivity.windowSize, new Delegate(this) {
            final /* synthetic */ MultiImageEventActivity$imagesAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
                if (r2 != null) goto L_0x0034;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void actionButtonClicked() {
                /*
                    r4 = this;
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity$imagesAdapter$2 r0 = r4.this$0
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity r0 = r0.this$0
                    kr.co.popone.fitts.eventtracker.EventTracker r0 = r0.getEventTracker$app_productionFittsRelease()
                    r1 = 0
                    java.lang.String r2 = "Tap Action Button On RPC"
                    r3 = 2
                    kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls.logCustom$default(r0, r2, r1, r3, r1)
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity$imagesAdapter$2 r0 = r4.this$0
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity r0 = r0.this$0
                    kr.co.popone.fitts.services.FittsSchemeHandler r0 = r0.getSchemeHandler$app_productionFittsRelease()
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity$imagesAdapter$2 r1 = r4.this$0
                    kr.co.popone.fitts.feature.event.MultiImageEventActivity r1 = r1.this$0
                    kr.co.popone.fitts.feature.event.ImagesAdapter r2 = r1.getImagesAdapter()
                    kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r2 = r2.getRemotePushContent()
                    if (r2 == 0) goto L_0x0032
                    kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r2 = r2.getButton()
                    if (r2 == 0) goto L_0x0032
                    java.lang.String r2 = r2.getActionScheme()
                    if (r2 == 0) goto L_0x0032
                    goto L_0x0034
                L_0x0032:
                    java.lang.String r2 = ""
                L_0x0034:
                    r0.handleScheme(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.MultiImageEventActivity$imagesAdapter$2.AnonymousClass1.actionButtonClicked():void");
            }
        });
    }
}
