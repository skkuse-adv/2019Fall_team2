package kr.co.popone.fitts.feature.comment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.kakao.message.template.MessageTemplateProtocol;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import kr.co.popone.fitts.model.post.PostAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class CommentsActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAM_POST_OWNER = "post_owner";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public ArrayList<Comment> commentItemList = new ArrayList<>();
    private int commentListCount;
    /* access modifiers changed from: private */
    public Disposable commentListRequest;
    /* access modifiers changed from: private */
    public Disposable deleteCommentRequest;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public boolean isPostOwner;
    private final int limit = 10;
    /* access modifiers changed from: private */
    public Disposable moreCommentListRequest;
    @NotNull
    public PostAPI postAPI;
    private long postID = -1;
    /* access modifiers changed from: private */
    public Disposable putCommentRequest;
    /* access modifiers changed from: private */
    public Disposable reportCommentRequest;
    @Nullable
    private View reportCommentView;
    @NotNull
    public SessionManager sessionManager;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final PostAPI getPostAPI() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final long getPostID() {
        return this.postID;
    }

    public final void setPostID(long j) {
        this.postID = j;
    }

    public final int getCommentListCount() {
        return this.commentListCount;
    }

    public final void setCommentListCount(int i) {
        this.commentListCount = i;
    }

    @Nullable
    public final View getReportCommentView() {
        return this.reportCommentView;
    }

    public final void setReportCommentView(@Nullable View view) {
        this.reportCommentView = view;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_comment);
        ((ImageButton) _$_findCachedViewById(C0010R$id.back_button)).setOnClickListener(new CommentsActivity$onCreate$1(this));
        this.postID = getIntent().getLongExtra("comment_post_id", -1);
        this.isPostOwner = getIntent().getBooleanExtra(PARAM_POST_OWNER, false);
        this.commentListCount = getIntent().getIntExtra(MessageTemplateProtocol.COMMENT_COUNT, 0);
        Disposable disposable = this.commentListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        this.commentListRequest = postAPI2.getComments(this.postID, null, this.limit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CommentsActivity$onCreate$2<Object,Object>(this));
    }

    public void onBackPressed() {
        hideKeyboard();
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    public final void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final void showKeyboard() {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).toggleSoftInput(2, 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "comment_message")
    @SuppressLint({"SetTextI18n"})
    public final void onReceive(@NotNull Message message) {
        Message message2 = message;
        Intrinsics.checkParameterIsNotNull(message2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (message2.what == 1 && message.getData().getLong("postId") == this.postID) {
            String str = ")";
            String str2 = "댓글 (";
            String str3 = "comment_title";
            String str4 = "null cannot be cast to non-null type kr.co.popone.fitts.model.datamodel.service.post.Comment";
            String str5 = "comment_list";
            if (message.getData().getBoolean("isAddedComment")) {
                ArrayList<Comment> arrayList = this.commentItemList;
                Serializable serializable = message.getData().getSerializable("addComment");
                if (serializable != null) {
                    arrayList.add((Comment) serializable);
                    this.commentListCount++;
                    RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.comment_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView, str5);
                    Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(0);
                    }
                    RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.comment_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str5);
                    Adapter adapter2 = recyclerView2.getAdapter();
                    if (adapter2 != null) {
                        adapter2.notifyItemInserted(this.commentItemList.size());
                    }
                    TextView textView = (TextView) _$_findCachedViewById(C0010R$id.comment_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView, str3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(String.valueOf(this.commentListCount));
                    sb.append(str);
                    textView.setText(sb.toString());
                } else {
                    throw new TypeCastException(str4);
                }
            } else {
                ArrayList<Comment> arrayList2 = this.commentItemList;
                ArrayList<Comment> arrayList3 = new ArrayList<>();
                for (Object next : arrayList2) {
                    long id = ((Comment) next).getId();
                    Serializable serializable2 = message.getData().getSerializable("removeComment");
                    if (serializable2 != null) {
                        if (id == ((Comment) serializable2).getId()) {
                            arrayList3.add(next);
                        }
                    } else {
                        throw new TypeCastException(str4);
                    }
                }
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                for (Comment remove : arrayList3) {
                    this.commentItemList.remove(remove);
                    this.commentListCount--;
                    RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.comment_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str5);
                    Adapter adapter3 = recyclerView3.getAdapter();
                    if (adapter3 != null) {
                        adapter3.notifyDataSetChanged();
                    }
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.comment_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(String.valueOf(this.commentListCount));
                    sb2.append(str);
                    textView2.setText(sb2.toString());
                    arrayList4.add(Unit.INSTANCE);
                }
            }
            ((RecyclerView) _$_findCachedViewById(C0010R$id.comment_list)).smoothScrollToPosition(this.commentItemList.size());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.commentListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.moreCommentListRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.putCommentRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.reportCommentRequest;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.deleteCommentRequest;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        this.commentListRequest = null;
        this.moreCommentListRequest = null;
        this.putCommentRequest = null;
        this.reportCommentRequest = null;
        this.deleteCommentRequest = null;
        this.postID = -1;
        this.commentListCount = 0;
        this.commentItemList = new ArrayList<>();
        this.reportCommentView = null;
        super.onDestroy();
    }
}
