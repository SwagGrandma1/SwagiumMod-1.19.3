package net.swaggrandma.swagiummod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagiummod.SwagiumMod;
import net.swaggrandma.swagiummod.item.custom.EightBallItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SwagiumMod.MOD_ID);

    public static final RegistryObject<Item> SWAGIUM = ITEMS.register("swagium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SWAGIUM = ITEMS.register("raw_swagium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties()));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
