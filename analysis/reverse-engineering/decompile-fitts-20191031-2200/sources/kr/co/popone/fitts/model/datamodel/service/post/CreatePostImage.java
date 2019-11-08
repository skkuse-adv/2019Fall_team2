package kr.co.popone.fitts.model.datamodel.service.post;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreatePostImage implements Serializable {
    @Nullable
    private String description;
    @Nullable
    private Integer id;
    @NotNull
    private String localpath = this.path;
    @NotNull
    private String path;

    public CreatePostImage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.path = str;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.path = str;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    public final void setId(@Nullable Integer num) {
        this.id = num;
    }

    @NotNull
    public final String getLocalpath() {
        return this.localpath;
    }

    public final void setLocalpath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.localpath = str;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id: ");
        sb.append(this.id);
        sb.append(", localpath: ");
        sb.append(this.localpath);
        sb.append(", path: ");
        sb.append(this.path);
        sb.append(", description: ");
        sb.append(this.description);
        sb.append('}');
        return sb.toString();
    }
}
