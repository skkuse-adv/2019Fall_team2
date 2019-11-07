package kr.co.popone.fitts.viewmodel.order;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import kr.co.popone.fitts.model.cart.CartVariants;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderPrice;
import kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.domain.payment.PaymentModuleData;
import kr.co.popone.fitts.model.order.BankAccount;
import kr.co.popone.fitts.model.order.OrderCompleteViewData;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.order.OrderListLineItem;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderViewModel extends BaseViewModel {
    private final MutableLiveData<Result> _addressInfoLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<CouponInfo>> _couponListLiveData = new MutableLiveData<>();
    private Discount _discount;
    /* access modifiers changed from: private */
    public final MutableLiveData<ExpectedReceivablePoint> _expectedReceivablePoint;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _haveToPaymentLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _isSpecialDiscount = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Membership>> _membershipListLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Membership> _membershipLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _membershipNotUsableReasonLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Throwable> _orderErrorLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<OrderPrice> _orderPriceLiveData = new MutableLiveData<>();
    private final MutableLiveData<PaymentModuleData> _paymentModuleLiveData = new MutableLiveData<>();
    private final MutableLiveData<PaymentType> _paymentTypeLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MediatorLiveData<Membership> _showMembershipDialog = new MediatorLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _toastTextLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> _validationMessageLiveData = new MutableLiveData<>();
    private BankAccount bankAccount;
    private final CartRepository cartRepository;
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    @NotNull
    private final MutableLiveData<OrderCompleteViewData> orderCompleteLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<OrderInfoViewData> orderInfoLiveData = new MutableLiveData<>();
    private final OrderInitialData orderInitialData;
    private final ProductRepository productRepository;
    private final FittsSocialRepository socialRepository;
    @Nullable
    private String zipCode;

    public enum PaymentType {
        KAKAO,
        CREDIT_CARD,
        DIRECT_DEPOSIT
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[OrderInitialData.Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.POINT.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.COUPON.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.MEMBERSHIP.ordinal()] = 3;
            $EnumSwitchMapping$1[OrderInitialData.Type.CART.ordinal()] = 1;
            $EnumSwitchMapping$1[OrderInitialData.Type.DIRECT.ordinal()] = 2;
        }
    }

    public OrderViewModel(@NotNull OrderInitialData orderInitialData2, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSocialRepository fittsSocialRepository, @NotNull ProductRepository productRepository2, @NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(orderInitialData2, "orderInitialData");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        Intrinsics.checkParameterIsNotNull(productRepository2, "productRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.orderInitialData = orderInitialData2;
        this.commerceRepository = fittsCommerceRepository;
        this.socialRepository = fittsSocialRepository;
        this.productRepository = productRepository2;
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
        this._paymentTypeLiveData.setValue(PaymentType.KAKAO);
        this.orderInfoLiveData.setValue(this.orderInitialData.getOrderInfo());
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.socialRepository.getFittsMemberships().subscribe(new Consumer<List<? extends Membership>>(this) {
            final /* synthetic */ OrderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(List<Membership> list) {
                this.this$0._membershipListLiveData.setValue(list);
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ OrderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0._membershipListLiveData.setValue(CollectionsKt__CollectionsKt.emptyList());
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "socialRepository.getFitt…List()\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.commerceRepository.getAvailableCoupons(this.orderInitialData.getOrderInfo().getTotalProductPrice()).subscribe(new Consumer<List<? extends CouponInfo>>(this) {
            final /* synthetic */ OrderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(List<CouponInfo> list) {
                this.this$0._couponListLiveData.setValue(list);
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ OrderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getErrorLiveData().setValue(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "commerceRepository.getAv…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        this._showMembershipDialog.addSource(this._membershipLiveData, new Observer<S>(this) {
            final /* synthetic */ OrderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(@Nullable Membership membership) {
                Long l = null;
                if (membership == null || membership.getId() != -1) {
                    Membership membership2 = (Membership) this.this$0._showMembershipDialog.getValue();
                    Object valueOf = membership2 != null ? Long.valueOf(membership2.getId()) : null;
                    if (membership != null) {
                        l = Long.valueOf(membership.getId());
                    }
                    if (!Intrinsics.areEqual(valueOf, (Object) l)) {
                        this.this$0._showMembershipDialog.setValue(membership);
                        return;
                    }
                    return;
                }
                this.this$0._showMembershipDialog.setValue(null);
            }
        });
        boolean z = true;
        this._haveToPaymentLiveData.setValue(Boolean.valueOf(true));
        MutableLiveData<Boolean> mutableLiveData = this._isSpecialDiscount;
        if (this.orderInitialData.getOrderInfo().getSpecialDiscountPrice() == null) {
            z = false;
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
        this._orderPriceLiveData.setValue(OrderPrice.Companion.m148new(this.orderInitialData.getOrderInfo()));
        this._expectedReceivablePoint = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<OrderInfoViewData> getOrderInfoLiveData() {
        return this.orderInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<OrderCompleteViewData> getOrderCompleteLiveData() {
        return this.orderCompleteLiveData;
    }

    @Nullable
    public final String getZipCode() {
        return this.zipCode;
    }

    public final void setZipCode(@Nullable String str) {
        this.zipCode = str;
    }

    @NotNull
    public final MutableLiveData<Boolean> visiblePaymentType() {
        return this._haveToPaymentLiveData;
    }

    @NotNull
    public final MutableLiveData<PaymentType> observePaymentType() {
        return this._paymentTypeLiveData;
    }

    @NotNull
    public final MutableLiveData<PaymentModuleData> observePaymentModuleData() {
        return this._paymentModuleLiveData;
    }

    @NotNull
    public final MutableLiveData<List<Membership>> updateMembershipList() {
        return this._membershipListLiveData;
    }

    @NotNull
    public final MediatorLiveData<Membership> showMembershipDialog() {
        return this._showMembershipDialog;
    }

    @NotNull
    public final MutableLiveData<String> updateMembershipNotUsableReason() {
        return this._membershipNotUsableReasonLiveData;
    }

    @NotNull
    public final MutableLiveData<OrderPrice> updateOrderPriceView() {
        return this._orderPriceLiveData;
    }

    @NotNull
    public final MutableLiveData<String> showToastMessage() {
        return this._toastTextLiveData;
    }

    @NotNull
    public final MutableLiveData<List<CouponInfo>> updateCouponList() {
        return this._couponListLiveData;
    }

    @NotNull
    public final MutableLiveData<String> showVaildationMessage() {
        return this._validationMessageLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> isSpecialDiscount() {
        return this._isSpecialDiscount;
    }

    @NotNull
    public final MutableLiveData<Result> updateAddressInfoView() {
        return this._addressInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Throwable> orderErrorOccured() {
        return this._orderErrorLiveData;
    }

    public final void discountStateChanted(@NotNull Discount discount) {
        Intrinsics.checkParameterIsNotNull(discount, "discount");
        OrderInitialData orderInitialData2 = this.orderInitialData;
        StringBuilder sb = new StringBuilder();
        sb.append("OrderActivity, ");
        sb.append(discount);
        Logger.d(sb.toString(), new Object[0]);
        this._discount = discount;
        Type type = discount.getType();
        if (type != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                OrderPrice orderPrice = OrderPrice.Companion.m149new(orderInitialData2.getOrderInfo(), discount.getPointValue());
                this._haveToPaymentLiveData.setValue(Boolean.valueOf(orderPrice.haveToPay()));
                this._orderPriceLiveData.setValue(orderPrice);
                getExpectedReceivablePoint(discount);
                return;
            } else if (i == 2) {
                OrderPrice orderPrice2 = OrderPrice.Companion.m150new(orderInitialData2.getOrderInfo(), discount.getCoupon());
                this._haveToPaymentLiveData.setValue(Boolean.valueOf(orderPrice2.haveToPay()));
                this._orderPriceLiveData.setValue(orderPrice2);
                getExpectedReceivablePoint(discount);
                return;
            } else if (i == 3) {
                membershipStateChanged(discount.getMembership());
                return;
            }
        }
        OrderPrice orderPrice3 = OrderPrice.Companion.m148new(orderInitialData2.getOrderInfo());
        this._haveToPaymentLiveData.setValue(Boolean.valueOf(orderPrice3.haveToPay()));
        this._orderPriceLiveData.setValue(orderPrice3);
        getExpectedReceivablePoint(null);
    }

    @NotNull
    public final MutableLiveData<ExpectedReceivablePoint> onExpectedReceivablePointUpdate() {
        return this._expectedReceivablePoint;
    }

    /* access modifiers changed from: private */
    public final void getExpectedReceivablePoint(Discount discount) {
        OrderDiscountInfo orderDiscountInfo;
        Type type = null;
        if ((discount != null ? discount.getType() : null) != Type.POINT) {
            if ((discount != null ? discount.getType() : null) != Type.COUPON) {
                if (discount != null) {
                    type = discount.getType();
                }
                if (type != Type.MEMBERSHIP) {
                    orderDiscountInfo = OrderDiscountInfo.Companion.m151new(this.orderInitialData);
                    CompositeDisposable compositeDisposable = this.disposables;
                    Disposable subscribe = this.commerceRepository.getExpectedReceivableFittsPoint(orderDiscountInfo).subscribe(new OrderViewModel$getExpectedReceivablePoint$1(this), new OrderViewModel$getExpectedReceivablePoint$2(this));
                    Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.getEx…mpty()\n                })");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            }
        }
        orderDiscountInfo = OrderDiscountInfo.Companion.m152new(this.orderInitialData, discount);
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.commerceRepository.getExpectedReceivableFittsPoint(orderDiscountInfo).subscribe(new OrderViewModel$getExpectedReceivablePoint$1(this), new OrderViewModel$getExpectedReceivablePoint$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "commerceRepository.getEx…mpty()\n                })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    private final void membershipStateChanged(Membership membership) {
        OrderInitialData orderInitialData2 = this.orderInitialData;
        StringBuilder sb = new StringBuilder();
        sb.append("Membership = ");
        sb.append(membership);
        Logger.d(sb.toString(), new Object[0]);
        if (membership == null) {
            handleMembershipInfo(OrderPrice.Companion.m148new(orderInitialData2.getOrderInfo()), Membership.Companion.newEmpty(), "");
            getExpectedReceivablePoint(null);
        } else if (membership.isInactive()) {
            handleMembershipInfo(OrderPrice.Companion.m148new(orderInitialData2.getOrderInfo()), Membership.Companion.newEmpty(), "핏티님의 멤버십 할인 혜택이 일시 중지되었습니다.");
            this._discount = Discount.Companion.m146new(Type.MEMBERSHIP, null, null, null);
            getExpectedReceivablePoint(null);
        } else if (!membership.isUsableMembership(orderInitialData2.getOrderInfo().getTotalProductPrice())) {
            handleMembershipInfo(OrderPrice.Companion.m148new(orderInitialData2.getOrderInfo()), Membership.Companion.newEmpty(), membership.getUnusableReason(orderInitialData2.getOrderInfo().getTotalProductPrice()));
            this._discount = Discount.Companion.m146new(Type.MEMBERSHIP, null, null, null);
            getExpectedReceivablePoint(null);
        } else {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = this.commerceRepository.calculateMembershipPrice(orderInitialData2.getOrderInfo().getVariantsJson(), membership.getId(), orderInitialData2.getType().getPriceParam()).doOnSuccess(new OrderViewModel$membershipStateChanged$$inlined$with$lambda$1(this, membership)).subscribe(new OrderViewModel$membershipStateChanged$$inlined$with$lambda$2(this, membership), new OrderViewModel$membershipStateChanged$$inlined$with$lambda$3(this, membership));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.calcu… 없습니다\"\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    private final void handleMembershipInfo(OrderPrice orderPrice, Membership membership, String str) {
        this._orderPriceLiveData.setValue(orderPrice);
        this._membershipLiveData.setValue(membership);
        this._membershipNotUsableReasonLiveData.setValue(str);
    }

    public final void updateAddressInfo(@NotNull Result result) {
        Intrinsics.checkParameterIsNotNull(result, MessageTemplateProtocol.ADDRESS);
        this._addressInfoLiveData.setValue(result);
        this.zipCode = result.getZoneCode();
    }

    public final void addressInfoCheckChanged(boolean z) {
        String str;
        if (z) {
            OrderInfoViewData orderInfoViewData = (OrderInfoViewData) this.orderInfoLiveData.getValue();
            if (orderInfoViewData != null) {
                ShippingAddressResponse userAddress = orderInfoViewData.getUserAddress();
                if (userAddress != null) {
                    str = userAddress.getZipCode();
                    this.zipCode = str;
                }
            }
            str = null;
            this.zipCode = str;
        }
    }

    public final void updateBankId(@Nullable BankAccount bankAccount2) {
        this.bankAccount = bankAccount2;
    }

    private final void updateValidationMessage(String str) {
        this._validationMessageLiveData.setValue(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeOrder(@org.jetbrains.annotations.NotNull java.lang.String r43, @org.jetbrains.annotations.NotNull java.lang.String r44, @org.jetbrains.annotations.Nullable java.lang.String r45, @org.jetbrains.annotations.NotNull java.lang.String r46, @org.jetbrains.annotations.NotNull java.lang.String r47, @org.jetbrains.annotations.NotNull java.lang.String r48, @org.jetbrains.annotations.NotNull java.lang.String r49, @org.jetbrains.annotations.Nullable java.lang.String r50, @org.jetbrains.annotations.NotNull java.lang.String r51, @org.jetbrains.annotations.Nullable java.lang.String r52, @org.jetbrains.annotations.Nullable java.lang.String r53) {
        /*
            r42 = this;
            r13 = r42
            r14 = r51
            r12 = r52
            r11 = r53
            java.lang.String r0 = "buyerName"
            r10 = r43
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "buyerContact"
            r9 = r44
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "shippingName"
            r8 = r46
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "shippingContact"
            r7 = r47
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "shippingAddress"
            r6 = r48
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "shippingAddress2"
            r5 = r49
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "remittorName"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r0 = r13.orderInitialData
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "OrderTest,  ZipCode = "
            r1.append(r2)
            java.lang.String r2 = r13.zipCode
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  DiscountType = "
            r1.append(r3)
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r3 = r13._discount
            if (r3 == 0) goto L_0x0065
            java.lang.String r3 = r3.getTypeParameter()
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  PointValue = "
            r1.append(r3)
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r3 = r13._discount
            if (r3 == 0) goto L_0x0085
            java.lang.Integer r3 = r3.getPointValue()
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  CouponId = "
            r1.append(r3)
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r3 = r13._discount
            if (r3 == 0) goto L_0x00af
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r3 = r3.getCoupon()
            if (r3 == 0) goto L_0x00af
            long r15 = r3.getId()
            java.lang.Long r3 = java.lang.Long.valueOf(r15)
            goto L_0x00b0
        L_0x00af:
            r3 = 0
        L_0x00b0:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  MembershipId = "
            r1.append(r3)
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r3 = r13._discount
            if (r3 == 0) goto L_0x00d9
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r3 = r3.getMembership()
            if (r3 == 0) goto L_0x00d9
            long r15 = r3.getId()
            java.lang.Long r3 = java.lang.Long.valueOf(r15)
            goto L_0x00da
        L_0x00d9:
            r3 = 0
        L_0x00da:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  BankId = "
            r1.append(r3)
            java.lang.Long r3 = r42.getBankId()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  RemittorName = "
            r1.append(r3)
            java.lang.String r3 = r13.getRemittorName(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  DeductionType = "
            r1.append(r3)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  DeductionNumber = "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "OrderTest,  PaymentType = "
            r1.append(r3)
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType> r3 = r13._paymentTypeLiveData
            java.lang.Object r3 = r3.getValue()
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r3 = (kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType) r3
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r3 = "OrderTest,  ------------------------------------------"
            com.orhanobut.logger.Logger.d(r3, r1)
            kr.co.popone.fitts.model.order.OrderInfoViewData r1 = r0.getOrderInfo()
            java.util.List r1 = r1.getLineItems()
            java.lang.String r1 = kr.co.popone.fitts.model.cart.CartEntityExtensionKt.mapToLineItemsJson(r1)
            java.lang.String r3 = "[]"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x018c
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, variantsJson is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "상품 정보를 확인하세요."
            r13.updateValidationMessage(r0)
            return
        L_0x018c:
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r43)
            if (r1 == 0) goto L_0x019f
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, buyerName is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "주문자 이름을 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x019f:
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r44)
            if (r1 == 0) goto L_0x01b2
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, buyerContact is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "주문자 연락처를 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x01b2:
            int r1 = r44.length()
            r3 = 10
            java.lang.String r15 = "OrderValidation, shippingContact is Null"
            if (r1 >= r3) goto L_0x01c7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r15, r0)
            java.lang.String r0 = "주문자 연락처를 올바르게 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x01c7:
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r46)
            if (r1 == 0) goto L_0x01da
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, shippingName is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "수령인 이름을 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x01da:
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r47)
            if (r1 == 0) goto L_0x01eb
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r15, r0)
            java.lang.String r0 = "수령인 연락처를 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x01eb:
            int r1 = r47.length()
            if (r1 >= r3) goto L_0x01fc
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r15, r0)
            java.lang.String r0 = "수령인 연락처를 올바르게 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x01fc:
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r48)
            if (r1 == 0) goto L_0x020f
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, shippingAddress is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "배송지 주소를 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x020f:
            boolean r1 = r42.haveToPay()
            java.lang.String r3 = "cart"
            java.lang.String r15 = "direct"
            if (r1 == 0) goto L_0x02f6
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType> r1 = r13._paymentTypeLiveData
            java.lang.Object r1 = r1.getValue()
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r1 = (kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType) r1
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r4 = kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType.DIRECT_DEPOSIT
            if (r1 != r4) goto L_0x0227
            goto L_0x02f6
        L_0x0227:
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType> r1 = r13._paymentTypeLiveData
            java.lang.Object r1 = r1.getValue()
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r1 = (kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType) r1
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r2 = kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType.KAKAO
            if (r1 == r2) goto L_0x024e
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType> r1 = r13._paymentTypeLiveData
            java.lang.Object r1 = r1.getValue()
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r1 = (kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType) r1
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r2 = kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType.CREDIT_CARD
            if (r1 != r2) goto L_0x0240
            goto L_0x024e
        L_0x0240:
            androidx.lifecycle.MutableLiveData r0 = r42.getErrorLiveData()
            java.lang.IllegalAccessException r1 = new java.lang.IllegalAccessException
            r1.<init>()
            r0.setValue(r1)
            goto L_0x0456
        L_0x024e:
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.model.domain.payment.PaymentModuleData> r1 = r13._paymentModuleLiveData
            kr.co.popone.fitts.model.domain.payment.PaymentModuleData r2 = new kr.co.popone.fitts.model.domain.payment.PaymentModuleData
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType> r4 = r13._paymentTypeLiveData
            java.lang.Object r4 = r4.getValue()
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r4 = (kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType) r4
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$PaymentType r11 = kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType.KAKAO
            if (r4 != r11) goto L_0x0261
            java.lang.String r4 = "kakao"
            goto L_0x0263
        L_0x0261:
            java.lang.String r4 = "html5_inicis"
        L_0x0263:
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r11 = r13.orderInitialData
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData$Type r11 = r11.getType()
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData$Type r12 = kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData.Type.CART
            if (r11 != r12) goto L_0x026e
            goto L_0x026f
        L_0x026e:
            r3 = r15
        L_0x026f:
            kr.co.popone.fitts.model.order.OrderInfoViewData r11 = r0.getOrderInfo()
            java.util.List r11 = r11.getLineItems()
            java.lang.String r17 = kr.co.popone.fitts.model.cart.CartEntityExtensionKt.mapToLineItemsJson(r11)
            java.lang.String r11 = r13.zipCode
            if (r11 == 0) goto L_0x0280
            goto L_0x0282
        L_0x0280:
            java.lang.String r11 = ""
        L_0x0282:
            r23 = r11
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r11 = r13._discount
            if (r11 == 0) goto L_0x028f
            java.lang.String r11 = r11.getTypeParameter()
            r27 = r11
            goto L_0x0291
        L_0x028f:
            r27 = 0
        L_0x0291:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r11 = r13._discount
            if (r11 == 0) goto L_0x029c
            java.lang.Integer r11 = r11.getPointValue()
            r28 = r11
            goto L_0x029e
        L_0x029c:
            r28 = 0
        L_0x029e:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r11 = r13._discount
            if (r11 == 0) goto L_0x02b3
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r11 = r11.getCoupon()
            if (r11 == 0) goto L_0x02b3
            long r11 = r11.getId()
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r29 = r11
            goto L_0x02b5
        L_0x02b3:
            r29 = 0
        L_0x02b5:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r11 = r13._discount
            if (r11 == 0) goto L_0x02ca
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r11 = r11.getMembership()
            if (r11 == 0) goto L_0x02ca
            long r11 = r11.getId()
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r30 = r11
            goto L_0x02cc
        L_0x02ca:
            r30 = 0
        L_0x02cc:
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r11 = r13.orderInitialData
            java.lang.Long r31 = r11.getPostId()
            long r11 = r0.getEventId()
            java.lang.Long r32 = java.lang.Long.valueOf(r11)
            r14 = r2
            r15 = r4
            r16 = r3
            r18 = r43
            r19 = r44
            r20 = r45
            r21 = r46
            r22 = r47
            r24 = r48
            r25 = r49
            r26 = r50
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r1.setValue(r2)
            goto L_0x0456
        L_0x02f6:
            boolean r1 = r42.haveToPay()
            r4 = 1
            if (r1 == 0) goto L_0x0356
            boolean r1 = r42.haveToPay()
            if (r1 == 0) goto L_0x0320
            kr.co.popone.fitts.model.order.BankAccount r1 = r13.bankAccount
            if (r1 == 0) goto L_0x0310
            long r17 = r1.getId()
            java.lang.Long r1 = java.lang.Long.valueOf(r17)
            goto L_0x0311
        L_0x0310:
            r1 = 0
        L_0x0311:
            if (r1 != 0) goto L_0x0320
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, bankAccount is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "입금 은행을 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x0320:
            boolean r1 = r42.haveToPay()
            if (r1 == 0) goto L_0x0339
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r51)
            if (r1 == 0) goto L_0x0339
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, remittorName is Null"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "송금인 이름을 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x0339:
            if (r12 == 0) goto L_0x0356
            if (r11 == 0) goto L_0x0346
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r53)
            if (r1 == 0) goto L_0x0344
            goto L_0x0346
        L_0x0344:
            r1 = 0
            goto L_0x0347
        L_0x0346:
            r1 = 1
        L_0x0347:
            if (r1 == 0) goto L_0x0356
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "OrderValidation, taxDeductionNumber is Null or Blank"
            com.orhanobut.logger.Logger.d(r1, r0)
            java.lang.String r0 = "현금영수증 번호를 입력해주세요."
            r13.updateValidationMessage(r0)
            return
        L_0x0356:
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r1 = r13.orderInitialData
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData$Type r1 = r1.getType()
            int[] r2 = kr.co.popone.fitts.viewmodel.order.OrderViewModel.WhenMappings.$EnumSwitchMapping$1
            int r1 = r1.ordinal()
            r1 = r2[r1]
            java.lang.String r2 = "from"
            java.lang.String r12 = "Order"
            if (r1 == r4) goto L_0x0459
            r3 = 2
            if (r1 == r3) goto L_0x036f
            goto L_0x0456
        L_0x036f:
            io.reactivex.disposables.CompositeDisposable r4 = r13.disposables
            kr.co.popone.fitts.repository.ProductRepository r1 = r13.productRepository
            kr.co.popone.fitts.model.order.OrderInfoViewData r3 = r0.getOrderInfo()
            java.util.List r3 = r3.getLineItems()
            java.lang.String r3 = kr.co.popone.fitts.model.cart.CartEntityExtensionKt.mapToLineItemsJson(r3)
            r37 = r2
            java.lang.String r2 = r13.zipCode
            if (r2 != 0) goto L_0x0388
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0388:
            r38 = r4
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x0395
            java.lang.String r4 = r4.getTypeParameter()
            r26 = r4
            goto L_0x0397
        L_0x0395:
            r26 = 0
        L_0x0397:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x03a2
            java.lang.Integer r4 = r4.getPointValue()
            r27 = r4
            goto L_0x03a4
        L_0x03a2:
            r27 = 0
        L_0x03a4:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x03b9
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r4 = r4.getCoupon()
            if (r4 == 0) goto L_0x03b9
            long r17 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r17)
            r28 = r4
            goto L_0x03bb
        L_0x03b9:
            r28 = 0
        L_0x03bb:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x03d0
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r4 = r4.getMembership()
            if (r4 == 0) goto L_0x03d0
            long r16 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r16)
            r29 = r4
            goto L_0x03d2
        L_0x03d0:
            r29 = 0
        L_0x03d2:
            java.lang.Long r30 = r42.getBankId()
            java.lang.String r31 = r13.getRemittorName(r14)
            kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r4 = r13.orderInitialData
            java.lang.Long r34 = r4.getPostId()
            long r35 = r0.getEventId()
            r4 = r15
            r15 = r1
            r16 = r3
            r17 = r43
            r18 = r44
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r2
            r23 = r48
            r24 = r49
            r25 = r50
            r32 = r52
            r33 = r53
            io.reactivex.Single r15 = r15.orderProductVariants(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$3 r3 = new kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$3
            r0 = r3
            r1 = r42
            r14 = r37
            r2 = r51
            r14 = r3
            r3 = r52
            r39 = r4
            r13 = r38
            r4 = r53
            r5 = r43
            r6 = r44
            r7 = r46
            r8 = r47
            r9 = r48
            r10 = r45
            r11 = r49
            r40 = r12
            r12 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$4 r12 = new kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$4
            r0 = r12
            r13 = r12
            r12 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            io.reactivex.disposables.Disposable r0 = r15.subscribe(r14, r13)
            java.lang.String r1 = "productRepository.orderP…it\n                    })"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = r38
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r1, r0)
            r13 = r42
            kr.co.popone.fitts.eventtracker.EventTracker r0 = r13.eventTracker
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r1 = new kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes
            r1.<init>()
            r2 = r37
            r3 = r39
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r1 = r1.put(r2, r3)
            r14 = r40
            r0.logCustom(r14, r1)
        L_0x0456:
            r0 = r13
            goto L_0x0537
        L_0x0459:
            r14 = r12
            io.reactivex.disposables.CompositeDisposable r12 = r13.disposables
            kr.co.popone.fitts.repository.CartRepository r15 = r13.cartRepository
            kr.co.popone.fitts.model.order.OrderInfoViewData r0 = r0.getOrderInfo()
            java.util.List r0 = r0.getLineItems()
            java.lang.String r0 = kr.co.popone.fitts.model.cart.CartEntityExtensionKt.mapToLineItemsJson(r0)
            java.lang.String r1 = r13.zipCode
            if (r1 != 0) goto L_0x0471
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0471:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x047c
            java.lang.String r4 = r4.getTypeParameter()
            r26 = r4
            goto L_0x047e
        L_0x047c:
            r26 = 0
        L_0x047e:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x0489
            java.lang.Integer r4 = r4.getPointValue()
            r27 = r4
            goto L_0x048b
        L_0x0489:
            r27 = 0
        L_0x048b:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x04a0
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r4 = r4.getCoupon()
            if (r4 == 0) goto L_0x04a0
            long r4 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r28 = r4
            goto L_0x04a2
        L_0x04a0:
            r28 = 0
        L_0x04a2:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r4 = r13._discount
            if (r4 == 0) goto L_0x04b7
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r4 = r4.getMembership()
            if (r4 == 0) goto L_0x04b7
            long r4 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r29 = r4
            goto L_0x04b9
        L_0x04b7:
            r29 = 0
        L_0x04b9:
            java.lang.Long r30 = r42.getBankId()
            r11 = r51
            r10 = r2
            java.lang.String r31 = r13.getRemittorName(r11)
            r16 = r0
            r17 = r43
            r18 = r44
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r1
            r23 = r48
            r24 = r49
            r25 = r50
            r32 = r52
            r33 = r53
            io.reactivex.Single r15 = r15.orderCartLineItemVariants(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$1 r9 = new kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$1
            r0 = r9
            r1 = r42
            r2 = r51
            r8 = r3
            r3 = r52
            r4 = r53
            r5 = r43
            r6 = r44
            r7 = r46
            r40 = r14
            r14 = r8
            r8 = r47
            r16 = r14
            r14 = r9
            r9 = r48
            r41 = r10
            r10 = r45
            r11 = r49
            r13 = r12
            r12 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$2 r12 = new kr.co.popone.fitts.viewmodel.order.OrderViewModel$makeOrder$$inlined$with$lambda$2
            r0 = r12
            r17 = r13
            r13 = r12
            r12 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            io.reactivex.disposables.Disposable r0 = r15.subscribe(r14, r13)
            java.lang.String r1 = "cartRepository.orderCart…it\n                    })"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = r17
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r1, r0)
            r0 = r42
            kr.co.popone.fitts.eventtracker.EventTracker r1 = r0.eventTracker
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r2 = new kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes
            r2.<init>()
            r4 = r16
            r3 = r41
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r2 = r2.put(r3, r4)
            r3 = r40
            r1.logCustom(r3, r2)
        L_0x0537:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.order.OrderViewModel.makeOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final Long getBankId() {
        if (!Intrinsics.areEqual((Object) (Boolean) this._haveToPaymentLiveData.getValue(), (Object) Boolean.valueOf(true))) {
            return null;
        }
        BankAccount bankAccount2 = this.bankAccount;
        if (bankAccount2 != null) {
            return Long.valueOf(bankAccount2.getId());
        }
        return null;
    }

    private final String getRemittorName(String str) {
        boolean z = true;
        if (!Intrinsics.areEqual((Object) (Boolean) this._haveToPaymentLiveData.getValue(), (Object) Boolean.valueOf(true))) {
            return null;
        }
        if (str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        return str;
    }

    private final boolean haveToPay() {
        return Intrinsics.areEqual((Object) (Boolean) this._haveToPaymentLiveData.getValue(), (Object) Boolean.valueOf(true));
    }

    public final void updatePaymentType(@NotNull PaymentType paymentType) {
        Intrinsics.checkParameterIsNotNull(paymentType, "type");
        this._paymentTypeLiveData.setValue(paymentType);
    }

    public final void triggerCurrentPaymentType() {
        MutableLiveData<PaymentType> mutableLiveData = this._paymentTypeLiveData;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }

    /* access modifiers changed from: private */
    public final void purchaseLog(List<OrderListLineItem> list) {
        try {
            for (OrderListLineItem lineItemVariants : list) {
                for (OrderListLineItemVariant variant : lineItemVariants.getLineItemVariants()) {
                    CartVariants variant2 = variant.getVariant();
                    this.eventTracker.customLogOrderDetail(variant2.getId(), variant2.getProduct().getTitle(), variant2.getPrice());
                }
            }
        } catch (NullPointerException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("purchaseLog::");
            sb.append(e);
            Logger.d(sb.toString(), new Object[0]);
        }
    }
}
