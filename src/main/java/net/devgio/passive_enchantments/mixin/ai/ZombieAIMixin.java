package net.devgio.passive_enchantments.mixin.ai;


import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Autovw
 */
@Mixin(ZombieEntity.class)
public abstract class ZombieAIMixin extends HostileEntity implements Monster
{
    protected ZombieAIMixin(EntityType<? extends HostileEntity> entityType, World level)
    {
        super(entityType, level);
    }




    @Inject(method = "tick", at = @At("HEAD"))
    private void Zombie_tick(CallbackInfo ci)
    {

        ZombieEntity mob = (ZombieEntity) (Object) this;
        LivingEntity target = mob.getTarget();

        if (target == null)
            return;

        if (target instanceof PlayerEntity)
        {

            if (mob.getAttacker() == target)
                return;

            for (ItemStack stack : target.getArmorItems())
            {

                if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_ZOMBIE))
                {
                    mob.setTarget(null);
                }
            }
        }
    }
}