package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostViewDataExtensionKt;
import retrofit2.HttpException;

final class CreatePostViewModel$shopLinkTextChanged$1<T1, T2> implements BiConsumer<LinkInfo, Throwable> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$shopLinkTextChanged$1(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(LinkInfo linkInfo, Throwable th) {
        if (!(th instanceof HttpException) || ((HttpException) th).code() != 403) {
            if (this.this$0.isPostValidateMode) {
                if (PostViewDataExtensionKt.isShopLinkValidate(this.this$0.getPostViewData())) {
                    this.this$0.getShopLinkValidate().onNext(ValidationTextColor.VALID);
                } else {
                    this.this$0.getShopLinkValidate().onNext(ValidationTextColor.INVALID);
                }
            }
            this.this$0.getPostViewData().setBlockedLink(false);
            this.this$0.getShopBlockValidate().onNext(Integer.valueOf(8));
            return;
        }
        this.this$0.getPostViewData().setBlockedLink(true);
        this.this$0.getShopBlockValidate().onNext(Integer.valueOf(0));
        this.this$0.getShopLinkValidate().onNext(ValidationTextColor.INVALID);
    }
}
