package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.VoidToUnit;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxRatingBar;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.BaseActivity;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostImageAdapter.CreatePostImageDecorator;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostImageAdapter.Delegate;
import kr.co.popone.fitts.feature.post.upload.posting.PostingActivityUiExtensionKt;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;
import kr.co.popone.fitts.feature.tag.TagGroup;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.ButtonExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreatePostActivity extends BaseActivity implements Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CreatePostActivity.class), "styleButtons", "getStyleButtons()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CreatePostActivity.class), "styles", "getStyles()Ljava/util/List;"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_MODIFY_POST_ID = "modify_post_id";
    @NotNull
    public static final String PARAMETER_ORDER_LINEITEM_VARIANT = "order_lineitem_variant_id";
    @NotNull
    public static final String PARAMETER_POST_MODE = "post_mode";
    @NotNull
    public static final String PARAMETER_POST_TYPE = "post_type";
    public static final int REQUEST_IMAGE_DETAIL = 99;
    public static final int REQUEST_MODIFY_POST = 101;
    public static final int REQUEST_SEARCH_SHOP = 100;
    private HashMap _$_findViewCache;
    @NotNull
    public CreatePostImageAdapter createPostImageAdapter;
    private final Lazy styleButtons$delegate = LazyKt__LazyJVMKt.lazy(new CreatePostActivity$styleButtons$2(this));
    private final Lazy styles$delegate = LazyKt__LazyJVMKt.lazy(new CreatePostActivity$styles$2(this));
    @NotNull
    private final CompositeDisposable viewDisposable = new CompositeDisposable();
    @NotNull
    public CreatePostViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startCreate$default(Companion companion, Context context, String str, String str2, PostVariantViewData postVariantViewData, int i, Object obj) {
            if ((i & 8) != 0) {
                postVariantViewData = null;
            }
            companion.startCreate(context, str, str2, postVariantViewData);
        }

        public final void startCreate(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable PostVariantViewData postVariantViewData) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(str2, "mode");
            Intent intent = new Intent(context, CreatePostActivity.class);
            intent.putExtra("post_type", str);
            intent.putExtra(CreatePostActivity.PARAMETER_POST_MODE, str2);
            intent.putExtra(CreatePostActivity.PARAMETER_ORDER_LINEITEM_VARIANT, postVariantViewData);
            ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_UP);
        }

        public static /* synthetic */ void startModify$default(Companion companion, Activity activity, int i, String str, String str2, long j, PostVariantViewData postVariantViewData, int i2, Object obj) {
            companion.startModify(activity, i, str, str2, j, (i2 & 32) != 0 ? null : postVariantViewData);
        }

        public final void startModify(@NotNull Activity activity, int i, @NotNull String str, @NotNull String str2, long j, @Nullable PostVariantViewData postVariantViewData) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(str2, "mode");
            Intent intent = new Intent(activity, CreatePostActivity.class);
            intent.putExtra("post_type", str);
            intent.putExtra(CreatePostActivity.PARAMETER_POST_MODE, str2);
            intent.putExtra(CreatePostActivity.PARAMETER_MODIFY_POST_ID, j);
            intent.putExtra(CreatePostActivity.PARAMETER_ORDER_LINEITEM_VARIANT, postVariantViewData);
            ActivityExtensionKt.activityStartForResult(activity, intent, ActivityAnimationType.SLIDE_UP, i);
        }
    }

    /* access modifiers changed from: private */
    public final List<Button> getStyleButtons() {
        Lazy lazy = this.styleButtons$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
    }

    private final List<String> getStyles() {
        Lazy lazy = this.styles$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (List) lazy.getValue();
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

    public int layoutResource() {
        return C0013R$layout.activity_createpost;
    }

    @NotNull
    public final CreatePostViewModel getViewModel() {
        CreatePostViewModel createPostViewModel = this.viewModel;
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return createPostViewModel;
    }

    public final void setViewModel(@NotNull CreatePostViewModel createPostViewModel) {
        Intrinsics.checkParameterIsNotNull(createPostViewModel, "<set-?>");
        this.viewModel = createPostViewModel;
    }

    @NotNull
    public final CompositeDisposable getViewDisposable() {
        return this.viewDisposable;
    }

    @NotNull
    public final CreatePostImageAdapter getCreatePostImageAdapter() {
        CreatePostImageAdapter createPostImageAdapter2 = this.createPostImageAdapter;
        if (createPostImageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostImageAdapter");
        }
        return createPostImageAdapter2;
    }

    public final void setCreatePostImageAdapter(@NotNull CreatePostImageAdapter createPostImageAdapter2) {
        Intrinsics.checkParameterIsNotNull(createPostImageAdapter2, "<set-?>");
        this.createPostImageAdapter = createPostImageAdapter2;
    }

    @NotNull
    public ActivityAnimationType finishAnimationType() {
        return ActivityAnimationType.SLIDE_DOWN;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        this.createPostImageAdapter = new CreatePostImageAdapter(this, this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_image_list);
        CreatePostImageAdapter createPostImageAdapter2 = this.createPostImageAdapter;
        if (createPostImageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostImageAdapter");
        }
        recyclerView.setAdapter(createPostImageAdapter2);
        int i = 0;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new CreatePostImageDecorator());
        }
        Unit unit = Unit.INSTANCE;
        CompositeDisposable compositeDisposable = this.viewDisposable;
        Button button = (Button) _$_findCachedViewById(C0010R$id.post_cover_image_insert_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "post_cover_image_insert_button");
        Observable map = RxView.clicks(button).map(VoidToUnit.INSTANCE);
        String str = "RxView.clicks(this).map(VoidToUnit)";
        Intrinsics.checkExpressionValueIsNotNull(map, str);
        Disposable subscribe = map.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "post_cover_image_insert_…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.viewDisposable;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.post_image_insert_button);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "post_image_insert_button");
        Observable map2 = RxView.clicks(linearLayout).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map2, str);
        Disposable subscribe2 = map2.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$3<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "post_image_insert_button…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.viewDisposable;
        Button button2 = (Button) _$_findCachedViewById(C0010R$id.search_shop_button);
        Intrinsics.checkExpressionValueIsNotNull(button2, "search_shop_button");
        Observable map3 = RxView.clicks(button2).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map3, str);
        Disposable subscribe3 = map3.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$4<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "search_shop_button.click…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.viewDisposable;
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.help_button);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "help_button");
        Observable map4 = RxView.clicks(imageButton).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map4, str);
        Disposable subscribe4 = map4.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$5<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe4, "help_button.clicks()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.viewDisposable;
        Button button3 = (Button) _$_findCachedViewById(C0010R$id.showUrlLinkButton);
        Intrinsics.checkExpressionValueIsNotNull(button3, "showUrlLinkButton");
        Observable map5 = RxView.clicks(button3).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map5, str);
        Disposable subscribe5 = map5.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$6<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe5, "showUrlLinkButton.clicks…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.viewDisposable;
        Button button4 = (Button) _$_findCachedViewById(C0010R$id.create_post_button);
        Intrinsics.checkExpressionValueIsNotNull(button4, "create_post_button");
        Observable map6 = RxView.clicks(button4).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map6, str);
        Disposable subscribe6 = map6.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$7<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe6, "create_post_button.click…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.viewDisposable;
        ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C0010R$id.close_button);
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, "close_button");
        Observable map7 = RxView.clicks(imageButton2).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map7, str);
        Disposable subscribe7 = map7.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$8<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe7, "close_button.clicks()\n  …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.viewDisposable;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.post_title);
        String str2 = "post_title";
        Intrinsics.checkExpressionValueIsNotNull(editText, str2);
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str3 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str3);
        Disposable subscribe8 = textChanges.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$9<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe8, "post_title.textChanges()…ring())\n                }");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        CompositeDisposable compositeDisposable9 = this.viewDisposable;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.post_title);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str2);
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str3);
        Disposable subscribe9 = textChanges2.map(CreatePostActivity$onCreate$10.INSTANCE).map(CreatePostActivity$onCreate$11.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$12<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe9, "post_title.textChanges()…y, it))\n                }");
        DisposableKt.plusAssign(compositeDisposable9, subscribe9);
        CompositeDisposable compositeDisposable10 = this.viewDisposable;
        RatingBar ratingBar = (RatingBar) _$_findCachedViewById(C0010R$id.post_rating);
        Intrinsics.checkExpressionValueIsNotNull(ratingBar, "post_rating");
        InitialValueObservable ratingChanges = RxRatingBar.ratingChanges(ratingBar);
        Intrinsics.checkExpressionValueIsNotNull(ratingChanges, "RxRatingBar.ratingChanges(this)");
        Disposable subscribe10 = ratingChanges.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$13<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe10, "post_rating.ratingChange…ged(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable10, subscribe10);
        CompositeDisposable compositeDisposable11 = this.viewDisposable;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.about_product);
        String str4 = "about_product";
        Intrinsics.checkExpressionValueIsNotNull(editText3, str4);
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str3);
        Disposable subscribe11 = textChanges3.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$14<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe11, "about_product.textChange…ring())\n                }");
        DisposableKt.plusAssign(compositeDisposable11, subscribe11);
        CompositeDisposable compositeDisposable12 = this.viewDisposable;
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.about_product);
        Intrinsics.checkExpressionValueIsNotNull(editText4, str4);
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str3);
        Disposable subscribe12 = textChanges4.map(CreatePostActivity$onCreate$15.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$16<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe12, "about_product.textChange…ew.GONE\n                }");
        DisposableKt.plusAssign(compositeDisposable12, subscribe12);
        CompositeDisposable compositeDisposable13 = this.viewDisposable;
        EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.about_size);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "about_size");
        InitialValueObservable textChanges5 = RxTextView.textChanges(editText5);
        Intrinsics.checkExpressionValueIsNotNull(textChanges5, str3);
        Disposable subscribe13 = textChanges5.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$17<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe13, "about_size.textChanges()…ring())\n                }");
        DisposableKt.plusAssign(compositeDisposable13, subscribe13);
        CompositeDisposable compositeDisposable14 = this.viewDisposable;
        EditText editText6 = (EditText) _$_findCachedViewById(C0010R$id.shop);
        String str5 = "shop";
        Intrinsics.checkExpressionValueIsNotNull(editText6, str5);
        InitialValueObservable textChanges6 = RxTextView.textChanges(editText6);
        Intrinsics.checkExpressionValueIsNotNull(textChanges6, str3);
        Disposable subscribe14 = textChanges6.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$18<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe14, "shop.textChanges()\n     …ring())\n                }");
        DisposableKt.plusAssign(compositeDisposable14, subscribe14);
        CompositeDisposable compositeDisposable15 = this.viewDisposable;
        EditText editText7 = (EditText) _$_findCachedViewById(C0010R$id.shop);
        Intrinsics.checkExpressionValueIsNotNull(editText7, str5);
        InitialValueObservable textChanges7 = RxTextView.textChanges(editText7);
        Intrinsics.checkExpressionValueIsNotNull(textChanges7, str3);
        Disposable subscribe15 = textChanges7.map(CreatePostActivity$onCreate$19.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$20<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe15, "shop.textChanges()\n     …ed = it\n                }");
        DisposableKt.plusAssign(compositeDisposable15, subscribe15);
        CompositeDisposable compositeDisposable16 = this.viewDisposable;
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.copy_shop_button);
        Intrinsics.checkExpressionValueIsNotNull(textView, "copy_shop_button");
        Observable map8 = RxView.clicks(textView).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map8, str);
        Disposable subscribe16 = map8.subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$21<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe16, "copy_shop_button.clicks(…     )\n\n                }");
        DisposableKt.plusAssign(compositeDisposable16, subscribe16);
        ((ScrollView) _$_findCachedViewById(C0010R$id.layout_create_post)).setOnTouchListener(new CreatePostActivity$onCreate$22(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.post_tag_layout)).setOnTouchListener(new CreatePostActivity$onCreate$23(this));
        ((TagGroup) _$_findCachedViewById(C0010R$id.tag_create_post)).setOnTagChangeListener(new CreatePostActivity$onCreate$24(this));
        for (Object next : getStyles()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str6 = (String) next;
            Button button5 = (Button) getStyleButtons().get(i);
            button5.setText(str6);
            button5.setOnClickListener(new CreatePostActivity$onCreate$$inlined$forEachIndexed$lambda$1(button5, str6, i, this));
            Unit unit2 = Unit.INSTANCE;
            i = i2;
        }
        CompositeDisposable compositeDisposable17 = this.viewDisposable;
        CreatePostViewModel createPostViewModel = this.viewModel;
        String str7 = "viewModel";
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe17 = createPostViewModel.getPostModelUpdated().map(CreatePostActivity$onCreate$26.INSTANCE).map(CreatePostActivity$onCreate$27.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$28<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe17, "viewModel.postModelUpdat…xt = it\n                }");
        DisposableKt.plusAssign(compositeDisposable17, subscribe17);
        CompositeDisposable compositeDisposable18 = this.viewDisposable;
        CreatePostViewModel createPostViewModel2 = this.viewModel;
        if (createPostViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe18 = createPostViewModel2.getPostModelUpdated().map(CreatePostActivity$onCreate$29.INSTANCE).map(CreatePostActivity$onCreate$30.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$31<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe18, "viewModel.postModelUpdat…iew(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable18, subscribe18);
        CompositeDisposable compositeDisposable19 = this.viewDisposable;
        CreatePostViewModel createPostViewModel3 = this.viewModel;
        if (createPostViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe19 = createPostViewModel3.getPostModelUpdated().map(CreatePostActivity$onCreate$32.INSTANCE).filter(CreatePostActivity$onCreate$33.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$34<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe19, "viewModel.postModelUpdat…ged(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable19, subscribe19);
        CompositeDisposable compositeDisposable20 = this.viewDisposable;
        CreatePostViewModel createPostViewModel4 = this.viewModel;
        if (createPostViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe20 = createPostViewModel4.getPostModelUpdated().map(CreatePostActivity$onCreate$35.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$36<Object>(this));
        String str8 = "viewModel.postModelUpdat…ITABLE)\n                }";
        Intrinsics.checkExpressionValueIsNotNull(subscribe20, str8);
        DisposableKt.plusAssign(compositeDisposable20, subscribe20);
        CompositeDisposable compositeDisposable21 = this.viewDisposable;
        CreatePostViewModel createPostViewModel5 = this.viewModel;
        if (createPostViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe21 = createPostViewModel5.getPostModelUpdated().map(CreatePostActivity$onCreate$37.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$38<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe21, "viewModel.postModelUpdat…ng = it\n                }");
        DisposableKt.plusAssign(compositeDisposable21, subscribe21);
        CompositeDisposable compositeDisposable22 = this.viewDisposable;
        CreatePostViewModel createPostViewModel6 = this.viewModel;
        if (createPostViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe22 = createPostViewModel6.getPostModelUpdated().map(CreatePostActivity$onCreate$39.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$40<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe22, str8);
        DisposableKt.plusAssign(compositeDisposable22, subscribe22);
        CompositeDisposable compositeDisposable23 = this.viewDisposable;
        CreatePostViewModel createPostViewModel7 = this.viewModel;
        if (createPostViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe23 = createPostViewModel7.getPostModelUpdated().map(CreatePostActivity$onCreate$41.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$42<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe23, "viewModel.postModelUpdat…Tag(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable23, subscribe23);
        CompositeDisposable compositeDisposable24 = this.viewDisposable;
        CreatePostViewModel createPostViewModel8 = this.viewModel;
        if (createPostViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe24 = createPostViewModel8.getPostModelUpdated().map(CreatePostActivity$onCreate$43.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$44<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe24, "viewModel.postModelUpdat…ags(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable24, subscribe24);
        CompositeDisposable compositeDisposable25 = this.viewDisposable;
        CreatePostViewModel createPostViewModel9 = this.viewModel;
        if (createPostViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe25 = createPostViewModel9.getPostModelUpdated().map(CreatePostActivity$onCreate$45.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$46<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe25, str8);
        DisposableKt.plusAssign(compositeDisposable25, subscribe25);
        CompositeDisposable compositeDisposable26 = this.viewDisposable;
        CreatePostViewModel createPostViewModel10 = this.viewModel;
        if (createPostViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe26 = createPostViewModel10.getPostModelUpdated().map(CreatePostActivity$onCreate$47.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$48<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe26, str8);
        DisposableKt.plusAssign(compositeDisposable26, subscribe26);
        CompositeDisposable compositeDisposable27 = this.viewDisposable;
        CreatePostViewModel createPostViewModel11 = this.viewModel;
        if (createPostViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe27 = createPostViewModel11.getPostModelUpdated().filter(CreatePostActivity$onCreate$49.INSTANCE).map(CreatePostActivity$onCreate$50.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$51<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe27, "viewModel.postModelUpdat…VISIBLE\n                }");
        DisposableKt.plusAssign(compositeDisposable27, subscribe27);
        CompositeDisposable compositeDisposable28 = this.viewDisposable;
        CreatePostViewModel createPostViewModel12 = this.viewModel;
        if (createPostViewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe28 = createPostViewModel12.getPostModelUpdated().map(CreatePostActivity$onCreate$52.INSTANCE).subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$53<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe28, "viewModel.postModelUpdat…eLoad()\n                }");
        DisposableKt.plusAssign(compositeDisposable28, subscribe28);
        CompositeDisposable compositeDisposable29 = this.viewDisposable;
        CreatePostViewModel createPostViewModel13 = this.viewModel;
        if (createPostViewModel13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe29 = createPostViewModel13.getValidateScroll().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$54<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe29, "viewModel.validateScroll…oInt())\n                }");
        DisposableKt.plusAssign(compositeDisposable29, subscribe29);
        CompositeDisposable compositeDisposable30 = this.viewDisposable;
        CreatePostViewModel createPostViewModel14 = this.viewModel;
        if (createPostViewModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe30 = createPostViewModel14.getPostTitleValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$55<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe30, "viewModel.postTitleValid…awable)\n                }");
        DisposableKt.plusAssign(compositeDisposable30, subscribe30);
        CompositeDisposable compositeDisposable31 = this.viewDisposable;
        CreatePostViewModel createPostViewModel15 = this.viewModel;
        if (createPostViewModel15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe31 = createPostViewModel15.getCoverImageValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$56<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe31, "viewModel.coverImageVali…, 0, 0)\n                }");
        DisposableKt.plusAssign(compositeDisposable31, subscribe31);
        CompositeDisposable compositeDisposable32 = this.viewDisposable;
        CreatePostViewModel createPostViewModel16 = this.viewModel;
        if (createPostViewModel16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe32 = createPostViewModel16.getCoverImageUpdated().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$57<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe32, "viewModel.coverImageUpda…idate()\n                }");
        DisposableKt.plusAssign(compositeDisposable32, subscribe32);
        CompositeDisposable compositeDisposable33 = this.viewDisposable;
        CreatePostViewModel createPostViewModel17 = this.viewModel;
        if (createPostViewModel17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe33 = createPostViewModel17.getDetailImageValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$58<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe33, "viewModel.detailImageVal…is, it)\n                }");
        DisposableKt.plusAssign(compositeDisposable33, subscribe33);
        CompositeDisposable compositeDisposable34 = this.viewDisposable;
        CreatePostViewModel createPostViewModel18 = this.viewModel;
        if (createPostViewModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe34 = createPostViewModel18.getDetailImageUpdated().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$59<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe34, "viewModel.detailImageUpd…idate()\n                }");
        DisposableKt.plusAssign(compositeDisposable34, subscribe34);
        CompositeDisposable compositeDisposable35 = this.viewDisposable;
        CreatePostViewModel createPostViewModel19 = this.viewModel;
        if (createPostViewModel19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe35 = createPostViewModel19.getDetailImageHintUpdated().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$60<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe35, "viewModel.detailImageHin…ext(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable35, subscribe35);
        CompositeDisposable compositeDisposable36 = this.viewDisposable;
        CreatePostViewModel createPostViewModel20 = this.viewModel;
        if (createPostViewModel20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe36 = createPostViewModel20.getDetailImageVisibility().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$61<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe36, "viewModel.detailImageVis…ew.GONE\n                }");
        DisposableKt.plusAssign(compositeDisposable36, subscribe36);
        CompositeDisposable compositeDisposable37 = this.viewDisposable;
        CreatePostViewModel createPostViewModel21 = this.viewModel;
        if (createPostViewModel21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe37 = createPostViewModel21.getStarScoreValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$62<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe37, "viewModel.starScoreValid…nColor)\n                }");
        DisposableKt.plusAssign(compositeDisposable37, subscribe37);
        CompositeDisposable compositeDisposable38 = this.viewDisposable;
        CreatePostViewModel createPostViewModel22 = this.viewModel;
        if (createPostViewModel22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe38 = createPostViewModel22.getAboutSizeValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$63<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe38, "viewModel.aboutSizeValid…nColor)\n                }");
        DisposableKt.plusAssign(compositeDisposable38, subscribe38);
        CompositeDisposable compositeDisposable39 = this.viewDisposable;
        CreatePostViewModel createPostViewModel23 = this.viewModel;
        if (createPostViewModel23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe39 = createPostViewModel23.getShopLinkValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$64<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe39, "viewModel.shopLinkValida…nColor)\n                }");
        DisposableKt.plusAssign(compositeDisposable39, subscribe39);
        CompositeDisposable compositeDisposable40 = this.viewDisposable;
        CreatePostViewModel createPostViewModel24 = this.viewModel;
        if (createPostViewModel24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe40 = createPostViewModel24.getShopBlockValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$65<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe40, "viewModel.shopBlockValid…ty = it\n                }");
        DisposableKt.plusAssign(compositeDisposable40, subscribe40);
        CompositeDisposable compositeDisposable41 = this.viewDisposable;
        CreatePostViewModel createPostViewModel25 = this.viewModel;
        if (createPostViewModel25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe41 = createPostViewModel25.getStyleTagValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$66<Object>(this));
        String str9 = "viewModel.styleTagValida…nColor)\n                }";
        Intrinsics.checkExpressionValueIsNotNull(subscribe41, str9);
        DisposableKt.plusAssign(compositeDisposable41, subscribe41);
        CompositeDisposable compositeDisposable42 = this.viewDisposable;
        CreatePostViewModel createPostViewModel26 = this.viewModel;
        if (createPostViewModel26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe42 = createPostViewModel26.getStyleTagUpdated().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$67<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe42, "viewModel.styleTagUpdate…idate()\n                }");
        DisposableKt.plusAssign(compositeDisposable42, subscribe42);
        CompositeDisposable compositeDisposable43 = this.viewDisposable;
        CreatePostViewModel createPostViewModel27 = this.viewModel;
        if (createPostViewModel27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe43 = createPostViewModel27.getStyleTagValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$68<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe43, str9);
        DisposableKt.plusAssign(compositeDisposable43, subscribe43);
        CompositeDisposable compositeDisposable44 = this.viewDisposable;
        CreatePostViewModel createPostViewModel28 = this.viewModel;
        if (createPostViewModel28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe44 = createPostViewModel28.getShopLinkUpdated().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$69<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe44, "viewModel.shopLinkUpdate…ext(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable44, subscribe44);
        CompositeDisposable compositeDisposable45 = this.viewDisposable;
        CreatePostViewModel createPostViewModel29 = this.viewModel;
        if (createPostViewModel29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe45 = createPostViewModel29.getAboutFitErrorVisivility().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$70<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe45, "viewModel.aboutFitErrorV…ty = it\n                }");
        DisposableKt.plusAssign(compositeDisposable45, subscribe45);
        CompositeDisposable compositeDisposable46 = this.viewDisposable;
        CreatePostViewModel createPostViewModel30 = this.viewModel;
        if (createPostViewModel30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe46 = createPostViewModel30.getAboutFitValidate().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$71<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe46, "viewModel.aboutFitValida…nColor)\n                }");
        DisposableKt.plusAssign(compositeDisposable46, subscribe46);
        CompositeDisposable compositeDisposable47 = this.viewDisposable;
        CreatePostViewModel createPostViewModel31 = this.viewModel;
        if (createPostViewModel31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Disposable subscribe47 = createPostViewModel31.getErrorOccured().subscribe((Consumer<? super T>) new CreatePostActivity$onCreate$72<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe47, "viewModel.errorOccured\n …해주세요.\")\n                }");
        DisposableKt.plusAssign(compositeDisposable47, subscribe47);
        if (Intrinsics.areEqual((Object) getIntent().getStringExtra(PARAMETER_POST_MODE), (Object) "modify")) {
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.styleTagDivider);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "styleTagDivider");
            _$_findCachedViewById.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.style_tag_layout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "style_tag_layout");
            linearLayout2.setVisibility(8);
        }
        Unit unit3 = Unit.INSTANCE;
        CreatePostViewModel createPostViewModel32 = this.viewModel;
        if (createPostViewModel32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str7);
        }
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        createPostViewModel32.loadCreatePostData(intent);
    }

    public void onImageClick() {
        CreatePostViewModel createPostViewModel = this.viewModel;
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        createPostViewModel.postDetailImageEditClicked(new CreatePostActivity$onImageClick$1(this));
    }

    public void onBackPressed() {
        CreatePostViewModel createPostViewModel = this.viewModel;
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        createPostViewModel.closeButtonClicked(new CreatePostActivity$onBackPressed$1(this));
    }

    /* access modifiers changed from: private */
    public final void showFinishDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0013R$layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.findViewById(C0010R$id.ok).setOnClickListener(new CreatePostActivity$showFinishDialog$$inlined$apply$lambda$1(dialog, this));
        dialog.findViewById(C0010R$id.cancel).setOnClickListener(new CreatePostActivity$showFinishDialog$$inlined$apply$lambda$2(dialog, this));
        dialog.show();
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

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = "viewModel";
        switch (i) {
            case 99:
                if (i2 == -1 && intent != null) {
                    CreatePostViewModel createPostViewModel = this.viewModel;
                    if (createPostViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    createPostViewModel.detailImageEdited(intent);
                    return;
                }
                return;
            case 100:
                if (i2 == 1001) {
                    if (intent != null) {
                        CreatePostViewModel createPostViewModel2 = this.viewModel;
                        if (createPostViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                        }
                        createPostViewModel2.shopLinkChanged(intent);
                        return;
                    }
                    return;
                } else if (i2 == 1002) {
                    findViewById(C0010R$id.shop).requestFocus();
                    return;
                } else {
                    return;
                }
            case 101:
                if (i2 == -1) {
                    CreatePostViewModel createPostViewModel3 = this.viewModel;
                    if (createPostViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    createPostViewModel3.savePostTemporary(false);
                    setResult(-1, new Intent());
                    finish();
                    overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
                    return;
                }
                return;
            default:
                if (i2 != -1) {
                    return;
                }
                if (i == ImageFile.Companion.getTYPE_COVER()) {
                    if (intent != null) {
                        CreatePostViewModel createPostViewModel4 = this.viewModel;
                        if (createPostViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                        }
                        createPostViewModel4.coverImageChanged(intent);
                        return;
                    }
                    return;
                } else if (i == ImageFile.Companion.getTYPE_POST() && intent != null) {
                    CreatePostViewModel createPostViewModel5 = this.viewModel;
                    if (createPostViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    createPostViewModel5.detailImageChanged(intent);
                    return;
                } else {
                    return;
                }
        }
    }

    /* access modifiers changed from: private */
    public final void updateCreatePostView(PostType postType) {
        Button button = (Button) _$_findCachedViewById(C0010R$id.post_cover_image_insert_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "post_cover_image_insert_button");
        PostingActivityUiExtensionKt.coverImageInsertButtonText(button, postType);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.post_title);
        Intrinsics.checkExpressionValueIsNotNull(editText, "post_title");
        PostingActivityUiExtensionKt.postTitleHintText(editText, postType);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.create_post_detail_image_insert_label);
        Intrinsics.checkExpressionValueIsNotNull(textView, "create_post_detail_image_insert_label");
        PostingActivityUiExtensionKt.detailImageLebelText(textView, postType);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.post_image_list_hint_desc);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "post_image_list_hint_desc");
        PostingActivityUiExtensionKt.postImageListHintText(textView2, postType);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.productDescriptionErrorTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "productDescriptionErrorTextView");
        PostingActivityUiExtensionKt.productDescErrorText(textView3, postType);
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.post_rating_title);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "post_rating_title");
        PostingActivityUiExtensionKt.postRatingTitleText(textView4, postType);
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.about_product_title);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "about_product_title");
        PostingActivityUiExtensionKt.aboutProductTitleText(textView5, postType);
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.about_product);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "about_product");
        PostingActivityUiExtensionKt.productHintText(editText2, postType);
        TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.about_product_hint);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "about_product_hint");
        PostingActivityUiExtensionKt.aboutProductHintText(textView6, postType);
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.about_size);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "about_size");
        PostingActivityUiExtensionKt.aboutSizeHintText(editText3, postType);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.about_size_layout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "about_size_layout");
        PostingActivityUiExtensionKt.aboutSizeLayoutVisiblity(linearLayout, postType);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CreatePostViewModel createPostViewModel = this.viewModel;
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        createPostViewModel.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        CreatePostViewModel createPostViewModel = this.viewModel;
        if (createPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        createPostViewModel.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.viewDisposable.clear();
    }

    /* access modifiers changed from: private */
    public final void checkSelectedStyleTag(List<String> list) {
        for (String indexOf : list) {
            int indexOf2 = getStyles().indexOf(indexOf);
            if (indexOf2 >= 0) {
                Button button = (Button) getStyleButtons().get(indexOf2);
                button.setSelected(true);
                ButtonExtensionsKt.updateStyleButton(button);
            }
        }
    }
}
