package com.example.pf_05.xmlparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by pf-05 on 6/2/2018.
 */


@Root(name = "breakfast_menu")
public class BreakfastMenu {

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @ElementList(inline = true)

    private List<Food> foodList;

    public BreakfastMenu() {
    }
}
