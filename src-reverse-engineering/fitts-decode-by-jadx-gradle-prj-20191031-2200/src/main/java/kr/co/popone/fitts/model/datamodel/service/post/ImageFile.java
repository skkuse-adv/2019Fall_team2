package kr.co.popone.fitts.model.datamodel.service.post;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ImageFile implements Serializable {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final int TYPE_APPLY_FITTE_IMAGE = 6;
    /* access modifiers changed from: private */
    public static final int TYPE_COVER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_POST = 1;
    /* access modifiers changed from: private */
    public static final int TYPE_PROFILE = 5;
    /* access modifiers changed from: private */
    public static final int TYPE_SHOW_ROOM = 7;
    @NotNull
    private File file;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_COVER() {
            return ImageFile.TYPE_COVER;
        }

        public final int getTYPE_POST() {
            return ImageFile.TYPE_POST;
        }

        public final int getTYPE_PROFILE() {
            return ImageFile.TYPE_PROFILE;
        }

        public final int getTYPE_APPLY_FITTE_IMAGE() {
            return ImageFile.TYPE_APPLY_FITTE_IMAGE;
        }

        public final int getTYPE_SHOW_ROOM() {
            return ImageFile.TYPE_SHOW_ROOM;
        }
    }

    private final int exifOrientationToDegrees(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public ImageFile(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "uri");
        this.type = i;
        File createTempFile = File.createTempFile("temp", ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        Bitmap rotate = rotate(BitmapFactory.decodeFile(str), exifOrientationToDegrees(new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)));
        Intrinsics.checkExpressionValueIsNotNull(rotate, "src");
        if (rotate.getHeight() <= 2048 || rotate.getWidth() <= 2048) {
            Bitmap.createScaledBitmap(rotate, rotate.getWidth(), rotate.getHeight(), true).compress(CompressFormat.JPEG, 85, fileOutputStream);
        } else if (rotate.getHeight() > rotate.getWidth()) {
            Bitmap.createScaledBitmap(rotate, 2048, (rotate.getHeight() * 2048) / rotate.getWidth(), true).compress(CompressFormat.JPEG, 85, fileOutputStream);
        } else {
            Bitmap.createScaledBitmap(rotate, (rotate.getWidth() * 2048) / rotate.getHeight(), 2048, true).compress(CompressFormat.JPEG, 85, fileOutputStream);
        }
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "tempFile");
        this.file = createTempFile;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    public final void setFile(@NotNull File file2) {
        Intrinsics.checkParameterIsNotNull(file2, "<set-?>");
        this.file = file2;
    }

    private final Bitmap rotate(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = (float) 2;
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / f, ((float) bitmap.getHeight()) / f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (!(!Intrinsics.areEqual((Object) bitmap, (Object) createBitmap))) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }
}
