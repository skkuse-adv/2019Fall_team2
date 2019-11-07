package com.facebook.share.model;

@Deprecated
public enum AppInviteContent$Builder$Destination {
    FACEBOOK("facebook"),
    MESSENGER("messenger");
    
    private final String name;

    private AppInviteContent$Builder$Destination(String str) {
        this.name = str;
    }

    public boolean equalsName(String str) {
        if (str == null) {
            return false;
        }
        return this.name.equals(str);
    }

    public String toString() {
        return this.name;
    }
}
