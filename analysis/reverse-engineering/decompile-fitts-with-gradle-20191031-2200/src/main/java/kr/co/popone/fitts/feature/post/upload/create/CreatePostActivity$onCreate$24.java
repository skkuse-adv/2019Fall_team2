package kr.co.popone.fitts.feature.post.upload.create;

import kr.co.popone.fitts.feature.tag.TagGroup;
import kr.co.popone.fitts.feature.tag.TagGroup.OnTagChangeListener;
import org.jetbrains.annotations.Nullable;

public final class CreatePostActivity$onCreate$24 implements OnTagChangeListener {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$24(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public void onAppend(@Nullable TagGroup tagGroup, @Nullable String str) {
        if (str != null) {
            this.this$0.getViewModel().userTagAdded(str);
        }
    }

    public void onDelete(@Nullable TagGroup tagGroup, @Nullable String str) {
        if (str != null) {
            this.this$0.getViewModel().userTagRemoved(str);
        }
    }
}
