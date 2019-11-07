package kr.co.popone.fitts.feature.comment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.utils.Snackbar;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

final class CommentsActivity$onCreate$2<T1, T2> implements BiConsumer<ArrayList<Comment>, Throwable> {
    final /* synthetic */ CommentsActivity this$0;

    CommentsActivity$onCreate$2(CommentsActivity commentsActivity) {
        this.this$0 = commentsActivity;
    }

    public final void accept(ArrayList<Comment> arrayList, Throwable th) {
        this.this$0.commentListRequest = null;
        if (arrayList != null) {
            this.this$0.commentItemList = arrayList;
            CollectionsKt___CollectionsJvmKt.reverse(this.this$0.commentItemList);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.comment_title);
            Intrinsics.checkExpressionValueIsNotNull(textView, "comment_title");
            StringBuilder sb = new StringBuilder();
            sb.append("댓글 (");
            sb.append(String.valueOf(this.this$0.getCommentListCount()));
            sb.append(")");
            textView.setText(sb.toString());
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.comment_list);
            recyclerView.setAdapter(new PostCommentAdapter(this.this$0, new CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1(recyclerView, this, arrayList)));
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.smoothScrollToPosition(this.this$0.commentItemList.size());
            recyclerView.addOnLayoutChangeListener(new CommentsActivity$onCreate$2$$special$$inlined$run$lambda$2(recyclerView, this, arrayList));
            ((Button) this.this$0._$_findCachedViewById(C0010R$id.comment_posting)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CommentsActivity$onCreate$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    EditText editText = (EditText) this.this$0.this$0._$_findCachedViewById(C0010R$id.edit_comment);
                    String str = "edit_comment";
                    Intrinsics.checkExpressionValueIsNotNull(editText, str);
                    if ((editText.getText().toString().length() > 0) && this.this$0.this$0.putCommentRequest == null) {
                        this.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom("Feedback", new CustomAttributes().put("type", "comment"));
                        DefaultImpls.logCustom$default(this.this$0.this$0.getEventTracker$app_productionFittsRelease(), "Comment", null, 2, null);
                        CommentsActivity commentsActivity = this.this$0.this$0;
                        PostAPI postAPI = commentsActivity.getPostAPI();
                        long postID = this.this$0.this$0.getPostID();
                        EditText editText2 = (EditText) this.this$0.this$0._$_findCachedViewById(C0010R$id.edit_comment);
                        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
                        commentsActivity.putCommentRequest = postAPI.postComment(postID, editText2.getText().toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<Comment, Throwable>(this) {
                            final /* synthetic */ AnonymousClass3 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void accept(Comment comment, Throwable th) {
                                this.this$0.this$0.this$0.putCommentRequest = null;
                                if (comment != null) {
                                    Message message = new Message();
                                    message.what = 1;
                                    Bundle bundle = new Bundle();
                                    bundle.putLong("postId", this.this$0.this$0.this$0.getPostID());
                                    bundle.putBoolean("isAddedComment", true);
                                    bundle.putSerializable("addComment", comment);
                                    message.setData(bundle);
                                    EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                                    EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                                    EventBus.getDefault().post(message, AppManager.COMMENT_MESSAGE);
                                    EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
                                    EditText editText = (EditText) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.edit_comment);
                                    Intrinsics.checkExpressionValueIsNotNull(editText, "edit_comment");
                                    editText.setText(null);
                                    this.this$0.this$0.this$0.hideKeyboard();
                                    ((RecyclerView) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.comment_list)).smoothScrollToPosition(this.this$0.this$0.this$0.commentItemList.size());
                                    return;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("error occured ");
                                sb.append(th);
                                Logger.d(sb.toString(), new Object[0]);
                                if (!(th instanceof HttpException)) {
                                    Snackbar.Companion.showMessage(this.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                                } else if (((HttpException) th).code() == 401) {
                                    Intent intent = new Intent(this.this$0.this$0.this$0, IntroActivity.class);
                                    intent.addFlags(32768);
                                    intent.addFlags(268435456);
                                    this.this$0.this$0.this$0.startActivity(intent);
                                }
                            }
                        });
                    }
                }
            });
            EventBus.getDefault().register(this.this$0);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
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
