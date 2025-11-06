package com.risingheroes;

import com.risingheroes.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RisingHeroes implements ModInitializer {
    public static final String MOD_ID = "risingheroes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        LOGGER.info("Rising Heroes mod initialized!");
    }
}

