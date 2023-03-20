package net.swaggrandma.swagiummod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.swaggrandma.swagiummod.SwagiumMod;

@Mod.EventBusSubscriber(modid = SwagiumMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab SWAGIUM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        SWAGIUM_TAB = event.registerCreativeModeTab(new ResourceLocation(SwagiumMod.MOD_ID, "swagium_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RAW_SWAGIUM.get()))
                        .title(Component.translatable("creativemodetab.swagium_tab")));
    }
}
