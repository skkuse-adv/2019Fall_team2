package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultAppMeasurementEventListenerRegistrar implements AppMeasurementEventListenerRegistrar {
    private static final String ANALYTIC_CLASS = "com.google.android.gms.measurement.AppMeasurement";
    private static final String ANALYTIC_CLASS_ON_EVENT_LISTENER = "com.google.android.gms.measurement.AppMeasurement$OnEventListener";
    private static final String CRASH_ORIGIN = "crash";
    private static final String ERROR_PREFIX = "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: ";
    private static final String GET_INSTANCE_METHOD = "getInstance";
    private static final String METHOD_EQUALS = "equals";
    private static final String METHOD_HASHCODE = "hashCode";
    private static final String METHOD_ONEVENT = "onEvent";
    private static final String METHOD_TOSTRING = "toString";
    private static final String NAME = "name";
    private static final List<Class<?>> ONEVENT_EXPECTED_ARGTYPES = Collections.unmodifiableList(Arrays.asList(new Class[]{String.class, String.class, Bundle.class, Long.class}));
    private static final String PARAMETERS = "parameters";
    private static final String REGISTER_METHOD = "registerOnMeasurementEventListener";
    /* access modifiers changed from: private */
    public final CrashlyticsCore crashlyticsCore;
    private Object eventListenerProxy;

    public DefaultAppMeasurementEventListenerRegistrar(CrashlyticsCore crashlyticsCore2) {
        this.crashlyticsCore = crashlyticsCore2;
    }

    public boolean register() {
        Class cls = getClass(ANALYTIC_CLASS);
        String str = CrashlyticsCore.TAG;
        if (cls == null) {
            Fabric.getLogger().d(str, "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        Object instance = getInstance(cls);
        if (instance == null) {
            Fabric.getLogger().w(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not create an instance of Firebase Analytics.");
            return false;
        }
        Class cls2 = getClass(ANALYTIC_CLASS_ON_EVENT_LISTENER);
        if (cls2 == null) {
            Fabric.getLogger().w(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not get class com.google.android.gms.measurement.AppMeasurement$OnEventListener");
            return false;
        }
        try {
            cls.getDeclaredMethod(REGISTER_METHOD, new Class[]{cls2}).invoke(instance, new Object[]{getOnEventListenerProxy(cls2)});
        } catch (NoSuchMethodException e) {
            Fabric.getLogger().w(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Method registerOnMeasurementEventListener not found.", e);
            return false;
        } catch (Exception e2) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append(ERROR_PREFIX);
            sb.append(e2.getMessage());
            logger.w(str, sb.toString(), e2);
        }
        return true;
    }

    private Class<?> getClass(String str) {
        try {
            return this.crashlyticsCore.getContext().getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object getInstance(Class<?> cls) {
        try {
            return cls.getDeclaredMethod(GET_INSTANCE_METHOD, new Class[]{Context.class}).invoke(cls, new Object[]{this.crashlyticsCore.getContext()});
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized Object getOnEventListenerProxy(Class cls) {
        if (this.eventListenerProxy == null) {
            this.eventListenerProxy = Proxy.newProxyInstance(this.crashlyticsCore.getContext().getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    String name = method.getName();
                    if (objArr.length == 1 && name.equals(DefaultAppMeasurementEventListenerRegistrar.METHOD_EQUALS)) {
                        return Boolean.valueOf(equalsImpl(obj, objArr[0]));
                    }
                    if (objArr.length == 0 && name.equals(DefaultAppMeasurementEventListenerRegistrar.METHOD_HASHCODE)) {
                        return Integer.valueOf(super.hashCode());
                    }
                    if (objArr.length == 0 && name.equals(DefaultAppMeasurementEventListenerRegistrar.METHOD_TOSTRING)) {
                        return super.toString();
                    }
                    if (objArr.length == 4 && name.equals(DefaultAppMeasurementEventListenerRegistrar.METHOD_ONEVENT) && DefaultAppMeasurementEventListenerRegistrar.validateOnEventArgTypes(objArr)) {
                        String str = objArr[0];
                        String str2 = objArr[1];
                        Bundle bundle = objArr[2];
                        if (str != null && !str.equals("crash")) {
                            DefaultAppMeasurementEventListenerRegistrar.writeEventToUserLog(DefaultAppMeasurementEventListenerRegistrar.this.crashlyticsCore, str2, bundle);
                            return null;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected method invoked on AppMeasurement.EventListener: ");
                    sb.append(name);
                    sb.append("(");
                    StringBuilder sb2 = new StringBuilder(sb.toString());
                    for (int i = 0; i < objArr.length; i++) {
                        if (i > 0) {
                            sb2.append(", ");
                        }
                        sb2.append(objArr[0].getClass().getName());
                    }
                    sb2.append("); returning null");
                    Fabric.getLogger().e(CrashlyticsCore.TAG, sb2.toString());
                    return null;
                }

                public boolean equalsImpl(Object obj, Object obj2) {
                    boolean z = true;
                    if (obj == obj2) {
                        return true;
                    }
                    if (obj2 == null || !Proxy.isProxyClass(obj2.getClass()) || !super.equals(Proxy.getInvocationHandler(obj2))) {
                        z = false;
                    }
                    return z;
                }
            });
        }
        return this.eventListenerProxy;
    }

    static boolean validateOnEventArgTypes(Object[] objArr) {
        if (objArr.length != ONEVENT_EXPECTED_ARGTYPES.size()) {
            return false;
        }
        Iterator it = ONEVENT_EXPECTED_ARGTYPES.iterator();
        for (Object obj : objArr) {
            if (!obj.getClass().equals(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void writeEventToUserLog(CrashlyticsCore crashlyticsCore2, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("$A$:");
            sb.append(serializeEvent(str, bundle));
            crashlyticsCore2.log(sb.toString());
        } catch (JSONException unused) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to serialize Firebase Analytics event; ");
            sb2.append(str);
            logger.w(CrashlyticsCore.TAG, sb2.toString());
        }
    }

    private static String serializeEvent(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
