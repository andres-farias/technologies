package com.deepblue.techs.pgpool;

import java.util.Random;

/**
 * @author Andrés Farías (a.farias@globant.com)
 */
public class ProductFactory {

    private static Random random = new Random();

    public static Product randomProduct() {
        String name = randomName();
        return new Product(name, random.nextDouble());
    }

    private static String randomName() {

        String[] size = {"Little", "Medium", "Big", "Huge"};
        String[] colours = {"Red", "Gray", "Orange", "Yellow", "Blue", "Black"};
        String[] products = {"Machine", "Jeans", "Helicopter", "Car", "Boat", "Glass", "Macbook", "Football", "Bed"};

        return size[random.nextInt(size.length)] + " " + colours[random.nextInt(colours.length)] + " " + products[random.nextInt(products.length)];
    }
}
