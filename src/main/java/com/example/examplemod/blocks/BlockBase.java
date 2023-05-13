package com.example.examplemod.blocks;

import com.example.examplemod.ModTabs;
import com.example.examplemod.RegisterUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setCreativeTab(ModTabs.TAB1);
        RegisterUtil.initBlock(this, name);
    }
}
