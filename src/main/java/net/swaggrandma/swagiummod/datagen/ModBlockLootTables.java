package net.swaggrandma.swagiummod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagiummod.block.ModBlocks;
import net.swaggrandma.swagiummod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SWAGIUM_BLOCK.get());

        add(ModBlocks.SWAGIUM_ORE.get(),
                (block -> createOreDrop(ModBlocks.SWAGIUM_ORE.get(), ModItems.RAW_SWAGIUM.get())));

        add(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get(),
                (block -> createOreDrop(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get(), ModItems.RAW_SWAGIUM.get())));

        this.dropSelf(ModBlocks.SWAGIUM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SWAGIUM_LOG.get());
        this.dropSelf(ModBlocks.SWAGIUM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SWAGIUM_WOOD.get());
        this.dropSelf(ModBlocks.SWAGIUM_PLANKS.get());
        this.dropSelf(ModBlocks.SWAGIUM_SAPLING.get());

        this.add(ModBlocks.SWAGIUM_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.SWAGIUM_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
