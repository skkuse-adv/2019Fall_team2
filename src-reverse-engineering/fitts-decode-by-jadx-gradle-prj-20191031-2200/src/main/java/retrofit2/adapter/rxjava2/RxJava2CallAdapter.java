package retrofit2.adapter.rxjava2;

import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    RxJava2CallAdapter(Type type, Scheduler scheduler2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = scheduler2;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.Observable] */
    /* JADX WARNING: type inference failed for: r2v2, types: [io.reactivex.Observable] */
    /* JADX WARNING: type inference failed for: r2v3, types: [io.reactivex.Observable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [io.reactivex.Completable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [io.reactivex.Observable] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12, types: [retrofit2.adapter.rxjava2.BodyObservable] */
    /* JADX WARNING: type inference failed for: r2v13, types: [retrofit2.adapter.rxjava2.ResultObservable] */
    /* JADX WARNING: type inference failed for: r0v8, types: [retrofit2.adapter.rxjava2.CallExecuteObservable] */
    /* JADX WARNING: type inference failed for: r0v9, types: [retrofit2.adapter.rxjava2.CallEnqueueObservable] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object adapt(retrofit2.Call<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.isAsync
            if (r0 == 0) goto L_0x000a
            retrofit2.adapter.rxjava2.CallEnqueueObservable r0 = new retrofit2.adapter.rxjava2.CallEnqueueObservable
            r0.<init>(r2)
            goto L_0x000f
        L_0x000a:
            retrofit2.adapter.rxjava2.CallExecuteObservable r0 = new retrofit2.adapter.rxjava2.CallExecuteObservable
            r0.<init>(r2)
        L_0x000f:
            boolean r2 = r1.isResult
            if (r2 == 0) goto L_0x0019
            retrofit2.adapter.rxjava2.ResultObservable r2 = new retrofit2.adapter.rxjava2.ResultObservable
            r2.<init>(r0)
            goto L_0x0024
        L_0x0019:
            boolean r2 = r1.isBody
            if (r2 == 0) goto L_0x0023
            retrofit2.adapter.rxjava2.BodyObservable r2 = new retrofit2.adapter.rxjava2.BodyObservable
            r2.<init>(r0)
            goto L_0x0024
        L_0x0023:
            r2 = r0
        L_0x0024:
            io.reactivex.Scheduler r0 = r1.scheduler
            if (r0 == 0) goto L_0x002c
            io.reactivex.Observable r2 = r2.subscribeOn(r0)
        L_0x002c:
            boolean r0 = r1.isFlowable
            if (r0 == 0) goto L_0x0037
            io.reactivex.BackpressureStrategy r0 = io.reactivex.BackpressureStrategy.LATEST
            io.reactivex.Flowable r2 = r2.toFlowable(r0)
            return r2
        L_0x0037:
            boolean r0 = r1.isSingle
            if (r0 == 0) goto L_0x0040
            io.reactivex.Single r2 = r2.singleOrError()
            return r2
        L_0x0040:
            boolean r0 = r1.isMaybe
            if (r0 == 0) goto L_0x0049
            io.reactivex.Maybe r2 = r2.singleElement()
            return r2
        L_0x0049:
            boolean r0 = r1.isCompletable
            if (r0 == 0) goto L_0x0051
            io.reactivex.Completable r2 = r2.ignoreElements()
        L_0x0051:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.RxJava2CallAdapter.adapt(retrofit2.Call):java.lang.Object");
    }
}
