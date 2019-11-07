package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ComponentDiscovery<T> {
    private final T context;
    private final RegistrarNameRetriever<T> retriever;

    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
        private MetadataRegistrarNameRetriever() {
        }

        public List<String> retrieve(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : metadata.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(metadata.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private static Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    return null;
                }
                return serviceInfo.metaData;
            } catch (NameNotFoundException unused) {
                return null;
            }
        }
    }

    @VisibleForTesting
    interface RegistrarNameRetriever<T> {
        List<String> retrieve(T t);
    }

    public static ComponentDiscovery<Context> forContext(Context context2) {
        return new ComponentDiscovery<>(context2, new MetadataRegistrarNameRetriever());
    }

    @VisibleForTesting
    ComponentDiscovery(T t, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.context = t;
        this.retriever = registrarNameRetriever;
    }

    public List<ComponentRegistrar> discover() {
        return instantiate(this.retriever.retrieve(this.context));
    }

    private static List<ComponentRegistrar> instantiate(List<String> list) {
        String str = "Could not instantiate %s";
        String str2 = "Could not instantiate %s.";
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            try {
                Class cls = Class.forName(str3);
                if (!ComponentRegistrar.class.isAssignableFrom(cls)) {
                    String.format("Class %s is not an instance of %s", new Object[]{str3, "com.google.firebase.components.ComponentRegistrar"});
                } else {
                    arrayList.add((ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not an found.", new Object[]{str3});
            } catch (IllegalAccessException unused2) {
                String.format(str2, new Object[]{str3});
            } catch (InstantiationException unused3) {
                String.format(str2, new Object[]{str3});
            } catch (NoSuchMethodException unused4) {
                String.format(str, new Object[]{str3});
            } catch (InvocationTargetException unused5) {
                String.format(str, new Object[]{str3});
            }
        }
        return arrayList;
    }
}
