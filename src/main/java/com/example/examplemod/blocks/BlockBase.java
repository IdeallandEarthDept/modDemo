package com.example.examplemod.blocks;

import com.example.examplemod.ModTabs;
import com.example.examplemod.RegisterUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(Material materialIn, String name) {
        super(materialIn);
        RegisterUtil.initBlock(this, name);
        setCreativeTab(ModTabs.TAB1);
    }
}
