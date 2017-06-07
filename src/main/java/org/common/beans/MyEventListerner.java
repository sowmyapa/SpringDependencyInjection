package org.common.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by sowmyaparameshwara on 5/25/17.
 */
@Component
public class MyEventListerner implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Event : "+event.toString());
    }
}
