package net.devgio.passive_enchantments.helpers;

import net.devgio.passive_enchantments.enchantments.Enchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.registry.tag.TagKey;
import java.util.Map;
import java.util.HashMap;


public class EnchantmentFinder {

    public TagKey<Enchantment> mobEnchantment(LivingEntity mob) {

        Class<?> mobClass = mob.getClass();
        Map<Class<?>, TagKey<Enchantment>> enchantmentMap = new HashMap<>() {{
            put(BlazeEntity.class, Enchantments.PASSIVE_BLAZE);
            put(BreezeEntity.class, Enchantments.PASSIVE_BREEZE);
            put(TransientCreakingEntity.class, Enchantments.PASSIVE_CREAKING);
            put(CreakingEntity.class, Enchantments.PASSIVE_CREAKING);
            put(CreeperEntity.class, Enchantments.PASSIVE_CREEPER);
            put(EndermanEntity.class, Enchantments.PASSIVE_ENDERMAN);
            put(EndermiteEntity.class, Enchantments.PASSIVE_ENDERMITE);
            put(GuardianEntity.class, Enchantments.PASSIVE_GUARDIAN);
            put(HoglinEntity.class, Enchantments.PASSIVE_HOGLIN);
            put(PhantomEntity.class, Enchantments.PASSIVE_PHANTOM);
            put(PiglinEntity.class, Enchantments.PASSIVE_PIGLIN);
            put(PiglinBruteEntity.class, Enchantments.PASSIVE_PIGLIN_BRUTE);
            put(ShulkerEntity.class, Enchantments.PASSIVE_SHULKER);
            put(SilverfishEntity.class, Enchantments.PASSIVE_SILVERFISH);
            put(SlimeEntity.class, Enchantments.PASSIVE_SLIME);
            put(SkeletonEntity.class, Enchantments.PASSIVE_SKELETON);
            put(StrayEntity.class, Enchantments.PASSIVE_SKELETON);
            put(BoggedEntity.class, Enchantments.PASSIVE_SKELETON);
            put(SpiderEntity.class, Enchantments.PASSIVE_SPIDER);
            put(CaveSpiderEntity.class, Enchantments.PASSIVE_SPIDER);
            put(VexEntity.class, Enchantments.PASSIVE_VEX);
            put(ZoglinEntity.class, Enchantments.PASSIVE_ZOGLIN);
            // For patrol entities
            put(PillagerEntity.class, Enchantments.PASSIVE_PATROL);
            put(RavagerEntity.class, Enchantments.PASSIVE_PATROL);
            put(VindicatorEntity.class, Enchantments.PASSIVE_PATROL);
            put(EvokerEntity.class, Enchantments.PASSIVE_PATROL);
            put(IllusionerEntity.class, Enchantments.PASSIVE_PATROL);
            put(WitchEntity.class, Enchantments.PASSIVE_PATROL);
        }};

// Fetch the enchantment based on the mob's class or default to ZOMBIE enchantment

        return enchantmentMap.getOrDefault(mobClass, Enchantments.PASSIVE_ZOMBIE);
    }

    public TagKey<Enchantment> curse = Enchantments.AGGRESSION_CURSE;



}
