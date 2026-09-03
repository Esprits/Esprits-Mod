package esprits_mod.tags;

import esprits_mod.EspritsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> WOOD_ARMOR = bind("wooden_armor");
    public static final TagKey<Item> TREE_BARK = bind("tree_bark");
    public static final TagKey<Item> REPAIRS_WOOD_ARMOR = bind("repairs_wood_armor");

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, name));
    }
}
