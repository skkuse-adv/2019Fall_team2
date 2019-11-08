package kr.co.popone.fitts.feature.comment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.internal.ServerProtocol;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.hdodenhof.circleimageview.CircleImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostCommentAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_COMMENT_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private static final int TYPE_POST_HEADER = 0;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public final class CommentHeaderHolder extends ViewHolder {
        @NotNull
        private final Button moreComment;

        public CommentHeaderHolder(@NotNull PostCommentAdapter postCommentAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            Button button = (Button) view.findViewById(C0010R$id.more_comment_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "itemView.more_comment_button");
            this.moreComment = button;
        }

        @NotNull
        public final Button getMoreComment() {
            return this.moreComment;
        }
    }

    public final class CommentHolder extends ViewHolder {
        @NotNull
        private final TextView comment;
        @NotNull
        private final LinearLayout commentLayout;
        @NotNull
        private final TextView createAt;
        @NotNull
        private final TextView profileID;
        @NotNull
        private final CircleImageView profileImage;

        public CommentHolder(@NotNull PostCommentAdapter postCommentAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.comment_layout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "itemView.comment_layout");
            this.commentLayout = linearLayout;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profile_image);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.profile_image");
            this.profileImage = circleImageView;
            TextView textView = (TextView) view.findViewById(C0010R$id.profile_id);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.profile_id");
            this.profileID = textView;
            TextView textView2 = (TextView) view.findViewById(C0010R$id.comment);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.comment");
            this.comment = textView2;
            TextView textView3 = (TextView) view.findViewById(C0010R$id.create_at);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.create_at");
            this.createAt = textView3;
        }

        @NotNull
        public final LinearLayout getCommentLayout() {
            return this.commentLayout;
        }

        @NotNull
        public final CircleImageView getProfileImage() {
            return this.profileImage;
        }

        @NotNull
        public final TextView getProfileID() {
            return this.profileID;
        }

        @NotNull
        public final TextView getComment() {
            return this.comment;
        }

        @NotNull
        public final TextView getCreateAt() {
            return this.createAt;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate {
        @Nullable
        Integer getCommentCount();

        @NotNull
        List<Comment> getCommentList();

        boolean getReportMode();

        boolean getTotalComment();

        boolean isPostActivity();

        void onCommentIDClicked(@NotNull Comment comment);

        void onMoreCommentClicked();

        void onProfileImageClicked(@NotNull Comment comment);

        void onReportCommentClicked(@NotNull Comment comment, @NotNull View view);

        void onTotalCommentClicked();

        void setReportMode(boolean z);

        void setTotalComment(boolean z);
    }

    public final class PostHeaderHolder extends ViewHolder {
        @NotNull
        private final TextView commentCount;
        @NotNull
        private final Button totalCommentButton;

        public PostHeaderHolder(@NotNull PostCommentAdapter postCommentAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            TextView textView = (TextView) view.findViewById(C0010R$id.comment_count);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.comment_count");
            this.commentCount = textView;
            Button button = (Button) view.findViewById(C0010R$id.total_comment_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "itemView.total_comment_button");
            this.totalCommentButton = button;
        }

        @NotNull
        public final TextView getCommentCount() {
            return this.commentCount;
        }

        @NotNull
        public final Button getTotalCommentButton() {
            return this.totalCommentButton;
        }
    }

    public PostCommentAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "LayoutInflater.from(pare…nt_header, parent, false)";
        if (i == TYPE_POST_HEADER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_comment_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            return new PostHeaderHolder(this, inflate);
        } else if (i == TYPE_COMMENT_HEADER) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_comment_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            return new CommentHeaderHolder(this, inflate2);
        } else if (i == TYPE_ITEM) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_comment, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "LayoutInflater.from(pare…t_comment, parent, false)");
            return new CommentHolder(this, inflate3);
        } else {
            throw new IllegalAccessException();
        }
    }

    public int getItemViewType(int i) {
        if (i != 0) {
            return TYPE_ITEM;
        }
        if (this.delegate.isPostActivity()) {
            return TYPE_POST_HEADER;
        }
        return TYPE_COMMENT_HEADER;
    }

    private final Comment getItem(int i) {
        return (Comment) this.delegate.getCommentList().get(i);
    }

    public int getItemCount() {
        return this.delegate.getCommentList().size() + 1;
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Iterator it;
        int i2;
        ArrayList arrayList;
        ViewHolder viewHolder2 = viewHolder;
        Intrinsics.checkParameterIsNotNull(viewHolder2, "holder");
        char c = 0;
        if (viewHolder2 instanceof CommentHolder) {
            char c2 = 1;
            Comment item = getItem(i - 1);
            CommentHolder commentHolder = (CommentHolder) viewHolder2;
            commentHolder.getCommentLayout().setOnLongClickListener(new PostCommentAdapter$onBindViewHolder$1(this, item, viewHolder2));
            commentHolder.getCommentLayout().setOnClickListener(new PostCommentAdapter$onBindViewHolder$2(this, item, viewHolder2));
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
            RequestOptions requestOptions = (RequestOptions) error;
            if (Intrinsics.areEqual((Object) item.getUser().getStatus(), (Object) "deactivated")) {
                Glide.with(this.context).load(Integer.valueOf(C0008R$drawable.image_default_profile)).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) commentHolder.getProfileImage());
            } else {
                Glide.with(this.context).load(item.getUser().getProfileImageUrl()).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) commentHolder.getProfileImage());
            }
            commentHolder.getProfileImage().setOnClickListener(new PostCommentAdapter$onBindViewHolder$3(this, item));
            TextView profileID = commentHolder.getProfileID();
            profileID.setText(item.getUser().getFittsID());
            profileID.setOnClickListener(new PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$1(this, item));
            TextView comment = commentHolder.getComment();
            SpannableString spannableString = new SpannableString(item.getContent());
            if (item.getMentionees() != null) {
                Set keySet = item.getMentionees().keySet();
                Intrinsics.checkExpressionValueIsNotNull(keySet, "currentItem.mentionees.keySet()");
                Iterator it2 = keySet.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    ArrayList spans = setSpans(item.getContent(), '@');
                    int size = spans.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            Object obj = spans.get(i3);
                            Intrinsics.checkExpressionValueIsNotNull(obj, "calloutSpansFitts[i]");
                            int[] iArr = (int[]) obj;
                            int i4 = iArr[c];
                            int i5 = iArr[c2];
                            if (Intrinsics.areEqual((Object) item.getContent().subSequence(i4 + 1, i5).toString(), (Object) str)) {
                                JsonElement jsonElement = item.getMentionees().get(str);
                                String str2 = "null cannot be cast to non-null type com.google.gson.JsonObject";
                                if (jsonElement != null) {
                                    JsonElement jsonElement2 = ((JsonObject) jsonElement).get(ServerProtocol.DIALOG_PARAM_STATE);
                                    Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "(currentItem.mentionees.… JsonObject).get(\"state\")");
                                    String str3 = "(currentItem.mentionees.… as JsonObject).get(\"id\")";
                                    it = it2;
                                    String str4 = "id";
                                    arrayList = spans;
                                    String str5 = "context";
                                    if (Intrinsics.areEqual((Object) jsonElement2.getAsString(), (Object) "active")) {
                                        i2 = size;
                                        Context context2 = comment.getContext();
                                        Intrinsics.checkExpressionValueIsNotNull(context2, str5);
                                        JsonElement jsonElement3 = item.getMentionees().get(str);
                                        if (jsonElement3 != null) {
                                            JsonElement jsonElement4 = ((JsonObject) jsonElement3).get(str4);
                                            Intrinsics.checkExpressionValueIsNotNull(jsonElement4, str3);
                                            spannableString.setSpan(new CalloutLink(context2, Long.valueOf(jsonElement4.getAsLong())), i4, i5, 0);
                                        } else {
                                            throw new TypeCastException(str2);
                                        }
                                    } else {
                                        i2 = size;
                                        Context context3 = comment.getContext();
                                        Intrinsics.checkExpressionValueIsNotNull(context3, str5);
                                        JsonElement jsonElement5 = item.getMentionees().get(str);
                                        if (jsonElement5 != null) {
                                            JsonElement jsonElement6 = ((JsonObject) jsonElement5).get(str4);
                                            Intrinsics.checkExpressionValueIsNotNull(jsonElement6, str3);
                                            spannableString.setSpan(new CalloutLinkNormal(context3, Long.valueOf(jsonElement6.getAsLong())), i4, i5, 0);
                                        } else {
                                            throw new TypeCastException(str2);
                                        }
                                    }
                                } else {
                                    throw new TypeCastException(str2);
                                }
                            } else {
                                it = it2;
                                arrayList = spans;
                                i2 = size;
                            }
                            i3++;
                            it2 = it;
                            spans = arrayList;
                            size = i2;
                            c2 = 1;
                            c = 0;
                        }
                    }
                }
            }
            TextView textView = (TextView) comment.findViewById(C0010R$id.comment);
            String str6 = "comment";
            Intrinsics.checkExpressionValueIsNotNull(textView, str6);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView2 = (TextView) comment.findViewById(C0010R$id.comment);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str6);
            textView2.setText(spannableString);
            comment.setOnLongClickListener(new PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$2(this, item, viewHolder2));
            comment.setOnClickListener(new PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$3(this, item, viewHolder2));
            loadDate(commentHolder.getCreateAt(), item.getCreatedAt());
            commentHolder.getCreateAt().setOnClickListener(new PostCommentAdapter$onBindViewHolder$6(this, item, viewHolder2));
            commentHolder.getCreateAt().setOnLongClickListener(new PostCommentAdapter$onBindViewHolder$7(this, item, viewHolder2));
        } else if (viewHolder2 instanceof PostHeaderHolder) {
            PostHeaderHolder postHeaderHolder = (PostHeaderHolder) viewHolder2;
            TextView commentCount = postHeaderHolder.getCommentCount();
            StringBuilder sb = new StringBuilder();
            sb.append("댓글 (");
            sb.append(String.valueOf(this.delegate.getCommentCount()));
            sb.append(")");
            commentCount.setText(sb.toString());
            postHeaderHolder.getTotalCommentButton().setOnClickListener(new PostCommentAdapter$onBindViewHolder$8(this));
        } else if (!(viewHolder2 instanceof CommentHeaderHolder)) {
        } else {
            if (this.delegate.getTotalComment()) {
                ((CommentHeaderHolder) viewHolder2).getMoreComment().setVisibility(8);
                return;
            }
            CommentHeaderHolder commentHeaderHolder = (CommentHeaderHolder) viewHolder2;
            commentHeaderHolder.getMoreComment().setVisibility(0);
            commentHeaderHolder.getMoreComment().setOnClickListener(new PostCommentAdapter$onBindViewHolder$9(this));
        }
    }

    private final ArrayList<int[]> setSpans(String str, char c) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(c));
        sb.append("\\w+");
        Matcher matcher = Pattern.compile(sb.toString()).matcher(str);
        while (matcher.find()) {
            arrayList.add(new int[]{matcher.start(), matcher.end()});
        }
        return arrayList;
    }

    @SuppressLint({"SetTextI18n"})
    private final void loadDate(TextView textView, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M월 d일", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(text)");
        long time = date.getTime() - parse.getTime();
        if (time < 60000) {
            textView.setText("방금 전");
        } else if (time < 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time < 86400000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time / 3600000));
            sb2.append("시간 전");
            textView.setText(sb2.toString());
        } else if (time < 604800000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time / 86400000));
            sb3.append("일 전");
            textView.setText(sb3.toString());
        } else {
            textView.setText(simpleDateFormat2.format(parse).toString());
        }
    }
}
