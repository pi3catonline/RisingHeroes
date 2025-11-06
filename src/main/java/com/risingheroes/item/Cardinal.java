package com.risingheroes.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Base class for all Cardinal items in the Rising Heroes mod.
 * All Cardinal weapons inherit from this class.
 */
public abstract class Cardinal extends Item {
    public Cardinal(Settings settings) {
        super(settings);
    }

    /**
     * Override this method to provide custom behavior for Cardinal items.
     * This is a base implementation that can be extended by subclasses.
     */
    @Override
    public boolean isDamageable() {
        return true;
    }

    /**
     * All Cardinal items have a special glow effect.
     */
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}

