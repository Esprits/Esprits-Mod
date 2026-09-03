package esprits_mod.client.datagen;

import esprits_mod.EspritsMod;
import esprits_mod.references.ModItemIDs;
import esprits_mod.world.item.equipment.WoodArmorMaterial;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class EspritsModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> WOOD_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, "wooden_armor"));

    public EspritsModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(WOOD_ARMOR)
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

        builder(WoodArmorMaterial.REPAIRS_WOOD_ARMOR)
                .add(ModItemIDs.TREE_BARK)
                .addOptionalTag(ItemTags.PLANKS);

        builder(ItemTags.WOODEN_TOOL_MATERIALS)
                .add(ModItemIDs.TREE_BARK)
                .addOptionalTag(ItemTags.PLANKS)
                .setReplace(true);
    }
}