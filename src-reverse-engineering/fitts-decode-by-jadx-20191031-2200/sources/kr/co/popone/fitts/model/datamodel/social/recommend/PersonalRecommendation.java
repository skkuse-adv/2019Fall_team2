package kr.co.popone.fitts.model.datamodel.social.recommend;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PersonalRecommendation {
    @SerializedName("id")
    @Nullable
    private final Integer id;
    @SerializedName("posts")
    @Nullable
    private final List<Post> posts;
    @SerializedName("short_title")
    @Nullable
    private final String shortTitle;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("users")
    @Nullable
    private final List<User> users;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User>, for r8v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r7v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation copy$default(kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation r3, java.lang.Integer r4, java.lang.String r5, java.lang.String r6, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r7, java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r8, int r9, java.lang.Object r10) {
        /*
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.Integer r4 = r3.id
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            java.lang.String r5 = r3.title
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            java.lang.String r6 = r3.shortTitle
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r7 = r3.posts
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r8 = r3.users
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation r3 = r5.copy(r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation.copy$default(kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation");
    }

    @Nullable
    public final Integer component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.shortTitle;
    }

    @Nullable
    public final List<Post> component4() {
        return this.posts;
    }

    @Nullable
    public final List<User> component5() {
        return this.users;
    }

    @NotNull
    public final PersonalRecommendation copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable List<Post> list, @Nullable List<User> list2) {
        PersonalRecommendation personalRecommendation = new PersonalRecommendation(num, str, str2, list, list2);
        return personalRecommendation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.users, (java.lang.Object) r3.users) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation
            if (r0 == 0) goto L_0x003b
            kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation r3 = (kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation) r3
            java.lang.Integer r0 = r2.id
            java.lang.Integer r1 = r3.id
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.title
            java.lang.String r1 = r3.title
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.shortTitle
            java.lang.String r1 = r3.shortTitle
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r0 = r2.posts
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r1 = r3.posts
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r0 = r2.users
            java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r3 = r3.users
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.id;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.shortTitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Post> list = this.posts;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<User> list2 = this.users;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonalRecommendation(id=");
        sb.append(this.id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", shortTitle=");
        sb.append(this.shortTitle);
        sb.append(", posts=");
        sb.append(this.posts);
        sb.append(", users=");
        sb.append(this.users);
        sb.append(")");
        return sb.toString();
    }

    public PersonalRecommendation(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable List<Post> list, @Nullable List<User> list2) {
        this.id = num;
        this.title = str;
        this.shortTitle = str2;
        this.posts = list;
        this.users = list2;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getShortTitle() {
        return this.shortTitle;
    }

    @Nullable
    public final List<Post> getPosts() {
        return this.posts;
    }

    @Nullable
    public final List<User> getUsers() {
        return this.users;
    }
}
