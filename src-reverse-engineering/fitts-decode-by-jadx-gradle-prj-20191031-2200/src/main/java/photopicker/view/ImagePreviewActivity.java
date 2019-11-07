package photopicker.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.facebook.share.internal.MessengerShareContentUtility;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.utils.DataHolderManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.model.LocalMedia;
import photopicker.widget.PreviewViewPager;

public final class ImagePreviewActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_POSITION = EXTRA_POSITION;
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_PREVIEW_LIST = EXTRA_PREVIEW_LIST;
    /* access modifiers changed from: private */
    @NotNull
    public static final String EXTRA_PREVIEW_SELECT_LIST = EXTRA_PREVIEW_SELECT_LIST;
    /* access modifiers changed from: private */
    @NotNull
    public static final String OUTPUT_ISDONE = OUTPUT_ISDONE;
    /* access modifiers changed from: private */
    @NotNull
    public static final String OUTPUT_LIST = OUTPUT_LIST;
    /* access modifiers changed from: private */
    public static final int REQUEST_PREVIEW = 68;
    private HashMap _$_findViewCache;
    @NotNull
    public DataHolderManager dataHolderManager;
    @NotNull
    private List<LocalMedia> images = new ArrayList();
    private int position;
    private TextView previewTitle;
    @NotNull
    private ArrayList<LocalMedia> selectImages = new ArrayList<>();
    @Nullable
    private FrameLayout selectNot;
    private TextView selectedNum;
    @Nullable
    private TextView selectedNumTitle;
    @Nullable
    private PreviewViewPager viewPager;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getREQUEST_PREVIEW() {
            return ImagePreviewActivity.REQUEST_PREVIEW;
        }

        @NotNull
        public final String getEXTRA_PREVIEW_LIST() {
            return ImagePreviewActivity.EXTRA_PREVIEW_LIST;
        }

        @NotNull
        public final String getEXTRA_PREVIEW_SELECT_LIST() {
            return ImagePreviewActivity.EXTRA_PREVIEW_SELECT_LIST;
        }

        @NotNull
        public final String getEXTRA_POSITION() {
            return ImagePreviewActivity.EXTRA_POSITION;
        }

        @NotNull
        public final String getOUTPUT_LIST() {
            return ImagePreviewActivity.OUTPUT_LIST;
        }

        @NotNull
        public final String getOUTPUT_ISDONE() {
            return ImagePreviewActivity.OUTPUT_ISDONE;
        }

        public final void startPreview(@NotNull Activity activity, @NotNull List<LocalMedia> list, @NotNull List<LocalMedia> list2, int i) {
            Intrinsics.checkParameterIsNotNull(activity, "context");
            Intrinsics.checkParameterIsNotNull(list, "images");
            Intrinsics.checkParameterIsNotNull(list2, "selectImages");
            Intent intent = new Intent(activity, ImagePreviewActivity.class);
            intent.putExtra(getEXTRA_POSITION(), i);
            activity.startActivityForResult(intent, getREQUEST_PREVIEW());
        }
    }

    public final class SimpleFragmentAdapter extends FragmentPagerAdapter {
        final /* synthetic */ ImagePreviewActivity this$0;

        public SimpleFragmentAdapter(@NotNull ImagePreviewActivity imagePreviewActivity, FragmentManager fragmentManager) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fm");
            this.this$0 = imagePreviewActivity;
            super(fragmentManager);
        }

        @NotNull
        public Fragment getItem(int i) {
            photopicker.view.ImagePreviewFragment.Companion companion = ImagePreviewFragment.Companion;
            String path = ((LocalMedia) this.this$0.getImages().get(i)).getPath();
            if (path == null) {
                Intrinsics.throwNpe();
            }
            return companion.getInstance(path);
        }

        public int getCount() {
            return this.this$0.getImages().size();
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

    @Nullable
    public final PreviewViewPager getViewPager() {
        return this.viewPager;
    }

    public final void setViewPager(@Nullable PreviewViewPager previewViewPager) {
        this.viewPager = previewViewPager;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    @NotNull
    public final List<LocalMedia> getImages() {
        return this.images;
    }

    public final void setImages(@NotNull List<LocalMedia> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.images = list;
    }

    @NotNull
    public final ArrayList<LocalMedia> getSelectImages() {
        return this.selectImages;
    }

    public final void setSelectImages(@NotNull ArrayList<LocalMedia> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.selectImages = arrayList;
    }

    @Nullable
    public final TextView getSelectedNumTitle() {
        return this.selectedNumTitle;
    }

    public final void setSelectedNumTitle(@Nullable TextView textView) {
        this.selectedNumTitle = textView;
    }

    @Nullable
    public final FrameLayout getSelectNot() {
        return this.selectNot;
    }

    public final void setSelectNot(@Nullable FrameLayout frameLayout) {
        this.selectNot = frameLayout;
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
        setContentView((int) C0013R$layout.activity_image_preview);
        initView();
        registerListener();
        ((ImageButton) _$_findCachedViewById(C0010R$id.back_button)).setOnClickListener(new ImagePreviewActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C0010R$id.done_size)).setOnClickListener(new ImagePreviewActivity$onCreate$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.done_button)).setOnClickListener(new ImagePreviewActivity$onCreate$3(this));
    }

    private final void initView() {
        DataHolderManager dataHolderManager2 = this.dataHolderManager;
        String str = "dataHolderManager";
        if (dataHolderManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        List<LocalMedia> listData = dataHolderManager2.getListData(EXTRA_PREVIEW_LIST);
        if (listData != null) {
            this.images = listData;
            DataHolderManager dataHolderManager3 = this.dataHolderManager;
            if (dataHolderManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            List listData2 = dataHolderManager3.getListData(EXTRA_PREVIEW_SELECT_LIST);
            if (listData2 != null) {
                this.selectImages = (ArrayList) listData2;
                this.position = getIntent().getIntExtra(EXTRA_POSITION, 0);
                this.previewTitle = (TextView) findViewById(C0010R$id.preview_title);
                this.selectedNum = (TextView) findViewById(C0010R$id.ordinal_textview);
                this.selectedNumTitle = (TextView) findViewById(C0010R$id.done_size);
                if (this.selectImages.size() > 0) {
                    TextView textView = this.selectedNumTitle;
                    if (textView == null) {
                        Intrinsics.throwNpe();
                    }
                    textView.setVisibility(0);
                    TextView textView2 = this.selectedNumTitle;
                    if (textView2 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView2.setText(String.valueOf(this.selectImages.size()));
                } else {
                    TextView textView3 = this.selectedNumTitle;
                    if (textView3 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView3.setVisibility(8);
                }
                this.selectNot = (FrameLayout) findViewById(C0010R$id.border_select);
                FrameLayout frameLayout = this.selectNot;
                if (frameLayout == null) {
                    Intrinsics.throwNpe();
                }
                frameLayout.setOnClickListener(new ImagePreviewActivity$initView$1(this));
                onImageSwitch(this.position);
                this.viewPager = (PreviewViewPager) findViewById(C0010R$id.preview_pager);
                PreviewViewPager previewViewPager = this.viewPager;
                if (previewViewPager == null) {
                    Intrinsics.throwNpe();
                }
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
                previewViewPager.setAdapter(new SimpleFragmentAdapter(this, supportFragmentManager));
                PreviewViewPager previewViewPager2 = this.viewPager;
                if (previewViewPager2 == null) {
                    Intrinsics.throwNpe();
                }
                previewViewPager2.setCurrentItem(this.position);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<photopicker.model.LocalMedia>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<photopicker.model.LocalMedia>");
    }

    /* access modifiers changed from: private */
    public final void onDoneClick(boolean z) {
        Intent intent = new Intent();
        intent.putExtra(OUTPUT_LIST, this.selectImages);
        intent.putExtra(OUTPUT_ISDONE, z);
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        onDoneClick(false);
    }

    private final void registerListener() {
        PreviewViewPager previewViewPager = this.viewPager;
        if (previewViewPager == null) {
            Intrinsics.throwNpe();
        }
        previewViewPager.addOnPageChangeListener(new ImagePreviewActivity$registerListener$1(this));
    }

    public final void onImageSwitch(int i) {
        TextView textView = this.previewTitle;
        if (textView == null) {
            Intrinsics.throwNpe();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(i + 1));
        sb.append("/");
        sb.append(String.valueOf(this.images.size()));
        textView.setText(sb.toString());
        if (isSelected((LocalMedia) this.images.get(i))) {
            TextView textView2 = this.selectedNum;
            if (textView2 == null) {
                Intrinsics.throwNpe();
            }
            textView2.setText(String.valueOf(((LocalMedia) this.images.get(i)).getNum()));
            TextView textView3 = this.selectedNum;
            if (textView3 == null) {
                Intrinsics.throwNpe();
            }
            textView3.setVisibility(0);
            return;
        }
        TextView textView4 = this.selectedNum;
        if (textView4 == null) {
            Intrinsics.throwNpe();
        }
        textView4.setVisibility(8);
    }

    public final boolean isSelected(@NotNull LocalMedia localMedia) {
        Intrinsics.checkParameterIsNotNull(localMedia, MessengerShareContentUtility.MEDIA_IMAGE);
        ArrayList<LocalMedia> arrayList = this.selectImages;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (LocalMedia path : arrayList) {
            if (Intrinsics.areEqual((Object) path.getPath(), (Object) localMedia.getPath())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        DataHolderManager dataHolderManager2 = this.dataHolderManager;
        String str = "dataHolderManager";
        if (dataHolderManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        dataHolderManager2.popListData(EXTRA_PREVIEW_LIST);
        DataHolderManager dataHolderManager3 = this.dataHolderManager;
        if (dataHolderManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        dataHolderManager3.popListData(EXTRA_PREVIEW_SELECT_LIST);
    }
}
