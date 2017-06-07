package org.common.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 */
public class Triangle implements Shape,ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean {

    private ApplicationContext context;

    private String type;

    private int height;

    private List<Point> points;

    private Point pointA;

    private Point pointB;

    private Point pointC;


    Triangle(int height){
        this.height = height;
    }

    Triangle(String type){
        this.type = type;
    }



    Triangle(String type,int height){
        this.type = type;
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public String getType(){
        return type;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    @Resource(name="onePoint")
    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    @Required
    @Autowired
    @Qualifier("pointCRelated")
    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

//    public void setType(String type){
//        this.type = type;
//    }

    public void draw(){
        System.out.println("Drawing Triangle");
        System.out.println(type+ " Traingle drawn "+getHeight()+" PointA "+getPointA()+" PointB "+getPointB()+" PointC "+getPointC());
        for(Point point : points){
            System.out.println(point);
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name : "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Intialised bean triangle");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed bean triangle");

    }

    public void myInit(){
        System.out.println("Triangle my init method call");
    }

    public void cleanUp(){
        System.out.println("Triangle my destroy method call");

    }

}
