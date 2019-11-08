package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.ui.DialogExtensions;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.HttpException;

final class StoreBrowserActivity$onCreate$23<T> implements Observer<Throwable> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$23(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Throwable th) {
        if (th instanceof HttpException) {
            ResponseBody errorBody = ((HttpException) th).response().errorBody();
            if (errorBody == null) {
                Intrinsics.throwNpe();
            }
            byte[] bytes = errorBody.bytes();
            Intrinsics.checkExpressionValueIsNotNull(bytes, "it.response().errorBody()!!.bytes()");
            JSONObject jSONObject = new JSONObject(new String(bytes, Charsets.UTF_8));
            String str = SettingsJsonConstants.PROMPT_MESSAGE_KEY;
            String string = jSONObject.getString(str);
            DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
            StoreBrowserActivity storeBrowserActivity = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(string, str);
            dialogExtensions.showMessageDialog(storeBrowserActivity, "", string, AnonymousClass1.INSTANCE, "확인");
            return;
        }
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
