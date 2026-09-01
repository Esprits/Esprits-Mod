package espritsmod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EspritsModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EspritsModModelProvider::new);
		pack.addProvider(EspritsModRecipeProvider::new);
		pack.addProvider(EspritsModEnglishLangProvider::new);
		pack.addProvider(EspritsModItemTagProvider::new);
	}
}
