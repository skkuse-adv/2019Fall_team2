package photopicker.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.gun0912.tedpermission.TedPermission.Builder;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.CropUtil;

public final class ImageCropActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_PATH = EXTRA_PATH;
    /* access modifiers changed from: private */
    @NotNull
    public static final String MODE_CROP_FREE = MODE_CROP_FREE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String MODE_SHOW_ROOM = MODE_SHOW_ROOM;
    /* access modifiers changed from: private */
    @NotNull
    public static final String OUTPUT_PATH = OUTPUT_PATH;
    /* access modifiers changed from: private */
    public static final int REQUEST_CROP = 69;
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private HashMap _$_findViewCache;
    private ImageButton backText;
    /* access modifiers changed from: private */
    public CropImageView cropImageView;
    private TextView doneText;
    private final Handler handler = new Handler();
    private boolean isFreeCrop;
    private boolean isShowRoom;
    private PermissionListener permissionListener = new ImageCropActivity$permissionListener$1(this);
    /* access modifiers changed from: private */
    public Uri saveUri;
    private Uri sourceUri;
    private Toolbar toolbar;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getEXTRA_PATH() {
            return ImageCropActivity.EXTRA_PATH;
        }

        @NotNull
        public final String getOUTPUT_PATH() {
            return ImageCropActivity.OUTPUT_PATH;
        }

        @NotNull
        public final String getMODE_SHOW_ROOM() {
            return ImageCropActivity.MODE_SHOW_ROOM;
        }

        @NotNull
        public final String getMODE_CROP_FREE() {
            return ImageCropActivity.MODE_CROP_FREE;
        }

        public final int getREQUEST_CROP() {
            return ImageCropActivity.REQUEST_CROP;
        }

        public final void startCrop(@NotNull Activity activity, @Nullable String str, boolean z, boolean z2) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intent intent = new Intent(activity, ImageCropActivity.class);
            intent.putExtra(getEXTRA_PATH(), str);
            intent.putExtra(getMODE_SHOW_ROOM(), z);
            intent.putExtra(getMODE_CROP_FREE(), z2);
            activity.startActivityForResult(intent, getREQUEST_CROP());
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_image_crop);
        String stringExtra = getIntent().getStringExtra(EXTRA_PATH);
        this.isShowRoom = getIntent().getBooleanExtra(MODE_SHOW_ROOM, false);
        this.isFreeCrop = getIntent().getBooleanExtra(MODE_CROP_FREE, false);
        this.sourceUri = Uri.fromFile(new File(stringExtra));
        ((Builder) ((Builder) ((Builder) TedPermission.with(this).setPermissionListener(this.permissionListener)).setDeniedMessage((CharSequence) "권한을 설정해 주시길 바랍니다...")).setPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")).check();
        initView();
        registerListener();
    }

    public final void initView() {
        InputStream inputStream;
        this.toolbar = (Toolbar) findViewById(C0010R$id.toolbar);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwNpe();
        }
        toolbar2.setTitle((CharSequence) "");
        setSupportActionBar(this.toolbar);
        this.doneText = (TextView) findViewById(C0010R$id.done_text);
        this.backText = (ImageButton) findViewById(C0010R$id.back_text);
        this.cropImageView = (CropImageView) findViewById(2131362098);
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 == null) {
            Intrinsics.throwNpe();
        }
        cropImageView2.setAspectRatio(1, 1);
        if (this.isShowRoom) {
            CropImageView cropImageView3 = this.cropImageView;
            if (cropImageView3 == null) {
                Intrinsics.throwNpe();
            }
            cropImageView3.setAspectRatio(375, 130);
        }
        if (this.isFreeCrop) {
            CropImageView cropImageView4 = this.cropImageView;
            if (cropImageView4 == null) {
                Intrinsics.throwNpe();
            }
            cropImageView4.clearAspectRatio();
        }
        CropUtil cropUtil = CropUtil.INSTANCE;
        ContentResolver contentResolver = getContentResolver();
        Intrinsics.checkExpressionValueIsNotNull(contentResolver, "contentResolver");
        int exifRotation = cropUtil.getExifRotation(cropUtil.getFromMediaUri(this, contentResolver, this.sourceUri));
        InputStream inputStream2 = null;
        try {
            int calculateBitmapSampleSize = calculateBitmapSampleSize(this.sourceUri);
            ContentResolver contentResolver2 = getContentResolver();
            Uri uri = this.sourceUri;
            if (uri == null) {
                Intrinsics.throwNpe();
            }
            inputStream = contentResolver2.openInputStream(uri);
            try {
                Options options = new Options();
                options.inSampleSize = calculateBitmapSampleSize;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), getRotateMatrix(decodeStream, exifRotation % 360), true);
                    CropImageView cropImageView5 = this.cropImageView;
                    if (cropImageView5 == null) {
                        Intrinsics.throwNpe();
                    }
                    cropImageView5.setImageBitmap(createBitmap);
                    CropUtil.INSTANCE.closeSilently(inputStream);
                }
                CropUtil.INSTANCE.closeSilently(inputStream);
            } catch (IOException e) {
                e = e;
                inputStream2 = inputStream;
                e.printStackTrace();
                CropUtil.INSTANCE.closeSilently(inputStream2);
            } catch (OutOfMemoryError e2) {
                e = e2;
                inputStream2 = inputStream;
                e.printStackTrace();
                CropUtil.INSTANCE.closeSilently(inputStream2);
            } catch (Throwable th) {
                th = th;
                CropUtil.INSTANCE.closeSilently(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            CropUtil.INSTANCE.closeSilently(inputStream2);
        } catch (OutOfMemoryError e4) {
            e = e4;
            e.printStackTrace();
            CropUtil.INSTANCE.closeSilently(inputStream2);
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
            CropUtil.INSTANCE.closeSilently(inputStream);
            throw th;
        }
    }

    public final void registerListener() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwNpe();
        }
        toolbar2.setNavigationOnClickListener(new ImageCropActivity$registerListener$1(this));
        TextView textView = this.doneText;
        if (textView == null) {
            Intrinsics.throwNpe();
        }
        textView.setOnClickListener(new ImageCropActivity$registerListener$2(this));
        ImageButton imageButton = this.backText;
        if (imageButton == null) {
            Intrinsics.throwNpe();
        }
        imageButton.setOnClickListener(new ImageCropActivity$registerListener$3(this));
    }

    private final Matrix getRotateMatrix(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        if (!(bitmap == null || i == 0)) {
            matrix.preTranslate((float) (-(bitmap.getWidth() / 2)), (float) (-(bitmap.getHeight() / 2)));
            matrix.postRotate((float) i);
            matrix.postTranslate((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        }
        return matrix;
    }

    private final int calculateBitmapSampleSize(Uri uri) throws IOException {
        Options options = new Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                CropUtil.INSTANCE.closeSilently(openInputStream);
                int maxImageSize = getMaxImageSize();
                while (true) {
                    if (options.outHeight / i <= maxImageSize && options.outWidth / i <= maxImageSize) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = openInputStream;
                CropUtil.INSTANCE.closeSilently(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            CropUtil.INSTANCE.closeSilently(inputStream);
            throw th;
        }
    }

    private final int getMaxImageSize() {
        int maxTextureSize = getMaxTextureSize();
        if (maxTextureSize == 0) {
            return SIZE_DEFAULT;
        }
        return Math.min(maxTextureSize, SIZE_LIMIT);
    }

    private final int getMaxTextureSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* access modifiers changed from: private */
    public final void saveOutput(Bitmap bitmap) {
        if (this.saveUri != null) {
            OutputStream outputStream = null;
            try {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = this.saveUri;
                if (uri == null) {
                    Intrinsics.throwNpe();
                }
                outputStream = contentResolver.openOutputStream(uri);
                if (outputStream != null) {
                    bitmap.compress(CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                CropUtil.INSTANCE.closeSilently(null);
                throw th;
            }
            CropUtil.INSTANCE.closeSilently(outputStream);
            Intent intent = new Intent();
            String str = OUTPUT_PATH;
            Uri uri2 = this.saveUri;
            if (uri2 == null) {
                Intrinsics.throwNpe();
            }
            setResult(-1, intent.putExtra(str, uri2.getPath()));
        }
        this.handler.post(new ImageCropActivity$saveOutput$1(bitmap));
        finish();
    }
}
