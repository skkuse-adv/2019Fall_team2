package org.jetbrains.anko.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ManagedSQLiteOpenHelper extends SQLiteOpenHelper {
    private final AtomicInteger counter;
    private SQLiteDatabase db;

    public /* synthetic */ ManagedSQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            cursorFactory = null;
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        this(context, str, cursorFactory, i);
    }

    public ManagedSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @Nullable CursorFactory cursorFactory, int i) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        super(context, str, cursorFactory, i);
        this.counter = new AtomicInteger();
    }

    public final <T> T use(@NotNull Function1<? super SQLiteDatabase, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        try {
            return function1.invoke(openDatabase());
        } finally {
            closeDatabase();
        }
    }

    private final synchronized SQLiteDatabase openDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (this.counter.incrementAndGet() == 1) {
            this.db = getWritableDatabase();
        }
        sQLiteDatabase = this.db;
        if (sQLiteDatabase == null) {
            Intrinsics.throwNpe();
        }
        return sQLiteDatabase;
    }

    private final synchronized void closeDatabase() {
        if (this.counter.decrementAndGet() == 0) {
            SQLiteDatabase sQLiteDatabase = this.db;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        }
    }
}
