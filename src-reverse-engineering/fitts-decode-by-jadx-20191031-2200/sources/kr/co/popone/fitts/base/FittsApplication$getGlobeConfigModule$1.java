package kr.co.popone.fitts.base;

import android.os.Build.VERSION;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.http.GlobeHttpHandler;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.internal.Version;
import org.jetbrains.annotations.NotNull;

public final class FittsApplication$getGlobeConfigModule$1 implements GlobeHttpHandler {
    final /* synthetic */ FittsApplication this$0;

    FittsApplication$getGlobeConfigModule$1(FittsApplication fittsApplication) {
        this.this$0 = fittsApplication;
    }

    @NotNull
    public Request onHttpRequestBefore(@NotNull Chain chain, @NotNull Request request) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(request, "request");
        String fittsID = this.this$0.getSessionManager$app_productionFittsRelease().getFittsID();
        String token = this.this$0.getSessionManager$app_productionFittsRelease().getToken();
        String str = "chain\n                  …                 .build()";
        String str2 = ") ";
        String str3 = "; build:153; Android ";
        String str4 = "Fitts/2.11.2 (";
        String str5 = "User-Agent";
        if (fittsID == null || token == null) {
            Builder removeHeader = chain.request().newBuilder().removeHeader(str5);
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(this.this$0.getPackageName());
            sb.append(str3);
            sb.append(VERSION.RELEASE);
            sb.append(str2);
            sb.append(Version.userAgent());
            Request build = removeHeader.addHeader(str5, sb.toString()).build();
            Intrinsics.checkExpressionValueIsNotNull(build, str);
            Logger.d(build.toString(), new Object[0]);
            return build;
        }
        Builder removeHeader2 = chain.request().newBuilder().addHeader("X-Fitts-ID", fittsID).addHeader("X-User-Token", token).removeHeader(str5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(this.this$0.getPackageName());
        sb2.append(str3);
        sb2.append(VERSION.RELEASE);
        sb2.append(str2);
        sb2.append(Version.userAgent());
        Request build2 = removeHeader2.addHeader(str5, sb2.toString()).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("fittsid ------>");
        sb3.append(fittsID);
        sb3.append("    ||   auth_token------>");
        sb3.append(token);
        Logger.d(sb3.toString(), new Object[0]);
        Logger.d(build2.toString(), new Object[0]);
        return build2;
    }
}
