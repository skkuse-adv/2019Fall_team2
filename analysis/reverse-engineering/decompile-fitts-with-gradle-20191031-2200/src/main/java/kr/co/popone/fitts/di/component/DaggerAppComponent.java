package kr.co.popone.fitts.di.component;

import android.app.Activity;
import android.app.Service;
import androidx.fragment.app.Fragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.android.AndroidInjector.Factory;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.AppManager_Factory;
import kr.co.popone.fitts.base.FittsApplication;
import kr.co.popone.fitts.base.FittsApplication_MembersInjector;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.SessionManager_Factory;
import kr.co.popone.fitts.di.module.AppModule;
import kr.co.popone.fitts.di.module.AppModule_ProvideActionLogUtilFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideApplicationFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideContextFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideCreatePostActivityUtilFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideDataHoldermanagerFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideEventTrackerFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideFirebaseAnalyticsFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideNotificationHandlerFactory;
import kr.co.popone.fitts.di.module.AppModule_ProvideSchemeHandlerFactory;
import kr.co.popone.fitts.di.module.ClientModule;
import kr.co.popone.fitts.di.module.ClientModule_ProvideClient$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.ClientModule_ProvideIntercept$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.CreatePostModule;
import kr.co.popone.fitts.di.module.CreatePostModule_ProvideCreatePostViewModelFactory;
import kr.co.popone.fitts.di.module.GlobeConfigModule;
import kr.co.popone.fitts.di.module.GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory;
import kr.co.popone.fitts.di.module.IdentificationModule;
import kr.co.popone.fitts.di.module.IdentificationModule_ProvideCreatePostViewModelFactory;
import kr.co.popone.fitts.di.module.RepositoryModule;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideAllSearchHistoryRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideCartRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideCategorySearchRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideExchangeRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideFittsCommerceRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideFittsServiceRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideFittsSocialRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideHomeRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvidePostRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideProductRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideRefundRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideSearchRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideShopSearchHistoryRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideStoreRepositoryFactory;
import kr.co.popone.fitts.di.module.RepositoryModule_ProvideUserRepositoryFactory;
import kr.co.popone.fitts.di.module.ServiceModule;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideActionLogAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideCartAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideCategoryAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideCollectionAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideCouponAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideEventAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideExchangeApiFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideFittsCommerceApiFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideFittsServiceApiFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideFittsSocialApiFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvidePaymentAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvidePostAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideProductAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideRefundApiFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideSearchAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideStoreAPIFactory;
import kr.co.popone.fitts.di.module.ServiceModule_ProvideUserAPIFactory;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateCartActivity$CartActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent;
import kr.co.popone.fitts.di.module.ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.WebActivity;
import kr.co.popone.fitts.feature.alarm.AlarmFragment;
import kr.co.popone.fitts.feature.alarm.AlarmFragment_MembersInjector;
import kr.co.popone.fitts.feature.alarm.AlarmSettingActivity;
import kr.co.popone.fitts.feature.alarm.AlarmSettingActivity_MembersInjector;
import kr.co.popone.fitts.feature.banner.BannerActivity;
import kr.co.popone.fitts.feature.banner.BannerActivity_MembersInjector;
import kr.co.popone.fitts.feature.card.FittsCardRendingActivity;
import kr.co.popone.fitts.feature.card.FittsCardRendingActivity_MembersInjector;
import kr.co.popone.fitts.feature.cart.CartActivity;
import kr.co.popone.fitts.feature.cart.CartActivity_MembersInjector;
import kr.co.popone.fitts.feature.category.CategorySearchActivity;
import kr.co.popone.fitts.feature.category.CategorySearchActivity_MembersInjector;
import kr.co.popone.fitts.feature.category.CategorySearchFragment;
import kr.co.popone.fitts.feature.category.CategorySearchFragment_MembersInjector;
import kr.co.popone.fitts.feature.collection.MixedCollectionActivity;
import kr.co.popone.fitts.feature.collection.MixedCollectionActivity_MembersInjector;
import kr.co.popone.fitts.feature.collection.PostCollectionActivity;
import kr.co.popone.fitts.feature.collection.PostCollectionActivity_MembersInjector;
import kr.co.popone.fitts.feature.collection.PromotionCollectionActivity;
import kr.co.popone.fitts.feature.collection.PromotionCollectionActivity_MembersInjector;
import kr.co.popone.fitts.feature.comment.CommentsActivity;
import kr.co.popone.fitts.feature.comment.CommentsActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponHomeActivity;
import kr.co.popone.fitts.feature.coupon.CouponHomeActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponListFragment;
import kr.co.popone.fitts.feature.coupon.CouponListFragment_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity;
import kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponRegisterActivity;
import kr.co.popone.fitts.feature.coupon.CouponRegisterActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity;
import kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponUseActivity;
import kr.co.popone.fitts.feature.coupon.CouponUseActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity;
import kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.TermsAgreeWebViewActivity;
import kr.co.popone.fitts.feature.coupon.TermsAgreeWebViewActivity_MembersInjector;
import kr.co.popone.fitts.feature.coupon.UsedCouponHistoryFragment;
import kr.co.popone.fitts.feature.coupon.UsedCouponHistoryFragment_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventApplyActivity;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventApplyActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableEventActivity;
import kr.co.popone.fitts.feature.event.AppliableEventActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableEventApplyActivity;
import kr.co.popone.fitts.feature.event.AppliableEventApplyActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableEventResultActivity;
import kr.co.popone.fitts.feature.event.AppliableEventResultActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.AppliableEventWinnerInputActivity;
import kr.co.popone.fitts.feature.event.AppliableEventWinnerInputActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.EventShopWebActivity;
import kr.co.popone.fitts.feature.event.EventShopWebActivity_MembersInjector;
import kr.co.popone.fitts.feature.event.MultiImageEventActivity;
import kr.co.popone.fitts.feature.event.MultiImageEventActivity_MembersInjector;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyActivity;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyActivity_MembersInjector;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyCompleteFragment;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity_MembersInjector;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteFragment;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.follow.FollowActivity;
import kr.co.popone.fitts.feature.follow.FollowActivity_MembersInjector;
import kr.co.popone.fitts.feature.home.HomeFragment;
import kr.co.popone.fitts.feature.home.HomeFragment_MembersInjector;
import kr.co.popone.fitts.feature.home.WelcomeActivity;
import kr.co.popone.fitts.feature.home.WelcomeActivity_MembersInjector;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment_MembersInjector;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity_MembersInjector;
import kr.co.popone.fitts.feature.identification.view.IdentificationAdditionalInfoFragment;
import kr.co.popone.fitts.feature.identification.view.IdentificationAdditionalInfoFragment_MembersInjector;
import kr.co.popone.fitts.feature.identification.view.IdentificationWebViewFragment;
import kr.co.popone.fitts.feature.identification.view.IdentificationWebViewFragment_MembersInjector;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.intro.IntroActivity_MembersInjector;
import kr.co.popone.fitts.feature.intro.IntroLoginFragment;
import kr.co.popone.fitts.feature.intro.IntroLoginFragment_MembersInjector;
import kr.co.popone.fitts.feature.intro.join.JoinActivity;
import kr.co.popone.fitts.feature.intro.join.JoinActivity_MembersInjector;
import kr.co.popone.fitts.feature.intro.login.LoginActivity;
import kr.co.popone.fitts.feature.intro.login.LoginActivity_MembersInjector;
import kr.co.popone.fitts.feature.intro.login.ResetPasswordActivity;
import kr.co.popone.fitts.feature.intro.login.ResetPasswordActivity_MembersInjector;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.feature.main.MainActivity_MembersInjector;
import kr.co.popone.fitts.feature.me.MeFragment;
import kr.co.popone.fitts.feature.me.MeFragment_MembersInjector;
import kr.co.popone.fitts.feature.me.ModifyBodyActivity;
import kr.co.popone.fitts.feature.me.ModifyBodyActivity_MembersInjector;
import kr.co.popone.fitts.feature.me.ModifyProfileActivity;
import kr.co.popone.fitts.feature.me.ModifyProfileActivity_MembersInjector;
import kr.co.popone.fitts.feature.me.like.LikedActivity;
import kr.co.popone.fitts.feature.me.like.LikedActivity_MembersInjector;
import kr.co.popone.fitts.feature.ncommerce.NCommerceActivity;
import kr.co.popone.fitts.feature.ncommerce.NCommerceActivity_MembersInjector;
import kr.co.popone.fitts.feature.ncommerce.PointHistoryFragment;
import kr.co.popone.fitts.feature.ncommerce.PointHistoryFragment_MembersInjector;
import kr.co.popone.fitts.feature.ncommerce.PointRevenueDetailFragment;
import kr.co.popone.fitts.feature.ncommerce.PointRevenueDetailFragment_MembersInjector;
import kr.co.popone.fitts.feature.ncommerce.PointUsageHistoryFragment;
import kr.co.popone.fitts.feature.ncommerce.PointUsageHistoryFragment_MembersInjector;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity_MembersInjector;
import kr.co.popone.fitts.feature.order.OrderActivity;
import kr.co.popone.fitts.feature.order.OrderActivity_MembersInjector;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity_MembersInjector;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderPaymentFragment;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderPaymentFragment_MembersInjector;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderReservationFragment;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderReservationFragment_MembersInjector;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity_MembersInjector;
import kr.co.popone.fitts.feature.order.orderlist.OrderListActivity;
import kr.co.popone.fitts.feature.order.orderlist.OrderListActivity_MembersInjector;
import kr.co.popone.fitts.feature.payment.PaymentModuleActivity;
import kr.co.popone.fitts.feature.payment.PaymentModuleActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.PostFirstWriteNoticeActivity;
import kr.co.popone.fitts.feature.post.PostFirstWriteNoticeActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.PostVerificationFinishNoticeActivity;
import kr.co.popone.fitts.feature.post.PostVerificationFinishNoticeActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity;
import kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.PostingViolationNoticeActivity;
import kr.co.popone.fitts.feature.post.PostingViolationNoticeActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.ProfileInputActivity;
import kr.co.popone.fitts.feature.post.ProfileInputActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.UserSizeInputActivity;
import kr.co.popone.fitts.feature.post.UserSizeInputActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.post.detail.PostActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.detail.ReportPostActivity;
import kr.co.popone.fitts.feature.post.detail.ReportPostActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.follow.FollowingPostActivity;
import kr.co.popone.fitts.feature.post.follow.FollowingPostActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity;
import kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.upload.crop.PostImageDetailActivity;
import kr.co.popone.fitts.feature.post.upload.guide.PostFirstWriteGuideActivity;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity_MembersInjector;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;
import kr.co.popone.fitts.feature.push.order.OrderAllCancelFragment;
import kr.co.popone.fitts.feature.push.order.OrderAllCancelFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderCompleteFragment;
import kr.co.popone.fitts.feature.push.order.OrderCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderPartCancelFragment;
import kr.co.popone.fitts.feature.push.order.OrderPartCancelFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderPaymentCompleteFragment;
import kr.co.popone.fitts.feature.push.order.OrderPaymentCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderPaymentRushFragment;
import kr.co.popone.fitts.feature.push.order.OrderPaymentRushFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderRendingActivity;
import kr.co.popone.fitts.feature.push.order.OrderRendingActivity_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderReservationCancelFragment;
import kr.co.popone.fitts.feature.push.order.OrderReservationCancelFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderReservationCompleteFragment;
import kr.co.popone.fitts.feature.push.order.OrderReservationCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderReservationSoldOutFragment;
import kr.co.popone.fitts.feature.push.order.OrderReservationSoldOutFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.OrderShippingCompleteFragment;
import kr.co.popone.fitts.feature.push.order.OrderShippingCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.PaymentCancelMisPriceFragment;
import kr.co.popone.fitts.feature.push.order.PaymentCancelMisPriceFragment_MembersInjector;
import kr.co.popone.fitts.feature.push.order.PaymentCancelSoldOutFragment;
import kr.co.popone.fitts.feature.push.order.PaymentCancelSoldOutFragment_MembersInjector;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity_MembersInjector;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity_MembersInjector;
import kr.co.popone.fitts.feature.refund.RefundApplyActivity;
import kr.co.popone.fitts.feature.refund.RefundApplyActivity_MembersInjector;
import kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment;
import kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity_MembersInjector;
import kr.co.popone.fitts.feature.refund.RefundCompleteFragment;
import kr.co.popone.fitts.feature.refund.RefundCompleteFragment_MembersInjector;
import kr.co.popone.fitts.feature.reward.RewardPointUseActivity;
import kr.co.popone.fitts.feature.reward.RewardPointUseActivity_MembersInjector;
import kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity;
import kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity_MembersInjector;
import kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity;
import kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity_MembersInjector;
import kr.co.popone.fitts.feature.reward.UsedRewardHistoryFragment;
import kr.co.popone.fitts.feature.reward.UsedRewardHistoryFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.feature.search.ShopSearchActivity_MembersInjector;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity_MembersInjector;
import kr.co.popone.fitts.feature.search.view.FittieSearchResultFragment;
import kr.co.popone.fitts.feature.search.view.FittieSearchResultFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.IntergratedSearchResultFragment;
import kr.co.popone.fitts.feature.search.view.IntergratedSearchResultFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.PostSearchResultFragment;
import kr.co.popone.fitts.feature.search.view.PostSearchResultFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.SearchActivity;
import kr.co.popone.fitts.feature.search.view.SearchActivity_MembersInjector;
import kr.co.popone.fitts.feature.search.view.SearchHistoryFragment;
import kr.co.popone.fitts.feature.search.view.SearchHistoryFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.SearchHomeFragment;
import kr.co.popone.fitts.feature.search.view.SearchHomeFragment_MembersInjector;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment_MembersInjector;
import kr.co.popone.fitts.feature.setting.FeedbackActivity;
import kr.co.popone.fitts.feature.setting.FeedbackActivity_MembersInjector;
import kr.co.popone.fitts.feature.setting.ModifyUserInfoActivity;
import kr.co.popone.fitts.feature.setting.ModifyUserInfoActivity_MembersInjector;
import kr.co.popone.fitts.feature.setting.SettingActivity;
import kr.co.popone.fitts.feature.setting.SettingActivity_MembersInjector;
import kr.co.popone.fitts.feature.setting.WithdrawalActivity;
import kr.co.popone.fitts.feature.setting.WithdrawalActivity_MembersInjector;
import kr.co.popone.fitts.feature.showroom.ModifyShowRoomActivity;
import kr.co.popone.fitts.feature.showroom.ModifyShowRoomActivity_MembersInjector;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity_MembersInjector;
import kr.co.popone.fitts.feature.store.StoreFragment;
import kr.co.popone.fitts.feature.store.StoreFragment_MembersInjector;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity_MembersInjector;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity_MembersInjector;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity_MembersInjector;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity_MembersInjector;
import kr.co.popone.fitts.feature.store.newest.StoreNewFeedFragment;
import kr.co.popone.fitts.feature.store.newest.StoreNewFeedFragment_MembersInjector;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment_MembersInjector;
import kr.co.popone.fitts.feature.tag.TagSearchActivity;
import kr.co.popone.fitts.feature.tag.TagSearchActivity_MembersInjector;
import kr.co.popone.fitts.feature.trend.TrendFeedActivity;
import kr.co.popone.fitts.feature.trend.TrendFeedActivity_MembersInjector;
import kr.co.popone.fitts.feature.wish.WishListActvitity;
import kr.co.popone.fitts.feature.wish.WishListActvitity_MembersInjector;
import kr.co.popone.fitts.http.GlobeHttpHandler;
import kr.co.popone.fitts.http.RequestIntercept;
import kr.co.popone.fitts.http.RequestIntercept_Factory;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import kr.co.popone.fitts.model.cart.CartAPI;
import kr.co.popone.fitts.model.category.CategoryAPI;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.product.ProductAPI;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.model.store.StoreAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.CategoryRepository;
import kr.co.popone.fitts.repository.ExchangeRepository;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.repository.home.HomeRepository;
import kr.co.popone.fitts.services.FittsFirebaseMessagingService;
import kr.co.popone.fitts.services.FittsFirebaseMessagingService_MembersInjector;
import kr.co.popone.fitts.services.FittsFirebaseMessasingServiceComponent;
import kr.co.popone.fitts.services.FittsNotificationHandler;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.DataHolderManager;
import kr.co.popone.fitts.viewmodel.alarm.AlarmModule;
import kr.co.popone.fitts.viewmodel.alarm.AlarmModule_ProvideAlarmViewModelFactory;
import kr.co.popone.fitts.viewmodel.alarm.AlarmModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.alarm.AlarmViewModel;
import kr.co.popone.fitts.viewmodel.alarm.AlarmViewModelFactory;
import kr.co.popone.fitts.viewmodel.banner.BannerModule;
import kr.co.popone.fitts.viewmodel.banner.BannerModule_ProvideCartViewModelFactory;
import kr.co.popone.fitts.viewmodel.banner.BannerModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.banner.BannerViewModel;
import kr.co.popone.fitts.viewmodel.banner.BannerViewModelFactory;
import kr.co.popone.fitts.viewmodel.cart.CartModule;
import kr.co.popone.fitts.viewmodel.cart.CartModule_ProvideCartViewModelFactory;
import kr.co.popone.fitts.viewmodel.cart.CartModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.cart.CartViewModel;
import kr.co.popone.fitts.viewmodel.cart.CartViewModelFactory;
import kr.co.popone.fitts.viewmodel.category.CategorySearchModule;
import kr.co.popone.fitts.viewmodel.category.CategorySearchModule_ProvideCategorySearchActivityViewModelFactory;
import kr.co.popone.fitts.viewmodel.category.CategorySearchModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.category.CategorySearchViewModel;
import kr.co.popone.fitts.viewmodel.category.CategorySearchViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeModule;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeModule_ProvideRefundViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeApplyCompleteFragmentModule;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteActivityModule;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteFragmentModule;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModel;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.HomeModule;
import kr.co.popone.fitts.viewmodel.home.HomeModule_ProvideHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.HomeModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.home.HomeViewModel;
import kr.co.popone.fitts.viewmodel.home.HomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedModule;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedModule_ProvideHomeFeedViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostModule;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostModule_ProvideHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostViewModel;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceModule;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.PointHistoryModule;
import kr.co.popone.fitts.viewmodel.ncommerce.PointHistoryModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.PointHistoryModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.PointUsageHistoryModule;
import kr.co.popone.fitts.viewmodel.ncommerce.PointUsageHistoryModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.PointUsageHistoryModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.RevenueDetailModule;
import kr.co.popone.fitts.viewmodel.ncommerce.RevenueDetailModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.ncommerce.RevenueDetailModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.OrderModule;
import kr.co.popone.fitts.viewmodel.order.OrderModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.OrderModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel;
import kr.co.popone.fitts.viewmodel.order.OrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderModule;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderPaymentModule;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderReservationModule;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailModule;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailViewModel;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.list.OrderListModule;
import kr.co.popone.fitts.viewmodel.order.list.OrderListModule_ProvideOrderListViewModelFactory;
import kr.co.popone.fitts.viewmodel.order.list.OrderListModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.order.list.OrderListViewModel;
import kr.co.popone.fitts.viewmodel.order.list.OrderListViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderAllCancelModule;
import kr.co.popone.fitts.viewmodel.push.OrderAllCancelModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderAllCancelModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderCompleteModule;
import kr.co.popone.fitts.viewmodel.push.OrderCompleteModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderCompleteModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPartCancelModule;
import kr.co.popone.fitts.viewmodel.push.OrderPartCancelModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPartCancelModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentCompleteModule;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentCompleteModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentRushModule;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentRushModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPaymentRushModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCancelModule;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCancelModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCancelModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCompleteModule;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCompleteModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationCompleteModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationSoldOutModule;
import kr.co.popone.fitts.viewmodel.push.OrderReservationSoldOutModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.OrderShippingCompleteModule;
import kr.co.popone.fitts.viewmodel.push.OrderShippingCompleteModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.OrderShippingCompleteModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelMisPriceModule;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelMisPriceModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelMisPriceModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelSoldOutModule;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelSoldOutModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.push.PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendModule;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendViewModel;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundModule;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundModule_ProvideRefundViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundApplyCompleteFragmentModule;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteActivityModule;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteActivityModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteFragmentModule;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchHistoryModule;
import kr.co.popone.fitts.viewmodel.search.home.SearchHistoryModule_ProvideHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchHistoryModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchHomeModule;
import kr.co.popone.fitts.viewmodel.search.home.SearchHomeModule_ProvideHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchHomeModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchModule;
import kr.co.popone.fitts.viewmodel.search.home.SearchModule_ProvideHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.FittieSearchResultModule;
import kr.co.popone.fitts.viewmodel.search.result.FittieSearchResultModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.FittieSearchResultModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.result.PostSearchResultModule;
import kr.co.popone.fitts.viewmodel.search.result.PostSearchResultModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.PostSearchResultModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.result.ProductSearchResultModule;
import kr.co.popone.fitts.viewmodel.search.result.ProductSearchResultModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.ProductSearchResultModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultModule;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.UnifiedSearchResultModule;
import kr.co.popone.fitts.viewmodel.search.result.UnifiedSearchResultModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.search.result.UnifiedSearchResultModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.StoreModule;
import kr.co.popone.fitts.viewmodel.store.StoreModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.StoreModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.StoreViewModel;
import kr.co.popone.fitts.viewmodel.store.StoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.ShopBridgeViewModel;
import kr.co.popone.fitts.viewmodel.store.bridge.StoreBridgeModule;
import kr.co.popone.fitts.viewmodel.store.bridge.StoreBridgeModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.StoreBridgeModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.StoreBridgeViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeModule;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeViewModel;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserModule;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserViewModel;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModelModule;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModelModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkModule;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkModule_ProvideStoreHomeViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkViewModel;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModel;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModelModule;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModelModule_ProvideHomeFeedViewModelFactory;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModelModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedModule;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedModule_ProvideStoreViewModelFactory;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModelFactory;
import kr.co.popone.fitts.viewmodel.wish.WishListModule;
import kr.co.popone.fitts.viewmodel.wish.WishListModule_ProvideOrderViewModelFactory;
import kr.co.popone.fitts.viewmodel.wish.WishListModule_ProvidesViewModelFactoryFactory;
import kr.co.popone.fitts.viewmodel.wish.WishListViewModel;
import kr.co.popone.fitts.viewmodel.wish.WishListViewModelFactory;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import photopicker.view.ImagePreviewActivity;
import photopicker.view.ImagePreviewActivity_MembersInjector;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity_MembersInjector;
import retrofit2.Retrofit;

public final class DaggerAppComponent implements AppComponent {
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent.Builder> alarmFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AlarmSettingActivityComponent.Builder> alarmSettingActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<AppManager> appManagerProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableCollaborativeEventActivityComponent.Builder> appliableCollaborativeEventActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableCollaborativeEventApplyActivityComponent.Builder> appliableCollaborativeEventApplyActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableEventActivityComponent.Builder> appliableEventActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableEventApplyActivityComponent.Builder> appliableEventApplyActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableEventResultActivityComponent.Builder> appliableEventResultActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.AppliableEventWinnerInputActivityComponent.Builder> appliableEventWinnerInputActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent.Builder> bannerActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateCartActivity$CartActivitySubcomponent.Builder> cartActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent.Builder> categorySearchActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.CategorySearchFragmentComponent.Builder> categorySearchFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CommentsActivityComponent.Builder> commentsActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponHomeActivityComponent.Builder> couponHomeActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.CouponListFragmentComponent.Builder> couponListFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponPointInputUserInfoActivityComponent.Builder> couponPointInputUserInfoActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponRegisterActivityComponent.Builder> couponRegisterActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponUsageDetailActivityComponent.Builder> couponUsageDetailActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponUseActivityComponent.Builder> couponUseActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.CouponUseConfirmActivityComponent.Builder> couponUseConfirmActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent.Builder> createPostActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.EventShopWebActivityComponent.Builder> eventShopWebActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent.Builder> exchangeApplyActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent.Builder> exchangeApplyCompleteFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent.Builder> exchangeCompleteActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent.Builder> exchangeCompleteFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.FeedbackActivityComponent.Builder> feedbackActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent.Builder> fittieRecommendActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent.Builder> fittieSearchResultFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.FittsCardRendingActivityComponent.Builder> fittsCardRendingActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.services.FittsFirebaseMessasingServiceComponent.Builder> fittsFirebaseMessasingServiceComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.FollowActivityComponent.Builder> followActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent.Builder> followingPostActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent.Builder> homeFeedFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent.Builder> homeFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.IdentificationActivityComponent.Builder> identificationActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent.Builder> identificationAdditionalInfoFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.IdentificationWebViewFragmentComponent.Builder> identificationWebViewFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ImagePreviewActivityComponent.Builder> imagePreviewActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ImageSelectorActivityComponent.Builder> imageSelectorActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent.Builder> intergratedSearchResultFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.IntroActivityComponent.Builder> introActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.IntroLoginFragmentComponent.Builder> introLoginFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.JoinActivityComponent.Builder> joinActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.LikedActivityComponent.Builder> likedActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.LoginActivityComponent.Builder> loginActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.MainActivityComponent.Builder> mainActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.MeFragmentComponent.Builder> meFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.MixedCollectionActivityComponent.Builder> mixedCollectionActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ModifyBodyActivityComponent.Builder> modifyBodyActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ModifyProfileActivityComponent.Builder> modifyProfileActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ModifyShowRoomActivityComponent.Builder> modifyShowRoomActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ModifyUserInfoActivityComponent.Builder> modifyUserInfoActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.MultiImageEventActivityComponent.Builder> multiImageEventActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent.Builder> nCommerceActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.OpenWebActivityComponent.Builder> openWebActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent.Builder> orderActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent.Builder> orderAllCancelFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent.Builder> orderCompleteFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent.Builder> orderCompleteRenderActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent.Builder> orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent.Builder> orderCompleteRenderReservationFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent.Builder> orderDetailActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent.Builder> orderListActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent.Builder> orderPartCancelFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent.Builder> orderPaymentCompleteFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent.Builder> orderPaymentRushFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent.Builder> orderRendingActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent.Builder> orderReservationCancelFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent.Builder> orderReservationCompleteFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent.Builder> orderReservationSoldOutFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent.Builder> orderShippingCompleteFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent.Builder> paymentCancelMisPriceFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent.Builder> paymentCancelSoldOutFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PaymentModuleActivityComponent.Builder> paymentModuleActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PersonalizedRecommendActivityComponent.Builder> personalizedRecommendActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent.Builder> pointHistoryFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent.Builder> pointRevenueDetailFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent.Builder> pointUsageHistoryFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostActivityComponent.Builder> postActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostCollectionActivityComponent.Builder> postCollectionActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostDeleteNotificationDetailActivityComponent.Builder> postDeleteNotificationDetailActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostFirstWriteGuideActivityComponent.Builder> postFirstWriteGuideActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostFirstWriteNoticeActivityComponent.Builder> postFirstWriteNoticeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostImageDetailActivityComponent.Builder> postImageDetailActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostPreviewComponent.Builder> postPreviewComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent.Builder> postSearchResultFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostVerificationFinishNoticeActivityComponent.Builder> postVerificationFinishNoticeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostVerificationRejectNoticeActivityComponent.Builder> postVerificationRejectNoticeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PostingViolationNoticeActivityComponent.Builder> postingViolationNoticeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent.Builder> productBridgeActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent.Builder> productSearchResultFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ProfileInputActivityComponent.Builder> profileInputActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.PromotionCollectionActivityComponent.Builder> promotionCollectionActivityComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<ActionLogAPI> provideActionLogAPIProvider;
    /* access modifiers changed from: private */
    public Provider<ActionLogUtil> provideActionLogUtilProvider;
    /* access modifiers changed from: private */
    public Provider<SearchHistoryRepository> provideAllSearchHistoryRepositoryProvider;
    private AppModule_ProvideApplicationFactory provideApplicationProvider;
    private Provider<HttpUrl> provideBaseUrl$app_productionFittsReleaseProvider;
    private Provider<CartAPI> provideCartAPIProvider;
    /* access modifiers changed from: private */
    public Provider<CartRepository> provideCartRepositoryProvider;
    private Provider<CategoryAPI> provideCategoryAPIProvider;
    /* access modifiers changed from: private */
    public Provider<CategoryRepository> provideCategorySearchRepositoryProvider;
    private Provider<OkHttpClient> provideClient$app_productionFittsReleaseProvider;
    private Provider<okhttp3.OkHttpClient.Builder> provideClientBuilder$app_productionFittsReleaseProvider;
    /* access modifiers changed from: private */
    public Provider<CollectionAPI> provideCollectionAPIProvider;
    private AppModule_ProvideContextFactory provideContextProvider;
    /* access modifiers changed from: private */
    public Provider<CouponAPI> provideCouponAPIProvider;
    /* access modifiers changed from: private */
    public Provider<CreatePostActivityUtil> provideCreatePostActivityUtilProvider;
    /* access modifiers changed from: private */
    public Provider<DataHolderManager> provideDataHoldermanagerProvider;
    /* access modifiers changed from: private */
    public Provider<EventAPI> provideEventAPIProvider;
    /* access modifiers changed from: private */
    public Provider<EventTracker> provideEventTrackerProvider;
    private Provider<ExchangeApi> provideExchangeApiProvider;
    /* access modifiers changed from: private */
    public Provider<ExchangeRepository> provideExchangeRepositoryProvider;
    private Provider<FirebaseAnalytics> provideFirebaseAnalyticsProvider;
    private Provider<FittsCommerceApi> provideFittsCommerceApiProvider;
    /* access modifiers changed from: private */
    public Provider<FittsCommerceRepository> provideFittsCommerceRepositoryProvider;
    private Provider<FittsServiceApi> provideFittsServiceApiProvider;
    /* access modifiers changed from: private */
    public Provider<FittsServiceRepository> provideFittsServiceRepositoryProvider;
    private Provider<FittsSocialApi> provideFittsSocialApiProvider;
    /* access modifiers changed from: private */
    public Provider<FittsSocialRepository> provideFittsSocialRepositoryProvider;
    private Provider<GlobeHttpHandler> provideGlobeHttpHandler$app_productionFittsReleaseProvider;
    /* access modifiers changed from: private */
    public Provider<HomeRepository> provideHomeRepositoryProvider;
    private Provider<Interceptor> provideIntercept$app_productionFittsReleaseProvider;
    /* access modifiers changed from: private */
    public Provider<FittsNotificationHandler> provideNotificationHandlerProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentAPI> providePaymentAPIProvider;
    /* access modifiers changed from: private */
    public Provider<PostAPI> providePostAPIProvider;
    /* access modifiers changed from: private */
    public Provider<PostRepository> providePostRepositoryProvider;
    private Provider<ProductAPI> provideProductAPIProvider;
    /* access modifiers changed from: private */
    public Provider<ProductRepository> provideProductRepositoryProvider;
    private Provider<RefundApi> provideRefundApiProvider;
    /* access modifiers changed from: private */
    public Provider<RefundRepository> provideRefundRepositoryProvider;
    private Provider<Retrofit> provideRetrofit$app_productionFittsReleaseProvider;
    private Provider<retrofit2.Retrofit.Builder> provideRetrofitBuilder$app_productionFittsReleaseProvider;
    /* access modifiers changed from: private */
    public Provider<FittsSchemeHandler> provideSchemeHandlerProvider;
    /* access modifiers changed from: private */
    public Provider<SearchAPI> provideSearchAPIProvider;
    /* access modifiers changed from: private */
    public Provider<SearchRepository> provideSearchRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<SearchHistoryRepository> provideShopSearchHistoryRepositoryProvider;
    private Provider<StoreAPI> provideStoreAPIProvider;
    /* access modifiers changed from: private */
    public Provider<StoreRepository> provideStoreRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<UserAPI> provideUserAPIProvider;
    /* access modifiers changed from: private */
    public Provider<UserRepository> provideUserRepositoryProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent.Builder> refundApplyActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent.Builder> refundApplyCompleteFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent.Builder> refundCompleteActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent.Builder> refundCompleteFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ReportPostComponent.Builder> reportPostComponentBuilderProvider;
    private Provider<RequestIntercept> requestInterceptProvider;
    private Provider<kr.co.popone.fitts.di.component.ResetPasswordActivityComponent.Builder> resetPasswordActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.RewardPointUseActivityComponent.Builder> rewardPointUseActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.RewardPointUseConfirmActivityComponent.Builder> rewardPointUseConfirmActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.RewardUsageDetailActivityComponent.Builder> rewardUsageDetailActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent.Builder> searchActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent.Builder> searchHistoryFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent.Builder> searchHomeFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent.Builder> searchResultFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<SessionManager> sessionManagerProvider;
    private Provider<kr.co.popone.fitts.di.component.SettingActivityComponent.Builder> settingActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent.Builder> shopBookmarkActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent.Builder> shopBridgeActivitySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ShopSearchActivityComponent.Builder> shopSearchActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ShopWebViewActivityComponent.Builder> shopWebViewActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.ShowRoomActivityComponent.Builder> showRoomActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent.Builder> storeBrowserActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent.Builder> storeFeedFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent.Builder> storeFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent.Builder> storeNewFeedFragmentSubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.TagSearchActivityComponent.Builder> tagSearchActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.TermsAgreeActivityComponent.Builder> termsAgreeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent.Builder> trendFeedActivitySubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.UsedCouponHistoryFragmentComponent.Builder> usedCouponHistoryFragmentComponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<kr.co.popone.fitts.di.component.UsedRewardHistoryFragmentComponent.Builder> usedRewardHistoryFragmentComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.UserSizeInputActivityComponent.Builder> userSizeInputActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.WebComponent.Builder> webComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.WelcomeActivityComponent.Builder> welcomeActivityComponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent.Builder> wishListActvititySubcomponentBuilderProvider;
    private Provider<kr.co.popone.fitts.di.component.WithdrawalComponent.Builder> withdrawalComponentBuilderProvider;

    public static final class Builder {
        /* access modifiers changed from: private */
        public AppModule appModule;
        /* access modifiers changed from: private */
        public ClientModule clientModule;
        /* access modifiers changed from: private */
        public GlobeConfigModule globeConfigModule;
        /* access modifiers changed from: private */
        public RepositoryModule repositoryModule;
        /* access modifiers changed from: private */
        public ServiceModule serviceModule;

        private Builder() {
        }

        public AppComponent build() {
            String str = " must be set";
            if (this.appModule != null) {
                if (this.clientModule == null) {
                    this.clientModule = new ClientModule();
                }
                if (this.globeConfigModule != null) {
                    if (this.serviceModule == null) {
                        this.serviceModule = new ServiceModule();
                    }
                    if (this.repositoryModule == null) {
                        this.repositoryModule = new RepositoryModule();
                    }
                    return new DaggerAppComponent(this);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(GlobeConfigModule.class.getCanonicalName());
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AppModule.class.getCanonicalName());
            sb2.append(str);
            throw new IllegalStateException(sb2.toString());
        }

        public Builder appModule(AppModule appModule2) {
            this.appModule = (AppModule) Preconditions.checkNotNull(appModule2);
            return this;
        }

        public Builder clientModule(ClientModule clientModule2) {
            this.clientModule = (ClientModule) Preconditions.checkNotNull(clientModule2);
            return this;
        }

        public Builder serviceModule(ServiceModule serviceModule2) {
            this.serviceModule = (ServiceModule) Preconditions.checkNotNull(serviceModule2);
            return this;
        }

        public Builder globeConfigModule(GlobeConfigModule globeConfigModule2) {
            this.globeConfigModule = (GlobeConfigModule) Preconditions.checkNotNull(globeConfigModule2);
            return this;
        }

        public Builder repositoryModule(RepositoryModule repositoryModule2) {
            this.repositoryModule = (RepositoryModule) Preconditions.checkNotNull(repositoryModule2);
            return this;
        }
    }

    private final class AlarmFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public AlarmModule alarmModule;
        /* access modifiers changed from: private */
        public AlarmFragment seedInstance;

        private AlarmFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent build() {
            if (this.alarmModule == null) {
                this.alarmModule = new AlarmModule();
            }
            if (this.seedInstance != null) {
                return new AlarmFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AlarmFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AlarmFragment alarmFragment) {
            this.seedInstance = (AlarmFragment) Preconditions.checkNotNull(alarmFragment);
        }
    }

    private final class AlarmFragmentSubcomponentImpl implements ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent {
        private AlarmModule alarmModule;
        private AlarmFragment seedInstance;

        private AlarmFragmentSubcomponentImpl(AlarmFragmentSubcomponentBuilder alarmFragmentSubcomponentBuilder) {
            initialize(alarmFragmentSubcomponentBuilder);
        }

        private AlarmViewModelFactory getAlarmViewModelFactory() {
            return AlarmModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.alarmModule, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
        }

        private AlarmViewModel getAlarmViewModel() {
            return AlarmModule_ProvideAlarmViewModelFactory.proxyProvideAlarmViewModel(this.alarmModule, this.seedInstance, getAlarmViewModelFactory());
        }

        private void initialize(AlarmFragmentSubcomponentBuilder alarmFragmentSubcomponentBuilder) {
            this.alarmModule = alarmFragmentSubcomponentBuilder.alarmModule;
            this.seedInstance = alarmFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(AlarmFragment alarmFragment) {
            injectAlarmFragment(alarmFragment);
        }

        private AlarmFragment injectAlarmFragment(AlarmFragment alarmFragment) {
            AlarmFragment_MembersInjector.injectVm(alarmFragment, getAlarmViewModel());
            return alarmFragment;
        }
    }

    private final class AlarmSettingActivityComponentBuilder extends kr.co.popone.fitts.di.component.AlarmSettingActivityComponent.Builder {
        private AlarmSettingActivity seedInstance;

        private AlarmSettingActivityComponentBuilder() {
        }

        public AlarmSettingActivityComponent build() {
            if (this.seedInstance != null) {
                return new AlarmSettingActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AlarmSettingActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AlarmSettingActivity alarmSettingActivity) {
            this.seedInstance = (AlarmSettingActivity) Preconditions.checkNotNull(alarmSettingActivity);
        }
    }

    private final class AlarmSettingActivityComponentImpl implements AlarmSettingActivityComponent {
        private AlarmSettingActivityComponentImpl(AlarmSettingActivityComponentBuilder alarmSettingActivityComponentBuilder) {
        }

        public void inject(AlarmSettingActivity alarmSettingActivity) {
            injectAlarmSettingActivity(alarmSettingActivity);
        }

        private AlarmSettingActivity injectAlarmSettingActivity(AlarmSettingActivity alarmSettingActivity) {
            AlarmSettingActivity_MembersInjector.injectUserAPI(alarmSettingActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return alarmSettingActivity;
        }
    }

    private final class AppliableCollaborativeEventActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableCollaborativeEventActivityComponent.Builder {
        private AppliableCollaborativeEventActivity seedInstance;

        private AppliableCollaborativeEventActivityComponentBuilder() {
        }

        public AppliableCollaborativeEventActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableCollaborativeEventActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableCollaborativeEventActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
            this.seedInstance = (AppliableCollaborativeEventActivity) Preconditions.checkNotNull(appliableCollaborativeEventActivity);
        }
    }

    private final class AppliableCollaborativeEventActivityComponentImpl implements AppliableCollaborativeEventActivityComponent {
        private AppliableCollaborativeEventActivityComponentImpl(AppliableCollaborativeEventActivityComponentBuilder appliableCollaborativeEventActivityComponentBuilder) {
        }

        public void inject(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
            injectAppliableCollaborativeEventActivity(appliableCollaborativeEventActivity);
        }

        private AppliableCollaborativeEventActivity injectAppliableCollaborativeEventActivity(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
            AppliableCollaborativeEventActivity_MembersInjector.injectEventAPI(appliableCollaborativeEventActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            AppliableCollaborativeEventActivity_MembersInjector.injectEventTracker(appliableCollaborativeEventActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return appliableCollaborativeEventActivity;
        }
    }

    private final class AppliableCollaborativeEventApplyActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableCollaborativeEventApplyActivityComponent.Builder {
        private AppliableCollaborativeEventApplyActivity seedInstance;

        private AppliableCollaborativeEventApplyActivityComponentBuilder() {
        }

        public AppliableCollaborativeEventApplyActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableCollaborativeEventApplyActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableCollaborativeEventApplyActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
            this.seedInstance = (AppliableCollaborativeEventApplyActivity) Preconditions.checkNotNull(appliableCollaborativeEventApplyActivity);
        }
    }

    private final class AppliableCollaborativeEventApplyActivityComponentImpl implements AppliableCollaborativeEventApplyActivityComponent {
        private AppliableCollaborativeEventApplyActivityComponentImpl(AppliableCollaborativeEventApplyActivityComponentBuilder appliableCollaborativeEventApplyActivityComponentBuilder) {
        }

        public void inject(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
            injectAppliableCollaborativeEventApplyActivity(appliableCollaborativeEventApplyActivity);
        }

        private AppliableCollaborativeEventApplyActivity injectAppliableCollaborativeEventApplyActivity(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
            AppliableCollaborativeEventApplyActivity_MembersInjector.injectEventAPI(appliableCollaborativeEventApplyActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            return appliableCollaborativeEventApplyActivity;
        }
    }

    private final class AppliableEventActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableEventActivityComponent.Builder {
        private AppliableEventActivity seedInstance;

        private AppliableEventActivityComponentBuilder() {
        }

        public AppliableEventActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableEventActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableEventActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableEventActivity appliableEventActivity) {
            this.seedInstance = (AppliableEventActivity) Preconditions.checkNotNull(appliableEventActivity);
        }
    }

    private final class AppliableEventActivityComponentImpl implements AppliableEventActivityComponent {
        private AppliableEventActivityComponentImpl(AppliableEventActivityComponentBuilder appliableEventActivityComponentBuilder) {
        }

        public void inject(AppliableEventActivity appliableEventActivity) {
            injectAppliableEventActivity(appliableEventActivity);
        }

        private AppliableEventActivity injectAppliableEventActivity(AppliableEventActivity appliableEventActivity) {
            AppliableEventActivity_MembersInjector.injectEventAPI(appliableEventActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            AppliableEventActivity_MembersInjector.injectEventTracker(appliableEventActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return appliableEventActivity;
        }
    }

    private final class AppliableEventApplyActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableEventApplyActivityComponent.Builder {
        private AppliableEventApplyActivity seedInstance;

        private AppliableEventApplyActivityComponentBuilder() {
        }

        public AppliableEventApplyActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableEventApplyActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableEventApplyActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableEventApplyActivity appliableEventApplyActivity) {
            this.seedInstance = (AppliableEventApplyActivity) Preconditions.checkNotNull(appliableEventApplyActivity);
        }
    }

    private final class AppliableEventApplyActivityComponentImpl implements AppliableEventApplyActivityComponent {
        private AppliableEventApplyActivityComponentImpl(AppliableEventApplyActivityComponentBuilder appliableEventApplyActivityComponentBuilder) {
        }

        public void inject(AppliableEventApplyActivity appliableEventApplyActivity) {
            injectAppliableEventApplyActivity(appliableEventApplyActivity);
        }

        private AppliableEventApplyActivity injectAppliableEventApplyActivity(AppliableEventApplyActivity appliableEventApplyActivity) {
            AppliableEventApplyActivity_MembersInjector.injectEventAPI(appliableEventApplyActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            AppliableEventApplyActivity_MembersInjector.injectPostAPI(appliableEventApplyActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return appliableEventApplyActivity;
        }
    }

    private final class AppliableEventResultActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableEventResultActivityComponent.Builder {
        private AppliableEventResultActivity seedInstance;

        private AppliableEventResultActivityComponentBuilder() {
        }

        public AppliableEventResultActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableEventResultActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableEventResultActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableEventResultActivity appliableEventResultActivity) {
            this.seedInstance = (AppliableEventResultActivity) Preconditions.checkNotNull(appliableEventResultActivity);
        }
    }

    private final class AppliableEventResultActivityComponentImpl implements AppliableEventResultActivityComponent {
        private AppliableEventResultActivityComponentImpl(AppliableEventResultActivityComponentBuilder appliableEventResultActivityComponentBuilder) {
        }

        public void inject(AppliableEventResultActivity appliableEventResultActivity) {
            injectAppliableEventResultActivity(appliableEventResultActivity);
        }

        private AppliableEventResultActivity injectAppliableEventResultActivity(AppliableEventResultActivity appliableEventResultActivity) {
            AppliableEventResultActivity_MembersInjector.injectEventAPI(appliableEventResultActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            return appliableEventResultActivity;
        }
    }

    private final class AppliableEventWinnerInputActivityComponentBuilder extends kr.co.popone.fitts.di.component.AppliableEventWinnerInputActivityComponent.Builder {
        private AppliableEventWinnerInputActivity seedInstance;

        private AppliableEventWinnerInputActivityComponentBuilder() {
        }

        public AppliableEventWinnerInputActivityComponent build() {
            if (this.seedInstance != null) {
                return new AppliableEventWinnerInputActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(AppliableEventWinnerInputActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
            this.seedInstance = (AppliableEventWinnerInputActivity) Preconditions.checkNotNull(appliableEventWinnerInputActivity);
        }
    }

    private final class AppliableEventWinnerInputActivityComponentImpl implements AppliableEventWinnerInputActivityComponent {
        private AppliableEventWinnerInputActivityComponentImpl(AppliableEventWinnerInputActivityComponentBuilder appliableEventWinnerInputActivityComponentBuilder) {
        }

        public void inject(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
            injectAppliableEventWinnerInputActivity(appliableEventWinnerInputActivity);
        }

        private AppliableEventWinnerInputActivity injectAppliableEventWinnerInputActivity(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
            AppliableEventWinnerInputActivity_MembersInjector.injectEventAPI(appliableEventWinnerInputActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            AppliableEventWinnerInputActivity_MembersInjector.injectUserAPI(appliableEventWinnerInputActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return appliableEventWinnerInputActivity;
        }
    }

    private final class BannerActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public BannerModule bannerModule;
        /* access modifiers changed from: private */
        public BannerActivity seedInstance;

        private BannerActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent build() {
            if (this.bannerModule == null) {
                this.bannerModule = new BannerModule();
            }
            if (this.seedInstance != null) {
                return new BannerActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(BannerActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(BannerActivity bannerActivity) {
            this.seedInstance = (BannerActivity) Preconditions.checkNotNull(bannerActivity);
        }
    }

    private final class BannerActivitySubcomponentImpl implements ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent {
        private BannerModule bannerModule;
        private BannerActivity seedInstance;

        private BannerActivitySubcomponentImpl(BannerActivitySubcomponentBuilder bannerActivitySubcomponentBuilder) {
            initialize(bannerActivitySubcomponentBuilder);
        }

        private BannerViewModelFactory getBannerViewModelFactory() {
            return BannerModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.bannerModule, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private BannerViewModel getBannerViewModel() {
            return BannerModule_ProvideCartViewModelFactory.proxyProvideCartViewModel(this.bannerModule, this.seedInstance, getBannerViewModelFactory());
        }

        private void initialize(BannerActivitySubcomponentBuilder bannerActivitySubcomponentBuilder) {
            this.bannerModule = bannerActivitySubcomponentBuilder.bannerModule;
            this.seedInstance = bannerActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(BannerActivity bannerActivity) {
            injectBannerActivity(bannerActivity);
        }

        private BannerActivity injectBannerActivity(BannerActivity bannerActivity) {
            BannerActivity_MembersInjector.injectViewModel(bannerActivity, getBannerViewModel());
            return bannerActivity;
        }
    }

    private final class CartActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateCartActivity$CartActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public CartModule cartModule;
        /* access modifiers changed from: private */
        public CartActivity seedInstance;

        private CartActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateCartActivity$CartActivitySubcomponent build() {
            if (this.cartModule == null) {
                this.cartModule = new CartModule();
            }
            if (this.seedInstance != null) {
                return new CartActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CartActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CartActivity cartActivity) {
            this.seedInstance = (CartActivity) Preconditions.checkNotNull(cartActivity);
        }
    }

    private final class CartActivitySubcomponentImpl implements ViewModelModule_CreateCartActivity$CartActivitySubcomponent {
        private CartModule cartModule;
        private CartActivity seedInstance;

        private CartActivitySubcomponentImpl(CartActivitySubcomponentBuilder cartActivitySubcomponentBuilder) {
            initialize(cartActivitySubcomponentBuilder);
        }

        private CartViewModelFactory getCartViewModelFactory() {
            return CartModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.cartModule, (CartRepository) DaggerAppComponent.this.provideCartRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private CartViewModel getCartViewModel() {
            return CartModule_ProvideCartViewModelFactory.proxyProvideCartViewModel(this.cartModule, this.seedInstance, getCartViewModelFactory());
        }

        private void initialize(CartActivitySubcomponentBuilder cartActivitySubcomponentBuilder) {
            this.cartModule = cartActivitySubcomponentBuilder.cartModule;
            this.seedInstance = cartActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(CartActivity cartActivity) {
            injectCartActivity(cartActivity);
        }

        private CartActivity injectCartActivity(CartActivity cartActivity) {
            CartActivity_MembersInjector.injectViewModel(cartActivity, getCartViewModel());
            return cartActivity;
        }
    }

    private final class CategorySearchActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public CategorySearchModule categorySearchModule;
        /* access modifiers changed from: private */
        public CategorySearchActivity seedInstance;

        private CategorySearchActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent build() {
            if (this.categorySearchModule == null) {
                this.categorySearchModule = new CategorySearchModule();
            }
            if (this.seedInstance != null) {
                return new CategorySearchActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CategorySearchActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CategorySearchActivity categorySearchActivity) {
            this.seedInstance = (CategorySearchActivity) Preconditions.checkNotNull(categorySearchActivity);
        }
    }

    private final class CategorySearchActivitySubcomponentImpl implements ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent {
        private CategorySearchModule categorySearchModule;
        private CategorySearchActivity seedInstance;

        private CategorySearchActivitySubcomponentImpl(CategorySearchActivitySubcomponentBuilder categorySearchActivitySubcomponentBuilder) {
            initialize(categorySearchActivitySubcomponentBuilder);
        }

        private CategorySearchViewModelFactory getCategorySearchViewModelFactory() {
            return CategorySearchModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.categorySearchModule, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private CategorySearchViewModel getCategorySearchViewModel() {
            return CategorySearchModule_ProvideCategorySearchActivityViewModelFactory.proxyProvideCategorySearchActivityViewModel(this.categorySearchModule, this.seedInstance, getCategorySearchViewModelFactory());
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private void initialize(CategorySearchActivitySubcomponentBuilder categorySearchActivitySubcomponentBuilder) {
            this.categorySearchModule = categorySearchActivitySubcomponentBuilder.categorySearchModule;
            this.seedInstance = categorySearchActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(CategorySearchActivity categorySearchActivity) {
            injectCategorySearchActivity(categorySearchActivity);
        }

        private CategorySearchActivity injectCategorySearchActivity(CategorySearchActivity categorySearchActivity) {
            CategorySearchActivity_MembersInjector.injectViewModel(categorySearchActivity, getCategorySearchViewModel());
            CategorySearchActivity_MembersInjector.injectDispatchingAndroidInjector(categorySearchActivity, getDispatchingAndroidInjectorOfFragment());
            return categorySearchActivity;
        }
    }

    private final class CategorySearchFragmentComponentBuilder extends kr.co.popone.fitts.di.component.CategorySearchFragmentComponent.Builder {
        private CategorySearchFragment seedInstance;

        private CategorySearchFragmentComponentBuilder() {
        }

        public CategorySearchFragmentComponent build() {
            if (this.seedInstance != null) {
                return new CategorySearchFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CategorySearchFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CategorySearchFragment categorySearchFragment) {
            this.seedInstance = (CategorySearchFragment) Preconditions.checkNotNull(categorySearchFragment);
        }
    }

    private final class CategorySearchFragmentComponentImpl implements CategorySearchFragmentComponent {
        private CategorySearchFragmentComponentImpl(CategorySearchFragmentComponentBuilder categorySearchFragmentComponentBuilder) {
        }

        public void inject(CategorySearchFragment categorySearchFragment) {
            injectCategorySearchFragment(categorySearchFragment);
        }

        private CategorySearchFragment injectCategorySearchFragment(CategorySearchFragment categorySearchFragment) {
            CategorySearchFragment_MembersInjector.injectCategoryRepository(categorySearchFragment, (CategoryRepository) DaggerAppComponent.this.provideCategorySearchRepositoryProvider.get());
            CategorySearchFragment_MembersInjector.injectEventTracker(categorySearchFragment, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            CategorySearchFragment_MembersInjector.injectActionLogAPI(categorySearchFragment, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            return categorySearchFragment;
        }
    }

    private final class CommentsActivityComponentBuilder extends kr.co.popone.fitts.di.component.CommentsActivityComponent.Builder {
        private CommentsActivity seedInstance;

        private CommentsActivityComponentBuilder() {
        }

        public CommentsActivityComponent build() {
            if (this.seedInstance != null) {
                return new CommentsActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CommentsActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CommentsActivity commentsActivity) {
            this.seedInstance = (CommentsActivity) Preconditions.checkNotNull(commentsActivity);
        }
    }

    private final class CommentsActivityComponentImpl implements CommentsActivityComponent {
        private CommentsActivityComponentImpl(CommentsActivityComponentBuilder commentsActivityComponentBuilder) {
        }

        public void inject(CommentsActivity commentsActivity) {
            injectCommentsActivity(commentsActivity);
        }

        private CommentsActivity injectCommentsActivity(CommentsActivity commentsActivity) {
            CommentsActivity_MembersInjector.injectEventTracker(commentsActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            CommentsActivity_MembersInjector.injectSessionManager(commentsActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            CommentsActivity_MembersInjector.injectPostAPI(commentsActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return commentsActivity;
        }
    }

    private final class CouponHomeActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponHomeActivityComponent.Builder {
        private CouponHomeActivity seedInstance;

        private CouponHomeActivityComponentBuilder() {
        }

        public CouponHomeActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponHomeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponHomeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponHomeActivity couponHomeActivity) {
            this.seedInstance = (CouponHomeActivity) Preconditions.checkNotNull(couponHomeActivity);
        }
    }

    private final class CouponHomeActivityComponentImpl implements CouponHomeActivityComponent {
        private CouponHomeActivityComponentImpl(CouponHomeActivityComponentBuilder couponHomeActivityComponentBuilder) {
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        public void inject(CouponHomeActivity couponHomeActivity) {
            injectCouponHomeActivity(couponHomeActivity);
        }

        private CouponHomeActivity injectCouponHomeActivity(CouponHomeActivity couponHomeActivity) {
            CouponHomeActivity_MembersInjector.injectFragmentInjector(couponHomeActivity, getDispatchingAndroidInjectorOfFragment());
            CouponHomeActivity_MembersInjector.injectSessionManager(couponHomeActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            CouponHomeActivity_MembersInjector.injectUserAPI(couponHomeActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return couponHomeActivity;
        }
    }

    private final class CouponListFragmentComponentBuilder extends kr.co.popone.fitts.di.component.CouponListFragmentComponent.Builder {
        private CouponListFragment seedInstance;

        private CouponListFragmentComponentBuilder() {
        }

        public CouponListFragmentComponent build() {
            if (this.seedInstance != null) {
                return new CouponListFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponListFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponListFragment couponListFragment) {
            this.seedInstance = (CouponListFragment) Preconditions.checkNotNull(couponListFragment);
        }
    }

    private final class CouponListFragmentComponentImpl implements CouponListFragmentComponent {
        private CouponListFragmentComponentImpl(CouponListFragmentComponentBuilder couponListFragmentComponentBuilder) {
        }

        public void inject(CouponListFragment couponListFragment) {
            injectCouponListFragment(couponListFragment);
        }

        private CouponListFragment injectCouponListFragment(CouponListFragment couponListFragment) {
            CouponListFragment_MembersInjector.injectCouponAPI(couponListFragment, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            CouponListFragment_MembersInjector.injectSessionManager(couponListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return couponListFragment;
        }
    }

    private final class CouponPointInputUserInfoActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponPointInputUserInfoActivityComponent.Builder {
        private CouponPointInputUserInfoActivity seedInstance;

        private CouponPointInputUserInfoActivityComponentBuilder() {
        }

        public CouponPointInputUserInfoActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponPointInputUserInfoActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponPointInputUserInfoActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
            this.seedInstance = (CouponPointInputUserInfoActivity) Preconditions.checkNotNull(couponPointInputUserInfoActivity);
        }
    }

    private final class CouponPointInputUserInfoActivityComponentImpl implements CouponPointInputUserInfoActivityComponent {
        private CouponPointInputUserInfoActivityComponentImpl(CouponPointInputUserInfoActivityComponentBuilder couponPointInputUserInfoActivityComponentBuilder) {
        }

        public void inject(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
            injectCouponPointInputUserInfoActivity(couponPointInputUserInfoActivity);
        }

        private CouponPointInputUserInfoActivity injectCouponPointInputUserInfoActivity(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
            CouponPointInputUserInfoActivity_MembersInjector.injectSessionManager(couponPointInputUserInfoActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            CouponPointInputUserInfoActivity_MembersInjector.injectUserAPI(couponPointInputUserInfoActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return couponPointInputUserInfoActivity;
        }
    }

    private final class CouponRegisterActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponRegisterActivityComponent.Builder {
        private CouponRegisterActivity seedInstance;

        private CouponRegisterActivityComponentBuilder() {
        }

        public CouponRegisterActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponRegisterActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponRegisterActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponRegisterActivity couponRegisterActivity) {
            this.seedInstance = (CouponRegisterActivity) Preconditions.checkNotNull(couponRegisterActivity);
        }
    }

    private final class CouponRegisterActivityComponentImpl implements CouponRegisterActivityComponent {
        private CouponRegisterActivityComponentImpl(CouponRegisterActivityComponentBuilder couponRegisterActivityComponentBuilder) {
        }

        public void inject(CouponRegisterActivity couponRegisterActivity) {
            injectCouponRegisterActivity(couponRegisterActivity);
        }

        private CouponRegisterActivity injectCouponRegisterActivity(CouponRegisterActivity couponRegisterActivity) {
            CouponRegisterActivity_MembersInjector.injectCouponAPI(couponRegisterActivity, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            return couponRegisterActivity;
        }
    }

    private final class CouponUsageDetailActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponUsageDetailActivityComponent.Builder {
        private CouponUsageDetailActivity seedInstance;

        private CouponUsageDetailActivityComponentBuilder() {
        }

        public CouponUsageDetailActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponUsageDetailActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponUsageDetailActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponUsageDetailActivity couponUsageDetailActivity) {
            this.seedInstance = (CouponUsageDetailActivity) Preconditions.checkNotNull(couponUsageDetailActivity);
        }
    }

    private final class CouponUsageDetailActivityComponentImpl implements CouponUsageDetailActivityComponent {
        private CouponUsageDetailActivityComponentImpl(CouponUsageDetailActivityComponentBuilder couponUsageDetailActivityComponentBuilder) {
        }

        public void inject(CouponUsageDetailActivity couponUsageDetailActivity) {
            injectCouponUsageDetailActivity(couponUsageDetailActivity);
        }

        private CouponUsageDetailActivity injectCouponUsageDetailActivity(CouponUsageDetailActivity couponUsageDetailActivity) {
            CouponUsageDetailActivity_MembersInjector.injectCouponAPI(couponUsageDetailActivity, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            CouponUsageDetailActivity_MembersInjector.injectPaymentAPI(couponUsageDetailActivity, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return couponUsageDetailActivity;
        }
    }

    private final class CouponUseActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponUseActivityComponent.Builder {
        private CouponUseActivity seedInstance;

        private CouponUseActivityComponentBuilder() {
        }

        public CouponUseActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponUseActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponUseActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponUseActivity couponUseActivity) {
            this.seedInstance = (CouponUseActivity) Preconditions.checkNotNull(couponUseActivity);
        }
    }

    private final class CouponUseActivityComponentImpl implements CouponUseActivityComponent {
        private CouponUseActivityComponentImpl(CouponUseActivityComponentBuilder couponUseActivityComponentBuilder) {
        }

        public void inject(CouponUseActivity couponUseActivity) {
            injectCouponUseActivity(couponUseActivity);
        }

        private CouponUseActivity injectCouponUseActivity(CouponUseActivity couponUseActivity) {
            CouponUseActivity_MembersInjector.injectUserAPI(couponUseActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            CouponUseActivity_MembersInjector.injectPostAPI(couponUseActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return couponUseActivity;
        }
    }

    private final class CouponUseConfirmActivityComponentBuilder extends kr.co.popone.fitts.di.component.CouponUseConfirmActivityComponent.Builder {
        private CouponUseConfirmActivity seedInstance;

        private CouponUseConfirmActivityComponentBuilder() {
        }

        public CouponUseConfirmActivityComponent build() {
            if (this.seedInstance != null) {
                return new CouponUseConfirmActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CouponUseConfirmActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CouponUseConfirmActivity couponUseConfirmActivity) {
            this.seedInstance = (CouponUseConfirmActivity) Preconditions.checkNotNull(couponUseConfirmActivity);
        }
    }

    private final class CouponUseConfirmActivityComponentImpl implements CouponUseConfirmActivityComponent {
        private CouponUseConfirmActivityComponentImpl(CouponUseConfirmActivityComponentBuilder couponUseConfirmActivityComponentBuilder) {
        }

        public void inject(CouponUseConfirmActivity couponUseConfirmActivity) {
            injectCouponUseConfirmActivity(couponUseConfirmActivity);
        }

        private CouponUseConfirmActivity injectCouponUseConfirmActivity(CouponUseConfirmActivity couponUseConfirmActivity) {
            CouponUseConfirmActivity_MembersInjector.injectPaymentAPI(couponUseConfirmActivity, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return couponUseConfirmActivity;
        }
    }

    private final class CreatePostActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public CreatePostModule createPostModule;
        private CreatePostActivity seedInstance;

        private CreatePostActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent build() {
            if (this.createPostModule == null) {
                this.createPostModule = new CreatePostModule();
            }
            if (this.seedInstance != null) {
                return new CreatePostActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CreatePostActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(CreatePostActivity createPostActivity) {
            this.seedInstance = (CreatePostActivity) Preconditions.checkNotNull(createPostActivity);
        }
    }

    private final class CreatePostActivitySubcomponentImpl implements ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent {
        private CreatePostModule createPostModule;

        private CreatePostActivitySubcomponentImpl(CreatePostActivitySubcomponentBuilder createPostActivitySubcomponentBuilder) {
            initialize(createPostActivitySubcomponentBuilder);
        }

        private CreatePostViewModel getCreatePostViewModel() {
            return CreatePostModule_ProvideCreatePostViewModelFactory.proxyProvideCreatePostViewModel(this.createPostModule, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
        }

        private void initialize(CreatePostActivitySubcomponentBuilder createPostActivitySubcomponentBuilder) {
            this.createPostModule = createPostActivitySubcomponentBuilder.createPostModule;
        }

        public void inject(CreatePostActivity createPostActivity) {
            injectCreatePostActivity(createPostActivity);
        }

        private CreatePostActivity injectCreatePostActivity(CreatePostActivity createPostActivity) {
            CreatePostActivity_MembersInjector.injectViewModel(createPostActivity, getCreatePostViewModel());
            return createPostActivity;
        }
    }

    private final class EventShopWebActivityComponentBuilder extends kr.co.popone.fitts.di.component.EventShopWebActivityComponent.Builder {
        private EventShopWebActivity seedInstance;

        private EventShopWebActivityComponentBuilder() {
        }

        public EventShopWebActivityComponent build() {
            if (this.seedInstance != null) {
                return new EventShopWebActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(EventShopWebActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(EventShopWebActivity eventShopWebActivity) {
            this.seedInstance = (EventShopWebActivity) Preconditions.checkNotNull(eventShopWebActivity);
        }
    }

    private final class EventShopWebActivityComponentImpl implements EventShopWebActivityComponent {
        private EventShopWebActivityComponentImpl(EventShopWebActivityComponentBuilder eventShopWebActivityComponentBuilder) {
        }

        public void inject(EventShopWebActivity eventShopWebActivity) {
            injectEventShopWebActivity(eventShopWebActivity);
        }

        private EventShopWebActivity injectEventShopWebActivity(EventShopWebActivity eventShopWebActivity) {
            EventShopWebActivity_MembersInjector.injectEventAPI(eventShopWebActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            EventShopWebActivity_MembersInjector.injectUserAPI(eventShopWebActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return eventShopWebActivity;
        }
    }

    private final class ExchangeApplyActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public ExchangeModule exchangeModule;
        /* access modifiers changed from: private */
        public ExchangeApplyActivity seedInstance;

        private ExchangeApplyActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent build() {
            if (this.exchangeModule == null) {
                this.exchangeModule = new ExchangeModule();
            }
            if (this.seedInstance != null) {
                return new ExchangeApplyActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ExchangeApplyActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ExchangeApplyActivity exchangeApplyActivity) {
            this.seedInstance = (ExchangeApplyActivity) Preconditions.checkNotNull(exchangeApplyActivity);
        }
    }

    private final class ExchangeApplyActivitySubcomponentImpl implements ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent {
        private ExchangeModule exchangeModule;
        private ExchangeApplyActivity seedInstance;

        private ExchangeApplyActivitySubcomponentImpl(ExchangeApplyActivitySubcomponentBuilder exchangeApplyActivitySubcomponentBuilder) {
            initialize(exchangeApplyActivitySubcomponentBuilder);
        }

        private ExchangeViewModelFactory getExchangeViewModelFactory() {
            return ExchangeModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.exchangeModule, (ExchangeRepository) DaggerAppComponent.this.provideExchangeRepositoryProvider.get());
        }

        private ExchangeViewModel getExchangeViewModel() {
            return ExchangeModule_ProvideRefundViewModelFactory.proxyProvideRefundViewModel(this.exchangeModule, this.seedInstance, getExchangeViewModelFactory());
        }

        private void initialize(ExchangeApplyActivitySubcomponentBuilder exchangeApplyActivitySubcomponentBuilder) {
            this.exchangeModule = exchangeApplyActivitySubcomponentBuilder.exchangeModule;
            this.seedInstance = exchangeApplyActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(ExchangeApplyActivity exchangeApplyActivity) {
            injectExchangeApplyActivity(exchangeApplyActivity);
        }

        private ExchangeApplyActivity injectExchangeApplyActivity(ExchangeApplyActivity exchangeApplyActivity) {
            ExchangeApplyActivity_MembersInjector.injectViewModel(exchangeApplyActivity, getExchangeViewModel());
            return exchangeApplyActivity;
        }
    }

    private final class ExchangeApplyCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public ExchangeCompleteActivityModule exchangeCompleteActivityModule;
        /* access modifiers changed from: private */
        public ExchangeApplyCompleteFragment seedInstance;

        private ExchangeApplyCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent build() {
            if (this.exchangeCompleteActivityModule == null) {
                this.exchangeCompleteActivityModule = new ExchangeCompleteActivityModule();
            }
            if (this.seedInstance != null) {
                return new ExchangeApplyCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ExchangeApplyCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
            this.seedInstance = (ExchangeApplyCompleteFragment) Preconditions.checkNotNull(exchangeApplyCompleteFragment);
        }
    }

    private final class ExchangeApplyCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent {
        private ExchangeCompleteActivityModule exchangeCompleteActivityModule;
        private ExchangeApplyCompleteFragment seedInstance;

        private ExchangeApplyCompleteFragmentSubcomponentImpl(ExchangeApplyCompleteFragmentSubcomponentBuilder exchangeApplyCompleteFragmentSubcomponentBuilder) {
            initialize(exchangeApplyCompleteFragmentSubcomponentBuilder);
        }

        private ExchangeDetailViewModelFactory getExchangeDetailViewModelFactory() {
            return ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.exchangeCompleteActivityModule, (ExchangeRepository) DaggerAppComponent.this.provideExchangeRepositoryProvider.get());
        }

        private ExchangeDetailViewModel getExchangeDetailViewModel() {
            return ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.exchangeCompleteActivityModule, this.seedInstance, getExchangeDetailViewModelFactory());
        }

        private void initialize(ExchangeApplyCompleteFragmentSubcomponentBuilder exchangeApplyCompleteFragmentSubcomponentBuilder) {
            this.exchangeCompleteActivityModule = exchangeApplyCompleteFragmentSubcomponentBuilder.exchangeCompleteActivityModule;
            this.seedInstance = exchangeApplyCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
            injectExchangeApplyCompleteFragment(exchangeApplyCompleteFragment);
        }

        private ExchangeApplyCompleteFragment injectExchangeApplyCompleteFragment(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
            ExchangeApplyCompleteFragment_MembersInjector.injectViewModel(exchangeApplyCompleteFragment, getExchangeDetailViewModel());
            return exchangeApplyCompleteFragment;
        }
    }

    private final class ExchangeCompleteActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule;
        /* access modifiers changed from: private */
        public ExchangeCompleteActivity seedInstance;

        private ExchangeCompleteActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent build() {
            if (this.exchangeApplyCompleteFragmentModule == null) {
                this.exchangeApplyCompleteFragmentModule = new ExchangeApplyCompleteFragmentModule();
            }
            if (this.seedInstance != null) {
                return new ExchangeCompleteActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ExchangeCompleteActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ExchangeCompleteActivity exchangeCompleteActivity) {
            this.seedInstance = (ExchangeCompleteActivity) Preconditions.checkNotNull(exchangeCompleteActivity);
        }
    }

    private final class ExchangeCompleteActivitySubcomponentImpl implements ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent {
        private ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule;
        private ExchangeCompleteActivity seedInstance;

        private ExchangeCompleteActivitySubcomponentImpl(ExchangeCompleteActivitySubcomponentBuilder exchangeCompleteActivitySubcomponentBuilder) {
            initialize(exchangeCompleteActivitySubcomponentBuilder);
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private ExchangeDetailViewModelFactory getExchangeDetailViewModelFactory() {
            return ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.exchangeApplyCompleteFragmentModule, (ExchangeRepository) DaggerAppComponent.this.provideExchangeRepositoryProvider.get());
        }

        private ExchangeDetailViewModel getExchangeDetailViewModel() {
            return ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.exchangeApplyCompleteFragmentModule, this.seedInstance, getExchangeDetailViewModelFactory());
        }

        private void initialize(ExchangeCompleteActivitySubcomponentBuilder exchangeCompleteActivitySubcomponentBuilder) {
            this.exchangeApplyCompleteFragmentModule = exchangeCompleteActivitySubcomponentBuilder.exchangeApplyCompleteFragmentModule;
            this.seedInstance = exchangeCompleteActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(ExchangeCompleteActivity exchangeCompleteActivity) {
            injectExchangeCompleteActivity(exchangeCompleteActivity);
        }

        private ExchangeCompleteActivity injectExchangeCompleteActivity(ExchangeCompleteActivity exchangeCompleteActivity) {
            ExchangeCompleteActivity_MembersInjector.injectFragmentInjector(exchangeCompleteActivity, getDispatchingAndroidInjectorOfFragment());
            ExchangeCompleteActivity_MembersInjector.injectViewModel(exchangeCompleteActivity, getExchangeDetailViewModel());
            return exchangeCompleteActivity;
        }
    }

    private final class ExchangeCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public ExchangeCompleteFragmentModule exchangeCompleteFragmentModule;
        /* access modifiers changed from: private */
        public ExchangeCompleteFragment seedInstance;

        private ExchangeCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent build() {
            if (this.exchangeCompleteFragmentModule == null) {
                this.exchangeCompleteFragmentModule = new ExchangeCompleteFragmentModule();
            }
            if (this.seedInstance != null) {
                return new ExchangeCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ExchangeCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ExchangeCompleteFragment exchangeCompleteFragment) {
            this.seedInstance = (ExchangeCompleteFragment) Preconditions.checkNotNull(exchangeCompleteFragment);
        }
    }

    private final class ExchangeCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent {
        private ExchangeCompleteFragmentModule exchangeCompleteFragmentModule;
        private ExchangeCompleteFragment seedInstance;

        private ExchangeCompleteFragmentSubcomponentImpl(ExchangeCompleteFragmentSubcomponentBuilder exchangeCompleteFragmentSubcomponentBuilder) {
            initialize(exchangeCompleteFragmentSubcomponentBuilder);
        }

        private ExchangeDetailViewModelFactory getExchangeDetailViewModelFactory() {
            return ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.exchangeCompleteFragmentModule, (ExchangeRepository) DaggerAppComponent.this.provideExchangeRepositoryProvider.get());
        }

        private ExchangeDetailViewModel getExchangeDetailViewModel() {
            return ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.exchangeCompleteFragmentModule, this.seedInstance, getExchangeDetailViewModelFactory());
        }

        private void initialize(ExchangeCompleteFragmentSubcomponentBuilder exchangeCompleteFragmentSubcomponentBuilder) {
            this.exchangeCompleteFragmentModule = exchangeCompleteFragmentSubcomponentBuilder.exchangeCompleteFragmentModule;
            this.seedInstance = exchangeCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(ExchangeCompleteFragment exchangeCompleteFragment) {
            injectExchangeCompleteFragment(exchangeCompleteFragment);
        }

        private ExchangeCompleteFragment injectExchangeCompleteFragment(ExchangeCompleteFragment exchangeCompleteFragment) {
            ExchangeCompleteFragment_MembersInjector.injectViewModel(exchangeCompleteFragment, getExchangeDetailViewModel());
            return exchangeCompleteFragment;
        }
    }

    private final class FeedbackActivityComponentBuilder extends kr.co.popone.fitts.di.component.FeedbackActivityComponent.Builder {
        private FeedbackActivity seedInstance;

        private FeedbackActivityComponentBuilder() {
        }

        public FeedbackActivityComponent build() {
            if (this.seedInstance != null) {
                return new FeedbackActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FeedbackActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FeedbackActivity feedbackActivity) {
            this.seedInstance = (FeedbackActivity) Preconditions.checkNotNull(feedbackActivity);
        }
    }

    private final class FeedbackActivityComponentImpl implements FeedbackActivityComponent {
        private FeedbackActivityComponentImpl(FeedbackActivityComponentBuilder feedbackActivityComponentBuilder) {
        }

        public void inject(FeedbackActivity feedbackActivity) {
            injectFeedbackActivity(feedbackActivity);
        }

        private FeedbackActivity injectFeedbackActivity(FeedbackActivity feedbackActivity) {
            FeedbackActivity_MembersInjector.injectFittsServiceRepository(feedbackActivity, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
            return feedbackActivity;
        }
    }

    private final class FittieRecommendActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public FittieRecommendModule fittieRecommendModule;
        /* access modifiers changed from: private */
        public FittieRecommendActivity seedInstance;

        private FittieRecommendActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent build() {
            if (this.fittieRecommendModule == null) {
                this.fittieRecommendModule = new FittieRecommendModule();
            }
            if (this.seedInstance != null) {
                return new FittieRecommendActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FittieRecommendActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FittieRecommendActivity fittieRecommendActivity) {
            this.seedInstance = (FittieRecommendActivity) Preconditions.checkNotNull(fittieRecommendActivity);
        }
    }

    private final class FittieRecommendActivitySubcomponentImpl implements ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent {
        private FittieRecommendModule fittieRecommendModule;
        private FittieRecommendActivity seedInstance;

        private FittieRecommendActivitySubcomponentImpl(FittieRecommendActivitySubcomponentBuilder fittieRecommendActivitySubcomponentBuilder) {
            initialize(fittieRecommendActivitySubcomponentBuilder);
        }

        private FittieRecommendViewModelFactory getFittieRecommendViewModelFactory() {
            return FittieRecommendModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.fittieRecommendModule, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get(), (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
        }

        private FittieRecommendViewModel getFittieRecommendViewModel() {
            return FittieRecommendModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.fittieRecommendModule, this.seedInstance, getFittieRecommendViewModelFactory());
        }

        private void initialize(FittieRecommendActivitySubcomponentBuilder fittieRecommendActivitySubcomponentBuilder) {
            this.fittieRecommendModule = fittieRecommendActivitySubcomponentBuilder.fittieRecommendModule;
            this.seedInstance = fittieRecommendActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(FittieRecommendActivity fittieRecommendActivity) {
            injectFittieRecommendActivity(fittieRecommendActivity);
        }

        private FittieRecommendActivity injectFittieRecommendActivity(FittieRecommendActivity fittieRecommendActivity) {
            FittieRecommendActivity_MembersInjector.injectVm(fittieRecommendActivity, getFittieRecommendViewModel());
            return fittieRecommendActivity;
        }
    }

    private final class FittieSearchResultFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public FittieSearchResultModule fittieSearchResultModule;
        /* access modifiers changed from: private */
        public FittieSearchResultFragment seedInstance;

        private FittieSearchResultFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent build() {
            if (this.fittieSearchResultModule == null) {
                this.fittieSearchResultModule = new FittieSearchResultModule();
            }
            if (this.seedInstance != null) {
                return new FittieSearchResultFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FittieSearchResultFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FittieSearchResultFragment fittieSearchResultFragment) {
            this.seedInstance = (FittieSearchResultFragment) Preconditions.checkNotNull(fittieSearchResultFragment);
        }
    }

    private final class FittieSearchResultFragmentSubcomponentImpl implements ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent {
        private FittieSearchResultModule fittieSearchResultModule;
        private FittieSearchResultFragment seedInstance;

        private FittieSearchResultFragmentSubcomponentImpl(FittieSearchResultFragmentSubcomponentBuilder fittieSearchResultFragmentSubcomponentBuilder) {
            initialize(fittieSearchResultFragmentSubcomponentBuilder);
        }

        private SearchResultViewModelFactory getSearchResultViewModelFactory() {
            return FittieSearchResultModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.fittieSearchResultModule, this.seedInstance, (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private SearchResultViewModel getSearchResultViewModel() {
            return FittieSearchResultModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.fittieSearchResultModule, this.seedInstance, getSearchResultViewModelFactory());
        }

        private void initialize(FittieSearchResultFragmentSubcomponentBuilder fittieSearchResultFragmentSubcomponentBuilder) {
            this.fittieSearchResultModule = fittieSearchResultFragmentSubcomponentBuilder.fittieSearchResultModule;
            this.seedInstance = fittieSearchResultFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(FittieSearchResultFragment fittieSearchResultFragment) {
            injectFittieSearchResultFragment(fittieSearchResultFragment);
        }

        private FittieSearchResultFragment injectFittieSearchResultFragment(FittieSearchResultFragment fittieSearchResultFragment) {
            FittieSearchResultFragment_MembersInjector.injectViewModel(fittieSearchResultFragment, getSearchResultViewModel());
            return fittieSearchResultFragment;
        }
    }

    private final class FittsCardRendingActivityComponentBuilder extends kr.co.popone.fitts.di.component.FittsCardRendingActivityComponent.Builder {
        private FittsCardRendingActivity seedInstance;

        private FittsCardRendingActivityComponentBuilder() {
        }

        public FittsCardRendingActivityComponent build() {
            if (this.seedInstance != null) {
                return new FittsCardRendingActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FittsCardRendingActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FittsCardRendingActivity fittsCardRendingActivity) {
            this.seedInstance = (FittsCardRendingActivity) Preconditions.checkNotNull(fittsCardRendingActivity);
        }
    }

    private final class FittsCardRendingActivityComponentImpl implements FittsCardRendingActivityComponent {
        private FittsCardRendingActivityComponentImpl(FittsCardRendingActivityComponentBuilder fittsCardRendingActivityComponentBuilder) {
        }

        public void inject(FittsCardRendingActivity fittsCardRendingActivity) {
            injectFittsCardRendingActivity(fittsCardRendingActivity);
        }

        private FittsCardRendingActivity injectFittsCardRendingActivity(FittsCardRendingActivity fittsCardRendingActivity) {
            FittsCardRendingActivity_MembersInjector.injectCouponAPI(fittsCardRendingActivity, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            FittsCardRendingActivity_MembersInjector.injectEventTracker(fittsCardRendingActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return fittsCardRendingActivity;
        }
    }

    private final class FittsFirebaseMessasingServiceComponentBuilder extends kr.co.popone.fitts.services.FittsFirebaseMessasingServiceComponent.Builder {
        private FittsFirebaseMessagingService seedInstance;

        private FittsFirebaseMessasingServiceComponentBuilder() {
        }

        public FittsFirebaseMessasingServiceComponent build() {
            if (this.seedInstance != null) {
                return new FittsFirebaseMessasingServiceComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FittsFirebaseMessagingService.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FittsFirebaseMessagingService fittsFirebaseMessagingService) {
            this.seedInstance = (FittsFirebaseMessagingService) Preconditions.checkNotNull(fittsFirebaseMessagingService);
        }
    }

    private final class FittsFirebaseMessasingServiceComponentImpl implements FittsFirebaseMessasingServiceComponent {
        private FittsFirebaseMessasingServiceComponentImpl(FittsFirebaseMessasingServiceComponentBuilder fittsFirebaseMessasingServiceComponentBuilder) {
        }

        public void inject(FittsFirebaseMessagingService fittsFirebaseMessagingService) {
            injectFittsFirebaseMessagingService(fittsFirebaseMessagingService);
        }

        private FittsFirebaseMessagingService injectFittsFirebaseMessagingService(FittsFirebaseMessagingService fittsFirebaseMessagingService) {
            FittsFirebaseMessagingService_MembersInjector.injectFittsNotificationHandler(fittsFirebaseMessagingService, (FittsNotificationHandler) DaggerAppComponent.this.provideNotificationHandlerProvider.get());
            FittsFirebaseMessagingService_MembersInjector.injectServiceRepository(fittsFirebaseMessagingService, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
            FittsFirebaseMessagingService_MembersInjector.injectSessionManager(fittsFirebaseMessagingService, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return fittsFirebaseMessagingService;
        }
    }

    private final class FollowActivityComponentBuilder extends kr.co.popone.fitts.di.component.FollowActivityComponent.Builder {
        private FollowActivity seedInstance;

        private FollowActivityComponentBuilder() {
        }

        public FollowActivityComponent build() {
            if (this.seedInstance != null) {
                return new FollowActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FollowActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FollowActivity followActivity) {
            this.seedInstance = (FollowActivity) Preconditions.checkNotNull(followActivity);
        }
    }

    private final class FollowActivityComponentImpl implements FollowActivityComponent {
        private FollowActivityComponentImpl(FollowActivityComponentBuilder followActivityComponentBuilder) {
        }

        public void inject(FollowActivity followActivity) {
            injectFollowActivity(followActivity);
        }

        private FollowActivity injectFollowActivity(FollowActivity followActivity) {
            FollowActivity_MembersInjector.injectUserAPI(followActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            FollowActivity_MembersInjector.injectSessionManager(followActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            FollowActivity_MembersInjector.injectEventTracker(followActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return followActivity;
        }
    }

    private final class FollowingPostActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public FollowingPostModule followingPostModule;
        /* access modifiers changed from: private */
        public FollowingPostActivity seedInstance;

        private FollowingPostActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent build() {
            if (this.followingPostModule == null) {
                this.followingPostModule = new FollowingPostModule();
            }
            if (this.seedInstance != null) {
                return new FollowingPostActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FollowingPostActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(FollowingPostActivity followingPostActivity) {
            this.seedInstance = (FollowingPostActivity) Preconditions.checkNotNull(followingPostActivity);
        }
    }

    private final class FollowingPostActivitySubcomponentImpl implements ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent {
        private FollowingPostModule followingPostModule;
        private FollowingPostActivity seedInstance;

        private FollowingPostActivitySubcomponentImpl(FollowingPostActivitySubcomponentBuilder followingPostActivitySubcomponentBuilder) {
            initialize(followingPostActivitySubcomponentBuilder);
        }

        private FollowingPostViewModelFactory getFollowingPostViewModelFactory() {
            return FollowingPostModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.followingPostModule, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get(), (PostRepository) DaggerAppComponent.this.providePostRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
        }

        private FollowingPostViewModel getFollowingPostViewModel() {
            return FollowingPostModule_ProvideHomeViewModelFactory.proxyProvideHomeViewModel(this.followingPostModule, this.seedInstance, getFollowingPostViewModelFactory());
        }

        private void initialize(FollowingPostActivitySubcomponentBuilder followingPostActivitySubcomponentBuilder) {
            this.followingPostModule = followingPostActivitySubcomponentBuilder.followingPostModule;
            this.seedInstance = followingPostActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(FollowingPostActivity followingPostActivity) {
            injectFollowingPostActivity(followingPostActivity);
        }

        private FollowingPostActivity injectFollowingPostActivity(FollowingPostActivity followingPostActivity) {
            FollowingPostActivity_MembersInjector.injectViewModel(followingPostActivity, getFollowingPostViewModel());
            return followingPostActivity;
        }
    }

    private final class HomeFeedFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public HomeFeedModule homeFeedModule;
        /* access modifiers changed from: private */
        public HomeFeedFragment seedInstance;

        private HomeFeedFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent build() {
            if (this.homeFeedModule == null) {
                this.homeFeedModule = new HomeFeedModule();
            }
            if (this.seedInstance != null) {
                return new HomeFeedFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(HomeFeedFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(HomeFeedFragment homeFeedFragment) {
            this.seedInstance = (HomeFeedFragment) Preconditions.checkNotNull(homeFeedFragment);
        }
    }

    private final class HomeFeedFragmentSubcomponentImpl implements ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent {
        private HomeFeedModule homeFeedModule;
        private HomeFeedFragment seedInstance;

        private HomeFeedFragmentSubcomponentImpl(HomeFeedFragmentSubcomponentBuilder homeFeedFragmentSubcomponentBuilder) {
            initialize(homeFeedFragmentSubcomponentBuilder);
        }

        private HomeFeedViewModelFactory getHomeFeedViewModelFactory() {
            return HomeFeedModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.homeFeedModule, this.seedInstance, (FittsSocialRepository) DaggerAppComponent.this.provideFittsSocialRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
        }

        private HomeFeedViewModel getHomeFeedViewModel() {
            return HomeFeedModule_ProvideHomeFeedViewModelFactory.proxyProvideHomeFeedViewModel(this.homeFeedModule, this.seedInstance, getHomeFeedViewModelFactory());
        }

        private void initialize(HomeFeedFragmentSubcomponentBuilder homeFeedFragmentSubcomponentBuilder) {
            this.homeFeedModule = homeFeedFragmentSubcomponentBuilder.homeFeedModule;
            this.seedInstance = homeFeedFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(HomeFeedFragment homeFeedFragment) {
            injectHomeFeedFragment(homeFeedFragment);
        }

        private HomeFeedFragment injectHomeFeedFragment(HomeFeedFragment homeFeedFragment) {
            HomeFeedFragment_MembersInjector.injectViewModel(homeFeedFragment, getHomeFeedViewModel());
            return homeFeedFragment;
        }
    }

    private final class HomeFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public HomeModule homeModule;
        /* access modifiers changed from: private */
        public HomeFragment seedInstance;

        private HomeFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent build() {
            if (this.homeModule == null) {
                this.homeModule = new HomeModule();
            }
            if (this.seedInstance != null) {
                return new HomeFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(HomeFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(HomeFragment homeFragment) {
            this.seedInstance = (HomeFragment) Preconditions.checkNotNull(homeFragment);
        }
    }

    private final class HomeFragmentSubcomponentImpl implements ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent {
        private HomeModule homeModule;
        private HomeFragment seedInstance;

        private HomeFragmentSubcomponentImpl(HomeFragmentSubcomponentBuilder homeFragmentSubcomponentBuilder) {
            initialize(homeFragmentSubcomponentBuilder);
        }

        private HomeViewModelFactory getHomeViewModelFactory() {
            return HomeModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.homeModule, (HomeRepository) DaggerAppComponent.this.provideHomeRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private HomeViewModel getHomeViewModel() {
            return HomeModule_ProvideHomeViewModelFactory.proxyProvideHomeViewModel(this.homeModule, this.seedInstance, getHomeViewModelFactory());
        }

        private void initialize(HomeFragmentSubcomponentBuilder homeFragmentSubcomponentBuilder) {
            this.homeModule = homeFragmentSubcomponentBuilder.homeModule;
            this.seedInstance = homeFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(HomeFragment homeFragment) {
            injectHomeFragment(homeFragment);
        }

        private HomeFragment injectHomeFragment(HomeFragment homeFragment) {
            HomeFragment_MembersInjector.injectViewModel(homeFragment, getHomeViewModel());
            return homeFragment;
        }
    }

    private final class IdentificationActivityComponentBuilder extends kr.co.popone.fitts.di.component.IdentificationActivityComponent.Builder {
        private IdentificationActivity seedInstance;

        private IdentificationActivityComponentBuilder() {
        }

        public IdentificationActivityComponent build() {
            if (this.seedInstance != null) {
                return new IdentificationActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IdentificationActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IdentificationActivity identificationActivity) {
            this.seedInstance = (IdentificationActivity) Preconditions.checkNotNull(identificationActivity);
        }
    }

    private final class IdentificationActivityComponentImpl implements IdentificationActivityComponent {
        private IdentificationActivityComponentImpl(IdentificationActivityComponentBuilder identificationActivityComponentBuilder) {
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        public void inject(IdentificationActivity identificationActivity) {
            injectIdentificationActivity(identificationActivity);
        }

        private IdentificationActivity injectIdentificationActivity(IdentificationActivity identificationActivity) {
            IdentificationActivity_MembersInjector.injectFragmentInjector(identificationActivity, getDispatchingAndroidInjectorOfFragment());
            return identificationActivity;
        }
    }

    private final class IdentificationAdditionalInfoFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public IdentificationModule identificationModule;
        private IdentificationAdditionalInfoFragment seedInstance;

        private IdentificationAdditionalInfoFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent build() {
            if (this.identificationModule == null) {
                this.identificationModule = new IdentificationModule();
            }
            if (this.seedInstance != null) {
                return new IdentificationAdditionalInfoFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IdentificationAdditionalInfoFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
            this.seedInstance = (IdentificationAdditionalInfoFragment) Preconditions.checkNotNull(identificationAdditionalInfoFragment);
        }
    }

    private final class IdentificationAdditionalInfoFragmentSubcomponentImpl implements ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent {
        private IdentificationModule identificationModule;

        private IdentificationAdditionalInfoFragmentSubcomponentImpl(IdentificationAdditionalInfoFragmentSubcomponentBuilder identificationAdditionalInfoFragmentSubcomponentBuilder) {
            initialize(identificationAdditionalInfoFragmentSubcomponentBuilder);
        }

        private IdentificationAdditionalInfoViewModel getIdentificationAdditionalInfoViewModel() {
            return IdentificationModule_ProvideCreatePostViewModelFactory.proxyProvideCreatePostViewModel(this.identificationModule, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
        }

        private void initialize(IdentificationAdditionalInfoFragmentSubcomponentBuilder identificationAdditionalInfoFragmentSubcomponentBuilder) {
            this.identificationModule = identificationAdditionalInfoFragmentSubcomponentBuilder.identificationModule;
        }

        public void inject(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
            injectIdentificationAdditionalInfoFragment(identificationAdditionalInfoFragment);
        }

        private IdentificationAdditionalInfoFragment injectIdentificationAdditionalInfoFragment(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
            IdentificationAdditionalInfoFragment_MembersInjector.injectViewModel(identificationAdditionalInfoFragment, getIdentificationAdditionalInfoViewModel());
            return identificationAdditionalInfoFragment;
        }
    }

    private final class IdentificationWebViewFragmentComponentBuilder extends kr.co.popone.fitts.di.component.IdentificationWebViewFragmentComponent.Builder {
        private IdentificationWebViewFragment seedInstance;

        private IdentificationWebViewFragmentComponentBuilder() {
        }

        public IdentificationWebViewFragmentComponent build() {
            if (this.seedInstance != null) {
                return new IdentificationWebViewFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IdentificationWebViewFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IdentificationWebViewFragment identificationWebViewFragment) {
            this.seedInstance = (IdentificationWebViewFragment) Preconditions.checkNotNull(identificationWebViewFragment);
        }
    }

    private final class IdentificationWebViewFragmentComponentImpl implements IdentificationWebViewFragmentComponent {
        private IdentificationWebViewFragmentComponentImpl(IdentificationWebViewFragmentComponentBuilder identificationWebViewFragmentComponentBuilder) {
        }

        public void inject(IdentificationWebViewFragment identificationWebViewFragment) {
            injectIdentificationWebViewFragment(identificationWebViewFragment);
        }

        private IdentificationWebViewFragment injectIdentificationWebViewFragment(IdentificationWebViewFragment identificationWebViewFragment) {
            IdentificationWebViewFragment_MembersInjector.injectSessionManager(identificationWebViewFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return identificationWebViewFragment;
        }
    }

    private final class ImagePreviewActivityComponentBuilder extends kr.co.popone.fitts.di.component.ImagePreviewActivityComponent.Builder {
        private ImagePreviewActivity seedInstance;

        private ImagePreviewActivityComponentBuilder() {
        }

        public ImagePreviewActivityComponent build() {
            if (this.seedInstance != null) {
                return new ImagePreviewActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ImagePreviewActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ImagePreviewActivity imagePreviewActivity) {
            this.seedInstance = (ImagePreviewActivity) Preconditions.checkNotNull(imagePreviewActivity);
        }
    }

    private final class ImagePreviewActivityComponentImpl implements ImagePreviewActivityComponent {
        private ImagePreviewActivityComponentImpl(ImagePreviewActivityComponentBuilder imagePreviewActivityComponentBuilder) {
        }

        public void inject(ImagePreviewActivity imagePreviewActivity) {
            injectImagePreviewActivity(imagePreviewActivity);
        }

        private ImagePreviewActivity injectImagePreviewActivity(ImagePreviewActivity imagePreviewActivity) {
            ImagePreviewActivity_MembersInjector.injectDataHolderManager(imagePreviewActivity, (DataHolderManager) DaggerAppComponent.this.provideDataHoldermanagerProvider.get());
            return imagePreviewActivity;
        }
    }

    private final class ImageSelectorActivityComponentBuilder extends kr.co.popone.fitts.di.component.ImageSelectorActivityComponent.Builder {
        private ImageSelectorActivity seedInstance;

        private ImageSelectorActivityComponentBuilder() {
        }

        public ImageSelectorActivityComponent build() {
            if (this.seedInstance != null) {
                return new ImageSelectorActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ImageSelectorActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ImageSelectorActivity imageSelectorActivity) {
            this.seedInstance = (ImageSelectorActivity) Preconditions.checkNotNull(imageSelectorActivity);
        }
    }

    private final class ImageSelectorActivityComponentImpl implements ImageSelectorActivityComponent {
        private ImageSelectorActivityComponentImpl(ImageSelectorActivityComponentBuilder imageSelectorActivityComponentBuilder) {
        }

        public void inject(ImageSelectorActivity imageSelectorActivity) {
            injectImageSelectorActivity(imageSelectorActivity);
        }

        private ImageSelectorActivity injectImageSelectorActivity(ImageSelectorActivity imageSelectorActivity) {
            ImageSelectorActivity_MembersInjector.injectDataHolderManager(imageSelectorActivity, (DataHolderManager) DaggerAppComponent.this.provideDataHoldermanagerProvider.get());
            return imageSelectorActivity;
        }
    }

    private final class IntergratedSearchResultFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public IntergratedSearchResultFragment seedInstance;
        /* access modifiers changed from: private */
        public UnifiedSearchResultModule unifiedSearchResultModule;

        private IntergratedSearchResultFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent build() {
            if (this.unifiedSearchResultModule == null) {
                this.unifiedSearchResultModule = new UnifiedSearchResultModule();
            }
            if (this.seedInstance != null) {
                return new IntergratedSearchResultFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IntergratedSearchResultFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IntergratedSearchResultFragment intergratedSearchResultFragment) {
            this.seedInstance = (IntergratedSearchResultFragment) Preconditions.checkNotNull(intergratedSearchResultFragment);
        }
    }

    private final class IntergratedSearchResultFragmentSubcomponentImpl implements ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent {
        private IntergratedSearchResultFragment seedInstance;
        private UnifiedSearchResultModule unifiedSearchResultModule;

        private IntergratedSearchResultFragmentSubcomponentImpl(IntergratedSearchResultFragmentSubcomponentBuilder intergratedSearchResultFragmentSubcomponentBuilder) {
            initialize(intergratedSearchResultFragmentSubcomponentBuilder);
        }

        private SearchResultViewModelFactory getSearchResultViewModelFactory() {
            return UnifiedSearchResultModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.unifiedSearchResultModule, this.seedInstance, (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private SearchResultViewModel getSearchResultViewModel() {
            return UnifiedSearchResultModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.unifiedSearchResultModule, this.seedInstance, getSearchResultViewModelFactory());
        }

        private void initialize(IntergratedSearchResultFragmentSubcomponentBuilder intergratedSearchResultFragmentSubcomponentBuilder) {
            this.unifiedSearchResultModule = intergratedSearchResultFragmentSubcomponentBuilder.unifiedSearchResultModule;
            this.seedInstance = intergratedSearchResultFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(IntergratedSearchResultFragment intergratedSearchResultFragment) {
            injectIntergratedSearchResultFragment(intergratedSearchResultFragment);
        }

        private IntergratedSearchResultFragment injectIntergratedSearchResultFragment(IntergratedSearchResultFragment intergratedSearchResultFragment) {
            IntergratedSearchResultFragment_MembersInjector.injectViewModel(intergratedSearchResultFragment, getSearchResultViewModel());
            return intergratedSearchResultFragment;
        }
    }

    private final class IntroActivityComponentBuilder extends kr.co.popone.fitts.di.component.IntroActivityComponent.Builder {
        private IntroActivity seedInstance;

        private IntroActivityComponentBuilder() {
        }

        public IntroActivityComponent build() {
            if (this.seedInstance != null) {
                return new IntroActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IntroActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IntroActivity introActivity) {
            this.seedInstance = (IntroActivity) Preconditions.checkNotNull(introActivity);
        }
    }

    private final class IntroActivityComponentImpl implements IntroActivityComponent {
        private IntroActivityComponentImpl(IntroActivityComponentBuilder introActivityComponentBuilder) {
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        public void inject(IntroActivity introActivity) {
            injectIntroActivity(introActivity);
        }

        private IntroActivity injectIntroActivity(IntroActivity introActivity) {
            IntroActivity_MembersInjector.injectFragmentInjector(introActivity, getDispatchingAndroidInjectorOfFragment());
            IntroActivity_MembersInjector.injectUserAPI(introActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            IntroActivity_MembersInjector.injectSessionManager(introActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            IntroActivity_MembersInjector.injectEventTracker(introActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return introActivity;
        }
    }

    private final class IntroLoginFragmentComponentBuilder extends kr.co.popone.fitts.di.component.IntroLoginFragmentComponent.Builder {
        private IntroLoginFragment seedInstance;

        private IntroLoginFragmentComponentBuilder() {
        }

        public IntroLoginFragmentComponent build() {
            if (this.seedInstance != null) {
                return new IntroLoginFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(IntroLoginFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(IntroLoginFragment introLoginFragment) {
            this.seedInstance = (IntroLoginFragment) Preconditions.checkNotNull(introLoginFragment);
        }
    }

    private final class IntroLoginFragmentComponentImpl implements IntroLoginFragmentComponent {
        private IntroLoginFragmentComponentImpl(IntroLoginFragmentComponentBuilder introLoginFragmentComponentBuilder) {
        }

        public void inject(IntroLoginFragment introLoginFragment) {
            injectIntroLoginFragment(introLoginFragment);
        }

        private IntroLoginFragment injectIntroLoginFragment(IntroLoginFragment introLoginFragment) {
            IntroLoginFragment_MembersInjector.injectEventTracker(introLoginFragment, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return introLoginFragment;
        }
    }

    private final class JoinActivityComponentBuilder extends kr.co.popone.fitts.di.component.JoinActivityComponent.Builder {
        private JoinActivity seedInstance;

        private JoinActivityComponentBuilder() {
        }

        public JoinActivityComponent build() {
            if (this.seedInstance != null) {
                return new JoinActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(JoinActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(JoinActivity joinActivity) {
            this.seedInstance = (JoinActivity) Preconditions.checkNotNull(joinActivity);
        }
    }

    private final class JoinActivityComponentImpl implements JoinActivityComponent {
        private JoinActivityComponentImpl(JoinActivityComponentBuilder joinActivityComponentBuilder) {
        }

        public void inject(JoinActivity joinActivity) {
            injectJoinActivity(joinActivity);
        }

        private JoinActivity injectJoinActivity(JoinActivity joinActivity) {
            JoinActivity_MembersInjector.injectEventTracker(joinActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            JoinActivity_MembersInjector.injectSessionManager(joinActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            JoinActivity_MembersInjector.injectUserAPI(joinActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return joinActivity;
        }
    }

    private final class LikedActivityComponentBuilder extends kr.co.popone.fitts.di.component.LikedActivityComponent.Builder {
        private LikedActivity seedInstance;

        private LikedActivityComponentBuilder() {
        }

        public LikedActivityComponent build() {
            if (this.seedInstance != null) {
                return new LikedActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(LikedActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(LikedActivity likedActivity) {
            this.seedInstance = (LikedActivity) Preconditions.checkNotNull(likedActivity);
        }
    }

    private final class LikedActivityComponentImpl implements LikedActivityComponent {
        private LikedActivityComponentImpl(LikedActivityComponentBuilder likedActivityComponentBuilder) {
        }

        public void inject(LikedActivity likedActivity) {
            injectLikedActivity(likedActivity);
        }

        private LikedActivity injectLikedActivity(LikedActivity likedActivity) {
            LikedActivity_MembersInjector.injectEventTracker(likedActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            LikedActivity_MembersInjector.injectPostAPI(likedActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            LikedActivity_MembersInjector.injectUserAPI(likedActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            LikedActivity_MembersInjector.injectActionLogUtil(likedActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            return likedActivity;
        }
    }

    private final class LoginActivityComponentBuilder extends kr.co.popone.fitts.di.component.LoginActivityComponent.Builder {
        private LoginActivity seedInstance;

        private LoginActivityComponentBuilder() {
        }

        public LoginActivityComponent build() {
            if (this.seedInstance != null) {
                return new LoginActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(LoginActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(LoginActivity loginActivity) {
            this.seedInstance = (LoginActivity) Preconditions.checkNotNull(loginActivity);
        }
    }

    private final class LoginActivityComponentImpl implements LoginActivityComponent {
        private LoginActivityComponentImpl(LoginActivityComponentBuilder loginActivityComponentBuilder) {
        }

        public void inject(LoginActivity loginActivity) {
            injectLoginActivity(loginActivity);
        }

        private LoginActivity injectLoginActivity(LoginActivity loginActivity) {
            LoginActivity_MembersInjector.injectUserAPI(loginActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            LoginActivity_MembersInjector.injectSessionManager(loginActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return loginActivity;
        }
    }

    private final class MainActivityComponentBuilder extends kr.co.popone.fitts.di.component.MainActivityComponent.Builder {
        private MainActivity seedInstance;

        private MainActivityComponentBuilder() {
        }

        public MainActivityComponent build() {
            if (this.seedInstance != null) {
                return new MainActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(MainActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(MainActivity mainActivity) {
            this.seedInstance = (MainActivity) Preconditions.checkNotNull(mainActivity);
        }
    }

    private final class MainActivityComponentImpl implements MainActivityComponent {
        private MainActivityComponentImpl(MainActivityComponentBuilder mainActivityComponentBuilder) {
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        public void inject(MainActivity mainActivity) {
            injectMainActivity(mainActivity);
        }

        private MainActivity injectMainActivity(MainActivity mainActivity) {
            MainActivity_MembersInjector.injectFragmentInjector(mainActivity, getDispatchingAndroidInjectorOfFragment());
            MainActivity_MembersInjector.injectFittsNotificationHandler(mainActivity, (FittsNotificationHandler) DaggerAppComponent.this.provideNotificationHandlerProvider.get());
            MainActivity_MembersInjector.injectSchemeHandler(mainActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            MainActivity_MembersInjector.injectSessionManager(mainActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MainActivity_MembersInjector.injectAppManager(mainActivity, (AppManager) DaggerAppComponent.this.appManagerProvider.get());
            MainActivity_MembersInjector.injectEventTracker(mainActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            MainActivity_MembersInjector.injectSearchAPI(mainActivity, (SearchAPI) DaggerAppComponent.this.provideSearchAPIProvider.get());
            MainActivity_MembersInjector.injectCreatePostActivityUtil(mainActivity, (CreatePostActivityUtil) DaggerAppComponent.this.provideCreatePostActivityUtilProvider.get());
            MainActivity_MembersInjector.injectActionLogUtil(mainActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            MainActivity_MembersInjector.injectCategoryRepository(mainActivity, (CategoryRepository) DaggerAppComponent.this.provideCategorySearchRepositoryProvider.get());
            MainActivity_MembersInjector.injectFittsServiceRepository(mainActivity, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
            MainActivity_MembersInjector.injectUserApi(mainActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            MainActivity_MembersInjector.injectActionLogAPI(mainActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            return mainActivity;
        }
    }

    private final class MeFragmentComponentBuilder extends kr.co.popone.fitts.di.component.MeFragmentComponent.Builder {
        private MeFragment seedInstance;

        private MeFragmentComponentBuilder() {
        }

        public MeFragmentComponent build() {
            if (this.seedInstance != null) {
                return new MeFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(MeFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(MeFragment meFragment) {
            this.seedInstance = (MeFragment) Preconditions.checkNotNull(meFragment);
        }
    }

    private final class MeFragmentComponentImpl implements MeFragmentComponent {
        private MeFragmentComponentImpl(MeFragmentComponentBuilder meFragmentComponentBuilder) {
        }

        public void inject(MeFragment meFragment) {
            injectMeFragment(meFragment);
        }

        private MeFragment injectMeFragment(MeFragment meFragment) {
            MeFragment_MembersInjector.injectEventTracker(meFragment, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            MeFragment_MembersInjector.injectSessionManager(meFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MeFragment_MembersInjector.injectSchemeHandler(meFragment, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            MeFragment_MembersInjector.injectUserAPI(meFragment, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            MeFragment_MembersInjector.injectCouponAPI(meFragment, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            MeFragment_MembersInjector.injectFittsServiceRepository(meFragment, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
            return meFragment;
        }
    }

    private final class MixedCollectionActivityComponentBuilder extends kr.co.popone.fitts.di.component.MixedCollectionActivityComponent.Builder {
        private MixedCollectionActivity seedInstance;

        private MixedCollectionActivityComponentBuilder() {
        }

        public MixedCollectionActivityComponent build() {
            if (this.seedInstance != null) {
                return new MixedCollectionActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(MixedCollectionActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(MixedCollectionActivity mixedCollectionActivity) {
            this.seedInstance = (MixedCollectionActivity) Preconditions.checkNotNull(mixedCollectionActivity);
        }
    }

    private final class MixedCollectionActivityComponentImpl implements MixedCollectionActivityComponent {
        private MixedCollectionActivityComponentImpl(MixedCollectionActivityComponentBuilder mixedCollectionActivityComponentBuilder) {
        }

        public void inject(MixedCollectionActivity mixedCollectionActivity) {
            injectMixedCollectionActivity(mixedCollectionActivity);
        }

        private MixedCollectionActivity injectMixedCollectionActivity(MixedCollectionActivity mixedCollectionActivity) {
            MixedCollectionActivity_MembersInjector.injectSchemeHandler(mixedCollectionActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            MixedCollectionActivity_MembersInjector.injectCollectionAPI(mixedCollectionActivity, (CollectionAPI) DaggerAppComponent.this.provideCollectionAPIProvider.get());
            MixedCollectionActivity_MembersInjector.injectUserAPI(mixedCollectionActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            MixedCollectionActivity_MembersInjector.injectActionLogUtil(mixedCollectionActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            MixedCollectionActivity_MembersInjector.injectActionLogAPI(mixedCollectionActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            MixedCollectionActivity_MembersInjector.injectEventTracker(mixedCollectionActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            MixedCollectionActivity_MembersInjector.injectCommerceRepository(mixedCollectionActivity, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get());
            return mixedCollectionActivity;
        }
    }

    private final class ModifyBodyActivityComponentBuilder extends kr.co.popone.fitts.di.component.ModifyBodyActivityComponent.Builder {
        private ModifyBodyActivity seedInstance;

        private ModifyBodyActivityComponentBuilder() {
        }

        public ModifyBodyActivityComponent build() {
            if (this.seedInstance != null) {
                return new ModifyBodyActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ModifyBodyActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ModifyBodyActivity modifyBodyActivity) {
            this.seedInstance = (ModifyBodyActivity) Preconditions.checkNotNull(modifyBodyActivity);
        }
    }

    private final class ModifyBodyActivityComponentImpl implements ModifyBodyActivityComponent {
        private ModifyBodyActivityComponentImpl(ModifyBodyActivityComponentBuilder modifyBodyActivityComponentBuilder) {
        }

        public void inject(ModifyBodyActivity modifyBodyActivity) {
            injectModifyBodyActivity(modifyBodyActivity);
        }

        private ModifyBodyActivity injectModifyBodyActivity(ModifyBodyActivity modifyBodyActivity) {
            ModifyBodyActivity_MembersInjector.injectUserAPI(modifyBodyActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            ModifyBodyActivity_MembersInjector.injectSessionManager(modifyBodyActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return modifyBodyActivity;
        }
    }

    private final class ModifyProfileActivityComponentBuilder extends kr.co.popone.fitts.di.component.ModifyProfileActivityComponent.Builder {
        private ModifyProfileActivity seedInstance;

        private ModifyProfileActivityComponentBuilder() {
        }

        public ModifyProfileActivityComponent build() {
            if (this.seedInstance != null) {
                return new ModifyProfileActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ModifyProfileActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ModifyProfileActivity modifyProfileActivity) {
            this.seedInstance = (ModifyProfileActivity) Preconditions.checkNotNull(modifyProfileActivity);
        }
    }

    private final class ModifyProfileActivityComponentImpl implements ModifyProfileActivityComponent {
        private ModifyProfileActivityComponentImpl(ModifyProfileActivityComponentBuilder modifyProfileActivityComponentBuilder) {
        }

        public void inject(ModifyProfileActivity modifyProfileActivity) {
            injectModifyProfileActivity(modifyProfileActivity);
        }

        private ModifyProfileActivity injectModifyProfileActivity(ModifyProfileActivity modifyProfileActivity) {
            ModifyProfileActivity_MembersInjector.injectUserAPI(modifyProfileActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return modifyProfileActivity;
        }
    }

    private final class ModifyShowRoomActivityComponentBuilder extends kr.co.popone.fitts.di.component.ModifyShowRoomActivityComponent.Builder {
        private ModifyShowRoomActivity seedInstance;

        private ModifyShowRoomActivityComponentBuilder() {
        }

        public ModifyShowRoomActivityComponent build() {
            if (this.seedInstance != null) {
                return new ModifyShowRoomActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ModifyShowRoomActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ModifyShowRoomActivity modifyShowRoomActivity) {
            this.seedInstance = (ModifyShowRoomActivity) Preconditions.checkNotNull(modifyShowRoomActivity);
        }
    }

    private final class ModifyShowRoomActivityComponentImpl implements ModifyShowRoomActivityComponent {
        private ModifyShowRoomActivityComponentImpl(ModifyShowRoomActivityComponentBuilder modifyShowRoomActivityComponentBuilder) {
        }

        public void inject(ModifyShowRoomActivity modifyShowRoomActivity) {
            injectModifyShowRoomActivity(modifyShowRoomActivity);
        }

        private ModifyShowRoomActivity injectModifyShowRoomActivity(ModifyShowRoomActivity modifyShowRoomActivity) {
            ModifyShowRoomActivity_MembersInjector.injectSessionManager(modifyShowRoomActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            ModifyShowRoomActivity_MembersInjector.injectUserAPI(modifyShowRoomActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return modifyShowRoomActivity;
        }
    }

    private final class ModifyUserInfoActivityComponentBuilder extends kr.co.popone.fitts.di.component.ModifyUserInfoActivityComponent.Builder {
        private ModifyUserInfoActivity seedInstance;

        private ModifyUserInfoActivityComponentBuilder() {
        }

        public ModifyUserInfoActivityComponent build() {
            if (this.seedInstance != null) {
                return new ModifyUserInfoActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ModifyUserInfoActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ModifyUserInfoActivity modifyUserInfoActivity) {
            this.seedInstance = (ModifyUserInfoActivity) Preconditions.checkNotNull(modifyUserInfoActivity);
        }
    }

    private final class ModifyUserInfoActivityComponentImpl implements ModifyUserInfoActivityComponent {
        private ModifyUserInfoActivityComponentImpl(ModifyUserInfoActivityComponentBuilder modifyUserInfoActivityComponentBuilder) {
        }

        public void inject(ModifyUserInfoActivity modifyUserInfoActivity) {
            injectModifyUserInfoActivity(modifyUserInfoActivity);
        }

        private ModifyUserInfoActivity injectModifyUserInfoActivity(ModifyUserInfoActivity modifyUserInfoActivity) {
            ModifyUserInfoActivity_MembersInjector.injectUserAPI(modifyUserInfoActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return modifyUserInfoActivity;
        }
    }

    private final class MultiImageEventActivityComponentBuilder extends kr.co.popone.fitts.di.component.MultiImageEventActivityComponent.Builder {
        private MultiImageEventActivity seedInstance;

        private MultiImageEventActivityComponentBuilder() {
        }

        public MultiImageEventActivityComponent build() {
            if (this.seedInstance != null) {
                return new MultiImageEventActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(MultiImageEventActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(MultiImageEventActivity multiImageEventActivity) {
            this.seedInstance = (MultiImageEventActivity) Preconditions.checkNotNull(multiImageEventActivity);
        }
    }

    private final class MultiImageEventActivityComponentImpl implements MultiImageEventActivityComponent {
        private MultiImageEventActivityComponentImpl(MultiImageEventActivityComponentBuilder multiImageEventActivityComponentBuilder) {
        }

        public void inject(MultiImageEventActivity multiImageEventActivity) {
            injectMultiImageEventActivity(multiImageEventActivity);
        }

        private MultiImageEventActivity injectMultiImageEventActivity(MultiImageEventActivity multiImageEventActivity) {
            MultiImageEventActivity_MembersInjector.injectEventAPI(multiImageEventActivity, (EventAPI) DaggerAppComponent.this.provideEventAPIProvider.get());
            MultiImageEventActivity_MembersInjector.injectSchemeHandler(multiImageEventActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            MultiImageEventActivity_MembersInjector.injectEventTracker(multiImageEventActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return multiImageEventActivity;
        }
    }

    private final class NCommerceActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public NCommerceModule nCommerceModule;
        /* access modifiers changed from: private */
        public NCommerceActivity seedInstance;

        private NCommerceActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent build() {
            if (this.nCommerceModule == null) {
                this.nCommerceModule = new NCommerceModule();
            }
            if (this.seedInstance != null) {
                return new NCommerceActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(NCommerceActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(NCommerceActivity nCommerceActivity) {
            this.seedInstance = (NCommerceActivity) Preconditions.checkNotNull(nCommerceActivity);
        }
    }

    private final class NCommerceActivitySubcomponentImpl implements ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent {
        private NCommerceModule nCommerceModule;
        private NCommerceActivity seedInstance;

        private NCommerceActivitySubcomponentImpl(NCommerceActivitySubcomponentBuilder nCommerceActivitySubcomponentBuilder) {
            initialize(nCommerceActivitySubcomponentBuilder);
        }

        private NCommerceViewModelFactory getNCommerceViewModelFactory() {
            return NCommerceModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.nCommerceModule, (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private NCommerceViewModel getNCommerceViewModel() {
            return NCommerceModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.nCommerceModule, this.seedInstance, getNCommerceViewModelFactory());
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private void initialize(NCommerceActivitySubcomponentBuilder nCommerceActivitySubcomponentBuilder) {
            this.nCommerceModule = nCommerceActivitySubcomponentBuilder.nCommerceModule;
            this.seedInstance = nCommerceActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(NCommerceActivity nCommerceActivity) {
            injectNCommerceActivity(nCommerceActivity);
        }

        private NCommerceActivity injectNCommerceActivity(NCommerceActivity nCommerceActivity) {
            NCommerceActivity_MembersInjector.injectViewModel(nCommerceActivity, getNCommerceViewModel());
            NCommerceActivity_MembersInjector.injectFragmentInjector(nCommerceActivity, getDispatchingAndroidInjectorOfFragment());
            return nCommerceActivity;
        }
    }

    private final class OpenWebActivityComponentBuilder extends kr.co.popone.fitts.di.component.OpenWebActivityComponent.Builder {
        private OpenWebActivity seedInstance;

        private OpenWebActivityComponentBuilder() {
        }

        public OpenWebActivityComponent build() {
            if (this.seedInstance != null) {
                return new OpenWebActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OpenWebActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OpenWebActivity openWebActivity) {
            this.seedInstance = (OpenWebActivity) Preconditions.checkNotNull(openWebActivity);
        }
    }

    private final class OpenWebActivityComponentImpl implements OpenWebActivityComponent {
        private OpenWebActivityComponentImpl(OpenWebActivityComponentBuilder openWebActivityComponentBuilder) {
        }

        public void inject(OpenWebActivity openWebActivity) {
            injectOpenWebActivity(openWebActivity);
        }

        private OpenWebActivity injectOpenWebActivity(OpenWebActivity openWebActivity) {
            OpenWebActivity_MembersInjector.injectFittsSchemeHandler(openWebActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            OpenWebActivity_MembersInjector.injectEventTracker(openWebActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return openWebActivity;
        }
    }

    private final class OrderActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderModule orderModule;
        /* access modifiers changed from: private */
        public OrderActivity seedInstance;

        private OrderActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent build() {
            if (this.orderModule == null) {
                this.orderModule = new OrderModule();
            }
            if (this.seedInstance != null) {
                return new OrderActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderActivity orderActivity) {
            this.seedInstance = (OrderActivity) Preconditions.checkNotNull(orderActivity);
        }
    }

    private final class OrderActivitySubcomponentImpl implements ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent {
        private OrderModule orderModule;
        private OrderActivity seedInstance;

        private OrderActivitySubcomponentImpl(OrderActivitySubcomponentBuilder orderActivitySubcomponentBuilder) {
            initialize(orderActivitySubcomponentBuilder);
        }

        private OrderViewModelFactory getOrderViewModelFactory() {
            return OrderModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderModule, this.seedInstance, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSocialRepository) DaggerAppComponent.this.provideFittsSocialRepositoryProvider.get(), (ProductRepository) DaggerAppComponent.this.provideProductRepositoryProvider.get(), (CartRepository) DaggerAppComponent.this.provideCartRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private OrderViewModel getOrderViewModel() {
            return OrderModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderModule, this.seedInstance, getOrderViewModelFactory());
        }

        private void initialize(OrderActivitySubcomponentBuilder orderActivitySubcomponentBuilder) {
            this.orderModule = orderActivitySubcomponentBuilder.orderModule;
            this.seedInstance = orderActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(OrderActivity orderActivity) {
            injectOrderActivity(orderActivity);
        }

        private OrderActivity injectOrderActivity(OrderActivity orderActivity) {
            OrderActivity_MembersInjector.injectViewModel(orderActivity, getOrderViewModel());
            return orderActivity;
        }
    }

    private final class OrderAllCancelFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderAllCancelModule orderAllCancelModule;
        /* access modifiers changed from: private */
        public OrderAllCancelFragment seedInstance;

        private OrderAllCancelFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent build() {
            if (this.orderAllCancelModule == null) {
                this.orderAllCancelModule = new OrderAllCancelModule();
            }
            if (this.seedInstance != null) {
                return new OrderAllCancelFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderAllCancelFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderAllCancelFragment orderAllCancelFragment) {
            this.seedInstance = (OrderAllCancelFragment) Preconditions.checkNotNull(orderAllCancelFragment);
        }
    }

    private final class OrderAllCancelFragmentSubcomponentImpl implements ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent {
        private OrderAllCancelModule orderAllCancelModule;
        private OrderAllCancelFragment seedInstance;

        private OrderAllCancelFragmentSubcomponentImpl(OrderAllCancelFragmentSubcomponentBuilder orderAllCancelFragmentSubcomponentBuilder) {
            initialize(orderAllCancelFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderAllCancelModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderAllCancelModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderAllCancelModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderAllCancelModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderAllCancelFragmentSubcomponentBuilder orderAllCancelFragmentSubcomponentBuilder) {
            this.orderAllCancelModule = orderAllCancelFragmentSubcomponentBuilder.orderAllCancelModule;
            this.seedInstance = orderAllCancelFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderAllCancelFragment orderAllCancelFragment) {
            injectOrderAllCancelFragment(orderAllCancelFragment);
        }

        private OrderAllCancelFragment injectOrderAllCancelFragment(OrderAllCancelFragment orderAllCancelFragment) {
            OrderAllCancelFragment_MembersInjector.injectViewModel(orderAllCancelFragment, getOrderPushRendingViewModel());
            return orderAllCancelFragment;
        }
    }

    private final class OrderCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderCompleteModule orderCompleteModule;
        /* access modifiers changed from: private */
        public OrderCompleteFragment seedInstance;

        private OrderCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent build() {
            if (this.orderCompleteModule == null) {
                this.orderCompleteModule = new OrderCompleteModule();
            }
            if (this.seedInstance != null) {
                return new OrderCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderCompleteFragment orderCompleteFragment) {
            this.seedInstance = (OrderCompleteFragment) Preconditions.checkNotNull(orderCompleteFragment);
        }
    }

    private final class OrderCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent {
        private OrderCompleteModule orderCompleteModule;
        private OrderCompleteFragment seedInstance;

        private OrderCompleteFragmentSubcomponentImpl(OrderCompleteFragmentSubcomponentBuilder orderCompleteFragmentSubcomponentBuilder) {
            initialize(orderCompleteFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderCompleteModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderCompleteModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderCompleteModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderCompleteModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderCompleteFragmentSubcomponentBuilder orderCompleteFragmentSubcomponentBuilder) {
            this.orderCompleteModule = orderCompleteFragmentSubcomponentBuilder.orderCompleteModule;
            this.seedInstance = orderCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderCompleteFragment orderCompleteFragment) {
            injectOrderCompleteFragment(orderCompleteFragment);
        }

        private OrderCompleteFragment injectOrderCompleteFragment(OrderCompleteFragment orderCompleteFragment) {
            OrderCompleteFragment_MembersInjector.injectViewModel(orderCompleteFragment, getOrderPushRendingViewModel());
            return orderCompleteFragment;
        }
    }

    private final class OrderCompleteRenderActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderCompleteRenderModule orderCompleteRenderModule;
        /* access modifiers changed from: private */
        public OrderCompleteRenderActivity seedInstance;

        private OrderCompleteRenderActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent build() {
            if (this.orderCompleteRenderModule == null) {
                this.orderCompleteRenderModule = new OrderCompleteRenderModule();
            }
            if (this.seedInstance != null) {
                return new OrderCompleteRenderActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderCompleteRenderActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderCompleteRenderActivity orderCompleteRenderActivity) {
            this.seedInstance = (OrderCompleteRenderActivity) Preconditions.checkNotNull(orderCompleteRenderActivity);
        }
    }

    private final class OrderCompleteRenderActivitySubcomponentImpl implements ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent {
        private OrderCompleteRenderModule orderCompleteRenderModule;
        private OrderCompleteRenderActivity seedInstance;

        private OrderCompleteRenderActivitySubcomponentImpl(OrderCompleteRenderActivitySubcomponentBuilder orderCompleteRenderActivitySubcomponentBuilder) {
            initialize(orderCompleteRenderActivitySubcomponentBuilder);
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private OrderCompleteRenderViewModelFactory getOrderCompleteRenderViewModelFactory() {
            return OrderCompleteRenderModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderCompleteRenderModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderCompleteRenderViewModel getOrderCompleteRenderViewModel() {
            return OrderCompleteRenderModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderCompleteRenderModule, this.seedInstance, getOrderCompleteRenderViewModelFactory());
        }

        private void initialize(OrderCompleteRenderActivitySubcomponentBuilder orderCompleteRenderActivitySubcomponentBuilder) {
            this.orderCompleteRenderModule = orderCompleteRenderActivitySubcomponentBuilder.orderCompleteRenderModule;
            this.seedInstance = orderCompleteRenderActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(OrderCompleteRenderActivity orderCompleteRenderActivity) {
            injectOrderCompleteRenderActivity(orderCompleteRenderActivity);
        }

        private OrderCompleteRenderActivity injectOrderCompleteRenderActivity(OrderCompleteRenderActivity orderCompleteRenderActivity) {
            OrderCompleteRenderActivity_MembersInjector.injectFragmentInjector(orderCompleteRenderActivity, getDispatchingAndroidInjectorOfFragment());
            OrderCompleteRenderActivity_MembersInjector.injectViewModel(orderCompleteRenderActivity, getOrderCompleteRenderViewModel());
            return orderCompleteRenderActivity;
        }
    }

    private final class OrderCompleteRenderPaymentFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule;
        /* access modifiers changed from: private */
        public OrderCompleteRenderPaymentFragment seedInstance;

        private OrderCompleteRenderPaymentFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent build() {
            if (this.orderCompleteRenderPaymentModule == null) {
                this.orderCompleteRenderPaymentModule = new OrderCompleteRenderPaymentModule();
            }
            if (this.seedInstance != null) {
                return new OrderCompleteRenderPaymentFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderCompleteRenderPaymentFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
            this.seedInstance = (OrderCompleteRenderPaymentFragment) Preconditions.checkNotNull(orderCompleteRenderPaymentFragment);
        }
    }

    private final class OrderCompleteRenderPaymentFragmentSubcomponentImpl implements ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent {
        private OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule;
        private OrderCompleteRenderPaymentFragment seedInstance;

        private OrderCompleteRenderPaymentFragmentSubcomponentImpl(OrderCompleteRenderPaymentFragmentSubcomponentBuilder orderCompleteRenderPaymentFragmentSubcomponentBuilder) {
            initialize(orderCompleteRenderPaymentFragmentSubcomponentBuilder);
        }

        private OrderCompleteRenderViewModelFactory getOrderCompleteRenderViewModelFactory() {
            return OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderCompleteRenderPaymentModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderCompleteRenderViewModel getOrderCompleteRenderViewModel() {
            return OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderCompleteRenderPaymentModule, this.seedInstance, getOrderCompleteRenderViewModelFactory());
        }

        private void initialize(OrderCompleteRenderPaymentFragmentSubcomponentBuilder orderCompleteRenderPaymentFragmentSubcomponentBuilder) {
            this.orderCompleteRenderPaymentModule = orderCompleteRenderPaymentFragmentSubcomponentBuilder.orderCompleteRenderPaymentModule;
            this.seedInstance = orderCompleteRenderPaymentFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
            injectOrderCompleteRenderPaymentFragment(orderCompleteRenderPaymentFragment);
        }

        private OrderCompleteRenderPaymentFragment injectOrderCompleteRenderPaymentFragment(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
            OrderCompleteRenderPaymentFragment_MembersInjector.injectViewModel(orderCompleteRenderPaymentFragment, getOrderCompleteRenderViewModel());
            return orderCompleteRenderPaymentFragment;
        }
    }

    private final class OrderCompleteRenderReservationFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderCompleteRenderReservationModule orderCompleteRenderReservationModule;
        /* access modifiers changed from: private */
        public OrderCompleteRenderReservationFragment seedInstance;

        private OrderCompleteRenderReservationFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent build() {
            if (this.orderCompleteRenderReservationModule == null) {
                this.orderCompleteRenderReservationModule = new OrderCompleteRenderReservationModule();
            }
            if (this.seedInstance != null) {
                return new OrderCompleteRenderReservationFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderCompleteRenderReservationFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
            this.seedInstance = (OrderCompleteRenderReservationFragment) Preconditions.checkNotNull(orderCompleteRenderReservationFragment);
        }
    }

    private final class OrderCompleteRenderReservationFragmentSubcomponentImpl implements ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent {
        private OrderCompleteRenderReservationModule orderCompleteRenderReservationModule;
        private OrderCompleteRenderReservationFragment seedInstance;

        private OrderCompleteRenderReservationFragmentSubcomponentImpl(OrderCompleteRenderReservationFragmentSubcomponentBuilder orderCompleteRenderReservationFragmentSubcomponentBuilder) {
            initialize(orderCompleteRenderReservationFragmentSubcomponentBuilder);
        }

        private OrderCompleteRenderViewModelFactory getOrderCompleteRenderViewModelFactory() {
            return OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderCompleteRenderReservationModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderCompleteRenderViewModel getOrderCompleteRenderViewModel() {
            return OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderCompleteRenderReservationModule, this.seedInstance, getOrderCompleteRenderViewModelFactory());
        }

        private void initialize(OrderCompleteRenderReservationFragmentSubcomponentBuilder orderCompleteRenderReservationFragmentSubcomponentBuilder) {
            this.orderCompleteRenderReservationModule = orderCompleteRenderReservationFragmentSubcomponentBuilder.orderCompleteRenderReservationModule;
            this.seedInstance = orderCompleteRenderReservationFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
            injectOrderCompleteRenderReservationFragment(orderCompleteRenderReservationFragment);
        }

        private OrderCompleteRenderReservationFragment injectOrderCompleteRenderReservationFragment(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
            OrderCompleteRenderReservationFragment_MembersInjector.injectViewModel(orderCompleteRenderReservationFragment, getOrderCompleteRenderViewModel());
            return orderCompleteRenderReservationFragment;
        }
    }

    private final class OrderDetailActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderDetailModule orderDetailModule;
        /* access modifiers changed from: private */
        public OrderDetailActivity seedInstance;

        private OrderDetailActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent build() {
            if (this.orderDetailModule == null) {
                this.orderDetailModule = new OrderDetailModule();
            }
            if (this.seedInstance != null) {
                return new OrderDetailActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderDetailActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderDetailActivity orderDetailActivity) {
            this.seedInstance = (OrderDetailActivity) Preconditions.checkNotNull(orderDetailActivity);
        }
    }

    private final class OrderDetailActivitySubcomponentImpl implements ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent {
        private OrderDetailModule orderDetailModule;
        private OrderDetailActivity seedInstance;

        private OrderDetailActivitySubcomponentImpl(OrderDetailActivitySubcomponentBuilder orderDetailActivitySubcomponentBuilder) {
            initialize(orderDetailActivitySubcomponentBuilder);
        }

        private OrderDetailViewModelFactory getOrderDetailViewModelFactory() {
            return OrderDetailModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderDetailModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (CreatePostActivityUtil) DaggerAppComponent.this.provideCreatePostActivityUtilProvider.get());
        }

        private OrderDetailViewModel getOrderDetailViewModel() {
            return OrderDetailModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderDetailModule, this.seedInstance, getOrderDetailViewModelFactory());
        }

        private void initialize(OrderDetailActivitySubcomponentBuilder orderDetailActivitySubcomponentBuilder) {
            this.orderDetailModule = orderDetailActivitySubcomponentBuilder.orderDetailModule;
            this.seedInstance = orderDetailActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(OrderDetailActivity orderDetailActivity) {
            injectOrderDetailActivity(orderDetailActivity);
        }

        private OrderDetailActivity injectOrderDetailActivity(OrderDetailActivity orderDetailActivity) {
            OrderDetailActivity_MembersInjector.injectViewModel(orderDetailActivity, getOrderDetailViewModel());
            return orderDetailActivity;
        }
    }

    private final class OrderListActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderListModule orderListModule;
        /* access modifiers changed from: private */
        public OrderListActivity seedInstance;

        private OrderListActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent build() {
            if (this.orderListModule == null) {
                this.orderListModule = new OrderListModule();
            }
            if (this.seedInstance != null) {
                return new OrderListActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderListActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderListActivity orderListActivity) {
            this.seedInstance = (OrderListActivity) Preconditions.checkNotNull(orderListActivity);
        }
    }

    private final class OrderListActivitySubcomponentImpl implements ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent {
        private OrderListModule orderListModule;
        private OrderListActivity seedInstance;

        private OrderListActivitySubcomponentImpl(OrderListActivitySubcomponentBuilder orderListActivitySubcomponentBuilder) {
            initialize(orderListActivitySubcomponentBuilder);
        }

        private OrderListViewModelFactory getOrderListViewModelFactory() {
            return OrderListModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderListModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private OrderListViewModel getOrderListViewModel() {
            return OrderListModule_ProvideOrderListViewModelFactory.proxyProvideOrderListViewModel(this.orderListModule, this.seedInstance, getOrderListViewModelFactory());
        }

        private void initialize(OrderListActivitySubcomponentBuilder orderListActivitySubcomponentBuilder) {
            this.orderListModule = orderListActivitySubcomponentBuilder.orderListModule;
            this.seedInstance = orderListActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(OrderListActivity orderListActivity) {
            injectOrderListActivity(orderListActivity);
        }

        private OrderListActivity injectOrderListActivity(OrderListActivity orderListActivity) {
            OrderListActivity_MembersInjector.injectViewModel(orderListActivity, getOrderListViewModel());
            return orderListActivity;
        }
    }

    private final class OrderPartCancelFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderPartCancelModule orderPartCancelModule;
        /* access modifiers changed from: private */
        public OrderPartCancelFragment seedInstance;

        private OrderPartCancelFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent build() {
            if (this.orderPartCancelModule == null) {
                this.orderPartCancelModule = new OrderPartCancelModule();
            }
            if (this.seedInstance != null) {
                return new OrderPartCancelFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderPartCancelFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderPartCancelFragment orderPartCancelFragment) {
            this.seedInstance = (OrderPartCancelFragment) Preconditions.checkNotNull(orderPartCancelFragment);
        }
    }

    private final class OrderPartCancelFragmentSubcomponentImpl implements ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent {
        private OrderPartCancelModule orderPartCancelModule;
        private OrderPartCancelFragment seedInstance;

        private OrderPartCancelFragmentSubcomponentImpl(OrderPartCancelFragmentSubcomponentBuilder orderPartCancelFragmentSubcomponentBuilder) {
            initialize(orderPartCancelFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderPartCancelModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderPartCancelModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderPartCancelModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderPartCancelModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderPartCancelFragmentSubcomponentBuilder orderPartCancelFragmentSubcomponentBuilder) {
            this.orderPartCancelModule = orderPartCancelFragmentSubcomponentBuilder.orderPartCancelModule;
            this.seedInstance = orderPartCancelFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderPartCancelFragment orderPartCancelFragment) {
            injectOrderPartCancelFragment(orderPartCancelFragment);
        }

        private OrderPartCancelFragment injectOrderPartCancelFragment(OrderPartCancelFragment orderPartCancelFragment) {
            OrderPartCancelFragment_MembersInjector.injectViewModel(orderPartCancelFragment, getOrderPushRendingViewModel());
            return orderPartCancelFragment;
        }
    }

    private final class OrderPaymentCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderPaymentCompleteModule orderPaymentCompleteModule;
        /* access modifiers changed from: private */
        public OrderPaymentCompleteFragment seedInstance;

        private OrderPaymentCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent build() {
            if (this.orderPaymentCompleteModule == null) {
                this.orderPaymentCompleteModule = new OrderPaymentCompleteModule();
            }
            if (this.seedInstance != null) {
                return new OrderPaymentCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderPaymentCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
            this.seedInstance = (OrderPaymentCompleteFragment) Preconditions.checkNotNull(orderPaymentCompleteFragment);
        }
    }

    private final class OrderPaymentCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent {
        private OrderPaymentCompleteModule orderPaymentCompleteModule;
        private OrderPaymentCompleteFragment seedInstance;

        private OrderPaymentCompleteFragmentSubcomponentImpl(OrderPaymentCompleteFragmentSubcomponentBuilder orderPaymentCompleteFragmentSubcomponentBuilder) {
            initialize(orderPaymentCompleteFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderPaymentCompleteModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderPaymentCompleteModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderPaymentCompleteModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderPaymentCompleteFragmentSubcomponentBuilder orderPaymentCompleteFragmentSubcomponentBuilder) {
            this.orderPaymentCompleteModule = orderPaymentCompleteFragmentSubcomponentBuilder.orderPaymentCompleteModule;
            this.seedInstance = orderPaymentCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
            injectOrderPaymentCompleteFragment(orderPaymentCompleteFragment);
        }

        private OrderPaymentCompleteFragment injectOrderPaymentCompleteFragment(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
            OrderPaymentCompleteFragment_MembersInjector.injectViewModel(orderPaymentCompleteFragment, getOrderPushRendingViewModel());
            return orderPaymentCompleteFragment;
        }
    }

    private final class OrderPaymentRushFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderPaymentRushModule orderPaymentRushModule;
        /* access modifiers changed from: private */
        public OrderPaymentRushFragment seedInstance;

        private OrderPaymentRushFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent build() {
            if (this.orderPaymentRushModule == null) {
                this.orderPaymentRushModule = new OrderPaymentRushModule();
            }
            if (this.seedInstance != null) {
                return new OrderPaymentRushFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderPaymentRushFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderPaymentRushFragment orderPaymentRushFragment) {
            this.seedInstance = (OrderPaymentRushFragment) Preconditions.checkNotNull(orderPaymentRushFragment);
        }
    }

    private final class OrderPaymentRushFragmentSubcomponentImpl implements ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent {
        private OrderPaymentRushModule orderPaymentRushModule;
        private OrderPaymentRushFragment seedInstance;

        private OrderPaymentRushFragmentSubcomponentImpl(OrderPaymentRushFragmentSubcomponentBuilder orderPaymentRushFragmentSubcomponentBuilder) {
            initialize(orderPaymentRushFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderPaymentRushModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderPaymentRushModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderPaymentRushModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderPaymentRushModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderPaymentRushFragmentSubcomponentBuilder orderPaymentRushFragmentSubcomponentBuilder) {
            this.orderPaymentRushModule = orderPaymentRushFragmentSubcomponentBuilder.orderPaymentRushModule;
            this.seedInstance = orderPaymentRushFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderPaymentRushFragment orderPaymentRushFragment) {
            injectOrderPaymentRushFragment(orderPaymentRushFragment);
        }

        private OrderPaymentRushFragment injectOrderPaymentRushFragment(OrderPaymentRushFragment orderPaymentRushFragment) {
            OrderPaymentRushFragment_MembersInjector.injectViewModel(orderPaymentRushFragment, getOrderPushRendingViewModel());
            return orderPaymentRushFragment;
        }
    }

    private final class OrderRendingActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent.Builder {
        private OrderRendingActivity seedInstance;

        private OrderRendingActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new OrderRendingActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderRendingActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderRendingActivity orderRendingActivity) {
            this.seedInstance = (OrderRendingActivity) Preconditions.checkNotNull(orderRendingActivity);
        }
    }

    private final class OrderRendingActivitySubcomponentImpl implements ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent {
        private OrderRendingActivitySubcomponentImpl(OrderRendingActivitySubcomponentBuilder orderRendingActivitySubcomponentBuilder) {
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        public void inject(OrderRendingActivity orderRendingActivity) {
            injectOrderRendingActivity(orderRendingActivity);
        }

        private OrderRendingActivity injectOrderRendingActivity(OrderRendingActivity orderRendingActivity) {
            OrderRendingActivity_MembersInjector.injectFragmentInjector(orderRendingActivity, getDispatchingAndroidInjectorOfFragment());
            return orderRendingActivity;
        }
    }

    private final class OrderReservationCancelFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderReservationCancelModule orderReservationCancelModule;
        /* access modifiers changed from: private */
        public OrderReservationCancelFragment seedInstance;

        private OrderReservationCancelFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent build() {
            if (this.orderReservationCancelModule == null) {
                this.orderReservationCancelModule = new OrderReservationCancelModule();
            }
            if (this.seedInstance != null) {
                return new OrderReservationCancelFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderReservationCancelFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderReservationCancelFragment orderReservationCancelFragment) {
            this.seedInstance = (OrderReservationCancelFragment) Preconditions.checkNotNull(orderReservationCancelFragment);
        }
    }

    private final class OrderReservationCancelFragmentSubcomponentImpl implements ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent {
        private OrderReservationCancelModule orderReservationCancelModule;
        private OrderReservationCancelFragment seedInstance;

        private OrderReservationCancelFragmentSubcomponentImpl(OrderReservationCancelFragmentSubcomponentBuilder orderReservationCancelFragmentSubcomponentBuilder) {
            initialize(orderReservationCancelFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderReservationCancelModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderReservationCancelModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderReservationCancelModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderReservationCancelModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderReservationCancelFragmentSubcomponentBuilder orderReservationCancelFragmentSubcomponentBuilder) {
            this.orderReservationCancelModule = orderReservationCancelFragmentSubcomponentBuilder.orderReservationCancelModule;
            this.seedInstance = orderReservationCancelFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderReservationCancelFragment orderReservationCancelFragment) {
            injectOrderReservationCancelFragment(orderReservationCancelFragment);
        }

        private OrderReservationCancelFragment injectOrderReservationCancelFragment(OrderReservationCancelFragment orderReservationCancelFragment) {
            OrderReservationCancelFragment_MembersInjector.injectViewModel(orderReservationCancelFragment, getOrderPushRendingViewModel());
            return orderReservationCancelFragment;
        }
    }

    private final class OrderReservationCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderReservationCompleteModule orderReservationCompleteModule;
        /* access modifiers changed from: private */
        public OrderReservationCompleteFragment seedInstance;

        private OrderReservationCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent build() {
            if (this.orderReservationCompleteModule == null) {
                this.orderReservationCompleteModule = new OrderReservationCompleteModule();
            }
            if (this.seedInstance != null) {
                return new OrderReservationCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderReservationCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderReservationCompleteFragment orderReservationCompleteFragment) {
            this.seedInstance = (OrderReservationCompleteFragment) Preconditions.checkNotNull(orderReservationCompleteFragment);
        }
    }

    private final class OrderReservationCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent {
        private OrderReservationCompleteModule orderReservationCompleteModule;
        private OrderReservationCompleteFragment seedInstance;

        private OrderReservationCompleteFragmentSubcomponentImpl(OrderReservationCompleteFragmentSubcomponentBuilder orderReservationCompleteFragmentSubcomponentBuilder) {
            initialize(orderReservationCompleteFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderReservationCompleteModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderReservationCompleteModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderReservationCompleteModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderReservationCompleteModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderReservationCompleteFragmentSubcomponentBuilder orderReservationCompleteFragmentSubcomponentBuilder) {
            this.orderReservationCompleteModule = orderReservationCompleteFragmentSubcomponentBuilder.orderReservationCompleteModule;
            this.seedInstance = orderReservationCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderReservationCompleteFragment orderReservationCompleteFragment) {
            injectOrderReservationCompleteFragment(orderReservationCompleteFragment);
        }

        private OrderReservationCompleteFragment injectOrderReservationCompleteFragment(OrderReservationCompleteFragment orderReservationCompleteFragment) {
            OrderReservationCompleteFragment_MembersInjector.injectViewModel(orderReservationCompleteFragment, getOrderPushRendingViewModel());
            return orderReservationCompleteFragment;
        }
    }

    private final class OrderReservationSoldOutFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderReservationSoldOutModule orderReservationSoldOutModule;
        /* access modifiers changed from: private */
        public OrderReservationSoldOutFragment seedInstance;

        private OrderReservationSoldOutFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent build() {
            if (this.orderReservationSoldOutModule == null) {
                this.orderReservationSoldOutModule = new OrderReservationSoldOutModule();
            }
            if (this.seedInstance != null) {
                return new OrderReservationSoldOutFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderReservationSoldOutFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
            this.seedInstance = (OrderReservationSoldOutFragment) Preconditions.checkNotNull(orderReservationSoldOutFragment);
        }
    }

    private final class OrderReservationSoldOutFragmentSubcomponentImpl implements ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent {
        private OrderReservationSoldOutModule orderReservationSoldOutModule;
        private OrderReservationSoldOutFragment seedInstance;

        private OrderReservationSoldOutFragmentSubcomponentImpl(OrderReservationSoldOutFragmentSubcomponentBuilder orderReservationSoldOutFragmentSubcomponentBuilder) {
            initialize(orderReservationSoldOutFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderReservationSoldOutModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderReservationSoldOutModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderReservationSoldOutModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderReservationSoldOutFragmentSubcomponentBuilder orderReservationSoldOutFragmentSubcomponentBuilder) {
            this.orderReservationSoldOutModule = orderReservationSoldOutFragmentSubcomponentBuilder.orderReservationSoldOutModule;
            this.seedInstance = orderReservationSoldOutFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
            injectOrderReservationSoldOutFragment(orderReservationSoldOutFragment);
        }

        private OrderReservationSoldOutFragment injectOrderReservationSoldOutFragment(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
            OrderReservationSoldOutFragment_MembersInjector.injectViewModel(orderReservationSoldOutFragment, getOrderPushRendingViewModel());
            return orderReservationSoldOutFragment;
        }
    }

    private final class OrderShippingCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public OrderShippingCompleteModule orderShippingCompleteModule;
        /* access modifiers changed from: private */
        public OrderShippingCompleteFragment seedInstance;

        private OrderShippingCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent build() {
            if (this.orderShippingCompleteModule == null) {
                this.orderShippingCompleteModule = new OrderShippingCompleteModule();
            }
            if (this.seedInstance != null) {
                return new OrderShippingCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OrderShippingCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(OrderShippingCompleteFragment orderShippingCompleteFragment) {
            this.seedInstance = (OrderShippingCompleteFragment) Preconditions.checkNotNull(orderShippingCompleteFragment);
        }
    }

    private final class OrderShippingCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent {
        private OrderShippingCompleteModule orderShippingCompleteModule;
        private OrderShippingCompleteFragment seedInstance;

        private OrderShippingCompleteFragmentSubcomponentImpl(OrderShippingCompleteFragmentSubcomponentBuilder orderShippingCompleteFragmentSubcomponentBuilder) {
            initialize(orderShippingCompleteFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return OrderShippingCompleteModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.orderShippingCompleteModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return OrderShippingCompleteModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.orderShippingCompleteModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(OrderShippingCompleteFragmentSubcomponentBuilder orderShippingCompleteFragmentSubcomponentBuilder) {
            this.orderShippingCompleteModule = orderShippingCompleteFragmentSubcomponentBuilder.orderShippingCompleteModule;
            this.seedInstance = orderShippingCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(OrderShippingCompleteFragment orderShippingCompleteFragment) {
            injectOrderShippingCompleteFragment(orderShippingCompleteFragment);
        }

        private OrderShippingCompleteFragment injectOrderShippingCompleteFragment(OrderShippingCompleteFragment orderShippingCompleteFragment) {
            OrderShippingCompleteFragment_MembersInjector.injectViewModel(orderShippingCompleteFragment, getOrderPushRendingViewModel());
            return orderShippingCompleteFragment;
        }
    }

    private final class PaymentCancelMisPriceFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public PaymentCancelMisPriceModule paymentCancelMisPriceModule;
        /* access modifiers changed from: private */
        public PaymentCancelMisPriceFragment seedInstance;

        private PaymentCancelMisPriceFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent build() {
            if (this.paymentCancelMisPriceModule == null) {
                this.paymentCancelMisPriceModule = new PaymentCancelMisPriceModule();
            }
            if (this.seedInstance != null) {
                return new PaymentCancelMisPriceFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PaymentCancelMisPriceFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
            this.seedInstance = (PaymentCancelMisPriceFragment) Preconditions.checkNotNull(paymentCancelMisPriceFragment);
        }
    }

    private final class PaymentCancelMisPriceFragmentSubcomponentImpl implements ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent {
        private PaymentCancelMisPriceModule paymentCancelMisPriceModule;
        private PaymentCancelMisPriceFragment seedInstance;

        private PaymentCancelMisPriceFragmentSubcomponentImpl(PaymentCancelMisPriceFragmentSubcomponentBuilder paymentCancelMisPriceFragmentSubcomponentBuilder) {
            initialize(paymentCancelMisPriceFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return PaymentCancelMisPriceModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.paymentCancelMisPriceModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return PaymentCancelMisPriceModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.paymentCancelMisPriceModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(PaymentCancelMisPriceFragmentSubcomponentBuilder paymentCancelMisPriceFragmentSubcomponentBuilder) {
            this.paymentCancelMisPriceModule = paymentCancelMisPriceFragmentSubcomponentBuilder.paymentCancelMisPriceModule;
            this.seedInstance = paymentCancelMisPriceFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
            injectPaymentCancelMisPriceFragment(paymentCancelMisPriceFragment);
        }

        private PaymentCancelMisPriceFragment injectPaymentCancelMisPriceFragment(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
            PaymentCancelMisPriceFragment_MembersInjector.injectViewModel(paymentCancelMisPriceFragment, getOrderPushRendingViewModel());
            return paymentCancelMisPriceFragment;
        }
    }

    private final class PaymentCancelSoldOutFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public PaymentCancelSoldOutModule paymentCancelSoldOutModule;
        /* access modifiers changed from: private */
        public PaymentCancelSoldOutFragment seedInstance;

        private PaymentCancelSoldOutFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent build() {
            if (this.paymentCancelSoldOutModule == null) {
                this.paymentCancelSoldOutModule = new PaymentCancelSoldOutModule();
            }
            if (this.seedInstance != null) {
                return new PaymentCancelSoldOutFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PaymentCancelSoldOutFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
            this.seedInstance = (PaymentCancelSoldOutFragment) Preconditions.checkNotNull(paymentCancelSoldOutFragment);
        }
    }

    private final class PaymentCancelSoldOutFragmentSubcomponentImpl implements ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent {
        private PaymentCancelSoldOutModule paymentCancelSoldOutModule;
        private PaymentCancelSoldOutFragment seedInstance;

        private PaymentCancelSoldOutFragmentSubcomponentImpl(PaymentCancelSoldOutFragmentSubcomponentBuilder paymentCancelSoldOutFragmentSubcomponentBuilder) {
            initialize(paymentCancelSoldOutFragmentSubcomponentBuilder);
        }

        private OrderPushRendingViewModelFactory getOrderPushRendingViewModelFactory() {
            return PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.paymentCancelSoldOutModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private OrderPushRendingViewModel getOrderPushRendingViewModel() {
            return PaymentCancelSoldOutModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.paymentCancelSoldOutModule, this.seedInstance, getOrderPushRendingViewModelFactory());
        }

        private void initialize(PaymentCancelSoldOutFragmentSubcomponentBuilder paymentCancelSoldOutFragmentSubcomponentBuilder) {
            this.paymentCancelSoldOutModule = paymentCancelSoldOutFragmentSubcomponentBuilder.paymentCancelSoldOutModule;
            this.seedInstance = paymentCancelSoldOutFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
            injectPaymentCancelSoldOutFragment(paymentCancelSoldOutFragment);
        }

        private PaymentCancelSoldOutFragment injectPaymentCancelSoldOutFragment(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
            PaymentCancelSoldOutFragment_MembersInjector.injectViewModel(paymentCancelSoldOutFragment, getOrderPushRendingViewModel());
            return paymentCancelSoldOutFragment;
        }
    }

    private final class PaymentModuleActivityComponentBuilder extends kr.co.popone.fitts.di.component.PaymentModuleActivityComponent.Builder {
        private PaymentModuleActivity seedInstance;

        private PaymentModuleActivityComponentBuilder() {
        }

        public PaymentModuleActivityComponent build() {
            if (this.seedInstance != null) {
                return new PaymentModuleActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PaymentModuleActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PaymentModuleActivity paymentModuleActivity) {
            this.seedInstance = (PaymentModuleActivity) Preconditions.checkNotNull(paymentModuleActivity);
        }
    }

    private final class PaymentModuleActivityComponentImpl implements PaymentModuleActivityComponent {
        private PaymentModuleActivityComponentImpl(PaymentModuleActivityComponentBuilder paymentModuleActivityComponentBuilder) {
        }

        public void inject(PaymentModuleActivity paymentModuleActivity) {
            injectPaymentModuleActivity(paymentModuleActivity);
        }

        private PaymentModuleActivity injectPaymentModuleActivity(PaymentModuleActivity paymentModuleActivity) {
            PaymentModuleActivity_MembersInjector.injectPaymentApi(paymentModuleActivity, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return paymentModuleActivity;
        }
    }

    private final class PersonalizedRecommendActivityComponentBuilder extends kr.co.popone.fitts.di.component.PersonalizedRecommendActivityComponent.Builder {
        private PersonalizedRecommendActivity seedInstance;

        private PersonalizedRecommendActivityComponentBuilder() {
        }

        public PersonalizedRecommendActivityComponent build() {
            if (this.seedInstance != null) {
                return new PersonalizedRecommendActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PersonalizedRecommendActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PersonalizedRecommendActivity personalizedRecommendActivity) {
            this.seedInstance = (PersonalizedRecommendActivity) Preconditions.checkNotNull(personalizedRecommendActivity);
        }
    }

    private final class PersonalizedRecommendActivityComponentImpl implements PersonalizedRecommendActivityComponent {
        private PersonalizedRecommendActivityComponentImpl(PersonalizedRecommendActivityComponentBuilder personalizedRecommendActivityComponentBuilder) {
        }

        public void inject(PersonalizedRecommendActivity personalizedRecommendActivity) {
            injectPersonalizedRecommendActivity(personalizedRecommendActivity);
        }

        private PersonalizedRecommendActivity injectPersonalizedRecommendActivity(PersonalizedRecommendActivity personalizedRecommendActivity) {
            PersonalizedRecommendActivity_MembersInjector.injectEventTracker(personalizedRecommendActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            PersonalizedRecommendActivity_MembersInjector.injectSocialRepository(personalizedRecommendActivity, (FittsSocialRepository) DaggerAppComponent.this.provideFittsSocialRepositoryProvider.get());
            PersonalizedRecommendActivity_MembersInjector.injectUserAPI(personalizedRecommendActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            PersonalizedRecommendActivity_MembersInjector.injectActionLogUtil(personalizedRecommendActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            return personalizedRecommendActivity;
        }
    }

    private final class PointHistoryFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public PointHistoryModule pointHistoryModule;
        /* access modifiers changed from: private */
        public PointHistoryFragment seedInstance;

        private PointHistoryFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent build() {
            if (this.pointHistoryModule == null) {
                this.pointHistoryModule = new PointHistoryModule();
            }
            if (this.seedInstance != null) {
                return new PointHistoryFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PointHistoryFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PointHistoryFragment pointHistoryFragment) {
            this.seedInstance = (PointHistoryFragment) Preconditions.checkNotNull(pointHistoryFragment);
        }
    }

    private final class PointHistoryFragmentSubcomponentImpl implements ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent {
        private PointHistoryModule pointHistoryModule;
        private PointHistoryFragment seedInstance;

        private PointHistoryFragmentSubcomponentImpl(PointHistoryFragmentSubcomponentBuilder pointHistoryFragmentSubcomponentBuilder) {
            initialize(pointHistoryFragmentSubcomponentBuilder);
        }

        private NCommerceViewModelFactory getNCommerceViewModelFactory() {
            return PointHistoryModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.pointHistoryModule, (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private NCommerceViewModel getNCommerceViewModel() {
            return PointHistoryModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.pointHistoryModule, this.seedInstance, getNCommerceViewModelFactory());
        }

        private void initialize(PointHistoryFragmentSubcomponentBuilder pointHistoryFragmentSubcomponentBuilder) {
            this.pointHistoryModule = pointHistoryFragmentSubcomponentBuilder.pointHistoryModule;
            this.seedInstance = pointHistoryFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PointHistoryFragment pointHistoryFragment) {
            injectPointHistoryFragment(pointHistoryFragment);
        }

        private PointHistoryFragment injectPointHistoryFragment(PointHistoryFragment pointHistoryFragment) {
            PointHistoryFragment_MembersInjector.injectViewModel(pointHistoryFragment, getNCommerceViewModel());
            return pointHistoryFragment;
        }
    }

    private final class PointRevenueDetailFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public RevenueDetailModule revenueDetailModule;
        /* access modifiers changed from: private */
        public PointRevenueDetailFragment seedInstance;

        private PointRevenueDetailFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent build() {
            if (this.revenueDetailModule == null) {
                this.revenueDetailModule = new RevenueDetailModule();
            }
            if (this.seedInstance != null) {
                return new PointRevenueDetailFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PointRevenueDetailFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PointRevenueDetailFragment pointRevenueDetailFragment) {
            this.seedInstance = (PointRevenueDetailFragment) Preconditions.checkNotNull(pointRevenueDetailFragment);
        }
    }

    private final class PointRevenueDetailFragmentSubcomponentImpl implements ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent {
        private RevenueDetailModule revenueDetailModule;
        private PointRevenueDetailFragment seedInstance;

        private PointRevenueDetailFragmentSubcomponentImpl(PointRevenueDetailFragmentSubcomponentBuilder pointRevenueDetailFragmentSubcomponentBuilder) {
            initialize(pointRevenueDetailFragmentSubcomponentBuilder);
        }

        private NCommerceViewModelFactory getNCommerceViewModelFactory() {
            return RevenueDetailModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.revenueDetailModule, (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private NCommerceViewModel getNCommerceViewModel() {
            return RevenueDetailModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.revenueDetailModule, this.seedInstance, getNCommerceViewModelFactory());
        }

        private void initialize(PointRevenueDetailFragmentSubcomponentBuilder pointRevenueDetailFragmentSubcomponentBuilder) {
            this.revenueDetailModule = pointRevenueDetailFragmentSubcomponentBuilder.revenueDetailModule;
            this.seedInstance = pointRevenueDetailFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PointRevenueDetailFragment pointRevenueDetailFragment) {
            injectPointRevenueDetailFragment(pointRevenueDetailFragment);
        }

        private PointRevenueDetailFragment injectPointRevenueDetailFragment(PointRevenueDetailFragment pointRevenueDetailFragment) {
            PointRevenueDetailFragment_MembersInjector.injectViewModel(pointRevenueDetailFragment, getNCommerceViewModel());
            return pointRevenueDetailFragment;
        }
    }

    private final class PointUsageHistoryFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public PointUsageHistoryModule pointUsageHistoryModule;
        /* access modifiers changed from: private */
        public PointUsageHistoryFragment seedInstance;

        private PointUsageHistoryFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent build() {
            if (this.pointUsageHistoryModule == null) {
                this.pointUsageHistoryModule = new PointUsageHistoryModule();
            }
            if (this.seedInstance != null) {
                return new PointUsageHistoryFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PointUsageHistoryFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PointUsageHistoryFragment pointUsageHistoryFragment) {
            this.seedInstance = (PointUsageHistoryFragment) Preconditions.checkNotNull(pointUsageHistoryFragment);
        }
    }

    private final class PointUsageHistoryFragmentSubcomponentImpl implements ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent {
        private PointUsageHistoryModule pointUsageHistoryModule;
        private PointUsageHistoryFragment seedInstance;

        private PointUsageHistoryFragmentSubcomponentImpl(PointUsageHistoryFragmentSubcomponentBuilder pointUsageHistoryFragmentSubcomponentBuilder) {
            initialize(pointUsageHistoryFragmentSubcomponentBuilder);
        }

        private NCommerceViewModelFactory getNCommerceViewModelFactory() {
            return PointUsageHistoryModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.pointUsageHistoryModule, (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private NCommerceViewModel getNCommerceViewModel() {
            return PointUsageHistoryModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.pointUsageHistoryModule, this.seedInstance, getNCommerceViewModelFactory());
        }

        private void initialize(PointUsageHistoryFragmentSubcomponentBuilder pointUsageHistoryFragmentSubcomponentBuilder) {
            this.pointUsageHistoryModule = pointUsageHistoryFragmentSubcomponentBuilder.pointUsageHistoryModule;
            this.seedInstance = pointUsageHistoryFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PointUsageHistoryFragment pointUsageHistoryFragment) {
            injectPointUsageHistoryFragment(pointUsageHistoryFragment);
        }

        private PointUsageHistoryFragment injectPointUsageHistoryFragment(PointUsageHistoryFragment pointUsageHistoryFragment) {
            PointUsageHistoryFragment_MembersInjector.injectViewModel(pointUsageHistoryFragment, getNCommerceViewModel());
            return pointUsageHistoryFragment;
        }
    }

    private final class PostActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostActivityComponent.Builder {
        private PostActivity seedInstance;

        private PostActivityComponentBuilder() {
        }

        public PostActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostActivity postActivity) {
            this.seedInstance = (PostActivity) Preconditions.checkNotNull(postActivity);
        }
    }

    private final class PostActivityComponentImpl implements PostActivityComponent {
        private PostActivityComponentImpl(PostActivityComponentBuilder postActivityComponentBuilder) {
        }

        public void inject(PostActivity postActivity) {
            injectPostActivity(postActivity);
        }

        private PostActivity injectPostActivity(PostActivity postActivity) {
            PostActivity_MembersInjector.injectEventTracker(postActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            PostActivity_MembersInjector.injectSessionManager(postActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            PostActivity_MembersInjector.injectCreatePostActivityUtil(postActivity, (CreatePostActivityUtil) DaggerAppComponent.this.provideCreatePostActivityUtilProvider.get());
            PostActivity_MembersInjector.injectActionLogUtil(postActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            PostActivity_MembersInjector.injectActionLogAPI(postActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            PostActivity_MembersInjector.injectStoreRepository(postActivity, (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get());
            PostActivity_MembersInjector.injectServiceRepository(postActivity, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
            PostActivity_MembersInjector.injectPostAPI(postActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            PostActivity_MembersInjector.injectUserAPI(postActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return postActivity;
        }
    }

    private final class PostCollectionActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostCollectionActivityComponent.Builder {
        private PostCollectionActivity seedInstance;

        private PostCollectionActivityComponentBuilder() {
        }

        public PostCollectionActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostCollectionActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostCollectionActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostCollectionActivity postCollectionActivity) {
            this.seedInstance = (PostCollectionActivity) Preconditions.checkNotNull(postCollectionActivity);
        }
    }

    private final class PostCollectionActivityComponentImpl implements PostCollectionActivityComponent {
        private PostCollectionActivityComponentImpl(PostCollectionActivityComponentBuilder postCollectionActivityComponentBuilder) {
        }

        public void inject(PostCollectionActivity postCollectionActivity) {
            injectPostCollectionActivity(postCollectionActivity);
        }

        private PostCollectionActivity injectPostCollectionActivity(PostCollectionActivity postCollectionActivity) {
            PostCollectionActivity_MembersInjector.injectCollectionAPI(postCollectionActivity, (CollectionAPI) DaggerAppComponent.this.provideCollectionAPIProvider.get());
            PostCollectionActivity_MembersInjector.injectSchemeHandler(postCollectionActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            PostCollectionActivity_MembersInjector.injectEventTracker(postCollectionActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            PostCollectionActivity_MembersInjector.injectActionLogUtil(postCollectionActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            PostCollectionActivity_MembersInjector.injectActionLogAPI(postCollectionActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            return postCollectionActivity;
        }
    }

    private final class PostDeleteNotificationDetailActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostDeleteNotificationDetailActivityComponent.Builder {
        private PostDeleteNotificationDetailActivity seedInstance;

        private PostDeleteNotificationDetailActivityComponentBuilder() {
        }

        public PostDeleteNotificationDetailActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostDeleteNotificationDetailActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostDeleteNotificationDetailActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
            this.seedInstance = (PostDeleteNotificationDetailActivity) Preconditions.checkNotNull(postDeleteNotificationDetailActivity);
        }
    }

    private final class PostDeleteNotificationDetailActivityComponentImpl implements PostDeleteNotificationDetailActivityComponent {
        private PostDeleteNotificationDetailActivityComponentImpl(PostDeleteNotificationDetailActivityComponentBuilder postDeleteNotificationDetailActivityComponentBuilder) {
        }

        public void inject(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
            injectPostDeleteNotificationDetailActivity(postDeleteNotificationDetailActivity);
        }

        private PostDeleteNotificationDetailActivity injectPostDeleteNotificationDetailActivity(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
            PostDeleteNotificationDetailActivity_MembersInjector.injectPostAPI(postDeleteNotificationDetailActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return postDeleteNotificationDetailActivity;
        }
    }

    private final class PostFirstWriteGuideActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostFirstWriteGuideActivityComponent.Builder {
        private PostFirstWriteGuideActivity seedInstance;

        private PostFirstWriteGuideActivityComponentBuilder() {
        }

        public PostFirstWriteGuideActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostFirstWriteGuideActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostFirstWriteGuideActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostFirstWriteGuideActivity postFirstWriteGuideActivity) {
            this.seedInstance = (PostFirstWriteGuideActivity) Preconditions.checkNotNull(postFirstWriteGuideActivity);
        }
    }

    private final class PostFirstWriteGuideActivityComponentImpl implements PostFirstWriteGuideActivityComponent {
        public void inject(PostFirstWriteGuideActivity postFirstWriteGuideActivity) {
        }

        private PostFirstWriteGuideActivityComponentImpl(DaggerAppComponent daggerAppComponent, PostFirstWriteGuideActivityComponentBuilder postFirstWriteGuideActivityComponentBuilder) {
        }
    }

    private final class PostFirstWriteNoticeActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostFirstWriteNoticeActivityComponent.Builder {
        private PostFirstWriteNoticeActivity seedInstance;

        private PostFirstWriteNoticeActivityComponentBuilder() {
        }

        public PostFirstWriteNoticeActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostFirstWriteNoticeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostFirstWriteNoticeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity) {
            this.seedInstance = (PostFirstWriteNoticeActivity) Preconditions.checkNotNull(postFirstWriteNoticeActivity);
        }
    }

    private final class PostFirstWriteNoticeActivityComponentImpl implements PostFirstWriteNoticeActivityComponent {
        private PostFirstWriteNoticeActivityComponentImpl(PostFirstWriteNoticeActivityComponentBuilder postFirstWriteNoticeActivityComponentBuilder) {
        }

        public void inject(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity) {
            injectPostFirstWriteNoticeActivity(postFirstWriteNoticeActivity);
        }

        private PostFirstWriteNoticeActivity injectPostFirstWriteNoticeActivity(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity) {
            PostFirstWriteNoticeActivity_MembersInjector.injectSchemeHandler(postFirstWriteNoticeActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            return postFirstWriteNoticeActivity;
        }
    }

    private final class PostImageDetailActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostImageDetailActivityComponent.Builder {
        private PostImageDetailActivity seedInstance;

        private PostImageDetailActivityComponentBuilder() {
        }

        public PostImageDetailActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostImageDetailActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostImageDetailActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostImageDetailActivity postImageDetailActivity) {
            this.seedInstance = (PostImageDetailActivity) Preconditions.checkNotNull(postImageDetailActivity);
        }
    }

    private final class PostImageDetailActivityComponentImpl implements PostImageDetailActivityComponent {
        public void inject(PostImageDetailActivity postImageDetailActivity) {
        }

        private PostImageDetailActivityComponentImpl(DaggerAppComponent daggerAppComponent, PostImageDetailActivityComponentBuilder postImageDetailActivityComponentBuilder) {
        }
    }

    private final class PostPreviewComponentBuilder extends kr.co.popone.fitts.di.component.PostPreviewComponent.Builder {
        private PostPreviewActivity seedInstance;

        private PostPreviewComponentBuilder() {
        }

        public PostPreviewComponent build() {
            if (this.seedInstance != null) {
                return new PostPreviewComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostPreviewActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostPreviewActivity postPreviewActivity) {
            this.seedInstance = (PostPreviewActivity) Preconditions.checkNotNull(postPreviewActivity);
        }
    }

    private final class PostPreviewComponentImpl implements PostPreviewComponent {
        private PostPreviewComponentImpl(PostPreviewComponentBuilder postPreviewComponentBuilder) {
        }

        public void inject(PostPreviewActivity postPreviewActivity) {
            injectPostPreviewActivity(postPreviewActivity);
        }

        private PostPreviewActivity injectPostPreviewActivity(PostPreviewActivity postPreviewActivity) {
            PostPreviewActivity_MembersInjector.injectSessionManager(postPreviewActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            PostPreviewActivity_MembersInjector.injectPostAPI(postPreviewActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            PostPreviewActivity_MembersInjector.injectUserAPI(postPreviewActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            PostPreviewActivity_MembersInjector.injectEventTracker(postPreviewActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return postPreviewActivity;
        }
    }

    private final class PostSearchResultFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public PostSearchResultModule postSearchResultModule;
        /* access modifiers changed from: private */
        public PostSearchResultFragment seedInstance;

        private PostSearchResultFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent build() {
            if (this.postSearchResultModule == null) {
                this.postSearchResultModule = new PostSearchResultModule();
            }
            if (this.seedInstance != null) {
                return new PostSearchResultFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostSearchResultFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostSearchResultFragment postSearchResultFragment) {
            this.seedInstance = (PostSearchResultFragment) Preconditions.checkNotNull(postSearchResultFragment);
        }
    }

    private final class PostSearchResultFragmentSubcomponentImpl implements ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent {
        private PostSearchResultModule postSearchResultModule;
        private PostSearchResultFragment seedInstance;

        private PostSearchResultFragmentSubcomponentImpl(PostSearchResultFragmentSubcomponentBuilder postSearchResultFragmentSubcomponentBuilder) {
            initialize(postSearchResultFragmentSubcomponentBuilder);
        }

        private SearchResultViewModelFactory getSearchResultViewModelFactory() {
            return PostSearchResultModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.postSearchResultModule, this.seedInstance, (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private SearchResultViewModel getSearchResultViewModel() {
            return PostSearchResultModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.postSearchResultModule, this.seedInstance, getSearchResultViewModelFactory());
        }

        private void initialize(PostSearchResultFragmentSubcomponentBuilder postSearchResultFragmentSubcomponentBuilder) {
            this.postSearchResultModule = postSearchResultFragmentSubcomponentBuilder.postSearchResultModule;
            this.seedInstance = postSearchResultFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(PostSearchResultFragment postSearchResultFragment) {
            injectPostSearchResultFragment(postSearchResultFragment);
        }

        private PostSearchResultFragment injectPostSearchResultFragment(PostSearchResultFragment postSearchResultFragment) {
            PostSearchResultFragment_MembersInjector.injectViewModel(postSearchResultFragment, getSearchResultViewModel());
            return postSearchResultFragment;
        }
    }

    private final class PostVerificationFinishNoticeActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostVerificationFinishNoticeActivityComponent.Builder {
        private PostVerificationFinishNoticeActivity seedInstance;

        private PostVerificationFinishNoticeActivityComponentBuilder() {
        }

        public PostVerificationFinishNoticeActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostVerificationFinishNoticeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostVerificationFinishNoticeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity) {
            this.seedInstance = (PostVerificationFinishNoticeActivity) Preconditions.checkNotNull(postVerificationFinishNoticeActivity);
        }
    }

    private final class PostVerificationFinishNoticeActivityComponentImpl implements PostVerificationFinishNoticeActivityComponent {
        private PostVerificationFinishNoticeActivityComponentImpl(PostVerificationFinishNoticeActivityComponentBuilder postVerificationFinishNoticeActivityComponentBuilder) {
        }

        public void inject(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity) {
            injectPostVerificationFinishNoticeActivity(postVerificationFinishNoticeActivity);
        }

        private PostVerificationFinishNoticeActivity injectPostVerificationFinishNoticeActivity(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity) {
            PostVerificationFinishNoticeActivity_MembersInjector.injectSchemeHandler(postVerificationFinishNoticeActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            return postVerificationFinishNoticeActivity;
        }
    }

    private final class PostVerificationRejectNoticeActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostVerificationRejectNoticeActivityComponent.Builder {
        private PostVerificationRejectNoticeActivity seedInstance;

        private PostVerificationRejectNoticeActivityComponentBuilder() {
        }

        public PostVerificationRejectNoticeActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostVerificationRejectNoticeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostVerificationRejectNoticeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity) {
            this.seedInstance = (PostVerificationRejectNoticeActivity) Preconditions.checkNotNull(postVerificationRejectNoticeActivity);
        }
    }

    private final class PostVerificationRejectNoticeActivityComponentImpl implements PostVerificationRejectNoticeActivityComponent {
        private PostVerificationRejectNoticeActivityComponentImpl(PostVerificationRejectNoticeActivityComponentBuilder postVerificationRejectNoticeActivityComponentBuilder) {
        }

        public void inject(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity) {
            injectPostVerificationRejectNoticeActivity(postVerificationRejectNoticeActivity);
        }

        private PostVerificationRejectNoticeActivity injectPostVerificationRejectNoticeActivity(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity) {
            PostVerificationRejectNoticeActivity_MembersInjector.injectUserAPI(postVerificationRejectNoticeActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return postVerificationRejectNoticeActivity;
        }
    }

    private final class PostingViolationNoticeActivityComponentBuilder extends kr.co.popone.fitts.di.component.PostingViolationNoticeActivityComponent.Builder {
        private PostingViolationNoticeActivity seedInstance;

        private PostingViolationNoticeActivityComponentBuilder() {
        }

        public PostingViolationNoticeActivityComponent build() {
            if (this.seedInstance != null) {
                return new PostingViolationNoticeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PostingViolationNoticeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PostingViolationNoticeActivity postingViolationNoticeActivity) {
            this.seedInstance = (PostingViolationNoticeActivity) Preconditions.checkNotNull(postingViolationNoticeActivity);
        }
    }

    private final class PostingViolationNoticeActivityComponentImpl implements PostingViolationNoticeActivityComponent {
        private PostingViolationNoticeActivityComponentImpl(PostingViolationNoticeActivityComponentBuilder postingViolationNoticeActivityComponentBuilder) {
        }

        public void inject(PostingViolationNoticeActivity postingViolationNoticeActivity) {
            injectPostingViolationNoticeActivity(postingViolationNoticeActivity);
        }

        private PostingViolationNoticeActivity injectPostingViolationNoticeActivity(PostingViolationNoticeActivity postingViolationNoticeActivity) {
            PostingViolationNoticeActivity_MembersInjector.injectPostAPI(postingViolationNoticeActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return postingViolationNoticeActivity;
        }
    }

    private final class ProductBridgeActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public ProductBridgeModule productBridgeModule;
        /* access modifiers changed from: private */
        public ProductBridgeActivity seedInstance;

        private ProductBridgeActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent build() {
            if (this.productBridgeModule == null) {
                this.productBridgeModule = new ProductBridgeModule();
            }
            if (this.seedInstance != null) {
                return new ProductBridgeActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ProductBridgeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ProductBridgeActivity productBridgeActivity) {
            this.seedInstance = (ProductBridgeActivity) Preconditions.checkNotNull(productBridgeActivity);
        }
    }

    private final class ProductBridgeActivitySubcomponentImpl implements ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent {
        private ProductBridgeModule productBridgeModule;
        private ProductBridgeActivity seedInstance;

        private ProductBridgeActivitySubcomponentImpl(ProductBridgeActivitySubcomponentBuilder productBridgeActivitySubcomponentBuilder) {
            initialize(productBridgeActivitySubcomponentBuilder);
        }

        private ProductBridgeViewModelFactory getProductBridgeViewModelFactory() {
            return ProductBridgeModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.productBridgeModule, (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get(), (PostRepository) DaggerAppComponent.this.providePostRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
        }

        private ProductBridgeViewModel getProductBridgeViewModel() {
            return ProductBridgeModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.productBridgeModule, this.seedInstance, getProductBridgeViewModelFactory());
        }

        private void initialize(ProductBridgeActivitySubcomponentBuilder productBridgeActivitySubcomponentBuilder) {
            this.productBridgeModule = productBridgeActivitySubcomponentBuilder.productBridgeModule;
            this.seedInstance = productBridgeActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(ProductBridgeActivity productBridgeActivity) {
            injectProductBridgeActivity(productBridgeActivity);
        }

        private ProductBridgeActivity injectProductBridgeActivity(ProductBridgeActivity productBridgeActivity) {
            ProductBridgeActivity_MembersInjector.injectViewModel(productBridgeActivity, getProductBridgeViewModel());
            return productBridgeActivity;
        }
    }

    private final class ProductSearchResultFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public ProductSearchResultModule productSearchResultModule;
        /* access modifiers changed from: private */
        public ProductSearchResultFragment seedInstance;

        private ProductSearchResultFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent build() {
            if (this.productSearchResultModule == null) {
                this.productSearchResultModule = new ProductSearchResultModule();
            }
            if (this.seedInstance != null) {
                return new ProductSearchResultFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ProductSearchResultFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ProductSearchResultFragment productSearchResultFragment) {
            this.seedInstance = (ProductSearchResultFragment) Preconditions.checkNotNull(productSearchResultFragment);
        }
    }

    private final class ProductSearchResultFragmentSubcomponentImpl implements ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent {
        private ProductSearchResultModule productSearchResultModule;
        private ProductSearchResultFragment seedInstance;

        private ProductSearchResultFragmentSubcomponentImpl(ProductSearchResultFragmentSubcomponentBuilder productSearchResultFragmentSubcomponentBuilder) {
            initialize(productSearchResultFragmentSubcomponentBuilder);
        }

        private SearchResultViewModelFactory getSearchResultViewModelFactory() {
            return ProductSearchResultModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.productSearchResultModule, this.seedInstance, (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private SearchResultViewModel getSearchResultViewModel() {
            return ProductSearchResultModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.productSearchResultModule, this.seedInstance, getSearchResultViewModelFactory());
        }

        private void initialize(ProductSearchResultFragmentSubcomponentBuilder productSearchResultFragmentSubcomponentBuilder) {
            this.productSearchResultModule = productSearchResultFragmentSubcomponentBuilder.productSearchResultModule;
            this.seedInstance = productSearchResultFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(ProductSearchResultFragment productSearchResultFragment) {
            injectProductSearchResultFragment(productSearchResultFragment);
        }

        private ProductSearchResultFragment injectProductSearchResultFragment(ProductSearchResultFragment productSearchResultFragment) {
            ProductSearchResultFragment_MembersInjector.injectViewModel(productSearchResultFragment, getSearchResultViewModel());
            return productSearchResultFragment;
        }
    }

    private final class ProfileInputActivityComponentBuilder extends kr.co.popone.fitts.di.component.ProfileInputActivityComponent.Builder {
        private ProfileInputActivity seedInstance;

        private ProfileInputActivityComponentBuilder() {
        }

        public ProfileInputActivityComponent build() {
            if (this.seedInstance != null) {
                return new ProfileInputActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ProfileInputActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ProfileInputActivity profileInputActivity) {
            this.seedInstance = (ProfileInputActivity) Preconditions.checkNotNull(profileInputActivity);
        }
    }

    private final class ProfileInputActivityComponentImpl implements ProfileInputActivityComponent {
        private ProfileInputActivityComponentImpl(ProfileInputActivityComponentBuilder profileInputActivityComponentBuilder) {
        }

        public void inject(ProfileInputActivity profileInputActivity) {
            injectProfileInputActivity(profileInputActivity);
        }

        private ProfileInputActivity injectProfileInputActivity(ProfileInputActivity profileInputActivity) {
            ProfileInputActivity_MembersInjector.injectUserAPI(profileInputActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            ProfileInputActivity_MembersInjector.injectPostAPI(profileInputActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            ProfileInputActivity_MembersInjector.injectSessionManager(profileInputActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            ProfileInputActivity_MembersInjector.injectEventTracker(profileInputActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            return profileInputActivity;
        }
    }

    private final class PromotionCollectionActivityComponentBuilder extends kr.co.popone.fitts.di.component.PromotionCollectionActivityComponent.Builder {
        private PromotionCollectionActivity seedInstance;

        private PromotionCollectionActivityComponentBuilder() {
        }

        public PromotionCollectionActivityComponent build() {
            if (this.seedInstance != null) {
                return new PromotionCollectionActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PromotionCollectionActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(PromotionCollectionActivity promotionCollectionActivity) {
            this.seedInstance = (PromotionCollectionActivity) Preconditions.checkNotNull(promotionCollectionActivity);
        }
    }

    private final class PromotionCollectionActivityComponentImpl implements PromotionCollectionActivityComponent {
        private PromotionCollectionActivityComponentImpl(PromotionCollectionActivityComponentBuilder promotionCollectionActivityComponentBuilder) {
        }

        public void inject(PromotionCollectionActivity promotionCollectionActivity) {
            injectPromotionCollectionActivity(promotionCollectionActivity);
        }

        private PromotionCollectionActivity injectPromotionCollectionActivity(PromotionCollectionActivity promotionCollectionActivity) {
            PromotionCollectionActivity_MembersInjector.injectPostAPI(promotionCollectionActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            PromotionCollectionActivity_MembersInjector.injectCollectionAPI(promotionCollectionActivity, (CollectionAPI) DaggerAppComponent.this.provideCollectionAPIProvider.get());
            PromotionCollectionActivity_MembersInjector.injectSchemeHandler(promotionCollectionActivity, (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
            PromotionCollectionActivity_MembersInjector.injectSessionManager(promotionCollectionActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            PromotionCollectionActivity_MembersInjector.injectEventTracker(promotionCollectionActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            PromotionCollectionActivity_MembersInjector.injectActionLogUtil(promotionCollectionActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            PromotionCollectionActivity_MembersInjector.injectActionLogAPI(promotionCollectionActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            PromotionCollectionActivity_MembersInjector.injectUserAPI(promotionCollectionActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return promotionCollectionActivity;
        }
    }

    private final class RefundApplyActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public RefundModule refundModule;
        /* access modifiers changed from: private */
        public RefundApplyActivity seedInstance;

        private RefundApplyActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent build() {
            if (this.refundModule == null) {
                this.refundModule = new RefundModule();
            }
            if (this.seedInstance != null) {
                return new RefundApplyActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RefundApplyActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RefundApplyActivity refundApplyActivity) {
            this.seedInstance = (RefundApplyActivity) Preconditions.checkNotNull(refundApplyActivity);
        }
    }

    private final class RefundApplyActivitySubcomponentImpl implements ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent {
        private RefundModule refundModule;
        private RefundApplyActivity seedInstance;

        private RefundApplyActivitySubcomponentImpl(RefundApplyActivitySubcomponentBuilder refundApplyActivitySubcomponentBuilder) {
            initialize(refundApplyActivitySubcomponentBuilder);
        }

        private RefundViewModelFactory getRefundViewModelFactory() {
            return RefundModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.refundModule, (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get());
        }

        private RefundViewModel getRefundViewModel() {
            return RefundModule_ProvideRefundViewModelFactory.proxyProvideRefundViewModel(this.refundModule, this.seedInstance, getRefundViewModelFactory());
        }

        private void initialize(RefundApplyActivitySubcomponentBuilder refundApplyActivitySubcomponentBuilder) {
            this.refundModule = refundApplyActivitySubcomponentBuilder.refundModule;
            this.seedInstance = refundApplyActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(RefundApplyActivity refundApplyActivity) {
            injectRefundApplyActivity(refundApplyActivity);
        }

        private RefundApplyActivity injectRefundApplyActivity(RefundApplyActivity refundApplyActivity) {
            RefundApplyActivity_MembersInjector.injectViewModel(refundApplyActivity, getRefundViewModel());
            return refundApplyActivity;
        }
    }

    private final class RefundApplyCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public RefundCompleteActivityModule refundCompleteActivityModule;
        /* access modifiers changed from: private */
        public RefundApplyCompleteFragment seedInstance;

        private RefundApplyCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent build() {
            if (this.refundCompleteActivityModule == null) {
                this.refundCompleteActivityModule = new RefundCompleteActivityModule();
            }
            if (this.seedInstance != null) {
                return new RefundApplyCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RefundApplyCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RefundApplyCompleteFragment refundApplyCompleteFragment) {
            this.seedInstance = (RefundApplyCompleteFragment) Preconditions.checkNotNull(refundApplyCompleteFragment);
        }
    }

    private final class RefundApplyCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent {
        private RefundCompleteActivityModule refundCompleteActivityModule;
        private RefundApplyCompleteFragment seedInstance;

        private RefundApplyCompleteFragmentSubcomponentImpl(RefundApplyCompleteFragmentSubcomponentBuilder refundApplyCompleteFragmentSubcomponentBuilder) {
            initialize(refundApplyCompleteFragmentSubcomponentBuilder);
        }

        private RefundDetailViewModelFactory getRefundDetailViewModelFactory() {
            return RefundCompleteActivityModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.refundCompleteActivityModule, (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get());
        }

        private RefundDetailViewModel getRefundDetailViewModel() {
            return RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.refundCompleteActivityModule, this.seedInstance, getRefundDetailViewModelFactory());
        }

        private void initialize(RefundApplyCompleteFragmentSubcomponentBuilder refundApplyCompleteFragmentSubcomponentBuilder) {
            this.refundCompleteActivityModule = refundApplyCompleteFragmentSubcomponentBuilder.refundCompleteActivityModule;
            this.seedInstance = refundApplyCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(RefundApplyCompleteFragment refundApplyCompleteFragment) {
            injectRefundApplyCompleteFragment(refundApplyCompleteFragment);
        }

        private RefundApplyCompleteFragment injectRefundApplyCompleteFragment(RefundApplyCompleteFragment refundApplyCompleteFragment) {
            RefundApplyCompleteFragment_MembersInjector.injectViewModel(refundApplyCompleteFragment, getRefundDetailViewModel());
            return refundApplyCompleteFragment;
        }
    }

    private final class RefundCompleteActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule;
        /* access modifiers changed from: private */
        public RefundCompleteActivity seedInstance;

        private RefundCompleteActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent build() {
            if (this.refundApplyCompleteFragmentModule == null) {
                this.refundApplyCompleteFragmentModule = new RefundApplyCompleteFragmentModule();
            }
            if (this.seedInstance != null) {
                return new RefundCompleteActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RefundCompleteActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RefundCompleteActivity refundCompleteActivity) {
            this.seedInstance = (RefundCompleteActivity) Preconditions.checkNotNull(refundCompleteActivity);
        }
    }

    private final class RefundCompleteActivitySubcomponentImpl implements ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent {
        private RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule;
        private RefundCompleteActivity seedInstance;

        private RefundCompleteActivitySubcomponentImpl(RefundCompleteActivitySubcomponentBuilder refundCompleteActivitySubcomponentBuilder) {
            initialize(refundCompleteActivitySubcomponentBuilder);
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private RefundDetailViewModelFactory getRefundDetailViewModelFactory() {
            return RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.refundApplyCompleteFragmentModule, (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get());
        }

        private RefundDetailViewModel getRefundDetailViewModel() {
            return RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.refundApplyCompleteFragmentModule, this.seedInstance, getRefundDetailViewModelFactory());
        }

        private void initialize(RefundCompleteActivitySubcomponentBuilder refundCompleteActivitySubcomponentBuilder) {
            this.refundApplyCompleteFragmentModule = refundCompleteActivitySubcomponentBuilder.refundApplyCompleteFragmentModule;
            this.seedInstance = refundCompleteActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(RefundCompleteActivity refundCompleteActivity) {
            injectRefundCompleteActivity(refundCompleteActivity);
        }

        private RefundCompleteActivity injectRefundCompleteActivity(RefundCompleteActivity refundCompleteActivity) {
            RefundCompleteActivity_MembersInjector.injectFragmentInjector(refundCompleteActivity, getDispatchingAndroidInjectorOfFragment());
            RefundCompleteActivity_MembersInjector.injectViewModel(refundCompleteActivity, getRefundDetailViewModel());
            return refundCompleteActivity;
        }
    }

    private final class RefundCompleteFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public RefundCompleteFragmentModule refundCompleteFragmentModule;
        /* access modifiers changed from: private */
        public RefundCompleteFragment seedInstance;

        private RefundCompleteFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent build() {
            if (this.refundCompleteFragmentModule == null) {
                this.refundCompleteFragmentModule = new RefundCompleteFragmentModule();
            }
            if (this.seedInstance != null) {
                return new RefundCompleteFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RefundCompleteFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RefundCompleteFragment refundCompleteFragment) {
            this.seedInstance = (RefundCompleteFragment) Preconditions.checkNotNull(refundCompleteFragment);
        }
    }

    private final class RefundCompleteFragmentSubcomponentImpl implements ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent {
        private RefundCompleteFragmentModule refundCompleteFragmentModule;
        private RefundCompleteFragment seedInstance;

        private RefundCompleteFragmentSubcomponentImpl(RefundCompleteFragmentSubcomponentBuilder refundCompleteFragmentSubcomponentBuilder) {
            initialize(refundCompleteFragmentSubcomponentBuilder);
        }

        private RefundDetailViewModelFactory getRefundDetailViewModelFactory() {
            return RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.refundCompleteFragmentModule, (RefundRepository) DaggerAppComponent.this.provideRefundRepositoryProvider.get());
        }

        private RefundDetailViewModel getRefundDetailViewModel() {
            return RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory.proxyProvideExchangeDetailViewModel(this.refundCompleteFragmentModule, this.seedInstance, getRefundDetailViewModelFactory());
        }

        private void initialize(RefundCompleteFragmentSubcomponentBuilder refundCompleteFragmentSubcomponentBuilder) {
            this.refundCompleteFragmentModule = refundCompleteFragmentSubcomponentBuilder.refundCompleteFragmentModule;
            this.seedInstance = refundCompleteFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(RefundCompleteFragment refundCompleteFragment) {
            injectRefundCompleteFragment(refundCompleteFragment);
        }

        private RefundCompleteFragment injectRefundCompleteFragment(RefundCompleteFragment refundCompleteFragment) {
            RefundCompleteFragment_MembersInjector.injectViewModel(refundCompleteFragment, getRefundDetailViewModel());
            return refundCompleteFragment;
        }
    }

    private final class ReportPostComponentBuilder extends kr.co.popone.fitts.di.component.ReportPostComponent.Builder {
        private ReportPostActivity seedInstance;

        private ReportPostComponentBuilder() {
        }

        public ReportPostComponent build() {
            if (this.seedInstance != null) {
                return new ReportPostComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ReportPostActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ReportPostActivity reportPostActivity) {
            this.seedInstance = (ReportPostActivity) Preconditions.checkNotNull(reportPostActivity);
        }
    }

    private final class ReportPostComponentImpl implements ReportPostComponent {
        private ReportPostComponentImpl(ReportPostComponentBuilder reportPostComponentBuilder) {
        }

        public void inject(ReportPostActivity reportPostActivity) {
            injectReportPostActivity(reportPostActivity);
        }

        private ReportPostActivity injectReportPostActivity(ReportPostActivity reportPostActivity) {
            ReportPostActivity_MembersInjector.injectPostAPI(reportPostActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return reportPostActivity;
        }
    }

    private final class ResetPasswordActivityComponentBuilder extends kr.co.popone.fitts.di.component.ResetPasswordActivityComponent.Builder {
        private ResetPasswordActivity seedInstance;

        private ResetPasswordActivityComponentBuilder() {
        }

        public ResetPasswordActivityComponent build() {
            if (this.seedInstance != null) {
                return new ResetPasswordActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ResetPasswordActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ResetPasswordActivity resetPasswordActivity) {
            this.seedInstance = (ResetPasswordActivity) Preconditions.checkNotNull(resetPasswordActivity);
        }
    }

    private final class ResetPasswordActivityComponentImpl implements ResetPasswordActivityComponent {
        private ResetPasswordActivityComponentImpl(ResetPasswordActivityComponentBuilder resetPasswordActivityComponentBuilder) {
        }

        public void inject(ResetPasswordActivity resetPasswordActivity) {
            injectResetPasswordActivity(resetPasswordActivity);
        }

        private ResetPasswordActivity injectResetPasswordActivity(ResetPasswordActivity resetPasswordActivity) {
            ResetPasswordActivity_MembersInjector.injectUserAPI(resetPasswordActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return resetPasswordActivity;
        }
    }

    private final class RewardPointUseActivityComponentBuilder extends kr.co.popone.fitts.di.component.RewardPointUseActivityComponent.Builder {
        private RewardPointUseActivity seedInstance;

        private RewardPointUseActivityComponentBuilder() {
        }

        public RewardPointUseActivityComponent build() {
            if (this.seedInstance != null) {
                return new RewardPointUseActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RewardPointUseActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RewardPointUseActivity rewardPointUseActivity) {
            this.seedInstance = (RewardPointUseActivity) Preconditions.checkNotNull(rewardPointUseActivity);
        }
    }

    private final class RewardPointUseActivityComponentImpl implements RewardPointUseActivityComponent {
        private RewardPointUseActivityComponentImpl(RewardPointUseActivityComponentBuilder rewardPointUseActivityComponentBuilder) {
        }

        public void inject(RewardPointUseActivity rewardPointUseActivity) {
            injectRewardPointUseActivity(rewardPointUseActivity);
        }

        private RewardPointUseActivity injectRewardPointUseActivity(RewardPointUseActivity rewardPointUseActivity) {
            RewardPointUseActivity_MembersInjector.injectUserAPI(rewardPointUseActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            RewardPointUseActivity_MembersInjector.injectPostAPI(rewardPointUseActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            return rewardPointUseActivity;
        }
    }

    private final class RewardPointUseConfirmActivityComponentBuilder extends kr.co.popone.fitts.di.component.RewardPointUseConfirmActivityComponent.Builder {
        private RewardPointUseConfirmActivity seedInstance;

        private RewardPointUseConfirmActivityComponentBuilder() {
        }

        public RewardPointUseConfirmActivityComponent build() {
            if (this.seedInstance != null) {
                return new RewardPointUseConfirmActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RewardPointUseConfirmActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RewardPointUseConfirmActivity rewardPointUseConfirmActivity) {
            this.seedInstance = (RewardPointUseConfirmActivity) Preconditions.checkNotNull(rewardPointUseConfirmActivity);
        }
    }

    private final class RewardPointUseConfirmActivityComponentImpl implements RewardPointUseConfirmActivityComponent {
        private RewardPointUseConfirmActivityComponentImpl(RewardPointUseConfirmActivityComponentBuilder rewardPointUseConfirmActivityComponentBuilder) {
        }

        public void inject(RewardPointUseConfirmActivity rewardPointUseConfirmActivity) {
            injectRewardPointUseConfirmActivity(rewardPointUseConfirmActivity);
        }

        private RewardPointUseConfirmActivity injectRewardPointUseConfirmActivity(RewardPointUseConfirmActivity rewardPointUseConfirmActivity) {
            RewardPointUseConfirmActivity_MembersInjector.injectPaymentAPI(rewardPointUseConfirmActivity, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return rewardPointUseConfirmActivity;
        }
    }

    private final class RewardUsageDetailActivityComponentBuilder extends kr.co.popone.fitts.di.component.RewardUsageDetailActivityComponent.Builder {
        private RewardUsageDetailActivity seedInstance;

        private RewardUsageDetailActivityComponentBuilder() {
        }

        public RewardUsageDetailActivityComponent build() {
            if (this.seedInstance != null) {
                return new RewardUsageDetailActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RewardUsageDetailActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(RewardUsageDetailActivity rewardUsageDetailActivity) {
            this.seedInstance = (RewardUsageDetailActivity) Preconditions.checkNotNull(rewardUsageDetailActivity);
        }
    }

    private final class RewardUsageDetailActivityComponentImpl implements RewardUsageDetailActivityComponent {
        private RewardUsageDetailActivityComponentImpl(RewardUsageDetailActivityComponentBuilder rewardUsageDetailActivityComponentBuilder) {
        }

        public void inject(RewardUsageDetailActivity rewardUsageDetailActivity) {
            injectRewardUsageDetailActivity(rewardUsageDetailActivity);
        }

        private RewardUsageDetailActivity injectRewardUsageDetailActivity(RewardUsageDetailActivity rewardUsageDetailActivity) {
            RewardUsageDetailActivity_MembersInjector.injectPaymentAPI(rewardUsageDetailActivity, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return rewardUsageDetailActivity;
        }
    }

    private final class SearchActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public SearchModule searchModule;
        /* access modifiers changed from: private */
        public SearchActivity seedInstance;

        private SearchActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent build() {
            if (this.searchModule == null) {
                this.searchModule = new SearchModule();
            }
            if (this.seedInstance != null) {
                return new SearchActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SearchActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(SearchActivity searchActivity) {
            this.seedInstance = (SearchActivity) Preconditions.checkNotNull(searchActivity);
        }
    }

    private final class SearchActivitySubcomponentImpl implements ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent {
        private SearchModule searchModule;
        private SearchActivity seedInstance;

        private SearchActivitySubcomponentImpl(SearchActivitySubcomponentBuilder searchActivitySubcomponentBuilder) {
            initialize(searchActivitySubcomponentBuilder);
        }

        private Map<Class<? extends Fragment>, Provider<Factory<? extends Fragment>>> getMapOfClassOfAndProviderOfFactoryOf() {
            return MapBuilder.newMapBuilder(41).put(IntroLoginFragment.class, DaggerAppComponent.this.introLoginFragmentComponentBuilderProvider).put(MeFragment.class, DaggerAppComponent.this.meFragmentComponentBuilderProvider).put(UsedRewardHistoryFragment.class, DaggerAppComponent.this.usedRewardHistoryFragmentComponentBuilderProvider).put(CouponListFragment.class, DaggerAppComponent.this.couponListFragmentComponentBuilderProvider).put(UsedCouponHistoryFragment.class, DaggerAppComponent.this.usedCouponHistoryFragmentComponentBuilderProvider).put(IdentificationWebViewFragment.class, DaggerAppComponent.this.identificationWebViewFragmentComponentBuilderProvider).put(CategorySearchFragment.class, DaggerAppComponent.this.categorySearchFragmentComponentBuilderProvider).put(IdentificationAdditionalInfoFragment.class, DaggerAppComponent.this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider).put(StoreFragment.class, DaggerAppComponent.this.storeFragmentSubcomponentBuilderProvider).put(StoreFeedFragment.class, DaggerAppComponent.this.storeFeedFragmentSubcomponentBuilderProvider).put(HomeFragment.class, DaggerAppComponent.this.homeFragmentSubcomponentBuilderProvider).put(SearchHomeFragment.class, DaggerAppComponent.this.searchHomeFragmentSubcomponentBuilderProvider).put(SearchHistoryFragment.class, DaggerAppComponent.this.searchHistoryFragmentSubcomponentBuilderProvider).put(SearchResultFragment.class, DaggerAppComponent.this.searchResultFragmentSubcomponentBuilderProvider).put(IntergratedSearchResultFragment.class, DaggerAppComponent.this.intergratedSearchResultFragmentSubcomponentBuilderProvider).put(PostSearchResultFragment.class, DaggerAppComponent.this.postSearchResultFragmentSubcomponentBuilderProvider).put(ProductSearchResultFragment.class, DaggerAppComponent.this.productSearchResultFragmentSubcomponentBuilderProvider).put(FittieSearchResultFragment.class, DaggerAppComponent.this.fittieSearchResultFragmentSubcomponentBuilderProvider).put(ExchangeApplyCompleteFragment.class, DaggerAppComponent.this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider).put(ExchangeCompleteFragment.class, DaggerAppComponent.this.exchangeCompleteFragmentSubcomponentBuilderProvider).put(RefundApplyCompleteFragment.class, DaggerAppComponent.this.refundApplyCompleteFragmentSubcomponentBuilderProvider).put(RefundCompleteFragment.class, DaggerAppComponent.this.refundCompleteFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderPaymentFragment.class, DaggerAppComponent.this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider).put(OrderCompleteRenderReservationFragment.class, DaggerAppComponent.this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider).put(OrderReservationCompleteFragment.class, DaggerAppComponent.this.orderReservationCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentRushFragment.class, DaggerAppComponent.this.orderPaymentRushFragmentSubcomponentBuilderProvider).put(OrderCompleteFragment.class, DaggerAppComponent.this.orderCompleteFragmentSubcomponentBuilderProvider).put(OrderPaymentCompleteFragment.class, DaggerAppComponent.this.orderPaymentCompleteFragmentSubcomponentBuilderProvider).put(OrderReservationSoldOutFragment.class, DaggerAppComponent.this.orderReservationSoldOutFragmentSubcomponentBuilderProvider).put(OrderReservationCancelFragment.class, DaggerAppComponent.this.orderReservationCancelFragmentSubcomponentBuilderProvider).put(PaymentCancelMisPriceFragment.class, DaggerAppComponent.this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider).put(PaymentCancelSoldOutFragment.class, DaggerAppComponent.this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider).put(OrderAllCancelFragment.class, DaggerAppComponent.this.orderAllCancelFragmentSubcomponentBuilderProvider).put(OrderPartCancelFragment.class, DaggerAppComponent.this.orderPartCancelFragmentSubcomponentBuilderProvider).put(OrderShippingCompleteFragment.class, DaggerAppComponent.this.orderShippingCompleteFragmentSubcomponentBuilderProvider).put(PointRevenueDetailFragment.class, DaggerAppComponent.this.pointRevenueDetailFragmentSubcomponentBuilderProvider).put(PointHistoryFragment.class, DaggerAppComponent.this.pointHistoryFragmentSubcomponentBuilderProvider).put(PointUsageHistoryFragment.class, DaggerAppComponent.this.pointUsageHistoryFragmentSubcomponentBuilderProvider).put(StoreNewFeedFragment.class, DaggerAppComponent.this.storeNewFeedFragmentSubcomponentBuilderProvider).put(HomeFeedFragment.class, DaggerAppComponent.this.homeFeedFragmentSubcomponentBuilderProvider).put(AlarmFragment.class, DaggerAppComponent.this.alarmFragmentSubcomponentBuilderProvider).build();
        }

        private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
        }

        private SearchViewModelFactory getSearchViewModelFactory() {
            return SearchModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.searchModule, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (SearchHistoryRepository) DaggerAppComponent.this.provideAllSearchHistoryRepositoryProvider.get());
        }

        private SearchViewModel getSearchViewModel() {
            return SearchModule_ProvideHomeViewModelFactory.proxyProvideHomeViewModel(this.searchModule, this.seedInstance, getSearchViewModelFactory());
        }

        private void initialize(SearchActivitySubcomponentBuilder searchActivitySubcomponentBuilder) {
            this.searchModule = searchActivitySubcomponentBuilder.searchModule;
            this.seedInstance = searchActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(SearchActivity searchActivity) {
            injectSearchActivity(searchActivity);
        }

        private SearchActivity injectSearchActivity(SearchActivity searchActivity) {
            SearchActivity_MembersInjector.injectFragmentInjector(searchActivity, getDispatchingAndroidInjectorOfFragment());
            SearchActivity_MembersInjector.injectViewModel(searchActivity, getSearchViewModel());
            return searchActivity;
        }
    }

    private final class SearchHistoryFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public SearchHistoryModule searchHistoryModule;
        /* access modifiers changed from: private */
        public SearchHistoryFragment seedInstance;

        private SearchHistoryFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent build() {
            if (this.searchHistoryModule == null) {
                this.searchHistoryModule = new SearchHistoryModule();
            }
            if (this.seedInstance != null) {
                return new SearchHistoryFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SearchHistoryFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(SearchHistoryFragment searchHistoryFragment) {
            this.seedInstance = (SearchHistoryFragment) Preconditions.checkNotNull(searchHistoryFragment);
        }
    }

    private final class SearchHistoryFragmentSubcomponentImpl implements ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent {
        private SearchHistoryModule searchHistoryModule;
        private SearchHistoryFragment seedInstance;

        private SearchHistoryFragmentSubcomponentImpl(SearchHistoryFragmentSubcomponentBuilder searchHistoryFragmentSubcomponentBuilder) {
            initialize(searchHistoryFragmentSubcomponentBuilder);
        }

        private SearchViewModelFactory getSearchViewModelFactory() {
            return SearchHistoryModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.searchHistoryModule, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (SearchHistoryRepository) DaggerAppComponent.this.provideAllSearchHistoryRepositoryProvider.get());
        }

        private SearchViewModel getSearchViewModel() {
            return SearchHistoryModule_ProvideHomeViewModelFactory.proxyProvideHomeViewModel(this.searchHistoryModule, this.seedInstance, getSearchViewModelFactory());
        }

        private void initialize(SearchHistoryFragmentSubcomponentBuilder searchHistoryFragmentSubcomponentBuilder) {
            this.searchHistoryModule = searchHistoryFragmentSubcomponentBuilder.searchHistoryModule;
            this.seedInstance = searchHistoryFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(SearchHistoryFragment searchHistoryFragment) {
            injectSearchHistoryFragment(searchHistoryFragment);
        }

        private SearchHistoryFragment injectSearchHistoryFragment(SearchHistoryFragment searchHistoryFragment) {
            SearchHistoryFragment_MembersInjector.injectViewModel(searchHistoryFragment, getSearchViewModel());
            return searchHistoryFragment;
        }
    }

    private final class SearchHomeFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public SearchHomeModule searchHomeModule;
        /* access modifiers changed from: private */
        public SearchHomeFragment seedInstance;

        private SearchHomeFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent build() {
            if (this.searchHomeModule == null) {
                this.searchHomeModule = new SearchHomeModule();
            }
            if (this.seedInstance != null) {
                return new SearchHomeFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SearchHomeFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(SearchHomeFragment searchHomeFragment) {
            this.seedInstance = (SearchHomeFragment) Preconditions.checkNotNull(searchHomeFragment);
        }
    }

    private final class SearchHomeFragmentSubcomponentImpl implements ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent {
        private SearchHomeModule searchHomeModule;
        private SearchHomeFragment seedInstance;

        private SearchHomeFragmentSubcomponentImpl(SearchHomeFragmentSubcomponentBuilder searchHomeFragmentSubcomponentBuilder) {
            initialize(searchHomeFragmentSubcomponentBuilder);
        }

        private SearchViewModelFactory getSearchViewModelFactory() {
            return SearchHomeModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.searchHomeModule, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (SearchHistoryRepository) DaggerAppComponent.this.provideAllSearchHistoryRepositoryProvider.get());
        }

        private SearchViewModel getSearchViewModel() {
            return SearchHomeModule_ProvideHomeViewModelFactory.proxyProvideHomeViewModel(this.searchHomeModule, this.seedInstance, getSearchViewModelFactory());
        }

        private void initialize(SearchHomeFragmentSubcomponentBuilder searchHomeFragmentSubcomponentBuilder) {
            this.searchHomeModule = searchHomeFragmentSubcomponentBuilder.searchHomeModule;
            this.seedInstance = searchHomeFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(SearchHomeFragment searchHomeFragment) {
            injectSearchHomeFragment(searchHomeFragment);
        }

        private SearchHomeFragment injectSearchHomeFragment(SearchHomeFragment searchHomeFragment) {
            SearchHomeFragment_MembersInjector.injectViewModel(searchHomeFragment, getSearchViewModel());
            return searchHomeFragment;
        }
    }

    private final class SearchResultFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public SearchResultModule searchResultModule;
        /* access modifiers changed from: private */
        public SearchResultFragment seedInstance;

        private SearchResultFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent build() {
            if (this.searchResultModule == null) {
                this.searchResultModule = new SearchResultModule();
            }
            if (this.seedInstance != null) {
                return new SearchResultFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SearchResultFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(SearchResultFragment searchResultFragment) {
            this.seedInstance = (SearchResultFragment) Preconditions.checkNotNull(searchResultFragment);
        }
    }

    private final class SearchResultFragmentSubcomponentImpl implements ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent {
        private SearchResultModule searchResultModule;
        private SearchResultFragment seedInstance;

        private SearchResultFragmentSubcomponentImpl(SearchResultFragmentSubcomponentBuilder searchResultFragmentSubcomponentBuilder) {
            initialize(searchResultFragmentSubcomponentBuilder);
        }

        private SearchResultViewModelFactory getSearchResultViewModelFactory() {
            return SearchResultModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.searchResultModule, this.seedInstance, (SearchRepository) DaggerAppComponent.this.provideSearchRepositoryProvider.get(), (UserRepository) DaggerAppComponent.this.provideUserRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
        }

        private SearchResultViewModel getSearchResultViewModel() {
            return SearchResultModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.searchResultModule, this.seedInstance, getSearchResultViewModelFactory());
        }

        private void initialize(SearchResultFragmentSubcomponentBuilder searchResultFragmentSubcomponentBuilder) {
            this.searchResultModule = searchResultFragmentSubcomponentBuilder.searchResultModule;
            this.seedInstance = searchResultFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(SearchResultFragment searchResultFragment) {
            injectSearchResultFragment(searchResultFragment);
        }

        private SearchResultFragment injectSearchResultFragment(SearchResultFragment searchResultFragment) {
            SearchResultFragment_MembersInjector.injectViewModel(searchResultFragment, getSearchResultViewModel());
            return searchResultFragment;
        }
    }

    private final class SettingActivityComponentBuilder extends kr.co.popone.fitts.di.component.SettingActivityComponent.Builder {
        private SettingActivity seedInstance;

        private SettingActivityComponentBuilder() {
        }

        public SettingActivityComponent build() {
            if (this.seedInstance != null) {
                return new SettingActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SettingActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(SettingActivity settingActivity) {
            this.seedInstance = (SettingActivity) Preconditions.checkNotNull(settingActivity);
        }
    }

    private final class SettingActivityComponentImpl implements SettingActivityComponent {
        private SettingActivityComponentImpl(SettingActivityComponentBuilder settingActivityComponentBuilder) {
        }

        public void inject(SettingActivity settingActivity) {
            injectSettingActivity(settingActivity);
        }

        private SettingActivity injectSettingActivity(SettingActivity settingActivity) {
            SettingActivity_MembersInjector.injectSessionManager(settingActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            SettingActivity_MembersInjector.injectUserAPI(settingActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return settingActivity;
        }
    }

    private final class ShopBookmarkActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public ShopBookmarkActivity seedInstance;
        /* access modifiers changed from: private */
        public ShopBookmarkModule shopBookmarkModule;

        private ShopBookmarkActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent build() {
            if (this.shopBookmarkModule == null) {
                this.shopBookmarkModule = new ShopBookmarkModule();
            }
            if (this.seedInstance != null) {
                return new ShopBookmarkActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ShopBookmarkActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ShopBookmarkActivity shopBookmarkActivity) {
            this.seedInstance = (ShopBookmarkActivity) Preconditions.checkNotNull(shopBookmarkActivity);
        }
    }

    private final class ShopBookmarkActivitySubcomponentImpl implements ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent {
        private ShopBookmarkActivity seedInstance;
        private ShopBookmarkModule shopBookmarkModule;

        private ShopBookmarkActivitySubcomponentImpl(ShopBookmarkActivitySubcomponentBuilder shopBookmarkActivitySubcomponentBuilder) {
            initialize(shopBookmarkActivitySubcomponentBuilder);
        }

        private ShopBookmarkViewModelFactory getShopBookmarkViewModelFactory() {
            return ShopBookmarkModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.shopBookmarkModule, (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private ShopBookmarkViewModel getShopBookmarkViewModel() {
            return ShopBookmarkModule_ProvideStoreHomeViewModelFactory.proxyProvideStoreHomeViewModel(this.shopBookmarkModule, this.seedInstance, getShopBookmarkViewModelFactory());
        }

        private void initialize(ShopBookmarkActivitySubcomponentBuilder shopBookmarkActivitySubcomponentBuilder) {
            this.shopBookmarkModule = shopBookmarkActivitySubcomponentBuilder.shopBookmarkModule;
            this.seedInstance = shopBookmarkActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(ShopBookmarkActivity shopBookmarkActivity) {
            injectShopBookmarkActivity(shopBookmarkActivity);
        }

        private ShopBookmarkActivity injectShopBookmarkActivity(ShopBookmarkActivity shopBookmarkActivity) {
            ShopBookmarkActivity_MembersInjector.injectViewModel(shopBookmarkActivity, getShopBookmarkViewModel());
            return shopBookmarkActivity;
        }
    }

    private final class ShopBridgeActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public ShopBridgeActivity seedInstance;
        /* access modifiers changed from: private */
        public StoreBridgeModule storeBridgeModule;

        private ShopBridgeActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent build() {
            if (this.storeBridgeModule == null) {
                this.storeBridgeModule = new StoreBridgeModule();
            }
            if (this.seedInstance != null) {
                return new ShopBridgeActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ShopBridgeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ShopBridgeActivity shopBridgeActivity) {
            this.seedInstance = (ShopBridgeActivity) Preconditions.checkNotNull(shopBridgeActivity);
        }
    }

    private final class ShopBridgeActivitySubcomponentImpl implements ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent {
        private ShopBridgeActivity seedInstance;
        private StoreBridgeModule storeBridgeModule;

        private ShopBridgeActivitySubcomponentImpl(ShopBridgeActivitySubcomponentBuilder shopBridgeActivitySubcomponentBuilder) {
            initialize(shopBridgeActivitySubcomponentBuilder);
        }

        private StoreBridgeViewModelFactory getStoreBridgeViewModelFactory() {
            return StoreBridgeModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.storeBridgeModule, this.seedInstance, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get(), (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private ShopBridgeViewModel getShopBridgeViewModel() {
            return StoreBridgeModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.storeBridgeModule, this.seedInstance, getStoreBridgeViewModelFactory());
        }

        private void initialize(ShopBridgeActivitySubcomponentBuilder shopBridgeActivitySubcomponentBuilder) {
            this.storeBridgeModule = shopBridgeActivitySubcomponentBuilder.storeBridgeModule;
            this.seedInstance = shopBridgeActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(ShopBridgeActivity shopBridgeActivity) {
            injectShopBridgeActivity(shopBridgeActivity);
        }

        private ShopBridgeActivity injectShopBridgeActivity(ShopBridgeActivity shopBridgeActivity) {
            ShopBridgeActivity_MembersInjector.injectVm(shopBridgeActivity, getShopBridgeViewModel());
            return shopBridgeActivity;
        }
    }

    private final class ShopSearchActivityComponentBuilder extends kr.co.popone.fitts.di.component.ShopSearchActivityComponent.Builder {
        private ShopSearchActivity seedInstance;

        private ShopSearchActivityComponentBuilder() {
        }

        public ShopSearchActivityComponent build() {
            if (this.seedInstance != null) {
                return new ShopSearchActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ShopSearchActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ShopSearchActivity shopSearchActivity) {
            this.seedInstance = (ShopSearchActivity) Preconditions.checkNotNull(shopSearchActivity);
        }
    }

    private final class ShopSearchActivityComponentImpl implements ShopSearchActivityComponent {
        private ShopSearchActivityComponentImpl(ShopSearchActivityComponentBuilder shopSearchActivityComponentBuilder) {
        }

        public void inject(ShopSearchActivity shopSearchActivity) {
            injectShopSearchActivity(shopSearchActivity);
        }

        private ShopSearchActivity injectShopSearchActivity(ShopSearchActivity shopSearchActivity) {
            ShopSearchActivity_MembersInjector.injectSearchAPI(shopSearchActivity, (SearchAPI) DaggerAppComponent.this.provideSearchAPIProvider.get());
            ShopSearchActivity_MembersInjector.injectSearchHistoryRepository(shopSearchActivity, (SearchHistoryRepository) DaggerAppComponent.this.provideShopSearchHistoryRepositoryProvider.get());
            return shopSearchActivity;
        }
    }

    private final class ShopWebViewActivityComponentBuilder extends kr.co.popone.fitts.di.component.ShopWebViewActivityComponent.Builder {
        private ShopWebViewActivity seedInstance;

        private ShopWebViewActivityComponentBuilder() {
        }

        public ShopWebViewActivityComponent build() {
            if (this.seedInstance != null) {
                return new ShopWebViewActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ShopWebViewActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ShopWebViewActivity shopWebViewActivity) {
            this.seedInstance = (ShopWebViewActivity) Preconditions.checkNotNull(shopWebViewActivity);
        }
    }

    private final class ShopWebViewActivityComponentImpl implements ShopWebViewActivityComponent {
        private ShopWebViewActivityComponentImpl(ShopWebViewActivityComponentBuilder shopWebViewActivityComponentBuilder) {
        }

        public void inject(ShopWebViewActivity shopWebViewActivity) {
            injectShopWebViewActivity(shopWebViewActivity);
        }

        private ShopWebViewActivity injectShopWebViewActivity(ShopWebViewActivity shopWebViewActivity) {
            ShopWebViewActivity_MembersInjector.injectUserAPI(shopWebViewActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return shopWebViewActivity;
        }
    }

    private final class ShowRoomActivityComponentBuilder extends kr.co.popone.fitts.di.component.ShowRoomActivityComponent.Builder {
        private ShowRoomActivity seedInstance;

        private ShowRoomActivityComponentBuilder() {
        }

        public ShowRoomActivityComponent build() {
            if (this.seedInstance != null) {
                return new ShowRoomActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ShowRoomActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(ShowRoomActivity showRoomActivity) {
            this.seedInstance = (ShowRoomActivity) Preconditions.checkNotNull(showRoomActivity);
        }
    }

    private final class ShowRoomActivityComponentImpl implements ShowRoomActivityComponent {
        private ShowRoomActivityComponentImpl(ShowRoomActivityComponentBuilder showRoomActivityComponentBuilder) {
        }

        public void inject(ShowRoomActivity showRoomActivity) {
            injectShowRoomActivity(showRoomActivity);
        }

        private ShowRoomActivity injectShowRoomActivity(ShowRoomActivity showRoomActivity) {
            ShowRoomActivity_MembersInjector.injectUserAPI(showRoomActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            ShowRoomActivity_MembersInjector.injectPostAPI(showRoomActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            ShowRoomActivity_MembersInjector.injectEventTracker(showRoomActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            ShowRoomActivity_MembersInjector.injectSessionManager(showRoomActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            ShowRoomActivity_MembersInjector.injectCreatePostActivityUtil(showRoomActivity, (CreatePostActivityUtil) DaggerAppComponent.this.provideCreatePostActivityUtilProvider.get());
            ShowRoomActivity_MembersInjector.injectActionLogUtil(showRoomActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            ShowRoomActivity_MembersInjector.injectActionLogAPI(showRoomActivity, (ActionLogAPI) DaggerAppComponent.this.provideActionLogAPIProvider.get());
            return showRoomActivity;
        }
    }

    private final class StoreBrowserActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public StoreBrowserActivity seedInstance;
        /* access modifiers changed from: private */
        public StoreBrowserModule storeBrowserModule;

        private StoreBrowserActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent build() {
            if (this.storeBrowserModule == null) {
                this.storeBrowserModule = new StoreBrowserModule();
            }
            if (this.seedInstance != null) {
                return new StoreBrowserActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(StoreBrowserActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(StoreBrowserActivity storeBrowserActivity) {
            this.seedInstance = (StoreBrowserActivity) Preconditions.checkNotNull(storeBrowserActivity);
        }
    }

    private final class StoreBrowserActivitySubcomponentImpl implements ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent {
        private StoreBrowserActivity seedInstance;
        private StoreBrowserModule storeBrowserModule;

        private StoreBrowserActivitySubcomponentImpl(StoreBrowserActivitySubcomponentBuilder storeBrowserActivitySubcomponentBuilder) {
            initialize(storeBrowserActivitySubcomponentBuilder);
        }

        private StoreBrowserViewModelFactory getStoreBrowserViewModelFactory() {
            return StoreBrowserModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.storeBrowserModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (ProductRepository) DaggerAppComponent.this.provideProductRepositoryProvider.get(), (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get(), (CartRepository) DaggerAppComponent.this.provideCartRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get());
        }

        private StoreBrowserViewModel getStoreBrowserViewModel() {
            return StoreBrowserModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.storeBrowserModule, this.seedInstance, getStoreBrowserViewModelFactory());
        }

        private void initialize(StoreBrowserActivitySubcomponentBuilder storeBrowserActivitySubcomponentBuilder) {
            this.storeBrowserModule = storeBrowserActivitySubcomponentBuilder.storeBrowserModule;
            this.seedInstance = storeBrowserActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(StoreBrowserActivity storeBrowserActivity) {
            injectStoreBrowserActivity(storeBrowserActivity);
        }

        private StoreBrowserActivity injectStoreBrowserActivity(StoreBrowserActivity storeBrowserActivity) {
            StoreBrowserActivity_MembersInjector.injectViewModel(storeBrowserActivity, getStoreBrowserViewModel());
            return storeBrowserActivity;
        }
    }

    private final class StoreFeedFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public StoreFeedFragment seedInstance;
        /* access modifiers changed from: private */
        public StoreFeedViewModelModule storeFeedViewModelModule;

        private StoreFeedFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent build() {
            if (this.storeFeedViewModelModule == null) {
                this.storeFeedViewModelModule = new StoreFeedViewModelModule();
            }
            if (this.seedInstance != null) {
                return new StoreFeedFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(StoreFeedFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(StoreFeedFragment storeFeedFragment) {
            this.seedInstance = (StoreFeedFragment) Preconditions.checkNotNull(storeFeedFragment);
        }
    }

    private final class StoreFeedFragmentSubcomponentImpl implements ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent {
        private StoreFeedFragment seedInstance;
        private StoreFeedViewModelModule storeFeedViewModelModule;

        private StoreFeedFragmentSubcomponentImpl(StoreFeedFragmentSubcomponentBuilder storeFeedFragmentSubcomponentBuilder) {
            initialize(storeFeedFragmentSubcomponentBuilder);
        }

        private StoreFeedViewModelFactory getStoreFeedViewModelFactory() {
            return StoreFeedViewModelModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.storeFeedViewModelModule, this.seedInstance, (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get(), (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get(), (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
        }

        private StoreFeedViewModel getStoreFeedViewModel() {
            return StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory.proxyProvideStoreHomeViewModel(this.storeFeedViewModelModule, this.seedInstance, getStoreFeedViewModelFactory());
        }

        private void initialize(StoreFeedFragmentSubcomponentBuilder storeFeedFragmentSubcomponentBuilder) {
            this.storeFeedViewModelModule = storeFeedFragmentSubcomponentBuilder.storeFeedViewModelModule;
            this.seedInstance = storeFeedFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(StoreFeedFragment storeFeedFragment) {
            injectStoreFeedFragment(storeFeedFragment);
        }

        private StoreFeedFragment injectStoreFeedFragment(StoreFeedFragment storeFeedFragment) {
            StoreFeedFragment_MembersInjector.injectVm(storeFeedFragment, getStoreFeedViewModel());
            return storeFeedFragment;
        }
    }

    private final class StoreFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public StoreFragment seedInstance;
        /* access modifiers changed from: private */
        public StoreModule storeModule;

        private StoreFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent build() {
            if (this.storeModule == null) {
                this.storeModule = new StoreModule();
            }
            if (this.seedInstance != null) {
                return new StoreFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(StoreFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(StoreFragment storeFragment) {
            this.seedInstance = (StoreFragment) Preconditions.checkNotNull(storeFragment);
        }
    }

    private final class StoreFragmentSubcomponentImpl implements ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent {
        private StoreFragment seedInstance;
        private StoreModule storeModule;

        private StoreFragmentSubcomponentImpl(StoreFragmentSubcomponentBuilder storeFragmentSubcomponentBuilder) {
            initialize(storeFragmentSubcomponentBuilder);
        }

        private StoreViewModelFactory getStoreViewModelFactory() {
            return StoreModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.storeModule, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get());
        }

        private StoreViewModel getStoreViewModel() {
            return StoreModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.storeModule, this.seedInstance, getStoreViewModelFactory());
        }

        private void initialize(StoreFragmentSubcomponentBuilder storeFragmentSubcomponentBuilder) {
            this.storeModule = storeFragmentSubcomponentBuilder.storeModule;
            this.seedInstance = storeFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(StoreFragment storeFragment) {
            injectStoreFragment(storeFragment);
        }

        private StoreFragment injectStoreFragment(StoreFragment storeFragment) {
            StoreFragment_MembersInjector.injectViewModel(storeFragment, getStoreViewModel());
            return storeFragment;
        }
    }

    private final class StoreNewFeedFragmentSubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent.Builder {
        /* access modifiers changed from: private */
        public NewestProductViewModelModule newestProductViewModelModule;
        /* access modifiers changed from: private */
        public StoreNewFeedFragment seedInstance;

        private StoreNewFeedFragmentSubcomponentBuilder() {
        }

        public ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent build() {
            if (this.newestProductViewModelModule == null) {
                this.newestProductViewModelModule = new NewestProductViewModelModule();
            }
            if (this.seedInstance != null) {
                return new StoreNewFeedFragmentSubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(StoreNewFeedFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(StoreNewFeedFragment storeNewFeedFragment) {
            this.seedInstance = (StoreNewFeedFragment) Preconditions.checkNotNull(storeNewFeedFragment);
        }
    }

    private final class StoreNewFeedFragmentSubcomponentImpl implements ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent {
        private NewestProductViewModelModule newestProductViewModelModule;
        private StoreNewFeedFragment seedInstance;

        private StoreNewFeedFragmentSubcomponentImpl(StoreNewFeedFragmentSubcomponentBuilder storeNewFeedFragmentSubcomponentBuilder) {
            initialize(storeNewFeedFragmentSubcomponentBuilder);
        }

        private NewestProductViewModelFactory getNewestProductViewModelFactory() {
            return NewestProductViewModelModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.newestProductViewModelModule, (StoreRepository) DaggerAppComponent.this.provideStoreRepositoryProvider.get(), (FittsServiceRepository) DaggerAppComponent.this.provideFittsServiceRepositoryProvider.get(), (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private NewestProductViewModel getNewestProductViewModel() {
            return NewestProductViewModelModule_ProvideHomeFeedViewModelFactory.proxyProvideHomeFeedViewModel(this.newestProductViewModelModule, this.seedInstance, getNewestProductViewModelFactory());
        }

        private void initialize(StoreNewFeedFragmentSubcomponentBuilder storeNewFeedFragmentSubcomponentBuilder) {
            this.newestProductViewModelModule = storeNewFeedFragmentSubcomponentBuilder.newestProductViewModelModule;
            this.seedInstance = storeNewFeedFragmentSubcomponentBuilder.seedInstance;
        }

        public void inject(StoreNewFeedFragment storeNewFeedFragment) {
            injectStoreNewFeedFragment(storeNewFeedFragment);
        }

        private StoreNewFeedFragment injectStoreNewFeedFragment(StoreNewFeedFragment storeNewFeedFragment) {
            StoreNewFeedFragment_MembersInjector.injectVm(storeNewFeedFragment, getNewestProductViewModel());
            return storeNewFeedFragment;
        }
    }

    private final class TagSearchActivityComponentBuilder extends kr.co.popone.fitts.di.component.TagSearchActivityComponent.Builder {
        private TagSearchActivity seedInstance;

        private TagSearchActivityComponentBuilder() {
        }

        public TagSearchActivityComponent build() {
            if (this.seedInstance != null) {
                return new TagSearchActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TagSearchActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(TagSearchActivity tagSearchActivity) {
            this.seedInstance = (TagSearchActivity) Preconditions.checkNotNull(tagSearchActivity);
        }
    }

    private final class TagSearchActivityComponentImpl implements TagSearchActivityComponent {
        private TagSearchActivityComponentImpl(TagSearchActivityComponentBuilder tagSearchActivityComponentBuilder) {
        }

        public void inject(TagSearchActivity tagSearchActivity) {
            injectTagSearchActivity(tagSearchActivity);
        }

        private TagSearchActivity injectTagSearchActivity(TagSearchActivity tagSearchActivity) {
            TagSearchActivity_MembersInjector.injectEventTracker(tagSearchActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            TagSearchActivity_MembersInjector.injectPostAPI(tagSearchActivity, (PostAPI) DaggerAppComponent.this.providePostAPIProvider.get());
            TagSearchActivity_MembersInjector.injectActionLogUtil(tagSearchActivity, (ActionLogUtil) DaggerAppComponent.this.provideActionLogUtilProvider.get());
            return tagSearchActivity;
        }
    }

    private final class TermsAgreeActivityComponentBuilder extends kr.co.popone.fitts.di.component.TermsAgreeActivityComponent.Builder {
        private TermsAgreeWebViewActivity seedInstance;

        private TermsAgreeActivityComponentBuilder() {
        }

        public TermsAgreeActivityComponent build() {
            if (this.seedInstance != null) {
                return new TermsAgreeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TermsAgreeWebViewActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(TermsAgreeWebViewActivity termsAgreeWebViewActivity) {
            this.seedInstance = (TermsAgreeWebViewActivity) Preconditions.checkNotNull(termsAgreeWebViewActivity);
        }
    }

    private final class TermsAgreeActivityComponentImpl implements TermsAgreeActivityComponent {
        private TermsAgreeActivityComponentImpl(TermsAgreeActivityComponentBuilder termsAgreeActivityComponentBuilder) {
        }

        public void inject(TermsAgreeWebViewActivity termsAgreeWebViewActivity) {
            injectTermsAgreeWebViewActivity(termsAgreeWebViewActivity);
        }

        private TermsAgreeWebViewActivity injectTermsAgreeWebViewActivity(TermsAgreeWebViewActivity termsAgreeWebViewActivity) {
            TermsAgreeWebViewActivity_MembersInjector.injectCouponAPI(termsAgreeWebViewActivity, (CouponAPI) DaggerAppComponent.this.provideCouponAPIProvider.get());
            return termsAgreeWebViewActivity;
        }
    }

    private final class TrendFeedActivitySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent.Builder {
        /* access modifiers changed from: private */
        public TrendFeedActivity seedInstance;
        /* access modifiers changed from: private */
        public TrendFeedModule trendFeedModule;

        private TrendFeedActivitySubcomponentBuilder() {
        }

        public ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent build() {
            if (this.trendFeedModule == null) {
                this.trendFeedModule = new TrendFeedModule();
            }
            if (this.seedInstance != null) {
                return new TrendFeedActivitySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TrendFeedActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(TrendFeedActivity trendFeedActivity) {
            this.seedInstance = (TrendFeedActivity) Preconditions.checkNotNull(trendFeedActivity);
        }
    }

    private final class TrendFeedActivitySubcomponentImpl implements ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent {
        private TrendFeedActivity seedInstance;
        private TrendFeedModule trendFeedModule;

        private TrendFeedActivitySubcomponentImpl(TrendFeedActivitySubcomponentBuilder trendFeedActivitySubcomponentBuilder) {
            initialize(trendFeedActivitySubcomponentBuilder);
        }

        private TrendFeedViewModelFactory getTrendFeedViewModelFactory() {
            return TrendFeedModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.trendFeedModule, this.seedInstance, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get(), (FittsSchemeHandler) DaggerAppComponent.this.provideSchemeHandlerProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get(), (FittsSocialRepository) DaggerAppComponent.this.provideFittsSocialRepositoryProvider.get());
        }

        private TrendFeedViewModel getTrendFeedViewModel() {
            return TrendFeedModule_ProvideStoreViewModelFactory.proxyProvideStoreViewModel(this.trendFeedModule, this.seedInstance, getTrendFeedViewModelFactory());
        }

        private void initialize(TrendFeedActivitySubcomponentBuilder trendFeedActivitySubcomponentBuilder) {
            this.trendFeedModule = trendFeedActivitySubcomponentBuilder.trendFeedModule;
            this.seedInstance = trendFeedActivitySubcomponentBuilder.seedInstance;
        }

        public void inject(TrendFeedActivity trendFeedActivity) {
            injectTrendFeedActivity(trendFeedActivity);
        }

        private TrendFeedActivity injectTrendFeedActivity(TrendFeedActivity trendFeedActivity) {
            TrendFeedActivity_MembersInjector.injectVm(trendFeedActivity, getTrendFeedViewModel());
            return trendFeedActivity;
        }
    }

    private final class UsedCouponHistoryFragmentComponentBuilder extends kr.co.popone.fitts.di.component.UsedCouponHistoryFragmentComponent.Builder {
        private UsedCouponHistoryFragment seedInstance;

        private UsedCouponHistoryFragmentComponentBuilder() {
        }

        public UsedCouponHistoryFragmentComponent build() {
            if (this.seedInstance != null) {
                return new UsedCouponHistoryFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UsedCouponHistoryFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(UsedCouponHistoryFragment usedCouponHistoryFragment) {
            this.seedInstance = (UsedCouponHistoryFragment) Preconditions.checkNotNull(usedCouponHistoryFragment);
        }
    }

    private final class UsedCouponHistoryFragmentComponentImpl implements UsedCouponHistoryFragmentComponent {
        private UsedCouponHistoryFragmentComponentImpl(UsedCouponHistoryFragmentComponentBuilder usedCouponHistoryFragmentComponentBuilder) {
        }

        public void inject(UsedCouponHistoryFragment usedCouponHistoryFragment) {
            injectUsedCouponHistoryFragment(usedCouponHistoryFragment);
        }

        private UsedCouponHistoryFragment injectUsedCouponHistoryFragment(UsedCouponHistoryFragment usedCouponHistoryFragment) {
            UsedCouponHistoryFragment_MembersInjector.injectPaymentAPI(usedCouponHistoryFragment, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return usedCouponHistoryFragment;
        }
    }

    private final class UsedRewardHistoryFragmentComponentBuilder extends kr.co.popone.fitts.di.component.UsedRewardHistoryFragmentComponent.Builder {
        private UsedRewardHistoryFragment seedInstance;

        private UsedRewardHistoryFragmentComponentBuilder() {
        }

        public UsedRewardHistoryFragmentComponent build() {
            if (this.seedInstance != null) {
                return new UsedRewardHistoryFragmentComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UsedRewardHistoryFragment.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(UsedRewardHistoryFragment usedRewardHistoryFragment) {
            this.seedInstance = (UsedRewardHistoryFragment) Preconditions.checkNotNull(usedRewardHistoryFragment);
        }
    }

    private final class UsedRewardHistoryFragmentComponentImpl implements UsedRewardHistoryFragmentComponent {
        private UsedRewardHistoryFragmentComponentImpl(UsedRewardHistoryFragmentComponentBuilder usedRewardHistoryFragmentComponentBuilder) {
        }

        public void inject(UsedRewardHistoryFragment usedRewardHistoryFragment) {
            injectUsedRewardHistoryFragment(usedRewardHistoryFragment);
        }

        private UsedRewardHistoryFragment injectUsedRewardHistoryFragment(UsedRewardHistoryFragment usedRewardHistoryFragment) {
            UsedRewardHistoryFragment_MembersInjector.injectPaymentAPI(usedRewardHistoryFragment, (PaymentAPI) DaggerAppComponent.this.providePaymentAPIProvider.get());
            return usedRewardHistoryFragment;
        }
    }

    private final class UserSizeInputActivityComponentBuilder extends kr.co.popone.fitts.di.component.UserSizeInputActivityComponent.Builder {
        private UserSizeInputActivity seedInstance;

        private UserSizeInputActivityComponentBuilder() {
        }

        public UserSizeInputActivityComponent build() {
            if (this.seedInstance != null) {
                return new UserSizeInputActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UserSizeInputActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(UserSizeInputActivity userSizeInputActivity) {
            this.seedInstance = (UserSizeInputActivity) Preconditions.checkNotNull(userSizeInputActivity);
        }
    }

    private final class UserSizeInputActivityComponentImpl implements UserSizeInputActivityComponent {
        private UserSizeInputActivityComponentImpl(UserSizeInputActivityComponentBuilder userSizeInputActivityComponentBuilder) {
        }

        public void inject(UserSizeInputActivity userSizeInputActivity) {
            injectUserSizeInputActivity(userSizeInputActivity);
        }

        private UserSizeInputActivity injectUserSizeInputActivity(UserSizeInputActivity userSizeInputActivity) {
            UserSizeInputActivity_MembersInjector.injectUserAPI(userSizeInputActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            return userSizeInputActivity;
        }
    }

    private final class WebComponentBuilder extends kr.co.popone.fitts.di.component.WebComponent.Builder {
        private WebActivity seedInstance;

        private WebComponentBuilder() {
        }

        public WebComponent build() {
            if (this.seedInstance != null) {
                return new WebComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(WebActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(WebActivity webActivity) {
            this.seedInstance = (WebActivity) Preconditions.checkNotNull(webActivity);
        }
    }

    private final class WebComponentImpl implements WebComponent {
        public void inject(WebActivity webActivity) {
        }

        private WebComponentImpl(DaggerAppComponent daggerAppComponent, WebComponentBuilder webComponentBuilder) {
        }
    }

    private final class WelcomeActivityComponentBuilder extends kr.co.popone.fitts.di.component.WelcomeActivityComponent.Builder {
        private WelcomeActivity seedInstance;

        private WelcomeActivityComponentBuilder() {
        }

        public WelcomeActivityComponent build() {
            if (this.seedInstance != null) {
                return new WelcomeActivityComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(WelcomeActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(WelcomeActivity welcomeActivity) {
            this.seedInstance = (WelcomeActivity) Preconditions.checkNotNull(welcomeActivity);
        }
    }

    private final class WelcomeActivityComponentImpl implements WelcomeActivityComponent {
        private WelcomeActivityComponentImpl(WelcomeActivityComponentBuilder welcomeActivityComponentBuilder) {
        }

        public void inject(WelcomeActivity welcomeActivity) {
            injectWelcomeActivity(welcomeActivity);
        }

        private WelcomeActivity injectWelcomeActivity(WelcomeActivity welcomeActivity) {
            WelcomeActivity_MembersInjector.injectSessionManager(welcomeActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            WelcomeActivity_MembersInjector.injectUserAPI(welcomeActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            WelcomeActivity_MembersInjector.injectEventTracker(welcomeActivity, (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
            WelcomeActivity_MembersInjector.injectCreatePostActivityUtil(welcomeActivity, (CreatePostActivityUtil) DaggerAppComponent.this.provideCreatePostActivityUtilProvider.get());
            return welcomeActivity;
        }
    }

    private final class WishListActvititySubcomponentBuilder extends kr.co.popone.fitts.di.module.ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent.Builder {
        /* access modifiers changed from: private */
        public WishListActvitity seedInstance;
        /* access modifiers changed from: private */
        public WishListModule wishListModule;

        private WishListActvititySubcomponentBuilder() {
        }

        public ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent build() {
            if (this.wishListModule == null) {
                this.wishListModule = new WishListModule();
            }
            if (this.seedInstance != null) {
                return new WishListActvititySubcomponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(WishListActvitity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(WishListActvitity wishListActvitity) {
            this.seedInstance = (WishListActvitity) Preconditions.checkNotNull(wishListActvitity);
        }
    }

    private final class WishListActvititySubcomponentImpl implements ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent {
        private WishListActvitity seedInstance;
        private WishListModule wishListModule;

        private WishListActvititySubcomponentImpl(WishListActvititySubcomponentBuilder wishListActvititySubcomponentBuilder) {
            initialize(wishListActvititySubcomponentBuilder);
        }

        private WishListViewModelFactory getWishListViewModelFactory() {
            return WishListModule_ProvidesViewModelFactoryFactory.proxyProvidesViewModelFactory(this.wishListModule, (FittsCommerceRepository) DaggerAppComponent.this.provideFittsCommerceRepositoryProvider.get(), (EventTracker) DaggerAppComponent.this.provideEventTrackerProvider.get());
        }

        private WishListViewModel getWishListViewModel() {
            return WishListModule_ProvideOrderViewModelFactory.proxyProvideOrderViewModel(this.wishListModule, this.seedInstance, getWishListViewModelFactory());
        }

        private void initialize(WishListActvititySubcomponentBuilder wishListActvititySubcomponentBuilder) {
            this.wishListModule = wishListActvititySubcomponentBuilder.wishListModule;
            this.seedInstance = wishListActvititySubcomponentBuilder.seedInstance;
        }

        public void inject(WishListActvitity wishListActvitity) {
            injectWishListActvitity(wishListActvitity);
        }

        private WishListActvitity injectWishListActvitity(WishListActvitity wishListActvitity) {
            WishListActvitity_MembersInjector.injectViewModel(wishListActvitity, getWishListViewModel());
            return wishListActvitity;
        }
    }

    private final class WithdrawalComponentBuilder extends kr.co.popone.fitts.di.component.WithdrawalComponent.Builder {
        private WithdrawalActivity seedInstance;

        private WithdrawalComponentBuilder() {
        }

        public WithdrawalComponent build() {
            if (this.seedInstance != null) {
                return new WithdrawalComponentImpl(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(WithdrawalActivity.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public void seedInstance(WithdrawalActivity withdrawalActivity) {
            this.seedInstance = (WithdrawalActivity) Preconditions.checkNotNull(withdrawalActivity);
        }
    }

    private final class WithdrawalComponentImpl implements WithdrawalComponent {
        private WithdrawalComponentImpl(WithdrawalComponentBuilder withdrawalComponentBuilder) {
        }

        public void inject(WithdrawalActivity withdrawalActivity) {
            injectWithdrawalActivity(withdrawalActivity);
        }

        private WithdrawalActivity injectWithdrawalActivity(WithdrawalActivity withdrawalActivity) {
            WithdrawalActivity_MembersInjector.injectUserAPI(withdrawalActivity, (UserAPI) DaggerAppComponent.this.provideUserAPIProvider.get());
            WithdrawalActivity_MembersInjector.injectSessionManager(withdrawalActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return withdrawalActivity;
        }
    }

    private DaggerAppComponent(Builder builder) {
        initialize(builder);
        initialize2(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private Map<Class<? extends Activity>, Provider<Factory<? extends Activity>>> getMapOfClassOfAndProviderOfFactoryOf() {
        return MapBuilder.newMapBuilder(85).put(IntroActivity.class, this.introActivityComponentBuilderProvider).put(LoginActivity.class, this.loginActivityComponentBuilderProvider).put(TagSearchActivity.class, this.tagSearchActivityComponentBuilderProvider).put(JoinActivity.class, this.joinActivityComponentBuilderProvider).put(MainActivity.class, this.mainActivityComponentBuilderProvider).put(SettingActivity.class, this.settingActivityComponentBuilderProvider).put(AlarmSettingActivity.class, this.alarmSettingActivityComponentBuilderProvider).put(WithdrawalActivity.class, this.withdrawalComponentBuilderProvider).put(ReportPostActivity.class, this.reportPostComponentBuilderProvider).put(FeedbackActivity.class, this.feedbackActivityComponentBuilderProvider).put(WebActivity.class, this.webComponentBuilderProvider).put(PostImageDetailActivity.class, this.postImageDetailActivityComponentBuilderProvider).put(PostPreviewActivity.class, this.postPreviewComponentBuilderProvider).put(CommentsActivity.class, this.commentsActivityComponentBuilderProvider).put(PostActivity.class, this.postActivityComponentBuilderProvider).put(FollowActivity.class, this.followActivityComponentBuilderProvider).put(LikedActivity.class, this.likedActivityComponentBuilderProvider).put(ModifyBodyActivity.class, this.modifyBodyActivityComponentBuilderProvider).put(ModifyProfileActivity.class, this.modifyProfileActivityComponentBuilderProvider).put(ModifyShowRoomActivity.class, this.modifyShowRoomActivityComponentBuilderProvider).put(ShowRoomActivity.class, this.showRoomActivityComponentBuilderProvider).put(ShopSearchActivity.class, this.shopSearchActivityComponentBuilderProvider).put(RewardPointUseConfirmActivity.class, this.rewardPointUseConfirmActivityComponentBuilderProvider).put(RewardUsageDetailActivity.class, this.rewardUsageDetailActivityComponentBuilderProvider).put(ResetPasswordActivity.class, this.resetPasswordActivityComponentBuilderProvider).put(ImageSelectorActivity.class, this.imageSelectorActivityComponentBuilderProvider).put(PostDeleteNotificationDetailActivity.class, this.postDeleteNotificationDetailActivityComponentBuilderProvider).put(PostCollectionActivity.class, this.postCollectionActivityComponentBuilderProvider).put(ProfileInputActivity.class, this.profileInputActivityComponentBuilderProvider).put(PostVerificationRejectNoticeActivity.class, this.postVerificationRejectNoticeActivityComponentBuilderProvider).put(WelcomeActivity.class, this.welcomeActivityComponentBuilderProvider).put(PostFirstWriteGuideActivity.class, this.postFirstWriteGuideActivityComponentBuilderProvider).put(OpenWebActivity.class, this.openWebActivityComponentBuilderProvider).put(UserSizeInputActivity.class, this.userSizeInputActivityComponentBuilderProvider).put(PromotionCollectionActivity.class, this.promotionCollectionActivityComponentBuilderProvider).put(AppliableEventActivity.class, this.appliableEventActivityComponentBuilderProvider).put(AppliableEventApplyActivity.class, this.appliableEventApplyActivityComponentBuilderProvider).put(AppliableEventResultActivity.class, this.appliableEventResultActivityComponentBuilderProvider).put(AppliableEventWinnerInputActivity.class, this.appliableEventWinnerInputActivityComponentBuilderProvider).put(PostVerificationFinishNoticeActivity.class, this.postVerificationFinishNoticeActivityComponentBuilderProvider).put(RewardPointUseActivity.class, this.rewardPointUseActivityComponentBuilderProvider).put(PostingViolationNoticeActivity.class, this.postingViolationNoticeActivityComponentBuilderProvider).put(MultiImageEventActivity.class, this.multiImageEventActivityComponentBuilderProvider).put(AppliableCollaborativeEventActivity.class, this.appliableCollaborativeEventActivityComponentBuilderProvider).put(AppliableCollaborativeEventApplyActivity.class, this.appliableCollaborativeEventApplyActivityComponentBuilderProvider).put(EventShopWebActivity.class, this.eventShopWebActivityComponentBuilderProvider).put(ShopWebViewActivity.class, this.shopWebViewActivityComponentBuilderProvider).put(CouponRegisterActivity.class, this.couponRegisterActivityComponentBuilderProvider).put(CouponPointInputUserInfoActivity.class, this.couponPointInputUserInfoActivityComponentBuilderProvider).put(CouponUseActivity.class, this.couponUseActivityComponentBuilderProvider).put(CouponHomeActivity.class, this.couponHomeActivityComponentBuilderProvider).put(CouponUseConfirmActivity.class, this.couponUseConfirmActivityComponentBuilderProvider).put(CouponUsageDetailActivity.class, this.couponUsageDetailActivityComponentBuilderProvider).put(TermsAgreeWebViewActivity.class, this.termsAgreeActivityComponentBuilderProvider).put(PersonalizedRecommendActivity.class, this.personalizedRecommendActivityComponentBuilderProvider).put(ModifyUserInfoActivity.class, this.modifyUserInfoActivityComponentBuilderProvider).put(MixedCollectionActivity.class, this.mixedCollectionActivityComponentBuilderProvider).put(ImagePreviewActivity.class, this.imagePreviewActivityComponentBuilderProvider).put(IdentificationActivity.class, this.identificationActivityComponentBuilderProvider).put(PaymentModuleActivity.class, this.paymentModuleActivityComponentBuilderProvider).put(FittsCardRendingActivity.class, this.fittsCardRendingActivityComponentBuilderProvider).put(PostFirstWriteNoticeActivity.class, this.postFirstWriteNoticeActivityComponentBuilderProvider).put(CreatePostActivity.class, this.createPostActivitySubcomponentBuilderProvider).put(CategorySearchActivity.class, this.categorySearchActivitySubcomponentBuilderProvider).put(SearchActivity.class, this.searchActivitySubcomponentBuilderProvider).put(StoreBrowserActivity.class, this.storeBrowserActivitySubcomponentBuilderProvider).put(OrderActivity.class, this.orderActivitySubcomponentBuilderProvider).put(CartActivity.class, this.cartActivitySubcomponentBuilderProvider).put(OrderListActivity.class, this.orderListActivitySubcomponentBuilderProvider).put(OrderDetailActivity.class, this.orderDetailActivitySubcomponentBuilderProvider).put(FittieRecommendActivity.class, this.fittieRecommendActivitySubcomponentBuilderProvider).put(WishListActvitity.class, this.wishListActvititySubcomponentBuilderProvider).put(BannerActivity.class, this.bannerActivitySubcomponentBuilderProvider).put(ExchangeApplyActivity.class, this.exchangeApplyActivitySubcomponentBuilderProvider).put(RefundApplyActivity.class, this.refundApplyActivitySubcomponentBuilderProvider).put(ExchangeCompleteActivity.class, this.exchangeCompleteActivitySubcomponentBuilderProvider).put(RefundCompleteActivity.class, this.refundCompleteActivitySubcomponentBuilderProvider).put(OrderRendingActivity.class, this.orderRendingActivitySubcomponentBuilderProvider).put(OrderCompleteRenderActivity.class, this.orderCompleteRenderActivitySubcomponentBuilderProvider).put(NCommerceActivity.class, this.nCommerceActivitySubcomponentBuilderProvider).put(FollowingPostActivity.class, this.followingPostActivitySubcomponentBuilderProvider).put(ShopBridgeActivity.class, this.shopBridgeActivitySubcomponentBuilderProvider).put(ShopBookmarkActivity.class, this.shopBookmarkActivitySubcomponentBuilderProvider).put(ProductBridgeActivity.class, this.productBridgeActivitySubcomponentBuilderProvider).put(TrendFeedActivity.class, this.trendFeedActivitySubcomponentBuilderProvider).build();
    }

    private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
    }

    private Map<Class<? extends Service>, Provider<Factory<? extends Service>>> getMapOfClassOfAndProviderOfFactoryOf2() {
        return Collections.singletonMap(FittsFirebaseMessagingService.class, this.fittsFirebaseMessasingServiceComponentBuilderProvider);
    }

    private DispatchingAndroidInjector<Service> getDispatchingAndroidInjectorOfService() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf2());
    }

    private void initialize(Builder builder) {
        this.provideContextProvider = AppModule_ProvideContextFactory.create(builder.appModule);
        this.provideRetrofitBuilder$app_productionFittsReleaseProvider = DoubleCheck.provider(ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory.create(builder.clientModule));
        this.provideClientBuilder$app_productionFittsReleaseProvider = DoubleCheck.provider(ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory.create(builder.clientModule));
        this.provideGlobeHttpHandler$app_productionFittsReleaseProvider = DoubleCheck.provider(GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory.create(builder.globeConfigModule));
        this.requestInterceptProvider = DoubleCheck.provider(RequestIntercept_Factory.create(this.provideGlobeHttpHandler$app_productionFittsReleaseProvider));
        this.provideIntercept$app_productionFittsReleaseProvider = DoubleCheck.provider(ClientModule_ProvideIntercept$app_productionFittsReleaseFactory.create(builder.clientModule, this.requestInterceptProvider));
        this.provideClient$app_productionFittsReleaseProvider = DoubleCheck.provider(ClientModule_ProvideClient$app_productionFittsReleaseFactory.create(builder.clientModule, this.provideClientBuilder$app_productionFittsReleaseProvider, this.provideIntercept$app_productionFittsReleaseProvider));
        this.provideBaseUrl$app_productionFittsReleaseProvider = DoubleCheck.provider(GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory.create(builder.globeConfigModule));
        this.provideRetrofit$app_productionFittsReleaseProvider = DoubleCheck.provider(ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory.create(builder.clientModule, this.provideRetrofitBuilder$app_productionFittsReleaseProvider, this.provideClient$app_productionFittsReleaseProvider, this.provideBaseUrl$app_productionFittsReleaseProvider));
        this.provideUserAPIProvider = DoubleCheck.provider(ServiceModule_ProvideUserAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.sessionManagerProvider = DoubleCheck.provider(SessionManager_Factory.create(this.provideContextProvider, this.provideUserAPIProvider));
        this.introActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.IntroActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.IntroActivityComponent.Builder get() {
                return new IntroActivityComponentBuilder();
            }
        };
        this.loginActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.LoginActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.LoginActivityComponent.Builder get() {
                return new LoginActivityComponentBuilder();
            }
        };
        this.tagSearchActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.TagSearchActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.TagSearchActivityComponent.Builder get() {
                return new TagSearchActivityComponentBuilder();
            }
        };
        this.joinActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.JoinActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.JoinActivityComponent.Builder get() {
                return new JoinActivityComponentBuilder();
            }
        };
        this.mainActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.MainActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.MainActivityComponent.Builder get() {
                return new MainActivityComponentBuilder();
            }
        };
        this.settingActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.SettingActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.SettingActivityComponent.Builder get() {
                return new SettingActivityComponentBuilder();
            }
        };
        this.alarmSettingActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AlarmSettingActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AlarmSettingActivityComponent.Builder get() {
                return new AlarmSettingActivityComponentBuilder();
            }
        };
        this.withdrawalComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.WithdrawalComponent.Builder>() {
            public kr.co.popone.fitts.di.component.WithdrawalComponent.Builder get() {
                return new WithdrawalComponentBuilder();
            }
        };
        this.reportPostComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ReportPostComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ReportPostComponent.Builder get() {
                return new ReportPostComponentBuilder();
            }
        };
        this.feedbackActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.FeedbackActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.FeedbackActivityComponent.Builder get() {
                return new FeedbackActivityComponentBuilder();
            }
        };
        this.webComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.WebComponent.Builder>() {
            public kr.co.popone.fitts.di.component.WebComponent.Builder get() {
                return new WebComponentBuilder();
            }
        };
        this.postImageDetailActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostImageDetailActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostImageDetailActivityComponent.Builder get() {
                return new PostImageDetailActivityComponentBuilder();
            }
        };
        this.postPreviewComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostPreviewComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostPreviewComponent.Builder get() {
                return new PostPreviewComponentBuilder();
            }
        };
        this.commentsActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CommentsActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CommentsActivityComponent.Builder get() {
                return new CommentsActivityComponentBuilder();
            }
        };
        this.postActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostActivityComponent.Builder get() {
                return new PostActivityComponentBuilder();
            }
        };
        this.followActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.FollowActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.FollowActivityComponent.Builder get() {
                return new FollowActivityComponentBuilder();
            }
        };
        this.likedActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.LikedActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.LikedActivityComponent.Builder get() {
                return new LikedActivityComponentBuilder();
            }
        };
        this.modifyBodyActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ModifyBodyActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ModifyBodyActivityComponent.Builder get() {
                return new ModifyBodyActivityComponentBuilder();
            }
        };
        this.modifyProfileActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ModifyProfileActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ModifyProfileActivityComponent.Builder get() {
                return new ModifyProfileActivityComponentBuilder();
            }
        };
        this.modifyShowRoomActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ModifyShowRoomActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ModifyShowRoomActivityComponent.Builder get() {
                return new ModifyShowRoomActivityComponentBuilder();
            }
        };
        this.showRoomActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ShowRoomActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ShowRoomActivityComponent.Builder get() {
                return new ShowRoomActivityComponentBuilder();
            }
        };
        this.shopSearchActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ShopSearchActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ShopSearchActivityComponent.Builder get() {
                return new ShopSearchActivityComponentBuilder();
            }
        };
        this.rewardPointUseConfirmActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.RewardPointUseConfirmActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.RewardPointUseConfirmActivityComponent.Builder get() {
                return new RewardPointUseConfirmActivityComponentBuilder();
            }
        };
        this.rewardUsageDetailActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.RewardUsageDetailActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.RewardUsageDetailActivityComponent.Builder get() {
                return new RewardUsageDetailActivityComponentBuilder();
            }
        };
        this.resetPasswordActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ResetPasswordActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ResetPasswordActivityComponent.Builder get() {
                return new ResetPasswordActivityComponentBuilder();
            }
        };
        this.imageSelectorActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ImageSelectorActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ImageSelectorActivityComponent.Builder get() {
                return new ImageSelectorActivityComponentBuilder();
            }
        };
        this.postDeleteNotificationDetailActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostDeleteNotificationDetailActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostDeleteNotificationDetailActivityComponent.Builder get() {
                return new PostDeleteNotificationDetailActivityComponentBuilder();
            }
        };
        this.postCollectionActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostCollectionActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostCollectionActivityComponent.Builder get() {
                return new PostCollectionActivityComponentBuilder();
            }
        };
        this.profileInputActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ProfileInputActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ProfileInputActivityComponent.Builder get() {
                return new ProfileInputActivityComponentBuilder();
            }
        };
        this.postVerificationRejectNoticeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostVerificationRejectNoticeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostVerificationRejectNoticeActivityComponent.Builder get() {
                return new PostVerificationRejectNoticeActivityComponentBuilder();
            }
        };
        this.welcomeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.WelcomeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.WelcomeActivityComponent.Builder get() {
                return new WelcomeActivityComponentBuilder();
            }
        };
        this.postFirstWriteGuideActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostFirstWriteGuideActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostFirstWriteGuideActivityComponent.Builder get() {
                return new PostFirstWriteGuideActivityComponentBuilder();
            }
        };
        this.openWebActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.OpenWebActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.OpenWebActivityComponent.Builder get() {
                return new OpenWebActivityComponentBuilder();
            }
        };
        this.userSizeInputActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.UserSizeInputActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.UserSizeInputActivityComponent.Builder get() {
                return new UserSizeInputActivityComponentBuilder();
            }
        };
        this.promotionCollectionActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PromotionCollectionActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PromotionCollectionActivityComponent.Builder get() {
                return new PromotionCollectionActivityComponentBuilder();
            }
        };
        this.appliableEventActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableEventActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableEventActivityComponent.Builder get() {
                return new AppliableEventActivityComponentBuilder();
            }
        };
        this.appliableEventApplyActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableEventApplyActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableEventApplyActivityComponent.Builder get() {
                return new AppliableEventApplyActivityComponentBuilder();
            }
        };
        this.appliableEventResultActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableEventResultActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableEventResultActivityComponent.Builder get() {
                return new AppliableEventResultActivityComponentBuilder();
            }
        };
        this.appliableEventWinnerInputActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableEventWinnerInputActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableEventWinnerInputActivityComponent.Builder get() {
                return new AppliableEventWinnerInputActivityComponentBuilder();
            }
        };
        this.postVerificationFinishNoticeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostVerificationFinishNoticeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostVerificationFinishNoticeActivityComponent.Builder get() {
                return new PostVerificationFinishNoticeActivityComponentBuilder();
            }
        };
        this.rewardPointUseActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.RewardPointUseActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.RewardPointUseActivityComponent.Builder get() {
                return new RewardPointUseActivityComponentBuilder();
            }
        };
        this.postingViolationNoticeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostingViolationNoticeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostingViolationNoticeActivityComponent.Builder get() {
                return new PostingViolationNoticeActivityComponentBuilder();
            }
        };
        this.multiImageEventActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.MultiImageEventActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.MultiImageEventActivityComponent.Builder get() {
                return new MultiImageEventActivityComponentBuilder();
            }
        };
        this.appliableCollaborativeEventActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableCollaborativeEventActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableCollaborativeEventActivityComponent.Builder get() {
                return new AppliableCollaborativeEventActivityComponentBuilder();
            }
        };
        this.appliableCollaborativeEventApplyActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.AppliableCollaborativeEventApplyActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.AppliableCollaborativeEventApplyActivityComponent.Builder get() {
                return new AppliableCollaborativeEventApplyActivityComponentBuilder();
            }
        };
        this.eventShopWebActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.EventShopWebActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.EventShopWebActivityComponent.Builder get() {
                return new EventShopWebActivityComponentBuilder();
            }
        };
        this.shopWebViewActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ShopWebViewActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ShopWebViewActivityComponent.Builder get() {
                return new ShopWebViewActivityComponentBuilder();
            }
        };
        this.couponRegisterActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponRegisterActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponRegisterActivityComponent.Builder get() {
                return new CouponRegisterActivityComponentBuilder();
            }
        };
        this.couponPointInputUserInfoActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponPointInputUserInfoActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponPointInputUserInfoActivityComponent.Builder get() {
                return new CouponPointInputUserInfoActivityComponentBuilder();
            }
        };
        this.couponUseActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponUseActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponUseActivityComponent.Builder get() {
                return new CouponUseActivityComponentBuilder();
            }
        };
        this.couponHomeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponHomeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponHomeActivityComponent.Builder get() {
                return new CouponHomeActivityComponentBuilder();
            }
        };
        this.couponUseConfirmActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponUseConfirmActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponUseConfirmActivityComponent.Builder get() {
                return new CouponUseConfirmActivityComponentBuilder();
            }
        };
        this.couponUsageDetailActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponUsageDetailActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponUsageDetailActivityComponent.Builder get() {
                return new CouponUsageDetailActivityComponentBuilder();
            }
        };
        this.termsAgreeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.TermsAgreeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.TermsAgreeActivityComponent.Builder get() {
                return new TermsAgreeActivityComponentBuilder();
            }
        };
        this.personalizedRecommendActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PersonalizedRecommendActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PersonalizedRecommendActivityComponent.Builder get() {
                return new PersonalizedRecommendActivityComponentBuilder();
            }
        };
        this.modifyUserInfoActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ModifyUserInfoActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ModifyUserInfoActivityComponent.Builder get() {
                return new ModifyUserInfoActivityComponentBuilder();
            }
        };
        this.mixedCollectionActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.MixedCollectionActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.MixedCollectionActivityComponent.Builder get() {
                return new MixedCollectionActivityComponentBuilder();
            }
        };
        this.imagePreviewActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.ImagePreviewActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.ImagePreviewActivityComponent.Builder get() {
                return new ImagePreviewActivityComponentBuilder();
            }
        };
        this.identificationActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.IdentificationActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.IdentificationActivityComponent.Builder get() {
                return new IdentificationActivityComponentBuilder();
            }
        };
        this.paymentModuleActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PaymentModuleActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PaymentModuleActivityComponent.Builder get() {
                return new PaymentModuleActivityComponentBuilder();
            }
        };
        this.fittsCardRendingActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.FittsCardRendingActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.FittsCardRendingActivityComponent.Builder get() {
                return new FittsCardRendingActivityComponentBuilder();
            }
        };
        this.postFirstWriteNoticeActivityComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.PostFirstWriteNoticeActivityComponent.Builder>() {
            public kr.co.popone.fitts.di.component.PostFirstWriteNoticeActivityComponent.Builder get() {
                return new PostFirstWriteNoticeActivityComponentBuilder();
            }
        };
        this.createPostActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePostActivity$CreatePostActivitySubcomponent.Builder get() {
                return new CreatePostActivitySubcomponentBuilder();
            }
        };
        this.categorySearchActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateCategorySearchActivity$CategorySearchActivitySubcomponent.Builder get() {
                return new CategorySearchActivitySubcomponentBuilder();
            }
        };
        this.searchActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchActivity$SearchActivitySubcomponent.Builder get() {
                return new SearchActivitySubcomponentBuilder();
            }
        };
        this.storeBrowserActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBrowserActivity$StoreBrowserActivitySubcomponent.Builder get() {
                return new StoreBrowserActivitySubcomponentBuilder();
            }
        };
        this.orderActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderActivity$OrderActivitySubcomponent.Builder get() {
                return new OrderActivitySubcomponentBuilder();
            }
        };
        this.cartActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateCartActivity$CartActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateCartActivity$CartActivitySubcomponent.Builder get() {
                return new CartActivitySubcomponentBuilder();
            }
        };
        this.orderListActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderListActivity$OrderListActivitySubcomponent.Builder get() {
                return new OrderListActivitySubcomponentBuilder();
            }
        };
        this.orderDetailActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderDetailActivity$OrderDetailActivitySubcomponent.Builder get() {
                return new OrderDetailActivitySubcomponentBuilder();
            }
        };
        this.fittieRecommendActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieRecommendActivity$FittieRecommendActivitySubcomponent.Builder get() {
                return new FittieRecommendActivitySubcomponentBuilder();
            }
        };
        this.wishListActvititySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateWishListActivity$WishListActvititySubcomponent.Builder get() {
                return new WishListActvititySubcomponentBuilder();
            }
        };
        this.bannerActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateBannerActivity$BannerActivitySubcomponent.Builder get() {
                return new BannerActivitySubcomponentBuilder();
            }
        };
        this.exchangeApplyActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyActivity$ExchangeApplyActivitySubcomponent.Builder get() {
                return new ExchangeApplyActivitySubcomponentBuilder();
            }
        };
        this.refundApplyActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyActivity$RefundApplyActivitySubcomponent.Builder get() {
                return new RefundApplyActivitySubcomponentBuilder();
            }
        };
        this.exchangeCompleteActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteActivity$ExchangeCompleteActivitySubcomponent.Builder get() {
                return new ExchangeCompleteActivitySubcomponentBuilder();
            }
        };
        this.refundCompleteActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteActivity$RefundCompleteActivitySubcomponent.Builder get() {
                return new RefundCompleteActivitySubcomponentBuilder();
            }
        };
        this.orderRendingActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderRendingActivity$OrderRendingActivitySubcomponent.Builder get() {
                return new OrderRendingActivitySubcomponentBuilder();
            }
        };
        this.orderCompleteRenderActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderActivity$OrderCompleteRenderActivitySubcomponent.Builder get() {
                return new OrderCompleteRenderActivitySubcomponentBuilder();
            }
        };
        this.nCommerceActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateNCommerceActivity$NCommerceActivitySubcomponent.Builder get() {
                return new NCommerceActivitySubcomponentBuilder();
            }
        };
        this.followingPostActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateFollowingPostActivity$FollowingPostActivitySubcomponent.Builder get() {
                return new FollowingPostActivitySubcomponentBuilder();
            }
        };
        this.shopBridgeActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreBridgeActivity$ShopBridgeActivitySubcomponent.Builder get() {
                return new ShopBridgeActivitySubcomponentBuilder();
            }
        };
        this.shopBookmarkActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateShopBookmarkActivity$ShopBookmarkActivitySubcomponent.Builder get() {
                return new ShopBookmarkActivitySubcomponentBuilder();
            }
        };
        this.productBridgeActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateProductBridgeActivity$ProductBridgeActivitySubcomponent.Builder get() {
                return new ProductBridgeActivitySubcomponentBuilder();
            }
        };
        this.trendFeedActivitySubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateTrendFeedActivity$TrendFeedActivitySubcomponent.Builder get() {
                return new TrendFeedActivitySubcomponentBuilder();
            }
        };
        this.fittsFirebaseMessasingServiceComponentBuilderProvider = new Provider<kr.co.popone.fitts.services.FittsFirebaseMessasingServiceComponent.Builder>() {
            public kr.co.popone.fitts.services.FittsFirebaseMessasingServiceComponent.Builder get() {
                return new FittsFirebaseMessasingServiceComponentBuilder();
            }
        };
        this.introLoginFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.IntroLoginFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.IntroLoginFragmentComponent.Builder get() {
                return new IntroLoginFragmentComponentBuilder();
            }
        };
        this.meFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.MeFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.MeFragmentComponent.Builder get() {
                return new MeFragmentComponentBuilder();
            }
        };
        this.usedRewardHistoryFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.UsedRewardHistoryFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.UsedRewardHistoryFragmentComponent.Builder get() {
                return new UsedRewardHistoryFragmentComponentBuilder();
            }
        };
    }

    private void initialize2(Builder builder) {
        this.couponListFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CouponListFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CouponListFragmentComponent.Builder get() {
                return new CouponListFragmentComponentBuilder();
            }
        };
        this.usedCouponHistoryFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.UsedCouponHistoryFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.UsedCouponHistoryFragmentComponent.Builder get() {
                return new UsedCouponHistoryFragmentComponentBuilder();
            }
        };
        this.identificationWebViewFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.IdentificationWebViewFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.IdentificationWebViewFragmentComponent.Builder get() {
                return new IdentificationWebViewFragmentComponentBuilder();
            }
        };
        this.categorySearchFragmentComponentBuilderProvider = new Provider<kr.co.popone.fitts.di.component.CategorySearchFragmentComponent.Builder>() {
            public kr.co.popone.fitts.di.component.CategorySearchFragmentComponent.Builder get() {
                return new CategorySearchFragmentComponentBuilder();
            }
        };
        this.identificationAdditionalInfoFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateIdentificationAdditionalInfoFragment$IdentificationAdditionalInfoFragmentSubcomponent.Builder get() {
                return new IdentificationAdditionalInfoFragmentSubcomponentBuilder();
            }
        };
        this.storeFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreFragment$StoreFragmentSubcomponent.Builder get() {
                return new StoreFragmentSubcomponentBuilder();
            }
        };
        this.storeFeedFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateStoreRecommendFragment$StoreFeedFragmentSubcomponent.Builder get() {
                return new StoreFeedFragmentSubcomponentBuilder();
            }
        };
        this.homeFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateHomeFragment$HomeFragmentSubcomponent.Builder get() {
                return new HomeFragmentSubcomponentBuilder();
            }
        };
        this.searchHomeFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHomeFragment$SearchHomeFragmentSubcomponent.Builder get() {
                return new SearchHomeFragmentSubcomponentBuilder();
            }
        };
        this.searchHistoryFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchHistoryFragment$SearchHistoryFragmentSubcomponent.Builder get() {
                return new SearchHistoryFragmentSubcomponentBuilder();
            }
        };
        this.searchResultFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateSearchResultFragment$SearchResultFragmentSubcomponent.Builder get() {
                return new SearchResultFragmentSubcomponentBuilder();
            }
        };
        this.intergratedSearchResultFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateIntergratedSearchResultFragment$IntergratedSearchResultFragmentSubcomponent.Builder get() {
                return new IntergratedSearchResultFragmentSubcomponentBuilder();
            }
        };
        this.postSearchResultFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePostSearchResultFragment$PostSearchResultFragmentSubcomponent.Builder get() {
                return new PostSearchResultFragmentSubcomponentBuilder();
            }
        };
        this.productSearchResultFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateProductSearchResultFragment$ProductSearchResultFragmentSubcomponent.Builder get() {
                return new ProductSearchResultFragmentSubcomponentBuilder();
            }
        };
        this.fittieSearchResultFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateFittieSearchResultFragment$FittieSearchResultFragmentSubcomponent.Builder get() {
                return new FittieSearchResultFragmentSubcomponentBuilder();
            }
        };
        this.exchangeApplyCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeApplyCompleteFragment$ExchangeApplyCompleteFragmentSubcomponent.Builder get() {
                return new ExchangeApplyCompleteFragmentSubcomponentBuilder();
            }
        };
        this.exchangeCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateExchangeCompleteFragment$ExchangeCompleteFragmentSubcomponent.Builder get() {
                return new ExchangeCompleteFragmentSubcomponentBuilder();
            }
        };
        this.refundApplyCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundApplyCompleteFragment$RefundApplyCompleteFragmentSubcomponent.Builder get() {
                return new RefundApplyCompleteFragmentSubcomponentBuilder();
            }
        };
        this.refundCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateRefundCompleteFragment$RefundCompleteFragmentSubcomponent.Builder get() {
                return new RefundCompleteFragmentSubcomponentBuilder();
            }
        };
        this.orderCompleteRenderPaymentFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderPaymentFragment$OrderCompleteRenderPaymentFragmentSubcomponent.Builder get() {
                return new OrderCompleteRenderPaymentFragmentSubcomponentBuilder();
            }
        };
        this.orderCompleteRenderReservationFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteRenderReservationFragment$OrderCompleteRenderReservationFragmentSubcomponent.Builder get() {
                return new OrderCompleteRenderReservationFragmentSubcomponentBuilder();
            }
        };
        this.orderReservationCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCompleteFragment$OrderReservationCompleteFragmentSubcomponent.Builder get() {
                return new OrderReservationCompleteFragmentSubcomponentBuilder();
            }
        };
        this.orderPaymentRushFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentRushFragment$OrderPaymentRushFragmentSubcomponent.Builder get() {
                return new OrderPaymentRushFragmentSubcomponentBuilder();
            }
        };
        this.orderCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderCompleteFragment$OrderCompleteFragmentSubcomponent.Builder get() {
                return new OrderCompleteFragmentSubcomponentBuilder();
            }
        };
        this.orderPaymentCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPaymentCompleteFragment$OrderPaymentCompleteFragmentSubcomponent.Builder get() {
                return new OrderPaymentCompleteFragmentSubcomponentBuilder();
            }
        };
        this.orderReservationSoldOutFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationSoldOutFragment$OrderReservationSoldOutFragmentSubcomponent.Builder get() {
                return new OrderReservationSoldOutFragmentSubcomponentBuilder();
            }
        };
        this.orderReservationCancelFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderReservationCancelFragment$OrderReservationCancelFragmentSubcomponent.Builder get() {
                return new OrderReservationCancelFragmentSubcomponentBuilder();
            }
        };
        this.paymentCancelMisPriceFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelMisPriceFragment$PaymentCancelMisPriceFragmentSubcomponent.Builder get() {
                return new PaymentCancelMisPriceFragmentSubcomponentBuilder();
            }
        };
        this.paymentCancelSoldOutFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePaymentCancelSoldOutFragment$PaymentCancelSoldOutFragmentSubcomponent.Builder get() {
                return new PaymentCancelSoldOutFragmentSubcomponentBuilder();
            }
        };
        this.orderAllCancelFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderAllCancelFragment$OrderAllCancelFragmentSubcomponent.Builder get() {
                return new OrderAllCancelFragmentSubcomponentBuilder();
            }
        };
        this.orderPartCancelFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderPartCancelFragment$OrderPartCancelFragmentSubcomponent.Builder get() {
                return new OrderPartCancelFragmentSubcomponentBuilder();
            }
        };
        this.orderShippingCompleteFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateOrderShippingCompleteFragment$OrderShippingCompleteFragmentSubcomponent.Builder get() {
                return new OrderShippingCompleteFragmentSubcomponentBuilder();
            }
        };
        this.pointRevenueDetailFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateRevenueDetailFragment$PointRevenueDetailFragmentSubcomponent.Builder get() {
                return new PointRevenueDetailFragmentSubcomponentBuilder();
            }
        };
        this.pointHistoryFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePointHistoryFragment$PointHistoryFragmentSubcomponent.Builder get() {
                return new PointHistoryFragmentSubcomponentBuilder();
            }
        };
        this.pointUsageHistoryFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePointUsageHistoryFragment$PointUsageHistoryFragmentSubcomponent.Builder get() {
                return new PointUsageHistoryFragmentSubcomponentBuilder();
            }
        };
        this.storeNewFeedFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateNewestProductFragment$StoreNewFeedFragmentSubcomponent.Builder get() {
                return new StoreNewFeedFragmentSubcomponentBuilder();
            }
        };
        this.homeFeedFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreatePostsFragment$HomeFeedFragmentSubcomponent.Builder get() {
                return new HomeFeedFragmentSubcomponentBuilder();
            }
        };
        this.alarmFragmentSubcomponentBuilderProvider = new Provider<kr.co.popone.fitts.di.module.ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent.Builder>() {
            public kr.co.popone.fitts.di.module.ViewModelModule_CreateAlarmFragment$AlarmFragmentSubcomponent.Builder get() {
                return new AlarmFragmentSubcomponentBuilder();
            }
        };
        this.provideFirebaseAnalyticsProvider = DoubleCheck.provider(AppModule_ProvideFirebaseAnalyticsFactory.create(builder.appModule));
        this.provideEventTrackerProvider = DoubleCheck.provider(AppModule_ProvideEventTrackerFactory.create(builder.appModule, this.provideFirebaseAnalyticsProvider));
        this.providePostAPIProvider = DoubleCheck.provider(ServiceModule_ProvidePostAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideActionLogAPIProvider = DoubleCheck.provider(ServiceModule_ProvideActionLogAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideActionLogUtilProvider = DoubleCheck.provider(AppModule_ProvideActionLogUtilFactory.create(builder.appModule, this.provideActionLogAPIProvider));
        this.provideNotificationHandlerProvider = DoubleCheck.provider(AppModule_ProvideNotificationHandlerFactory.create(builder.appModule));
        this.provideFittsServiceApiProvider = DoubleCheck.provider(ServiceModule_ProvideFittsServiceApiFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideFittsServiceRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideFittsServiceRepositoryFactory.create(builder.repositoryModule, this.provideFittsServiceApiProvider));
        this.provideCreatePostActivityUtilProvider = DoubleCheck.provider(AppModule_ProvideCreatePostActivityUtilFactory.create(builder.appModule, this.provideEventTrackerProvider, this.provideUserAPIProvider, this.provideFittsServiceRepositoryProvider, this.sessionManagerProvider));
        this.provideSchemeHandlerProvider = DoubleCheck.provider(AppModule_ProvideSchemeHandlerFactory.create(builder.appModule, this.provideEventTrackerProvider, this.provideFittsServiceRepositoryProvider, this.provideCreatePostActivityUtilProvider));
        this.provideApplicationProvider = AppModule_ProvideApplicationFactory.create(builder.appModule);
        this.appManagerProvider = DoubleCheck.provider(AppManager_Factory.create(this.provideApplicationProvider, this.provideFittsServiceRepositoryProvider));
        this.provideSearchAPIProvider = DoubleCheck.provider(ServiceModule_ProvideSearchAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideCategoryAPIProvider = DoubleCheck.provider(ServiceModule_ProvideCategoryAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideCategorySearchRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideCategorySearchRepositoryFactory.create(builder.repositoryModule, this.provideCategoryAPIProvider));
        this.provideStoreAPIProvider = DoubleCheck.provider(ServiceModule_ProvideStoreAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideStoreRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideStoreRepositoryFactory.create(builder.repositoryModule, this.provideStoreAPIProvider));
        this.provideShopSearchHistoryRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideShopSearchHistoryRepositoryFactory.create(builder.repositoryModule, this.provideContextProvider));
        this.providePaymentAPIProvider = DoubleCheck.provider(ServiceModule_ProvidePaymentAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideDataHoldermanagerProvider = DoubleCheck.provider(AppModule_ProvideDataHoldermanagerFactory.create(builder.appModule));
        this.provideCollectionAPIProvider = DoubleCheck.provider(ServiceModule_ProvideCollectionAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideEventAPIProvider = DoubleCheck.provider(ServiceModule_ProvideEventAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideCouponAPIProvider = DoubleCheck.provider(ServiceModule_ProvideCouponAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideFittsSocialApiProvider = DoubleCheck.provider(ServiceModule_ProvideFittsSocialApiFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideFittsSocialRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideFittsSocialRepositoryFactory.create(builder.repositoryModule, this.provideFittsSocialApiProvider));
        this.provideFittsCommerceApiProvider = DoubleCheck.provider(ServiceModule_ProvideFittsCommerceApiFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideFittsCommerceRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideFittsCommerceRepositoryFactory.create(builder.repositoryModule, this.provideFittsCommerceApiProvider));
        this.provideSearchRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideSearchRepositoryFactory.create(builder.repositoryModule, this.provideSearchAPIProvider));
        this.provideAllSearchHistoryRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideAllSearchHistoryRepositoryFactory.create(builder.repositoryModule, this.provideContextProvider));
        this.provideProductAPIProvider = DoubleCheck.provider(ServiceModule_ProvideProductAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideProductRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideProductRepositoryFactory.create(builder.repositoryModule, this.provideProductAPIProvider));
        this.provideCartAPIProvider = DoubleCheck.provider(ServiceModule_ProvideCartAPIFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideCartRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideCartRepositoryFactory.create(builder.repositoryModule, this.provideCartAPIProvider));
        this.provideExchangeApiProvider = DoubleCheck.provider(ServiceModule_ProvideExchangeApiFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideExchangeRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideExchangeRepositoryFactory.create(builder.repositoryModule, this.provideExchangeApiProvider));
        this.provideRefundApiProvider = DoubleCheck.provider(ServiceModule_ProvideRefundApiFactory.create(builder.serviceModule, this.provideRetrofit$app_productionFittsReleaseProvider));
        this.provideRefundRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideRefundRepositoryFactory.create(builder.repositoryModule, this.provideRefundApiProvider));
        this.provideUserRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideUserRepositoryFactory.create(builder.repositoryModule, this.provideUserAPIProvider));
        this.providePostRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvidePostRepositoryFactory.create(builder.repositoryModule, this.providePostAPIProvider));
        this.provideHomeRepositoryProvider = DoubleCheck.provider(RepositoryModule_ProvideHomeRepositoryFactory.create(builder.repositoryModule, this.provideUserAPIProvider, this.sessionManagerProvider));
    }

    public void inject(FittsApplication fittsApplication) {
        injectFittsApplication(fittsApplication);
    }

    private FittsApplication injectFittsApplication(FittsApplication fittsApplication) {
        FittsApplication_MembersInjector.injectSessionManager(fittsApplication, (SessionManager) this.sessionManagerProvider.get());
        FittsApplication_MembersInjector.injectDispatchingAndroidInjector(fittsApplication, getDispatchingAndroidInjectorOfActivity());
        FittsApplication_MembersInjector.injectDispatchingServiceInjector(fittsApplication, getDispatchingAndroidInjectorOfService());
        FittsApplication_MembersInjector.injectUserAPI(fittsApplication, (UserAPI) this.provideUserAPIProvider.get());
        return fittsApplication;
    }
}
