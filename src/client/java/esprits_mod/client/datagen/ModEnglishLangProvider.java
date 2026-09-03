package esprits_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    protected ModEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.esprits_mod.oak_bark", "Oak Bark");
        translationBuilder.add("item.esprits_mod.birch_bark", "Birch Bark");
        translationBuilder.add("item.esprits_mod.spruce_bark", "Spruce Bark");
        translationBuilder.add("item.esprits_mod.jungle_bark", "Jungle Bark");
        translationBuilder.add("item.esprits_mod.acacia_bark", "Acacia Bark");
        translationBuilder.add("item.esprits_mod.dark_oak_bark", "Dark Oak Bark");
        translationBuilder.add("item.esprits_mod.mangrove_bark", "Mangrove Bark");
        translationBuilder.add("item.esprits_mod.cherry_bark", "Cherry Bark");
        translationBuilder.add("item.esprits_mod.pale_oak_bark", "Pale Oak Bark");
        translationBuilder.add("item.esprits_mod.crimson_bark", "Crimson Bark");
        translationBuilder.add("item.esprits_mod.warped_bark", "Warped Bark");

        translationBuilder.add("item.esprits_mod.wooden_helmet", "Wooden Helmet");
        translationBuilder.add("item.esprits_mod.wooden_chestplate", "Wooden Chestplate");
        translationBuilder.add("item.esprits_mod.wooden_leggings", "Wooden Leggings");
        translationBuilder.add("item.esprits_mod.wooden_boots", "Wooden Boots");
    }
}