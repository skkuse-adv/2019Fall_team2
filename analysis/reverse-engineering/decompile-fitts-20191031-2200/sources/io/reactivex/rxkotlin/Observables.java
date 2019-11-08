package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
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

public final class Observables {
    public static final Observables INSTANCE = new Observables();

    private Observables() {
    }

    public final <T1, T2, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        return Observable.combineLatest((ObservableSource<? extends T1>) observable, (ObservableSource<? extends T2>) observable2, (BiFunction<? super T1, ? super T2, ? extends R>) new Observables$combineLatest$1<Object,Object,Object>(function2));
    }

    public final <T1, T2> Observable<Pair<T1, T2>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        return Observable.combineLatest((ObservableSource<? extends T1>) observable, (ObservableSource<? extends T2>) observable2, (BiFunction<? super T1, ? super T2, ? extends R>) Observables$combineLatest$2.INSTANCE);
    }

    public final <T1, T2, T3, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, new Observables$combineLatest$3(function3));
    }

    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        return Observable.combineLatest(observable, observable2, observable3, Observables$combineLatest$4.INSTANCE);
    }

    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, new Observables$combineLatest$5(function4));
    }

    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, new Observables$combineLatest$6(function5));
    }

    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, new Observables$combineLatest$7(function6));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function72 = function7;
        Observable<T1> observable8 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable9 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable10 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable11 = observable4;
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable12 = observable5;
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Observable<T6> observable13 = observable6;
        Intrinsics.checkParameterIsNotNull(observable13, "source6");
        Observable<T7> observable14 = observable7;
        Intrinsics.checkParameterIsNotNull(observable14, "source7");
        Intrinsics.checkParameterIsNotNull(function72, "combineFunction");
        return Observable.combineLatest(observable8, observable9, observable10, observable11, observable12, observable13, observable14, new Observables$combineLatest$8(function72));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function82 = function8;
        Observable<T1> observable9 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable10 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable11 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable12 = observable4;
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable13 = observable5;
        Intrinsics.checkParameterIsNotNull(observable13, "source5");
        Observable<T6> observable14 = observable6;
        Intrinsics.checkParameterIsNotNull(observable14, "source6");
        Observable<T7> observable15 = observable7;
        Intrinsics.checkParameterIsNotNull(observable15, "source7");
        Observable<T8> observable16 = observable8;
        Intrinsics.checkParameterIsNotNull(observable16, "source8");
        Intrinsics.checkParameterIsNotNull(function82, "combineFunction");
        return Observable.combineLatest(observable9, observable10, observable11, observable12, observable13, observable14, observable15, observable16, new Observables$combineLatest$9(function82));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function92 = function9;
        Observable<T1> observable10 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable11 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable12 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable13 = observable4;
        Intrinsics.checkParameterIsNotNull(observable13, "source4");
        Observable<T5> observable14 = observable5;
        Intrinsics.checkParameterIsNotNull(observable14, "source5");
        Observable<T6> observable15 = observable6;
        Intrinsics.checkParameterIsNotNull(observable15, "source6");
        Observable<T7> observable16 = observable7;
        Intrinsics.checkParameterIsNotNull(observable16, "source7");
        Observable<T8> observable17 = observable8;
        Intrinsics.checkParameterIsNotNull(observable17, "source8");
        Observable<T9> observable18 = observable9;
        Intrinsics.checkParameterIsNotNull(observable18, "source9");
        Intrinsics.checkParameterIsNotNull(function92, "combineFunction");
        return Observable.combineLatest(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18, new Observables$combineLatest$10(function92));
    }

    public final <T1, T2, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        return Observable.zip(observable, observable2, new Observables$zip$1(function2));
    }

    public final <T1, T2> Observable<Pair<T1, T2>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        return Observable.zip(observable, observable2, Observables$zip$2.INSTANCE);
    }

    public final <T1, T2, T3, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        return Observable.zip((ObservableSource<? extends T1>) observable, (ObservableSource<? extends T2>) observable2, (ObservableSource<? extends T3>) observable3, (io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R>) new Observables$zip$3<Object,Object,Object,Object>(function3));
    }

    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        return Observable.zip((ObservableSource<? extends T1>) observable, (ObservableSource<? extends T2>) observable2, (ObservableSource<? extends T3>) observable3, (io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R>) Observables$zip$4.INSTANCE);
    }

    public final <T1, T2, T3, T4, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        return Observable.zip((ObservableSource<? extends T1>) observable, (ObservableSource<? extends T2>) observable2, (ObservableSource<? extends T3>) observable3, (ObservableSource<? extends T4>) observable4, (io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R>) new Observables$zip$5<Object,Object,Object,Object,Object>(function4));
    }

    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, new Observables$zip$6(function5));
    }

    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, new Observables$zip$7(function6));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function72 = function7;
        Observable<T1> observable8 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable9 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable10 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable11 = observable4;
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable12 = observable5;
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Observable<T6> observable13 = observable6;
        Intrinsics.checkParameterIsNotNull(observable13, "source6");
        Observable<T7> observable14 = observable7;
        Intrinsics.checkParameterIsNotNull(observable14, "source7");
        Intrinsics.checkParameterIsNotNull(function72, "combineFunction");
        return Observable.zip(observable8, observable9, observable10, observable11, observable12, observable13, observable14, new Observables$zip$8(function72));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function82 = function8;
        Observable<T1> observable9 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable10 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable11 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable12 = observable4;
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable13 = observable5;
        Intrinsics.checkParameterIsNotNull(observable13, "source5");
        Observable<T6> observable14 = observable6;
        Intrinsics.checkParameterIsNotNull(observable14, "source6");
        Observable<T7> observable15 = observable7;
        Intrinsics.checkParameterIsNotNull(observable15, "source7");
        Observable<T8> observable16 = observable8;
        Intrinsics.checkParameterIsNotNull(observable16, "source8");
        Intrinsics.checkParameterIsNotNull(function82, "combineFunction");
        return Observable.zip(observable9, observable10, observable11, observable12, observable13, observable14, observable15, observable16, new Observables$zip$9(function82));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function92 = function9;
        Observable<T1> observable10 = observable;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Observable<T2> observable11 = observable2;
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<T3> observable12 = observable3;
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable13 = observable4;
        Intrinsics.checkParameterIsNotNull(observable13, "source4");
        Observable<T5> observable14 = observable5;
        Intrinsics.checkParameterIsNotNull(observable14, "source5");
        Observable<T6> observable15 = observable6;
        Intrinsics.checkParameterIsNotNull(observable15, "source6");
        Observable<T7> observable16 = observable7;
        Intrinsics.checkParameterIsNotNull(observable16, "source7");
        Observable<T8> observable17 = observable8;
        Intrinsics.checkParameterIsNotNull(observable17, "source8");
        Observable<T9> observable18 = observable9;
        Intrinsics.checkParameterIsNotNull(observable18, "source9");
        Intrinsics.checkParameterIsNotNull(function92, "combineFunction");
        return Observable.zip(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18, new Observables$zip$10(function92));
    }
}
