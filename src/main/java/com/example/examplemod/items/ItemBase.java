package com.example.examplemod.items;

import com.example.examplemod.ModTabs;
import com.example.examplemod.RegisterUtil;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name)
    {
        super();
        RegisterUtil.initItem(this, name);
        setCreativeTab(ModTabs.TAB1);
    }

}
