package com.gildedrose.processors;

import com.gildedrose.Item;
import com.gildedrose.modifier.QualityModifier;
import com.gildedrose.modifier.SellInModifier;

public class DefaultItemProcessor implements ItemProcessor {
    @Override
    public void process(Item item) {
        SellInModifier.update(item);
        if (item.sellIn < 0) {
            QualityModifier.subtractQuality(item, 2);
        } else {
            QualityModifier.subtractQuality(item, 1);
        }
    }
}
