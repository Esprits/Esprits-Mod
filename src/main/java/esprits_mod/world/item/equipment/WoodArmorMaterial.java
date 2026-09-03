package esprits_mod.world.item.equipment;

import esprits_mod.EspritsMod;
import esprits_mod.tags.ModItemTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class WoodArmorMaterial {
    public static final int BASE_DURABILITY = 2;

    public static final ResourceKey<EquipmentAsset> WOOD_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(EspritsMod.MOD_ID, "wooden"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 1,
                    ArmorType.CHESTPLATE, 1,
                    ArmorType.LEGGINGS, 1,
                    ArmorType.BOOTS, 1
            ),
            10,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            0.0F,
            0.0F,
            ModItemTags.REPAIRS_WOOD_ARMOR,
            WOOD_ARMOR_MATERIAL_KEY
    );
}