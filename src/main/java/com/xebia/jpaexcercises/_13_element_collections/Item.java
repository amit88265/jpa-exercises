package com.xebia.jpaexcercises._13_element_collections;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Item {

    private String _name;
    private BigDecimal price;

    public Item() {
    }

    public Item(String name, BigDecimal price) {
        this._name = name;
        this.price = price;
    }

    public String getName() {
        return _name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
