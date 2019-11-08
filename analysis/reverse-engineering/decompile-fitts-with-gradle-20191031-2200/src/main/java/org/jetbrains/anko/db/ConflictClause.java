package org.jetbrains.anko.db;

public enum ConflictClause {
    ROLLBACK,
    ABORT,
    FAIL,
    IGNORE,
    REPLACE
}
