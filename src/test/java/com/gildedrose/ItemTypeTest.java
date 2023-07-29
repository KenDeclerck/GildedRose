package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeTest {

    @Test
    void shouldGetCorrectEnumSulfuras() {
        ItemType itemType = ItemType.valueOf("Sulfuras, Hand of Ragnaros");

        assertEquals(ItemType.SULFURAS, itemType);
    }

    @Test
    void shouldGetCorrectEnumAgedBrie() {
        ItemType itemType = ItemType.valueOf("Aged Brie");

        assertEquals(ItemType.AGED_BRIE, itemType);
    }
    @Test
    void shouldGetCorrectEnumBackstagePasses() {
        ItemType itemType = ItemType.valueOf("Backstage passes to a TAFKAL80ETC concert");

        assertEquals(ItemType.BACKSTAGE_PASSES, itemType);
    }

    @Test
    void shouldGetOtherItemIfNameNotFound() {
        ItemType itemType = ItemType.valueOf("Something else");

        assertEquals(ItemType.DEFAULT, itemType);
    }
}
