package com.example.examplemod.events;

import com.example.examplemod.blocks.RegisterBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ColorRegister {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerColor(ColorHandlerEvent.Block event) {
        event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
                if (pos != null && worldIn instanceof ChunkCache) {
                    return getLeavesColorForPos((ChunkCache) worldIn, pos);
                }
                if (pos != null && worldIn instanceof World) {
                    return getLeavesColorForPos((World) worldIn, pos);
                }
                else {
                    return 0xff00ff;
                }
            }
        }, RegisterBlocks.BLOCK_1);
    }

    public static int getLeavesColorForPos(ChunkCache world, BlockPos pos)
    {
        Biome biome = world.getBiome(pos);
        return biome.getModdedBiomeFoliageColor(biome.getFoliageColorAtPos(pos));
    }

    public static int getLeavesColorForPos(World world, BlockPos pos)
    {
        Biome biome = world.getBiome(pos);
        return biome.getModdedBiomeFoliageColor(biome.getFoliageColorAtPos(pos));
    }

}
