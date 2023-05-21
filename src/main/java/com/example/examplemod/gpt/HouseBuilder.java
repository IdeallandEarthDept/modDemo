package com.example.examplemod.gpt;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
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
        // 玻璃方块
        Block glassBlock = Blocks.GLASS;
        // 木门方块
        Block doorBlock = Blocks.OAK_DOOR;
        // 楼梯方块
        Block stairBlock = Blocks.OAK_STAIRS;

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
        for (int i = y + height + 1; i <= y + height + 3; i++) {
            int roofWidth = width - 2 * (i - (y + height + 1));
            int roofDepth = depth - 2 * (i - (y + height + 1));
            for (int j = x - roofWidth / 2; j <= x + roofWidth / 2; j++) {
                for (int k = z - roofDepth / 2; k <= z + roofDepth / 2; k++) {
                    if (j == x - roofWidth / 2 || j == x + roofWidth / 2 || k == z - roofDepth / 2 || k == z + roofDepth / 2) {
                        if ((j == x - roofWidth / 2 && k == z - roofDepth / 2) || (j == x + roofWidth / 2 && k == z + roofDepth / 2)) {
                            world.setBlockState(new BlockPos(j, i, k), stairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
                        } else if ((j == x + roofWidth / 2 && k == z - roofDepth / 2) || (j == x - roofWidth / 2 && k == z + roofDepth / 2)) {
                            world.setBlockState(new BlockPos(j, i, k), stairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH));
                        } else if (j == x - roofWidth / 2) {
                            world.setBlockState(new BlockPos(j, i, k), stairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
                        } else if (j == x + roofWidth / 2) {
                            world.setBlockState(new BlockPos(j, i, k), stairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
                        }
                    } else {
                        world.setBlockState(new BlockPos(j, i, k), plankBlock.getDefaultState());
                    }
                }
            }
        }

        // 添加窗户
        for (int i = y + 2; i <= y + 3; i++) {
            world.setBlockState(new BlockPos(x - width / 2, i, z), glassBlock.getDefaultState());
            world.setBlockState(new BlockPos(x + width / 2, i, z), glassBlock.getDefaultState());
        }
        for (int j = x - width / 2 + 1; j <= x + width / 2 - 1; j++) {
            world.setBlockState(new BlockPos(j, y + 2, z - depth / 2), glassBlock.getDefaultState());
            world.setBlockState(new BlockPos(j, y + 3, z - depth / 2), glassBlock.getDefaultState());
            world.setBlockState(new BlockPos(j, y + 2, z + depth / 2), glassBlock.getDefaultState());
            world.setBlockState(new BlockPos(j, y + 3, z + depth / 2), glassBlock.getDefaultState());
        }

        // 添加门
        BlockDoor.EnumDoorHalf upperHalf = BlockDoor.EnumDoorHalf.UPPER;
        world.setBlockState(new BlockPos(x, y + 1, z - depth / 2), Blocks.AIR.getDefaultState());
        world.setBlockState(new BlockPos(x, y + 2, z - depth / 2), Blocks.AIR.getDefaultState());
        world.setBlockState(new BlockPos(x, y + 1, z - depth / 2), doorBlock.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.NORTH).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER));
        world.setBlockState(new BlockPos(x, y + 2, z - depth / 2), doorBlock.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.NORTH).withProperty(BlockDoor.HALF, upperHalf));
    }
}
