package kotlin.jvm.internal;

public final class FloatCompanionObject {
    public static final FloatCompanionObject INSTANCE = new FloatCompanionObject();
    private static final float MAX_VALUE = Float.MAX_VALUE;
    private static final float MIN_VALUE = MIN_VALUE;
    private static final float NEGATIVE_INFINITY = NEGATIVE_INFINITY;
    private static final float NaN = NaN;
    private static final float POSITIVE_INFINITY = POSITIVE_INFINITY;

    private FloatCompanionObject() {
    }

    public final float getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final float getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final float getPOSITIVE_INFINITY() {
        return POSITIVE_INFINITY;
    }

    public final float getNEGATIVE_INFINITY() {
        return NEGATIVE_INFINITY;
    }

    public final float getNaN() {
        return NaN;
    }
}
