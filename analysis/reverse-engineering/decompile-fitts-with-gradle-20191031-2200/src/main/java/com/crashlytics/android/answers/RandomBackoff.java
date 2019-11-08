package com.crashlytics.android.answers;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

class RandomBackoff implements Backoff {
    final Backoff backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(Backoff backoff2, double d) {
        this(backoff2, d, new Random());
    }

    public RandomBackoff(Backoff backoff2, double d, Random random2) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (backoff2 == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random2 != null) {
            this.backoff = backoff2;
            this.jitterPercent = d;
            this.random = random2;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }

    public long getDelayMillis(int i) {
        double randomJitter = randomJitter();
        double delayMillis = (double) this.backoff.getDelayMillis(i);
        Double.isNaN(delayMillis);
        return (long) (randomJitter * delayMillis);
    }

    /* access modifiers changed from: 0000 */
    public double randomJitter() {
        double d = this.jitterPercent;
        double d2 = 1.0d - d;
        return d2 + (((d + 1.0d) - d2) * this.random.nextDouble());
    }
}
