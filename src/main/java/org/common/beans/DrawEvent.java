package org.common.beans;

import org.springframework.context.ApplicationEvent;

/**
 * Created by sowmyaparameshwara on 5/25/17.
 */
public class DrawEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DrawEvent(Object source) {
        super(source);
    }

    public String toString(){
        return "Draw Event Occured";
    }
}
