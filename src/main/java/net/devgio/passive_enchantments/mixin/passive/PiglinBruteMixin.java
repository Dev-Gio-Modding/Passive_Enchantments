package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TargetPredicate.class)
abstract class PiglinBruteMixin {



    @Inject(method = "test",at = @At("HEAD"), cancellable = true)
    private void onTargetTest(LivingEntity mob, LivingEntity target, CallbackInfoReturnable<Boolean> cir)
    {
        if (mob instanceof PiglinBruteEntity){
            if (target == null){
                return;
            }
            if (target.isPlayer()){
                PlayerEntity player = (PlayerEntity) target;
                if (mob.getAttacker() == target){
                    return;
                }
                for (ItemStack stack : player.getArmorItems())
                {
                    if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_HOGLIN)) {
                        cir.setReturnValue(false);
                    }
                }
            }
        }
    }
}