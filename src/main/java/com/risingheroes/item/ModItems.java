package com.risingheroes.item;

import com.risingheroes.RisingHeroes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Creative Tab - icon will be set after items are registered
    public static final ItemGroup RISING_HEROES_TAB = FabricItemGroup.builder()
        .icon(() -> new ItemStack(Items.DIAMOND_SWORD))
        .displayName(Text.translatable("itemGroup.risingheroes.rising_heroes"))
        .build();
    
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
        
        // Register creative tab
        Registry.register(Registry.ITEM_GROUP, 
            new Identifier(RisingHeroes.MOD_ID, "rising_heroes"), 
            RISING_HEROES_TAB);
    }
}

