package com.google.android.gms.internal.firebase_remote_config;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzep {
    private JSONObject zzkv;
    private Date zzkw;
    private JSONArray zzkx;

    private zzep() {
        this.zzkv = new JSONObject();
        this.zzkw = zzen.zzkp;
        this.zzkx = new JSONArray();
    }

    public final zzep zzd(Map<String, String> map) {
        this.zzkv = new JSONObject(map);
        return this;
    }

    public final zzep zza(Date date) {
        this.zzkw = date;
        return this;
    }

    public final zzep zzb(List<zzdd> list) {
        JSONArray jSONArray = new JSONArray();
        for (zzdd jSONObject : list) {
            jSONArray.put(new JSONObject(jSONObject));
        }
        this.zzkx = jSONArray;
        return this;
    }

    public final zzen zzcv() throws JSONException {
        return new zzen(this.zzkv, this.zzkw, this.zzkx);
    }
}
