package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.dialog.PostTypeSelectDialog;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class CreatePostActivityUtil$getBannerList$1<T> implements Consumer<List<? extends Banner>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ String $from;
    final /* synthetic */ CreatePostActivityUtil this$0;

    CreatePostActivityUtil$getBannerList$1(CreatePostActivityUtil createPostActivityUtil, Activity activity, String str, Function0 function0) {
        this.this$0 = createPostActivityUtil;
        this.$activity = activity;
        this.$from = str;
        this.$dismiss = function0;
    }

    public final void accept(List<Banner> list) {
        PostTypeSelectDialog access$createDialog = this.this$0.createDialog(this.$activity, this.$from, this.$dismiss);
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        access$createDialog.updateBanner((Banner) CollectionsKt___CollectionsKt.firstOrNull(list));
        access$createDialog.show();
    }
}
