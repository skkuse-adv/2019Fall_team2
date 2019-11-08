package org.jetbrains.anko.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AndroidSdkDatabaseUpdateQueryBuilder extends UpdateQueryBuilder {
    private final SQLiteDatabase db;

    public AndroidSdkDatabaseUpdateQueryBuilder(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkParameterIsNotNull(str, "table");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        super(str, pairArr);
        this.db = sQLiteDatabase;
    }

    public int execUpdate(@NotNull String str, @NotNull ContentValues contentValues, @Nullable String str2, @Nullable String[] strArr) {
        Intrinsics.checkParameterIsNotNull(str, "table");
        Intrinsics.checkParameterIsNotNull(contentValues, "values");
        return this.db.update(str, contentValues, str2, strArr);
    }
}
