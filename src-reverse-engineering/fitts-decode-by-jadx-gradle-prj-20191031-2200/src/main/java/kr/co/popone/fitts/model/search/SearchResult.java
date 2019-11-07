package kr.co.popone.fitts.model.search;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class SearchResult {

    public static final class FittieSearchResult extends SearchResult {
        @NotNull
        private final User user;

        @NotNull
        public static /* synthetic */ FittieSearchResult copy$default(FittieSearchResult fittieSearchResult, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                user2 = fittieSearchResult.user;
            }
            return fittieSearchResult.copy(user2);
        }

        @NotNull
        public final User component1() {
            return this.user;
        }

        @NotNull
        public final FittieSearchResult copy(@NotNull User user2) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            return new FittieSearchResult(user2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.user, (java.lang.Object) ((kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult) r2).user) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.search.SearchResult$FittieSearchResult r2 = (kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult) r2
                kr.co.popone.fitts.model.datamodel.service.user.User r0 = r1.user
                kr.co.popone.fitts.model.datamodel.service.user.User r2 = r2.user
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            User user2 = this.user;
            if (user2 != null) {
                return user2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FittieSearchResult(user=");
            sb.append(this.user);
            sb.append(")");
            return sb.toString();
        }

        public FittieSearchResult(@NotNull User user2) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            super(null);
            this.user = user2;
        }

        @NotNull
        public final User getUser() {
            return this.user;
        }
    }

    public static final class PostSearchResult extends SearchResult {
        @NotNull
        private final Post post;

        @NotNull
        public static /* synthetic */ PostSearchResult copy$default(PostSearchResult postSearchResult, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = postSearchResult.post;
            }
            return postSearchResult.copy(post2);
        }

        @NotNull
        public final Post component1() {
            return this.post;
        }

        @NotNull
        public final PostSearchResult copy(@NotNull Post post2) {
            Intrinsics.checkParameterIsNotNull(post2, "post");
            return new PostSearchResult(post2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.post, (java.lang.Object) ((kr.co.popone.fitts.model.search.SearchResult.PostSearchResult) r2).post) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.search.SearchResult.PostSearchResult
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.search.SearchResult$PostSearchResult r2 = (kr.co.popone.fitts.model.search.SearchResult.PostSearchResult) r2
                kr.co.popone.fitts.model.post.PostAPI$Post r0 = r1.post
                kr.co.popone.fitts.model.post.PostAPI$Post r2 = r2.post
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchResult.PostSearchResult.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            Post post2 = this.post;
            if (post2 != null) {
                return post2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostSearchResult(post=");
            sb.append(this.post);
            sb.append(")");
            return sb.toString();
        }

        public PostSearchResult(@NotNull Post post2) {
            Intrinsics.checkParameterIsNotNull(post2, "post");
            super(null);
            this.post = post2;
        }

        @NotNull
        public final Post getPost() {
            return this.post;
        }
    }

    public static final class ProductSearchResult extends SearchResult {
        @NotNull
        private final Product product;

        @NotNull
        public static /* synthetic */ ProductSearchResult copy$default(ProductSearchResult productSearchResult, Product product2, int i, Object obj) {
            if ((i & 1) != 0) {
                product2 = productSearchResult.product;
            }
            return productSearchResult.copy(product2);
        }

        @NotNull
        public final Product component1() {
            return this.product;
        }

        @NotNull
        public final ProductSearchResult copy(@NotNull Product product2) {
            Intrinsics.checkParameterIsNotNull(product2, "product");
            return new ProductSearchResult(product2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.product, (java.lang.Object) ((kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult) r2).product) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.search.SearchResult$ProductSearchResult r2 = (kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult) r2
                kr.co.popone.fitts.model.product.Product r0 = r1.product
                kr.co.popone.fitts.model.product.Product r2 = r2.product
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            Product product2 = this.product;
            if (product2 != null) {
                return product2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ProductSearchResult(product=");
            sb.append(this.product);
            sb.append(")");
            return sb.toString();
        }

        public ProductSearchResult(@NotNull Product product2) {
            Intrinsics.checkParameterIsNotNull(product2, "product");
            super(null);
            this.product = product2;
        }

        @NotNull
        public final Product getProduct() {
            return this.product;
        }
    }

    public static final class SearchResultCount extends SearchResult {
        public static final Companion Companion = new Companion(null);
        public static final long DEFAULT_ID = -35;
        private final int count;
        @NotNull
        private final String text;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        public static /* synthetic */ SearchResultCount copy$default(SearchResultCount searchResultCount, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = searchResultCount.count;
            }
            if ((i2 & 2) != 0) {
                str = searchResultCount.text;
            }
            return searchResultCount.copy(i, str);
        }

        public final int component1() {
            return this.count;
        }

        @NotNull
        public final String component2() {
            return this.text;
        }

        @NotNull
        public final SearchResultCount copy(int i, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            return new SearchResultCount(i, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof SearchResultCount) {
                    SearchResultCount searchResultCount = (SearchResultCount) obj;
                    if (!(this.count == searchResultCount.count) || !Intrinsics.areEqual((Object) this.text, (Object) searchResultCount.text)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.count * 31;
            String str = this.text;
            return i + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchResultCount(count=");
            sb.append(this.count);
            sb.append(", text=");
            sb.append(this.text);
            sb.append(")");
            return sb.toString();
        }

        public SearchResultCount(int i, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            super(null);
            this.count = i;
            this.text = str;
        }

        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }
    }

    private SearchResult() {
    }

    public /* synthetic */ SearchResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
