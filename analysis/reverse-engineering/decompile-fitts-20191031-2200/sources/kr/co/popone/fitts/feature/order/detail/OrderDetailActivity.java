package kr.co.popone.fitts.feature.order.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant;
import kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import kr.co.popone.fitts.model.order.OrderState;
import kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailViewModel;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderDetailActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_NUMBER = StringKeyGenerator.Companion.generate(OrderDetailActivity.class, "product_number");
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter();
    @NotNull
    public OrderDetailViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, long j) {
            if (context != null) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra(OrderDetailActivity.KEY_ORDER_NUMBER, j);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderState.values().length];

        static {
            $EnumSwitchMapping$0[OrderState.WAITING.ordinal()] = 1;
        }
    }

    public static final void start(@Nullable Context context, long j) {
        Companion.start(context, j);
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
    public final OrderDetailViewModel getViewModel() {
        OrderDetailViewModel orderDetailViewModel = this.viewModel;
        if (orderDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderDetailViewModel;
    }

    public final void setViewModel(@NotNull OrderDetailViewModel orderDetailViewModel) {
        Intrinsics.checkParameterIsNotNull(orderDetailViewModel, "<set-?>");
        this.viewModel = orderDetailViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_order_detail);
        OrderDetailViewModel orderDetailViewModel = this.viewModel;
        String str = "viewModel";
        if (orderDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderDetailViewModel.getOrderDetailLiveData().observe(new OrderDetailActivity$onCreate$1(this), new OrderDetailActivity$onCreate$2(this));
        OrderDetailViewModel orderDetailViewModel2 = this.viewModel;
        if (orderDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderDetailViewModel2.getCancelCompleteLiveData().observe(new OrderDetailActivity$onCreate$3(this), new OrderDetailActivity$onCreate$4(this));
        OrderDetailViewModel orderDetailViewModel3 = this.viewModel;
        if (orderDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderDetailViewModel3.getErrorLiveData().observe(new OrderDetailActivity$onCreate$5(this), new OrderDetailActivity$onCreate$6(this));
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new OrderDetailActivity$onCreate$7(this), new OrderDetailActivity$onCreate$8(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).setAdapter(this.orderDetailAdapter);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new OrderDetailActivity$onCreate$10(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonOrderCancel)).setOnClickListener(new OrderDetailActivity$onCreate$11(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: private */
    public final void postOrderStateChangeEvent(List<OrderListItemViewData> list) {
        OrderDetailViewModel orderDetailViewModel = this.viewModel;
        if (orderDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Long orderId = orderDetailViewModel.getOrderId();
        if (orderId != null) {
            RxBus.INSTANCE.post(new OrderEvent$OrderStateChangeEvent(orderId.longValue(), list));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        OrderDetailViewModel orderDetailViewModel = this.viewModel;
        if (orderDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        orderDetailViewModel.initDetailOrderId(new OrderDetailActivity$onResume$1(this));
    }

    /* access modifiers changed from: private */
    public final void startCreatePostActivity(OrderEvent$CreatePostOrderVariant orderEvent$CreatePostOrderVariant) {
        String state = orderEvent$CreatePostOrderVariant.getState();
        int hashCode = state.hashCode();
        if (hashCode != -1422950650) {
            if (hashCode == 1475627363 && state.equals("sold_out")) {
                DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this, "", "안타깝게도.. 해당 상품이 품절되어\n포스팅이 불가능해요 😭", null, null, 24, null);
            }
        } else if (state.equals("active")) {
            DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "포스팅 하시겠어요?", "포스팅 시 자동으로 구매확정됩니다.", new OrderDetailActivity$startCreatePostActivity$$inlined$run$lambda$1(orderEvent$CreatePostOrderVariant, this), null, null, null, 0, DimensionsKt.HDPI, null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateOrderHeadInfo(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailDate);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderDetailDate");
            textView.setText(simpleDateFormat.format(orderDetailViewData.getOrderDate()));
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textOrderNumber);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textOrderNumber");
            textView2.setText(orderDetailViewData.getOrderNumber());
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textTotalCount);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "textTotalCount");
            textView3.setText(String.valueOf(orderDetailViewData.getTotalCount()));
        }
    }

    /* access modifiers changed from: private */
    public final void updateBillingInfo(OrderDetailViewData orderDetailViewData) {
        String str;
        if (orderDetailViewData != null) {
            String str2 = "- ";
            String str3 = "textDiscountPrice";
            String str4 = "textAmountOfPayment";
            String str5 = "groupSpecialDiscount";
            String str6 = "groupNormalAdjustment";
            String str7 = "textTotalPrice";
            if (orderDetailViewData.getSpecialDiscountPrice() != null) {
                TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textAmountOfPayment);
                Intrinsics.checkExpressionValueIsNotNull(textView, str4);
                textView.setText(IntExtensionsKt.commaString((orderDetailViewData.getTotalProductPrice() + orderDetailViewData.getTotalShippingPrice()) - orderDetailViewData.getSpecialDiscountPrice().intValue()));
                TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textTotalPrice);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str7);
                textView2.setText(IntExtensionsKt.commaString(orderDetailViewData.calcTotalProductPrice()));
                TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textSpecialDiscount);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "textSpecialDiscount");
                textView3.setText(IntExtensionsKt.commaString(orderDetailViewData.getSpecialDiscountPrice().intValue()));
                TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textDiscountPrice);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str3);
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(IntExtensionsKt.commaString(orderDetailViewData.getSpecialDiscountPrice().intValue()));
                textView4.setText(sb.toString());
                Group group = (Group) _$_findCachedViewById(C0010R$id.groupNormalAdjustment);
                Intrinsics.checkExpressionValueIsNotNull(group, str6);
                ViewExtensionsKt.gone(group);
                Group group2 = (Group) _$_findCachedViewById(C0010R$id.groupSpecialDiscount);
                Intrinsics.checkExpressionValueIsNotNull(group2, str5);
                ViewExtensionsKt.visible(group2);
            } else {
                TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textTotalPrice);
                Intrinsics.checkExpressionValueIsNotNull(textView5, str7);
                textView5.setText(IntExtensionsKt.commaString(orderDetailViewData.calcTotalProductPrice()));
                Group group3 = (Group) _$_findCachedViewById(C0010R$id.groupNormalAdjustment);
                Intrinsics.checkExpressionValueIsNotNull(group3, str6);
                ViewExtensionsKt.visible(group3);
                Group group4 = (Group) _$_findCachedViewById(C0010R$id.groupSpecialDiscount);
                Intrinsics.checkExpressionValueIsNotNull(group4, str5);
                ViewExtensionsKt.gone(group4);
                String adjustType = orderDetailViewData.getAdjustType();
                if (adjustType != null) {
                    int hashCode = adjustType.hashCode();
                    if (hashCode != -1354573786) {
                        if (hashCode != -1340241962) {
                            if (hashCode == 106845584 && adjustType.equals("point")) {
                                updateAdjustInfo(orderDetailViewData.getAdjustValue(), Integer.valueOf(0), Integer.valueOf(0));
                            }
                        } else if (adjustType.equals("membership")) {
                            updateAdjustInfo(Integer.valueOf(0), Integer.valueOf(0), orderDetailViewData.getAdjustValue());
                        }
                    } else if (adjustType.equals("coupon")) {
                        updateAdjustInfo(Integer.valueOf(0), orderDetailViewData.getAdjustValue(), Integer.valueOf(0));
                    }
                }
                TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.textDiscountPrice);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str3);
                Integer adjustValue = orderDetailViewData.getAdjustValue();
                if ((adjustValue != null && adjustValue.intValue() == 0) || orderDetailViewData.getAdjustType() == null) {
                    str = "0";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    Integer adjustValue2 = orderDetailViewData.getAdjustValue();
                    sb2.append(adjustValue2 != null ? IntExtensionsKt.commaString(adjustValue2.intValue()) : null);
                    str = sb2.toString();
                }
                textView6.setText(str);
            }
            TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.textShippingPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView7, "textShippingPrice");
            textView7.setText(IntExtensionsKt.commaString(orderDetailViewData.getTotalShippingPrice()));
            TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.textAmountOfPayment);
            Intrinsics.checkExpressionValueIsNotNull(textView8, str4);
            textView8.setText(IntExtensionsKt.commaString(orderDetailViewData.getTotalOrderPrice()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if (r4 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r3 != null) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
        if (r4 != null) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateAdjustInfo(java.lang.Integer r3, java.lang.Integer r4, java.lang.Integer r5) {
        /*
            r2 = this;
            int r0 = kr.co.popone.fitts.C0010R$id.textUsedPoint
            android.view.View r0 = r2._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textUsedPoint"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = "0"
            if (r3 == 0) goto L_0x001c
            int r3 = r3.intValue()
            java.lang.String r3 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r3)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r3 = r1
        L_0x001d:
            r0.setText(r3)
            int r3 = kr.co.popone.fitts.C0010R$id.textUsedCoupon
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r0 = "textUsedCoupon"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            if (r4 == 0) goto L_0x003a
            int r4 = r4.intValue()
            java.lang.String r4 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r4)
            if (r4 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r4 = r1
        L_0x003b:
            r3.setText(r4)
            int r3 = kr.co.popone.fitts.C0010R$id.textDiscountMembershipPrice
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "textDiscountMembershipPrice"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            if (r5 == 0) goto L_0x0058
            int r4 = r5.intValue()
            java.lang.String r4 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r4)
            if (r4 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r4 = r1
        L_0x0059:
            r3.setText(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.order.detail.OrderDetailActivity.updateAdjustInfo(java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x011a, code lost:
        if (r1 != null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0138, code lost:
        if (r1 != null) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0156, code lost:
        if (r1 != null) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0174, code lost:
        if (r1 != null) goto L_0x0178;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBankInfo(kr.co.popone.fitts.model.order.OrderDetailViewData r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x01bb
            java.lang.String r0 = r10.getPaymentMethod()
            if (r0 != 0) goto L_0x000a
            goto L_0x01bb
        L_0x000a:
            int r1 = r0.hashCode()
            r2 = -900308920(0xffffffffca566048, float:-3512338.0)
            java.lang.String r3 = "textMothodOfPayment"
            java.lang.String r4 = "tableDateDeposite"
            java.lang.String r5 = "tableAccountOfPayment"
            java.lang.String r6 = "tableAccountHolder"
            java.lang.String r7 = "tableBankOfPayment"
            java.lang.String r8 = "tableRowDepositor"
            if (r1 == r2) goto L_0x009c
            r2 = -303793002(0xffffffffede47c96, float:-8.8391497E27)
            if (r1 == r2) goto L_0x0034
            r2 = 846974213(0x327bcd05, float:1.4656739E-8)
            if (r1 == r2) goto L_0x002b
            goto L_0x01bb
        L_0x002b:
            java.lang.String r1 = "kakaopay"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01bb
            goto L_0x003c
        L_0x0034:
            java.lang.String r1 = "credit_card"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01bb
        L_0x003c:
            int r0 = kr.co.popone.fitts.C0010R$id.textMothodOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r10 = r10.getPaymentMethod()
            java.lang.String r10 = r9.getPaymentMethodName(r10)
            r0.setText(r10)
            int r10 = kr.co.popone.fitts.C0010R$id.tableRowDepositor
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TableRow r10 = (android.widget.TableRow) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r8)
            r0 = 8
            r10.setVisibility(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.tableBankOfPayment
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TableRow r10 = (android.widget.TableRow) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r7)
            r10.setVisibility(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.tableAccountHolder
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TableRow r10 = (android.widget.TableRow) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r6)
            r10.setVisibility(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.tableAccountOfPayment
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TableRow r10 = (android.widget.TableRow) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r5)
            r10.setVisibility(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.tableDateDeposite
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TableRow r10 = (android.widget.TableRow) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r4)
            r10.setVisibility(r0)
            goto L_0x01bb
        L_0x009c:
            java.lang.String r1 = "direct_deposit"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01bb
            int r0 = kr.co.popone.fitts.C0010R$id.tableRowDepositor
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TableRow r0 = (android.widget.TableRow) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
            r1 = 0
            r0.setVisibility(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.tableBankOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TableRow r0 = (android.widget.TableRow) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.tableAccountHolder
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TableRow r0 = (android.widget.TableRow) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.tableAccountOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TableRow r0 = (android.widget.TableRow) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setVisibility(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.tableDateDeposite
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TableRow r0 = (android.widget.TableRow) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r0.setVisibility(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textMothodOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r1 = r10.getPaymentMethod()
            java.lang.String r1 = r9.getPaymentMethodName(r1)
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textBankOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textBankOfPayment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r10.getPaymentInfo()
            java.lang.String r2 = "-"
            if (r1 == 0) goto L_0x011d
            java.lang.String r1 = r1.getBankName()
            if (r1 == 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r1 = r2
        L_0x011e:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textDepositor
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textDepositor"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r10.getPaymentInfo()
            if (r1 == 0) goto L_0x013b
            java.lang.String r1 = r1.getRemittorName()
            if (r1 == 0) goto L_0x013b
            goto L_0x013c
        L_0x013b:
            r1 = r2
        L_0x013c:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textAccountOfPayment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textAccountOfPayment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r10.getPaymentInfo()
            if (r1 == 0) goto L_0x0159
            java.lang.String r1 = r1.getAccountNumber()
            if (r1 == 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r1 = r2
        L_0x015a:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textAccountHolder
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textAccountHolder"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r10.getPaymentInfo()
            if (r1 == 0) goto L_0x0177
            java.lang.String r1 = r1.getAccountHolder()
            if (r1 == 0) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r1 = r2
        L_0x0178:
            r0.setText(r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r0 = r10.getPaymentInfo()
            if (r0 == 0) goto L_0x0186
            java.util.Date r0 = r0.getDueDate()
            goto L_0x0187
        L_0x0186:
            r0 = 0
        L_0x0187:
            java.lang.String r1 = "textDateDeposite"
            if (r0 == 0) goto L_0x01ad
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd"
            r0.<init>(r2)
            int r2 = kr.co.popone.fitts.C0010R$id.textDateDeposite
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r10 = r10.getPaymentInfo()
            java.util.Date r10 = r10.getDueDate()
            java.lang.String r10 = r0.format(r10)
            r2.setText(r10)
            goto L_0x01bb
        L_0x01ad:
            int r10 = kr.co.popone.fitts.C0010R$id.textDateDeposite
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            r10.setText(r2)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.order.detail.OrderDetailActivity.updateBankInfo(kr.co.popone.fitts.model.order.OrderDetailViewData):void");
    }

    private final String getPaymentMethodName(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -900308920) {
                if (hashCode != -303793002) {
                    if (hashCode == 846974213 && str.equals("kakaopay")) {
                        return "카카오페이";
                    }
                } else if (str.equals("credit_card")) {
                    return "신용카드";
                }
            } else if (str.equals("direct_deposit")) {
                return "무통장 입금";
            }
        }
        return "-";
    }

    /* access modifiers changed from: private */
    public final void updateUserInfo(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderUserName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderUserName");
            textView.setText(orderDetailViewData.getUserInfo().getName());
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailContact);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textOrderDetailContact");
            textView2.setText(orderDetailViewData.getUserInfo().getContact());
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailEmail);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "textOrderDetailEmail");
            String email = orderDetailViewData.getUserInfo().getEmail();
            boolean z = true;
            if (!(email == null || email.length() == 0)) {
                z = false;
            }
            textView3.setText(z ? "-" : orderDetailViewData.getUserInfo().getEmail());
        }
    }

    /* access modifiers changed from: private */
    public final void updateShippingInfo(OrderDetailViewData orderDetailViewData) {
        String str;
        if (orderDetailViewData != null) {
            UserShippingInfo shippingAddress = orderDetailViewData.getShippingAddress();
            if (shippingAddress != null) {
                TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailShippingName);
                Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderDetailShippingName");
                textView.setText(shippingAddress.getName());
                TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailShippingContact);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "textOrderDetailShippingContact");
                textView2.setText(shippingAddress.getContact());
                TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textOrderDetailShippingAddress);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "textOrderDetailShippingAddress");
                StringBuilder sb = new StringBuilder();
                sb.append(shippingAddress.getAddress());
                sb.append(' ');
                sb.append(shippingAddress.getAddress2());
                textView3.setText(sb.toString());
                TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textShippingMemo);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "textShippingMemo");
                String message = shippingAddress.getMessage();
                if (message != null) {
                    if (!(message.length() == 0)) {
                        str = shippingAddress.getMessage();
                        textView4.setText(str);
                    }
                }
                str = "-";
                textView4.setText(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateCancelButton(OrderState orderState) {
        String str = "buttonOrderCancel";
        if (orderState != null && WhenMappings.$EnumSwitchMapping$0[orderState.ordinal()] == 1) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.buttonOrderCancel);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.buttonOrderCancel);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updatePredictPoint(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textPredictPoint);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textPredictPoint");
            StringBuilder sb = new StringBuilder();
            sb.append(IntExtensionsKt.commaString(orderDetailViewData.getPredictPoint()));
            sb.append(50896);
            textView.setText(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
