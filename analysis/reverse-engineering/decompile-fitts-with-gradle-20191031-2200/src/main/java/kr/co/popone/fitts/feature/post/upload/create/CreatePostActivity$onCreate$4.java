package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.internals.AnkoInternals;

final class CreatePostActivity$onCreate$4<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$4(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().searchShopButtonClicked(new Function0<Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$4 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                CreatePostActivity createPostActivity = this.this$0.this$0;
                Parameters parameters = new Parameters("쇼핑몰홈 링크 주소가 아닌\n상세페이지 링크 주소가 맞는지 확인해주세요", null, null, null, 14, null);
                createPostActivity.activityStartForResult(AnkoInternals.createIntent(createPostActivity, ShopSearchActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}), 100, ActivityAnimationType.SLIDE_RTOL.getEnter(), ActivityAnimationType.SLIDE_RTOL.getExit());
            }
        });
    }
}
