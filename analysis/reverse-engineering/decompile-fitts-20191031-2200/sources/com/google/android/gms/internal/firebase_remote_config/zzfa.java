package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class zzfa {
    public static Map<String, String> zza(Context context, int i) {
        HashMap hashMap = new HashMap();
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                return hashMap;
            }
            XmlResourceParser xml = resources.getXml(i);
            if (xml == null) {
                return hashMap;
            }
            String str = null;
            Object obj = null;
            Object obj2 = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    str = xml.getName();
                } else if (eventType == 3) {
                    if (xml.getName().equals("entry")) {
                        if (!(obj == null || obj2 == null)) {
                            hashMap.put(obj, obj2);
                        }
                        obj = null;
                        obj2 = null;
                    }
                    str = null;
                } else if (eventType == 4 && str != null) {
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 106079) {
                        if (hashCode == 111972721) {
                            if (str.equals("value")) {
                                c = 1;
                            }
                        }
                    } else if (str.equals("key")) {
                        c = 0;
                    }
                    if (c == 0) {
                        obj = xml.getText();
                    } else if (c == 1) {
                        obj2 = xml.getText();
                    }
                }
            }
            return hashMap;
        } catch (IOException | XmlPullParserException unused) {
        }
    }
}
