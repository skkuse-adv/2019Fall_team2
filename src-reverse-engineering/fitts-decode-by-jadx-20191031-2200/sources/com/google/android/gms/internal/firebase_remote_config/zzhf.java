package com.google.android.gms.internal.firebase_remote_config;

public enum zzhf {
    DOUBLE(0, zzhh.SCALAR, zzhs.DOUBLE),
    FLOAT(1, zzhh.SCALAR, zzhs.FLOAT),
    INT64(2, zzhh.SCALAR, zzhs.LONG),
    UINT64(3, zzhh.SCALAR, zzhs.LONG),
    INT32(4, zzhh.SCALAR, zzhs.INT),
    FIXED64(5, zzhh.SCALAR, zzhs.LONG),
    FIXED32(6, zzhh.SCALAR, zzhs.INT),
    BOOL(7, zzhh.SCALAR, zzhs.BOOLEAN),
    STRING(8, zzhh.SCALAR, zzhs.STRING),
    MESSAGE(9, zzhh.SCALAR, zzhs.MESSAGE),
    BYTES(10, zzhh.SCALAR, zzhs.BYTE_STRING),
    UINT32(11, zzhh.SCALAR, zzhs.INT),
    ENUM(12, zzhh.SCALAR, zzhs.ENUM),
    SFIXED32(13, zzhh.SCALAR, zzhs.INT),
    SFIXED64(14, zzhh.SCALAR, zzhs.LONG),
    SINT32(15, zzhh.SCALAR, zzhs.INT),
    SINT64(16, zzhh.SCALAR, zzhs.LONG),
    GROUP(17, zzhh.SCALAR, zzhs.MESSAGE),
    DOUBLE_LIST(18, zzhh.VECTOR, zzhs.DOUBLE),
    FLOAT_LIST(19, zzhh.VECTOR, zzhs.FLOAT),
    INT64_LIST(20, zzhh.VECTOR, zzhs.LONG),
    UINT64_LIST(21, zzhh.VECTOR, zzhs.LONG),
    INT32_LIST(22, zzhh.VECTOR, zzhs.INT),
    FIXED64_LIST(23, zzhh.VECTOR, zzhs.LONG),
    FIXED32_LIST(24, zzhh.VECTOR, zzhs.INT),
    BOOL_LIST(25, zzhh.VECTOR, zzhs.BOOLEAN),
    STRING_LIST(26, zzhh.VECTOR, zzhs.STRING),
    MESSAGE_LIST(27, zzhh.VECTOR, zzhs.MESSAGE),
    BYTES_LIST(28, zzhh.VECTOR, zzhs.BYTE_STRING),
    UINT32_LIST(29, zzhh.VECTOR, zzhs.INT),
    ENUM_LIST(30, zzhh.VECTOR, zzhs.ENUM),
    SFIXED32_LIST(31, zzhh.VECTOR, zzhs.INT),
    SFIXED64_LIST(32, zzhh.VECTOR, zzhs.LONG),
    SINT32_LIST(33, zzhh.VECTOR, zzhs.INT),
    SINT64_LIST(34, zzhh.VECTOR, zzhs.LONG),
    DOUBLE_LIST_PACKED(35, zzhh.PACKED_VECTOR, zzhs.DOUBLE),
    FLOAT_LIST_PACKED(36, zzhh.PACKED_VECTOR, zzhs.FLOAT),
    INT64_LIST_PACKED(37, zzhh.PACKED_VECTOR, zzhs.LONG),
    UINT64_LIST_PACKED(38, zzhh.PACKED_VECTOR, zzhs.LONG),
    INT32_LIST_PACKED(39, zzhh.PACKED_VECTOR, zzhs.INT),
    FIXED64_LIST_PACKED(40, zzhh.PACKED_VECTOR, zzhs.LONG),
    FIXED32_LIST_PACKED(41, zzhh.PACKED_VECTOR, zzhs.INT),
    BOOL_LIST_PACKED(42, zzhh.PACKED_VECTOR, zzhs.BOOLEAN),
    UINT32_LIST_PACKED(43, zzhh.PACKED_VECTOR, zzhs.INT),
    ENUM_LIST_PACKED(44, zzhh.PACKED_VECTOR, zzhs.ENUM),
    SFIXED32_LIST_PACKED(45, zzhh.PACKED_VECTOR, zzhs.INT),
    SFIXED64_LIST_PACKED(46, zzhh.PACKED_VECTOR, zzhs.LONG),
    SINT32_LIST_PACKED(47, zzhh.PACKED_VECTOR, zzhs.INT),
    SINT64_LIST_PACKED(48, zzhh.PACKED_VECTOR, zzhs.LONG),
    GROUP_LIST(49, zzhh.VECTOR, zzhs.MESSAGE),
    MAP(50, zzhh.MAP, zzhs.VOID);
    
    private static final zzhf[] zzsr = null;
    private final int id;

    private zzhf(int i, zzhh zzhh, zzhs zzhs) {
        this.id = i;
        int i2 = zzhe.zzqm[zzhh.ordinal()];
        if (i2 == 1) {
            zzhs.zzho();
        } else if (i2 == 2) {
            zzhs.zzho();
        }
        if (zzhh == zzhh.SCALAR) {
            int i3 = zzhe.zzqn[zzhs.ordinal()];
            if (i3 != 1 && i3 != 2) {
            }
        }
    }

    public final int id() {
        return this.id;
    }

    static {
        int i;
        zzhf[] values = values();
        zzsr = new zzhf[values.length];
        for (zzhf zzhf : values) {
            zzsr[zzhf.id] = zzhf;
        }
    }
}
