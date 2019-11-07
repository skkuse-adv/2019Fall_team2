package kr.co.popone.fitts.feature.post.detail;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class SameProductPostAdapter$Companion$COMPARATOR$1 extends ItemCallback<Post> {
    SameProductPostAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull Post post, @NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post, "old");
        Intrinsics.checkParameterIsNotNull(post2, AppSettingsData.STATUS_NEW);
        return post.getId() == post2.getId();
    }

    public boolean areContentsTheSame(@NotNull Post post, @NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post, "old");
        Intrinsics.checkParameterIsNotNull(post2, AppSettingsData.STATUS_NEW);
        return post.getId() == post2.getId();
    }
}
