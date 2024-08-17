package net.devgio.passive_enchantments.mixin.ai;


import net.devgio.passive_enchantments.Logger;
import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Autovw
 */
@Mixin(BlazeEntity.class)
public abstract class BlazeAIMixin extends HostileEntity
{
    protected BlazeAIMixin(EntityType<? extends HostileEntity> entityType, World level)
    {
        super(entityType, level);
    }




    @Inject(method = "mobTick", at = @At("HEAD"))
    private void Blaze_tick(CallbackInfo ci)
    {

        BlazeEntity mob = (BlazeEntity) (Object) this;
        LivingEntity target = mob.getTarget();


        if (target == null)
            return;

        if (target instanceof PlayerEntity)
        {

            if (mob.getAttacker() == target)
                return;

            for (ItemStack stack : target.getArmorItems())
            {

                if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_BLAZE))
                {

                    mob.setTarget(null);
                }
            }
        }
    }
}