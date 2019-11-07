package kotlin.jvm.internal;

public final class DoubleCompanionObject {
    public static final DoubleCompanionObject INSTANCE = new DoubleCompanionObject();
    private static final double MAX_VALUE = MAX_VALUE;
    private static final double MIN_VALUE = MIN_VALUE;
    private static final double NEGATIVE_INFINITY = NEGATIVE_INFINITY;
    private static final double NaN = NaN;
    private static final double POSITIVE_INFINITY = POSITIVE_INFINITY;

    private DoubleCompanionObject() {
    }

    public final double getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final double getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final double getPOSITIVE_INFINITY() {
        return POSITIVE_INFINITY;
    }

    public final double getNEGATIVE_INFINITY() {
        return NEGATIVE_INFINITY;
    }

    public final double getNaN() {
        return NaN;
    }
}
