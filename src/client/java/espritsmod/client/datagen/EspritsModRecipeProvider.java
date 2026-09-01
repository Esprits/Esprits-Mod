package espritsmod.client.datagen;

import espritsmod.references.ModItemIDs;
import espritsmod.world.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class EspritsModRecipeProvider extends FabricRecipeProvider {
    public EspritsModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shaped(RecipeCategory.COMBAT, ModItems.WOOD_HELMET, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .define('X', ModItems.TREE_BARK)
                        .unlockedBy(getHasName(ModItems.TREE_BARK), has(ModItems.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_CHESTPLATE, 1)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .define('X', ModItems.TREE_BARK)
                        .unlockedBy(getHasName(ModItems.TREE_BARK), has(ModItems.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_LEGGINGS, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .define('X', ModItems.TREE_BARK)
                        .unlockedBy(getHasName(ModItems.TREE_BARK), has(ModItems.TREE_BARK))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WOOD_BOOTS, 1)
                        .pattern("X X")
                        .pattern("X X")
                        .define('X', ModItems.TREE_BARK)
                        .unlockedBy(getHasName(ModItems.TREE_BARK), has(ModItems.TREE_BARK))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
