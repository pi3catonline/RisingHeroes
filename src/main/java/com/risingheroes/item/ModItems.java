package com.risingheroes.item;

import com.risingheroes.RisingHeroes;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Creative Tab - using ItemGroup directly (compatible with Fabric 1.19.2)
    // Index should be higher than existing groups (default groups go up to ~12)
    public static final ItemGroup RISING_HEROES_TAB = new ItemGroup(13, "rising_heroes") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND_SWORD); // Temporary icon, will be updated after items are registered
        }
        
        @Override
        public void appendStacks(net.minecraft.util.collection.DefaultedList<ItemStack> stacks) {
            stacks.add(new ItemStack(CARDINAL_SWORD));
            stacks.add(new ItemStack(CARDINAL_SPEAR));
            stacks.add(new ItemStack(CARDINAL_BOW));
            stacks.add(new ItemStack(CARDINAL_SHIELD));
        }
    };
    
    // Register items
    public static final Item CARDINAL_SWORD = registerItem("cardinal_sword",
        new CardinalSword(ToolMaterials.NETHERITE, 5, -2.4f, 
            new Item.Settings().group(RISING_HEROES_TAB)));
    
    public static final Item CARDINAL_SPEAR = registerItem("cardinal_spear",
        new CardinalSpear(ToolMaterials.NETHERITE, 5, -2.4f,
            new Item.Settings().group(RISING_HEROES_TAB)));
    
    public static final Item CARDINAL_BOW = registerItem("cardinal_bow",
        new CardinalBow(new Item.Settings().group(RISING_HEROES_TAB).maxDamage(384)));
    
    public static final Item CARDINAL_SHIELD = registerItem("cardinal_shield",
        new CardinalShield(new Item.Settings().group(RISING_HEROES_TAB).maxDamage(336)));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RisingHeroes.MOD_ID, name), item);
    }
    
    public static void registerModItems() {
        RisingHeroes.LOGGER.info("Registering Mod Items for " + RisingHeroes.MOD_ID);
        // ItemGroup is automatically registered when created, no manual registration needed
    }
}
