package com.example.examplemod.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeBase extends Biome {
    public BiomeBase(String name) {
        super(new BiomeProperties(name));
        setRegistryName(name);
        RegBiomes.list.add(this);
    }
}
