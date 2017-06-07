package org.common.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by sowmyaparameshwara on 5/23/17.
 */
@Component
public class Circle implements Shape,ApplicationEventPublisherAware {

    private Point center;

    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void draw() {
        System.out.println(messageSource.getMessage("drawing.circle",null,"Default Drawing Message",null));
        System.out.println(messageSource.getMessage("drawing.point",new Object[]{center.getX(),center.getY()},"Default Drawing Message",null));
        publisher.publishEvent(new DrawEvent(this));
    }


    public Point getCenter() {
        return center;
    }

    @Required
    @Autowired
    public void setCenter(Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initialiseCircle(){
        System.out.println("Initialising circle via JAVAX annotation");
    }

    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroying circle via JAVAX annotation");
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
