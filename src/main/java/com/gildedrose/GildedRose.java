package com.gildedrose;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static void addQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }

    private static boolean sellByDateHasPassed(Item item) {
        return item.sellIn < 0;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            if (item.name.equals(SULFURAS)) {
                return;
            }
            item.sellIn = item.sellIn - 1;

            if (item.name.equals(AGED_BRIE)) {
                if (sellByDateHasPassed(item)) {
                    addQuality(item, 2);
                } else {
                    addQuality(item, 1);
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn > 10) {
                    addQuality(item, 1);
                } else if (item.sellIn < 10 && item.sellIn > 5) {
                    addQuality(item, 2);
                } else if (item.sellIn < 5 && item.sellIn >= 0) {
                    addQuality(item, 3);
                } else if (sellByDateHasPassed(item)) {
                    item.quality = 0;
                }
            } else if (item.quality > 0) {
                if (sellByDateHasPassed(item)) {
                    item.quality = item.quality - 2;
                } else {
                    item.quality = item.quality - 1;
                }
            }

        });
    }
}
