package photopicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import photopicker.model.LocalMedia;
import photopicker.model.LocalMediaFolder;

public final class ImageFolderAdapter extends Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public int checkedIndex;
    private final Context context;
    @NotNull
    private List<LocalMediaFolder> folders = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(@NotNull String str, @NotNull List<LocalMedia> list);
    }

    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @NotNull
        private View contentView;
        @NotNull
        private TextView folderName;

        public ViewHolder(@NotNull ImageFolderAdapter imageFolderAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "contentView");
            super(view);
            this.contentView = view;
            View findViewById = this.contentView.findViewById(C0010R$id.folder_name);
            if (findViewById == null) {
                Intrinsics.throwNpe();
            }
            this.folderName = (TextView) findViewById;
        }

        @NotNull
        public final View getContentView() {
            return this.contentView;
        }

        public final void setContentView(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "<set-?>");
            this.contentView = view;
        }

        @NotNull
        public final TextView getFolderName() {
            return this.folderName;
        }

        public final void setFolderName(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.folderName = textView;
        }
    }

    public ImageFolderAdapter(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final List<LocalMediaFolder> getFolders() {
        return this.folders;
    }

    public final void setFolders(@NotNull List<LocalMediaFolder> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.folders = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_image_folder, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        LocalMediaFolder localMediaFolder = (LocalMediaFolder) this.folders.get(i);
        viewHolder.getFolderName().setText(localMediaFolder.getName());
        viewHolder.getContentView().setOnClickListener(new ImageFolderAdapter$onBindViewHolder$1(this, i, localMediaFolder));
    }

    public int getItemCount() {
        return this.folders.size();
    }

    public final void setOnItemClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }
}
