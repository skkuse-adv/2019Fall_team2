package com.facebook.appevents.codeless.internal;

public class UnityReflection {
    private static Class<?> unityPlayer;

    public static void sendMessage(String str, String str2, String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            unityPlayer.getMethod("UnitySendMessage", new Class[]{String.class, String.class, String.class}).invoke(unityPlayer, new Object[]{str, str2, str3});
        } catch (Exception unused) {
        }
    }

    public static void captureViewHierarchy() {
        sendMessage("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    public static void sendEventMapping(String str) {
        sendMessage("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }
}
