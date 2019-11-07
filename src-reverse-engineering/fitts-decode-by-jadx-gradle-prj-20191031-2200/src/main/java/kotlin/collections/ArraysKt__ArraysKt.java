package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "receiver$0");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    public static final <T> boolean contentDeepEquals(@NotNull T[] tArr, @NotNull T[] tArr2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr2, FacebookRequestErrorClassification.KEY_OTHER);
        if (tArr == tArr2) {
            return true;
        }
        if (tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if (!(t instanceof Object[]) || !(t2 instanceof Object[])) {
                    if (!(t instanceof byte[]) || !(t2 instanceof byte[])) {
                        if (!(t instanceof short[]) || !(t2 instanceof short[])) {
                            if (!(t instanceof int[]) || !(t2 instanceof int[])) {
                                if (!(t instanceof long[]) || !(t2 instanceof long[])) {
                                    if (!(t instanceof float[]) || !(t2 instanceof float[])) {
                                        if (!(t instanceof double[]) || !(t2 instanceof double[])) {
                                            if (!(t instanceof char[]) || !(t2 instanceof char[])) {
                                                if (!(t instanceof boolean[]) || !(t2 instanceof boolean[])) {
                                                    if (!(t instanceof UByteArray) || !(t2 instanceof UByteArray)) {
                                                        if (!(t instanceof UShortArray) || !(t2 instanceof UShortArray)) {
                                                            if (!(t instanceof UIntArray) || !(t2 instanceof UIntArray)) {
                                                                if (!(t instanceof ULongArray) || !(t2 instanceof ULongArray)) {
                                                                    if (!Intrinsics.areEqual((Object) t, (Object) t2)) {
                                                                        return false;
                                                                    }
                                                                } else if (!UArraysKt___UArraysKt.m125contentEqualsus8wMrg(((ULongArray) t).m87unboximpl(), ((ULongArray) t2).m87unboximpl())) {
                                                                    return false;
                                                                }
                                                            } else if (!UArraysKt___UArraysKt.m122contentEqualsctEhBpI(((UIntArray) t).m61unboximpl(), ((UIntArray) t2).m61unboximpl())) {
                                                                return false;
                                                            }
                                                        } else if (!UArraysKt___UArraysKt.m124contentEqualsmazbYpA(((UShortArray) t).m113unboximpl(), ((UShortArray) t2).m113unboximpl())) {
                                                            return false;
                                                        }
                                                    } else if (!UArraysKt___UArraysKt.m123contentEqualskdPth3s(((UByteArray) t).m35unboximpl(), ((UByteArray) t2).m35unboximpl())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) t, (char[]) t2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) t, (double[]) t2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) t, (float[]) t2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) t, (long[]) t2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) t, (int[]) t2)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) t, (short[]) t2)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if (!contentDeepEquals((Object[]) t, (Object[]) t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static final <T> String contentDeepToString(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        StringBuilder sb = new StringBuilder((RangesKt___RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(@NotNull T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            T t = tArr[i];
            if (t == null) {
                sb.append("null");
            } else if (t instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) t, sb, list);
            } else {
                String str = "java.util.Arrays.toString(this)";
                if (t instanceof byte[]) {
                    String arrays = Arrays.toString((byte[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays, str);
                    sb.append(arrays);
                } else if (t instanceof short[]) {
                    String arrays2 = Arrays.toString((short[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays2, str);
                    sb.append(arrays2);
                } else if (t instanceof int[]) {
                    String arrays3 = Arrays.toString((int[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays3, str);
                    sb.append(arrays3);
                } else if (t instanceof long[]) {
                    String arrays4 = Arrays.toString((long[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays4, str);
                    sb.append(arrays4);
                } else if (t instanceof float[]) {
                    String arrays5 = Arrays.toString((float[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays5, str);
                    sb.append(arrays5);
                } else if (t instanceof double[]) {
                    String arrays6 = Arrays.toString((double[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays6, str);
                    sb.append(arrays6);
                } else if (t instanceof char[]) {
                    String arrays7 = Arrays.toString((char[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays7, str);
                    sb.append(arrays7);
                } else if (t instanceof boolean[]) {
                    String arrays8 = Arrays.toString((boolean[]) t);
                    Intrinsics.checkExpressionValueIsNotNull(arrays8, str);
                    sb.append(arrays8);
                } else if (t instanceof UByteArray) {
                    sb.append(UArraysKt___UArraysKt.m131contentToStringGBYM_sE(((UByteArray) t).m35unboximpl()));
                } else if (t instanceof UShortArray) {
                    sb.append(UArraysKt___UArraysKt.m133contentToStringrL5Bavg(((UShortArray) t).m113unboximpl()));
                } else if (t instanceof UIntArray) {
                    sb.append(UArraysKt___UArraysKt.m130contentToStringajY9A(((UIntArray) t).m61unboximpl()));
                } else if (t instanceof ULongArray) {
                    sb.append(UArraysKt___UArraysKt.m132contentToStringQwZRm1k(((ULongArray) t).m87unboximpl()));
                } else {
                    sb.append(t.toString());
                }
            }
        }
        sb.append(']');
        list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    @NotNull
    public static final <T> List<T> flatten(@NotNull T[][] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i = 0;
        for (T[] length : tArr) {
            i += length.length;
        }
        ArrayList arrayList = new ArrayList(i);
        for (T[] addAll : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection) arrayList, (Object[]) addAll);
        }
        return arrayList;
    }
}
