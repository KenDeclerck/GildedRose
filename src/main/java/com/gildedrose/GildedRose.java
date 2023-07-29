package com.gildedrose;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            if (item.name.equals(SULFURAS)) {
                return;
            }
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)
                && item.quality > 0) {
                item.quality = item.quality - 1;
            } else {
                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn > 11) {
                        addQuality(item, 1);
                    } else if (item.sellIn < 11 && item.sellIn > 6) {
                        addQuality(item, 2);
                    } else if (item.sellIn < 6 && item.sellIn >= 0) {
                            addQuality(item, 3);
                        }
                        else if (item.sellIn < 0) {
                            item.quality = 0;
                        }
                    } else {
                        addQuality(item, 1);
                    }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.quality > 0 && (!item.name.equals(SULFURAS))) {
                                item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        addQuality(item, 1);
                    }
                }
            }
        });
    }

    private static void addQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }
}
