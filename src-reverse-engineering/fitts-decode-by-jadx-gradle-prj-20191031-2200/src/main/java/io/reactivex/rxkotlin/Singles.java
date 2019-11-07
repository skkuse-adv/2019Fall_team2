package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class Singles {
    public static final Singles INSTANCE = new Singles();

    private Singles() {
    }

    @NotNull
    public final <T, U, R> Single<R> zip(@NotNull SingleSource<T> singleSource, @NotNull SingleSource<U> singleSource2, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, new Singles$zip$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…-> zipper.invoke(t, u) })");
        return zip;
    }

    @NotNull
    public final <T, U> Single<Pair<T, U>> zip(@NotNull SingleSource<T> singleSource, @NotNull SingleSource<U> singleSource2) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Single<Pair<T, U>> zip = Single.zip(singleSource, singleSource2, Singles$zip$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…on { t, u -> Pair(t,u) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(function3, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, new Singles$zip$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, F…per.invoke(t1, t2, t3) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3> Single<Triple<T1, T2, T3>> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Single<Triple<T1, T2, T3>> zip = Single.zip(singleSource, singleSource2, singleSource3, Singles$zip$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, F…t3 -> Triple(t1,t2,t3) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(function4, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, new Singles$zip$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…invoke(t1, t2, t3, t4) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(function5, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, new Singles$zip$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…ke(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(singleSource6, "s6");
        Intrinsics.checkParameterIsNotNull(function6, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, new Singles$zip$7(function6));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function72 = function7;
        SingleSource<T1> singleSource8 = singleSource;
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        SingleSource<T2> singleSource9 = singleSource2;
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        SingleSource<T3> singleSource10 = singleSource3;
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        SingleSource<T4> singleSource11 = singleSource4;
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        SingleSource<T5> singleSource12 = singleSource5;
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        SingleSource<T6> singleSource13 = singleSource6;
        Intrinsics.checkParameterIsNotNull(singleSource13, "s6");
        SingleSource<T7> singleSource14 = singleSource7;
        Intrinsics.checkParameterIsNotNull(singleSource14, "s7");
        Intrinsics.checkParameterIsNotNull(function72, "zipper");
        Single<R> zip = Single.zip(singleSource8, singleSource9, singleSource10, singleSource11, singleSource12, singleSource13, singleSource14, new Singles$zip$8(function72));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull SingleSource<T8> singleSource8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function82 = function8;
        SingleSource<T1> singleSource9 = singleSource;
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        SingleSource<T2> singleSource10 = singleSource2;
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        SingleSource<T3> singleSource11 = singleSource3;
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        SingleSource<T4> singleSource12 = singleSource4;
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        SingleSource<T5> singleSource13 = singleSource5;
        Intrinsics.checkParameterIsNotNull(singleSource13, "s5");
        SingleSource<T6> singleSource14 = singleSource6;
        Intrinsics.checkParameterIsNotNull(singleSource14, "s6");
        SingleSource<T7> singleSource15 = singleSource7;
        Intrinsics.checkParameterIsNotNull(singleSource15, "s7");
        SingleSource<T8> singleSource16 = singleSource8;
        Intrinsics.checkParameterIsNotNull(singleSource16, "s8");
        Intrinsics.checkParameterIsNotNull(function82, "zipper");
        Single<R> zip = Single.zip(singleSource9, singleSource10, singleSource11, singleSource12, singleSource13, singleSource14, singleSource15, singleSource16, new Singles$zip$9(function82));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull SingleSource<T8> singleSource8, @NotNull SingleSource<T9> singleSource9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function92 = function9;
        SingleSource<T1> singleSource10 = singleSource;
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        SingleSource<T2> singleSource11 = singleSource2;
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        SingleSource<T3> singleSource12 = singleSource3;
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        SingleSource<T4> singleSource13 = singleSource4;
        Intrinsics.checkParameterIsNotNull(singleSource13, "s4");
        SingleSource<T5> singleSource14 = singleSource5;
        Intrinsics.checkParameterIsNotNull(singleSource14, "s5");
        SingleSource<T6> singleSource15 = singleSource6;
        Intrinsics.checkParameterIsNotNull(singleSource15, "s6");
        SingleSource<T7> singleSource16 = singleSource7;
        Intrinsics.checkParameterIsNotNull(singleSource16, "s7");
        SingleSource<T8> singleSource17 = singleSource8;
        Intrinsics.checkParameterIsNotNull(singleSource17, "s8");
        SingleSource<T9> singleSource18 = singleSource9;
        Intrinsics.checkParameterIsNotNull(singleSource18, "s9");
        Intrinsics.checkParameterIsNotNull(function92, "zipper");
        Single<R> zip = Single.zip(singleSource10, singleSource11, singleSource12, singleSource13, singleSource14, singleSource15, singleSource16, singleSource17, singleSource18, new Singles$zip$10(function92));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
