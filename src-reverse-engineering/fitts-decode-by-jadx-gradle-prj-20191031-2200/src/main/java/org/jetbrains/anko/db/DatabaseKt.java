package org.jetbrains.anko.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DatabaseKt {
    private static final Pattern ARG_PATTERN;

    public static final long insert(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.insert(str, null, toContentValues(pairArr));
    }

    public static final long insertOrThrow(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.insertOrThrow(str, null, toContentValues(pairArr));
    }

    public static final long replace(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.replace(str, null, toContentValues(pairArr));
    }

    public static final long replaceOrThrow(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.replaceOrThrow(str, null, toContentValues(pairArr));
    }

    public static final void transaction(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull Function1<? super SQLiteDatabase, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "code");
        try {
            sQLiteDatabase.beginTransaction();
            function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (TransactionAbortException unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    @NotNull
    public static final SelectQueryBuilder select(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        return new AndroidSdkDatabaseSelectQueryBuilder(sQLiteDatabase, str);
    }

    @NotNull
    public static final SelectQueryBuilder select(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        AndroidSdkDatabaseSelectQueryBuilder androidSdkDatabaseSelectQueryBuilder = new AndroidSdkDatabaseSelectQueryBuilder(sQLiteDatabase, str);
        androidSdkDatabaseSelectQueryBuilder.columns((String[]) Arrays.copyOf(strArr, strArr.length));
        return androidSdkDatabaseSelectQueryBuilder;
    }

    @NotNull
    public static final UpdateQueryBuilder update(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return new AndroidSdkDatabaseUpdateQueryBuilder(sQLiteDatabase, str, pairArr);
    }

    public static /* synthetic */ int delete$default(SQLiteDatabase sQLiteDatabase, String str, String str2, Pair[] pairArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return delete(sQLiteDatabase, str, str2, pairArr);
    }

    public static final int delete(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull String str2, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(str2, "whereClause");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        return sQLiteDatabase.delete(str, applyArguments(str2, (Pair<String, ? extends Object>[]) (Pair[]) Arrays.copyOf(pairArr, pairArr.length)), null);
    }

    public static /* synthetic */ void createTable$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, Pair[] pairArr, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createTable(sQLiteDatabase, str, z, pairArr);
    }

    public static final void createTable(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, boolean z, @NotNull Pair<String, ? extends SqlType>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "columns");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF NOT EXISTS" : "";
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<String, ? extends SqlType> pair : pairArr) {
            StringBuilder sb = new StringBuilder();
            sb.append((String) pair.getFirst());
            sb.append(' ');
            sb.append(((SqlType) pair.getSecond()).render());
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        sb2.append(str2);
        sb2.append(" `");
        sb2.append(replace$default);
        sb2.append("`(");
        sQLiteDatabase.execSQL(CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", sb2.toString(), ");", 0, null, null, 56, null));
    }

    public static /* synthetic */ void dropTable$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dropTable(sQLiteDatabase, str, z);
    }

    public static final void dropTable(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF EXISTS" : "";
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(str2);
        sb.append(" `");
        sb.append(replace$default);
        sb.append("`;");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public static /* synthetic */ void createIndex$default(SQLiteDatabase sQLiteDatabase, String str, String str2, boolean z, boolean z2, String[] strArr, int i, Object obj) {
        createIndex(sQLiteDatabase, str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, strArr);
    }

    public static final void createIndex(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull String str2, boolean z, boolean z2, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "indexName");
        Intrinsics.checkParameterIsNotNull(str2, "tableName");
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String replace$default2 = StringsKt__StringsJVMKt.replace$default(str2, "`", "``", false, 4, (Object) null);
        String str3 = "";
        String str4 = z2 ? "IF NOT EXISTS" : str3;
        if (z) {
            str3 = "UNIQUE";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE ");
        sb.append(str3);
        sb.append(" INDEX ");
        sb.append(str4);
        sb.append(" `");
        sb.append(replace$default);
        sb.append("` ON `");
        sb.append(replace$default2);
        sb.append("`(");
        sQLiteDatabase.execSQL(ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) ",", (CharSequence) sb.toString(), (CharSequence) ");", 0, (CharSequence) null, (Function1) null, 56, (Object) null));
    }

    public static /* synthetic */ void dropIndex$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dropIndex(sQLiteDatabase, str, z);
    }

    public static final void dropIndex(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "indexName");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF EXISTS" : "";
        StringBuilder sb = new StringBuilder();
        sb.append("DROP INDEX ");
        sb.append(str2);
        sb.append(" `");
        sb.append(replace$default);
        sb.append("`;");
        sQLiteDatabase.execSQL(sb.toString());
    }

    static {
        Pattern compile = Pattern.compile("([^\\\\])\\{([^{}]+)\\}");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"([^\\\\\\\\])\\\\{([^{}]+)\\\\}\")");
        ARG_PATTERN = compile;
    }

    @NotNull
    public static final String applyArguments(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "whereClause");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        HashMap hashMap = new HashMap();
        for (Pair<String, ? extends Object> pair : pairArr) {
            hashMap.put(pair.getFirst(), pair.getSecond());
        }
        return applyArguments(str, (Map<String, ? extends Object>) hashMap);
    }

    @NotNull
    public static final String applyArguments(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "whereClause");
        Intrinsics.checkParameterIsNotNull(map, "args");
        Matcher matcher = ARG_PATTERN.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            String group = matcher.group(2);
            Object obj = map.get(group);
            if (obj != null) {
                if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
                    str2 = obj.toString();
                } else if (obj instanceof Boolean) {
                    str2 = ((Boolean) obj).booleanValue() ? "1" : "0";
                } else if ((obj instanceof Float) || (obj instanceof Double)) {
                    str2 = obj.toString();
                } else {
                    StringBuilder sb = new StringBuilder();
                    String replace$default = StringsKt__StringsJVMKt.replace$default(obj.toString(), "'", "''", false, 4, (Object) null);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.valueOf('\''));
                    sb2.append(replace$default);
                    sb.append(sb2.toString());
                    sb.append('\'');
                    str2 = sb.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(matcher.group(1));
                sb3.append(str2);
                matcher.appendReplacement(stringBuffer, sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't find a value for key ");
                sb4.append(group);
                throw new IllegalStateException(sb4.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final ContentValues toContentValues(@NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "receiver$0");
        ContentValues contentValues = new ContentValues();
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                contentValues.putNull(str);
            } else if (component2 instanceof Boolean) {
                contentValues.put(str, (Boolean) component2);
            } else if (component2 instanceof Byte) {
                contentValues.put(str, (Byte) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(str, (byte[]) component2);
            } else if (component2 instanceof Double) {
                contentValues.put(str, (Double) component2);
            } else if (component2 instanceof Float) {
                contentValues.put(str, (Float) component2);
            } else if (component2 instanceof Integer) {
                contentValues.put(str, (Integer) component2);
            } else if (component2 instanceof Long) {
                contentValues.put(str, (Long) component2);
            } else if (component2 instanceof Short) {
                contentValues.put(str, (Short) component2);
            } else if (component2 instanceof String) {
                contentValues.put(str, (String) component2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Non-supported value type: ");
                sb.append(component2.getClass().getName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return contentValues;
    }
}
