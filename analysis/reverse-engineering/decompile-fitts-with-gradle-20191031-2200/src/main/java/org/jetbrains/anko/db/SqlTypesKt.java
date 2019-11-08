package org.jetbrains.anko.db;

import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SqlTypesKt {
    @NotNull
    private static final SqlTypeModifier AUTOINCREMENT = new SqlTypeModifierImpl("AUTOINCREMENT");
    @NotNull
    private static final SqlType BLOB = new SqlTypeImpl("BLOB", null, 2, null);
    @NotNull
    private static final SqlType INTEGER = new SqlTypeImpl("INTEGER", null, 2, null);
    @NotNull
    private static final SqlTypeModifier NOT_NULL = new SqlTypeModifierImpl("NOT NULL");
    @NotNull
    private static final SqlType NULL = new SqlTypeImpl("NULL", null, 2, null);
    @NotNull
    private static final SqlTypeModifier PRIMARY_KEY = new SqlTypeModifierImpl("PRIMARY KEY");
    @NotNull
    private static final SqlType REAL = new SqlTypeImpl("REAL", null, 2, null);
    @NotNull
    private static final SqlType TEXT = new SqlTypeImpl("TEXT", null, 2, null);
    @NotNull
    private static final SqlTypeModifier UNIQUE = new SqlTypeModifierImpl("UNIQUE");

    @NotNull
    public static final SqlType getNULL() {
        return NULL;
    }

    @NotNull
    public static final SqlType getINTEGER() {
        return INTEGER;
    }

    @NotNull
    public static final SqlType getREAL() {
        return REAL;
    }

    @NotNull
    public static final SqlType getTEXT() {
        return TEXT;
    }

    @NotNull
    public static final SqlType getBLOB() {
        return BLOB;
    }

    @NotNull
    public static final SqlTypeModifier ON_UPDATE(@NotNull ConstraintActions constraintActions) {
        Intrinsics.checkParameterIsNotNull(constraintActions, "constraintActions");
        StringBuilder sb = new StringBuilder();
        sb.append("ON UPDATE ");
        sb.append(constraintActions);
        return new SqlTypeModifierImpl(sb.toString());
    }

    @NotNull
    public static final SqlTypeModifier ON_DELETE(@NotNull ConstraintActions constraintActions) {
        Intrinsics.checkParameterIsNotNull(constraintActions, "constraintActions");
        StringBuilder sb = new StringBuilder();
        sb.append("ON DELETE ");
        sb.append(constraintActions);
        return new SqlTypeModifierImpl(sb.toString());
    }

    @NotNull
    public static final Pair<String, SqlType> FOREIGN_KEY(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull SqlTypeModifier... sqlTypeModifierArr) {
        Intrinsics.checkParameterIsNotNull(str, "columnName");
        Intrinsics.checkParameterIsNotNull(str2, "referenceTable");
        Intrinsics.checkParameterIsNotNull(str3, "referenceColumn");
        Intrinsics.checkParameterIsNotNull(sqlTypeModifierArr, "actions");
        StringBuilder sb = new StringBuilder();
        sb.append("FOREIGN KEY(");
        sb.append(str);
        sb.append(") REFERENCES ");
        sb.append(str2);
        sb.append('(');
        sb.append(str3);
        sb.append(')');
        ArrayList arrayList = new ArrayList(sqlTypeModifierArr.length);
        for (SqlTypeModifier modifier : sqlTypeModifierArr) {
            arrayList.add(modifier.getModifier());
        }
        sb.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, SqlTypesKt$FOREIGN_KEY$2.INSTANCE, 30, null));
        return TuplesKt.to("", new SqlTypeImpl(sb.toString(), null, 2, null));
    }

    @NotNull
    public static final SqlTypeModifier getPRIMARY_KEY() {
        return PRIMARY_KEY;
    }

    @NotNull
    public static final SqlTypeModifier getNOT_NULL() {
        return NOT_NULL;
    }

    @NotNull
    public static final SqlTypeModifier getAUTOINCREMENT() {
        return AUTOINCREMENT;
    }

    @NotNull
    public static final SqlTypeModifier getUNIQUE() {
        return UNIQUE;
    }

    @NotNull
    public static final SqlTypeModifier UNIQUE(@NotNull ConflictClause conflictClause) {
        Intrinsics.checkParameterIsNotNull(conflictClause, "conflictClause");
        StringBuilder sb = new StringBuilder();
        sb.append("UNIQUE ON CONFLICT ");
        sb.append(conflictClause);
        return new SqlTypeModifierImpl(sb.toString());
    }

    @NotNull
    public static final SqlTypeModifier DEFAULT(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        StringBuilder sb = new StringBuilder();
        sb.append("DEFAULT ");
        sb.append(str);
        return new SqlTypeModifierImpl(sb.toString());
    }
}
