package com.kakao.network.response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseBody {
    private JSONObject json;
    private int statusCode;

    public static class ResponseBodyException extends RuntimeException {
        private static final long serialVersionUID = 8171429617556607125L;

        public ResponseBodyException() {
        }

        public ResponseBodyException(String str) {
            super(str);
        }

        public ResponseBodyException(Exception exc) {
            super(exc);
        }
    }

    @Deprecated
    public int getStatusCode() {
        return this.statusCode;
    }

    public JSONObject getBody() {
        return this.json;
    }

    @Deprecated
    public ResponseBody(ResponseData responseData) throws ResponseBodyException {
        this(responseData.getHttpStatusCode(), responseData.getData());
    }

    @Deprecated
    public ResponseBody(int i, byte[] bArr) throws ResponseBodyException {
        this.json = null;
        this.statusCode = i;
        if (bArr == null) {
            throw new ResponseBodyException("Response body is null.");
        } else if (bArr.length != 0) {
            try {
                this.json = new JSONObject(new String(bArr));
            } catch (JSONException e) {
                throw new ResponseBodyException((Exception) e);
            }
        }
    }

    @Deprecated
    public ResponseBody(int i, JSONObject jSONObject) throws ResponseBodyException {
        this.json = null;
        this.statusCode = i;
        if (jSONObject != null) {
            this.json = jSONObject;
            return;
        }
        throw new ResponseBodyException();
    }

    public ResponseBody(JSONObject jSONObject) throws ResponseBodyException {
        this.json = null;
        if (jSONObject != null) {
            this.json = jSONObject;
            return;
        }
        throw new ResponseBodyException();
    }

    public ResponseBody(String str) throws ResponseBodyException {
        this.json = null;
        try {
            this.json = new JSONObject(str);
        } catch (JSONException e) {
            throw new ResponseBodyException((Exception) e);
        }
    }

    private Object getOrThrow(String str) {
        Object obj;
        try {
            obj = this.json.get(str);
        } catch (JSONException unused) {
            obj = null;
        }
        if (obj == null) {
            throw new NoSuchElementException(str);
        } else if (obj == JSONObject.NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public long getLong(String str) throws ResponseBodyException {
        try {
            Object orThrow = getOrThrow(str);
            if (orThrow instanceof Integer) {
                return (long) ((Integer) orThrow).intValue();
            }
            if (orThrow instanceof Long) {
                return ((Long) orThrow).longValue();
            }
            throw new ResponseBodyException();
        } catch (ResponseBodyException e) {
            throw e;
        } catch (Exception e2) {
            throw new ResponseBodyException(e2);
        }
    }

    public int getInt(String str) throws ResponseBodyException {
        try {
            return ((Integer) getOrThrow(str)).intValue();
        } catch (Exception e) {
            throw new ResponseBodyException(e);
        }
    }

    public boolean has(String str) {
        return this.json.has(str);
    }

    public int optInt(String str, int i) {
        if (has(str)) {
            try {
                return getInt(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return i;
    }

    public String getString(String str) throws ResponseBodyException {
        try {
            return (String) getOrThrow(str);
        } catch (Exception e) {
            throw new ResponseBodyException(e);
        }
    }

    public String optString(String str, String str2) {
        if (has(str)) {
            try {
                return getString(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return str2;
    }

    public boolean getBoolean(String str) throws ResponseBodyException {
        try {
            return ((Boolean) getOrThrow(str)).booleanValue();
        } catch (Exception e) {
            throw new ResponseBodyException(e);
        }
    }

    @Deprecated
    public ResponseBodyArray getArray(String str) throws ResponseBodyException {
        try {
            return new ResponseBodyArray((JSONArray) getOrThrow(str));
        } catch (ResponseBodyException e) {
            throw e;
        } catch (Exception e2) {
            throw new ResponseBodyException(e2);
        }
    }

    @Deprecated
    public ResponseBodyArray optArray(String str, ResponseBodyArray responseBodyArray) {
        if (has(str)) {
            try {
                return getArray(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return responseBodyArray;
    }

    public JSONArray getJSONArray(String str) throws ResponseBodyException {
        try {
            return (JSONArray) getOrThrow(str);
        } catch (ResponseBodyException e) {
            throw e;
        } catch (Exception e2) {
            throw new ResponseBodyException(e2);
        }
    }

    public JSONArray optJSONArray(String str, JSONArray jSONArray) {
        if (has(str)) {
            try {
                return getJSONArray(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return jSONArray;
    }

    public ResponseBody getBody(String str) throws ResponseBodyException {
        try {
            return new ResponseBody((JSONObject) getOrThrow(str));
        } catch (Exception e) {
            throw new ResponseBodyException(e);
        }
    }

    public ResponseBody optBody(String str, ResponseBody responseBody) {
        if (has(str)) {
            try {
                return getBody(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return responseBody;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public boolean optBoolean(String str, boolean z) {
        if (has(str)) {
            try {
                return getBoolean(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return z;
    }

    public long optLong(String str, long j) {
        if (has(str)) {
            try {
                return getLong(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return j;
    }

    public JSONObject getJSONObject(String str) {
        try {
            return (JSONObject) getOrThrow(str);
        } catch (ResponseBodyException e) {
            throw e;
        } catch (Exception e2) {
            throw new ResponseBodyException(e2);
        }
    }

    public JSONObject optJSONObject(String str, JSONObject jSONObject) {
        if (has(str)) {
            try {
                return getJSONObject(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return jSONObject;
    }

    public String toString() {
        return this.json.toString();
    }

    private Iterator<String> getKeys() {
        JSONObject jSONObject = this.json;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.keys();
    }

    public static <T> Map<String, T> toMap(ResponseBody responseBody) throws ResponseBodyException {
        HashMap hashMap = new HashMap();
        Iterator keys = responseBody.getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object orThrow = responseBody.getOrThrow(str);
            if (orThrow instanceof JSONArray) {
                orThrow = ResponseBodyArray.toList(new ResponseBodyArray((JSONArray) orThrow));
            } else if (orThrow instanceof JSONObject) {
                orThrow = toMap(new ResponseBody((JSONObject) orThrow));
            }
            hashMap.put(str, orThrow);
        }
        return hashMap;
    }
}
