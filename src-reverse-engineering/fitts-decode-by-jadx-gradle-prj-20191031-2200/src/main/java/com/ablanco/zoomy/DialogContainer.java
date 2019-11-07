package com.ablanco.zoomy;

import android.app.Dialog;
import android.view.ViewGroup;

public class DialogContainer implements TargetContainer {
    private Dialog mDialog;

    DialogContainer(Dialog dialog) {
        this.mDialog = dialog;
    }

    public final ViewGroup getDecorView() {
        if (this.mDialog.getWindow() != null) {
            return (ViewGroup) this.mDialog.getWindow().getDecorView();
        }
        return null;
    }
}
