package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegisterItem {
    @SubscribeEvent
    public static void handleItem(RegistryEvent.Register<Item> event)
    {
        //vanilla tab
        event.getRegistry().register(new Item().setRegistryName("test3").setCreativeTab(CreativeTabs.BREWING));
        event.getRegistry().register(new Item().setRegistryName("test4").setCreativeTab(ModTabs.TAB1));


    }


}
