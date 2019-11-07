package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class SelectQueryBuilder {
    private final ArrayList<String> columns = new ArrayList<>();
    private boolean distinct;
    private final ArrayList<String> groupBy = new ArrayList<>();
    private String having;
    private boolean havingApplied;
    private String limit;
    private String[] nativeSelectionArgs;
    private final ArrayList<String> orderBy = new ArrayList<>();
    private String selection;
    private boolean selectionApplied;
    @NotNull
    private final String tableName;
    private boolean useNativeSelection;

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Cursor execQuery(boolean z, @NotNull String str, @NotNull String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6);

    public SelectQueryBuilder(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        this.tableName = str;
    }

    @NotNull
    public final String getTableName() {
        return this.tableName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T exec(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "f"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            android.database.Cursor r0 = r3.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r1 < r2) goto L_0x001f
            r1 = 0
            java.lang.Object r4 = r4.invoke(r0)     // Catch:{ all -> 0x0018 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            goto L_0x0026
        L_0x0018:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r1
        L_0x001f:
            java.lang.Object r4 = r4.invoke(r0)     // Catch:{ all -> 0x0027 }
            r0.close()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            return r4
        L_0x0027:
            r4 = move-exception
            r0.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.exec(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T parseSingle(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseSingle(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseSingle(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseSingle(org.jetbrains.anko.db.RowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T parseOpt(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseOpt(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseOpt(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseOpt(org.jetbrains.anko.db.RowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> parseList(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.util.List r5 = org.jetbrains.anko.db.SqlParsersKt.parseList(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.util.List r5 = org.jetbrains.anko.db.SqlParsersKt.parseList(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseList(org.jetbrains.anko.db.RowParser):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T parseSingle(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseSingle(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseSingle(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseSingle(org.jetbrains.anko.db.MapRowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T parseOpt(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseOpt(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.lang.Object r5 = org.jetbrains.anko.db.SqlParsersKt.parseOpt(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseOpt(org.jetbrains.anko.db.MapRowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r0, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> parseList(@org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.database.Cursor r0 = r4.doExec()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 16
            if (r1 < r3) goto L_0x002c
            r1 = 0
            java.util.List r5 = org.jetbrains.anko.db.SqlParsersKt.parseList(r0, r5)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L_0x0039
        L_0x001f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r1
        L_0x002c:
            java.util.List r5 = org.jetbrains.anko.db.SqlParsersKt.parseList(r0, r5)     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SelectQueryBuilder.parseList(org.jetbrains.anko.db.MapRowParser):java.util.List");
    }

    @NotNull
    public final Cursor doExec() {
        String str = this.selectionApplied ? this.selection : null;
        String[] strArr = (!this.selectionApplied || !this.useNativeSelection) ? null : this.nativeSelectionArgs;
        boolean z = this.distinct;
        String str2 = this.tableName;
        ArrayList<String> arrayList = this.columns;
        if (arrayList != null) {
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return execQuery(z, str2, (String[]) array, str, strArr, CollectionsKt___CollectionsKt.joinToString$default(this.groupBy, ", ", null, null, 0, null, null, 62, null), this.having, CollectionsKt___CollectionsKt.joinToString$default(this.orderBy, ", ", null, null, 0, null, null, 62, null), this.limit);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }

    @NotNull
    public final SelectQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    @NotNull
    public final SelectQueryBuilder column(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.columns.add(str);
        return this;
    }

    @NotNull
    public final SelectQueryBuilder groupBy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        this.groupBy.add(str);
        return this;
    }

    @NotNull
    public static /* synthetic */ SelectQueryBuilder orderBy$default(SelectQueryBuilder selectQueryBuilder, String str, SqlOrderDirection sqlOrderDirection, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                sqlOrderDirection = SqlOrderDirection.ASC;
            }
            return selectQueryBuilder.orderBy(str, sqlOrderDirection);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: orderBy");
    }

    @NotNull
    public final SelectQueryBuilder orderBy(@NotNull String str, @NotNull SqlOrderDirection sqlOrderDirection) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(sqlOrderDirection, "direction");
        if (sqlOrderDirection == SqlOrderDirection.DESC) {
            ArrayList<String> arrayList = this.orderBy;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" DESC");
            arrayList.add(sb.toString());
        } else {
            this.orderBy.add(str);
        }
        return this;
    }

    @NotNull
    public final SelectQueryBuilder limit(int i) {
        this.limit = String.valueOf(i);
        return this;
    }

    @NotNull
    public final SelectQueryBuilder limit(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        this.limit = sb.toString();
        return this;
    }

    @NotNull
    public final SelectQueryBuilder columns(@NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "names");
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) this.columns, (T[]) strArr);
        return this;
    }

    @NotNull
    public final SelectQueryBuilder having(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "having");
        if (!this.havingApplied) {
            this.havingApplied = true;
            this.having = str;
            return this;
        }
        throw new AnkoException("Query having was already applied.");
    }

    @NotNull
    public final SelectQueryBuilder having(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "having");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        if (!this.selectionApplied) {
            this.havingApplied = true;
            this.having = DatabaseKt.applyArguments(str, (Pair<String, ? extends Object>[]) (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            return this;
        }
        throw new AnkoException("Query having was already applied.");
    }

    @NotNull
    public final SelectQueryBuilder where(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        return whereArgs(str, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @NotNull
    public final SelectQueryBuilder whereArgs(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = false;
            this.selection = DatabaseKt.applyArguments(str, (Pair<String, ? extends Object>[]) (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @NotNull
    public final SelectQueryBuilder where(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        return whereArgs(str);
    }

    @NotNull
    public final SelectQueryBuilder whereArgs(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = false;
            this.selection = str;
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @NotNull
    public final SelectQueryBuilder whereSimple(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(strArr, "args");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = true;
            this.selection = str;
            this.nativeSelectionArgs = strArr;
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @NotNull
    public final SelectQueryBuilder whereSupport(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(strArr, "args");
        return whereSimple(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
