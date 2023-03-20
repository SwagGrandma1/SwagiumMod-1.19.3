package net.swaggrandma.swagiummod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagiummod.SwagiumMod;
import net.swaggrandma.swagiummod.SwagiumMod;
import net.swaggrandma.swagiummod.block.ModBlocks;
import net.swaggrandma.swagiummod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SwagiumMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_SWAGIUM);
        simpleItem(ModItems.SWAGIUM);
        simpleItem(ModItems.EIGHT_BALL);
        saplingItem(ModBlocks.SWAGIUM_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> block)
    {
        return withExistingParent(block.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SwagiumMod.MOD_ID, "block/" + block.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SwagiumMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SwagiumMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
