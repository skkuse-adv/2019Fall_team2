package kr.co.popone.fitts.utils;

import kr.co.popone.fitts.C0001R$anim;

public enum ActivityAnimationType {
    SLIDE_DOWN(C0001R$anim.fade_in, C0001R$anim.slide_down),
    SLIDE_UP(C0001R$anim.slide_up, C0001R$anim.fade_out),
    SLIDE_RTOL(C0001R$anim.slide_right, C0001R$anim.fade_out),
    SLIDE_LTOR(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    
    private final int enter;
    private final int exit;

    private ActivityAnimationType(int i, int i2) {
        this.enter = i;
        this.exit = i2;
    }

    public final int getEnter() {
        return this.enter;
    }

    public final int getExit() {
        return this.exit;
    }
}
