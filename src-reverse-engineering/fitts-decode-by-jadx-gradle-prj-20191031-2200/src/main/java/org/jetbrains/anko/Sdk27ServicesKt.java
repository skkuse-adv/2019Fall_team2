package org.jetbrains.anko;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.usage.NetworkStatsManager;
import android.app.usage.StorageStatsManager;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothManager;
import android.companion.CompanionDeviceManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.ShortcutManager;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.midi.MidiManager;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.HardwarePropertiesManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.health.SystemHealthManager;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class Sdk27ServicesKt {
    @NotNull
    public static final AccessibilityManager getAccessibilityManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("accessibility");
        if (systemService != null) {
            return (AccessibilityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    @NotNull
    public static final AccountManager getAccountManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("account");
        if (systemService != null) {
            return (AccountManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.accounts.AccountManager");
    }

    @NotNull
    public static final ActivityManager getActivityManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return (ActivityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @NotNull
    public static final AlarmManager getAlarmManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            return (AlarmManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    @NotNull
    public static final AppOpsManager getAppOpsManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("appops");
        if (systemService != null) {
            return (AppOpsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.AppOpsManager");
    }

    @NotNull
    public static final AudioManager getAudioManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("audio");
        if (systemService != null) {
            return (AudioManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
    }

    @NotNull
    public static final BatteryManager getBatteryManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("batterymanager");
        if (systemService != null) {
            return (BatteryManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.BatteryManager");
    }

    @NotNull
    public static final BluetoothManager getBluetoothManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("bluetooth");
        if (systemService != null) {
            return (BluetoothManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    @NotNull
    public static final CameraManager getCameraManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("camera");
        if (systemService != null) {
            return (CameraManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    @NotNull
    public static final CaptioningManager getCaptioningManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("captioning");
        if (systemService != null) {
            return (CaptioningManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.accessibility.CaptioningManager");
    }

    @NotNull
    public static final CarrierConfigManager getCarrierConfigManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("carrier_config");
        if (systemService != null) {
            return (CarrierConfigManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.CarrierConfigManager");
    }

    @NotNull
    public static final ClipboardManager getClipboardManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            return (ClipboardManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    @NotNull
    public static final CompanionDeviceManager getCompanionDeviceManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("companiondevice");
        if (systemService != null) {
            return (CompanionDeviceManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.companion.CompanionDeviceManager");
    }

    @NotNull
    public static final ConnectivityManager getConnectivityManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return (ConnectivityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @NotNull
    public static final ConsumerIrManager getConsumerIrManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("consumer_ir");
        if (systemService != null) {
            return (ConsumerIrManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.ConsumerIrManager");
    }

    @NotNull
    public static final DevicePolicyManager getDevicePolicyManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("device_policy");
        if (systemService != null) {
            return (DevicePolicyManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
    }

    @NotNull
    public static final DisplayManager getDisplayManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        if (systemService != null) {
            return (DisplayManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.display.DisplayManager");
    }

    @NotNull
    public static final DownloadManager getDownloadManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("download");
        if (systemService != null) {
            return (DownloadManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
    }

    @NotNull
    public static final FingerprintManager getFingerprintManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("fingerprint");
        if (systemService != null) {
            return (FingerprintManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager");
    }

    @NotNull
    public static final HardwarePropertiesManager getHardwarePropertiesManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("hardware_properties");
        if (systemService != null) {
            return (HardwarePropertiesManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.HardwarePropertiesManager");
    }

    @NotNull
    public static final InputManager getInputManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("input");
        if (systemService != null) {
            return (InputManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.input.InputManager");
    }

    @NotNull
    public static final InputMethodManager getInputMethodManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            return (InputMethodManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @NotNull
    public static final KeyguardManager getKeyguardManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null) {
            return (KeyguardManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.KeyguardManager");
    }

    @NotNull
    public static final LocationManager getLocationManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService(MessageTemplateProtocol.TYPE_LOCATION);
        if (systemService != null) {
            return (LocationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    @NotNull
    public static final MediaProjectionManager getMediaProjectionManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("media_projection");
        if (systemService != null) {
            return (MediaProjectionManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
    }

    @NotNull
    public static final MediaSessionManager getMediaSessionManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("media_session");
        if (systemService != null) {
            return (MediaSessionManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.session.MediaSessionManager");
    }

    @NotNull
    public static final MidiManager getMidiManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("midi");
        if (systemService != null) {
            return (MidiManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.midi.MidiManager");
    }

    @NotNull
    public static final NetworkStatsManager getNetworkStatsManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("netstats");
        if (systemService != null) {
            return (NetworkStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.NetworkStatsManager");
    }

    @NotNull
    public static final NfcManager getNfcManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("nfc");
        if (systemService != null) {
            return (NfcManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.nfc.NfcManager");
    }

    @NotNull
    public static final NotificationManager getNotificationManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            return (NotificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    @NotNull
    public static final NsdManager getNsdManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("servicediscovery");
        if (systemService != null) {
            return (NsdManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.nsd.NsdManager");
    }

    @NotNull
    public static final PowerManager getPowerManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("power");
        if (systemService != null) {
            return (PowerManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.PowerManager");
    }

    @NotNull
    public static final PrintManager getPrintManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("print");
        if (systemService != null) {
            return (PrintManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.print.PrintManager");
    }

    @NotNull
    public static final RestrictionsManager getRestrictionsManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("restrictions");
        if (systemService != null) {
            return (RestrictionsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.RestrictionsManager");
    }

    @NotNull
    public static final SearchManager getSearchManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("search");
        if (systemService != null) {
            return (SearchManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.SearchManager");
    }

    @NotNull
    public static final SensorManager getSensorManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            return (SensorManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    @NotNull
    public static final ShortcutManager getShortcutManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("shortcut");
        if (systemService != null) {
            return (ShortcutManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
    }

    @NotNull
    public static final StorageManager getStorageManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("storage");
        if (systemService != null) {
            return (StorageManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.storage.StorageManager");
    }

    @NotNull
    public static final StorageStatsManager getStorageStatsManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("storagestats");
        if (systemService != null) {
            return (StorageStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.StorageStatsManager");
    }

    @NotNull
    public static final SystemHealthManager getSystemHealthManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("systemhealth");
        if (systemService != null) {
            return (SystemHealthManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.health.SystemHealthManager");
    }

    @NotNull
    public static final TelecomManager getTelecomManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("telecom");
        if (systemService != null) {
            return (TelecomManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telecom.TelecomManager");
    }

    @NotNull
    public static final TelephonyManager getTelephonyManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("phone");
        if (systemService != null) {
            return (TelephonyManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @NotNull
    public static final TextClassificationManager getTextClassificationManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("textclassification");
        if (systemService != null) {
            return (TextClassificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.textclassifier.TextClassificationManager");
    }

    @NotNull
    public static final TvInputManager getTvInputManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("tv_input");
        if (systemService != null) {
            return (TvInputManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.tv.TvInputManager");
    }

    @NotNull
    public static final UiModeManager getUiModeManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("uimode");
        if (systemService != null) {
            return (UiModeManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.UiModeManager");
    }

    @NotNull
    public static final UsageStatsManager getUsageStatsManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("usagestats");
        if (systemService != null) {
            return (UsageStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.UsageStatsManager");
    }

    @NotNull
    public static final UsbManager getUsbManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("usb");
        if (systemService != null) {
            return (UsbManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.usb.UsbManager");
    }

    @NotNull
    public static final UserManager getUserManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("user");
        if (systemService != null) {
            return (UserManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.UserManager");
    }

    @NotNull
    public static final WallpaperManager getWallpaperManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("wallpaper");
        if (systemService != null) {
            return (WallpaperManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.WallpaperManager");
    }

    @NotNull
    public static final WifiAwareManager getWifiAwareManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("wifiaware");
        if (systemService != null) {
            return (WifiAwareManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.aware.WifiAwareManager");
    }

    @NotNull
    public static final WifiManager getWifiManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("wifi");
        if (systemService != null) {
            return (WifiManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    @NotNull
    public static final WifiP2pManager getWifiP2pManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("wifip2p");
        if (systemService != null) {
            return (WifiP2pManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
    }

    @NotNull
    public static final WindowManager getWindowManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
