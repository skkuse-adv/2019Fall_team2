package kotlinx.coroutines.scheduling;

public final class NanoTimeSource extends TimeSource {
    public static final NanoTimeSource INSTANCE = new NanoTimeSource();

    private NanoTimeSource() {
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
