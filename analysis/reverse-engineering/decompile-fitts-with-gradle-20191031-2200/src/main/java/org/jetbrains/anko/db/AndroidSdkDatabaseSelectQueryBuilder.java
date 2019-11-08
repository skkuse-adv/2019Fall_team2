package org.jetbrains.anko.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AndroidSdkDatabaseSelectQueryBuilder extends SelectQueryBuilder {
    private final SQLiteDatabase db;

    public AndroidSdkDatabaseSelectQueryBuilder(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        super(str);
        this.db = sQLiteDatabase;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Cursor execQuery(boolean z, @NotNull String str, @NotNull String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6) {
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        String[] strArr3 = strArr;
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        String str8 = str3;
        Intrinsics.checkParameterIsNotNull(str8, "groupBy");
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, "orderBy");
        Cursor query = this.db.query(z, str7, strArr3, str2, strArr2, str8, str4, str9, str6);
        Intrinsics.checkExpressionValueIsNotNull(query, "db.query(distinct, table…, having, orderBy, limit)");
        return query;
    }
}
