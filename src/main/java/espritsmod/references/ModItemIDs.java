package espritsmod.references;

import espritsmod.EspritsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIDs {
    public static final ResourceKey<Item> TREE_BARK = create("tree_bark");

    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, name));
    }
}
