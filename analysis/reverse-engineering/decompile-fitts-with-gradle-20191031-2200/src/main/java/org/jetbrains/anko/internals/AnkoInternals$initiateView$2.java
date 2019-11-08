package org.jetbrains.anko.internals;

import android.content.Context;
import android.util.AttributeSet;
import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AnkoInternals$initiateView$2 extends Lambda implements Function0<Constructor<T>> {
    final /* synthetic */ Class $viewClass;

    AnkoInternals$initiateView$2(Class cls) {
        this.$viewClass = cls;
        super(0);
    }

    public final Constructor<T> invoke() {
        return this.$viewClass.getConstructor(new Class[]{Context.class, AttributeSet.class});
    }
}
