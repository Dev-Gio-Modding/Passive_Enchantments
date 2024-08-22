package net.devgio.passive_enchantments.mixin.passive;


import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BreezeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BreezeEntity.class)
public abstract class BreezeMixin extends HostileEntity
{
    protected BreezeMixin(EntityType<? extends HostileEntity> entityType, World level)
    {
        super(entityType, level);
    }




    @Inject(method = "canTarget", at = @At("HEAD"), cancellable = true)
    private void Breeze_tick(CallbackInfoReturnable<LivingEntity> cir)
    {

        BreezeEntity mob = (BreezeEntity) (Object) this;
        LivingEntity target = mob.getTarget();


        if (target == null)
            return;

        if (target instanceof PlayerEntity)
        {

            if (mob.getAttacker() == target)
                return;

            for (ItemStack stack : target.getArmorItems())
            {

                if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_BREEZE))
                {

                    cir.setReturnValue(null);
                  //  mob.setTarget(null);
                }
            }
        }
    }
}