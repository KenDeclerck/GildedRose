package com.gildedrose;

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

    public static void updateQuality(Item[] items1) {
        for (Item item : items1) {
            switch (ItemName.forName(item.name)) {
                case AGED_BRIE:
                    updateSellIn(item);
                    processAgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    updateSellIn(item);
                    processBackStagePasses(item);
                    break;
                case SULFURAS:
                    continue;
                default:
                    updateSellIn(item);
                    processOtherItems(item);
                    break;
            }
        }
    }

    private static void processOtherItems(Item item) {
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
