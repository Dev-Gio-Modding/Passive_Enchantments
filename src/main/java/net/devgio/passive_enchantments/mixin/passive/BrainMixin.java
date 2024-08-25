package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.Logger;
import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.Memory;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
//doesnt work

@Mixin(Brain.class)
public abstract class BrainMixin {
    @Inject(method = "setMemory", at = @At("HEAD"), cancellable = true)
    private <U> void setMemoryInternal(MemoryModuleType<U> moduleType, Optional<? extends Memory<?>> memory, CallbackInfo callback) {

        EntityType<?> type = ((MobEntity) (Object) this).getType();

        if (type == EntityType.HOGLIN) {

            HoglinEntity hoglin = (HoglinEntity) (Object) this;
            LivingEntity target = hoglin.getTarget();


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
                        if (moduleType == MemoryModuleType.ATTACK_TARGET)
                            callback.cancel();
                    }
                }
            }
        }

    }
}
