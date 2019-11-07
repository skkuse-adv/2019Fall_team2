package kotlin.math;

final class Constants {
    public static final Constants INSTANCE = new Constants();
    public static final double LN2 = Math.log(2.0d);
    public static final double epsilon = Math.ulp(1.0d);
    public static final double taylor_2_bound = Math.sqrt(epsilon);
    public static final double taylor_n_bound = Math.sqrt(taylor_2_bound);
    public static final double upper_taylor_2_bound;
    public static final double upper_taylor_n_bound;

    static {
        double d = (double) 1;
        double d2 = taylor_2_bound;
        Double.isNaN(d);
        upper_taylor_2_bound = d / d2;
        double d3 = taylor_n_bound;
        Double.isNaN(d);
        upper_taylor_n_bound = d / d3;
    }

    private Constants() {
    }
}
