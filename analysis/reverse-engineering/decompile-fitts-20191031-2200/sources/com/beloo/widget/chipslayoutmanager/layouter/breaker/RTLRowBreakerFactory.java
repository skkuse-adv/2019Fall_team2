package com.beloo.widget.chipslayoutmanager.layouter.breaker;

public class RTLRowBreakerFactory implements IBreakerFactory {
    public ILayoutRowBreaker createBackwardRowBreaker() {
        return new RTLBackwardRowBreaker();
    }

    public ILayoutRowBreaker createForwardRowBreaker() {
        return new RTLForwardRowBreaker();
    }
}
