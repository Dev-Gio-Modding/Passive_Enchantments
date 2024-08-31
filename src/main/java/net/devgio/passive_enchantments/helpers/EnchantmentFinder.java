package net.devgio.passive_enchantments.helpers;

import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.registry.tag.TagKey;

public class EnchantmentFinder {

    public TagKey<net.minecraft.enchantment.Enchantment> mobEnchantment(LivingEntity mob) {

        if (mob instanceof BlazeEntity) return Enchantments.PASSIVE_BLAZE;
        else if (mob instanceof BreezeEntity) return Enchantments.PASSIVE_BREEZE;
        else if (mob instanceof CreeperEntity) return Enchantments.PASSIVE_CREEPER;
        else if (mob instanceof EndermanEntity) return Enchantments.PASSIVE_ENDERMAN;
        else if (mob instanceof EndermiteEntity) return Enchantments.PASSIVE_ENDERMITE;
        else if (mob instanceof GuardianEntity) return Enchantments.PASSIVE_GUARDIAN;
        else if (mob instanceof HoglinEntity) return Enchantments.PASSIVE_HOGLIN;
        else if (mob instanceof PillagerEntity || mob instanceof RavagerEntity || mob instanceof VindicatorEntity || mob instanceof EvokerEntity || mob instanceof IllusionerEntity || mob instanceof WitchEntity) return Enchantments.PASSIVE_PATROL;
        else if (mob instanceof PhantomEntity) return Enchantments.PASSIVE_PHANTOM;
        else if (mob instanceof PiglinEntity) return Enchantments.PASSIVE_PIGLIN;
        else if (mob instanceof PiglinBruteEntity) return Enchantments.PASSIVE_PIGLIN_BRUTE;
        else if (mob instanceof ShulkerEntity) return Enchantments.PASSIVE_SHULKER;
        else if (mob instanceof SilverfishEntity) return Enchantments.PASSIVE_SILVERFISH;
        else if (mob instanceof SlimeEntity) return Enchantments.PASSIVE_SLIME;
        else if (mob instanceof SkeletonEntity || mob instanceof StrayEntity || mob instanceof BoggedEntity) return Enchantments.PASSIVE_SKELETON;
        else if (mob instanceof SpiderEntity || mob instanceof CaveSpiderEntity) return Enchantments.PASSIVE_SPIDER;
        else if (mob instanceof VexEntity) return Enchantments.PASSIVE_VEX;
        else if (mob instanceof ZoglinEntity) return Enchantments.PASSIVE_ZOGLIN;
        else if (mob instanceof ZombieEntity || mob instanceof DrownedEntity || mob instanceof HuskEntity || mob instanceof ZombieVillagerEntity) return Enchantments.PASSIVE_ZOMBIE;



        else return Enchantments.NOT_PASSIVE;
    }


}
