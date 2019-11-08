package kotlinx.coroutines;

import kotlin.coroutines.ContinuationInterceptor;

public interface EventLoop extends ContinuationInterceptor {
    long processNextEvent();
}
