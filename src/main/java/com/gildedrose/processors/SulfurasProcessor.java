package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

public class SulfurasProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
        System.out.println("Nothing should be processed for " + ItemName.SULFURAS);
    }
}
