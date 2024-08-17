package net.devgio.passive_enchantments.mixin.ai;


import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PiglinBrain.class)
public class PiglinAiMixin
{




	@Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)

	private static void wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir)
	{
		for (ItemStack stack : entity.getArmorItems())
		{

			if (EnchantmentHelper.hasAnyEnchantmentsIn(stack, Enchantments.PASSIVE_PIGLIN))
			{
				cir.setReturnValue(true);
			}


		}
	}
}
