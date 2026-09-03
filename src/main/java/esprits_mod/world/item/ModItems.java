package esprits_mod.world.item;

import esprits_mod.references.ModItemIDs;
import esprits_mod.world.item.equipment.WoodArmorMaterial;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    public static final Item OAK_BARK = registerItem(ModItemIDs.OAK_BARK);
    public static final Item WOOD_HELMET = registerItem(ModItemIDs.WOOD_HELMET, new Item.Properties()
            .humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.HELMET)
    );
    public static final Item WOOD_CHESTPLATE = registerItem(ModItemIDs.WOOD_CHESTPLATE, new Item.Properties()
            .humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
    );
    public static final Item WOOD_LEGGINGS = registerItem(ModItemIDs.WOOD_LEGGINGS, new Item.Properties()
            .humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
    );
    public static final Item WOOD_BOOTS = registerItem(ModItemIDs.WOOD_BOOTS, new Item.Properties()
            .humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.BOOTS)
    );

    public static Item registerItem(ResourceKey<Item> id) {
        return registerItem(id, Item::new, new Item.Properties());
    }

    public static Item registerItem(ResourceKey<Item> id, Item.Properties properties) {
        return registerItem(id, Item::new, properties);
    }

    public static Item registerItem(ResourceKey<Item> id, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        // Create the item instance
        Item item = itemFactory.apply(properties.setId(id));

        // Register & return the item
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group
        // and register an event handler that adds oak bark to the ingredients group
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.accept(ModItems.OAK_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(Items.STICK, ModItems.OAK_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertBefore(Items.LEATHER_HELMET, ModItems.WOOD_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_HELMET, ModItems.WOOD_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_CHESTPLATE, ModItems.WOOD_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_LEGGINGS, ModItems.WOOD_BOOTS));

        // Make the following items compostable
        CompostableRegistry.INSTANCE.add(ModItems.OAK_BARK, 0.3f);

        // Make the following items fuel
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.OAK_BARK, 100);
            builder.add(ModItems.WOOD_HELMET, 200);
            builder.add(ModItems.WOOD_CHESTPLATE, 200);
            builder.add(ModItems.WOOD_LEGGINGS, 200);
            builder.add(ModItems.WOOD_BOOTS, 200);
        });
    }
}