package com.facebook.share.widget;

import androidx.core.os.EnvironmentCompat;
import com.facebook.share.internal.MessengerShareContentUtility;

@Deprecated
public enum LikeView$ObjectType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN, 0),
    OPEN_GRAPH(MessengerShareContentUtility.TEMPLATE_OPEN_GRAPH_TYPE, 1),
    PAGE("page", 2);
    
    public static LikeView$ObjectType DEFAULT;
    private int intValue;
    private String stringValue;

    static {
        LikeView$ObjectType likeView$ObjectType;
        DEFAULT = likeView$ObjectType;
    }

    public static LikeView$ObjectType fromInt(int i) {
        LikeView$ObjectType[] values;
        for (LikeView$ObjectType likeView$ObjectType : values()) {
            if (likeView$ObjectType.getValue() == i) {
                return likeView$ObjectType;
            }
        }
        return null;
    }

    private LikeView$ObjectType(String str, int i) {
        this.stringValue = str;
        this.intValue = i;
    }

    public String toString() {
        return this.stringValue;
    }

    public int getValue() {
        return this.intValue;
    }
}
