package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.modifier.QualityModifier;
import com.gildedrose.modifier.SellInModifier;

public class AgedBrieProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
        SellInModifier.update(item);
        if (item.sellIn < 0) {
            QualityModifier.addQuality(item, 2);
        } else {
            QualityModifier.addQuality(item, 1);
        }
    }

    @Override
    public ItemType getItemType() {
        return ItemType.AGED_BRIE;
    }
}
