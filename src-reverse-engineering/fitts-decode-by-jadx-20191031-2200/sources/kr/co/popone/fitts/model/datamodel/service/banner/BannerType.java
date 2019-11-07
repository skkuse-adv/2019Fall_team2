package kr.co.popone.fitts.model.datamodel.service.banner;

import androidx.core.app.NotificationCompat;
import org.jetbrains.annotations.NotNull;

public enum BannerType {
    RECOMMEND("recommendation_content"),
    EVENT(NotificationCompat.CATEGORY_EVENT),
    MENU("menu");
    
    @NotNull
    private final String type;

    private BannerType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
