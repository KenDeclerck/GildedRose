package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemNameTest {

    @Test
    void shouldGetCorrectEnumSulfuras() {
        ItemName itemName = ItemName.valueOf("Sulfuras, Hand of Ragnaros");

        assertEquals(ItemName.SULFURAS, itemName);
    }

    @Test
    void shouldGetCorrectEnumAgedBrie() {
        ItemName itemName = ItemName.valueOf("Aged Brie");

        assertEquals(ItemName.AGED_BRIE, itemName);
    }
    @Test
    void shouldGetCorrectEnumBackstagePasses() {
        ItemName itemName = ItemName.valueOf("Backstage passes to a TAFKAL80ETC concert");

        assertEquals(ItemName.BACKSTAGE_PASSES, itemName);
    }

    @Test
    void shouldGetOtherItemIfNameNotFound() {
        ItemName itemName = ItemName.valueOf("Something else");

        assertEquals(ItemName.DEFAULT, itemName);
    }
}
