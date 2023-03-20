package net.swaggrandma.swagiummod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier num1, PlacementModifier num2)
    {
        return List.of(num1, InSquarePlacement.spread(), num2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int num1, PlacementModifier num2)
    {
        return orePlacement(CountPlacement.of(num1), num2);
    }

    public static List<PlacementModifier> rareOrePlacement(int num1, PlacementModifier num2)
    {
        return orePlacement(RarityFilter.onAverageOnceEvery(num1), num2);
    }
}
