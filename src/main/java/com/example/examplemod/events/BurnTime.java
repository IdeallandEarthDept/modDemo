package com.example.examplemod.events;

import net.minecraft.init.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class BurnTime {
    @SubscribeEvent
    public static void onBurn(FurnaceFuelBurnTimeEvent event)
    {
        if (event.getItemStack().getItem() == Items.DIAMOND)
        {
            event.setBurnTime(99);
        }
    }
}
