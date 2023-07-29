package com.gildedrose;

import com.gildedrose.processors.*;

import java.util.Map;
import java.util.PropertyResourceBundle;

class GildedRose {

    private static final Map<ItemName, ItemProcessor> processorsByName = Map.of(ItemName.AGED_BRIE, new AgedBrieProcessor(),
        ItemName.BACKSTAGE_PASSES, new BackStagePassesProcessor(),
        ItemName.SULFURAS, new SulfurasProcessor(),
        ItemName.DEFAULT, new DefaultItemProcessor());

    public static void processItemsForOneDay(Item[] items) {
        for (Item item : items) {
            processorsByName.get(ItemName.forName(item.name)).process(item);
        }
    }
}
