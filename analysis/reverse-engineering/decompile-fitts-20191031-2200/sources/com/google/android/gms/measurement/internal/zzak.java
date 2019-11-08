package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzct;
import com.google.android.gms.internal.measurement.zzjn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class zzak {
    static zzr zzfv;
    /* access modifiers changed from: private */
    public static List<zzdu<?>> zzfw = Collections.synchronizedList(new ArrayList());
    private static Boolean zzfz;
    public static zzdu<Boolean> zzgd;
    public static zzdu<Boolean> zzge;
    public static zzdu<String> zzgf = zza("measurement.log_tag", "FA", "FA-SVC", zzce.zzji);
    public static zzdu<Long> zzgg;
    public static zzdu<Long> zzgh;
    public static zzdu<Long> zzgi;
    public static zzdu<String> zzgj;
    public static zzdu<String> zzgk;
    public static zzdu<Integer> zzgl;
    public static zzdu<Integer> zzgm;
    public static zzdu<Integer> zzgn;
    public static zzdu<Integer> zzgo;
    public static zzdu<Integer> zzgp;
    public static zzdu<Integer> zzgq;
    public static zzdu<Integer> zzgr;
    public static zzdu<Integer> zzgs;
    public static zzdu<Integer> zzgt;
    public static zzdu<Integer> zzgu;
    public static zzdu<String> zzgv;
    public static zzdu<Long> zzgw;
    public static zzdu<Long> zzgx;
    public static zzdu<Long> zzgy;
    public static zzdu<Long> zzgz;
    public static zzdu<Long> zzha;
    public static zzdu<Long> zzhb;
    public static zzdu<Long> zzhc;
    public static zzdu<Long> zzhd;
    public static zzdu<Long> zzhe;
    public static zzdu<Long> zzhf;
    public static zzdu<Long> zzhg;
    public static zzdu<Integer> zzhh;
    public static zzdu<Long> zzhi;
    public static zzdu<Integer> zzhj;
    public static zzdu<Integer> zzhk;
    public static zzdu<Long> zzhl;
    public static zzdu<Boolean> zzhm;
    public static zzdu<String> zzhn;
    public static zzdu<Long> zzho;
    public static zzdu<Integer> zzhp;
    public static zzdu<Double> zzhq;
    public static zzdu<Integer> zzhr;
    public static zzdu<Boolean> zzhs;
    public static zzdu<Boolean> zzht;
    public static zzdu<Boolean> zzhu;
    public static zzdu<Boolean> zzhv;
    public static zzdu<Boolean> zzhw;
    public static zzdu<Boolean> zzhx;
    public static zzdu<Boolean> zzhy;
    public static zzdu<Boolean> zzhz;
    public static zzdu<Boolean> zzia;
    public static zzdu<Boolean> zzib;
    public static zzdu<Boolean> zzic;
    public static zzdu<Boolean> zzid;
    public static zzdu<Boolean> zzie;
    public static zzdu<Boolean> zzif;
    public static zzdu<Boolean> zzig;
    public static zzdu<Boolean> zzih;
    public static zzdu<Boolean> zzii;
    public static zzdu<Boolean> zzij;
    public static zzdu<Boolean> zzik;
    public static zzdu<Boolean> zzil;
    public static zzdu<Boolean> zzim;
    public static zzdu<Boolean> zzin;
    public static zzdu<Boolean> zzio;
    public static zzdu<Boolean> zzip;
    public static zzdu<Boolean> zziq;
    public static zzdu<Boolean> zzis;
    public static zzdu<Boolean> zzit;
    public static zzdu<Boolean> zziu;
    public static zzdu<Boolean> zziv;
    public static zzdu<Boolean> zziw;
    public static zzdu<Boolean> zzix;
    public static zzdu<Boolean> zziy;
    public static zzdu<Boolean> zziz;
    private static volatile zzfj zzj;
    public static zzdu<Boolean> zzja;
    public static zzdu<Boolean> zzjb;
    public static zzdu<Boolean> zzjc;
    public static zzdu<Boolean> zzjd;
    public static zzdu<Boolean> zzje;
    public static zzdu<Boolean> zzjg;
    public static zzdu<Boolean> zzjh;

    public static Map<String, String> zzk(Context context) {
        zzca zza = zzca.zza(context.getContentResolver(), zzcn.zzdh("com.google.android.gms.measurement"));
        return zza == null ? Collections.emptyMap() : zza.zzre();
    }

    static void zza(zzfj zzfj) {
        zzj = zzfj;
    }

    static void zza(Exception exc) {
        if (zzj != null) {
            Context context = zzj.getContext();
            if (zzfz == null) {
                zzfz = Boolean.valueOf(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
            }
            if (zzfz.booleanValue()) {
                zzj.zzab().zzgk().zza("Got Exception on PhenotypeFlag.get on Play device", exc);
            }
        }
    }

    private static <V> zzdu<V> zza(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable zzdv<V> zzdv) {
        zzdu zzdu = new zzdu(str, v, v2, zzdv);
        zzfw.add(zzdu);
        return zzdu;
    }

    static void zza(zzr zzr) {
        zzfv = zzr;
    }

    private static boolean isPackageSide() {
        if (zzfv != null) {
        }
        return false;
    }

    static final /* synthetic */ Long zzfu() {
        long j;
        if (isPackageSide()) {
            j = zzjn.zzyc();
        } else {
            j = zzjn.zzxo();
        }
        return Long.valueOf(j);
    }

    static final /* synthetic */ String zzfx() {
        return isPackageSide() ? zzjn.zzye() : zzjn.zzxp();
    }

    static {
        Collections.synchronizedSet(new HashSet());
        new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        Boolean valueOf = Boolean.valueOf(false);
        zza("measurement.log_third_party_store_events_enabled", valueOf, valueOf, zzan.zzji);
        zza("measurement.log_installs_enabled", valueOf, valueOf, zzam.zzji);
        zza("measurement.log_upgrades_enabled", valueOf, valueOf, zzaz.zzji);
        zzgd = zza("measurement.log_androidId_enabled", valueOf, valueOf, zzbi.zzji);
        zzge = zza("measurement.upload_dsid_enabled", valueOf, valueOf, zzbv.zzji);
        Long valueOf2 = Long.valueOf(10000);
        zzgg = zza("measurement.ad_id_cache_time", valueOf2, valueOf2, zzcr.zzji);
        Long valueOf3 = Long.valueOf(86400000);
        zzgh = zza("measurement.monitoring.sample_period_millis", valueOf3, valueOf3, zzda.zzji);
        Long valueOf4 = Long.valueOf(3600000);
        zzgi = zza("measurement.config.cache_time", valueOf3, valueOf4, zzdn.zzji);
        String str = "https";
        zzgj = zza("measurement.config.url_scheme", str, str, zzdt.zzji);
        String str2 = "app-measurement.com";
        zzgk = zza("measurement.config.url_authority", str2, str2, zzap.zzji);
        Integer valueOf5 = Integer.valueOf(100);
        zzgl = zza("measurement.upload.max_bundles", valueOf5, valueOf5, zzao.zzji);
        Integer valueOf6 = Integer.valueOf(65536);
        zzgm = zza("measurement.upload.max_batch_size", valueOf6, valueOf6, zzar.zzji);
        zzgn = zza("measurement.upload.max_bundle_size", valueOf6, valueOf6, zzaq.zzji);
        Integer valueOf7 = Integer.valueOf(1000);
        zzgo = zza("measurement.upload.max_events_per_bundle", valueOf7, valueOf7, zzat.zzji);
        Integer valueOf8 = Integer.valueOf(100000);
        zzgp = zza("measurement.upload.max_events_per_day", valueOf8, valueOf8, zzas.zzji);
        zzgq = zza("measurement.upload.max_error_events_per_day", valueOf7, valueOf7, zzav.zzji);
        Integer valueOf9 = Integer.valueOf(50000);
        zzgr = zza("measurement.upload.max_public_events_per_day", valueOf9, valueOf9, zzau.zzji);
        Integer valueOf10 = Integer.valueOf(500);
        zzgs = zza("measurement.upload.max_conversions_per_day", valueOf10, valueOf10, zzax.zzji);
        Integer valueOf11 = Integer.valueOf(10);
        zzgt = zza("measurement.upload.max_realtime_events_per_day", valueOf11, valueOf11, zzaw.zzji);
        Integer valueOf12 = Integer.valueOf(100000);
        zzgu = zza("measurement.store.max_stored_events_per_app", valueOf12, valueOf12, zzay.zzji);
        String str3 = "https://app-measurement.com/a";
        zzgv = zza("measurement.upload.url", str3, str3, zzbb.zzji);
        Long valueOf13 = Long.valueOf(43200000);
        zzgw = zza("measurement.upload.backoff_period", valueOf13, valueOf13, zzba.zzji);
        zzgx = zza("measurement.upload.window_interval", valueOf4, valueOf4, zzbd.zzji);
        zzgy = zza("measurement.upload.interval", valueOf4, valueOf4, zzbc.zzji);
        zzgz = zza("measurement.upload.realtime_upload_interval", valueOf2, valueOf2, zzbf.zzji);
        Long valueOf14 = Long.valueOf(1000);
        zzha = zza("measurement.upload.debug_upload_interval", valueOf14, valueOf14, zzbe.zzji);
        Long valueOf15 = Long.valueOf(500);
        zzhb = zza("measurement.upload.minimum_delay", valueOf15, valueOf15, zzbh.zzji);
        Long valueOf16 = Long.valueOf(60000);
        zzhc = zza("measurement.alarm_manager.minimum_interval", valueOf16, valueOf16, zzbg.zzji);
        zzhd = zza("measurement.upload.stale_data_deletion_interval", valueOf3, valueOf3, zzbj.zzji);
        Long valueOf17 = Long.valueOf(604800000);
        zzhe = zza("measurement.upload.refresh_blacklisted_config_interval", valueOf17, valueOf17, zzbl.zzji);
        Long valueOf18 = Long.valueOf(15000);
        zzhf = zza("measurement.upload.initial_upload_delay_time", valueOf18, valueOf18, zzbk.zzji);
        Long valueOf19 = Long.valueOf(1800000);
        zzhg = zza("measurement.upload.retry_time", valueOf19, valueOf19, zzbn.zzji);
        Integer valueOf20 = Integer.valueOf(6);
        zzhh = zza("measurement.upload.retry_count", valueOf20, valueOf20, zzbm.zzji);
        Long valueOf21 = Long.valueOf(2419200000L);
        zzhi = zza("measurement.upload.max_queue_time", valueOf21, valueOf21, zzbp.zzji);
        Integer valueOf22 = Integer.valueOf(4);
        zzhj = zza("measurement.lifetimevalue.max_currency_tracked", valueOf22, valueOf22, zzbo.zzji);
        Integer valueOf23 = Integer.valueOf(Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzhk = zza("measurement.audience.filter_result_max_count", valueOf23, valueOf23, zzbr.zzji);
        Long valueOf24 = Long.valueOf(5000);
        zzhl = zza("measurement.service_client.idle_disconnect_millis", valueOf24, valueOf24, zzbq.zzji);
        zzhm = zza("measurement.test.boolean_flag", valueOf, valueOf, zzbt.zzji);
        String str4 = "---";
        zzhn = zza("measurement.test.string_flag", str4, str4, zzbs.zzji);
        Long valueOf25 = Long.valueOf(-1);
        zzho = zza("measurement.test.long_flag", valueOf25, valueOf25, zzbu.zzji);
        Integer valueOf26 = Integer.valueOf(-2);
        zzhp = zza("measurement.test.int_flag", valueOf26, valueOf26, zzbx.zzji);
        Double valueOf27 = Double.valueOf(-3.0d);
        zzhq = zza("measurement.test.double_flag", valueOf27, valueOf27, zzbw.zzji);
        Integer valueOf28 = Integer.valueOf(50);
        zzhr = zza("measurement.experiment.max_ids", valueOf28, valueOf28, zzbz.zzji);
        zzhs = zza("measurement.validation.internal_limits_internal_event_params", valueOf, valueOf, zzby.zzji);
        Boolean valueOf29 = Boolean.valueOf(true);
        zzht = zza("measurement.audience.dynamic_filters", valueOf29, valueOf29, zzcb.zzji);
        zzhu = zza("measurement.reset_analytics.persist_time", valueOf, valueOf, zzca.zzji);
        zzhv = zza("measurement.validation.value_and_currency_params", valueOf29, valueOf29, zzcd.zzji);
        zzhw = zza("measurement.sampling.time_zone_offset_enabled", valueOf, valueOf, zzcc.zzji);
        zzhx = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", valueOf, valueOf, zzcf.zzji);
        zzhy = zza("measurement.fetch_config_with_admob_app_id", valueOf29, valueOf29, zzch.zzji);
        zzhz = zza("measurement.client.sessions.session_id_enabled", valueOf, valueOf, zzcg.zzji);
        zzia = zza("measurement.service.sessions.session_number_enabled", valueOf, valueOf, zzcj.zzji);
        zzib = zza("measurement.client.sessions.immediate_start_enabled_foreground", valueOf, valueOf, zzci.zzji);
        zzic = zza("measurement.client.sessions.background_sessions_enabled", valueOf, valueOf, zzcl.zzji);
        zzid = zza("measurement.client.sessions.remove_expired_session_properties_enabled", valueOf, valueOf, zzck.zzji);
        zzie = zza("measurement.service.sessions.session_number_backfill_enabled", valueOf, valueOf, zzcn.zzji);
        zzif = zza("measurement.service.sessions.remove_disabled_session_number", valueOf, valueOf, zzcm.zzji);
        zzig = zza("measurement.collection.firebase_global_collection_flag_enabled", valueOf29, valueOf29, zzcp.zzji);
        zzih = zza("measurement.collection.efficient_engagement_reporting_enabled", valueOf, valueOf, zzco.zzji);
        zzii = zza("measurement.collection.redundant_engagement_removal_enabled", valueOf, valueOf, zzcq.zzji);
        zzij = zza("measurement.personalized_ads_signals_collection_enabled", valueOf29, valueOf29, zzct.zzji);
        zzik = zza("measurement.personalized_ads_property_translation_enabled", valueOf29, valueOf29, zzcs.zzji);
        zzil = zza("measurement.collection.init_params_control_enabled", valueOf29, valueOf29, zzcv.zzji);
        zzim = zza("measurement.upload.disable_is_uploader", valueOf29, valueOf29, zzcu.zzji);
        zzin = zza("measurement.experiment.enable_experiment_reporting", valueOf29, valueOf29, zzcx.zzji);
        zzio = zza("measurement.collection.log_event_and_bundle_v2", valueOf29, valueOf29, zzcw.zzji);
        zzip = zza("measurement.collection.null_empty_event_name_fix", valueOf29, valueOf29, zzcz.zzji);
        zziq = zza("measurement.audience.sequence_filters", valueOf, valueOf, zzcy.zzji);
        zza("measurement.audience.sequence_filters_bundle_timestamp", valueOf, valueOf, zzdb.zzji);
        zzis = zza("measurement.quality.checksum", valueOf, valueOf, null);
        zzit = zza("measurement.module.collection.conditionally_omit_admob_app_id", valueOf29, valueOf29, zzdd.zzji);
        zziu = zza("measurement.sdk.dynamite.use_dynamite2", valueOf, valueOf, zzdc.zzji);
        zziv = zza("measurement.sdk.dynamite.allow_remote_dynamite", valueOf, valueOf, zzdf.zzji);
        zziw = zza("measurement.sdk.collection.validate_param_names_alphabetical", valueOf, valueOf, zzde.zzji);
        zzix = zza("measurement.collection.event_safelist", valueOf, valueOf, zzdh.zzji);
        zziy = zza("measurement.service.audience.scoped_filters_v27", valueOf, valueOf, zzdg.zzji);
        zziz = zza("measurement.service.audience.session_scoped_event_aggregates", valueOf, valueOf, zzdj.zzji);
        zzja = zza("measurement.service.audience.session_scoped_user_engagement", valueOf, valueOf, zzdi.zzji);
        zzjb = zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", valueOf, valueOf, zzdl.zzji);
        zzjc = zza("measurement.sdk.collection.retrieve_deeplink_from_bow", valueOf, valueOf, zzdk.zzji);
        zzjd = zza("measurement.app_launch.event_ordering_fix", valueOf, valueOf, zzdm.zzji);
        zzje = zza("measurement.sdk.collection.last_deep_link_referrer", valueOf, valueOf, zzdp.zzji);
        zza("measurement.sdk.collection.last_deep_link_referrer_campaign", valueOf, valueOf, zzdo.zzji);
        zzjg = zza("measurement.sdk.collection.last_gclid_from_referrer", valueOf, valueOf, zzdr.zzji);
        zzjh = zza("measurement.upload.file_lock_state_check", valueOf, valueOf, zzdq.zzji);
    }
}
