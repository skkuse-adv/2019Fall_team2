package org.jetbrains.anko;

public enum InputConstraints {
    PASSWORD(129);
    
    private final int value;

    protected InputConstraints(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
