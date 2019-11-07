package androidx.paging;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

class PageResult<T> {
    static final int APPEND = 1;
    private static final PageResult EMPTY_RESULT = new PageResult(Collections.emptyList(), 0);
    static final int INIT = 0;
    private static final PageResult INVALID_RESULT = new PageResult(Collections.emptyList(), 0);
    static final int PREPEND = 2;
    static final int TILE = 3;
    public final int leadingNulls;
    @NonNull
    public final List<T> page;
    public final int positionOffset;
    public final int trailingNulls;

    static abstract class Receiver<T> {
        @MainThread
        public abstract void onPageResult(int i, @NonNull PageResult<T> pageResult);

        Receiver() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ResultType {
    }

    static <T> PageResult<T> getEmptyResult() {
        return EMPTY_RESULT;
    }

    static <T> PageResult<T> getInvalidResult() {
        return INVALID_RESULT;
    }

    PageResult(@NonNull List<T> list, int i, int i2, int i3) {
        this.page = list;
        this.leadingNulls = i;
        this.trailingNulls = i2;
        this.positionOffset = i3;
    }

    PageResult(@NonNull List<T> list, int i) {
        this.page = list;
        this.leadingNulls = 0;
        this.trailingNulls = 0;
        this.positionOffset = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Result ");
        sb.append(this.leadingNulls);
        String str = ", ";
        sb.append(str);
        sb.append(this.page);
        sb.append(str);
        sb.append(this.trailingNulls);
        sb.append(", offset ");
        sb.append(this.positionOffset);
        return sb.toString();
    }

    public boolean isInvalid() {
        return this == INVALID_RESULT;
    }
}
