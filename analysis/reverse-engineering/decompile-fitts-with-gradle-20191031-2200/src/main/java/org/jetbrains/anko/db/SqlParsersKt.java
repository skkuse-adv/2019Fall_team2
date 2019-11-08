package org.jetbrains.anko.db;

import android.database.Cursor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SqlParsersKt {
    @NotNull
    private static final RowParser<byte[]> BlobParser = new SingleColumnParser();
    @NotNull
    private static final RowParser<Double> DoubleParser = new SingleColumnParser();
    @NotNull
    private static final RowParser<Float> FloatParser = new ScalarColumnParser(SqlParsersKt$FloatParser$1.INSTANCE);
    @NotNull
    private static final RowParser<Integer> IntParser = new ScalarColumnParser(SqlParsersKt$IntParser$1.INSTANCE);
    @NotNull
    private static final RowParser<Long> LongParser = new SingleColumnParser();
    @NotNull
    private static final RowParser<Short> ShortParser = new ScalarColumnParser(SqlParsersKt$ShortParser$1.INSTANCE);
    @NotNull
    private static final RowParser<String> StringParser = new SingleColumnParser();

    @NotNull
    public static final RowParser<Short> getShortParser() {
        return ShortParser;
    }

    @NotNull
    public static final RowParser<Integer> getIntParser() {
        return IntParser;
    }

    @NotNull
    public static final RowParser<Long> getLongParser() {
        return LongParser;
    }

    @NotNull
    public static final RowParser<Float> getFloatParser() {
        return FloatParser;
    }

    @NotNull
    public static final RowParser<Double> getDoubleParser() {
        return DoubleParser;
    }

    @NotNull
    public static final RowParser<String> getStringParser() {
        return StringParser;
    }

    @NotNull
    public static final RowParser<byte[]> getBlobParser() {
        return BlobParser;
    }

    @NotNull
    public static final Sequence<Object[]> sequence(@NotNull Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "receiver$0");
        return new CursorSequence(cursor);
    }

    @NotNull
    public static final Sequence<Map<String, Object>> mapSequence(@NotNull Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "receiver$0");
        return new CursorMapSequence(cursor);
    }

    @NotNull
    public static final Sequence<Object[]> asSequence(@NotNull Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "receiver$0");
        return new CursorSequence(cursor);
    }

    @NotNull
    public static final Sequence<Map<String, Object>> asMapSequence(@NotNull Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "receiver$0");
        return new CursorMapSequence(cursor);
    }

    private static final Object getColumnValue(@NotNull Cursor cursor, int i) {
        Object obj = null;
        if (cursor.isNull(i)) {
            return null;
        }
        int type = cursor.getType(i);
        if (type == 1) {
            obj = Long.valueOf(cursor.getLong(i));
        } else if (type == 2) {
            obj = Double.valueOf(cursor.getDouble(i));
        } else if (type == 3) {
            obj = cursor.getString(i);
        } else if (type == 4) {
            obj = (Serializable) cursor.getBlob(i);
        }
        return obj;
    }

    /* access modifiers changed from: private */
    public static final Object[] readColumnsArray(Cursor cursor) {
        int columnCount = cursor.getColumnCount();
        Object[] objArr = new Object[columnCount];
        int i = columnCount - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                objArr[i2] = getColumnValue(cursor, i2);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return objArr;
    }

    /* access modifiers changed from: private */
    public static final Map<String, Object> readColumnsMap(Cursor cursor) {
        int columnCount = cursor.getColumnCount();
        HashMap hashMap = new HashMap();
        int i = columnCount - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                hashMap.put(cursor.getColumnName(i2), getColumnValue(cursor, i2));
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T parseSingle(@org.jetbrains.annotations.NotNull android.database.Cursor r4, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r5) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "parseSingle accepts only cursors with a single entry"
            r2 = 1
            r3 = 16
            if (r0 < r3) goto L_0x0036
            r0 = 0
            int r3 = r4.getCount()     // Catch:{ all -> 0x002f }
            if (r3 != r2) goto L_0x0029
            r4.moveToFirst()     // Catch:{ all -> 0x002f }
            java.lang.Object[] r1 = readColumnsArray(r4)     // Catch:{ all -> 0x002f }
            java.lang.Object r5 = r5.parseRow(r1)     // Catch:{ all -> 0x002f }
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            return r5
        L_0x0029:
            android.database.sqlite.SQLiteException r5 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x002f }
            r5.<init>(r1)     // Catch:{ all -> 0x002f }
            throw r5     // Catch:{ all -> 0x002f }
        L_0x002f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)
            throw r0
        L_0x0036:
            int r0 = r4.getCount()     // Catch:{ all -> 0x0051 }
            if (r0 != r2) goto L_0x004b
            r4.moveToFirst()     // Catch:{ all -> 0x0051 }
            java.lang.Object[] r0 = readColumnsArray(r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r5 = r5.parseRow(r0)     // Catch:{ all -> 0x0051 }
            r4.close()     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            return r5
        L_0x004b:
            android.database.sqlite.SQLiteException r5 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0051 }
            r5.<init>(r1)     // Catch:{ all -> 0x0051 }
            throw r5     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r5 = move-exception
            r4.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseSingle(android.database.Cursor, org.jetbrains.anko.db.RowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T parseOpt(@org.jetbrains.annotations.NotNull android.database.Cursor r5, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r6) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "parseSingle accepts only cursors with a single entry or empty cursors"
            r2 = 1
            r3 = 0
            r4 = 16
            if (r0 < r4) goto L_0x0040
            int r0 = r5.getCount()     // Catch:{ all -> 0x0039 }
            if (r0 > r2) goto L_0x0033
            int r0 = r5.getCount()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0024
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            return r3
        L_0x0024:
            r5.moveToFirst()     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r0 = readColumnsArray(r5)     // Catch:{ all -> 0x0039 }
            java.lang.Object r6 = r6.parseRow(r0)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            return r6
        L_0x0033:
            android.database.sqlite.SQLiteException r6 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0039 }
            r6.<init>(r1)     // Catch:{ all -> 0x0039 }
            throw r6     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)
            throw r0
        L_0x0040:
            int r0 = r5.getCount()     // Catch:{ all -> 0x0065 }
            if (r0 > r2) goto L_0x005f
            int r0 = r5.getCount()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0050
            r5.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return r3
        L_0x0050:
            r5.moveToFirst()     // Catch:{ all -> 0x0065 }
            java.lang.Object[] r0 = readColumnsArray(r5)     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = r6.parseRow(r0)     // Catch:{ all -> 0x0065 }
            r5.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            return r6
        L_0x005f:
            android.database.sqlite.SQLiteException r6 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0065 }
            r6.<init>(r1)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r6 = move-exception
            r5.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseOpt(android.database.Cursor, org.jetbrains.anko.db.RowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.util.List<T> parseList(@org.jetbrains.annotations.NotNull android.database.Cursor r3, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.RowParser<? extends T> r4) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x003d
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0036 }
            int r2 = r3.getCount()     // Catch:{ all -> 0x0036 }
            r1.<init>(r2)     // Catch:{ all -> 0x0036 }
            r3.moveToFirst()     // Catch:{ all -> 0x0036 }
        L_0x001d:
            boolean r2 = r3.isAfterLast()     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x0032
            java.lang.Object[] r2 = readColumnsArray(r3)     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r4.parseRow(r2)     // Catch:{ all -> 0x0036 }
            r1.add(r2)     // Catch:{ all -> 0x0036 }
            r3.moveToNext()     // Catch:{ all -> 0x0036 }
            goto L_0x001d
        L_0x0032:
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            return r1
        L_0x0036:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        L_0x003d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0062 }
            int r1 = r3.getCount()     // Catch:{ all -> 0x0062 }
            r0.<init>(r1)     // Catch:{ all -> 0x0062 }
            r3.moveToFirst()     // Catch:{ all -> 0x0062 }
        L_0x0049:
            boolean r1 = r3.isAfterLast()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x005e
            java.lang.Object[] r1 = readColumnsArray(r3)     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = r4.parseRow(r1)     // Catch:{ all -> 0x0062 }
            r0.add(r1)     // Catch:{ all -> 0x0062 }
            r3.moveToNext()     // Catch:{ all -> 0x0062 }
            goto L_0x0049
        L_0x005e:
            r3.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            return r0
        L_0x0062:
            r4 = move-exception
            r3.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            goto L_0x0068
        L_0x0067:
            throw r4
        L_0x0068:
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseList(android.database.Cursor, org.jetbrains.anko.db.RowParser):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T parseSingle(@org.jetbrains.annotations.NotNull android.database.Cursor r4, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r5) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "parseSingle accepts only cursors with getCount() == 1"
            r2 = 1
            r3 = 16
            if (r0 < r3) goto L_0x0036
            r0 = 0
            int r3 = r4.getCount()     // Catch:{ all -> 0x002f }
            if (r3 != r2) goto L_0x0029
            r4.moveToFirst()     // Catch:{ all -> 0x002f }
            java.util.Map r1 = readColumnsMap(r4)     // Catch:{ all -> 0x002f }
            java.lang.Object r5 = r5.parseRow(r1)     // Catch:{ all -> 0x002f }
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            return r5
        L_0x0029:
            android.database.sqlite.SQLiteException r5 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x002f }
            r5.<init>(r1)     // Catch:{ all -> 0x002f }
            throw r5     // Catch:{ all -> 0x002f }
        L_0x002f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)
            throw r0
        L_0x0036:
            int r0 = r4.getCount()     // Catch:{ all -> 0x0051 }
            if (r0 != r2) goto L_0x004b
            r4.moveToFirst()     // Catch:{ all -> 0x0051 }
            java.util.Map r0 = readColumnsMap(r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r5 = r5.parseRow(r0)     // Catch:{ all -> 0x0051 }
            r4.close()     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            return r5
        L_0x004b:
            android.database.sqlite.SQLiteException r5 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0051 }
            r5.<init>(r1)     // Catch:{ all -> 0x0051 }
            throw r5     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r5 = move-exception
            r4.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseSingle(android.database.Cursor, org.jetbrains.anko.db.MapRowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T parseOpt(@org.jetbrains.annotations.NotNull android.database.Cursor r5, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r6) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "parseSingle accepts only cursors with getCount() == 1 or empty cursors"
            r2 = 1
            r3 = 0
            r4 = 16
            if (r0 < r4) goto L_0x0040
            int r0 = r5.getCount()     // Catch:{ all -> 0x0039 }
            if (r0 > r2) goto L_0x0033
            int r0 = r5.getCount()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0024
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            return r3
        L_0x0024:
            r5.moveToFirst()     // Catch:{ all -> 0x0039 }
            java.util.Map r0 = readColumnsMap(r5)     // Catch:{ all -> 0x0039 }
            java.lang.Object r6 = r6.parseRow(r0)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            return r6
        L_0x0033:
            android.database.sqlite.SQLiteException r6 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0039 }
            r6.<init>(r1)     // Catch:{ all -> 0x0039 }
            throw r6     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)
            throw r0
        L_0x0040:
            int r0 = r5.getCount()     // Catch:{ all -> 0x0065 }
            if (r0 > r2) goto L_0x005f
            int r0 = r5.getCount()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0050
            r5.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return r3
        L_0x0050:
            r5.moveToFirst()     // Catch:{ all -> 0x0065 }
            java.util.Map r0 = readColumnsMap(r5)     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = r6.parseRow(r0)     // Catch:{ all -> 0x0065 }
            r5.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            return r6
        L_0x005f:
            android.database.sqlite.SQLiteException r6 = new android.database.sqlite.SQLiteException     // Catch:{ all -> 0x0065 }
            r6.<init>(r1)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r6 = move-exception
            r5.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseOpt(android.database.Cursor, org.jetbrains.anko.db.MapRowParser):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.util.List<T> parseList(@org.jetbrains.annotations.NotNull android.database.Cursor r3, @org.jetbrains.annotations.NotNull org.jetbrains.anko.db.MapRowParser<? extends T> r4) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "parser"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x003d
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0036 }
            int r2 = r3.getCount()     // Catch:{ all -> 0x0036 }
            r1.<init>(r2)     // Catch:{ all -> 0x0036 }
            r3.moveToFirst()     // Catch:{ all -> 0x0036 }
        L_0x001d:
            boolean r2 = r3.isAfterLast()     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x0032
            java.util.Map r2 = readColumnsMap(r3)     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r4.parseRow(r2)     // Catch:{ all -> 0x0036 }
            r1.add(r2)     // Catch:{ all -> 0x0036 }
            r3.moveToNext()     // Catch:{ all -> 0x0036 }
            goto L_0x001d
        L_0x0032:
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            return r1
        L_0x0036:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        L_0x003d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0062 }
            int r1 = r3.getCount()     // Catch:{ all -> 0x0062 }
            r0.<init>(r1)     // Catch:{ all -> 0x0062 }
            r3.moveToFirst()     // Catch:{ all -> 0x0062 }
        L_0x0049:
            boolean r1 = r3.isAfterLast()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x005e
            java.util.Map r1 = readColumnsMap(r3)     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = r4.parseRow(r1)     // Catch:{ all -> 0x0062 }
            r0.add(r1)     // Catch:{ all -> 0x0062 }
            r3.moveToNext()     // Catch:{ all -> 0x0062 }
            goto L_0x0049
        L_0x005e:
            r3.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            return r0
        L_0x0062:
            r4 = move-exception
            r3.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            goto L_0x0068
        L_0x0067:
            throw r4
        L_0x0068:
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.SqlParsersKt.parseList(android.database.Cursor, org.jetbrains.anko.db.MapRowParser):java.util.List");
    }
}
