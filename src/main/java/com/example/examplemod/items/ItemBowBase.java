package com.example.examplemod.items;

import com.example.examplemod.ModTabs;
import com.example.examplemod.RegisterUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;

public class ItemBowBase extends ItemBow {
    public ItemBowBase(String name) {
        super();
        RegisterUtil.initItem(this, name);
        setCreativeTab(ModTabs.TAB1);
    }
}
