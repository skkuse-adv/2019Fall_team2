package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import org.jetbrains.annotations.NotNull;

public final class MainEvent$MainTabChangeEvent {
    @NotNull
    private final Tab tab;

    @NotNull
    public static /* synthetic */ MainEvent$MainTabChangeEvent copy$default(MainEvent$MainTabChangeEvent mainEvent$MainTabChangeEvent, Tab tab2, int i, Object obj) {
        if ((i & 1) != 0) {
            tab2 = mainEvent$MainTabChangeEvent.tab;
        }
        return mainEvent$MainTabChangeEvent.copy(tab2);
    }

    @NotNull
    public final Tab component1() {
        return this.tab;
    }

    @NotNull
    public final MainEvent$MainTabChangeEvent copy(@NotNull Tab tab2) {
        Intrinsics.checkParameterIsNotNull(tab2, "tab");
        return new MainEvent$MainTabChangeEvent(tab2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.tab, (java.lang.Object) ((kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent) r2).tab) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent r2 = (kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent) r2
            kr.co.popone.fitts.feature.main.MainTabBar$Tab r0 = r1.tab
            kr.co.popone.fitts.feature.main.MainTabBar$Tab r2 = r2.tab
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Tab tab2 = this.tab;
        if (tab2 != null) {
            return tab2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MainTabChangeEvent(tab=");
        sb.append(this.tab);
        sb.append(")");
        return sb.toString();
    }

    public MainEvent$MainTabChangeEvent(@NotNull Tab tab2) {
        Intrinsics.checkParameterIsNotNull(tab2, "tab");
        this.tab = tab2;
    }

    @NotNull
    public final Tab getTab() {
        return this.tab;
    }
}
