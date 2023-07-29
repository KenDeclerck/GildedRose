package com.gildedrose;

import java.util.Arrays;

class GildedRose {
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
            switch (ItemName.valueOf(item.name)) {
                case SULFURAS:
                    return;
                case AGED_BRIE:
                    processAgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    processBackStagePasses(item);
                    break;
                default:
                    processOtherItems(item);
                    break;
            }
        });
    }

    private static void processOtherItems(Item item) {
        updateSellIn(item);
        if (sellByDateHasPassed(item)) {
            subtractQuality(item, 2);
        } else {
            subtractQuality(item, 1);
        }
    }

    private static void subtractQuality(Item item, int amount) {
        item.quality = Math.max(item.quality - amount, 0);
    }

    private static void processBackStagePasses(Item item) {
        updateSellIn(item);
        if (item.sellIn > 10) {
            addQuality(item, 1);
        } else if (item.sellIn < 10 && item.sellIn > 5) {
            addQuality(item, 2);
        } else if (item.sellIn < 5 && item.sellIn >= 0) {
            addQuality(item, 3);
        } else if (sellByDateHasPassed(item)) {
            item.quality = 0;
        }
    }

    private static void processAgedBrie(Item item) {
        updateSellIn(item);
        if (sellByDateHasPassed(item)) {
            addQuality(item, 2);
        } else {
            addQuality(item, 1);
        }
    }

    private static void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
