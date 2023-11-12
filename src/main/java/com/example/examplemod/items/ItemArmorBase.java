package com.example.examplemod.items;

import com.example.examplemod.ModTabs;
import com.example.examplemod.RegisterUtil;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static net.minecraft.entity.SharedMonsterAttributes.ATTACK_DAMAGE;

public class ItemArmorBase extends ItemArmor {

    public static String s = "d664b939-359c-4fea-895e-fe7f0bcd4d84\n" +
            "d806b601-d165-4ef9-b940-3e07ea7d3dba\n" +
            "d35cdc54-14ca-40e2-9aa9-3c5f5bf99afc\n" +
            "c6af4e3e-5d16-4e22-97f2-5b7b42ceb27a\n" +
            "97d1f8a5-5097-459c-8359-7c48c63161d9\n" +
            "aaf6acfb-624e-4cfa-8af3-0ca35517cf43\n" +
            "6a19b1f0-16d1-4e42-9e59-c55463336476\n" +
            "0f32fd90-5075-4f7c-87d9-9eabd53336ca\n" +
            "e24722d5-3449-4eba-ab79-c3bda57eee5a\n" +
            "ae0f6985-e943-4180-8eb7-eaa88380d39f";

    UUID uuid = UUID.fromString("d664b939-359c-4fea-895e-fe7f0bcd4d84");
    UUID uuid2 = UUID.fromString("d806b601-d165-4ef9-b940-3e07ea7d3dba");

    public ItemArmorBase(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, 5, equipmentSlotIn);
        RegisterUtil.initItem(this, name);
        setCreativeTab(ModTabs.TAB1);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> hashmap = super.getAttributeModifiers(slot, stack);
        if (slot == EntityEquipmentSlot.MAINHAND)
        {
            ((BaseAttribute)ATTACK_DAMAGE).setShouldWatch(true);
//            hashmap.put(ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "test",10000,0));
//            hashmap.put(ATTACK_DAMAGE.getName(), new AttributeModifier(uuid2, "test",100,0));
//            hashmap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(uuid2, "test", -2,1));

            hashmap.put(ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "test", 10000,0));
//            hashmap.put(ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "test", 1,0));
//            hashmap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "test", 1,0));
        }
        return hashmap;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (worldIn != null)
        {
            EntityPlayer player = Minecraft.getMinecraft().player;
            tooltip.add(String.format("Cur ATK = %s", player.getEntityAttribute(ATTACK_DAMAGE).getAttributeValue()));
        }
    }
}
