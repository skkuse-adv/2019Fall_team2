package com.uber.rave;

import com.uber.rave.BaseValidator.ValidationContext;

public final class RaveError {
    private final String classElement;
    private final Class<?> clazz;
    private final String errorMsg;

    public RaveError(Class<?> cls, String str, String str2) {
        this.clazz = cls;
        this.errorMsg = str2;
        this.classElement = str;
    }

    public RaveError(ValidationContext validationContext, String str) {
        this.clazz = validationContext.getClazz();
        this.classElement = validationContext.getValidatedItemName();
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getClassElement() {
        return this.classElement;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public String toString() {
        String str = ":";
        if (this.classElement.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.clazz.getCanonicalName());
            sb.append(str);
            sb.append(this.errorMsg);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.clazz.getCanonicalName());
        sb2.append(str);
        sb2.append(this.classElement);
        sb2.append(str);
        sb2.append(this.errorMsg);
        return sb2.toString();
    }
}
