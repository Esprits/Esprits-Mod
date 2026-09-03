package esprits_mod.client.mixin.event;

import esprits_mod.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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
        ItemStack itemStack = new ItemStack(ModItems.OAK_BARK, UniformInt.of(1, 2).sample(level.getRandom()));

        Block.popResourceFromFace(level, pos, face, itemStack);
    }
}
