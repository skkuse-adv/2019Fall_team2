package kr.co.popone.fitts.feature.post.upload.crop;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.crop.PostImageDetailAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import org.jetbrains.annotations.NotNull;
import photopicker.model.LocalMedia;
import photopicker.view.ImageCropActivity;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity.Companion;

public final class PostImageDetailActivity$onCreate$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ RecyclerView $this_run;
    final /* synthetic */ PostImageDetailActivity this$0;

    PostImageDetailActivity$onCreate$$inlined$run$lambda$1(RecyclerView recyclerView, PostImageDetailActivity postImageDetailActivity) {
        this.$this_run = recyclerView;
        this.this$0 = postImageDetailActivity;
    }

    public boolean isModifyData() {
        return this.this$0.getIntent().getBooleanExtra("is_modify_data", false);
    }

    @NotNull
    public ArrayList<CreatePostImage> getPostImages() {
        return this.this$0.getImages();
    }

    public void onAddImageClick() {
        if (!this.this$0.getImages().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CreatePostImage localpath : this.this$0.getImages()) {
                arrayList.add(new LocalMedia(localpath.getLocalpath()));
                ((LocalMedia) arrayList.get(arrayList.size() - 1)).setNum(arrayList.size());
            }
            Companion companion = ImageSelectorActivity.Companion;
            companion.start(this.this$0, companion.getMODE_MULTIPLE(), false, ImageFile.Companion.getTYPE_POST(), arrayList);
            return;
        }
        Companion companion2 = ImageSelectorActivity.Companion;
        Companion.start$default(companion2, (Activity) this.this$0, companion2.getMODE_MULTIPLE(), false, ImageFile.Companion.getTYPE_POST(), 0, (PostType) null, 48, (Object) null);
    }

    public void onRemoveClick(@NotNull CreatePostImage createPostImage, int i) {
        Intrinsics.checkParameterIsNotNull(createPostImage, "item");
        this.this$0.getImages().remove(createPostImage);
        Adapter adapter = this.$this_run.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRemoved(i);
            adapter.notifyItemRangeChanged(i, adapter.getItemCount());
        }
    }

    public void onCropClick(@NotNull CreatePostImage createPostImage, int i) {
        Intrinsics.checkParameterIsNotNull(createPostImage, "item");
        this.this$0.changedImage = createPostImage;
        this.this$0.changedPosition = Integer.valueOf(i);
        ImageCropActivity.Companion.startCrop(this.this$0, createPostImage.getPath(), false, true);
    }
}
