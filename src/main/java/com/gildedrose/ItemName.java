package com.gildedrose;

import java.util.Arrays;

public enum ItemName {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    OTHER_ITEM(""),
    ;

    private final String value;
    ItemName(String value) {
        this.value = value;
    }

    public static ItemName forValue(String value) {
        return Arrays.stream(values()).filter(itemName ->  itemName.value.equals(value)).findFirst().orElse(OTHER_ITEM);
    };
}
