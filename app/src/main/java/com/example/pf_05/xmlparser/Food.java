package com.example.pf_05.xmlparser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by pf-05 on 6/2/2018.
 */

@Root(name = "food")

public class Food {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Element(name = "name")
    private String name;

    @Element(name = "price")
    private String price;

    @Element(name = "description")
    private String description;

    @Element(name = "calories")
    private String calories;


    public Food() {
    }
}
