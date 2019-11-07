package kr.co.popone.fitts.model.category;

import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse;
import kr.co.popone.fitts.model.product.CategoryProductListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CategoryAPI {
    @NotNull
    @GET("/api/v9/categories")
    @Headers({"Accept: application/json"})
    Single<List<CategoryData>> getCategoryList();

    @NotNull
    @GET("/api/v9/categories/posts")
    @Headers({"Accept: application/json"})
    Single<CategoryPostListResponse> getPostCategoryList(@Query("section_id") int i, @Nullable @Query("subsection_id") Integer num, @Nullable @Query("version") String str, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num2);

    @NotNull
    @GET("/api/v9/categories/products")
    @Headers({"Accept: application/json"})
    Single<CategoryProductListResponse> getProductCategoryList(@Query("section_id") int i, @Nullable @Query("subsection_id") Integer num, @Nullable @Query("version") String str, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num2);
}
