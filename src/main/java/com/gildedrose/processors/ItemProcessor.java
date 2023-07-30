package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public interface ItemProcessor {
    void process(Item item);

    ItemType getItemType();
}
