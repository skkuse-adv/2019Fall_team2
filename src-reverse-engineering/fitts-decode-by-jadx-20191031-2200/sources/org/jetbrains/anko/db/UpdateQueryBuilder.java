package org.jetbrains.anko.db;

import android.content.ContentValues;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class UpdateQueryBuilder {
    private String[] nativeSelectionArgs;
    private String selection;
    private boolean selectionApplied;
    @NotNull
    private final String tableName;
    private boolean useNativeSelection;
    @NotNull
    private final Pair<String, Object>[] values;

    public abstract int execUpdate(@NotNull String str, @NotNull ContentValues contentValues, @Nullable String str2, @Nullable String[] strArr);

    public UpdateQueryBuilder(@NotNull String str, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        this.tableName = str;
        this.values = pairArr;
    }

    @NotNull
    public final String getTableName() {
        return this.tableName;
    }

    @NotNull
    public final Pair<String, Object>[] getValues() {
        return this.values;
    }

    @NotNull
    public final UpdateQueryBuilder where(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        return whereArgs(str, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @NotNull
    public final UpdateQueryBuilder whereArgs(@NotNull String str, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = false;
            HashMap hashMap = new HashMap();
            for (Pair<String, ? extends Object> pair : pairArr) {
                hashMap.put(pair.getFirst(), pair.getSecond());
            }
            this.selection = DatabaseKt.applyArguments(str, (Map<String, ? extends Object>) hashMap);
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @NotNull
    public final UpdateQueryBuilder where(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        return whereArgs(str);
    }

    @NotNull
    public final UpdateQueryBuilder whereArgs(@NotNull String str) {
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
    public final UpdateQueryBuilder whereSimple(@NotNull String str, @NotNull String... strArr) {
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
    public final UpdateQueryBuilder whereSupport(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(strArr, "args");
        return whereSimple(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final int exec() {
        String[] strArr = null;
        String str = this.selectionApplied ? this.selection : null;
        if (this.selectionApplied && this.useNativeSelection) {
            strArr = this.nativeSelectionArgs;
        }
        return execUpdate(this.tableName, DatabaseKt.toContentValues(this.values), str, strArr);
    }
}
