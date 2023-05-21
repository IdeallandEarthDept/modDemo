package com.example.examplemod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
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
    public static final ItemBase ITEM_1 = new ItemBase("item_1");
    public static final ItemBuildHouse BUILD_HOUSE_1 = new ItemBuildHouse("item_build_1");
    
    @SubscribeEvent
    public static void handleItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ITEM_LIST.toArray(new Item[0]));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event)
    {
        for (Item item:
             ITEM_LIST) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
