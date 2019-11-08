package kr.co.popone.fitts.event;

import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryEvent$CategoryTypeChanged {
    @Nullable
    private final CategoryFeedType categoryType;

    @NotNull
    public static /* synthetic */ CategoryEvent$CategoryTypeChanged copy$default(CategoryEvent$CategoryTypeChanged categoryEvent$CategoryTypeChanged, CategoryFeedType categoryFeedType, int i, Object obj) {
        if ((i & 1) != 0) {
            categoryFeedType = categoryEvent$CategoryTypeChanged.categoryType;
        }
        return categoryEvent$CategoryTypeChanged.copy(categoryFeedType);
    }

    @Nullable
    public final CategoryFeedType component1() {
        return this.categoryType;
    }

    @NotNull
    public final CategoryEvent$CategoryTypeChanged copy(@Nullable CategoryFeedType categoryFeedType) {
        return new CategoryEvent$CategoryTypeChanged(categoryFeedType);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.categoryType, (java.lang.Object) ((kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged) r2).categoryType) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged r2 = (kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged) r2
            kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView$CategoryFeedType r0 = r1.categoryType
            kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView$CategoryFeedType r2 = r2.categoryType
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        CategoryFeedType categoryFeedType = this.categoryType;
        if (categoryFeedType != null) {
            return categoryFeedType.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryTypeChanged(categoryType=");
        sb.append(this.categoryType);
        sb.append(")");
        return sb.toString();
    }

    public CategoryEvent$CategoryTypeChanged(@Nullable CategoryFeedType categoryFeedType) {
        this.categoryType = categoryFeedType;
    }

    @Nullable
    public final CategoryFeedType getCategoryType() {
        return this.categoryType;
    }
}
