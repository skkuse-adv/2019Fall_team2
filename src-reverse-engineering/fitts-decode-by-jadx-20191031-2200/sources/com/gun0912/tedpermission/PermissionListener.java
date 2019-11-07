package com.gun0912.tedpermission;

import java.util.ArrayList;

public interface PermissionListener {
    void onPermissionDenied(ArrayList<String> arrayList);

    void onPermissionGranted();
}
