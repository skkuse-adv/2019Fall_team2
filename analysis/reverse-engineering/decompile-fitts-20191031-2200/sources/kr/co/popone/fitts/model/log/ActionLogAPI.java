package kr.co.popone.fitts.model.log;

import io.reactivex.Completable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ActionLogAPI {

    public static final class DefaultImpls {
        @FormUrlEncoded
        @NotNull
        @POST("/api/v9/action_logs")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Completable collectActionLog$default(ActionLogAPI actionLogAPI, String str, String str2, String str3, Long l, Long l2, int i, Object obj) {
            if (obj == null) {
                return actionLogAPI.collectActionLog(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collectActionLog");
        }
    }

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/action_logs")
    @Headers({"Accept: application/json"})
    Completable collectActionLog(@NotNull @Field("type") String str, @NotNull @Field("main_path") String str2, @Field("sub_path") @Nullable String str3, @Field("from_id") @Nullable Long l, @Field("target_id") @Nullable Long l2);
}
