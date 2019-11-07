package com.kakao.util.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreferencesCache implements PersistentKVStore {
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private final SharedPreferences file;
    private final Bundle memory = new Bundle();

    public SharedPreferencesCache(Context context, String str) {
        Utility.notNull(context, "context");
        Utility.notNull(str, "cacheName");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.file = context.getSharedPreferences(str, 0);
        reloadAll();
    }

    public synchronized void reloadAll() {
        for (String deserializeKey : this.file.getAll().keySet()) {
            try {
                deserializeKey(deserializeKey);
            } catch (JSONException unused) {
            }
        }
    }

    public synchronized void save(Bundle bundle) {
        Utility.notNull(bundle, "bundle");
        Editor edit = this.file.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle.get(str), edit);
            } catch (JSONException unused) {
                return;
            }
        }
        edit.apply();
        for (String deserializeKey : bundle.keySet()) {
            try {
                deserializeKey(deserializeKey);
            } catch (JSONException unused2) {
            }
        }
    }

    public synchronized void remove(String str) {
        Editor edit = this.file.edit();
        edit.remove(str);
        edit.apply();
        this.memory.remove(str);
    }

    public synchronized void clear(List<String> list) {
        Editor edit = this.file.edit();
        for (String remove : list) {
            edit.remove(remove);
        }
        edit.apply();
        for (String remove2 : list) {
            this.memory.remove(remove2);
        }
    }

    public synchronized void clearAll() {
        this.file.edit().clear().apply();
        this.memory.clear();
    }

    @SuppressLint({"ApplySharedPref"})
    public synchronized boolean clearAllSync() {
        boolean commit;
        commit = this.file.edit().clear().commit();
        this.memory.clear();
        return commit;
    }

    public synchronized Map<String, String> getStringMap(String str) {
        HashMap hashMap;
        reloadAll();
        hashMap = new HashMap();
        for (String str2 : this.memory.keySet()) {
            if (str2.startsWith(str)) {
                hashMap.put(str2.substring(str.length()), (String) this.memory.get(str2));
            }
        }
        return hashMap;
    }

    public synchronized void put(String str, Object obj) {
        Editor edit = this.file.edit();
        try {
            serializeKey(str, obj, edit);
            edit.apply();
            try {
                deserializeKey(str);
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
        }
    }

    public synchronized String getString(String str) {
        String string;
        string = this.memory.getString(str);
        if (string == null) {
            try {
                deserializeKey(str);
                string = this.memory.getString(str);
            } catch (JSONException unused) {
            }
        }
        return string;
    }

    public synchronized int getInt(String str) {
        int i;
        i = this.memory.getInt(str);
        if (i == 0) {
            try {
                deserializeKey(str);
                i = this.memory.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|(2:5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Long getLong(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.os.Bundle r0 = r5.memory     // Catch:{ all -> 0x001c }
            long r0 = r0.getLong(r6)     // Catch:{ all -> 0x001c }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0016
            r5.deserializeKey(r6)     // Catch:{ JSONException -> 0x0016 }
            android.os.Bundle r2 = r5.memory     // Catch:{ JSONException -> 0x0016 }
            long r0 = r2.getLong(r6)     // Catch:{ JSONException -> 0x0016 }
        L_0x0016:
            java.lang.Long r6 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x001c }
            monitor-exit(r5)
            return r6
        L_0x001c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.util.helper.SharedPreferencesCache.getLong(java.lang.String):java.lang.Long");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Boolean getBoolean(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.os.Bundle r0 = r1.memory     // Catch:{ all -> 0x0018 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000c
            r1.deserializeKey(r2)     // Catch:{ JSONException -> 0x000c }
        L_0x000c:
            android.os.Bundle r0 = r1.memory     // Catch:{ all -> 0x0018 }
            boolean r2 = r0.getBoolean(r2)     // Catch:{ all -> 0x0018 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)
            return r2
        L_0x0018:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.util.helper.SharedPreferencesCache.getBoolean(java.lang.String):java.lang.Boolean");
    }

    public synchronized Date getDate(String str) {
        Date date;
        long longValue = getLong(str).longValue();
        if (longValue <= 0) {
            date = null;
        } else {
            date = new Date(longValue);
        }
        return date;
    }

    private void serializeKey(String str, Object obj, Editor editor) throws JSONException {
        Object obj2;
        String str2;
        if (obj != null) {
            JSONObject jSONObject = new JSONObject();
            boolean z = obj instanceof Byte;
            JSONArray jSONArray = null;
            String str3 = JSON_VALUE;
            if (z) {
                jSONObject.put(str3, ((Byte) obj).intValue());
                obj2 = TYPE_BYTE;
            } else if (obj instanceof Short) {
                jSONObject.put(str3, ((Short) obj).intValue());
                obj2 = TYPE_SHORT;
            } else if (obj instanceof Integer) {
                jSONObject.put(str3, ((Integer) obj).intValue());
                obj2 = TYPE_INTEGER;
            } else if (obj instanceof Long) {
                jSONObject.put(str3, ((Long) obj).longValue());
                obj2 = TYPE_LONG;
            } else if (obj instanceof Float) {
                jSONObject.put(str3, ((Float) obj).doubleValue());
                obj2 = TYPE_FLOAT;
            } else if (obj instanceof Double) {
                jSONObject.put(str3, ((Double) obj).doubleValue());
                obj2 = TYPE_DOUBLE;
            } else if (obj instanceof Boolean) {
                jSONObject.put(str3, ((Boolean) obj).booleanValue());
                obj2 = TYPE_BOOLEAN;
            } else if (obj instanceof Character) {
                jSONObject.put(str3, obj.toString());
                obj2 = TYPE_CHAR;
            } else if (obj instanceof String) {
                jSONObject.put(str3, obj);
                obj2 = TYPE_STRING;
            } else if (obj instanceof Enum) {
                jSONObject.put(str3, obj.toString());
                jSONObject.put(JSON_VALUE_ENUM_TYPE, obj.getClass().getName());
                obj2 = TYPE_ENUM;
            } else {
                JSONArray jSONArray2 = new JSONArray();
                int i = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    while (i < length) {
                        jSONArray2.put(bArr[i]);
                        i++;
                    }
                    str2 = TYPE_BYTE_ARRAY;
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    int length2 = sArr.length;
                    while (i < length2) {
                        jSONArray2.put(sArr[i]);
                        i++;
                    }
                    str2 = TYPE_SHORT_ARRAY;
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int length3 = iArr.length;
                    while (i < length3) {
                        jSONArray2.put(iArr[i]);
                        i++;
                    }
                    str2 = TYPE_INTEGER_ARRAY;
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    int length4 = jArr.length;
                    while (i < length4) {
                        jSONArray2.put(jArr[i]);
                        i++;
                    }
                    str2 = TYPE_LONG_ARRAY;
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    int length5 = fArr.length;
                    while (i < length5) {
                        jSONArray2.put((double) fArr[i]);
                        i++;
                    }
                    str2 = TYPE_FLOAT_ARRAY;
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    int length6 = dArr.length;
                    while (i < length6) {
                        jSONArray2.put(dArr[i]);
                        i++;
                    }
                    str2 = TYPE_DOUBLE_ARRAY;
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    int length7 = zArr.length;
                    while (i < length7) {
                        jSONArray2.put(zArr[i]);
                        i++;
                    }
                    str2 = TYPE_BOOLEAN_ARRAY;
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    int length8 = cArr.length;
                    while (i < length8) {
                        jSONArray2.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    str2 = TYPE_CHAR_ARRAY;
                } else if (obj instanceof List) {
                    for (Object obj3 : (List) obj) {
                        if (obj3 == null) {
                            obj3 = JSONObject.NULL;
                        }
                        jSONArray2.put(obj3);
                    }
                    str2 = TYPE_STRING_LIST;
                } else {
                    obj2 = null;
                }
                obj2 = str2;
                jSONArray = jSONArray2;
            }
            if (obj2 != null) {
                jSONObject.put(JSON_VALUE_TYPE, obj2);
                if (jSONArray != null) {
                    jSONObject.putOpt(str3, jSONArray);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void deserializeKey(java.lang.String r8) throws org.json.JSONException {
        /*
            r7 = this;
            android.content.SharedPreferences r0 = r7.file
            java.lang.String r1 = "{}"
            java.lang.String r0 = r0.getString(r8, r1)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r0)
            java.lang.String r0 = "valueType"
            java.lang.String r0 = r1.getString(r0)
            int r2 = r0.hashCode()
            r3 = 1
            r4 = 0
            switch(r2) {
                case -1573317553: goto L_0x00e5;
                case -1383386164: goto L_0x00db;
                case -1374008726: goto L_0x00d1;
                case -1361632968: goto L_0x00c6;
                case -1325958191: goto L_0x00bb;
                case -1097129250: goto L_0x00b0;
                case -891985903: goto L_0x00a5;
                case -766441794: goto L_0x009a;
                case 104431: goto L_0x0090;
                case 3029738: goto L_0x0086;
                case 3039496: goto L_0x007b;
                case 3052374: goto L_0x006f;
                case 3118337: goto L_0x0063;
                case 3327612: goto L_0x0057;
                case 97526364: goto L_0x004b;
                case 100361105: goto L_0x0040;
                case 109413500: goto L_0x0035;
                case 1359468275: goto L_0x0029;
                case 2067161310: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x00f0
        L_0x001e:
            java.lang.String r2 = "short[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 5
            goto L_0x00f1
        L_0x0029:
            java.lang.String r2 = "double[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 13
            goto L_0x00f1
        L_0x0035:
            java.lang.String r2 = "short"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 4
            goto L_0x00f1
        L_0x0040:
            java.lang.String r2 = "int[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 7
            goto L_0x00f1
        L_0x004b:
            java.lang.String r2 = "float"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 10
            goto L_0x00f1
        L_0x0057:
            java.lang.String r2 = "long"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 8
            goto L_0x00f1
        L_0x0063:
            java.lang.String r2 = "enum"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 18
            goto L_0x00f1
        L_0x006f:
            java.lang.String r2 = "char"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 14
            goto L_0x00f1
        L_0x007b:
            java.lang.String r2 = "byte"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 2
            goto L_0x00f1
        L_0x0086:
            java.lang.String r2 = "bool"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 0
            goto L_0x00f1
        L_0x0090:
            java.lang.String r2 = "int"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 6
            goto L_0x00f1
        L_0x009a:
            java.lang.String r2 = "float[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 11
            goto L_0x00f1
        L_0x00a5:
            java.lang.String r2 = "string"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 16
            goto L_0x00f1
        L_0x00b0:
            java.lang.String r2 = "long[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 9
            goto L_0x00f1
        L_0x00bb:
            java.lang.String r2 = "double"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 12
            goto L_0x00f1
        L_0x00c6:
            java.lang.String r2 = "char[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 15
            goto L_0x00f1
        L_0x00d1:
            java.lang.String r2 = "byte[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 3
            goto L_0x00f1
        L_0x00db:
            java.lang.String r2 = "bool[]"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 1
            goto L_0x00f1
        L_0x00e5:
            java.lang.String r2 = "stringList"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f0
            r0 = 17
            goto L_0x00f1
        L_0x00f0:
            r0 = -1
        L_0x00f1:
            java.lang.String r2 = "value"
            switch(r0) {
                case 0: goto L_0x02b4;
                case 1: goto L_0x0298;
                case 2: goto L_0x028d;
                case 3: goto L_0x0270;
                case 4: goto L_0x0265;
                case 5: goto L_0x0248;
                case 6: goto L_0x023d;
                case 7: goto L_0x0220;
                case 8: goto L_0x0215;
                case 9: goto L_0x01f8;
                case 10: goto L_0x01ec;
                case 11: goto L_0x01ce;
                case 12: goto L_0x01c3;
                case 13: goto L_0x01a6;
                case 14: goto L_0x018f;
                case 15: goto L_0x0165;
                case 16: goto L_0x015a;
                case 17: goto L_0x0132;
                case 18: goto L_0x00f8;
                default: goto L_0x00f6;
            }
        L_0x00f6:
            goto L_0x02bd
        L_0x00f8:
            java.lang.String r0 = "enumType"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            java.lang.Enum r0 = java.lang.Enum.valueOf(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            android.os.Bundle r1 = r7.memory     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            r1.putSerializable(r8, r0)     // Catch:{ ClassNotFoundException -> 0x0113, IllegalArgumentException -> 0x0111 }
            goto L_0x02bd
        L_0x0111:
            r0 = move-exception
            goto L_0x0114
        L_0x0113:
            r0 = move-exception
        L_0x0114:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SharedPreferences.deserializeKey: Error deserializing key '"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = "' -- "
            r1.append(r8)
            r1.append(r0)
            java.lang.String r8 = r1.toString()
            com.kakao.util.helper.log.Logger.e(r8)
            goto L_0x02bd
        L_0x0132:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
        L_0x013f:
            if (r4 >= r1) goto L_0x0153
            java.lang.Object r3 = r0.get(r4)
            java.lang.Object r5 = org.json.JSONObject.NULL
            if (r3 != r5) goto L_0x014b
            r3 = 0
            goto L_0x014d
        L_0x014b:
            java.lang.String r3 = (java.lang.String) r3
        L_0x014d:
            r2.add(r4, r3)
            int r4 = r4 + 1
            goto L_0x013f
        L_0x0153:
            android.os.Bundle r0 = r7.memory
            r0.putStringArrayList(r8, r2)
            goto L_0x02bd
        L_0x015a:
            android.os.Bundle r0 = r7.memory
            java.lang.String r1 = r1.getString(r2)
            r0.putString(r8, r1)
            goto L_0x02bd
        L_0x0165:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            char[] r1 = new char[r1]
            r2 = 0
        L_0x0170:
            int r5 = r1.length
            if (r2 >= r5) goto L_0x0188
            java.lang.String r5 = r0.getString(r2)
            if (r5 == 0) goto L_0x0185
            int r6 = r5.length()
            if (r6 != r3) goto L_0x0185
            char r5 = r5.charAt(r4)
            r1[r2] = r5
        L_0x0185:
            int r2 = r2 + 1
            goto L_0x0170
        L_0x0188:
            android.os.Bundle r0 = r7.memory
            r0.putCharArray(r8, r1)
            goto L_0x02bd
        L_0x018f:
            java.lang.String r0 = r1.getString(r2)
            if (r0 == 0) goto L_0x02bd
            int r1 = r0.length()
            if (r1 != r3) goto L_0x02bd
            android.os.Bundle r1 = r7.memory
            char r0 = r0.charAt(r4)
            r1.putChar(r8, r0)
            goto L_0x02bd
        L_0x01a6:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            double[] r1 = new double[r1]
        L_0x01b0:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x01bc
            double r2 = r0.getDouble(r4)
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x01b0
        L_0x01bc:
            android.os.Bundle r0 = r7.memory
            r0.putDoubleArray(r8, r1)
            goto L_0x02bd
        L_0x01c3:
            android.os.Bundle r0 = r7.memory
            double r1 = r1.getDouble(r2)
            r0.putDouble(r8, r1)
            goto L_0x02bd
        L_0x01ce:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            float[] r1 = new float[r1]
        L_0x01d8:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x01e5
            double r2 = r0.getDouble(r4)
            float r2 = (float) r2
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x01d8
        L_0x01e5:
            android.os.Bundle r0 = r7.memory
            r0.putFloatArray(r8, r1)
            goto L_0x02bd
        L_0x01ec:
            android.os.Bundle r0 = r7.memory
            double r1 = r1.getDouble(r2)
            float r1 = (float) r1
            r0.putFloat(r8, r1)
            goto L_0x02bd
        L_0x01f8:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            long[] r1 = new long[r1]
        L_0x0202:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x020e
            long r2 = r0.getLong(r4)
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x0202
        L_0x020e:
            android.os.Bundle r0 = r7.memory
            r0.putLongArray(r8, r1)
            goto L_0x02bd
        L_0x0215:
            android.os.Bundle r0 = r7.memory
            long r1 = r1.getLong(r2)
            r0.putLong(r8, r1)
            goto L_0x02bd
        L_0x0220:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            int[] r1 = new int[r1]
        L_0x022a:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x0236
            int r2 = r0.getInt(r4)
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x022a
        L_0x0236:
            android.os.Bundle r0 = r7.memory
            r0.putIntArray(r8, r1)
            goto L_0x02bd
        L_0x023d:
            android.os.Bundle r0 = r7.memory
            int r1 = r1.getInt(r2)
            r0.putInt(r8, r1)
            goto L_0x02bd
        L_0x0248:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            short[] r1 = new short[r1]
        L_0x0252:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x025f
            int r2 = r0.getInt(r4)
            short r2 = (short) r2
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x0252
        L_0x025f:
            android.os.Bundle r0 = r7.memory
            r0.putShortArray(r8, r1)
            goto L_0x02bd
        L_0x0265:
            android.os.Bundle r0 = r7.memory
            int r1 = r1.getInt(r2)
            short r1 = (short) r1
            r0.putShort(r8, r1)
            goto L_0x02bd
        L_0x0270:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            byte[] r1 = new byte[r1]
        L_0x027a:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x0287
            int r2 = r0.getInt(r4)
            byte r2 = (byte) r2
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x027a
        L_0x0287:
            android.os.Bundle r0 = r7.memory
            r0.putByteArray(r8, r1)
            goto L_0x02bd
        L_0x028d:
            android.os.Bundle r0 = r7.memory
            int r1 = r1.getInt(r2)
            byte r1 = (byte) r1
            r0.putByte(r8, r1)
            goto L_0x02bd
        L_0x0298:
            org.json.JSONArray r0 = r1.getJSONArray(r2)
            int r1 = r0.length()
            boolean[] r1 = new boolean[r1]
        L_0x02a2:
            int r2 = r1.length
            if (r4 >= r2) goto L_0x02ae
            boolean r2 = r0.getBoolean(r4)
            r1[r4] = r2
            int r4 = r4 + 1
            goto L_0x02a2
        L_0x02ae:
            android.os.Bundle r0 = r7.memory
            r0.putBooleanArray(r8, r1)
            goto L_0x02bd
        L_0x02b4:
            android.os.Bundle r0 = r7.memory
            boolean r1 = r1.getBoolean(r2)
            r0.putBoolean(r8, r1)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.util.helper.SharedPreferencesCache.deserializeKey(java.lang.String):void");
    }
}
