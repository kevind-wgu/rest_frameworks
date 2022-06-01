package edu.wgu.ai.cocoa;

import dagger.Component;

import javax.inject.Singleton;

public class CocoaApp {
    @Singleton
    @Component(
            modules = {
                    HeaterModule.class,
                    PumpModule.class
            }
    )
    public interface DrinkShop {
        HCMaker maker();
        HCLogger logger();
    }

    public static void main(String[] args) {
        System.out.println("A");
        DrinkShop shop = DaggerCocoaApp_DrinkShop.builder().build();
        System.out.println("B");
        shop.maker().make();
        System.out.println("C");
        shop.logger().logs().forEach(log -> System.out.println(log));
        System.out.println("D");

        shop.maker().make();

        System.out.println("E");
    }
}
