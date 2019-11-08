package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

class UArraysKt___UArraysKt {
    /* renamed from: random-2D5oskM reason: not valid java name */
    public static final int m134random2D5oskM(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UIntArray.m55isEmptyimpl(iArr)) {
            return UIntArray.m52getimpl(iArr, random.nextInt(UIntArray.m53getSizeimpl(iArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* renamed from: random-JzugnMA reason: not valid java name */
    public static final long m135randomJzugnMA(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!ULongArray.m81isEmptyimpl(jArr)) {
            return ULongArray.m78getimpl(jArr, random.nextInt(ULongArray.m79getSizeimpl(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* renamed from: random-oSF2wD8 reason: not valid java name */
    public static final byte m136randomoSF2wD8(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UByteArray.m29isEmptyimpl(bArr)) {
            return UByteArray.m26getimpl(bArr, random.nextInt(UByteArray.m27getSizeimpl(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* renamed from: random-s5X_as8 reason: not valid java name */
    public static final short m137randoms5X_as8(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UShortArray.m107isEmptyimpl(sArr)) {
            return UShortArray.m104getimpl(sArr, random.nextInt(UShortArray.m105getSizeimpl(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* renamed from: contentEquals-ctEhBpI reason: not valid java name */
    public static final boolean m122contentEqualsctEhBpI(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, FacebookRequestErrorClassification.KEY_OTHER);
        return Arrays.equals(iArr, iArr2);
    }

    /* renamed from: contentEquals-us8wMrg reason: not valid java name */
    public static final boolean m125contentEqualsus8wMrg(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(jArr2, FacebookRequestErrorClassification.KEY_OTHER);
        return Arrays.equals(jArr, jArr2);
    }

    /* renamed from: contentEquals-kdPth3s reason: not valid java name */
    public static final boolean m123contentEqualskdPth3s(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(bArr2, FacebookRequestErrorClassification.KEY_OTHER);
        return Arrays.equals(bArr, bArr2);
    }

    /* renamed from: contentEquals-mazbYpA reason: not valid java name */
    public static final boolean m124contentEqualsmazbYpA(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sArr2, FacebookRequestErrorClassification.KEY_OTHER);
        return Arrays.equals(sArr, sArr2);
    }

    /* renamed from: contentHashCode--ajY-9A reason: not valid java name */
    public static final int m126contentHashCodeajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return Arrays.hashCode(iArr);
    }

    /* renamed from: contentHashCode-QwZRm1k reason: not valid java name */
    public static final int m128contentHashCodeQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return Arrays.hashCode(jArr);
    }

    /* renamed from: contentHashCode-GBYM_sE reason: not valid java name */
    public static final int m127contentHashCodeGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return Arrays.hashCode(bArr);
    }

    /* renamed from: contentHashCode-rL5Bavg reason: not valid java name */
    public static final int m129contentHashCoderL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return Arrays.hashCode(sArr);
    }

    @NotNull
    /* renamed from: contentToString--ajY-9A reason: not valid java name */
    public static final String m130contentToStringajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(iArr, "v"), ", ", "[", "]", 0, null, null, 56, null);
    }

    @NotNull
    /* renamed from: contentToString-QwZRm1k reason: not valid java name */
    public static final String m132contentToStringQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(jArr, "v"), ", ", "[", "]", 0, null, null, 56, null);
    }

    @NotNull
    /* renamed from: contentToString-GBYM_sE reason: not valid java name */
    public static final String m131contentToStringGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(bArr, "v"), ", ", "[", "]", 0, null, null, 56, null);
    }

    @NotNull
    /* renamed from: contentToString-rL5Bavg reason: not valid java name */
    public static final String m133contentToStringrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(sArr, "v"), ", ", "[", "]", 0, null, null, 56, null);
    }

    @NotNull
    /* renamed from: toTypedArray--ajY-9A reason: not valid java name */
    public static final UInt[] m138toTypedArrayajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        UInt[] uIntArr = new UInt[UIntArray.m53getSizeimpl(iArr)];
        int length = uIntArr.length;
        for (int i = 0; i < length; i++) {
            uIntArr[i] = UInt.m36boximpl(UIntArray.m52getimpl(iArr, i));
        }
        return uIntArr;
    }

    @NotNull
    /* renamed from: toTypedArray-QwZRm1k reason: not valid java name */
    public static final ULong[] m140toTypedArrayQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        ULong[] uLongArr = new ULong[ULongArray.m79getSizeimpl(jArr)];
        int length = uLongArr.length;
        for (int i = 0; i < length; i++) {
            uLongArr[i] = ULong.m62boximpl(ULongArray.m78getimpl(jArr, i));
        }
        return uLongArr;
    }

    @NotNull
    /* renamed from: toTypedArray-GBYM_sE reason: not valid java name */
    public static final UByte[] m139toTypedArrayGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        UByte[] uByteArr = new UByte[UByteArray.m27getSizeimpl(bArr)];
        int length = uByteArr.length;
        for (int i = 0; i < length; i++) {
            uByteArr[i] = UByte.m10boximpl(UByteArray.m26getimpl(bArr, i));
        }
        return uByteArr;
    }

    @NotNull
    /* renamed from: toTypedArray-rL5Bavg reason: not valid java name */
    public static final UShort[] m141toTypedArrayrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        UShort[] uShortArr = new UShort[UShortArray.m105getSizeimpl(sArr)];
        int length = uShortArr.length;
        for (int i = 0; i < length; i++) {
            uShortArr[i] = UShort.m88boximpl(UShortArray.m104getimpl(sArr, i));
        }
        return uShortArr;
    }
}
