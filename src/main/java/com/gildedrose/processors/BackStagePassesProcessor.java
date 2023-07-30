package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.modifier.QualityModifier;
import com.gildedrose.modifier.SellInModifier;

public class BackStagePassesProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
        SellInModifier.update(item);
        if (item.sellIn > 10) {
            QualityModifier.addQuality(item, 1);
        } else if (item.sellIn > 5) {
            QualityModifier.addQuality(item, 2);
        } else if (item.sellIn >= 0) {
            QualityModifier.addQuality(item, 3);
        } else {
            item.quality = 0;
        }
    }

    @Override
    public ItemType getItemType() {
        return ItemType.BACKSTAGE_PASSES;
    }
}
