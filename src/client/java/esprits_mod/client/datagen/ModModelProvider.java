package esprits_mod.client.datagen;

import esprits_mod.world.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.OAK_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WOOD_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WOOD_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WOOD_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WOOD_BOOTS, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}