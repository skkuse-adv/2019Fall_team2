package kr.co.popone.fitts.model.validation;

import com.uber.rave.BaseValidator;
import com.uber.rave.BaseValidator.ValidationContext;
import com.uber.rave.InvalidModelException;
import java.util.Collection;
import java.util.List;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import kr.co.popone.fitts.model.category.CategoryData;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse.ButtonProperties;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage;
import kr.co.popone.fitts.model.coupon.CouponAPI.AgreementImage;
import kr.co.popone.fitts.model.coupon.CouponAPI.AvailableCouponCountResponse;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm.Recommend;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm.Type;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmAgreement;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmCount;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerImage;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;
import kr.co.popone.fitts.model.datamodel.service.user.BodyFilter;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.ContactInfo;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventAppliabilityCheckResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventApplyResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo;
import kr.co.popone.fitts.model.event.EventAPI.EventHistory;
import kr.co.popone.fitts.model.event.EventAPI.RemotePushContent;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import kr.co.popone.fitts.model.event.EventAPI.TopImageItem;
import kr.co.popone.fitts.model.payment.PaymentAPI.CouponEnrollResult;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.FeedInfoResponse;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import kr.co.popone.fitts.model.post.PostAPI.PostId;
import kr.co.popone.fitts.model.post.PostAPI.PostInvoice;
import kr.co.popone.fitts.model.post.PostAPI.RelatedPost;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.post.PostAPI.Tag;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchAPI.BadgeResponse;
import kr.co.popone.fitts.model.search.SearchAPI.Comment;
import kr.co.popone.fitts.model.search.SearchAPI.Comment.MentioneeInfo;
import kr.co.popone.fitts.model.search.SearchAPI.Image;
import kr.co.popone.fitts.model.search.SearchAPI.RecommendationSection;
import kr.co.popone.fitts.model.search.SearchAPI.RecommendationSection.Item;
import kr.co.popone.fitts.model.search.SearchAPI.SearchFittieResult;
import kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult;
import kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Shop;
import kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult;
import kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult.PostEntry;
import kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry;
import kr.co.popone.fitts.model.search.SearchAPI.TimestampResponse;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.EmailAvailable;
import kr.co.popone.fitts.model.user.UserAPI.Enroll;
import kr.co.popone.fitts.model.user.UserAPI.IdAvailable;
import kr.co.popone.fitts.model.user.UserAPI.IvsInfo;
import kr.co.popone.fitts.model.user.UserAPI.Me;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse.UnpostableReason;
import kr.co.popone.fitts.model.user.UserAPI.Reward;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserAPI.UserInvoice;

public final class ValidatorFactoryImpl_Generated_Validator extends BaseValidator {
    ValidatorFactoryImpl_Generated_Validator() {
        addSupportedClass(CollectionDetailResponse.class);
        addSupportedClass(ButtonProperties.class);
        addSupportedClass(CollectionEntry.class);
        addSupportedClass(CollectionImage.class);
        addSupportedClass(FeedInfoResponse.class);
        addSupportedClass(RelatedPost.class);
        addSupportedClass(CreatePost.class);
        addSupportedClass(Post.class);
        addSupportedClass(Category.class);
        addSupportedClass(Tag.class);
        addSupportedClass(Style.class);
        addSupportedClass(LinkInfo.class);
        addSupportedClass(ResponseImageId.class);
        addSupportedClass(PostId.class);
        addSupportedClass(PostContent.class);
        addSupportedClass(PostInvoice.class);
        addSupportedClass(CategoryData.class);
        addSupportedClass(CouponEnrollResult.class);
        addSupportedClass(PaymentHistory.class);
        addSupportedClass(PaymentUsage.class);
        addSupportedClass(PostableResponse.class);
        addSupportedClass(UnpostableReason.class);
        addSupportedClass(ShippingAddressResponse.class);
        addSupportedClass(UserAPI.ResponseImageId.class);
        addSupportedClass(Reward.class);
        addSupportedClass(Enroll.class);
        addSupportedClass(Me.class);
        addSupportedClass(EmailAvailable.class);
        addSupportedClass(IdAvailable.class);
        addSupportedClass(UserInvoice.class);
        addSupportedClass(IvsInfo.class);
        addSupportedClass(AvailableCouponCountResponse.class);
        addSupportedClass(CouponInfo.class);
        addSupportedClass(CouponRegisterResult.class);
        addSupportedClass(CouponAgreementApply.class);
        addSupportedClass(AgreementImage.class);
        addSupportedClass(Image.class);
        addSupportedClass(SearchAPI.LinkInfo.class);
        addSupportedClass(Comment.class);
        addSupportedClass(MentioneeInfo.class);
        addSupportedClass(SearchAPI.Tag.class);
        addSupportedClass(SearchHomeResult.class);
        addSupportedClass(SearchHomeResult.Style.class);
        addSupportedClass(Shop.class);
        addSupportedClass(SearchPostResult.class);
        addSupportedClass(PostEntry.class);
        addSupportedClass(SearchShopResult.class);
        addSupportedClass(ShopEntry.class);
        addSupportedClass(SearchFittieResult.class);
        addSupportedClass(RecommendationSection.class);
        addSupportedClass(Item.class);
        addSupportedClass(BadgeResponse.class);
        addSupportedClass(TimestampResponse.class);
        addSupportedClass(SearchRecommend.class);
        addSupportedClass(ImageUrlWithRatio.class);
        addSupportedClass(Product.class);
        addSupportedClass(kr.co.popone.fitts.model.datamodel.commerce.Shop.class);
        addSupportedClass(SpecialDiscountInfo.class);
        addSupportedClass(kr.co.popone.fitts.model.datamodel.service.post.Image.class);
        addSupportedClass(LikeResult.class);
        addSupportedClass(kr.co.popone.fitts.model.datamodel.service.post.Comment.class);
        addSupportedClass(ShowRoom.class);
        addSupportedClass(BodyInfo.class);
        addSupportedClass(BodyFilter.class);
        addSupportedClass(MyInfo.class);
        addSupportedClass(User.class);
        addSupportedClass(ContactInfo.class);
        addSupportedClass(FollowResult.class);
        addSupportedClass(AlarmCount.class);
        addSupportedClass(AlarmAgreement.class);
        addSupportedClass(Alarm.class);
        addSupportedClass(Alarm.Reward.class);
        addSupportedClass(Recommend.class);
        addSupportedClass(Alarm.Enroll.class);
        addSupportedClass(Type.class);
        addSupportedClass(BannerImage.class);
        addSupportedClass(Banner.class);
        addSupportedClass(RemotePushContent.class);
        addSupportedClass(Ticket.class);
        addSupportedClass(AppliableEventResponse.class);
        addSupportedClass(AppliableEventResponse.Item.class);
        addSupportedClass(AppliableEventApplyResponse.class);
        addSupportedClass(AppliableEventResultResponse.class);
        addSupportedClass(WinnerInfo.class);
        addSupportedClass(AppliableEventAppliabilityCheckResponse.class);
        addSupportedClass(EventHistory.class);
        addSupportedClass(TopImageItem.class);
        addSupportedClass(TestModel.class);
        addSupportedClass(TestList.class);
        registerSelf();
    }

    /* access modifiers changed from: protected */
    public void validateAs(Object obj, Class<?> cls) throws InvalidModelException {
        if (!cls.isInstance(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj.getClass().getCanonicalName());
            sb.append("is not of type");
            sb.append(cls.getCanonicalName());
            throw new IllegalArgumentException(sb.toString());
        } else if (cls.equals(CollectionDetailResponse.class)) {
            validateAs((CollectionDetailResponse) obj);
        } else if (cls.equals(ButtonProperties.class)) {
            validateAs((ButtonProperties) obj);
        } else if (cls.equals(CollectionEntry.class)) {
            validateAs((CollectionEntry) obj);
        } else if (cls.equals(CollectionImage.class)) {
            validateAs((CollectionImage) obj);
        } else if (cls.equals(FeedInfoResponse.class)) {
            validateAs((FeedInfoResponse) obj);
        } else if (cls.equals(RelatedPost.class)) {
            validateAs((RelatedPost) obj);
        } else if (cls.equals(CreatePost.class)) {
            validateAs((CreatePost) obj);
        } else if (cls.equals(Post.class)) {
            validateAs((Post) obj);
        } else if (cls.equals(Category.class)) {
            validateAs((Category) obj);
        } else if (cls.equals(Tag.class)) {
            validateAs((Tag) obj);
        } else if (cls.equals(Style.class)) {
            validateAs((Style) obj);
        } else if (cls.equals(LinkInfo.class)) {
            validateAs((LinkInfo) obj);
        } else if (cls.equals(ResponseImageId.class)) {
            validateAs((ResponseImageId) obj);
        } else if (cls.equals(PostId.class)) {
            validateAs((PostId) obj);
        } else if (cls.equals(PostContent.class)) {
            validateAs((PostContent) obj);
        } else if (cls.equals(PostInvoice.class)) {
            validateAs((PostInvoice) obj);
        } else if (cls.equals(CategoryData.class)) {
            validateAs((CategoryData) obj);
        } else if (cls.equals(CouponEnrollResult.class)) {
            validateAs((CouponEnrollResult) obj);
        } else if (cls.equals(PaymentHistory.class)) {
            validateAs((PaymentHistory) obj);
        } else if (cls.equals(PaymentUsage.class)) {
            validateAs((PaymentUsage) obj);
        } else if (cls.equals(PostableResponse.class)) {
            validateAs((PostableResponse) obj);
        } else if (cls.equals(UnpostableReason.class)) {
            validateAs((UnpostableReason) obj);
        } else if (cls.equals(ShippingAddressResponse.class)) {
            validateAs((ShippingAddressResponse) obj);
        } else if (cls.equals(UserAPI.ResponseImageId.class)) {
            validateAs((UserAPI.ResponseImageId) obj);
        } else if (cls.equals(Reward.class)) {
            validateAs((Reward) obj);
        } else if (cls.equals(Enroll.class)) {
            validateAs((Enroll) obj);
        } else if (cls.equals(Me.class)) {
            validateAs((Me) obj);
        } else if (cls.equals(EmailAvailable.class)) {
            validateAs((EmailAvailable) obj);
        } else if (cls.equals(IdAvailable.class)) {
            validateAs((IdAvailable) obj);
        } else if (cls.equals(UserInvoice.class)) {
            validateAs((UserInvoice) obj);
        } else if (cls.equals(IvsInfo.class)) {
            validateAs((IvsInfo) obj);
        } else if (cls.equals(AvailableCouponCountResponse.class)) {
            validateAs((AvailableCouponCountResponse) obj);
        } else if (cls.equals(CouponInfo.class)) {
            validateAs((CouponInfo) obj);
        } else if (cls.equals(CouponRegisterResult.class)) {
            validateAs((CouponRegisterResult) obj);
        } else if (cls.equals(CouponAgreementApply.class)) {
            validateAs((CouponAgreementApply) obj);
        } else if (cls.equals(AgreementImage.class)) {
            validateAs((AgreementImage) obj);
        } else if (cls.equals(Image.class)) {
            validateAs((Image) obj);
        } else if (cls.equals(SearchAPI.LinkInfo.class)) {
            validateAs((SearchAPI.LinkInfo) obj);
        } else if (cls.equals(Comment.class)) {
            validateAs((Comment) obj);
        } else if (cls.equals(MentioneeInfo.class)) {
            validateAs((MentioneeInfo) obj);
        } else if (cls.equals(SearchAPI.Tag.class)) {
            validateAs((SearchAPI.Tag) obj);
        } else if (cls.equals(SearchHomeResult.class)) {
            validateAs((SearchHomeResult) obj);
        } else if (cls.equals(SearchHomeResult.Style.class)) {
            validateAs((SearchHomeResult.Style) obj);
        } else if (cls.equals(Shop.class)) {
            validateAs((Shop) obj);
        } else if (cls.equals(SearchPostResult.class)) {
            validateAs((SearchPostResult) obj);
        } else if (cls.equals(PostEntry.class)) {
            validateAs((PostEntry) obj);
        } else if (cls.equals(SearchShopResult.class)) {
            validateAs((SearchShopResult) obj);
        } else if (cls.equals(ShopEntry.class)) {
            validateAs((ShopEntry) obj);
        } else if (cls.equals(SearchFittieResult.class)) {
            validateAs((SearchFittieResult) obj);
        } else if (cls.equals(RecommendationSection.class)) {
            validateAs((RecommendationSection) obj);
        } else if (cls.equals(Item.class)) {
            validateAs((Item) obj);
        } else if (cls.equals(BadgeResponse.class)) {
            validateAs((BadgeResponse) obj);
        } else if (cls.equals(TimestampResponse.class)) {
            validateAs((TimestampResponse) obj);
        } else if (cls.equals(SearchRecommend.class)) {
            validateAs((SearchRecommend) obj);
        } else if (cls.equals(ImageUrlWithRatio.class)) {
            validateAs((ImageUrlWithRatio) obj);
        } else if (cls.equals(Product.class)) {
            validateAs((Product) obj);
        } else if (cls.equals(kr.co.popone.fitts.model.datamodel.commerce.Shop.class)) {
            validateAs((kr.co.popone.fitts.model.datamodel.commerce.Shop) obj);
        } else if (cls.equals(SpecialDiscountInfo.class)) {
            validateAs((SpecialDiscountInfo) obj);
        } else if (cls.equals(kr.co.popone.fitts.model.datamodel.service.post.Image.class)) {
            validateAs((kr.co.popone.fitts.model.datamodel.service.post.Image) obj);
        } else if (cls.equals(LikeResult.class)) {
            validateAs((LikeResult) obj);
        } else if (cls.equals(kr.co.popone.fitts.model.datamodel.service.post.Comment.class)) {
            validateAs((kr.co.popone.fitts.model.datamodel.service.post.Comment) obj);
        } else if (cls.equals(ShowRoom.class)) {
            validateAs((ShowRoom) obj);
        } else if (cls.equals(BodyInfo.class)) {
            validateAs((BodyInfo) obj);
        } else if (cls.equals(BodyFilter.class)) {
            validateAs((BodyFilter) obj);
        } else if (cls.equals(MyInfo.class)) {
            validateAs((MyInfo) obj);
        } else if (cls.equals(User.class)) {
            validateAs((User) obj);
        } else if (cls.equals(ContactInfo.class)) {
            validateAs((ContactInfo) obj);
        } else if (cls.equals(FollowResult.class)) {
            validateAs((FollowResult) obj);
        } else if (cls.equals(AlarmCount.class)) {
            validateAs((AlarmCount) obj);
        } else if (cls.equals(AlarmAgreement.class)) {
            validateAs((AlarmAgreement) obj);
        } else if (cls.equals(Alarm.class)) {
            validateAs((Alarm) obj);
        } else if (cls.equals(Alarm.Reward.class)) {
            validateAs((Alarm.Reward) obj);
        } else if (cls.equals(Recommend.class)) {
            validateAs((Recommend) obj);
        } else if (cls.equals(Alarm.Enroll.class)) {
            validateAs((Alarm.Enroll) obj);
        } else if (cls.equals(Type.class)) {
            validateAs((Type) obj);
        } else if (cls.equals(BannerImage.class)) {
            validateAs((BannerImage) obj);
        } else if (cls.equals(Banner.class)) {
            validateAs((Banner) obj);
        } else if (cls.equals(RemotePushContent.class)) {
            validateAs((RemotePushContent) obj);
        } else if (cls.equals(Ticket.class)) {
            validateAs((Ticket) obj);
        } else if (cls.equals(AppliableEventResponse.class)) {
            validateAs((AppliableEventResponse) obj);
        } else if (cls.equals(AppliableEventResponse.Item.class)) {
            validateAs((AppliableEventResponse.Item) obj);
        } else if (cls.equals(AppliableEventApplyResponse.class)) {
            validateAs((AppliableEventApplyResponse) obj);
        } else if (cls.equals(AppliableEventResultResponse.class)) {
            validateAs((AppliableEventResultResponse) obj);
        } else if (cls.equals(WinnerInfo.class)) {
            validateAs((WinnerInfo) obj);
        } else if (cls.equals(AppliableEventAppliabilityCheckResponse.class)) {
            validateAs((AppliableEventAppliabilityCheckResponse) obj);
        } else if (cls.equals(EventHistory.class)) {
            validateAs((EventHistory) obj);
        } else if (cls.equals(TopImageItem.class)) {
            validateAs((TopImageItem) obj);
        } else if (cls.equals(TestModel.class)) {
            validateAs((TestModel) obj);
        } else if (cls.equals(TestList.class)) {
            validateAs((TestList) obj);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj.getClass().getCanonicalName());
            sb2.append(" is not supported by validator ");
            sb2.append(ValidatorFactoryImpl_Generated_Validator.class.getCanonicalName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private void validateAs(CollectionDetailResponse collectionDetailResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CollectionDetailResponse.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) collectionDetailResponse.getType(), false, validationContext));
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) collectionDetailResponse.getTitle(), false, validationContext));
        validationContext.setValidatedItemName("getSize()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) collectionDetailResponse.getSize(), true, validationContext));
        validationContext.setValidatedItemName("getShortTitle()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) collectionDetailResponse.getShortTitle(), true, validationContext));
        validationContext.setValidatedItemName("getDescription1()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) collectionDetailResponse.getDescription1(), true, validationContext));
        validationContext.setValidatedItemName("getDescription2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) collectionDetailResponse.getDescription2(), true, validationContext));
        validationContext.setValidatedItemName("getMainImageUrl()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) collectionDetailResponse.getMainImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) collectionDetailResponse.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("getButtonProperties()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) collectionDetailResponse.getButtonProperties(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) collectionDetailResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) collectionDetailResponse.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) collectionDetailResponse.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) collectionDetailResponse.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) collectionDetailResponse.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) collectionDetailResponse.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) collectionDetailResponse.component9(), true, validationContext));
        validationContext.setValidatedItemName("component11()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) collectionDetailResponse.component11(), true, validationContext));
        validationContext.setValidatedItemName("component12()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) collectionDetailResponse.component12(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) collectionDetailResponse.toString(), true, validationContext));
        if (mergeErrors19 != null && !mergeErrors19.isEmpty()) {
            throw new InvalidModelException(mergeErrors19);
        }
    }

    private void validateAs(ButtonProperties buttonProperties) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ButtonProperties.class);
        validationContext.setValidatedItemName("getBackgroundColor()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) buttonProperties.getBackgroundColor(), true, validationContext));
        validationContext.setValidatedItemName("getTextColor()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) buttonProperties.getTextColor(), true, validationContext));
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) buttonProperties.getTitle(), true, validationContext));
        validationContext.setValidatedItemName("getActionScheme()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) buttonProperties.getActionScheme(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) buttonProperties.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) buttonProperties.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) buttonProperties.component3(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) buttonProperties.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) buttonProperties.toString(), true, validationContext));
        if (mergeErrors9 != null && !mergeErrors9.isEmpty()) {
            throw new InvalidModelException(mergeErrors9);
        }
    }

    private void validateAs(CollectionEntry collectionEntry) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CollectionEntry.class);
        validationContext.setValidatedItemName("getLink_url()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) collectionEntry.getLink_url(), true, validationContext));
        validationContext.setValidatedItemName("getBackground()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) collectionEntry.getBackground(), true, validationContext));
        validationContext.setValidatedItemName("getType()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) collectionEntry.getType(), false, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) collectionEntry.getUser(), true, validationContext));
        validationContext.setValidatedItemName("getPost()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) collectionEntry.getPost(), true, validationContext));
        validationContext.setValidatedItemName("getImage()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) collectionEntry.getImage(), true, validationContext));
        validationContext.setValidatedItemName("getPosts()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Collection<?>) collectionEntry.getPosts(), true, validationContext));
        validationContext.setValidatedItemName("getProducts()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Collection<?>) collectionEntry.getProducts(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) collectionEntry.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) collectionEntry.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) collectionEntry.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) collectionEntry.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) collectionEntry.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) collectionEntry.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Collection<?>) collectionEntry.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Collection<?>) collectionEntry.component10(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) collectionEntry.toString(), true, validationContext));
        if (mergeErrors17 != null && !mergeErrors17.isEmpty()) {
            throw new InvalidModelException(mergeErrors17);
        }
    }

    private void validateAs(CollectionImage collectionImage) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CollectionImage.class);
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) collectionImage.getUrl(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) collectionImage.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) collectionImage.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(FeedInfoResponse feedInfoResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(FeedInfoResponse.class);
        validationContext.setValidatedItemName("getPopularFeedVersion()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) feedInfoResponse.getPopularFeedVersion(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) feedInfoResponse.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) feedInfoResponse.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(RelatedPost relatedPost) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(RelatedPost.class);
        validationContext.setValidatedItemName("getFollowersNewPost()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) relatedPost.getFollowersNewPost(), true, validationContext));
        validationContext.setValidatedItemName("getPosts()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) relatedPost.getPosts(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) relatedPost.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) relatedPost.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) relatedPost.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(CreatePost createPost) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CreatePost.class);
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) createPost.getTitle(), true, validationContext));
        validationContext.setValidatedItemName("getAboutFit()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) createPost.getAboutFit(), true, validationContext));
        validationContext.setValidatedItemName("getAboutProduct()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) createPost.getAboutProduct(), true, validationContext));
        validationContext.setValidatedItemName("getCoverImagePath()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) createPost.getCoverImagePath(), true, validationContext));
        validationContext.setValidatedItemName("getFreeformImagesPath()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Collection<?>) createPost.getFreeformImagesPath(), true, validationContext));
        validationContext.setValidatedItemName("getFreeformImageIDs()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Collection<?>) createPost.getFreeformImageIDs(), true, validationContext));
        validationContext.setValidatedItemName("getTags()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Collection<?>) createPost.getTags(), true, validationContext));
        validationContext.setValidatedItemName("getStyleTags()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Collection<?>) createPost.getStyleTags(), true, validationContext));
        validationContext.setValidatedItemName("getAboutSize()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) createPost.getAboutSize(), true, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) createPost.getShop(), true, validationContext));
        validationContext.setValidatedItemName("getShopName()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) createPost.getShopName(), true, validationContext));
        validationContext.setValidatedItemName("getPrice()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) createPost.getPrice(), true, validationContext));
        validationContext.setValidatedItemName("getShopImage()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) createPost.getShopImage(), true, validationContext));
        validationContext.setValidatedItemName("getPostType()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) createPost.getPostType(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) createPost.toString(), true, validationContext));
        if (mergeErrors15 != null && !mergeErrors15.isEmpty()) {
            throw new InvalidModelException(mergeErrors15);
        }
    }

    private void validateAs(Post post) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Post.class);
        validationContext.setValidatedItemName("categoryGroup()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) post.categoryGroup(), true, validationContext));
        validationContext.setValidatedItemName("postType()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) post.postType(), true, validationContext));
        validationContext.setValidatedItemName("getBanner()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) post.getBanner(), true, validationContext));
        validationContext.setValidatedItemName("getId()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) Long.valueOf(post.getId()), false, validationContext));
        validationContext.setValidatedItemName("getState()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) post.getState(), true, validationContext));
        validationContext.setValidatedItemName("getInactiveReason()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) post.getInactiveReason(), true, validationContext));
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) post.getTitle(), false, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) post.getUser(), true, validationContext));
        validationContext.setValidatedItemName("getAboutFit()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) post.getAboutFit(), false, validationContext));
        validationContext.setValidatedItemName("getAboutProduct()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) post.getAboutProduct(), true, validationContext));
        validationContext.setValidatedItemName("getAboutSize()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) post.getAboutSize(), true, validationContext));
        validationContext.setValidatedItemName("getCoverImage()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) post.getCoverImage(), true, validationContext));
        validationContext.setValidatedItemName("getFreeformImages()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Collection<?>) post.getFreeformImages(), true, validationContext));
        validationContext.setValidatedItemName("getCloseshotImages()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Collection<?>) post.getCloseshotImages(), true, validationContext));
        validationContext.setValidatedItemName("getFullshotImages()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Collection<?>) post.getFullshotImages(), true, validationContext));
        validationContext.setValidatedItemName("getDetailImages()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Collection<?>) post.getDetailImages(), true, validationContext));
        validationContext.setValidatedItemName("getStars()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) Float.valueOf(post.getStars()), false, validationContext));
        validationContext.setValidatedItemName("getLinkInfo()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) post.getLinkInfo(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) post.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("getQuotedComments()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Collection<?>) post.getQuotedComments(), true, validationContext));
        validationContext.setValidatedItemName("getTags()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Collection<?>) post.getTags(), true, validationContext));
        validationContext.setValidatedItemName("getStyles()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Collection<?>) post.getStyles(), true, validationContext));
        validationContext.setValidatedItemName("getLineItemVariant()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) post.getLineItemVariant(), true, validationContext));
        validationContext.setValidatedItemName("getCategories()");
        List mergeErrors24 = BaseValidator.mergeErrors(mergeErrors23, BaseValidator.checkNullable((Collection<?>) post.getCategories(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors25 = BaseValidator.mergeErrors(mergeErrors24, BaseValidator.checkNullable((Object) post.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors26 = BaseValidator.mergeErrors(mergeErrors25, BaseValidator.checkNullable((Object) post.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors27 = BaseValidator.mergeErrors(mergeErrors26, BaseValidator.checkNullable((Object) post.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors28 = BaseValidator.mergeErrors(mergeErrors27, BaseValidator.checkNullable((Object) post.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors29 = BaseValidator.mergeErrors(mergeErrors28, BaseValidator.checkNullable((Object) post.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors30 = BaseValidator.mergeErrors(mergeErrors29, BaseValidator.checkNullable((Object) post.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors31 = BaseValidator.mergeErrors(mergeErrors30, BaseValidator.checkNullable((Object) post.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors32 = BaseValidator.mergeErrors(mergeErrors31, BaseValidator.checkNullable((Object) post.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors33 = BaseValidator.mergeErrors(mergeErrors32, BaseValidator.checkNullable((Collection<?>) post.component10(), true, validationContext));
        validationContext.setValidatedItemName("component11()");
        List mergeErrors34 = BaseValidator.mergeErrors(mergeErrors33, BaseValidator.checkNullable((Collection<?>) post.component11(), true, validationContext));
        validationContext.setValidatedItemName("component12()");
        List mergeErrors35 = BaseValidator.mergeErrors(mergeErrors34, BaseValidator.checkNullable((Collection<?>) post.component12(), true, validationContext));
        validationContext.setValidatedItemName("component13()");
        List mergeErrors36 = BaseValidator.mergeErrors(mergeErrors35, BaseValidator.checkNullable((Collection<?>) post.component13(), true, validationContext));
        validationContext.setValidatedItemName("component15()");
        List mergeErrors37 = BaseValidator.mergeErrors(mergeErrors36, BaseValidator.checkNullable((Object) post.component15(), true, validationContext));
        validationContext.setValidatedItemName("component16()");
        List mergeErrors38 = BaseValidator.mergeErrors(mergeErrors37, BaseValidator.checkNullable((Object) post.component16(), true, validationContext));
        validationContext.setValidatedItemName("component20()");
        List mergeErrors39 = BaseValidator.mergeErrors(mergeErrors38, BaseValidator.checkNullable((Collection<?>) post.component20(), true, validationContext));
        validationContext.setValidatedItemName("component21()");
        List mergeErrors40 = BaseValidator.mergeErrors(mergeErrors39, BaseValidator.checkNullable((Collection<?>) post.component21(), true, validationContext));
        validationContext.setValidatedItemName("component22()");
        List mergeErrors41 = BaseValidator.mergeErrors(mergeErrors40, BaseValidator.checkNullable((Collection<?>) post.component22(), true, validationContext));
        validationContext.setValidatedItemName("component24()");
        List mergeErrors42 = BaseValidator.mergeErrors(mergeErrors41, BaseValidator.checkNullable((Object) post.component24(), true, validationContext));
        validationContext.setValidatedItemName("component25()");
        List mergeErrors43 = BaseValidator.mergeErrors(mergeErrors42, BaseValidator.checkNullable((Collection<?>) post.component25(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors44 = BaseValidator.mergeErrors(mergeErrors43, BaseValidator.checkNullable((Object) post.toString(), true, validationContext));
        if (mergeErrors44 != null && !mergeErrors44.isEmpty()) {
            throw new InvalidModelException(mergeErrors44);
        }
    }

    private void validateAs(Category category) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Category.class);
        validationContext.setValidatedItemName("getGroup()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) category.getGroup(), false, validationContext));
        validationContext.setValidatedItemName("getSection()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) category.getSection(), true, validationContext));
        validationContext.setValidatedItemName("getSubsection()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) category.getSubsection(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) category.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) category.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) category.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) category.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(Tag tag) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Tag.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(tag.getId()), false, validationContext));
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) tag.getTitle(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) tag.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) tag.toString(), true, validationContext));
        if (mergeErrors4 != null && !mergeErrors4.isEmpty()) {
            throw new InvalidModelException(mergeErrors4);
        }
    }

    private void validateAs(Style style) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Style.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(style.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) style.getName(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) style.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) style.toString(), true, validationContext));
        if (mergeErrors4 != null && !mergeErrors4.isEmpty()) {
            throw new InvalidModelException(mergeErrors4);
        }
    }

    private void validateAs(LinkInfo linkInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(LinkInfo.class);
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) linkInfo.getLinkUrl(), false, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) linkInfo.getShop(), true, validationContext));
        validationContext.setValidatedItemName("getProduct()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) linkInfo.getProduct(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) linkInfo.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) linkInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) linkInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) linkInfo.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(ResponseImageId responseImageId) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ResponseImageId.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) responseImageId.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(PostId postId) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PostId.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) postId.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(PostContent postContent) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PostContent.class);
        validationContext.setValidatedItemName("getDescription()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) postContent.getDescription(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) postContent.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) postContent.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(PostInvoice postInvoice) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PostInvoice.class);
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) postInvoice.getUser(), false, validationContext));
        validationContext.setValidatedItemName("getPost()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) postInvoice.getPost(), false, validationContext));
        validationContext.setValidatedItemName("getDescription()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) postInvoice.getDescription(), true, validationContext));
        validationContext.setValidatedItemName("getAction()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) postInvoice.getAction(), false, validationContext));
        validationContext.setValidatedItemName("getInactivatedAt()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) postInvoice.getInactivatedAt(), true, validationContext));
        validationContext.setValidatedItemName("getDeactivatedAt()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) postInvoice.getDeactivatedAt(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) postInvoice.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) postInvoice.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) postInvoice.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) postInvoice.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) postInvoice.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) postInvoice.component7(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) postInvoice.toString(), true, validationContext));
        if (mergeErrors13 != null && !mergeErrors13.isEmpty()) {
            throw new InvalidModelException(mergeErrors13);
        }
    }

    private void validateAs(CategoryData categoryData) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CategoryData.class);
        validationContext.setValidatedItemName("getSection()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) categoryData.getSection(), true, validationContext));
        validationContext.setValidatedItemName("getIcon()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) categoryData.getIcon(), true, validationContext));
        validationContext.setValidatedItemName("getSubSections()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) categoryData.getSubSections(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) categoryData.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) categoryData.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Collection<?>) categoryData.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) categoryData.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(CouponEnrollResult couponEnrollResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CouponEnrollResult.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) couponEnrollResult.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(PaymentHistory paymentHistory) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PaymentHistory.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) paymentHistory.getType(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) paymentHistory.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) paymentHistory.getCreatedAt(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) paymentHistory.component2(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) paymentHistory.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) paymentHistory.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) paymentHistory.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(PaymentUsage paymentUsage) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PaymentUsage.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkIntRange(validationContext, paymentUsage.getId(), 1, Long.MAX_VALUE));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) paymentUsage.getUser(), false, validationContext));
        validationContext.setValidatedItemName("getCoupon()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) paymentUsage.getCoupon(), true, validationContext));
        validationContext.setValidatedItemName("getColor()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) paymentUsage.getColor(), true, validationContext));
        validationContext.setValidatedItemName("getSize()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) paymentUsage.getSize(), true, validationContext));
        validationContext.setValidatedItemName("getShippingName()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) paymentUsage.getShippingName(), false, validationContext));
        validationContext.setValidatedItemName("getShippingContact()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) paymentUsage.getShippingContact(), false, validationContext));
        validationContext.setValidatedItemName("getShippingAddress()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) paymentUsage.getShippingAddress(), false, validationContext));
        validationContext.setValidatedItemName("getShippingAddress2()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) paymentUsage.getShippingAddress2(), true, validationContext));
        validationContext.setValidatedItemName("getShippingZipCode()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) paymentUsage.getShippingZipCode(), true, validationContext));
        validationContext.setValidatedItemName("getShippingMessage()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) paymentUsage.getShippingMessage(), true, validationContext));
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) paymentUsage.getLinkUrl(), false, validationContext));
        validationContext.setValidatedItemName("getProduct()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) paymentUsage.getProduct(), true, validationContext));
        validationContext.setValidatedItemName("getStatus()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) paymentUsage.getStatus(), false, validationContext));
        validationContext.setValidatedItemName("getShippedAt()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) paymentUsage.getShippedAt(), true, validationContext));
        validationContext.setValidatedItemName("getCompletedAt()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) paymentUsage.getCompletedAt(), true, validationContext));
        validationContext.setValidatedItemName("getRejectedDescription()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) paymentUsage.getRejectedDescription(), true, validationContext));
        validationContext.setValidatedItemName("getRejectedAt()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) paymentUsage.getRejectedAt(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) paymentUsage.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Object) paymentUsage.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Object) paymentUsage.component3(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Object) paymentUsage.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) paymentUsage.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors24 = BaseValidator.mergeErrors(mergeErrors23, BaseValidator.checkNullable((Object) paymentUsage.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors25 = BaseValidator.mergeErrors(mergeErrors24, BaseValidator.checkNullable((Object) paymentUsage.component10(), true, validationContext));
        validationContext.setValidatedItemName("component11()");
        List mergeErrors26 = BaseValidator.mergeErrors(mergeErrors25, BaseValidator.checkNullable((Object) paymentUsage.component11(), true, validationContext));
        validationContext.setValidatedItemName("component12()");
        List mergeErrors27 = BaseValidator.mergeErrors(mergeErrors26, BaseValidator.checkNullable((Object) paymentUsage.component12(), true, validationContext));
        validationContext.setValidatedItemName("component13()");
        List mergeErrors28 = BaseValidator.mergeErrors(mergeErrors27, BaseValidator.checkNullable((Object) paymentUsage.component13(), true, validationContext));
        validationContext.setValidatedItemName("component14()");
        List mergeErrors29 = BaseValidator.mergeErrors(mergeErrors28, BaseValidator.checkNullable((Object) paymentUsage.component14(), true, validationContext));
        validationContext.setValidatedItemName("component15()");
        List mergeErrors30 = BaseValidator.mergeErrors(mergeErrors29, BaseValidator.checkNullable((Object) paymentUsage.component15(), true, validationContext));
        validationContext.setValidatedItemName("component16()");
        List mergeErrors31 = BaseValidator.mergeErrors(mergeErrors30, BaseValidator.checkNullable((Object) paymentUsage.component16(), true, validationContext));
        validationContext.setValidatedItemName("component17()");
        List mergeErrors32 = BaseValidator.mergeErrors(mergeErrors31, BaseValidator.checkNullable((Object) paymentUsage.component17(), true, validationContext));
        validationContext.setValidatedItemName("component18()");
        List mergeErrors33 = BaseValidator.mergeErrors(mergeErrors32, BaseValidator.checkNullable((Object) paymentUsage.component18(), true, validationContext));
        validationContext.setValidatedItemName("component19()");
        List mergeErrors34 = BaseValidator.mergeErrors(mergeErrors33, BaseValidator.checkNullable((Object) paymentUsage.component19(), true, validationContext));
        validationContext.setValidatedItemName("component20()");
        List mergeErrors35 = BaseValidator.mergeErrors(mergeErrors34, BaseValidator.checkNullable((Object) paymentUsage.component20(), true, validationContext));
        validationContext.setValidatedItemName("component21()");
        List mergeErrors36 = BaseValidator.mergeErrors(mergeErrors35, BaseValidator.checkNullable((Object) paymentUsage.component21(), true, validationContext));
        validationContext.setValidatedItemName("component22()");
        List mergeErrors37 = BaseValidator.mergeErrors(mergeErrors36, BaseValidator.checkNullable((Object) paymentUsage.component22(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors38 = BaseValidator.mergeErrors(mergeErrors37, BaseValidator.checkNullable((Object) paymentUsage.toString(), true, validationContext));
        if (mergeErrors38 != null && !mergeErrors38.isEmpty()) {
            throw new InvalidModelException(mergeErrors38);
        }
    }

    private void validateAs(PostableResponse postableResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PostableResponse.class);
        validationContext.setValidatedItemName("getUnpostableReason()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) postableResponse.getUnpostableReason(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) postableResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) postableResponse.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(UnpostableReason unpostableReason) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(UnpostableReason.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) unpostableReason.getType(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) unpostableReason.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) unpostableReason.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(ShippingAddressResponse shippingAddressResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ShippingAddressResponse.class);
        validationContext.setValidatedItemName("getName()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) shippingAddressResponse.getName(), false, validationContext));
        validationContext.setValidatedItemName("getContact()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) shippingAddressResponse.getContact(), false, validationContext));
        validationContext.setValidatedItemName("getZipCode()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) shippingAddressResponse.getZipCode(), false, validationContext));
        validationContext.setValidatedItemName("getAddress()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) shippingAddressResponse.getAddress(), false, validationContext));
        validationContext.setValidatedItemName("getAddress2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) shippingAddressResponse.getAddress2(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) shippingAddressResponse.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) shippingAddressResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) shippingAddressResponse.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) shippingAddressResponse.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) shippingAddressResponse.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) shippingAddressResponse.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) shippingAddressResponse.component7(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) shippingAddressResponse.toString(), true, validationContext));
        if (mergeErrors13 != null && !mergeErrors13.isEmpty()) {
            throw new InvalidModelException(mergeErrors13);
        }
    }

    private void validateAs(UserAPI.ResponseImageId responseImageId) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(UserAPI.ResponseImageId.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) responseImageId.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(Reward reward) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Reward.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) reward.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(Enroll enroll) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Enroll.class);
        validationContext.setValidatedItemName("getStatus()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) enroll.getStatus(), true, validationContext));
        validationContext.setValidatedItemName("getCreated_at()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) enroll.getCreated_at(), true, validationContext));
        validationContext.setValidatedItemName("getReject_description()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) enroll.getReject_description(), true, validationContext));
        validationContext.setValidatedItemName("getRejected_at()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) enroll.getRejected_at(), true, validationContext));
        validationContext.setValidatedItemName("getReward_points_at_confirm()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) enroll.getReward_points_at_confirm(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) enroll.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) enroll.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) enroll.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) enroll.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) enroll.component6(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) enroll.toString(), true, validationContext));
        if (mergeErrors11 != null && !mergeErrors11.isEmpty()) {
            throw new InvalidModelException(mergeErrors11);
        }
    }

    private void validateAs(Me me2) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Me.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkIntRange(validationContext, me2.getId(), 1, Long.MAX_VALUE));
        validationContext.setValidatedItemName("getFittsid()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) me2.getFittsid(), false, validationContext));
        validationContext.setValidatedItemName("getAuth_token()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) me2.getAuth_token(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) me2.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) me2.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) me2.toString(), true, validationContext));
        if (mergeErrors6 != null && !mergeErrors6.isEmpty()) {
            throw new InvalidModelException(mergeErrors6);
        }
    }

    private void validateAs(EmailAvailable emailAvailable) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(EmailAvailable.class);
        validationContext.setValidatedItemName("getEmail()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) emailAvailable.getEmail(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) emailAvailable.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) emailAvailable.component1(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) emailAvailable.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) emailAvailable.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(IdAvailable idAvailable) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(IdAvailable.class);
        validationContext.setValidatedItemName("getFittsid()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) idAvailable.getFittsid(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) idAvailable.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) idAvailable.component1(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) idAvailable.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) idAvailable.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(UserInvoice userInvoice) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(UserInvoice.class);
        validationContext.setValidatedItemName("getAction()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) userInvoice.getAction(), false, validationContext));
        validationContext.setValidatedItemName("getType()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) userInvoice.getType(), false, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) userInvoice.getCreatedAt(), true, validationContext));
        validationContext.setValidatedItemName("getRejectedAt()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) userInvoice.getRejectedAt(), true, validationContext));
        validationContext.setValidatedItemName("getReward()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) userInvoice.getReward(), true, validationContext));
        validationContext.setValidatedItemName("getVerifyAt()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) userInvoice.getVerifyAt(), true, validationContext));
        validationContext.setValidatedItemName("getRejectDescription()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) userInvoice.getRejectDescription(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) userInvoice.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) userInvoice.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) userInvoice.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) userInvoice.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) userInvoice.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) userInvoice.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) userInvoice.component8(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) userInvoice.toString(), true, validationContext));
        if (mergeErrors15 != null && !mergeErrors15.isEmpty()) {
            throw new InvalidModelException(mergeErrors15);
        }
    }

    private void validateAs(IvsInfo ivsInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(IvsInfo.class);
        validationContext.setValidatedItemName("getDateOfBirth()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) ivsInfo.getDateOfBirth(), true, validationContext));
        validationContext.setValidatedItemName("getGenderNumber()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) ivsInfo.getGenderNumber(), true, validationContext));
        validationContext.setValidatedItemName("getContactInfo()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) ivsInfo.getContactInfo(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) ivsInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) ivsInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) ivsInfo.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) ivsInfo.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(AvailableCouponCountResponse availableCouponCountResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AvailableCouponCountResponse.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) availableCouponCountResponse.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(CouponInfo couponInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CouponInfo.class);
        validationContext.setValidatedItemName("getState()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) couponInfo.getState(), false, validationContext));
        validationContext.setValidatedItemName("getStartDate()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) couponInfo.getStartDate(), true, validationContext));
        validationContext.setValidatedItemName("getEndDate()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) couponInfo.getEndDate(), true, validationContext));
        validationContext.setValidatedItemName("getAgreement()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) couponInfo.getAgreement(), true, validationContext));
        validationContext.setValidatedItemName("getDisplayMessage()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) couponInfo.getDisplayMessage(), true, validationContext));
        validationContext.setValidatedItemName("getMinOrderPrice()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) couponInfo.getMinOrderPrice(), true, validationContext));
        validationContext.setValidatedItemName("getAgreementImage()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) couponInfo.getAgreementImage(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) couponInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) couponInfo.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) couponInfo.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) couponInfo.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) couponInfo.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) couponInfo.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) couponInfo.component10(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) couponInfo.toString(), true, validationContext));
        if (mergeErrors15 != null && !mergeErrors15.isEmpty()) {
            throw new InvalidModelException(mergeErrors15);
        }
    }

    private void validateAs(CouponRegisterResult couponRegisterResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CouponRegisterResult.class);
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) couponRegisterResult.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) couponRegisterResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) couponRegisterResult.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(CouponAgreementApply couponAgreementApply) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(CouponAgreementApply.class);
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) couponAgreementApply.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) couponAgreementApply.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) couponAgreementApply.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(AgreementImage agreementImage) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AgreementImage.class);
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) agreementImage.getUrl(), true, validationContext));
        validationContext.setValidatedItemName("getRatio()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) agreementImage.getRatio(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) agreementImage.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) agreementImage.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) agreementImage.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(Image image) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Image.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(image.getId()), false, validationContext));
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) image.getUrl(), false, validationContext));
        validationContext.setValidatedItemName("getThumbnailUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) image.getThumbnailUrl(), true, validationContext));
        validationContext.setValidatedItemName("getDominantColor()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) image.getDominantColor(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) image.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) image.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) image.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) image.toString(), true, validationContext));
        if (mergeErrors8 != null && !mergeErrors8.isEmpty()) {
            throw new InvalidModelException(mergeErrors8);
        }
    }

    private void validateAs(SearchAPI.LinkInfo linkInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchAPI.LinkInfo.class);
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) linkInfo.getLinkUrl(), false, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) linkInfo.getShop(), true, validationContext));
        validationContext.setValidatedItemName("getProduct()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) linkInfo.getProduct(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) linkInfo.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) linkInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) linkInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) linkInfo.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(Comment comment) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Comment.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(comment.getId()), false, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) comment.getUser(), true, validationContext));
        validationContext.setValidatedItemName("getContent()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) comment.getContent(), true, validationContext));
        validationContext.setValidatedItemName("getMentionees()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable(comment.getMentionees(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) comment.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) comment.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable(comment.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) comment.toString(), true, validationContext));
        if (mergeErrors8 != null && !mergeErrors8.isEmpty()) {
            throw new InvalidModelException(mergeErrors8);
        }
    }

    private void validateAs(MentioneeInfo mentioneeInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(MentioneeInfo.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(mentioneeInfo.getId()), false, validationContext));
        validationContext.setValidatedItemName("isFittie()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Boolean.valueOf(mentioneeInfo.isFittie()), false, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) mentioneeInfo.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(SearchAPI.Tag tag) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchAPI.Tag.class);
        validationContext.setValidatedItemName("getName()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) tag.getName(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) tag.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) tag.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(SearchHomeResult searchHomeResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchHomeResult.class);
        validationContext.setValidatedItemName("getFitties()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) searchHomeResult.getFitties(), false, validationContext));
        validationContext.setValidatedItemName("getStyles()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) searchHomeResult.getStyles(), false, validationContext));
        validationContext.setValidatedItemName("getShops()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) searchHomeResult.getShops(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) searchHomeResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Collection<?>) searchHomeResult.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Collection<?>) searchHomeResult.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) searchHomeResult.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(SearchHomeResult.Style style) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchHomeResult.Style.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(style.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) style.getName(), false, validationContext));
        validationContext.setValidatedItemName("getImageUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) style.getImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) style.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) style.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) style.toString(), true, validationContext));
        if (mergeErrors6 != null && !mergeErrors6.isEmpty()) {
            throw new InvalidModelException(mergeErrors6);
        }
    }

    private void validateAs(Shop shop) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Shop.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(shop.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) shop.getName(), false, validationContext));
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) shop.getUrl(), false, validationContext));
        validationContext.setValidatedItemName("getDomains()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) shop.getDomains(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) shop.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) shop.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Collection<?>) shop.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) shop.toString(), true, validationContext));
        if (mergeErrors8 != null && !mergeErrors8.isEmpty()) {
            throw new InvalidModelException(mergeErrors8);
        }
    }

    private void validateAs(SearchPostResult searchPostResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchPostResult.class);
        validationContext.setValidatedItemName("getResults()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) searchPostResult.getResults(), false, validationContext));
        validationContext.setValidatedItemName("getTotalCount()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Integer.valueOf(searchPostResult.getTotalCount()), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) searchPostResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) searchPostResult.toString(), true, validationContext));
        if (mergeErrors4 != null && !mergeErrors4.isEmpty()) {
            throw new InvalidModelException(mergeErrors4);
        }
    }

    private void validateAs(PostEntry postEntry) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(PostEntry.class);
        validationContext.setValidatedItemName("categoryGroup()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) postEntry.categoryGroup(), true, validationContext));
        validationContext.setValidatedItemName("getId()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Long.valueOf(postEntry.getId()), false, validationContext));
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) postEntry.getTitle(), false, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) postEntry.getUser(), false, validationContext));
        validationContext.setValidatedItemName("getAboutFit()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) postEntry.getAboutFit(), true, validationContext));
        validationContext.setValidatedItemName("getAboutProduct()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) postEntry.getAboutProduct(), true, validationContext));
        validationContext.setValidatedItemName("getAboutSize()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) postEntry.getAboutSize(), true, validationContext));
        validationContext.setValidatedItemName("getCoverImage()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) postEntry.getCoverImage(), true, validationContext));
        validationContext.setValidatedItemName("getLinkInfo()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) postEntry.getLinkInfo(), false, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) postEntry.getCreatedAt(), true, validationContext));
        validationContext.setValidatedItemName("getTags()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Collection<?>) postEntry.getTags(), true, validationContext));
        validationContext.setValidatedItemName("getCategories()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Collection<?>) postEntry.getCategories(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) postEntry.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) postEntry.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) postEntry.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) postEntry.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) postEntry.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) postEntry.component7(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) postEntry.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Object) postEntry.component10(), true, validationContext));
        validationContext.setValidatedItemName("component15()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Collection<?>) postEntry.component15(), true, validationContext));
        validationContext.setValidatedItemName("component21()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Collection<?>) postEntry.component21(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) postEntry.toString(), true, validationContext));
        if (mergeErrors23 != null && !mergeErrors23.isEmpty()) {
            throw new InvalidModelException(mergeErrors23);
        }
    }

    private void validateAs(SearchShopResult searchShopResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchShopResult.class);
        validationContext.setValidatedItemName("getResults()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) searchShopResult.getResults(), false, validationContext));
        validationContext.setValidatedItemName("getTotalCount()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Integer.valueOf(searchShopResult.getTotalCount()), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) searchShopResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) searchShopResult.toString(), true, validationContext));
        if (mergeErrors4 != null && !mergeErrors4.isEmpty()) {
            throw new InvalidModelException(mergeErrors4);
        }
    }

    private void validateAs(ShopEntry shopEntry) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ShopEntry.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(shopEntry.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) shopEntry.getName(), false, validationContext));
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) shopEntry.getUrl(), false, validationContext));
        validationContext.setValidatedItemName("getDomains()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) shopEntry.getDomains(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) shopEntry.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) shopEntry.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Collection<?>) shopEntry.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) shopEntry.toString(), true, validationContext));
        if (mergeErrors8 != null && !mergeErrors8.isEmpty()) {
            throw new InvalidModelException(mergeErrors8);
        }
    }

    private void validateAs(SearchFittieResult searchFittieResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchFittieResult.class);
        validationContext.setValidatedItemName("getResults()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) searchFittieResult.getResults(), false, validationContext));
        validationContext.setValidatedItemName("getTotalCount()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Integer.valueOf(searchFittieResult.getTotalCount()), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) searchFittieResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) searchFittieResult.toString(), true, validationContext));
        if (mergeErrors4 != null && !mergeErrors4.isEmpty()) {
            throw new InvalidModelException(mergeErrors4);
        }
    }

    private void validateAs(RecommendationSection recommendationSection) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(RecommendationSection.class);
        validationContext.setValidatedItemName("getTitle()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) recommendationSection.getTitle(), false, validationContext));
        validationContext.setValidatedItemName("getSectionType()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) recommendationSection.getSectionType(), false, validationContext));
        validationContext.setValidatedItemName("getItems()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) recommendationSection.getItems(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) recommendationSection.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) recommendationSection.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Collection<?>) recommendationSection.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) recommendationSection.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(Item item) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Item.class);
        validationContext.setValidatedItemName("getImageUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) item.getImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getScheme()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) item.getScheme(), true, validationContext));
        validationContext.setValidatedItemName("getLabel1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) item.getLabel1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) item.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) item.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) item.component4(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) item.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(BadgeResponse badgeResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(BadgeResponse.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) badgeResponse.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(TimestampResponse timestampResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(TimestampResponse.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) timestampResponse.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(SearchRecommend searchRecommend) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SearchRecommend.class);
        validationContext.setValidatedItemName("getSearchKeywords()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) searchRecommend.getSearchKeywords(), true, validationContext));
        validationContext.setValidatedItemName("getRecommendStyles()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) searchRecommend.getRecommendStyles(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) searchRecommend.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) searchRecommend.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) searchRecommend.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(ImageUrlWithRatio imageUrlWithRatio) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ImageUrlWithRatio.class);
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) imageUrlWithRatio.getUrl(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) imageUrlWithRatio.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) imageUrlWithRatio.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(Product product) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Product.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkIntRange(validationContext, product.getId(), 1, Long.MAX_VALUE));
        validationContext.setValidatedItemName("getProductNumber()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) product.getProductNumber(), true, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) product.getShop(), true, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) product.getName(), true, validationContext));
        validationContext.setValidatedItemName("getPrice()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) product.getPrice(), true, validationContext));
        validationContext.setValidatedItemName("getImageUrl()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) product.getImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) product.getLinkUrl(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) product.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) product.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) product.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) product.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) product.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) product.component7(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) product.toString(), true, validationContext));
        if (mergeErrors14 != null && !mergeErrors14.isEmpty()) {
            throw new InvalidModelException(mergeErrors14);
        }
    }

    private void validateAs(kr.co.popone.fitts.model.datamodel.commerce.Shop shop) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(kr.co.popone.fitts.model.datamodel.commerce.Shop.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(shop.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) shop.getName(), true, validationContext));
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) shop.getUrl(), true, validationContext));
        validationContext.setValidatedItemName("getDomainNames()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) shop.getDomainNames(), true, validationContext));
        validationContext.setValidatedItemName("getHost()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) shop.getHost(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) shop.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) shop.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Collection<?>) shop.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) shop.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) shop.toString(), true, validationContext));
        if (mergeErrors10 != null && !mergeErrors10.isEmpty()) {
            throw new InvalidModelException(mergeErrors10);
        }
    }

    private void validateAs(SpecialDiscountInfo specialDiscountInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(SpecialDiscountInfo.class);
        validationContext.setValidatedItemName("toFeedItem()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) specialDiscountInfo.toFeedItem(), true, validationContext));
        validationContext.setValidatedItemName("getStartDate()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) specialDiscountInfo.getStartDate(), true, validationContext));
        validationContext.setValidatedItemName("getEndDate()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) specialDiscountInfo.getEndDate(), true, validationContext));
        validationContext.setValidatedItemName("getCurrentDate()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) specialDiscountInfo.getCurrentDate(), true, validationContext));
        validationContext.setValidatedItemName("getOpenImageUrl()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) specialDiscountInfo.getOpenImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getComingSoonImageUrl()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) specialDiscountInfo.getComingSoonImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getState()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) specialDiscountInfo.getState(), true, validationContext));
        validationContext.setValidatedItemName("getSpecialDiscounts()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Collection<?>) specialDiscountInfo.getSpecialDiscounts(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) specialDiscountInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) specialDiscountInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) specialDiscountInfo.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) specialDiscountInfo.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) specialDiscountInfo.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) specialDiscountInfo.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Collection<?>) specialDiscountInfo.component8(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) specialDiscountInfo.toString(), true, validationContext));
        if (mergeErrors16 != null && !mergeErrors16.isEmpty()) {
            throw new InvalidModelException(mergeErrors16);
        }
    }

    private void validateAs(kr.co.popone.fitts.model.datamodel.service.post.Image image) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(kr.co.popone.fitts.model.datamodel.service.post.Image.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Integer.valueOf(image.getId()), false, validationContext));
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) image.getUrl(), false, validationContext));
        validationContext.setValidatedItemName("getThumbnail()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) image.getThumbnail(), true, validationContext));
        validationContext.setValidatedItemName("getSmall()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) image.getSmall(), true, validationContext));
        validationContext.setValidatedItemName("getLqip()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) image.getLqip(), true, validationContext));
        validationContext.setValidatedItemName("getDescription()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) image.getDescription(), true, validationContext));
        validationContext.setValidatedItemName("getDominantColor()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) image.getDominantColor(), false, validationContext));
        validationContext.setValidatedItemName("getWidth()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) image.getWidth(), true, validationContext));
        validationContext.setValidatedItemName("getHeight()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) image.getHeight(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) image.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) image.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) image.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) image.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) image.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) image.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) image.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) image.component10(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) image.toString(), true, validationContext));
        if (mergeErrors18 != null && !mergeErrors18.isEmpty()) {
            throw new InvalidModelException(mergeErrors18);
        }
    }

    private void validateAs(LikeResult likeResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(LikeResult.class);
        validationContext.setValidatedItemName("getResult()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) likeResult.getResult(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) likeResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) likeResult.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(kr.co.popone.fitts.model.datamodel.service.post.Comment comment) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(kr.co.popone.fitts.model.datamodel.service.post.Comment.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(comment.getId()), false, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) comment.getUser(), false, validationContext));
        validationContext.setValidatedItemName("getContent()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) comment.getContent(), false, validationContext));
        validationContext.setValidatedItemName("getMentionees()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) comment.getMentionees(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) comment.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) comment.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) comment.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) comment.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) comment.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) comment.toString(), true, validationContext));
        if (mergeErrors10 != null && !mergeErrors10.isEmpty()) {
            throw new InvalidModelException(mergeErrors10);
        }
    }

    private void validateAs(ShowRoom showRoom) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ShowRoom.class);
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) showRoom.getUser(), false, validationContext));
        validationContext.setValidatedItemName("getShowRoomIntro()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) showRoom.getShowRoomIntro(), true, validationContext));
        validationContext.setValidatedItemName("getShowRoomCoverImageUrl()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) showRoom.getShowRoomCoverImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) showRoom.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) showRoom.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) showRoom.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) showRoom.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(BodyInfo bodyInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(BodyInfo.class);
        validationContext.setValidatedItemName("toSimpleInfo()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) bodyInfo.toSimpleInfo(), true, validationContext));
        validationContext.setValidatedItemName("getBodyType()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) bodyInfo.getBodyType(), false, validationContext));
        validationContext.setValidatedItemName("getWeight()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkIntRange(validationContext, (long) bodyInfo.getWeight(), 1, Long.MAX_VALUE));
        validationContext.setValidatedItemName("getHeight()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkIntRange(validationContext, (long) bodyInfo.getHeight(), 1, Long.MAX_VALUE));
        validationContext.setValidatedItemName("getTop()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) bodyInfo.getTop(), true, validationContext));
        validationContext.setValidatedItemName("getBottom()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) bodyInfo.getBottom(), true, validationContext));
        validationContext.setValidatedItemName("getFootDescription()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) bodyInfo.getFootDescription(), true, validationContext));
        validationContext.setValidatedItemName("getDescription()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) bodyInfo.getDescription(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) bodyInfo.component1(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) bodyInfo.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) bodyInfo.component5(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) bodyInfo.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) bodyInfo.component8(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) bodyInfo.toString(), true, validationContext));
        if (mergeErrors14 != null && !mergeErrors14.isEmpty()) {
            throw new InvalidModelException(mergeErrors14);
        }
    }

    private void validateAs(BodyFilter bodyFilter) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(BodyFilter.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) bodyFilter.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(MyInfo myInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(MyInfo.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(myInfo.getId()), false, validationContext));
        validationContext.setValidatedItemName("getEmail()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) myInfo.getEmail(), false, validationContext));
        validationContext.setValidatedItemName("getFittsID()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) myInfo.getFittsID(), false, validationContext));
        validationContext.setValidatedItemName("getActiveStatus()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) myInfo.getActiveStatus(), false, validationContext));
        validationContext.setValidatedItemName("getVerifyState()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) myInfo.getVerifyState(), true, validationContext));
        validationContext.setValidatedItemName("getContactInfo()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) myInfo.getContactInfo(), true, validationContext));
        validationContext.setValidatedItemName("getProfileImageUrl()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) myInfo.getProfileImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("isFollowing()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) Boolean.valueOf(myInfo.isFollowing()), false, validationContext));
        validationContext.setValidatedItemName("getBodyInfo()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) myInfo.getBodyInfo(), false, validationContext));
        validationContext.setValidatedItemName("getBodyFilter()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) myInfo.getBodyFilter(), true, validationContext));
        validationContext.setValidatedItemName("getLikesCount()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) myInfo.getLikesCount(), true, validationContext));
        validationContext.setValidatedItemName("getPostsCount()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) myInfo.getPostsCount(), true, validationContext));
        validationContext.setValidatedItemName("getStyles()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Collection<?>) myInfo.getStyles(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) myInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) myInfo.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) myInfo.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) myInfo.component5(), true, validationContext));
        validationContext.setValidatedItemName("component13()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) myInfo.component13(), true, validationContext));
        validationContext.setValidatedItemName("component14()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) myInfo.component14(), true, validationContext));
        validationContext.setValidatedItemName("component16()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Object) myInfo.component16(), true, validationContext));
        validationContext.setValidatedItemName("component17()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Object) myInfo.component17(), true, validationContext));
        validationContext.setValidatedItemName("component21()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Object) myInfo.component21(), true, validationContext));
        validationContext.setValidatedItemName("component22()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) myInfo.component22(), true, validationContext));
        validationContext.setValidatedItemName("component23()");
        List mergeErrors24 = BaseValidator.mergeErrors(mergeErrors23, BaseValidator.checkNullable((Collection<?>) myInfo.component23(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors25 = BaseValidator.mergeErrors(mergeErrors24, BaseValidator.checkNullable((Object) myInfo.toString(), true, validationContext));
        if (mergeErrors25 != null && !mergeErrors25.isEmpty()) {
            throw new InvalidModelException(mergeErrors25);
        }
    }

    private void validateAs(User user) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(User.class);
        validationContext.setValidatedItemName("getFollowStateText()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) user.getFollowStateText(), true, validationContext));
        validationContext.setValidatedItemName("getId()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) Long.valueOf(user.getId()), false, validationContext));
        validationContext.setValidatedItemName("getEmail()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) user.getEmail(), true, validationContext));
        validationContext.setValidatedItemName("getFittsID()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) user.getFittsID(), false, validationContext));
        validationContext.setValidatedItemName("getStatus()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) user.getStatus(), true, validationContext));
        validationContext.setValidatedItemName("getVerifyState()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) user.getVerifyState(), true, validationContext));
        validationContext.setValidatedItemName("getProfileImageUrl()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) user.getProfileImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getRewardPoints()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) user.getRewardPoints(), true, validationContext));
        validationContext.setValidatedItemName("isFollowing()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) Boolean.valueOf(user.isFollowing()), false, validationContext));
        validationContext.setValidatedItemName("getBodyInfo()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) user.getBodyInfo(), true, validationContext));
        validationContext.setValidatedItemName("getFollowingsCount()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) user.getFollowingsCount(), true, validationContext));
        validationContext.setValidatedItemName("getFollowersCount()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) user.getFollowersCount(), true, validationContext));
        validationContext.setValidatedItemName("getPostsCount()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) user.getPostsCount(), true, validationContext));
        validationContext.setValidatedItemName("getStyles()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Collection<?>) user.getStyles(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) user.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) user.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) user.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) user.component5(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) user.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Object) user.component8(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Object) user.component10(), true, validationContext));
        validationContext.setValidatedItemName("component11()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Object) user.component11(), true, validationContext));
        validationContext.setValidatedItemName("component12()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) user.component12(), true, validationContext));
        validationContext.setValidatedItemName("component13()");
        List mergeErrors24 = BaseValidator.mergeErrors(mergeErrors23, BaseValidator.checkNullable((Object) user.component13(), true, validationContext));
        validationContext.setValidatedItemName("component15()");
        List mergeErrors25 = BaseValidator.mergeErrors(mergeErrors24, BaseValidator.checkNullable((Collection<?>) user.component15(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors26 = BaseValidator.mergeErrors(mergeErrors25, BaseValidator.checkNullable((Object) user.toString(), true, validationContext));
        if (mergeErrors26 != null && !mergeErrors26.isEmpty()) {
            throw new InvalidModelException(mergeErrors26);
        }
    }

    private void validateAs(ContactInfo contactInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(ContactInfo.class);
        validationContext.setValidatedItemName("getName()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) contactInfo.getName(), true, validationContext));
        validationContext.setValidatedItemName("getContact()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) contactInfo.getContact(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) contactInfo.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) contactInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) contactInfo.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(FollowResult followResult) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(FollowResult.class);
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) followResult.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) followResult.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) followResult.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(AlarmCount alarmCount) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AlarmCount.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) alarmCount.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(AlarmAgreement alarmAgreement) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AlarmAgreement.class);
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) alarmAgreement.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) alarmAgreement.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) alarmAgreement.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(Alarm alarm) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Alarm.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(alarm.getId()), false, validationContext));
        validationContext.setValidatedItemName("getType()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) alarm.getType(), true, validationContext));
        validationContext.setValidatedItemName("getState()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) alarm.getState(), true, validationContext));
        validationContext.setValidatedItemName("getUser()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) alarm.getUser(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) alarm.getMessage(), false, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) alarm.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("getRewardInvoice()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) alarm.getRewardInvoice(), true, validationContext));
        validationContext.setValidatedItemName("getApplication()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) alarm.getApplication(), true, validationContext));
        validationContext.setValidatedItemName("getUserInvoice()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) alarm.getUserInvoice(), true, validationContext));
        validationContext.setValidatedItemName("getPost()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) alarm.getPost(), true, validationContext));
        validationContext.setValidatedItemName("getCollection()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) alarm.getCollection(), true, validationContext));
        validationContext.setValidatedItemName("getComment()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Object) alarm.getComment(), true, validationContext));
        validationContext.setValidatedItemName("getScheme()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Object) alarm.getScheme(), true, validationContext));
        validationContext.setValidatedItemName("getReward()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) alarm.getReward(), true, validationContext));
        validationContext.setValidatedItemName("getRecommend()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) alarm.getRecommend(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors16 = BaseValidator.mergeErrors(mergeErrors15, BaseValidator.checkNullable((Object) alarm.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors17 = BaseValidator.mergeErrors(mergeErrors16, BaseValidator.checkNullable((Object) alarm.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors18 = BaseValidator.mergeErrors(mergeErrors17, BaseValidator.checkNullable((Object) alarm.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors19 = BaseValidator.mergeErrors(mergeErrors18, BaseValidator.checkNullable((Object) alarm.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors20 = BaseValidator.mergeErrors(mergeErrors19, BaseValidator.checkNullable((Object) alarm.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors21 = BaseValidator.mergeErrors(mergeErrors20, BaseValidator.checkNullable((Object) alarm.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors22 = BaseValidator.mergeErrors(mergeErrors21, BaseValidator.checkNullable((Object) alarm.component8(), true, validationContext));
        validationContext.setValidatedItemName("component9()");
        List mergeErrors23 = BaseValidator.mergeErrors(mergeErrors22, BaseValidator.checkNullable((Object) alarm.component9(), true, validationContext));
        validationContext.setValidatedItemName("component10()");
        List mergeErrors24 = BaseValidator.mergeErrors(mergeErrors23, BaseValidator.checkNullable((Object) alarm.component10(), true, validationContext));
        validationContext.setValidatedItemName("component11()");
        List mergeErrors25 = BaseValidator.mergeErrors(mergeErrors24, BaseValidator.checkNullable((Object) alarm.component11(), true, validationContext));
        validationContext.setValidatedItemName("component12()");
        List mergeErrors26 = BaseValidator.mergeErrors(mergeErrors25, BaseValidator.checkNullable((Object) alarm.component12(), true, validationContext));
        validationContext.setValidatedItemName("component13()");
        List mergeErrors27 = BaseValidator.mergeErrors(mergeErrors26, BaseValidator.checkNullable((Object) alarm.component13(), true, validationContext));
        validationContext.setValidatedItemName("component14()");
        List mergeErrors28 = BaseValidator.mergeErrors(mergeErrors27, BaseValidator.checkNullable((Object) alarm.component14(), true, validationContext));
        validationContext.setValidatedItemName("component15()");
        List mergeErrors29 = BaseValidator.mergeErrors(mergeErrors28, BaseValidator.checkNullable((Object) alarm.component15(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors30 = BaseValidator.mergeErrors(mergeErrors29, BaseValidator.checkNullable((Object) alarm.toString(), true, validationContext));
        if (mergeErrors30 != null && !mergeErrors30.isEmpty()) {
            throw new InvalidModelException(mergeErrors30);
        }
    }

    private void validateAs(Alarm.Reward reward) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Alarm.Reward.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) reward.getType(), true, validationContext));
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) reward.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) reward.getCreatedAt(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) reward.component2(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) reward.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) reward.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) reward.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(Recommend recommend) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Recommend.class);
        validationContext.setValidatedItemName("getRecommendee()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) recommend.getRecommendee(), false, validationContext));
        validationContext.setValidatedItemName("getRecommender()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) recommend.getRecommender(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) recommend.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) recommend.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) recommend.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(Alarm.Enroll enroll) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Alarm.Enroll.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(enroll.getId()), false, validationContext));
        validationContext.setValidatedItemName("getEnrollStatus()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) enroll.getEnrollStatus(), false, validationContext));
        validationContext.setValidatedItemName("getCreatedAt()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) enroll.getCreatedAt(), false, validationContext));
        validationContext.setValidatedItemName("getRejectDescription()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) enroll.getRejectDescription(), true, validationContext));
        validationContext.setValidatedItemName("getRejectedAt()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) enroll.getRejectedAt(), true, validationContext));
        validationContext.setValidatedItemName("getRewardPoints()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) Integer.valueOf(enroll.getRewardPoints()), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) enroll.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) enroll.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) enroll.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) enroll.component5(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) enroll.toString(), true, validationContext));
        if (mergeErrors11 != null && !mergeErrors11.isEmpty()) {
            throw new InvalidModelException(mergeErrors11);
        }
    }

    private void validateAs(Type type) throws InvalidModelException {
        BaseValidator.getValidationContext(Type.class);
    }

    private void validateAs(BannerImage bannerImage) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(BannerImage.class);
        validationContext.setValidatedItemName("getUrl()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) bannerImage.getUrl(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) bannerImage.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) bannerImage.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(Banner banner) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Banner.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(banner.getId()), false, validationContext));
        validationContext.setValidatedItemName("getImage()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) banner.getImage(), true, validationContext));
        validationContext.setValidatedItemName("getScheme()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) banner.getScheme(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) banner.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) banner.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) banner.toString(), true, validationContext));
        if (mergeErrors6 != null && !mergeErrors6.isEmpty()) {
            throw new InvalidModelException(mergeErrors6);
        }
    }

    private void validateAs(RemotePushContent remotePushContent) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(RemotePushContent.class);
        validationContext.setValidatedItemName("getImages()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) remotePushContent.getImages(), false, validationContext));
        validationContext.setValidatedItemName("getButton()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) remotePushContent.getButton(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) remotePushContent.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) remotePushContent.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) remotePushContent.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(Ticket ticket) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(Ticket.class);
        validationContext.setValidatedItemName("getItem()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) ticket.getItem(), true, validationContext));
        validationContext.setValidatedItemName("getColor()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) ticket.getColor(), false, validationContext));
        validationContext.setValidatedItemName("getSize()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) ticket.getSize(), false, validationContext));
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) ticket.getLinkUrl(), false, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) ticket.getShop(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) ticket.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) ticket.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) ticket.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) ticket.component5(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Object) ticket.component7(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) ticket.toString(), true, validationContext));
        if (mergeErrors11 != null && !mergeErrors11.isEmpty()) {
            throw new InvalidModelException(mergeErrors11);
        }
    }

    private void validateAs(AppliableEventResponse appliableEventResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AppliableEventResponse.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) appliableEventResponse.getType(), true, validationContext));
        validationContext.setValidatedItemName("getSharedLink()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) appliableEventResponse.getSharedLink(), true, validationContext));
        validationContext.setValidatedItemName("getTopItems()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.getTopItems(), false, validationContext));
        validationContext.setValidatedItemName("getBottomImageUrl()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) appliableEventResponse.getBottomImageUrl(), true, validationContext));
        validationContext.setValidatedItemName("getHistories()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.getHistories(), false, validationContext));
        validationContext.setValidatedItemName("getItems()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.getItems(), false, validationContext));
        validationContext.setValidatedItemName("getStatus()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) appliableEventResponse.getStatus(), false, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors8 = BaseValidator.mergeErrors(mergeErrors7, BaseValidator.checkNullable((Object) appliableEventResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors9 = BaseValidator.mergeErrors(mergeErrors8, BaseValidator.checkNullable((Object) appliableEventResponse.component3(), true, validationContext));
        validationContext.setValidatedItemName("component4()");
        List mergeErrors10 = BaseValidator.mergeErrors(mergeErrors9, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.component4(), true, validationContext));
        validationContext.setValidatedItemName("component5()");
        List mergeErrors11 = BaseValidator.mergeErrors(mergeErrors10, BaseValidator.checkNullable((Object) appliableEventResponse.component5(), true, validationContext));
        validationContext.setValidatedItemName("component6()");
        List mergeErrors12 = BaseValidator.mergeErrors(mergeErrors11, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.component6(), true, validationContext));
        validationContext.setValidatedItemName("component7()");
        List mergeErrors13 = BaseValidator.mergeErrors(mergeErrors12, BaseValidator.checkNullable((Collection<?>) appliableEventResponse.component7(), true, validationContext));
        validationContext.setValidatedItemName("component8()");
        List mergeErrors14 = BaseValidator.mergeErrors(mergeErrors13, BaseValidator.checkNullable((Object) appliableEventResponse.component8(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors15 = BaseValidator.mergeErrors(mergeErrors14, BaseValidator.checkNullable((Object) appliableEventResponse.toString(), true, validationContext));
        if (mergeErrors15 != null && !mergeErrors15.isEmpty()) {
            throw new InvalidModelException(mergeErrors15);
        }
    }

    private void validateAs(AppliableEventResponse.Item item) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AppliableEventResponse.Item.class);
        validationContext.setValidatedItemName("getType()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) item.getType(), false, validationContext));
        validationContext.setValidatedItemName("getItems()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) item.getItems(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) item.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) item.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) item.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(AppliableEventApplyResponse appliableEventApplyResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AppliableEventApplyResponse.class);
        validationContext.setValidatedItemName("toString()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) appliableEventApplyResponse.toString(), true, validationContext));
        if (mergeErrors != null && !mergeErrors.isEmpty()) {
            throw new InvalidModelException(mergeErrors);
        }
    }

    private void validateAs(AppliableEventResultResponse appliableEventResultResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AppliableEventResultResponse.class);
        validationContext.setValidatedItemName("getTopImage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) appliableEventResultResponse.getTopImage(), false, validationContext));
        validationContext.setValidatedItemName("getWinners()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) appliableEventResultResponse.getWinners(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) appliableEventResultResponse.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Collection<?>) appliableEventResultResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) appliableEventResultResponse.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(WinnerInfo winnerInfo) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(WinnerInfo.class);
        validationContext.setValidatedItemName("getFittsID()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) winnerInfo.getFittsID(), false, validationContext));
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) winnerInfo.getLinkUrl(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) winnerInfo.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) winnerInfo.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) winnerInfo.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(AppliableEventAppliabilityCheckResponse appliableEventAppliabilityCheckResponse) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(AppliableEventAppliabilityCheckResponse.class);
        validationContext.setValidatedItemName("getMessage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) appliableEventAppliabilityCheckResponse.getMessage(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) appliableEventAppliabilityCheckResponse.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) appliableEventAppliabilityCheckResponse.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(EventHistory eventHistory) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(EventHistory.class);
        validationContext.setValidatedItemName("getTickets()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) eventHistory.getTickets(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) eventHistory.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) eventHistory.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }

    private void validateAs(TopImageItem topImageItem) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(TopImageItem.class);
        validationContext.setValidatedItemName("getImage()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) topImageItem.getImage(), false, validationContext));
        validationContext.setValidatedItemName("getLinkUrl()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) topImageItem.getLinkUrl(), true, validationContext));
        validationContext.setValidatedItemName("getShop()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) topImageItem.getShop(), true, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) topImageItem.component1(), true, validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) topImageItem.component2(), true, validationContext));
        validationContext.setValidatedItemName("component3()");
        List mergeErrors6 = BaseValidator.mergeErrors(mergeErrors5, BaseValidator.checkNullable((Object) topImageItem.component3(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors7 = BaseValidator.mergeErrors(mergeErrors6, BaseValidator.checkNullable((Object) topImageItem.toString(), true, validationContext));
        if (mergeErrors7 != null && !mergeErrors7.isEmpty()) {
            throw new InvalidModelException(mergeErrors7);
        }
    }

    private void validateAs(TestModel testModel) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(TestModel.class);
        validationContext.setValidatedItemName("getId()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Object) Long.valueOf(testModel.getId()), false, validationContext));
        validationContext.setValidatedItemName("getName()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Object) testModel.getName(), false, validationContext));
        validationContext.setValidatedItemName("getValid()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.mustBeTrue(testModel.getValid(), validationContext));
        validationContext.setValidatedItemName("component2()");
        List mergeErrors4 = BaseValidator.mergeErrors(mergeErrors3, BaseValidator.checkNullable((Object) testModel.component2(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors5 = BaseValidator.mergeErrors(mergeErrors4, BaseValidator.checkNullable((Object) testModel.toString(), true, validationContext));
        if (mergeErrors5 != null && !mergeErrors5.isEmpty()) {
            throw new InvalidModelException(mergeErrors5);
        }
    }

    private void validateAs(TestList testList) throws InvalidModelException {
        ValidationContext validationContext = BaseValidator.getValidationContext(TestList.class);
        validationContext.setValidatedItemName("getList()");
        List mergeErrors = BaseValidator.mergeErrors(null, BaseValidator.checkNullable((Collection<?>) testList.getList(), false, validationContext));
        validationContext.setValidatedItemName("component1()");
        List mergeErrors2 = BaseValidator.mergeErrors(mergeErrors, BaseValidator.checkNullable((Collection<?>) testList.component1(), true, validationContext));
        validationContext.setValidatedItemName("toString()");
        List mergeErrors3 = BaseValidator.mergeErrors(mergeErrors2, BaseValidator.checkNullable((Object) testList.toString(), true, validationContext));
        if (mergeErrors3 != null && !mergeErrors3.isEmpty()) {
            throw new InvalidModelException(mergeErrors3);
        }
    }
}
