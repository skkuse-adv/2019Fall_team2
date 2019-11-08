package kr.co.popone.fitts.feature.post;

import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import kr.co.popone.fitts.model.post.PostAPI.PostId;
import kr.co.popone.fitts.model.post.PostAPIKt;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import org.jetbrains.annotations.NotNull;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$7<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ CreatePost $localPostData;
    final /* synthetic */ PostVariantViewData $variantInfo;
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$7(ProfileInputActivity profileInputActivity, CreatePost createPost, PostVariantViewData postVariantViewData) {
        this.this$0 = profileInputActivity;
        this.$localPostData = createPost;
        this.$variantInfo = postVariantViewData;
    }

    public final Observable<PostId> apply(@NotNull List<PostContent> list) {
        List<PostContent> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "postImages");
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group", PostAPIKt.toAPIValue(this.$localPostData.getPostType()))));
        PostAPI postAPI$app_productionFittsRelease = this.this$0.getPostAPI$app_productionFittsRelease();
        String title = this.$localPostData.getTitle();
        String aboutFit = this.$localPostData.getAboutFit();
        String aboutProduct = this.$localPostData.getAboutProduct();
        String aboutSize = this.$localPostData.getAboutSize();
        int coverID = this.$localPostData.getCoverID();
        String json = new Gson().toJson((Object) list2);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(postImages)");
        float star = this.$localPostData.getStar();
        String json2 = new Gson().toJson((Object) this.$localPostData.getTags());
        Intrinsics.checkExpressionValueIsNotNull(json2, "Gson().toJson(localPostData.tags)");
        String json3 = new Gson().toJson((Object) this.$localPostData.getStyleTags());
        Intrinsics.checkExpressionValueIsNotNull(json3, "Gson().toJson(localPostData.styleTags)");
        String shop = this.$localPostData.getShop();
        String json4 = new Gson().toJson((Object) listOf);
        Intrinsics.checkExpressionValueIsNotNull(json4, "Gson().toJson(categories)");
        PostVariantViewData postVariantViewData = this.$variantInfo;
        return postAPI$app_productionFittsRelease.uploadPost(title, aboutFit, aboutProduct, aboutSize, coverID, json, star, json2, json3, shop, json4, postVariantViewData == null ? null : Long.valueOf(postVariantViewData.getVariantId())).subscribeOn(Schedulers.io());
    }
}
