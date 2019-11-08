package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    @NotNull
    public static final <T> Collection<T> asCollection(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return new ArrayAsCollection(tArr, false);
    }

    @NotNull
    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static <T> List<T> listOf(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? ArraysKt___ArraysJvmKt.asList(tArr) : emptyList();
    }

    @NotNull
    public static final <T> List<T> mutableListOf(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    @NotNull
    public static <T> ArrayList<T> arrayListOf(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    @NotNull
    public static final <T> List<T> listOfNotNull(@Nullable T t) {
        return t != null ? CollectionsKt__CollectionsJVMKt.listOf(t) : emptyList();
    }

    @NotNull
    public static final <T> List<T> listOfNotNull(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return ArraysKt___ArraysKt.filterNotNull(tArr);
    }

    @NotNull
    public static IntRange getIndices(@NotNull Collection<?> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        return list.size() - 1;
    }

    @NotNull
    public static <T> List<T> optimizeReadOnlyList(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        int size = list.size();
        if (size == 0) {
            return emptyList();
        }
        if (size != 1) {
            return list;
        }
        return CollectionsKt__CollectionsJVMKt.listOf(list.get(0));
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, (T) comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(@NotNull List<? extends T> list, @Nullable T t, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) list.get(i4), t);
            if (compareValues < 0) {
                i = i4 + 1;
            } else if (compareValues <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, obj, comparator, i, i2);
    }

    public static final <T> int binarySearch(@NotNull List<? extends T> list, T t, @NotNull Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare(list.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return binarySearch(list, i, i2, (Function1<? super T, Integer>) new CollectionsKt__CollectionsKt$binarySearchBy$1<Object,Integer>(function1, comparable));
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(@NotNull List<? extends T> list, @Nullable K k, int i, int i2, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return binarySearch(list, i, i2, (Function1<? super T, Integer>) new CollectionsKt__CollectionsKt$binarySearchBy$1<Object,Integer>(function1, k));
    }

    public static /* synthetic */ int binarySearch$default(List list, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, i, i2, function1);
    }

    public static final <T> int binarySearch(@NotNull List<? extends T> list, int i, int i2, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = ((Number) function1.invoke(list.get(i4))).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else if (intValue <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2, int i3) {
        String str = ").";
        String str2 = "fromIndex (";
        if (i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(i2);
            sb.append(") is greater than toIndex (");
            sb.append(i3);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(i2);
            sb2.append(") is less than zero.");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i3 > i) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toIndex (");
            sb3.append(i3);
            sb3.append(") is greater than size (");
            sb3.append(i);
            sb3.append(str);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
