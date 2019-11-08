package kr.co.popone.fitts.feature.post.upload.preview;

import android.content.Intent;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity.PreviewType;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class PostPreviewActivity$onCreate$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ CreatePost $createPost;
    final /* synthetic */ PostPreviewActivity this$0;

    PostPreviewActivity$onCreate$1(PostPreviewActivity postPreviewActivity, CreatePost createPost) {
        this.this$0 = postPreviewActivity;
        this.$createPost = createPost;
    }

    public final void accept(final MyInfo myInfo, Throwable th) {
        this.this$0.userInfoRequest = null;
        if (myInfo != null) {
            if (this.this$0.getPreviewType() == PreviewType.CreatePost) {
                this.this$0.requiresAdditionalInfo = myInfo.getRequiredAdditionalInfo();
                Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.create_post_button);
                String str = "create_post_button";
                Intrinsics.checkExpressionValueIsNotNull(button, str);
                button.setVisibility(0);
                Button button2 = (Button) this.this$0._$_findCachedViewById(C0010R$id.create_post_button);
                Intrinsics.checkExpressionValueIsNotNull(button2, str);
                button2.setText(this.this$0.requiresAdditionalInfo ? "다음" : "게시");
            }
            Disposable access$getLinkInfoRequest$p = this.this$0.linkInfoRequest;
            if (access$getLinkInfoRequest$p != null) {
                access$getLinkInfoRequest$p.dispose();
            }
            PostPreviewActivity postPreviewActivity = this.this$0;
            postPreviewActivity.linkInfoRequest = postPreviewActivity.getPostAPI().requestLinkInfo(this.$createPost.getShop()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<LinkInfo, Throwable>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(LinkInfo linkInfo, Throwable th) {
                    this.this$0.this$0.linkInfoRequest = null;
                    RecyclerView recyclerView = (RecyclerView) this.this$0.this$0._$_findCachedViewById(C0010R$id.preview_post);
                    recyclerView.setAdapter(new PostPreviewAdapter(this.this$0.this$0, new PostPreviewActivity$onCreate$1$1$$special$$inlined$run$lambda$1(this, linkInfo)));
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
