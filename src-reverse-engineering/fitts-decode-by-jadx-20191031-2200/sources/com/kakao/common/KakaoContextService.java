package com.kakao.common;

import android.content.Context;
import com.kakao.common.IConfiguration.Factory;

public class KakaoContextService {
    private static KakaoContextService instance;
    private IConfiguration configuration;
    private PhaseInfo phaseInfo;

    public IConfiguration getAppConfiguration() {
        return this.configuration;
    }

    public void setPhaseInfo(PhaseInfo phaseInfo2) {
        if (phaseInfo2 != null) {
            this.phaseInfo = phaseInfo2;
        }
    }

    public PhaseInfo phaseInfo() {
        return this.phaseInfo;
    }

    public synchronized void initialize(Context context) {
        if (this.configuration == null) {
            this.configuration = Factory.createConfiguration(context);
        }
        if (this.phaseInfo == null) {
            this.phaseInfo = new DefaultPhaseInfo(context);
        }
    }

    public synchronized void initialize(Context context, PhaseInfo phaseInfo2) {
        if (this.configuration == null) {
            this.configuration = Factory.createConfiguration(context);
        }
        this.phaseInfo = phaseInfo2;
    }

    public KakaoContextService(IConfiguration iConfiguration, PhaseInfo phaseInfo2) {
        this.configuration = iConfiguration;
        this.phaseInfo = phaseInfo2;
    }

    private KakaoContextService() {
    }

    public static synchronized KakaoContextService getInstance() {
        KakaoContextService kakaoContextService;
        synchronized (KakaoContextService.class) {
            if (instance == null) {
                instance = new KakaoContextService();
            }
            kakaoContextService = instance;
        }
        return kakaoContextService;
    }
}
