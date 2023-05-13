package com.example.examplemod;

import com.example.examplemod.blocks.RegisterItem;
import net.minecraft.item.Item;

public class RegisterUtil {
    public static void initItem(Item item, String name)
    {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        RegisterItem.ITEM_LIST.add(item);
    }
}
