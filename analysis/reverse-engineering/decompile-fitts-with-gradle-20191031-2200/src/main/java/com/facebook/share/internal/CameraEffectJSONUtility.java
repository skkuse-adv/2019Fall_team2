package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectArguments.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraEffectJSONUtility {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnArgumentsBuilder(Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        SETTERS.put(String.class, new Setter() {
            public void setOnArgumentsBuilder(Builder builder, String str, Object obj) throws JSONException {
                builder.putArgument(str, (String) obj);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            public void setOnArgumentsBuilder(Builder builder, String str, Object obj) throws JSONException {
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
            public void setOnArgumentsBuilder(Builder builder, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                String[] strArr = new String[jSONArray.length()];
                int i = 0;
                while (i < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        strArr[i] = (String) obj2;
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected type in an array: ");
                        sb.append(obj2.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                builder.putArgument(str, strArr);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
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
        return jSONObject;
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                Setter setter = (Setter) SETTERS.get(obj.getClass());
                if (setter != null) {
                    setter.setOnArgumentsBuilder(builder, str, obj);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported type: ");
                    sb.append(obj.getClass());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        return builder.build();
    }
}
