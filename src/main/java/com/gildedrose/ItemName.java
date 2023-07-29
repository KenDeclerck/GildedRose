package com.gildedrose;

import java.util.Arrays;

public enum ItemName {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    DEFAULT(""),
    ;

    private final String name;
    ItemName(String name) {
        this.name = name;
    }

    public static ItemName forName(String value) {
        return Arrays.stream(values()).filter(itemName ->  itemName.name.equals(value)).findFirst().orElse(DEFAULT);
    };
}
