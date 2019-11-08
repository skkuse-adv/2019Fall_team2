package com.google.android.gms.internal.firebase-perf;

public enum zzem {
    DOUBLE(0, zzeo.SCALAR, zzez.DOUBLE),
    FLOAT(1, zzeo.SCALAR, zzez.FLOAT),
    INT64(2, zzeo.SCALAR, zzez.LONG),
    UINT64(3, zzeo.SCALAR, zzez.LONG),
    INT32(4, zzeo.SCALAR, zzez.INT),
    FIXED64(5, zzeo.SCALAR, zzez.LONG),
    FIXED32(6, zzeo.SCALAR, zzez.INT),
    BOOL(7, zzeo.SCALAR, zzez.BOOLEAN),
    STRING(8, zzeo.SCALAR, zzez.STRING),
    MESSAGE(9, zzeo.SCALAR, zzez.MESSAGE),
    BYTES(10, zzeo.SCALAR, zzez.BYTE_STRING),
    UINT32(11, zzeo.SCALAR, zzez.INT),
    ENUM(12, zzeo.SCALAR, zzez.ENUM),
    SFIXED32(13, zzeo.SCALAR, zzez.INT),
    SFIXED64(14, zzeo.SCALAR, zzez.LONG),
    SINT32(15, zzeo.SCALAR, zzez.INT),
    SINT64(16, zzeo.SCALAR, zzez.LONG),
    GROUP(17, zzeo.SCALAR, zzez.MESSAGE),
    DOUBLE_LIST(18, zzeo.VECTOR, zzez.DOUBLE),
    FLOAT_LIST(19, zzeo.VECTOR, zzez.FLOAT),
    INT64_LIST(20, zzeo.VECTOR, zzez.LONG),
    UINT64_LIST(21, zzeo.VECTOR, zzez.LONG),
    INT32_LIST(22, zzeo.VECTOR, zzez.INT),
    FIXED64_LIST(23, zzeo.VECTOR, zzez.LONG),
    FIXED32_LIST(24, zzeo.VECTOR, zzez.INT),
    BOOL_LIST(25, zzeo.VECTOR, zzez.BOOLEAN),
    STRING_LIST(26, zzeo.VECTOR, zzez.STRING),
    MESSAGE_LIST(27, zzeo.VECTOR, zzez.MESSAGE),
    BYTES_LIST(28, zzeo.VECTOR, zzez.BYTE_STRING),
    UINT32_LIST(29, zzeo.VECTOR, zzez.INT),
    ENUM_LIST(30, zzeo.VECTOR, zzez.ENUM),
    SFIXED32_LIST(31, zzeo.VECTOR, zzez.INT),
    SFIXED64_LIST(32, zzeo.VECTOR, zzez.LONG),
    SINT32_LIST(33, zzeo.VECTOR, zzez.INT),
    SINT64_LIST(34, zzeo.VECTOR, zzez.LONG),
    DOUBLE_LIST_PACKED(35, zzeo.PACKED_VECTOR, zzez.DOUBLE),
    FLOAT_LIST_PACKED(36, zzeo.PACKED_VECTOR, zzez.FLOAT),
    INT64_LIST_PACKED(37, zzeo.PACKED_VECTOR, zzez.LONG),
    UINT64_LIST_PACKED(38, zzeo.PACKED_VECTOR, zzez.LONG),
    INT32_LIST_PACKED(39, zzeo.PACKED_VECTOR, zzez.INT),
    FIXED64_LIST_PACKED(40, zzeo.PACKED_VECTOR, zzez.LONG),
    FIXED32_LIST_PACKED(41, zzeo.PACKED_VECTOR, zzez.INT),
    BOOL_LIST_PACKED(42, zzeo.PACKED_VECTOR, zzez.BOOLEAN),
    UINT32_LIST_PACKED(43, zzeo.PACKED_VECTOR, zzez.INT),
    ENUM_LIST_PACKED(44, zzeo.PACKED_VECTOR, zzez.ENUM),
    SFIXED32_LIST_PACKED(45, zzeo.PACKED_VECTOR, zzez.INT),
    SFIXED64_LIST_PACKED(46, zzeo.PACKED_VECTOR, zzez.LONG),
    SINT32_LIST_PACKED(47, zzeo.PACKED_VECTOR, zzez.INT),
    SINT64_LIST_PACKED(48, zzeo.PACKED_VECTOR, zzez.LONG),
    GROUP_LIST(49, zzeo.VECTOR, zzez.MESSAGE),
    MAP(50, zzeo.MAP, zzez.VOID);
    
    private static final zzem[] zzqc = null;
    private final int id;

    private zzem(int i, zzeo zzeo, zzez zzez) {
        this.id = i;
        int i2 = zzel.zznx[zzeo.ordinal()];
        if (i2 == 1) {
            zzez.zzhs();
        } else if (i2 == 2) {
            zzez.zzhs();
        }
        if (zzeo == zzeo.SCALAR) {
            int i3 = zzel.zzny[zzez.ordinal()];
            if (i3 != 1 && i3 != 2) {
            }
        }
    }

    public final int id() {
        return this.id;
    }

    static {
        int i;
        zzem[] values = values();
        zzqc = new zzem[values.length];
        for (zzem zzem : values) {
            zzqc[zzem.id] = zzem;
        }
    }
}
