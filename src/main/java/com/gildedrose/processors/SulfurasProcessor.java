package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class SulfurasProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
//        Nothing should be processed for " + ItemType.SULFURAS);
    }

    @Override
    public ItemType getItemType() {
        return ItemType.SULFURAS;
    }
}
