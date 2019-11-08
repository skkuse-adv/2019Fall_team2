package io.victoralbertos.jolyglot;

import com.google.gson.Gson;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GsonSpeaker implements JolyglotGenerics {
    private final Gson gson;

    public GsonSpeaker(Gson gson2) {
        this.gson = gson2;
    }

    public GsonSpeaker() {
        this.gson = new Gson();
    }

    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }

    public String toJson(Object obj, Type type) {
        return this.gson.toJson(obj, type);
    }

    public <T> T fromJson(String str, Class<T> cls) throws RuntimeException {
        return this.gson.fromJson(str, cls);
    }

    public <T> T fromJson(String str, Type type) throws RuntimeException {
        return this.gson.fromJson(str, type);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[SYNTHETIC, Splitter:B:19:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T fromJson(java.io.File r4, java.lang.Class<T> r5) throws java.lang.RuntimeException {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0024 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x0024 }
            java.io.File r4 = r4.getAbsoluteFile()     // Catch:{ IOException -> 0x0024 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0024 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0024 }
            com.google.gson.Gson r4 = r3.gson     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.Object r4 = r4.fromJson(r1, r5)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            return r4
        L_0x001c:
            r4 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x001f:
            r4 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            goto L_0x002b
        L_0x0024:
            r4 = move-exception
        L_0x0025:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x0022 }
            r5.<init>(r4)     // Catch:{ all -> 0x0022 }
            throw r5     // Catch:{ all -> 0x0022 }
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.victoralbertos.jolyglot.GsonSpeaker.fromJson(java.io.File, java.lang.Class):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[SYNTHETIC, Splitter:B:19:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T fromJson(java.io.File r4, java.lang.reflect.Type r5) throws java.lang.RuntimeException {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0024 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x0024 }
            java.io.File r4 = r4.getAbsoluteFile()     // Catch:{ IOException -> 0x0024 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0024 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0024 }
            com.google.gson.Gson r4 = r3.gson     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.Object r4 = r4.fromJson(r1, r5)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            return r4
        L_0x001c:
            r4 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x001f:
            r4 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            goto L_0x002b
        L_0x0024:
            r4 = move-exception
        L_0x0025:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x0022 }
            r5.<init>(r4)     // Catch:{ all -> 0x0022 }
            throw r5     // Catch:{ all -> 0x0022 }
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.victoralbertos.jolyglot.GsonSpeaker.fromJson(java.io.File, java.lang.reflect.Type):java.lang.Object");
    }

    public GenericArrayType arrayOf(Type type) {
        return Types.arrayOf(type);
    }

    public ParameterizedType newParameterizedType(Type type, Type... typeArr) {
        return Types.newParameterizedType(type, typeArr);
    }
}
