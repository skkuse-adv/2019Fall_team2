package com.beloo.widget.chipslayoutmanager.layouter.breaker;

public class ColumnBreakerFactory implements IBreakerFactory {
    public ILayoutRowBreaker createBackwardRowBreaker() {
        return new LTRBackwardColumnBreaker();
    }

    public ILayoutRowBreaker createForwardRowBreaker() {
        return new LTRForwardColumnBreaker();
    }
}
