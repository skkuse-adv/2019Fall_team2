package org.simple.eventbus.handler;

import java.lang.reflect.InvocationTargetException;
import org.simple.eventbus.Subscription;

public class DefaultEventHandler implements EventHandler {
    public void handleEvent(Subscription subscription, Object obj) {
        if (subscription != null && subscription.subscriber.get() != null) {
            try {
                subscription.targetMethod.invoke(subscription.subscriber.get(), new Object[]{obj});
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
