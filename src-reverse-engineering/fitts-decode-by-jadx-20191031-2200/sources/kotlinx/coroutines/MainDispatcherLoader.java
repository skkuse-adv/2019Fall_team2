package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

final class MainDispatcherLoader {
    public static final MainDispatcherLoader INSTANCE;
    @NotNull
    public static final MainCoroutineDispatcher dispatcher;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        if (r0 != null) goto L_0x0058;
     */
    static {
        /*
            kotlinx.coroutines.MainDispatcherLoader r0 = new kotlinx.coroutines.MainDispatcherLoader
            r0.<init>()
            INSTANCE = r0
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r1 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r2 = r1.getClassLoader()
            java.util.ServiceLoader r1 = java.util.ServiceLoader.load(r1, r2)
            java.lang.String r2 = "ServiceLoader.load(clz, clz.classLoader)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)
            java.util.Iterator r1 = r1.iterator()
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 != 0) goto L_0x0027
            r2 = r3
            goto L_0x0048
        L_0x0027:
            java.lang.Object r2 = r1.next()
            r4 = r2
            kotlinx.coroutines.internal.MainDispatcherFactory r4 = (kotlinx.coroutines.internal.MainDispatcherFactory) r4
            int r4 = r4.getLoadPriority()
        L_0x0032:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0048
            java.lang.Object r5 = r1.next()
            r6 = r5
            kotlinx.coroutines.internal.MainDispatcherFactory r6 = (kotlinx.coroutines.internal.MainDispatcherFactory) r6
            int r6 = r6.getLoadPriority()
            if (r4 >= r6) goto L_0x0032
            r2 = r5
            r4 = r6
            goto L_0x0032
        L_0x0048:
            kotlinx.coroutines.internal.MainDispatcherFactory r2 = (kotlinx.coroutines.internal.MainDispatcherFactory) r2
            if (r2 == 0) goto L_0x0053
            kotlinx.coroutines.MainCoroutineDispatcher r0 = r0.tryCreateDispatcher(r2)
            if (r0 == 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            kotlinx.coroutines.MissingMainCoroutineDispatcher r0 = new kotlinx.coroutines.MissingMainCoroutineDispatcher
            r0.<init>(r3)
        L_0x0058:
            dispatcher = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.MainDispatcherLoader.<clinit>():void");
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory mainDispatcherFactory) {
        try {
            return mainDispatcherFactory.createDispatcher();
        } catch (Throwable th) {
            return new MissingMainCoroutineDispatcher(th);
        }
    }
}
