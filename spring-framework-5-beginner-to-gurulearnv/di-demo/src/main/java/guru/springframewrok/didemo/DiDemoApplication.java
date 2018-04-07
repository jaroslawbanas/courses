package guru.springframewrok.didemo;

import guru.springframewrok.didemo.controllers.ConstructorInjectedController;
import guru.springframewrok.didemo.controllers.MyConroller;
import guru.springframewrok.didemo.controllers.PropertyInjectedController;
import guru.springframewrok.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyConroller myConroller = (MyConroller) ctx.getBean("myConroller");

        System.out.println(myConroller.hello());

        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
    }
}
