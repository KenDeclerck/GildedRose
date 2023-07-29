package com.gildedrose;

import java.util.Arrays;

public enum ItemType {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    DEFAULT(""),
    ;

    private final String name;
    ItemType(String name) {
        this.name = name;
    }

    public static ItemType forName(String value) {
        return Arrays.stream(values()).filter(itemType ->  itemType.name.equals(value)).findFirst().orElse(DEFAULT);
    }

    public String getName() {
        return name;
    }

}
