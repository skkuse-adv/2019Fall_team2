package photopicker.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.gun0912.tedpermission.TedPermission.Builder;
import dagger.android.AndroidInjection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.utils.DataHolderManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.adapter.ImageListAdapter;
import photopicker.model.LocalMedia;
import photopicker.utils.GridSpacingItemDecoration;
import photopicker.utils.ScreenUtils;

public final class ImageSelectorActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_ENABLE_CROP = EXTRA_ENABLE_CROP;
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_SELECT_IMAGES = EXTRA_SELECT_IMAGES;
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_SELECT_MODE = EXTRA_SELECT_MODE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_SELECT_TYPE = EXTRA_SELECT_TYPE;
    /* access modifiers changed from: private */
    public static final int MODE_MULTIPLE = 1;
    /* access modifiers changed from: private */
    public static final int MODE_SHOWROOM = 3;
    /* access modifiers changed from: private */
    public static final int MODE_SINGLE = 2;
    /* access modifiers changed from: private */
    @NotNull
    public static final String PARAMETER_POST_TYPE = PARAMETER_POST_TYPE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String PREF_SHOWED_COVER_IMAGE_GUIDE = PREF_SHOWED_COVER_IMAGE_GUIDE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String PREF_SHOWED_DETAIL_IMAGE_GUIDE = PREF_SHOWED_DETAIL_IMAGE_GUIDE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String REQUEST_OUTPUT = REQUEST_OUTPUT;
    /* access modifiers changed from: private */
    public static final int TYPE_POST_COVER = 1;
    /* access modifiers changed from: private */
    public static final int TYPE_POST_DEFAULT = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_POST_DETAIL = 2;
    private HashMap _$_findViewCache;
    private ImageButton backText;
    private ArrayList<LocalMedia> beforeSelectedImages;
    /* access modifiers changed from: private */
    public TextView currentFolderName;
    @NotNull
    public DataHolderManager dataHolderManager;
    private TextView doneText;
    /* access modifiers changed from: private */
    public boolean enableCrop;
    private RelativeLayout folderLayout;
    /* access modifiers changed from: private */
    public FolderWindow folderWindow;
    /* access modifiers changed from: private */
    public ImageListAdapter imageAdapter;
    private GridLayoutManager layoutManager;
    private PermissionListener permissionListener = new ImageSelectorActivity$permissionListener$1(this);
    /* access modifiers changed from: private */
    public PostType postType;
    private RecyclerView recyclerView;
    private int selectMode = MODE_MULTIPLE;
    /* access modifiers changed from: private */
    public Integer selectType;
    private final int spanCount = 3;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getREQUEST_OUTPUT() {
            return ImageSelectorActivity.REQUEST_OUTPUT;
        }

        @NotNull
        public final String getEXTRA_SELECT_MODE() {
            return ImageSelectorActivity.EXTRA_SELECT_MODE;
        }

        @NotNull
        public final String getEXTRA_ENABLE_CROP() {
            return ImageSelectorActivity.EXTRA_ENABLE_CROP;
        }

        @NotNull
        public final String getEXTRA_SELECT_IMAGES() {
            return ImageSelectorActivity.EXTRA_SELECT_IMAGES;
        }

        @NotNull
        public final String getPARAMETER_POST_TYPE() {
            return ImageSelectorActivity.PARAMETER_POST_TYPE;
        }

        public final int getMODE_MULTIPLE() {
            return ImageSelectorActivity.MODE_MULTIPLE;
        }

        public final int getMODE_SINGLE() {
            return ImageSelectorActivity.MODE_SINGLE;
        }

        public final int getMODE_SHOWROOM() {
            return ImageSelectorActivity.MODE_SHOWROOM;
        }

        @NotNull
        public final String getEXTRA_SELECT_TYPE() {
            return ImageSelectorActivity.EXTRA_SELECT_TYPE;
        }

        public final int getTYPE_POST_COVER() {
            return ImageSelectorActivity.TYPE_POST_COVER;
        }

        public final int getTYPE_POST_DETAIL() {
            return ImageSelectorActivity.TYPE_POST_DETAIL;
        }

        @NotNull
        public final String getPREF_SHOWED_COVER_IMAGE_GUIDE() {
            return ImageSelectorActivity.PREF_SHOWED_COVER_IMAGE_GUIDE;
        }

        @NotNull
        public final String getPREF_SHOWED_DETAIL_IMAGE_GUIDE() {
            return ImageSelectorActivity.PREF_SHOWED_DETAIL_IMAGE_GUIDE;
        }

        public static /* synthetic */ void start$default(Companion companion, Activity activity, int i, boolean z, int i2, int i3, PostType postType, int i4, Object obj) {
            if ((i4 & 16) != 0) {
                i3 = ImageSelectorActivity.TYPE_POST_DEFAULT;
            }
            int i5 = i3;
            if ((i4 & 32) != 0) {
                postType = null;
            }
            companion.start(activity, i, z, i2, i5, postType);
        }

        public final void start(@NotNull Activity activity, int i, boolean z, int i2, int i3, @Nullable PostType postType) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intent intent = new Intent(activity, ImageSelectorActivity.class);
            intent.putExtra(getEXTRA_SELECT_MODE(), i);
            intent.putExtra(getEXTRA_ENABLE_CROP(), z);
            intent.putExtra(getEXTRA_SELECT_TYPE(), i3);
            if (postType != null) {
                intent.putExtra(getPARAMETER_POST_TYPE(), postType.name());
            }
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(activity, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            ActivityCompat.startActivityForResult(activity, intent, i2, makeCustomAnimation.toBundle());
        }

        public static /* synthetic */ void start$default(Companion companion, Activity activity, int i, boolean z, int i2, int i3, String str, int i4, Object obj) {
            if ((i4 & 16) != 0) {
                i3 = ImageSelectorActivity.TYPE_POST_DEFAULT;
            }
            companion.start(activity, i, z, i2, i3, str);
        }

        public final void start(@NotNull Activity activity, int i, boolean z, int i2, int i3, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intent intent = new Intent(activity, ImageSelectorActivity.class);
            intent.putExtra(getEXTRA_SELECT_MODE(), i);
            intent.putExtra(getEXTRA_ENABLE_CROP(), z);
            intent.putExtra(getEXTRA_SELECT_TYPE(), i3);
            intent.putExtra(getPARAMETER_POST_TYPE(), str);
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(activity, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            ActivityCompat.startActivityForResult(activity, intent, i2, makeCustomAnimation.toBundle());
        }

        public final void start(@NotNull Activity activity, int i, boolean z, int i2, @NotNull ArrayList<LocalMedia> arrayList) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(arrayList, "selectImages");
            Intent intent = new Intent(activity, ImageSelectorActivity.class);
            intent.putExtra(getEXTRA_SELECT_MODE(), i);
            intent.putExtra(getEXTRA_ENABLE_CROP(), z);
            intent.putExtra(getEXTRA_SELECT_IMAGES(), arrayList);
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(activity, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            ActivityCompat.startActivityForResult(activity, intent, i2, makeCustomAnimation.toBundle());
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$10 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$11 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$7 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$8 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$9 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$0[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$1[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$1[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$2[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$2[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$3[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$4[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$4[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$5[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$5[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$6[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$6[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$7[PostType.BAG.ordinal()] = 1;
            $EnumSwitchMapping$7[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$8[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$8[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$9[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$9[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$10[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$10[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$11[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$11[PostType.BAG.ordinal()] = 2;
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

    @NotNull
    public final DataHolderManager getDataHolderManager() {
        DataHolderManager dataHolderManager2 = this.dataHolderManager;
        if (dataHolderManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataHolderManager");
        }
        return dataHolderManager2;
    }

    public final void setDataHolderManager(@NotNull DataHolderManager dataHolderManager2) {
        Intrinsics.checkParameterIsNotNull(dataHolderManager2, "<set-?>");
        this.dataHolderManager = dataHolderManager2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_image_selector);
        this.beforeSelectedImages = (ArrayList) getIntent().getSerializableExtra(EXTRA_SELECT_IMAGES);
        this.selectMode = getIntent().getIntExtra(EXTRA_SELECT_MODE, MODE_MULTIPLE);
        this.enableCrop = getIntent().getBooleanExtra(EXTRA_ENABLE_CROP, false);
        this.selectType = Integer.valueOf(getIntent().getIntExtra(EXTRA_SELECT_TYPE, 0));
        String stringExtra = getIntent().getStringExtra(PARAMETER_POST_TYPE);
        if (stringExtra != null) {
            String upperCase = stringExtra.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            this.postType = PostType.valueOf(upperCase);
        }
        if (this.selectMode == MODE_MULTIPLE) {
            this.enableCrop = false;
        }
        ((Builder) ((Builder) ((Builder) TedPermission.with(this).setPermissionListener(this.permissionListener)).setDeniedMessage((CharSequence) "권한을 설정해 주시길 바랍니다...")).setPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")).check();
    }

    public final void initView() {
        this.folderWindow = new FolderWindow(this);
        this.doneText = (TextView) findViewById(C0010R$id.done_text);
        this.backText = (ImageButton) findViewById(C0010R$id.back_text);
        if (this.beforeSelectedImages != null) {
            TextView textView = this.doneText;
            if (textView == null) {
                Intrinsics.throwNpe();
            }
            textView.setEnabled(true);
            TextView textView2 = this.doneText;
            if (textView2 == null) {
                Intrinsics.throwNpe();
            }
            textView2.setTextColor(ContextCompat.getColor(this, C0006R$color.point));
        }
        TextView textView3 = this.doneText;
        if (textView3 == null) {
            Intrinsics.throwNpe();
        }
        textView3.setVisibility(this.selectMode == MODE_MULTIPLE ? 0 : 8);
        this.folderLayout = (RelativeLayout) findViewById(C0010R$id.folder_layout);
        this.currentFolderName = (TextView) findViewById(C0010R$id.folder_name);
        this.recyclerView = (RecyclerView) findViewById(C0010R$id.folder_list);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setHasFixedSize(true);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView3.addItemDecoration(new GridSpacingItemDecoration(this.spanCount, ScreenUtils.INSTANCE.dip2px(this, 2.0f), false));
        this.layoutManager = new GridLayoutManager(this, this.spanCount);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView4.setLayoutManager(this.layoutManager);
        this.imageAdapter = new ImageListAdapter(this, this.selectMode, this.beforeSelectedImages);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView5.setAdapter(this.imageAdapter);
    }

    public final void registerListener() {
        RelativeLayout relativeLayout = this.folderLayout;
        if (relativeLayout == null) {
            Intrinsics.throwNpe();
        }
        relativeLayout.setOnClickListener(new ImageSelectorActivity$registerListener$1(this));
        ImageListAdapter imageListAdapter = this.imageAdapter;
        if (imageListAdapter == null) {
            Intrinsics.throwNpe();
        }
        imageListAdapter.setOnImageSelectChangedListener(new ImageSelectorActivity$registerListener$2(this));
        TextView textView = this.doneText;
        if (textView == null) {
            Intrinsics.throwNpe();
        }
        textView.setOnClickListener(new ImageSelectorActivity$registerListener$3(this));
        ImageButton imageButton = this.backText;
        if (imageButton == null) {
            Intrinsics.throwNpe();
        }
        imageButton.setOnClickListener(new ImageSelectorActivity$registerListener$4(this));
        FolderWindow folderWindow2 = this.folderWindow;
        if (folderWindow2 == null) {
            Intrinsics.throwNpe();
        }
        folderWindow2.setOnItemClickListener(new ImageSelectorActivity$registerListener$5(this));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 != -1) {
            return;
        }
        if (i == ImageCropActivity.Companion.getREQUEST_CROP()) {
            onSelectDone(intent != null ? intent.getStringExtra(ImageCropActivity.Companion.getOUTPUT_PATH()) : null);
        } else if (i == ImagePreviewActivity.Companion.getREQUEST_PREVIEW()) {
            if (intent == null) {
                Intrinsics.throwNpe();
            }
            boolean booleanExtra = intent.getBooleanExtra(ImagePreviewActivity.Companion.getOUTPUT_ISDONE(), false);
            Serializable serializableExtra = intent.getSerializableExtra(ImagePreviewActivity.Companion.getOUTPUT_LIST());
            if (serializableExtra != null) {
                ArrayList arrayList = (ArrayList) serializableExtra;
                if (booleanExtra) {
                    onSelectDone((List<LocalMedia>) arrayList);
                    return;
                }
                ImageListAdapter imageListAdapter = this.imageAdapter;
                if (imageListAdapter == null) {
                    Intrinsics.throwNpe();
                }
                imageListAdapter.bindSelectImages(arrayList);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<photopicker.model.LocalMedia> /* = java.util.ArrayList<photopicker.model.LocalMedia> */");
        }
    }

    public final void startCrop(@Nullable String str) {
        if (this.selectMode == MODE_SHOWROOM) {
            ImageCropActivity.Companion.startCrop(this, str, true, false);
        } else {
            ImageCropActivity.Companion.startCrop(this, str, false, false);
        }
    }

    /* access modifiers changed from: private */
    public final void onSelectDone(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        for (LocalMedia path : list) {
            String path2 = path.getPath();
            if (path2 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(path2);
        }
        onResult(arrayList);
    }

    public final void onSelectDone(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        onResult(arrayList);
    }

    private final void onResult(ArrayList<String> arrayList) {
        setResult(-1, new Intent().putStringArrayListExtra(REQUEST_OUTPUT, arrayList));
        finish();
    }
}
