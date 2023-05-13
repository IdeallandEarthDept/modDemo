package com.example.examplemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RegisterBlocks {
    public static final List<Block> BLOCK_LIST = new ArrayList<>();
    public static final Block TEST = new Block(Material.ANVIL).setRegistryName("block1");

    @SubscribeEvent
    public static void handleBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(TEST);
        event.getRegistry().registerAll(BLOCK_LIST.toArray(new Block[0]));
    }
}
