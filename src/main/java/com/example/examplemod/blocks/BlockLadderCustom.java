package com.example.examplemod.blocks;

import com.example.examplemod.RegisterUtil;
import net.minecraft.block.BlockLadder;

public class BlockLadderCustom extends BlockLadder {
    public BlockLadderCustom() {
        RegisterUtil.initBlock(this, "test_ladder");
    }
}
