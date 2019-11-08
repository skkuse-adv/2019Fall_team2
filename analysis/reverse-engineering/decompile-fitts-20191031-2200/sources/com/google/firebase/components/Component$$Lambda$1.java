package com.google.firebase.components;

final /* synthetic */ class Component$$Lambda$1 implements ComponentFactory {
    private final Object arg$1;

    private Component$$Lambda$1(Object obj) {
        this.arg$1 = obj;
    }

    public static ComponentFactory lambdaFactory$(Object obj) {
        return new Component$$Lambda$1(obj);
    }

    public Object create(ComponentContainer componentContainer) {
        Object obj = this.arg$1;
        Component.lambda$of$0(obj, componentContainer);
        return obj;
    }
}
