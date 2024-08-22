package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HoglinEntity.class)
abstract
class HoglinTestMixin {


    @Shadow public abstract @Nullable LivingEntity getTarget();

    @Inject(method = "tryAttack",at = @At("HEAD"), cancellable = true)
    private void tryAttack(Entity entity, CallbackInfoReturnable<Boolean> cir)
    {

            HoglinEntity mob = (HoglinEntity) (Object) this;
            LivingEntity target = (LivingEntity) entity;

            if (target == null){
                return;
            }
            if (target.isPlayer()){
                if (mob.getAttacker() == target){
                    return;
                }
                for (ItemStack stack : target.getArmorItems())
                {
                    if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_HOGLIN)) {
                        cir.setReturnValue(null);
                    }
                }
            }
        }
    }
