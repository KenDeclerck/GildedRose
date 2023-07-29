package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class GildedRoseTest {

    @ParameterizedTest(name = "{index}: {0} with sellIn {1} and quality {2} - Expected: sellIn={3}, quality={4}")
    @MethodSource("provideItemsForUpdateQuality")
    void shouldUpdateQualityAndSellIn(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = {new Item(name, initialSellIn, initialQuality)};

        GildedRose.processItemsForOneDay(items);

        assertItemQualityAndSellIn(items[0], expectedSellIn, expectedQuality);
    }

    private static Stream<Arguments> provideItemsForUpdateQuality() {
        return Stream.of(
            Arguments.of("Normal item", 10, 10, 9, 9),
            Arguments.of("other normal item", 5, 16, 4, 15),
            Arguments.of("other normal item", 5, 0, 4, 0),
            Arguments.of(ItemType.SULFURAS.name(), 10, 80, 10, 80),
            Arguments.of(ItemType.AGED_BRIE.name(), 10, 10, 9, 11),
            Arguments.of(ItemType.AGED_BRIE.name(), 10, 50, 9, 50),
            Arguments.of(ItemType.BACKSTAGE_PASSES.name(), 10, 10, 9, 12),
            Arguments.of(ItemType.BACKSTAGE_PASSES.name(), 14, 10, 13, 11),
            Arguments.of(ItemType.BACKSTAGE_PASSES.name(), 5, 10, 4, 13),
            Arguments.of(ItemType.BACKSTAGE_PASSES.name(), 1, 49, 0, 50),
            Arguments.of("Normal item", 0, 10, -1, 8),
            Arguments.of(ItemType.BACKSTAGE_PASSES.name(), 0, 10, -1, 0),
            Arguments.of(ItemType.AGED_BRIE.name(), 0, 10, -1, 12)
        );
    }

    private static void assertItemQualityAndSellIn(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn, "Unexpected sellIn value");
        assertEquals(expectedQuality, item.quality, "Unexpected quality value");
    }
}
