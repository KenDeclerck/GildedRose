package com.gildedrose;

import com.gildedrose.processors.*;

import java.util.List;
import java.util.Map;

class GildedRose {

    private static final List<ItemProcessor> processors = List.of(new AgedBrieProcessor(),
        new BackStagePassesProcessor(),
        new SulfurasProcessor(),
        new NormalItemProcessor(),
        new ConjuredItemProcessor());

    public static void processItemsForOneDay(Item[] items) {
        for (Item item : items) {
            processors.stream()
                .filter(processor -> processor.getItemType() == ItemType.forName(item.name))
                .findFirst()
                .ifPresentOrElse(processor -> processor.process(item),
                    () -> System.out.println("Something went wrong."));
        }
    }
}
