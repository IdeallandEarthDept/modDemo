package com.example.examplemod;

import com.example.examplemod.blocks.RegisterBlocks;
import com.example.examplemod.items.RegisterItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RegisterUtil {
    public static void initItem(Item item, String name)
    {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        RegisterItem.ITEM_LIST.add(item);
    }

    public static void initBlock(Block block, String name)
    {
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        RegisterBlocks.BLOCK_LIST.add(block);

        ItemBlock item = new ItemBlock(block);
        initItem(item, name);
    }
}
