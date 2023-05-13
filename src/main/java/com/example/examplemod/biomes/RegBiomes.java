package com.example.examplemod.biomes;

import com.example.examplemod.ExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class RegBiomes {

    public static List<Biome> list = new ArrayList<>();

    public static final Biome biome = new BiomeBase("new_biome");
    public static final Biome biome2 = new BiomeBase("new_biome2");

    static void initBiomes()
    {
        //Mess up, may skip
        biome.topBlock = Blocks.LAPIS_BLOCK.getDefaultState();
        BiomeManager.addSpawnBiome(biome);
        //add to overworld, standard rate = 10
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                new BiomeManager.BiomeEntry(biome, 9999));
    }

    static void postRegBiomes()
    {
        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD);
    }

    @SubscribeEvent
    public static void regBiomes(RegistryEvent.Register<Biome> event)
    {
        initBiomes();

        event.getRegistry().registerAll(list.toArray(new Biome[0]));

        postRegBiomes();
    }
}
