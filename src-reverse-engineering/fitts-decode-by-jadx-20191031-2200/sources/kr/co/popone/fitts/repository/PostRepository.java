package kr.co.popone.fitts.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.post.PostAPI.PostProductInfoResponse;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostRepository {
    private final PostAPI postAPI;

    public PostRepository(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "postAPI");
        this.postAPI = postAPI2;
    }

    @NotNull
    public final Single<ArrayList<Post>> getPostsByType(@NotNull String str, @Nullable String str2, @Nullable Long l, int i) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<ArrayList<Post>> observeOn = this.postAPI.getPostList(str, str2, l, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.getPostList(type…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<LikeResult> putPostLike(long j) {
        Single<LikeResult> observeOn = this.postAPI.putLikes(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.putLikes(postId)…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<LikeResult> deletePostLike(long j) {
        Single<LikeResult> observeOn = this.postAPI.deleteLikes(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.deleteLikes(post…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<PostProductInfoResponse> getProductDetailAndRecommend(long j) {
        Single<PostProductInfoResponse> observeOn = this.postAPI.getProductBridgeHeader(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.getProductBridge…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<ArrayList<Product>> getRecommendProduct(long j, @Nullable Long l, @Nullable Integer num) {
        Single<ArrayList<Product>> observeOn = this.postAPI.getRecommendProducts(j, l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.getRecommendProd…dSchedulers.mainThread())");
        return observeOn;
    }
}
