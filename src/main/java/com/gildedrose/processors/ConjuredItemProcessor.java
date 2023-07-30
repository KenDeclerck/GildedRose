package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.modifier.QualityModifier;
import com.gildedrose.modifier.SellInModifier;

public class ConjuredItemProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
        SellInModifier.update(item);
        if (item.sellIn < 0) {
            QualityModifier.subtractQuality(item, 4);
        } else {
            QualityModifier.subtractQuality(item, 2);
        }
    }

    @Override
    public ItemType getItemType() {
        return ItemType.CONJURED;
    }
}
