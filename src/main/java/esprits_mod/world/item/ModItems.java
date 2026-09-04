package esprits_mod.world.item;

import esprits_mod.references.ModItemIDs;
import esprits_mod.tags.ModItemTags;
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
    // ### TREE BARK START ###
    public static final Item OAK_BARK = registerItem(ModItemIDs.OAK_BARK);
    public static final Item BIRCH_BARK = registerItem(ModItemIDs.BIRCH_BARK);
    public static final Item SPRUCE_BARK = registerItem(ModItemIDs.SPRUCE_BARK);
    public static final Item JUNGLE_BARK = registerItem(ModItemIDs.JUNGLE_BARK);
    public static final Item ACACIA_BARK = registerItem(ModItemIDs.ACACIA_BARK);
    public static final Item DARK_OAK_BARK = registerItem(ModItemIDs.DARK_OAK_BARK);
    public static final Item MANGROVE_BARK = registerItem(ModItemIDs.MANGROVE_BARK);
    public static final Item CHERRY_BARK = registerItem(ModItemIDs.CHERRY_BARK);
    public static final Item PALE_OAK_BARK = registerItem(ModItemIDs.PALE_OAK_BARK);
    public static final Item CRIMSON_BARK = registerItem(ModItemIDs.CRIMSON_BARK);
    public static final Item WARPED_BARK = registerItem(ModItemIDs.WARPED_BARK);

    // ### WOODEN HELMET START ###
    public static final Item WOOD_HELMET = registerItem(ModItemIDs.WOOD_HELMET, new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.HELMET));
    public static final Item WOOD_CHESTPLATE = registerItem(ModItemIDs.WOOD_CHESTPLATE, new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.CHESTPLATE));
    public static final Item WOOD_LEGGINGS = registerItem(ModItemIDs.WOOD_LEGGINGS, new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.LEGGINGS));
    public static final Item WOOD_BOOTS = registerItem(ModItemIDs.WOOD_BOOTS, new Item.Properties().humanoidArmor(WoodArmorMaterial.INSTANCE, ArmorType.BOOTS));

    // ### REGISTER ITEM OVERLOADS START ###
    public static Item registerItem(ResourceKey<Item> id) {
        return registerItem(id, Item::new, new Item.Properties());
    }

    public static Item registerItem(ResourceKey<Item> id, Item.Properties properties) {
        return registerItem(id, Item::new, properties);
    }

    public static Item registerItem(ResourceKey<Item> id, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {
        // ### CREATIVE TAB START ###
        // TODO Separate this into its own file
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(Items.STICK, ModItems.OAK_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.OAK_BARK, ModItems.BIRCH_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.BIRCH_BARK, ModItems.SPRUCE_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.SPRUCE_BARK, ModItems.JUNGLE_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.JUNGLE_BARK, ModItems.ACACIA_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.ACACIA_BARK, ModItems.DARK_OAK_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.DARK_OAK_BARK, ModItems.MANGROVE_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.MANGROVE_BARK, ModItems.CHERRY_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.CHERRY_BARK, ModItems.PALE_OAK_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.PALE_OAK_BARK, ModItems.CRIMSON_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.insertAfter(ModItems.CRIMSON_BARK, ModItems.WARPED_BARK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertBefore(Items.LEATHER_HELMET, ModItems.WOOD_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_HELMET, ModItems.WOOD_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_CHESTPLATE, ModItems.WOOD_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.insertAfter(ModItems.WOOD_LEGGINGS, ModItems.WOOD_BOOTS));

        // ### COMPOSTABLE START ###
        // FIXME Have to do all items one by one instead of the #esprits:tree_bark tag :v (see net.fabricmc.fabric.impl.content.registry.CompostableRegistryImpl:39 lmao)
        CompostableRegistry.INSTANCE.add(ModItems.OAK_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.BIRCH_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.SPRUCE_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.JUNGLE_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.ACACIA_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.DARK_OAK_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.MANGROVE_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.CHERRY_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.PALE_OAK_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.CRIMSON_BARK, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.WARPED_BARK, 0.3f);

        // ### FUEL START ###
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItemTags.TREE_BARK, 100);
            builder.add(ModItems.WOOD_HELMET, 200);
            builder.add(ModItems.WOOD_CHESTPLATE, 200);
            builder.add(ModItems.WOOD_LEGGINGS, 200);
            builder.add(ModItems.WOOD_BOOTS, 200);
        });
    }
}