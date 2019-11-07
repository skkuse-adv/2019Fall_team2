package com.beloo.widget.chipslayoutmanager.layouter.breaker;

public class LTRRowBreakerFactory implements IBreakerFactory {
    public ILayoutRowBreaker createBackwardRowBreaker() {
        return new LTRBackwardRowBreaker();
    }

    public ILayoutRowBreaker createForwardRowBreaker() {
        return new LTRForwardRowBreaker();
    }
}
