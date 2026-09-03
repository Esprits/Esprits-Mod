package esprits_mod.references;

import esprits_mod.EspritsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIDs {
    public static final ResourceKey<Item> OAK_BARK = create("oak_bark");
    public static final ResourceKey<Item> BIRCH_BARK = create("birch_bark");
    public static final ResourceKey<Item> SPRUCE_BARK = create("spruce_bark");
    public static final ResourceKey<Item> JUNGLE_BARK = create("jungle_bark");
    public static final ResourceKey<Item> ACACIA_BARK = create("acacia_bark");
    public static final ResourceKey<Item> DARK_OAK_BARK = create("dark_oak_bark");
    public static final ResourceKey<Item> MANGROVE_BARK = create("mangrove_bark");
    public static final ResourceKey<Item> CHERRY_BARK = create("cherry_bark");
    public static final ResourceKey<Item> PALE_OAK_BARK = create("pale_oak_bark");
    public static final ResourceKey<Item> CRIMSON_BARK = create("crimson_bark");
    public static final ResourceKey<Item> WARPED_BARK = create("warped_bark");
    public static final ResourceKey<Item> WOOD_HELMET = create("wooden_helmet");
    public static final ResourceKey<Item> WOOD_CHESTPLATE = create("wooden_chestplate");
    public static final ResourceKey<Item> WOOD_LEGGINGS = create("wooden_leggings");
    public static final ResourceKey<Item> WOOD_BOOTS = create("wooden_boots");

    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, name));
    }
}