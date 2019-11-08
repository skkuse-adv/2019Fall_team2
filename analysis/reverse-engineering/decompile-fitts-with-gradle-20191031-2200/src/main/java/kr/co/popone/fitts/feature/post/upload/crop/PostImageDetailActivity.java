package kr.co.popone.fitts.feature.post.upload.crop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.view.ImageCropActivity;
import photopicker.view.ImageSelectorActivity;

public final class PostImageDetailActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public CreatePostImage changedImage;
    /* access modifiers changed from: private */
    public Integer changedPosition;
    @NotNull
    private final ArrayList<CreatePostImage> images = new ArrayList<>();

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
    public final ArrayList<CreatePostImage> getImages() {
        return this.images;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_postwritedetail);
        Serializable serializableExtra = getIntent().getSerializableExtra("post_detail_data");
        if (serializableExtra != null) {
            for (Object next : (ArrayList) serializableExtra) {
                ArrayList<CreatePostImage> arrayList = this.images;
                if (next != null) {
                    arrayList.add((CreatePostImage) next);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage");
                }
            }
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.detail_post_list);
            recyclerView.setAdapter(new PostImageDetailAdapter(this, new PostImageDetailActivity$onCreate$$inlined$run$lambda$1(recyclerView, this)));
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            recyclerView.setOnTouchListener(new PostImageDetailActivity$onCreate$$inlined$run$lambda$2(this));
            ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new PostImageDetailActivity$onCreate$3(this));
            ((Button) _$_findCachedViewById(C0010R$id.complete_button)).setOnClickListener(new PostImageDetailActivity$onCreate$4(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
    }

    public void onBackPressed() {
        hideKeyboard();
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = "detail_post_list";
        ArrayList<String> arrayList = null;
        if (i == ImageCropActivity.Companion.getREQUEST_CROP()) {
            String stringExtra = intent != null ? intent.getStringExtra(ImageCropActivity.Companion.getOUTPUT_PATH()) : null;
            if (stringExtra != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("crop result path ");
                sb.append(stringExtra);
                Logger.d(sb.toString(), new Object[0]);
                ArrayList<CreatePostImage> arrayList2 = this.images;
                ArrayList<CreatePostImage> arrayList3 = new ArrayList<>();
                for (Object next : arrayList2) {
                    if (Intrinsics.areEqual((Object) (CreatePostImage) next, (Object) this.changedImage)) {
                        arrayList3.add(next);
                    }
                }
                for (CreatePostImage createPostImage : arrayList3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("crop result for each start with ");
                    sb2.append(createPostImage);
                    sb2.append("    applying path ");
                    sb2.append(stringExtra);
                    Logger.d(sb2.toString(), new Object[0]);
                    createPostImage.setPath(stringExtra);
                    CreatePostImage createPostImage2 = this.changedImage;
                    if (createPostImage2 == null) {
                        Intrinsics.throwNpe();
                    }
                    createPostImage.setDescription(createPostImage2.getDescription());
                    RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.detail_post_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
                    Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        Integer num = this.changedPosition;
                        if (num == null) {
                            Intrinsics.throwNpe();
                        }
                        adapter.notifyItemChanged(num.intValue());
                    }
                    ((RecyclerView) _$_findCachedViewById(C0010R$id.detail_post_list)).postDelayed(new PostImageDetailActivity$onActivityResult$$inlined$forEach$lambda$1(this, stringExtra), 10);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("crop result for each end with ");
                    sb3.append(createPostImage);
                    sb3.append("   path ");
                    sb3.append(createPostImage.getPath());
                    Logger.d(sb3.toString(), new Object[0]);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("ImageCropActivity result applied images ");
                sb4.append(this.images);
                Logger.d(sb4.toString(), new Object[0]);
            }
        }
        if (i2 == -1) {
            if (intent != null) {
                arrayList = intent.getStringArrayListExtra(ImageSelectorActivity.Companion.getREQUEST_OUTPUT());
            }
            if (arrayList != null && i == ImageFile.Companion.getTYPE_POST()) {
                ArrayList arrayList4 = new ArrayList();
                if (arrayList.size() >= 1) {
                    for (String str2 : arrayList) {
                        Intrinsics.checkExpressionValueIsNotNull(str2, "image_uri");
                        arrayList4.add(new CreatePostImage(str2));
                    }
                }
                if (this.images.isEmpty()) {
                    this.images.addAll(arrayList4);
                } else {
                    for (CreatePostImage createPostImage3 : this.images) {
                        ArrayList<CreatePostImage> arrayList5 = new ArrayList<>();
                        for (Object next2 : arrayList4) {
                            if (Intrinsics.areEqual((Object) createPostImage3.getLocalpath(), (Object) ((CreatePostImage) next2).getLocalpath())) {
                                arrayList5.add(next2);
                            }
                        }
                        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                        for (CreatePostImage createPostImage4 : arrayList5) {
                            createPostImage4.setId(createPostImage3.getId());
                            createPostImage4.setDescription(createPostImage3.getDescription());
                            createPostImage4.setPath(createPostImage3.getPath());
                            arrayList6.add(Unit.INSTANCE);
                        }
                    }
                    this.images.clear();
                    this.images.addAll(arrayList4);
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.detail_post_list);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
                Adapter adapter2 = recyclerView2.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyDataSetChanged();
                }
            }
        }
    }
}
