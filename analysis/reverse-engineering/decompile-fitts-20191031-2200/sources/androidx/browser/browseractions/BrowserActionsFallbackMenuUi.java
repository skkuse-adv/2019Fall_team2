package androidx.browser.browseractions;

import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.annotation.VisibleForTesting;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import java.util.List;

class BrowserActionsFallbackMenuUi implements OnItemClickListener {
    private static final String TAG = "BrowserActionskMenuUi";
    private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;
    BrowserActionsFallMenuUiListener mMenuUiListener;
    private final Uri mUri;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @VisibleForTesting
    interface BrowserActionsFallMenuUiListener {
        void onMenuShown(View view);
    }

    BrowserActionsFallbackMenuUi(Context context, Uri uri, List<BrowserActionItem> list) {
        this.mContext = context;
        this.mUri = uri;
        this.mMenuItems = list;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setMenuUiListener(BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener) {
        this.mMenuUiListener = browserActionsFallMenuUiListener;
    }

    public void displayMenu() {
        final View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_page, null);
        this.mBrowserActionsDialog = new BrowserActionsFallbackMenuDialog(this.mContext, initMenuView(inflate));
        this.mBrowserActionsDialog.setContentView(inflate);
        if (this.mMenuUiListener != null) {
            this.mBrowserActionsDialog.setOnShowListener(new OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    BrowserActionsFallbackMenuUi.this.mMenuUiListener.onMenuShown(inflate);
                }
            });
        }
        this.mBrowserActionsDialog.show();
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R.id.browser_actions_menu_view);
        final TextView textView = (TextView) view.findViewById(R.id.browser_actions_header_text);
        textView.setText(this.mUri.toString());
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (TextViewCompat.getMaxLines(textView) == Integer.MAX_VALUE) {
                    textView.setMaxLines(1);
                    textView.setEllipsize(TruncateAt.END);
                    return;
                }
                textView.setMaxLines(Integer.MAX_VALUE);
                textView.setEllipsize(null);
            }
        });
        ListView listView = (ListView) view.findViewById(R.id.browser_actions_menu_items);
        listView.setAdapter(new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            ((BrowserActionItem) this.mMenuItems.get(i)).getAction().send();
            this.mBrowserActionsDialog.dismiss();
        } catch (CanceledException unused) {
        }
    }
}
