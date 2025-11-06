package com.risingheroes.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

/**
 * Cardinal Shield - A powerful shield with the Cardinal heritage.
 */
public class CardinalShield extends ShieldItem {
    public CardinalShield(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}

