package net.devgio.passive_enchantments.mixin.passive;

import net.devgio.passive_enchantments.helpers.EnchantmentFinder;
import net.devgio.passive_enchantments.helpers.MobFinder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;




@Mixin(TargetPredicate.class)
abstract
class MobMixin {

    @Inject(method = "test",at = @At("HEAD"), cancellable = true)
    private void onTargetTest(LivingEntity mob, LivingEntity target, CallbackInfoReturnable<Boolean> cir)
    {
        if (target == null){
                return;
        }
        if (target.isPlayer()){
            PlayerEntity player = (PlayerEntity) target;

            for (ItemStack stack : player.getArmorItems()) {
                TagKey<Enchantment> enchantment = new EnchantmentFinder().mobEnchantment(mob);
                TagKey<Enchantment> curse = new EnchantmentFinder().curse;
                boolean hasEnchantment = EnchantmentHelper.hasAnyEnchantmentsIn(stack, enchantment);
                boolean hasCurse = EnchantmentHelper.hasAnyEnchantmentsIn(stack, curse);

                if (hasCurse) {
                    cir.setReturnValue(true);
                } else {
                    boolean mobFinder = new MobFinder().mobFinder(mob);
                    if (mobFinder) {
                        if (mob.getAttacker() == target){
                            cir.setReturnValue(false);
                        } else {
                        cir.setReturnValue(false);
                        }
                    }
                    else if (hasEnchantment) {
                        if (mob.getAttacker() == target){
                            return;
                        } else {
                            cir.setReturnValue(false);
                        }
                    }
                }
            }
        }
    }
}