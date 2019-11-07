package kr.co.popone.fitts.viewmodel.store;

import androidx.lifecycle.MutableLiveData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class StoreViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MutableLiveData<Integer> cartVariantCountLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final FittsServiceRepository serviceRepository;
    private final UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getStoreTabName(int i) {
        if (i == 0) {
            return "home";
        }
        if (i == 1) {
            return "best";
        }
        if (i == 2) {
            return AppSettingsData.STATUS_NEW;
        }
        if (i != 3) {
            return null;
        }
        return "store";
    }

    public StoreViewModel(@NotNull UserAPI userAPI2, @NotNull EventTracker eventTracker2, @NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        this.userAPI = userAPI2;
        this.eventTracker = eventTracker2;
        this.serviceRepository = fittsServiceRepository;
    }

    @NotNull
    public final MutableLiveData<Integer> getCartVariantCountLiveData() {
        return this.cartVariantCountLiveData;
    }

    public final void getBadgeCount() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userAPI.getBadgeCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreViewModel$getBadgeCount$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.getBadgeCount()\n…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void onStoreTabSelected(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "from");
        int hashCode = str.hashCode();
        if (hashCode != -907987547) {
            if (hashCode == 109770977 && str.equals("store")) {
                storeTabSelectAnswer(i);
                storeTabDetailAnswer(i, str);
                storeTabSelectActionLog(i, false);
            }
        } else if (str.equals("scheme")) {
            storeTabDetailAnswer(i, str);
            storeTabSelectActionLog(i, true);
        }
    }

    private final void storeTabSelectAnswer(int i) {
        String storeTabName = getStoreTabName(i);
        if (storeTabName != null) {
            this.eventTracker.customLogTapStoreTab(storeTabName);
        }
    }

    private final void storeTabDetailAnswer(int i, String str) {
        String str2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : "Tap Store Shop Tab" : "Tap Store New Tab" : "Tap Store Best Tab" : "Tap Store Home Tab";
        if (str2 != null) {
            this.eventTracker.customLogTabStoreDetailTab(str2, str);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v3, types: [kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v6, types: [kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder] */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v9, types: [kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder] */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v12, types: [kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder] */
    /* JADX WARNING: type inference failed for: r4v13, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String, kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder]
  uses: [java.lang.String, java.lang.Object, ?[int, boolean, OBJECT, ARRAY, byte, short, char], kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder]
  mth insns count: 85
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void storeTabSelectActionLog(int r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            r1 = 0
            java.lang.String r2 = "fitts://storeHome?tabName=%s"
            java.lang.String r3 = "StoreHomeFeed"
            r4 = 0
            r5 = 1
            if (r8 == 0) goto L_0x0094
            if (r8 == r5) goto L_0x006a
            r6 = 2
            if (r8 == r6) goto L_0x0040
            r6 = 3
            if (r8 == r6) goto L_0x0015
            goto L_0x00bd
        L_0x0015:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = new kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setPath(r3)
            java.lang.String r3 = "Shop"
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setSubPath(r3)
            if (r9 == 0) goto L_0x003a
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r3 = "shop"
            r9[r1] = r3
            int r1 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)
            java.lang.String r4 = java.lang.String.format(r2, r9)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
        L_0x003a:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r4 = r8.setScheme(r4)
            goto L_0x00bd
        L_0x0040:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = new kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setPath(r3)
            java.lang.String r3 = "New"
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setSubPath(r3)
            if (r9 == 0) goto L_0x0065
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r3 = "new"
            r9[r1] = r3
            int r1 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)
            java.lang.String r4 = java.lang.String.format(r2, r9)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
        L_0x0065:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r4 = r8.setScheme(r4)
            goto L_0x00bd
        L_0x006a:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = new kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setPath(r3)
            java.lang.String r3 = "Sale"
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setSubPath(r3)
            if (r9 == 0) goto L_0x008f
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r3 = "sale"
            r9[r1] = r3
            int r1 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)
            java.lang.String r4 = java.lang.String.format(r2, r9)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
        L_0x008f:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r4 = r8.setScheme(r4)
            goto L_0x00bd
        L_0x0094:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = new kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setPath(r3)
            java.lang.String r3 = "Home"
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r8 = r8.setSubPath(r3)
            if (r9 == 0) goto L_0x00b9
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r3 = "home"
            r9[r1] = r3
            int r1 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)
            java.lang.String r4 = java.lang.String.format(r2, r9)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
        L_0x00b9:
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog$Builder r4 = r8.setScheme(r4)
        L_0x00bd:
            if (r4 == 0) goto L_0x00d8
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog r8 = r4.build()
            if (r8 == 0) goto L_0x00d8
            kr.co.popone.fitts.model.repository.service.FittsServiceRepository r9 = r7.serviceRepository
            io.reactivex.Completable r8 = r9.postFittsActionLog(r8)
            kr.co.popone.fitts.viewmodel.store.StoreViewModel$storeTabSelectActionLog$1$1 r9 = kr.co.popone.fitts.viewmodel.store.StoreViewModel$storeTabSelectActionLog$1$1.INSTANCE
            kr.co.popone.fitts.viewmodel.store.StoreViewModel$storeTabSelectActionLog$1$2 r0 = kr.co.popone.fitts.viewmodel.store.StoreViewModel$storeTabSelectActionLog$1$2.INSTANCE
            io.reactivex.disposables.Disposable r8 = io.reactivex.rxkotlin.SubscribersKt.subscribeBy(r8, r9, r0)
            io.reactivex.disposables.CompositeDisposable r9 = r7.disposables
            io.reactivex.rxkotlin.DisposableKt.addTo(r8, r9)
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.store.StoreViewModel.storeTabSelectActionLog(int, boolean):void");
    }

    public final void logTapSlideMenu() {
        this.eventTracker.customLogTapSlideMenu();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
