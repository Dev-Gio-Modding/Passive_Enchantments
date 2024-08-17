package net.devgio.passive_enchantments.mixin.ai;


import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Autovw
 */
@Mixin(PhantomEntity.class)
public abstract class PhantomAIMixin extends FlyingEntity implements Monster
{
    protected PhantomAIMixin(EntityType<? extends FlyingEntity> entityType, World level)
    {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void Phantom_tick(CallbackInfo ci)
    {
        PhantomEntity phantom = (PhantomEntity) (Object) this; // phantom (attacker)
        LivingEntity target = phantom.getTarget(); // phantom target (player)

        if (target == null)
            return;

        if (target instanceof PlayerEntity)
        {
            // return early if the attacker was angered by the target (player)
            if (phantom.getAttacker() == target)
                return;

            for (ItemStack stack : target.getArmorItems())
            {

                if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_PHANTOMS))
                {
                    phantom.setTarget(null);
                }
            }
        }
    }
}