package photopicker.utils;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0016R$string;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.model.LocalMedia;
import photopicker.model.LocalMediaFolder;
import photopicker.utils.LocalMediaLoader.LocalMediaLoadListener;

public final class LocalMediaLoader$loadAllImage$1 implements LoaderCallbacks<Cursor> {
    final /* synthetic */ LocalMediaLoadListener $imageLoadListener;
    final /* synthetic */ LocalMediaLoader this$0;

    public void onLoaderReset(@NotNull Loader<Cursor> loader) {
        Intrinsics.checkParameterIsNotNull(loader, "loader");
    }

    LocalMediaLoader$loadAllImage$1(LocalMediaLoader localMediaLoader, LocalMediaLoadListener localMediaLoadListener) {
        this.this$0 = localMediaLoader;
        this.$imageLoadListener = localMediaLoadListener;
    }

    @NotNull
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        FragmentActivity access$getActivity$p = this.this$0.activity;
        Uri uri = Media.EXTERNAL_CONTENT_URI;
        String[] imageProjection = this.this$0.getImageProjection();
        String[] strArr = {"image/jpeg", "image/png"};
        StringBuilder sb = new StringBuilder();
        sb.append(this.this$0.getImageProjection()[2]);
        sb.append(" DESC");
        CursorLoader cursorLoader = new CursorLoader(access$getActivity$p, uri, imageProjection, "mime_type=? or mime_type=?", strArr, sb.toString());
        return cursorLoader;
    }

    public void onLoadFinished(@NotNull Loader<Cursor> loader, @NotNull Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(loader, "loader");
        Intrinsics.checkParameterIsNotNull(cursor, "data");
        ArrayList arrayList = new ArrayList();
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        ArrayList arrayList2 = new ArrayList();
        cursor.moveToFirst();
        do {
            String string = cursor.getString(cursor.getColumnIndex("_data"));
            LocalMediaLoader localMediaLoader = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(string, "path");
            LocalMediaFolder access$getImageFolder = localMediaLoader.getImageFolder(string, arrayList);
            if (StringsKt__StringsJVMKt.endsWith$default(string, ".jpg", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(string, ".png", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(string, ".jpeg", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(string, ".bmp", false, 2, null)) {
                LocalMedia localMedia = new LocalMedia(string);
                arrayList2.add(localMedia);
                access$getImageFolder.getImages().add(localMedia);
                access$getImageFolder.setImageNum(access$getImageFolder.getImages().size());
            }
            if (!arrayList.contains(access$getImageFolder) && access$getImageFolder.getImageNum() > 0) {
                arrayList.add(access$getImageFolder);
            }
        } while (cursor.moveToNext());
        localMediaFolder.setImages(arrayList2);
        localMediaFolder.setImageNum(localMediaFolder.getImages().size());
        if (!arrayList2.isEmpty()) {
            localMediaFolder.setFirstImagePath(((LocalMedia) arrayList2.get(0)).getPath());
        }
        localMediaFolder.setName(this.this$0.activity.getString(C0016R$string.all_image));
        arrayList.add(localMediaFolder);
        this.this$0.sortFolder(arrayList);
        this.$imageLoadListener.loadComplete(arrayList);
    }
}
