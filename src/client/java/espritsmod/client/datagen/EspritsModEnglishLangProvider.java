package espritsmod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EspritsModEnglishLangProvider extends FabricLanguageProvider {
    protected EspritsModEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.esprits-mod.tree_bark", "Tree Bark");

        translationBuilder.add("item.esprits-mod.wooden_helmet", "Wooden Helmet");
        translationBuilder.add("item.esprits-mod.wooden_chestplate", "Wooden Chestplate");
        translationBuilder.add("item.esprits-mod.wooden_leggings", "Wooden Leggings");
        translationBuilder.add("item.esprits-mod.wooden_boots", "Wooden Boots");
    }
}
