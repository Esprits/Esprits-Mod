package esprits_mod.client.datagen;

import esprits_mod.tags.ModItemTags;
import esprits_mod.world.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                // TODO Not sure why this is here tbh, but I'm keeping it in case I need it (I honestly haven't looked into it yet)
                // HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                // ### WOODEN ARMOR START ###
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_HELMET, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .define('X', ModItemTags.TREE_BARK)
                        .unlockedBy(getHasNameTag(ModItemTags.TREE_BARK), has(ModItemTags.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_CHESTPLATE, 1)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .define('X', ModItemTags.TREE_BARK)
                        .unlockedBy(getHasNameTag(ModItemTags.TREE_BARK), has(ModItemTags.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_LEGGINGS, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .define('X', ModItemTags.TREE_BARK)
                        .unlockedBy(getHasNameTag(ModItemTags.TREE_BARK), has(ModItemTags.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_BOOTS, 1)
                        .pattern("X X")
                        .pattern("X X")
                        .define('X', ModItemTags.TREE_BARK)
                        .unlockedBy(getHasNameTag(ModItemTags.TREE_BARK), has(ModItemTags.TREE_BARK))
                        .save(output);
            }
        };
    }

    protected String getHasNameTag(TagKey<Item> tag) {
        return "has_" + tag.location().getPath();
    }

    @Override
    public String getName() {
        // FIXME For some reason FabricRecipeProvider doesn't have getName() overridden?
        return "Recipe Definitions";
    }
}