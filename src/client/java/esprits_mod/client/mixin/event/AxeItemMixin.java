package esprits_mod.client.mixin.event;

import esprits_mod.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Here "@Mixin(AxeItem.class)" is kind of like extends "AxeItem.class"
// However, the way Mixin Callback Injectors work is that it will *inject* itself into the selected method
@Mixin(AxeItem.class)
public class AxeItemMixin {
    // So for example, "@Inject" here would kind of be like "@Override"
    // However, it doesn't override the original method at all, it simply goes to a location (set with "at")
    // and injects the code inside the "onUseOn" method here at that location

    // For "@At", "value" is the type of Injection Point, "INVOKE" finds "a method call and injects before it"
    // "target" is the method call INVOKE is looking for, so in this case trigger() (that comes from ItemUsedOnLocationTrigger) located in AxeItem's useOn()
    @Inject(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/triggers/ItemUsedOnLocationTrigger;trigger(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemInstance;)V"))
    void onUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        // Before CallbackInfo, you can get the original method's arguments
        // CallbackInfo ("Returnable" in this case) is essentially what "return" returns (would usually be void,
        // but you can set the variable type with "Returnable"

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();
        Block block = level.getBlockState(pos).getBlock();
        Item item;

        // Check which log type is stripped and set the item as its appropriate bark
        if (block.equals(Blocks.OAK_LOG)) {
            item = ModItems.OAK_BARK;
        } else if (block.equals(Blocks.BIRCH_LOG)) {
            item = ModItems.BIRCH_BARK;
        } else if (block.equals(Blocks.SPRUCE_LOG)) {
            item = ModItems.SPRUCE_BARK;
        } else if (block.equals(Blocks.JUNGLE_LOG)) {
            item = ModItems.JUNGLE_BARK;
        } else if (block.equals(Blocks.ACACIA_LOG)) {
            item = ModItems.ACACIA_BARK;
        } else if (block.equals(Blocks.DARK_OAK_LOG)) {
            item = ModItems.DARK_OAK_BARK;
        } else if (block.equals(Blocks.MANGROVE_LOG)) {
            item = ModItems.MANGROVE_BARK;
        } else if (block.equals(Blocks.CHERRY_LOG)) {
            item = ModItems.CHERRY_BARK;
        } else if (block.equals(Blocks.PALE_OAK_LOG)) {
            item = ModItems.PALE_OAK_BARK;
        } else if (block.equals(Blocks.CRIMSON_STEM)) {
            item = ModItems.CRIMSON_BARK;
        } else if (block.equals(Blocks.WARPED_STEM)) {
            item = ModItems.WARPED_BARK;
        } else {
            item = ModItems.OAK_BARK;
        }

        ItemStack itemStack = new ItemStack(item, UniformInt.of(1, 2).sample(level.getRandom()));

        Block.popResourceFromFace(level, pos, face, itemStack);
    }
}
