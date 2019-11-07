package kr.co.popone.fitts.feature.post;

import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import org.jetbrains.annotations.NotNull;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$6<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ProfileInputActivity$createPostAndUpdateAdditionalInfo$6 INSTANCE = new ProfileInputActivity$createPostAndUpdateAdditionalInfo$6();

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$6() {
    }

    public final Observable<List<PostContent>> apply(@NotNull ArrayList<Observable<PostContent>> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "imageWithDescription");
        StringBuilder sb = new StringBuilder();
        sb.append("imageWithDescription : ");
        sb.append(arrayList);
        Logger.d(sb.toString(), new Object[0]);
        return Observable.concat((Iterable<? extends ObservableSource<? extends T>>) arrayList).toList().toObservable();
    }
}
