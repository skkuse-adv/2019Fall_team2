package com.ablanco.zoomy;

public class ZoomyConfig {
    private boolean immersiveModeEnabled = true;
    private boolean zoomAnimationEnabled = true;

    public boolean isZoomAnimationEnabled() {
        return this.zoomAnimationEnabled;
    }

    public void setZoomAnimationEnabled(boolean z) {
        this.zoomAnimationEnabled = z;
    }

    public boolean isImmersiveModeEnabled() {
        return this.immersiveModeEnabled;
    }

    public void setImmersiveModeEnabled(boolean z) {
        this.immersiveModeEnabled = z;
    }
}
