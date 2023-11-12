package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
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
    public static final ItemBowBase BOW_5 = new ItemBowBase("bow5");

    public static final ItemArmor.ArmorMaterial DEMO_MAT = EnumHelper.addArmorMaterial(
                    ExampleMod.MODID+":demo_armor", ExampleMod.MODID+":popolon_armor",
            100,new int[]{2,3,4,5},10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,1f)
            .setRepairItem(new ItemStack(BOW_2));

    public static final ItemArmorBase DEMO_HEAD = new ItemArmorBase("demo_armor_1",DEMO_MAT, EntityEquipmentSlot.HEAD);
    public static final ItemArmorBase DEMO_CHEST = new ItemArmorBase("demo_armor_2",DEMO_MAT, EntityEquipmentSlot.CHEST);
    public static final ItemArmorBase DEMO_LEG = new ItemArmorBase("demo_armor_3",DEMO_MAT, EntityEquipmentSlot.LEGS);
    public static final ItemArmorBase DEMO_FEET = new ItemArmorBase("demo_armor_4",DEMO_MAT, EntityEquipmentSlot.FEET);

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
