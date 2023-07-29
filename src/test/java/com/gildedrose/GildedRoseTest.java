package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String NORMAL_ITEM = "Normal item";
    public static final String NORMAL_ITEM1 = "other normal item";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void foo() {
        GildedRose app = new GildedRose(getItemsArrWithOneItem("foo", 0, 0));
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void shouldSubtractOneQualityForNormalItems() {
        Item[] items = new Item[] {
            new Item(NORMAL_ITEM, 10, 10),
            new Item(NORMAL_ITEM1, 5, 16)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 9, 9);
        assertItemQualityAndSellIn(app.items[1], 4, 15);
    }

    @Test
    void shouldNotSubtractSellInOrQualityForSulfuras() {
        GildedRose app = new GildedRose(getItemsArrWithOneItem(SULFURAS, 10, 80));

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 10, 80);
    }

    @Test
    void shouldIncreaseQualityOfBrie() {
        GildedRose app = new GildedRose(getItemsArrWithOneItem(AGED_BRIE, 10, 10));

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 9, 11);
    }

    @Test
    void shouldNotIncreaseQualityAbove50() {
        Item[] items = getItemsArrWithOneItem(AGED_BRIE, 10, 50);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 9, 50);
    }

    @Test
    void shouldIncreaseQualityOfBackstagePassesBy2_lessThan10DaysMoreThan5() {
        Item[] items = getItemsArrWithOneItem(BACKSTAGE_PASSES, 10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 9, 12);
    }

    @Test
    void shouldIncreaseQualityOfBackstagePassesBy1_moreThan10Days() {
        Item[] items = getItemsArrWithOneItem(BACKSTAGE_PASSES, 14, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 13, 11);
    }

    @Test
    void shouldIncreaseQualityOfBackstagePassesBy3_lessThan5Days() {
        Item[] items = getItemsArrWithOneItem(BACKSTAGE_PASSES, 5, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], 4, 13);
    }

    @Test
    void shouldDecreaseQualityTwiceAsFastOnceSellByDateHasPassed() {
        Item[] items = getItemsArrWithOneItem(NORMAL_ITEM, 0, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], -1, 8);
    }

    @Test
    void shouldSetQualityToZeroOnceSellByDateHasPassedForBackstagePasses() {
        Item[] items = getItemsArrWithOneItem(BACKSTAGE_PASSES, 0, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], -1, 0);
    }

    @Test
    void shouldIncreaseQualityBy2IfSellByDateHasPassedForBrie() {
        Item[] items = getItemsArrWithOneItem(AGED_BRIE, 0, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], -1, 12);
    }

    private static Item[] getItemsArrWithOneItem(String name, int sellIn, int quality) {
        return new Item[]{new Item(name, sellIn, quality)};
    }

    private static void assertItemQualityAndSellIn(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }

}
