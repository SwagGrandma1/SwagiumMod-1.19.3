package net.swaggrandma.swagiummod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.swaggrandma.swagiummod.block.ModBlocks;
import net.swaggrandma.swagiummod.item.ModCreativeModeTabs;
import net.swaggrandma.swagiummod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SwagiumMod.MOD_ID)
public class SwagiumMod
{
    public static final String MOD_ID = "swagiummod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public SwagiumMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.SWAGIUM_TAB)
        {
            event.accept(ModItems.SWAGIUM);
            event.accept(ModItems.RAW_SWAGIUM);
            event.accept(ModItems.EIGHT_BALL);

            event.accept(ModBlocks.SWAGIUM_BLOCK);
            event.accept(ModBlocks.DEEPSLATE_SWAGIUM_ORE);
            event.accept(ModBlocks.SWAGIUM_ORE);

            event.accept(ModBlocks.SWAGIUM_LOG);
            event.accept(ModBlocks.SWAGIUM_SAPLING);
            event.accept(ModBlocks.SWAGIUM_LEAVES);
            event.accept(ModBlocks.STRIPPED_SWAGIUM_LOG);
            event.accept(ModBlocks.STRIPPED_SWAGIUM_WOOD);
            event.accept(ModBlocks.SWAGIUM_PLANKS);
            event.accept(ModBlocks.SWAGIUM_WOOD);

        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
