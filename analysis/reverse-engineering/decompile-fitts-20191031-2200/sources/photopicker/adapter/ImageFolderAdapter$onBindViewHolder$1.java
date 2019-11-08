package photopicker.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import photopicker.adapter.ImageFolderAdapter.OnItemClickListener;
import photopicker.model.LocalMediaFolder;

final class ImageFolderAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ LocalMediaFolder $folder;
    final /* synthetic */ int $position;
    final /* synthetic */ ImageFolderAdapter this$0;

    ImageFolderAdapter$onBindViewHolder$1(ImageFolderAdapter imageFolderAdapter, int i, LocalMediaFolder localMediaFolder) {
        this.this$0 = imageFolderAdapter;
        this.$position = i;
        this.$folder = localMediaFolder;
    }

    public final void onClick(View view) {
        if (this.this$0.onItemClickListener != null) {
            this.this$0.checkedIndex = this.$position;
            this.this$0.notifyDataSetChanged();
            OnItemClickListener access$getOnItemClickListener$p = this.this$0.onItemClickListener;
            if (access$getOnItemClickListener$p == null) {
                Intrinsics.throwNpe();
            }
            String name = this.$folder.getName();
            if (name == null) {
                Intrinsics.throwNpe();
            }
            access$getOnItemClickListener$p.onItemClick(name, this.$folder.getImages());
        }
    }
}
