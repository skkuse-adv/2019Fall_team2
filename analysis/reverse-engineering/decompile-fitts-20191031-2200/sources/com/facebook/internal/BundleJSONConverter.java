package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        SETTERS.put(Boolean.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Integer.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Long.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Double.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                while (i < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected type in an array: ");
                        sb.append(obj2.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static JSONObject convertToJSON(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnJSON(jSONObject, str, obj);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported type: ");
                        sb.append(obj.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(str, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnBundle(bundle, str, obj);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported type: ");
                        sb.append(obj.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return bundle;
    }
}
