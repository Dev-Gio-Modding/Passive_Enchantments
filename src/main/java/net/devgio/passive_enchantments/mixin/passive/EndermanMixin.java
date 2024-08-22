package net.devgio.passive_enchantments.mixin.passive;


import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(EndermanEntity.class)
public abstract class EndermanMixin extends HostileEntity implements Angerable
{


    protected EndermanMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "isPlayerStaring", at = @At("HEAD"), cancellable = true)

    private void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> cir)
    {
        for (ItemStack stack : player.getArmorItems())
        {

            if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_ENDERMAN))
            {
                cir.setReturnValue(false);
            }


        }
    }
}
