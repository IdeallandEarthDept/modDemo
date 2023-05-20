package com.example.examplemod.blocks;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class RegisterBlocks {

    public static final List<Block> BLOCK_LIST = new ArrayList<>();

    public static final Block BLOCK_1 = new BlockBase("block_1",Material.ROCK);
    public static final Block BLOCK_2 = new BlockBase("block_2",Material.ROCK).setLightLevel(1.0f);
    public static final Block BLOCK_LADDER = new BlockLadderCustom();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BLOCK_LIST.toArray(new Block[0]));
    }
}
