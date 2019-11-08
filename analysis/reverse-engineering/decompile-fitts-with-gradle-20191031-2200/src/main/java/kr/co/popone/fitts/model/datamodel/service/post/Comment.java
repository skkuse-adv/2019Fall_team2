package kr.co.popone.fitts.model.datamodel.service.post;

import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.kakao.message.template.MessageTemplateProtocol;
import com.uber.rave.annotation.Validated;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Comment implements Serializable {
    @NotNull
    private final String content;
    @SerializedName("created_at")
    @NotNull
    private final String createdAt;
    private final long id;
    @Nullable
    private final JsonObject mentionees;
    @NotNull
    private final User user;

    @NotNull
    public static /* synthetic */ Comment copy$default(Comment comment, long j, User user2, String str, JsonObject jsonObject, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = comment.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            user2 = comment.user;
        }
        User user3 = user2;
        if ((i & 4) != 0) {
            str = comment.content;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            jsonObject = comment.mentionees;
        }
        JsonObject jsonObject2 = jsonObject;
        if ((i & 16) != 0) {
            str2 = comment.createdAt;
        }
        return comment.copy(j2, user3, str3, jsonObject2, str2);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    @Nullable
    public final JsonObject component4() {
        return this.mentionees;
    }

    @NotNull
    public final String component5() {
        return this.createdAt;
    }

    @NotNull
    public final Comment copy(long j, @NotNull User user2, @NotNull String str, @Nullable JsonObject jsonObject, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(user2, "user");
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.CONTENT);
        Intrinsics.checkParameterIsNotNull(str2, "createdAt");
        Comment comment = new Comment(j, user2, str, jsonObject, str2);
        return comment;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Comment) {
                Comment comment = (Comment) obj;
                if (!(this.id == comment.id) || !Intrinsics.areEqual((Object) this.user, (Object) comment.user) || !Intrinsics.areEqual((Object) this.content, (Object) comment.content) || !Intrinsics.areEqual((Object) this.mentionees, (Object) comment.mentionees) || !Intrinsics.areEqual((Object) this.createdAt, (Object) comment.createdAt)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user2 = this.user;
        int i2 = 0;
        int hashCode = (i + (user2 != null ? user2.hashCode() : 0)) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        JsonObject jsonObject = this.mentionees;
        int hashCode3 = (hashCode2 + (jsonObject != null ? jsonObject.hashCode() : 0)) * 31;
        String str2 = this.createdAt;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment(id=");
        sb.append(this.id);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", mentionees=");
        sb.append(this.mentionees);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(")");
        return sb.toString();
    }

    public Comment(long j, @NotNull User user2, @NotNull String str, @Nullable JsonObject jsonObject, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(user2, "user");
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.CONTENT);
        Intrinsics.checkParameterIsNotNull(str2, "createdAt");
        this.id = j;
        this.user = user2;
        this.content = str;
        this.mentionees = jsonObject;
        this.createdAt = str2;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @NotNull
    @NonNull
    public final User getUser() {
        return this.user;
    }

    @NotNull
    @NonNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final JsonObject getMentionees() {
        return this.mentionees;
    }

    @NotNull
    @NonNull
    public final String getCreatedAt() {
        return this.createdAt;
    }
}
