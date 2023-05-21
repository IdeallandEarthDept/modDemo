package com.example.examplemod.gpt;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HouseBuilder {
    public static void buildWoodenHouse(int x, int y, int z, World world) {
        // 计算木屋尺寸
        int width = 7;
        int height = 5;
        int depth = 6;

        // 木板方块
        Block plankBlock = Blocks.PLANKS;

        // 构建地面
        for (int i = x - width / 2; i <= x + width / 2; i++) {
            for (int j = z - depth / 2; j <= z + depth / 2; j++) {
                world.setBlockState(new BlockPos(i, y, j), plankBlock.getDefaultState());
            }
        }

        // 构建墙壁
        for (int i = y + 1; i <= y + height; i++) {
            for (int j = x - width / 2; j <= x + width / 2; j++) {
                world.setBlockState(new BlockPos(j, i, z - depth / 2), plankBlock.getDefaultState());
                world.setBlockState(new BlockPos(j, i, z + depth / 2), plankBlock.getDefaultState());
            }
            for (int j = z - depth / 2 + 1; j <= z + depth / 2 - 1; j++) {
                world.setBlockState(new BlockPos(x - width / 2, i, j), plankBlock.getDefaultState());
                world.setBlockState(new BlockPos(x + width / 2, i, j), plankBlock.getDefaultState());
            }
        }

        // 构建屋顶
        for (int i = x - width / 2; i <= x + width / 2; i++) {
            for (int j = z - depth / 2; j <= z + depth / 2; j++) {
                world.setBlockState(new BlockPos(i, y + height + 1, j), plankBlock.getDefaultState());
            }
        }
    }
}
