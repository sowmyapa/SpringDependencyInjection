package org;

import org.common.beans.Shape;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 */

public class Application {

    public static void main(String[] args){
        /*ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }*/

        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("springs.xml"));
            AbstractApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
            context.registerShutdownHook();
            Shape t = (Shape) context.getBean("Triangle-Alias");
            t.draw();
            Shape c = (Shape) context.getBean("circle");
            c.draw();
            System.out.println(context.getMessage("greeting",null,"Default Greeting",null));

        //context = new ClassPathXmlApplicationContext("springs.xml");
        /* t = (Triangle) context.getBean("Triangle-Alias");
        t.draw();
        System.out.println(t);*/

    }
}
