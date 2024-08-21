    package net.devgio.passive_enchantments.mixin.passive;

    import net.devgio.passive_enchantments.enchantments.Enchantments;
    import net.minecraft.enchantment.EnchantmentHelper;
    import net.minecraft.entity.EntityType;
    import net.minecraft.entity.LivingEntity;
    import net.minecraft.entity.mob.*;
    import net.minecraft.item.ItemStack;
    import org.jetbrains.annotations.Nullable;
    import org.spongepowered.asm.mixin.Mixin;
    import org.spongepowered.asm.mixin.Shadow;
    import org.spongepowered.asm.mixin.injection.At;
    import org.spongepowered.asm.mixin.injection.Inject;
    import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

    @Mixin(MobEntity.class)
    abstract
    class PhantomMixin {

        @Shadow private @Nullable LivingEntity target;

        @Inject(method = "getTarget", at = @At("HEAD"), cancellable = true)
        private void getTarget(CallbackInfoReturnable<Boolean> cir) {

            if (EntityType.PHANTOM == ((MobEntity)(Object)this).getType()) {

                PhantomEntity mob = (PhantomEntity) (Object) this;
                LivingEntity target = this.target;

                if (target == null){
                    return;
                }

                if (target.isPlayer()){
                    if (mob.getAttacker() == target){
                        return;
                    }
                    for (ItemStack stack : target.getArmorItems()) {

                        if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_PHANTOM)) {
                            cir.setReturnValue(null);
                        }
                    }
                }

            }
        }
    }