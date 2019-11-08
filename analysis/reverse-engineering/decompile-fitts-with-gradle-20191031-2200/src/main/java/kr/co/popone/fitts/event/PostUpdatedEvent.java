package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PostUpdatedEvent {
    @NotNull
    private final Post post;

    public PostUpdatedEvent(@NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post2, "post");
        this.post = post2;
    }

    @NotNull
    public final Post getPost() {
        return this.post;
    }
}
