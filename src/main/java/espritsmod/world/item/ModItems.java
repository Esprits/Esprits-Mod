package espritsmod.world.item;

import espritsmod.references.ModItemIDs;
import espritsmod.world.item.equipment.WoodArmorMaterial;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;

import java.util.function.Function;

public class ModItems {
    public static final Item TREE_BARK = register(
            ModItemIDs.TREE_BARK,
            Item::new,
            new Item.Properties().compostable(NumberProviders.COMPOSTABLE_LOW).cookingFuel(NumberProviders.COOKING_TIME_DRY_PLANTS));
    public static final Item WOOD_HELMET = register(
            ModItemIDs.WOOD_HELMET,
            Item::new,
            new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(WoodArmorMaterial.BASE_DURABILITY)));
    public static final Item WOOD_CHESTPLATE = register(
            ModItemIDs.WOOD_CHESTPLATE,
            Item::new,
            new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(WoodArmorMaterial.BASE_DURABILITY)));
    public static final Item WOOD_LEGGINGS = register(
            ModItemIDs.WOOD_LEGGINGS,
            Item::new,
            new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(WoodArmorMaterial.BASE_DURABILITY)));
    public static final Item WOOD_BOOTS = register(
            ModItemIDs.WOOD_BOOTS,
            Item::new,
            new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(WoodArmorMaterial.BASE_DURABILITY)));

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group
        // and register an event handler that adds tree bark to the ingredients group
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(Items.STICK, ModItems.TREE_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertBefore(Items.LEATHER_HELMET, ModItems.WOOD_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_HELMET, ModItems.WOOD_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_CHESTPLATE, ModItems.WOOD_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_LEGGINGS, ModItems.WOOD_BOOTS));
    }
}
