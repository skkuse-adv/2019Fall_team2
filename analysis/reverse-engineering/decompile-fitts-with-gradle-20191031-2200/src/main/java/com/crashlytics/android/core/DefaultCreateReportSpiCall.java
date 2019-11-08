package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending report to: ");
        sb.append(getUrl());
        String sb2 = sb.toString();
        String str = CrashlyticsCore.TAG;
        logger.d(str, sb2);
        int code = applyMultipartDataTo.code();
        Logger logger2 = Fabric.getLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Create report request ID: ");
        sb3.append(applyMultipartDataTo.header(AbstractSpiCall.HEADER_REQUEST_ID));
        logger2.d(str, sb3.toString());
        Logger logger3 = Fabric.getLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Result was: ");
        sb4.append(code);
        logger3.d(str, sb4.toString());
        return ResponseParser.parse(code) == 0;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest header = httpRequest.header(AbstractSpiCall.HEADER_API_KEY, createReportRequest.apiKey).header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android").header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        for (Entry header2 : createReportRequest.report.getCustomHeaders().entrySet()) {
            header = header.header(header2);
        }
        return header;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        File[] files;
        httpRequest.part(IDENTIFIER_PARAM, report.getIdentifier());
        int length = report.getFiles().length;
        String str = FILE_CONTENT_TYPE;
        String str2 = " to report ";
        String str3 = CrashlyticsCore.TAG;
        if (length == 1) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Adding single file ");
            sb.append(report.getFileName());
            sb.append(str2);
            sb.append(report.getIdentifier());
            logger.d(str3, sb.toString());
            return httpRequest.part(FILE_PARAM, report.getFileName(), str, report.getFile());
        }
        int i = 0;
        for (File file : report.getFiles()) {
            Logger logger2 = Fabric.getLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Adding file ");
            sb2.append(file.getName());
            sb2.append(str2);
            sb2.append(report.getIdentifier());
            logger2.d(str3, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(MULTI_FILE_PARAM);
            sb3.append(i);
            sb3.append("]");
            httpRequest.part(sb3.toString(), file.getName(), str, file);
            i++;
        }
        return httpRequest;
    }
}
