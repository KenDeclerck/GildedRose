package com.gildedrose.modifier;

import com.gildedrose.Item;

public class SellInModifier {
    public static void update(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
