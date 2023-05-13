package com.example.examplemod.biomes;

import com.example.examplemod.ExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class RegBiomes {

    @SubscribeEvent
    public static void regBiomes(RegistryEvent.Register<Biome> event)
    {
        Biome.BiomeProperties properties = new Biome.BiomeProperties("new_biome");
        //Mess up, may skip
        properties.setBaseHeight(-0.5f).setWaterColor(0xffffff).setHeightVariation(1.0f);

        Biome biome = new BiomeBase(properties);
        biome.setRegistryName("new_biome");

        //Mess up, may skip
        biome.topBlock = Blocks.LAPIS_BLOCK.getDefaultState();
        BiomeManager.addSpawnBiome(biome);
        //add to overworld, standard rate = 10
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                new BiomeManager.BiomeEntry(biome, 9999));

        //must register first
        event.getRegistry().register(biome);

        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD);
    }
}
