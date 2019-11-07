package kr.co.popone.fitts.model.post;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PostAPIKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$0[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$0[PostType.BAG.ordinal()] = 3;
        }
    }

    @NotNull
    public static final String toAPIValue(@NotNull PostType postType) {
        Intrinsics.checkParameterIsNotNull(postType, "receiver$0");
        int i = WhenMappings.$EnumSwitchMapping$0[postType.ordinal()];
        if (i == 1) {
            return "옷";
        }
        if (i == 2) {
            return "신발";
        }
        if (i == 3) {
            return "가방";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final PostFeedViewData mapToDomain(@NotNull Post post) {
        Intrinsics.checkParameterIsNotNull(post, "receiver$0");
        long id = post.getId();
        Image coverImage = post.getCoverImage();
        String url = coverImage != null ? coverImage.getUrl() : null;
        Image coverImage2 = post.getCoverImage();
        String lqip = coverImage2 != null ? coverImage2.getLqip() : null;
        Image coverImage3 = post.getCoverImage();
        PostFeedViewData postFeedViewData = new PostFeedViewData(id, url, lqip, coverImage3 != null ? coverImage3.getDominantColor() : null, post.getTitle(), post.getUser().getProfileImageUrl(), post.getUser().getFittsID(), post.getUser().isSuitable());
        return postFeedViewData;
    }

    @NotNull
    public static final List<PostFeedViewData> mapToDomain(@NotNull List<Post> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Post mapToDomain : list) {
            arrayList.add(mapToDomain(mapToDomain));
        }
        return arrayList;
    }
}
