package com.google.android.gms.internal.firebase_remote_config;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzen {
    /* access modifiers changed from: private */
    public static final Date zzkp = new Date(0);
    private JSONObject zzkq;
    private JSONObject zzkr;
    private Date zzks;
    private JSONArray zzkt;

    private zzen(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.zzkr = jSONObject;
        this.zzks = date;
        this.zzkt = jSONArray;
        this.zzkq = jSONObject2;
    }

    static zzen zza(JSONObject jSONObject) throws JSONException {
        return new zzen(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    public final JSONObject zzcq() {
        return this.zzkr;
    }

    public final Date zzcr() {
        return this.zzks;
    }

    public final JSONArray zzcs() {
        return this.zzkt;
    }

    public final String toString() {
        return this.zzkq.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzen)) {
            return false;
        }
        return this.zzkq.toString().equals(((zzen) obj).toString());
    }

    public final int hashCode() {
        return this.zzkq.hashCode();
    }

    public static zzep zzct() {
        return new zzep();
    }
}
