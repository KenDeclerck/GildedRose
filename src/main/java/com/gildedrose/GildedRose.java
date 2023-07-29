package com.gildedrose;

import com.gildedrose.processors.*;

import java.util.Map;

class GildedRose {

    private static final Map<ItemType, ItemProcessor> processorsByName = Map.of(ItemType.AGED_BRIE, new AgedBrieProcessor(),
        ItemType.BACKSTAGE_PASSES, new BackStagePassesProcessor(),
        ItemType.SULFURAS, new SulfurasProcessor(),
        ItemType.NORMAL, new NormalItemProcessor());

    public static void processItemsForOneDay(Item[] items) {
        for (Item item : items) {
            processorsByName.get(ItemType.forName(item.name)).process(item);
        }
    }
}
