package kr.co.popone.fitts.model.validation;

import androidx.annotation.NonNull;
import com.kakao.message.template.MessageTemplateProtocol;
import com.uber.rave.annotation.Validated;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Validated(factory = ValidatorFactoryImpl.class)
public final class TestList<T> {
    @NotNull
    private final List<T> list;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<T>, for r1v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.validation.TestList copy$default(kr.co.popone.fitts.model.validation.TestList r0, java.util.List<T> r1, int r2, java.lang.Object r3) {
        /*
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0006
            java.util.List<T> r1 = r0.list
        L_0x0006:
            kr.co.popone.fitts.model.validation.TestList r0 = r0.copy(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.validation.TestList.copy$default(kr.co.popone.fitts.model.validation.TestList, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.validation.TestList");
    }

    @NotNull
    public final List<T> component1() {
        return this.list;
    }

    @NotNull
    public final TestList<T> copy(@NotNull List<? extends T> list2) {
        Intrinsics.checkParameterIsNotNull(list2, MessageTemplateProtocol.TYPE_LIST);
        return new TestList<>(list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.list, (java.lang.Object) ((kr.co.popone.fitts.model.validation.TestList) r2).list) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.model.validation.TestList
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.validation.TestList r2 = (kr.co.popone.fitts.model.validation.TestList) r2
            java.util.List<T> r0 = r1.list
            java.util.List<T> r2 = r2.list
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.validation.TestList.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<T> list2 = this.list;
        if (list2 != null) {
            return list2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TestList(list=");
        sb.append(this.list);
        sb.append(")");
        return sb.toString();
    }

    public TestList(@NotNull List<? extends T> list2) {
        Intrinsics.checkParameterIsNotNull(list2, MessageTemplateProtocol.TYPE_LIST);
        this.list = list2;
    }

    @NotNull
    @NonNull
    public final List<T> getList() {
        return this.list;
    }
}
