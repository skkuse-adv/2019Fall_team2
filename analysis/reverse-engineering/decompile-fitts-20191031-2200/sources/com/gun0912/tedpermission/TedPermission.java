package com.gun0912.tedpermission;

import android.content.Context;

public class TedPermission extends TedPermissionBase {
    public static final String TAG = "TedPermission";

    public static class Builder extends PermissionBuilder<Builder> {
        private Builder(Context context) {
            super(context);
        }

        public void check() {
            checkPermissions();
        }
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }
}
