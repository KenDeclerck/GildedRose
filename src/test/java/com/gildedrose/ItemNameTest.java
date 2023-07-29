package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemNameTest {

    @Test
    void shouldGetCorrectEnumSulfuras() {
        ItemName itemName = ItemName.forValue("Sulfuras, Hand of Ragnaros");

        assertEquals(ItemName.SULFURAS, itemName);
    }

    @Test
    void shouldGetCorrectEnumAgedBrie() {
        ItemName itemName = ItemName.forValue("Aged Brie");

        assertEquals(ItemName.AGED_BRIE, itemName);
    }
    @Test
    void shouldGetCorrectEnumBackstagePasses() {
        ItemName itemName = ItemName.forValue("Backstage passes to a TAFKAL80ETC concert");

        assertEquals(ItemName.BACKSTAGE_PASSES, itemName);
    }

    @Test
    void shouldGetOtherItemIfNameNotFound() {
        ItemName itemName = ItemName.forValue("Something else");

        assertEquals(ItemName.OTHER_ITEM, itemName);
    }
}
