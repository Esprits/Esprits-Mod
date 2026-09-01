package esprits_mod.references;

import esprits_mod.EspritsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIDs {
    public static final ResourceKey<Item> TREE_BARK = create("tree_bark");
    public static final ResourceKey<Item> WOOD_HELMET = create("wooden_helmet");
    public static final ResourceKey<Item> WOOD_CHESTPLATE = create("wooden_chestplate");
    public static final ResourceKey<Item> WOOD_LEGGINGS = create("wooden_leggings");
    public static final ResourceKey<Item> WOOD_BOOTS = create("wooden_boots");

    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, name));
    }
}