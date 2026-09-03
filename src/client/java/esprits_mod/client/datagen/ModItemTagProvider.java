package esprits_mod.client.datagen;

import esprits_mod.references.ModItemIDs;
import esprits_mod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(ModItemTags.TREE_BARK)
                .add(ModItemIDs.OAK_BARK)
                .add(ModItemIDs.BIRCH_BARK)
                .add(ModItemIDs.SPRUCE_BARK)
                .add(ModItemIDs.JUNGLE_BARK)
                .add(ModItemIDs.ACACIA_BARK)
                .add(ModItemIDs.DARK_OAK_BARK)
                .add(ModItemIDs.MANGROVE_BARK)
                .add(ModItemIDs.CHERRY_BARK)
                .add(ModItemIDs.PALE_OAK_BARK)
                .add(ModItemIDs.CRIMSON_BARK)
                .add(ModItemIDs.WARPED_BARK);

        builder(ModItemTags.WOOD_ARMOR)
                .add(ModItemIDs.WOOD_HELMET)
                .add(ModItemIDs.WOOD_CHESTPLATE)
                .add(ModItemIDs.WOOD_LEGGINGS)
                .add(ModItemIDs.WOOD_BOOTS);

        builder(ItemTags.HEAD_ARMOR)
                .add(ModItemIDs.WOOD_HELMET);
        builder(ItemTags.CHEST_ARMOR)
                .add(ModItemIDs.WOOD_CHESTPLATE);
        builder(ItemTags.LEG_ARMOR)
                .add(ModItemIDs.WOOD_LEGGINGS);
        builder(ItemTags.FOOT_ARMOR)
                .add(ModItemIDs.WOOD_BOOTS);

        builder(ModItemTags.REPAIRS_WOOD_ARMOR)
                .add(ModItemIDs.OAK_BARK)
                .addOptionalTag(ItemTags.PLANKS);

        builder(ItemTags.WOODEN_TOOL_MATERIALS)
                .add(ModItemIDs.OAK_BARK)
                .addOptionalTag(ItemTags.PLANKS)
                .setReplace(true);
    }
}