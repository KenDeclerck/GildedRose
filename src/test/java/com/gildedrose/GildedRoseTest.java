package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String NORMAL_ITEM = "Normal item";
    public static final String NORMAL_ITEM1 = "other normal item";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @ParameterizedTest(name = "{index}: {0} with sellIn {1} and quality {2} - Expected: sellIn={3}, quality={4}")
    @MethodSource("provideItemsForUpdateQuality")
    void shouldUpdateQualityAndSellIn(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        GildedRose app = new GildedRose(new Item[]{new Item(name, initialSellIn, initialQuality)});

        app.updateQuality();

        assertItemQualityAndSellIn(app.items[0], expectedSellIn, expectedQuality);
    }

    private static Stream<Arguments> provideItemsForUpdateQuality() {
        return Stream.of(
            Arguments.of(NORMAL_ITEM, 10, 10, 9, 9),
            Arguments.of(NORMAL_ITEM1, 5, 16, 4, 15),
            Arguments.of(SULFURAS, 10, 80, 10, 80),
            Arguments.of(AGED_BRIE, 10, 10, 9, 11),
            Arguments.of(AGED_BRIE, 10, 50, 9, 50),
            Arguments.of(BACKSTAGE_PASSES, 10, 10, 9, 12),
            Arguments.of(BACKSTAGE_PASSES, 14, 10, 13, 11),
            Arguments.of(BACKSTAGE_PASSES, 5, 10, 4, 13),
            Arguments.of(NORMAL_ITEM, 0, 10, -1, 8),
            Arguments.of(BACKSTAGE_PASSES, 0, 10, -1, 0),
            Arguments.of(AGED_BRIE, 0, 10, -1, 12)
        );
    }

    private static void assertItemQualityAndSellIn(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn, "Unexpected sellIn value");
        assertEquals(expectedQuality, item.quality, "Unexpected quality value");
    }
}
