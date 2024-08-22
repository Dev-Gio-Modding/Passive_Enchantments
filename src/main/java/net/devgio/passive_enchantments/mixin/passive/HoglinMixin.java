package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.Logger;
import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
abstract
class HoglinMixin  {

    @Shadow private @Nullable LivingEntity target;

    @Shadow protected abstract @Nullable LivingEntity getTargetInBrain();

    @Inject(method = "getTarget",at = @At("HEAD"), cancellable = true)
    private void getTarget(CallbackInfoReturnable<LivingEntity> cir)
    {
        EntityType<?> type = ((MobEntity)(Object)this).getType();

        if (type == EntityType.HOGLIN) {

            HoglinEntity mob = (HoglinEntity) (Object) this;
            LivingEntity target = this.getTargetInBrain();

            if (target == null){
                Logger.LOGGER.info("test5");
                return;
            }

            if (target.isPlayer()){
                Logger.LOGGER.info("test4");
                if (mob.getAttacker() == target){
                    Logger.LOGGER.info("test3");
                    return;
                }
                for (ItemStack stack : target.getArmorItems())
                {
                    Logger.LOGGER.info("test1");
                    if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_HOGLIN)) {
                        Logger.LOGGER.info("test2");
                        cir.setReturnValue(null);
                    }
                }
            }
        }
    }
}