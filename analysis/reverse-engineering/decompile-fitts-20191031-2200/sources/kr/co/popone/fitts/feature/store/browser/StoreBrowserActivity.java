package kr.co.popone.fitts.feature.store.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.BaseActivity;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.dialog.ProductPostAdapter;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.AffiliatesProductRestrictState;
import kr.co.popone.fitts.model.product.OrderableType;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewDataKt;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog.Delegate;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreBrowserActivity extends BaseActivity implements Delegate, ProductPostAdapter.Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StoreBrowserActivity.class), "optionSelectDialog", "getOptionSelectDialog()Lkr/co/popone/fitts/ui/custom/StoreOptionSelectDialog;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StoreBrowserActivity.class), "soldOutDialog", "getSoldOutDialog()Landroid/app/Dialog;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StoreBrowserActivity.class), "duplicateDialog", "getDuplicateDialog()Landroid/app/Dialog;"))};
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_EVENT_ID = StringKeyGenerator.Companion.generate(StoreBrowserActivity.class, "half_sale");
    /* access modifiers changed from: private */
    public static final String KEY_INITIALI_URL = StringKeyGenerator.Companion.generate(StoreBrowserActivity.class, "url");
    /* access modifiers changed from: private */
    public static final String KEY_POST_ID = StringKeyGenerator.Companion.generate(StoreBrowserActivity.class, "post_id");
    /* access modifiers changed from: private */
    public static final String KEY_START_FROM = StringKeyGenerator.Companion.generate(StoreBrowserActivity.class, "start_from");
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final Lazy duplicateDialog$delegate = LazyKt__LazyJVMKt.lazy(new StoreBrowserActivity$duplicateDialog$2(this));
    private final Lazy optionSelectDialog$delegate = LazyKt__LazyJVMKt.lazy(new StoreBrowserActivity$optionSelectDialog$2(this));
    private final Lazy soldOutDialog$delegate = LazyKt__LazyJVMKt.lazy(new StoreBrowserActivity$soldOutDialog$2(this));
    @NotNull
    public StoreBrowserViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, Long l, Long l2, int i, Object obj) {
            companion.start(context, str, str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
        }

        public final void start(@Nullable Context context, @NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2) {
            Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.LINK);
            if (context != null) {
                Intent intent = new Intent(context, StoreBrowserActivity.class);
                intent.putExtra(StoreBrowserActivity.KEY_INITIALI_URL, str);
                intent.putExtra(StoreBrowserActivity.KEY_POST_ID, l2);
                intent.putExtra(StoreBrowserActivity.KEY_EVENT_ID, l);
                intent.putExtra(StoreBrowserActivity.KEY_START_FROM, str2);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_UP);
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[AffiliatesProductRestrictState.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[OrderableType.values().length];

        static {
            $EnumSwitchMapping$0[AffiliatesProductRestrictState.NONE.ordinal()] = 1;
            $EnumSwitchMapping$0[AffiliatesProductRestrictState.ALREADY_ORDERED.ordinal()] = 2;
            $EnumSwitchMapping$0[AffiliatesProductRestrictState.NEED_TO_POST.ordinal()] = 3;
            $EnumSwitchMapping$0[AffiliatesProductRestrictState.SOLD_OUT.ordinal()] = 4;
            $EnumSwitchMapping$0[AffiliatesProductRestrictState.CHERRY_PICKER.ordinal()] = 5;
            $EnumSwitchMapping$1[OrderableType.NORMAL.ordinal()] = 1;
            $EnumSwitchMapping$1[OrderableType.SPECIAL_DISCOUNT.ordinal()] = 2;
        }
    }

    private final Dialog getDuplicateDialog() {
        Lazy lazy = this.duplicateDialog$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (Dialog) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final StoreOptionSelectDialog getOptionSelectDialog() {
        Lazy lazy = this.optionSelectDialog$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (StoreOptionSelectDialog) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final Dialog getSoldOutDialog() {
        Lazy lazy = this.soldOutDialog$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (Dialog) lazy.getValue();
    }

    public static final void start(@Nullable Context context, @NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2) {
        Companion.start(context, str, str2, l, l2);
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
        return C0013R$layout.activity_store_browser;
    }

    @NotNull
    public final StoreBrowserViewModel getViewModel() {
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return storeBrowserViewModel;
    }

    public final void setViewModel(@NotNull StoreBrowserViewModel storeBrowserViewModel) {
        Intrinsics.checkParameterIsNotNull(storeBrowserViewModel, "<set-?>");
        this.viewModel = storeBrowserViewModel;
    }

    @NotNull
    public ActivityAnimationType finishAnimationType() {
        return ActivityAnimationType.SLIDE_DOWN;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        String str = "viewModel";
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel.initPostId(new StoreBrowserActivity$onCreate$1(this));
        StoreBrowserViewModel storeBrowserViewModel2 = this.viewModel;
        if (storeBrowserViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel2.initEventId(new StoreBrowserActivity$onCreate$2(this));
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.storeWebview);
        WebSettings settings = webView.getSettings();
        String str2 = "settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str2);
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str2);
        settings2.setDomStorageEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        if (VERSION.SDK_INT >= 21) {
            WebSettings settings3 = webView.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings3, str2);
            settings3.setMixedContentMode(2);
        }
        webView.setWebChromeClient(new StoreBrowserActivity$onCreate$$inlined$apply$lambda$1(this));
        webView.setWebViewClient(new StoreBrowserActivity$onCreate$$inlined$apply$lambda$2(this));
        String stringExtra = getIntent().getStringExtra(KEY_INITIALI_URL);
        StoreBrowserViewModel storeBrowserViewModel3 = this.viewModel;
        if (storeBrowserViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, MessageTemplateProtocol.LINK);
        storeBrowserViewModel3.checkPartnerAndLoading(stringExtra);
        ((WebView) _$_findCachedViewById(C0010R$id.storeWebview)).loadUrl(stringExtra);
        StoreBrowserViewModel storeBrowserViewModel4 = this.viewModel;
        if (storeBrowserViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel4.getOptionsLiveData().observe(new StoreBrowserActivity$onCreate$4(this), new StoreBrowserActivity$onCreate$5(this));
        StoreBrowserViewModel storeBrowserViewModel5 = this.viewModel;
        if (storeBrowserViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel5.isPageLoaedLiveData().observe(new StoreBrowserActivity$onCreate$6(this), new StoreBrowserActivity$onCreate$7(this));
        StoreBrowserViewModel storeBrowserViewModel6 = this.viewModel;
        if (storeBrowserViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel6.getOrderableOptionLiveData().observe(new StoreBrowserActivity$onCreate$8(this), new StoreBrowserActivity$onCreate$9(this));
        StoreBrowserViewModel storeBrowserViewModel7 = this.viewModel;
        if (storeBrowserViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel7.getTotalPriceLiveData().observe(new StoreBrowserActivity$onCreate$10(this), new StoreBrowserActivity$onCreate$11(this));
        StoreBrowserViewModel storeBrowserViewModel8 = this.viewModel;
        if (storeBrowserViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel8.getTotalPriceErrorLiveData().observe(new StoreBrowserActivity$onCreate$12(this), new StoreBrowserActivity$onCreate$13(this));
        StoreBrowserViewModel storeBrowserViewModel9 = this.viewModel;
        if (storeBrowserViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel9.getToastLiveData().observe(new StoreBrowserActivity$onCreate$14(this), new StoreBrowserActivity$onCreate$15(this));
        StoreBrowserViewModel storeBrowserViewModel10 = this.viewModel;
        if (storeBrowserViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel10.getOrderInfoLiveData().observe(new StoreBrowserActivity$onCreate$16(this), new StoreBrowserActivity$onCreate$17(this));
        StoreBrowserViewModel storeBrowserViewModel11 = this.viewModel;
        if (storeBrowserViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel11.getCheckOrderableExceptionLiveData().observe(new StoreBrowserActivity$onCreate$18(this), new StoreBrowserActivity$onCreate$19(this));
        StoreBrowserViewModel storeBrowserViewModel12 = this.viewModel;
        if (storeBrowserViewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel12.getErrorLiveData().observe(new StoreBrowserActivity$onCreate$20(this), new StoreBrowserActivity$onCreate$21(this));
        StoreBrowserViewModel storeBrowserViewModel13 = this.viewModel;
        if (storeBrowserViewModel13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel13.getErrorMessageLiveData().observe(new StoreBrowserActivity$onCreate$22(this), new StoreBrowserActivity$onCreate$23(this));
        StoreBrowserViewModel storeBrowserViewModel14 = this.viewModel;
        if (storeBrowserViewModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel14.getAffiliatesProductLiveData().observe(new StoreBrowserActivity$onCreate$24(this), new StoreBrowserActivity$onCreate$25(this));
        StoreBrowserViewModel storeBrowserViewModel15 = this.viewModel;
        if (storeBrowserViewModel15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel15.isWishProductLiveData().observe(new StoreBrowserActivity$onCreate$26(this), new StoreBrowserActivity$onCreate$27(this));
        StoreBrowserViewModel storeBrowserViewModel16 = this.viewModel;
        if (storeBrowserViewModel16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel16.getSoldOutLiveData().observe(new StoreBrowserActivity$onCreate$28(this), new StoreBrowserActivity$onCreate$29(this));
        StoreBrowserViewModel storeBrowserViewModel17 = this.viewModel;
        if (storeBrowserViewModel17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel17.isShowLoadingBottomView().observe(new StoreBrowserActivity$onCreate$30(this), new StoreBrowserActivity$onCreate$31(this));
        StoreBrowserViewModel storeBrowserViewModel18 = this.viewModel;
        if (storeBrowserViewModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel18.isShowStoreStoreInfoBubble().observe(new StoreBrowserActivity$onCreate$32(this), new StoreBrowserActivity$onCreate$33(this));
        StoreBrowserViewModel storeBrowserViewModel19 = this.viewModel;
        if (storeBrowserViewModel19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel19.getCloseLoadingView().observe(new StoreBrowserActivity$onCreate$34(this), new StoreBrowserActivity$onCreate$35(this));
        StoreBrowserViewModel storeBrowserViewModel20 = this.viewModel;
        if (storeBrowserViewModel20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel20.getStoreNameLiveData().observe(new StoreBrowserActivity$onCreate$36(this), new StoreBrowserActivity$onCreate$37(this));
        StoreBrowserViewModel storeBrowserViewModel21 = this.viewModel;
        if (storeBrowserViewModel21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel21.getBuyButtonGoneLiveData().observe(new StoreBrowserActivity$onCreate$38(this), new StoreBrowserActivity$onCreate$39(this));
        StoreBrowserViewModel storeBrowserViewModel22 = this.viewModel;
        if (storeBrowserViewModel22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel22.getRelatedPostsLiveData().observe(new StoreBrowserActivity$onCreate$40(this), new StoreBrowserActivity$onCreate$41(this));
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribe((Consumer<? super T>) new StoreBrowserActivity$onCreate$42<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        ((LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy)).setOnClickListener(new StoreBrowserActivity$onCreate$43(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.iconClose)).setOnClickListener(new StoreBrowserActivity$onCreate$44(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.iconHart)).setOnClickListener(new StoreBrowserActivity$onCreate$45(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.iconProductPost)).setOnClickListener(new StoreBrowserActivity$onCreate$46(this));
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(C0008R$drawable.icon_loading_store_browser)).into((ImageView) _$_findCachedViewById(C0010R$id.iconLoadingStoreBrowser));
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(C0008R$drawable.icon_loading_store_browser_bottom)).into((ImageView) _$_findCachedViewById(C0010R$id.imageLoadingBottom));
        StoreBrowserViewModel storeBrowserViewModel23 = this.viewModel;
        if (storeBrowserViewModel23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeBrowserViewModel23.leaveEnterLog(getIntent().getStringExtra(KEY_START_FROM));
    }

    /* access modifiers changed from: private */
    public final void hadleSchemeByBuildConfig(String str, String str2) {
        int hashCode = "production".hashCode();
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.handleScheme(this, str2);
    }

    /* access modifiers changed from: private */
    public final void handleIntentScheme(String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            Intrinsics.checkExpressionValueIsNotNull(parseUri, "Intent.parseUri(url, Intent.URI_INTENT_SCHEME)");
            if (getPackageManager().getLaunchIntentForPackage(parseUri.getPackage()) != null) {
                startActivity(parseUri);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            StringBuilder sb = new StringBuilder();
            sb.append("market://details?id=");
            sb.append(parseUri.getPackage());
            intent.setData(Uri.parse(sb.toString()));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void removeDomScript() {
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.executeDomRemoveScript(new StoreBrowserActivity$removeDomScript$1(this));
    }

    public void totalPriceChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderableJsons");
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.getTotalVariantOptions(str);
    }

    public void onOptionSelected(int i, @NotNull List<ProductOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "options");
        getOptionSelectDialog().productOptionSelected(i, list);
    }

    public void onOptionSelectFinished(long j) {
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.getVariantsInfo(j);
    }

    public void onOptionSoldOut() {
        if (!getSoldOutDialog().isShowing()) {
            getSoldOutDialog().show();
        }
    }

    public void onCartButtonClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderableJsons");
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.registerVariantToCart(str);
    }

    public void onBuyButtonClicked(@NotNull List<OrderableOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "orderableOptions");
        StringBuilder sb = new StringBuilder();
        sb.append("onBuyButtonClicked = ");
        sb.append(new Gson().toJson((Object) ProductOptionViewDataKt.mapToEntiry(list)));
        Logger.d(sb.toString(), new Object[0]);
        String json = new Gson().toJson((Object) ProductOptionViewDataKt.mapToEntiry(list));
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Intrinsics.checkExpressionValueIsNotNull(json, "json");
        storeBrowserViewModel.getPreOrderInfo(json);
    }

    public void onOptionDuplicated() {
        if (!getDuplicateDialog().isShowing()) {
            getDuplicateDialog().show();
        }
    }

    public void onPostClick(long j) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_id", j);
        ContextExtensionKt.activityStart(this, intent, ActivityAnimationType.SLIDE_RTOL);
        StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
        if (storeBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeBrowserViewModel.leavePostEnterLog();
    }

    /* access modifiers changed from: private */
    public final void handleOrderableType(OrderableType orderableType) {
        getOptionSelectDialog().updateOrderableType(orderableType);
        int i = WhenMappings.$EnumSwitchMapping$1[orderableType.ordinal()];
        String str = "textBuy";
        if (i == 1) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textBuy);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText("구매하기");
        } else if (i == 2) {
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textBuy);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setText("특가 구매하기");
        }
    }

    /* access modifiers changed from: private */
    public final void updateOptionSelectView(AffiliatesProduct affiliatesProduct) {
        if (affiliatesProduct != null) {
            String str = "badgeProductPostCount";
            String str2 = "layoutBuy";
            String str3 = "iconHart";
            String str4 = "iconProductPost";
            if (affiliatesProduct.isProduct()) {
                ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
                Intrinsics.checkExpressionValueIsNotNull(imageView, str3);
                ViewExtensionsKt.visible(imageView);
                ImageView imageView2 = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
                Intrinsics.checkExpressionValueIsNotNull(imageView2, str3);
                imageView2.setEnabled(true);
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, str2);
                ViewExtensionsKt.visible(linearLayout);
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str2);
                linearLayout2.setEnabled(true);
                if (affiliatesProduct.getRelatedPostsCount() > 0) {
                    ((ImageView) _$_findCachedViewById(C0010R$id.iconProductPost)).setImageResource(C0008R$drawable.icon_product_post);
                    ImageView imageView3 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
                    Intrinsics.checkExpressionValueIsNotNull(imageView3, str4);
                    imageView3.setClickable(true);
                    ImageView imageView4 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
                    Intrinsics.checkExpressionValueIsNotNull(imageView4, str4);
                    ViewExtensionsKt.visible(imageView4);
                    TextView textView = (TextView) _$_findCachedViewById(C0010R$id.badgeProductPostCount);
                    Intrinsics.checkExpressionValueIsNotNull(textView, str);
                    textView.setText(String.valueOf(affiliatesProduct.getRelatedPostsCount()));
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.badgeProductPostCount);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    ViewExtensionsKt.visible(textView2);
                } else {
                    ((ImageView) _$_findCachedViewById(C0010R$id.iconProductPost)).setImageResource(C0008R$drawable.icon_product_post_empty);
                    ImageView imageView5 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
                    Intrinsics.checkExpressionValueIsNotNull(imageView5, str4);
                    imageView5.setClickable(false);
                    ImageView imageView6 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
                    Intrinsics.checkExpressionValueIsNotNull(imageView6, str4);
                    ViewExtensionsKt.visible(imageView6);
                    TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.badgeProductPostCount);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, str);
                    ViewExtensionsKt.gone(textView3);
                }
            } else {
                ImageView imageView7 = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
                Intrinsics.checkExpressionValueIsNotNull(imageView7, str3);
                ViewExtensionsKt.gone(imageView7);
                ImageView imageView8 = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
                Intrinsics.checkExpressionValueIsNotNull(imageView8, str3);
                imageView8.setEnabled(false);
                LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, str2);
                ViewExtensionsKt.gone(linearLayout3);
                LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, str2);
                linearLayout4.setEnabled(false);
                ImageView imageView9 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
                Intrinsics.checkExpressionValueIsNotNull(imageView9, str4);
                ViewExtensionsKt.gone(imageView9);
                TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.badgeProductPostCount);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str);
                ViewExtensionsKt.gone(textView4);
            }
            if (affiliatesProduct.isProduct()) {
                StoreBrowserViewModel storeBrowserViewModel = this.viewModel;
                if (storeBrowserViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                storeBrowserViewModel.startShowStoreInfoBubble();
            }
        }
    }

    public final void hidePartnerlayout() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
        String str = "layoutBuy";
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
        linearLayout.setEnabled(false);
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
        String str2 = "iconHart";
        Intrinsics.checkExpressionValueIsNotNull(imageView, str2);
        imageView.setEnabled(false);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutBuy);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.gone(linearLayout2);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, str2);
        ViewExtensionsKt.gone(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(C0010R$id.iconProductPost);
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "iconProductPost");
        ViewExtensionsKt.gone(imageView3);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.badgeProductPostCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "badgeProductPostCount");
        ViewExtensionsKt.gone(textView);
    }

    /* access modifiers changed from: private */
    public final void updateWishIcon(boolean z) {
        ((ImageView) _$_findCachedViewById(C0010R$id.iconHart)).setImageResource(z ? C0008R$drawable.img_icon_heart_point : C0008R$drawable.img_icon_heart);
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.iconHart);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "iconHart");
        imageView.setTag(z ? "fill" : "empty");
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(C0010R$id.storeWebview)).canGoBack()) {
            ((WebView) _$_findCachedViewById(C0010R$id.storeWebview)).goBack();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
