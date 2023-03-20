package net.swaggrandma.swagiummod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagiummod.SwagiumMod;
import net.swaggrandma.swagiummod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SwagiumMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SWAGIUM_BLOCK);
        blockWithItem(ModBlocks.SWAGIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SWAGIUM_ORE);
        
        logBlock(((RotatedPillarBlock) ModBlocks.SWAGIUM_LOG.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.SWAGIUM_WOOD.get(), blockTexture(ModBlocks.SWAGIUM_LOG.get()), blockTexture(ModBlocks.SWAGIUM_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_SWAGIUM_LOG.get(), new ResourceLocation(SwagiumMod.MOD_ID, "block/stripped_swagium_log"),
                new ResourceLocation(SwagiumMod.MOD_ID, "block/stripped_swagium_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_SWAGIUM_WOOD.get(), new ResourceLocation(SwagiumMod.MOD_ID, "block/stripped_swagium_log"),
                new ResourceLocation(SwagiumMod.MOD_ID, "block/stripped_swagium_log"));


        blockWithItem(ModBlocks.SWAGIUM_PLANKS);
        blockWithItem(ModBlocks.SWAGIUM_LEAVES);

        saplingBlock(ModBlocks.SWAGIUM_SAPLING);

        simpleBlockItem(ModBlocks.SWAGIUM_LOG.get(), models().withExistingParent("swagiummod:swagium_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.SWAGIUM_WOOD.get(), models().withExistingParent("swagiummod:swagium_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_SWAGIUM_LOG.get(), models().withExistingParent("swagiummod:stripped_swagium_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_SWAGIUM_WOOD.get(), models().withExistingParent("swagiummod:stripped_swagium_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
