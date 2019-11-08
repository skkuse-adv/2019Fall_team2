package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.List;

class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
        this.apiKey = str3;
    }

    public boolean send(List<File> list) {
        HttpRequest header = getHttpRequest().header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android").header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion()).header(AbstractSpiCall.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(FILE_PARAM_NAME);
            sb.append(i);
            header.part(sb.toString(), file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        Logger logger = Fabric.getLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending ");
        sb2.append(list.size());
        sb2.append(" analytics files to ");
        sb2.append(getUrl());
        String sb3 = sb2.toString();
        String str = Answers.TAG;
        logger.d(str, sb3);
        int code = header.code();
        Logger logger2 = Fabric.getLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Response code for analytics file send is ");
        sb4.append(code);
        logger2.d(str, sb4.toString());
        if (ResponseParser.parse(code) == 0) {
            return true;
        }
        return false;
    }
}
