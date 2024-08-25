package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.Logger;
import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(HoglinEntity.class)
public abstract class HoglinMixin {


    @Inject(method = "tryAttack",at = @At("HEAD"), cancellable = true)
    private void onAttacking(Entity target, CallbackInfoReturnable<Boolean> cir)
    {

        Logger.LOGGER.info("test");

        HoglinEntity hoglin = (HoglinEntity) (Object) this;
        Brain<HoglinEntity> brain = hoglin.getBrain();



        if (target == null){
                return;
            }
            if (target.isPlayer()){
                PlayerEntity player = (PlayerEntity) target;

                if (hoglin.getAttacker() == target){
                    Logger.LOGGER.info("test if hoglin was attacked");
                    return;
                }

                for (ItemStack stack : player.getArmorItems())
                {
                    if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_HOGLIN)) {

                        Logger.LOGGER.info("test cancel");
                        brain.forget(MemoryModuleType.ATTACK_TARGET);


                        cir.setReturnValue(false);




                    }
                }
            }
        }
    }
