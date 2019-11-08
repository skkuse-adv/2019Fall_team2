package kr.co.popone.fitts.feature.comment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.kakao.network.ServerProtocol;
import com.orhanobut.logger.Logger;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.feature.comment.PostCommentAdapter.Delegate;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

public final class CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ ArrayList $commentsResult$inlined;
    final /* synthetic */ RecyclerView $this_run;
    private boolean reportMode;
    final /* synthetic */ CommentsActivity$onCreate$2 this$0;
    private boolean totalComment;

    public boolean isPostActivity() {
        return false;
    }

    public void onTotalCommentClicked() {
    }

    CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1(RecyclerView recyclerView, CommentsActivity$onCreate$2 commentsActivity$onCreate$2, ArrayList arrayList) {
        this.$this_run = recyclerView;
        this.this$0 = commentsActivity$onCreate$2;
        this.$commentsResult$inlined = arrayList;
        this.totalComment = this.$commentsResult$inlined.size() < 10;
    }

    public boolean getReportMode() {
        return this.reportMode;
    }

    public void setReportMode(boolean z) {
        this.reportMode = z;
    }

    @NotNull
    public List<Comment> getCommentList() {
        return this.this$0.this$0.commentItemList;
    }

    @Nullable
    public Integer getCommentCount() {
        return Integer.valueOf(this.this$0.this$0.getCommentListCount());
    }

    public boolean getTotalComment() {
        return this.totalComment;
    }

    public void setTotalComment(boolean z) {
        this.totalComment = z;
    }

    public void onProfileImageClicked(@NotNull Comment comment) {
        Intrinsics.checkParameterIsNotNull(comment, "data");
        if (Intrinsics.areEqual((Object) comment.getUser().getStatus(), (Object) "deactivated")) {
            Snackbar.Companion.showMessage(this.this$0.this$0, "탈퇴한 사용자입니다");
            return;
        }
        this.this$0.this$0.hideKeyboard();
        ShowRoomActivity.Companion.start(this.this$0.this$0, Long.valueOf(comment.getUser().getId()), "comment");
    }

    public void onCommentIDClicked(@NotNull Comment comment) {
        Intrinsics.checkParameterIsNotNull(comment, "data");
        EditText editText = (EditText) this.this$0.this$0._$_findCachedViewById(C0010R$id.edit_comment);
        boolean z = editText.getText().toString().length() == 0;
        String str = ServerProtocol.AUTHORIZATION_HEADER_DELIMITER;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("@");
            sb.append(comment.getUser().getFittsID());
            sb.append(str);
            editText.setText(sb.toString(), BufferType.EDITABLE);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(editText.getText().toString());
            sb2.append(" @");
            sb2.append(comment.getUser().getFittsID());
            sb2.append(str);
            editText.setText(sb2.toString(), BufferType.EDITABLE);
        }
        editText.setSelection(editText.getText().toString().length());
        editText.requestFocus();
        this.this$0.this$0.showKeyboard();
    }

    public void onMoreCommentClicked() {
        if (this.this$0.this$0.moreCommentListRequest == null) {
            CommentsActivity commentsActivity = this.this$0.this$0;
            commentsActivity.moreCommentListRequest = commentsActivity.getPostAPI().getComments(this.this$0.this$0.getPostID(), Long.valueOf(((Comment) this.this$0.this$0.commentItemList.get(0)).getId()), this.this$0.this$0.getLimit()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<ArrayList<Comment>, Throwable>(this) {
                final /* synthetic */ CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(ArrayList<Comment> arrayList, Throwable th) {
                    this.this$0.this$0.this$0.moreCommentListRequest = null;
                    if (arrayList != null) {
                        if (arrayList.size() < 10) {
                            this.this$0.setTotalComment(true);
                        }
                        CollectionsKt___CollectionsJvmKt.reverse(arrayList);
                        this.this$0.this$0.this$0.commentItemList.addAll(0, arrayList);
                        Adapter adapter = this.this$0.$this_run.getAdapter();
                        if (adapter != null) {
                            adapter.notifyItemRangeInserted(0, arrayList.size());
                        }
                    } else if (!(th instanceof HttpException)) {
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

    public void onReportCommentClicked(@NotNull final Comment comment, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(comment, "data");
        Intrinsics.checkParameterIsNotNull(view, "view");
        ((TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.delete_title)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                if (this.this$0.this$0.this$0.deleteCommentRequest == null) {
                    CommentsActivity commentsActivity = this.this$0.this$0.this$0;
                    commentsActivity.deleteCommentRequest = commentsActivity.getPostAPI().deleteComment(comment.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                        final /* synthetic */ AnonymousClass2 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void accept(String str, Throwable th) {
                            this.this$0.this$0.this$0.this$0.deleteCommentRequest = null;
                            if (str != null) {
                                Message message = new Message();
                                message.what = 1;
                                Bundle bundle = new Bundle();
                                bundle.putLong("postId", this.this$0.this$0.this$0.this$0.getPostID());
                                bundle.putBoolean("isAddedComment", false);
                                bundle.putSerializable("removeComment", comment);
                                message.setData(bundle);
                                EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                                EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                                EventBus.getDefault().post(message, AppManager.COMMENT_MESSAGE);
                                EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
                                Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0, "정상적으로 삭제되었습니다");
                                this.this$0.this$0.setReportMode(false);
                                View reportCommentView = this.this$0.this$0.this$0.this$0.getReportCommentView();
                                if (reportCommentView == null) {
                                    Intrinsics.throwNpe();
                                }
                                reportCommentView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                this.this$0.this$0.this$0.this$0.setReportCommentView(null);
                                ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report);
                                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "app_bar_report");
                                constraintLayout.setVisibility(8);
                                ((ConstraintLayout) this.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report)).startAnimation(AnimationUtils.loadAnimation(this.this$0.this$0.$this_run.getContext(), C0001R$anim.slide_left_out));
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("error occured ");
                            sb.append(th);
                            Logger.d(sb.toString(), new Object[0]);
                            if (!(th instanceof HttpException)) {
                                Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                            } else if (((HttpException) th).code() == 401) {
                                Intent intent = new Intent(this.this$0.this$0.this$0.this$0, IntroActivity.class);
                                intent.addFlags(32768);
                                intent.addFlags(268435456);
                                this.this$0.this$0.this$0.this$0.startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
        ((TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.report_title)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                final Dialog dialog = new Dialog(this.this$0.this$0.this$0);
                dialog.requestWindowFeature(1);
                dialog.setContentView(C0013R$layout.report_comment_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialog.findViewById(C0010R$id.comment_report1).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(View view) {
                        if (this.this$0.this$0.this$0.this$0.reportCommentRequest == null) {
                            CommentsActivity commentsActivity = this.this$0.this$0.this$0.this$0;
                            commentsActivity.reportCommentRequest = commentsActivity.getPostAPI().reportComment(comment.getId(), "insult").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                                final /* synthetic */ AnonymousClass1 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public final void accept(String str, Throwable th) {
                                    this.this$0.this$0.this$0.this$0.this$0.reportCommentRequest = null;
                                    if (str != null) {
                                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, "정상적으로 신고되었습니다");
                                        if (this.this$0.this$0.this$0.this$0.this$0.getReportCommentView() != null) {
                                            this.this$0.this$0.this$0.setReportMode(false);
                                            View reportCommentView = this.this$0.this$0.this$0.this$0.this$0.getReportCommentView();
                                            if (reportCommentView == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            reportCommentView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                            this.this$0.this$0.this$0.this$0.this$0.setReportCommentView(null);
                                            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report);
                                            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "app_bar_report");
                                            constraintLayout.setVisibility(8);
                                            ((ConstraintLayout) this.this$0.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report)).startAnimation(AnimationUtils.loadAnimation(this.this$0.this$0.this$0.this$0.this$0, C0001R$anim.slide_left_out));
                                            return;
                                        }
                                        return;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("error occured ");
                                    sb.append(th);
                                    Logger.d(sb.toString(), new Object[0]);
                                    if (th instanceof HttpException) {
                                        HttpException httpException = (HttpException) th;
                                        if (httpException.code() == 401) {
                                            Intent intent = new Intent(this.this$0.this$0.this$0.this$0.this$0, IntroActivity.class);
                                            intent.addFlags(32768);
                                            intent.addFlags(268435456);
                                            this.this$0.this$0.this$0.this$0.this$0.startActivity(intent);
                                        } else if (httpException.code() == 409) {
                                            Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, "이미 신고 되었습니다.");
                                        } else {
                                            ResponseBody errorBody = httpException.response().errorBody();
                                            if (errorBody == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            byte[] bytes = errorBody.bytes();
                                            Intrinsics.checkExpressionValueIsNotNull(bytes, "throwable.response().errorBody()!!.bytes()");
                                            String string = new JSONObject(new String(bytes, Charsets.UTF_8)).getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
                                            Intrinsics.checkExpressionValueIsNotNull(string, "errorBody.getString(\"message\")");
                                            Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, string);
                                        }
                                    } else {
                                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                                    }
                                }
                            });
                        }
                        dialog.dismiss();
                    }
                });
                dialog.findViewById(C0010R$id.comment_report2).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(View view) {
                        if (this.this$0.this$0.this$0.this$0.reportCommentRequest == null) {
                            CommentsActivity commentsActivity = this.this$0.this$0.this$0.this$0;
                            commentsActivity.reportCommentRequest = commentsActivity.getPostAPI().reportComment(comment.getId(), "spam").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                                final /* synthetic */ AnonymousClass2 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public final void accept(String str, Throwable th) {
                                    this.this$0.this$0.this$0.this$0.this$0.reportCommentRequest = null;
                                    if (str != null) {
                                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, "정상적으로 신고되었습니다");
                                        if (this.this$0.this$0.this$0.this$0.this$0.getReportCommentView() != null) {
                                            this.this$0.this$0.this$0.setReportMode(false);
                                            View reportCommentView = this.this$0.this$0.this$0.this$0.this$0.getReportCommentView();
                                            if (reportCommentView == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            reportCommentView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                            this.this$0.this$0.this$0.this$0.this$0.setReportCommentView(null);
                                            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report);
                                            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "app_bar_report");
                                            constraintLayout.setVisibility(8);
                                            ((ConstraintLayout) this.this$0.this$0.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report)).startAnimation(AnimationUtils.loadAnimation(this.this$0.this$0.this$0.this$0.this$0, C0001R$anim.slide_left_out));
                                        }
                                    } else if (th instanceof HttpException) {
                                        HttpException httpException = (HttpException) th;
                                        if (httpException.code() == 401) {
                                            Intent intent = new Intent(this.this$0.this$0.this$0.this$0.this$0, IntroActivity.class);
                                            intent.addFlags(32768);
                                            intent.addFlags(268435456);
                                            this.this$0.this$0.this$0.this$0.this$0.startActivity(intent);
                                        }
                                        ResponseBody errorBody = httpException.response().errorBody();
                                        if (errorBody == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        byte[] bytes = errorBody.bytes();
                                        Intrinsics.checkExpressionValueIsNotNull(bytes, "throwable.response().errorBody()!!.bytes()");
                                        String string = new JSONObject(new String(bytes, Charsets.UTF_8)).getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
                                        Intrinsics.checkExpressionValueIsNotNull(string, "errorBody.getString(\"message\")");
                                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, string);
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("error occured ");
                                        sb.append(th);
                                        Logger.d(sb.toString(), new Object[0]);
                                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                                    }
                                }
                            });
                        }
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.delete_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "delete_title");
        int i = 8;
        textView.setVisibility((Intrinsics.areEqual((Object) comment.getUser().getFittsID(), (Object) this.this$0.this$0.getSessionManager$app_productionFittsRelease().getFittsID()) || this.this$0.this$0.isPostOwner) ? 0 : 8);
        TextView textView2 = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.report_title);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "report_title");
        if (!Intrinsics.areEqual((Object) comment.getUser().getFittsID(), (Object) this.this$0.this$0.getSessionManager$app_productionFittsRelease().getFittsID())) {
            i = 0;
        }
        textView2.setVisibility(i);
        if (!getReportMode()) {
            setReportMode(true);
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "app_bar_report");
            constraintLayout.setVisibility(0);
            ((ConstraintLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report)).startAnimation(AnimationUtils.loadAnimation(this.$this_run.getContext(), C0001R$anim.slide_right));
            ((ImageButton) this.this$0.this$0._$_findCachedViewById(C0010R$id.report_back)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CommentsActivity$onCreate$2$$special$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    if (this.this$0.this$0.this$0.getReportCommentView() != null) {
                        this.this$0.setReportMode(false);
                        View reportCommentView = this.this$0.this$0.this$0.getReportCommentView();
                        if (reportCommentView == null) {
                            Intrinsics.throwNpe();
                        }
                        reportCommentView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        this.this$0.this$0.this$0.setReportCommentView(null);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "app_bar_report");
                        constraintLayout.setVisibility(8);
                        ((ConstraintLayout) this.this$0.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar_report)).startAnimation(AnimationUtils.loadAnimation(this.this$0.$this_run.getContext(), C0001R$anim.slide_left_out));
                    }
                }
            });
        }
        if (this.this$0.this$0.getReportCommentView() != null) {
            View reportCommentView = this.this$0.this$0.getReportCommentView();
            if (reportCommentView == null) {
                Intrinsics.throwNpe();
            }
            reportCommentView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.this$0.this$0.setReportCommentView(null);
        }
        this.this$0.this$0.setReportCommentView(view);
        view.setBackgroundColor(Color.parseColor("#EFF1F5"));
    }
}
