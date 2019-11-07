package kotlin.math;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static /* synthetic */ void absoluteValue$annotations(double d) {
    }

    public static /* synthetic */ void absoluteValue$annotations(float f) {
    }

    public static /* synthetic */ void absoluteValue$annotations(int i) {
    }

    public static /* synthetic */ void absoluteValue$annotations(long j) {
    }

    public static final int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static final int getSign(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public static /* synthetic */ void sign$annotations(double d) {
    }

    public static /* synthetic */ void sign$annotations(float f) {
    }

    public static /* synthetic */ void sign$annotations(int i) {
    }

    public static /* synthetic */ void sign$annotations(long j) {
    }

    public static /* synthetic */ void ulp$annotations(double d) {
    }

    public static /* synthetic */ void ulp$annotations(float f) {
    }

    public static final double asinh(double d) {
        double d2 = Constants.taylor_n_bound;
        if (d >= d2) {
            if (d <= Constants.upper_taylor_n_bound) {
                double d3 = d * d;
                double d4 = (double) 1;
                Double.isNaN(d4);
                return Math.log(d + Math.sqrt(d3 + d4));
            } else if (d > Constants.upper_taylor_2_bound) {
                return Math.log(d) + Constants.LN2;
            } else {
                double d5 = (double) 2;
                Double.isNaN(d5);
                double d6 = d * d5;
                double d7 = (double) 1;
                Double.isNaN(d7);
                return Math.log(d6 + (d7 / d6));
            }
        } else if (d <= (-d2)) {
            return -asinh(-d);
        } else {
            if (Math.abs(d) < Constants.taylor_2_bound) {
                return d;
            }
            double d8 = d * d * d;
            double d9 = (double) 6;
            Double.isNaN(d9);
            return d - (d8 / d9);
        }
    }

    public static final double acosh(double d) {
        double d2 = (double) 1;
        if (d < d2) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        if (d > Constants.upper_taylor_2_bound) {
            return Math.log(d) + Constants.LN2;
        }
        Double.isNaN(d2);
        double d3 = d - d2;
        if (d3 >= Constants.taylor_n_bound) {
            double d4 = d * d;
            Double.isNaN(d2);
            return Math.log(d + Math.sqrt(d4 - d2));
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= Constants.taylor_2_bound) {
            double d5 = sqrt * sqrt * sqrt;
            double d6 = (double) 12;
            Double.isNaN(d6);
            sqrt -= d5 / d6;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    public static final double atanh(double d) {
        if (Math.abs(d) < Constants.taylor_n_bound) {
            if (Math.abs(d) > Constants.taylor_2_bound) {
                double d2 = d * d * d;
                double d3 = (double) 3;
                Double.isNaN(d3);
                d += d2 / d3;
            }
            return d;
        }
        double d4 = (double) 1;
        Double.isNaN(d4);
        double d5 = d4 + d;
        Double.isNaN(d4);
        double log = Math.log(d5 / (d4 - d));
        double d6 = (double) 2;
        Double.isNaN(d6);
        return log / d6;
    }

    public static final double log(double d, double d2) {
        if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 == 1.0d) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        return Math.log(d) / Math.log(d2);
    }

    public static final double log2(double d) {
        return Math.log(d) / Constants.LN2;
    }

    public static final double truncate(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > ((double) 0)) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d > ((double) Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        } else {
            if (d < ((double) Integer.MIN_VALUE)) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d);
        }
    }

    public static final long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final float log(float f, float f2) {
        if (f2 <= 0.0f || f2 == 1.0f) {
            return FloatCompanionObject.INSTANCE.getNaN();
        }
        return (float) (Math.log((double) f) / Math.log((double) f2));
    }

    public static final float log2(float f) {
        return (float) (Math.log((double) f) / Constants.LN2);
    }

    public static final float truncate(float f) {
        double d;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > ((float) 0)) {
            d = Math.floor((double) f);
        } else {
            d = Math.ceil((double) f);
        }
        return (float) d;
    }

    public static int roundToInt(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(float f) {
        return roundToLong((double) f);
    }
}
