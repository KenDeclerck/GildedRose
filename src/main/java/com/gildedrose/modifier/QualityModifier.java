package com.gildedrose.modifier;

import com.gildedrose.Item;

public class QualityModifier {
    public static void addQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }

    public static void subtractQuality(Item item, int amount) {
        item.quality = Math.max(item.quality - amount, 0);
    }
}
