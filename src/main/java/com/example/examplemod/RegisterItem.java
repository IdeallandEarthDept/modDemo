package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RegisterItem {
    public static final List<Item> ITEM_LIST = new ArrayList<>();
//    public static final ItemBow BOW_1 = (ItemBow) new ItemBow().setRegistryName("bow1").setCreativeTab(ModTabs.TAB1).setUnlocalizedName("bow1");
    public static final ItemBowBase BOW_2 = new ItemBowBase("bow2");
    public static final ItemBowBase BOW_3 = new ItemBowBase("bow3");
    public static final ItemBowBase BOW_4 = new ItemBowBase("bow4");




    @SubscribeEvent
    public static void handleItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ITEM_LIST.toArray(new Item[0]));
    }


}
