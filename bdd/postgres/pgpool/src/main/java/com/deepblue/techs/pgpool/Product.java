package com.deepblue.techs.pgpool;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Andrés Farías (a.farias@globant.com)
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{ name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
