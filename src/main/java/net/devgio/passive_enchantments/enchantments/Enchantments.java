package net.devgio.passive_enchantments.enchantments;

import net.devgio.passive_enchantments.PassiveEnchantments;
import net.minecraft.enchantment.Enchantment;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;



public class Enchantments {

    //For List
    public static final RegistryKey<Enchantment> PASSIVE_BLAZE_ENCHANTMENT = Enchantments.of("passive_blaze");
    public static final RegistryKey<Enchantment> PASSIVE_BREEZE_ENCHANTMENT = Enchantments.of("passive_breeze");
    public static final RegistryKey<Enchantment> PASSIVE_CREEPER_ENCHANTMENT = Enchantments.of("passive_creeper");
    public static final RegistryKey<Enchantment> PASSIVE_ENDERMAN_ENCHANTMENT = Enchantments.of("passive_enderman");
    public static final RegistryKey<Enchantment> PASSIVE_ENDERMITE_ENCHANTMENT = Enchantments.of("passive_endermite");
    public static final RegistryKey<Enchantment> PASSIVE_PHANTOM_ENCHANTMENT = Enchantments.of("passive_phantom");
    public static final RegistryKey<Enchantment> PASSIVE_PIGLIN_ENCHANTMENT = Enchantments.of("passive_piglin");
    public static final RegistryKey<Enchantment> PASSIVE_SHULKER_ENCHANTMENT = Enchantments.of("passive_shulker");
    public static final RegistryKey<Enchantment> PASSIVE_SKELETON_ENCHANTMENT = Enchantments.of("passive_skeleton");
    public static final RegistryKey<Enchantment> PASSIVE_SLIME_ENCHANTMENT = Enchantments.of("passive_slime");
    public static final RegistryKey<Enchantment> PASSIVE_SPIDER_ENCHANTMENT = Enchantments.of("passive_spider");
    public static final RegistryKey<Enchantment> PASSIVE_ZOMBIE_ENCHANTMENT = Enchantments.of("passive_zombie");

    //Enchantment Tags, used instead of getting level
    public static final TagKey<Enchantment> PASSIVE_BLAZE = enchantmentTagKeyOf("passive_blaze");
    public static final TagKey<Enchantment> PASSIVE_BREEZE = enchantmentTagKeyOf("passive_breeze");
    public static final TagKey<Enchantment> PASSIVE_CREEPER = enchantmentTagKeyOf("passive_creeper");
    public static final TagKey<Enchantment> PASSIVE_ENDERMAN = enchantmentTagKeyOf("passive_enderman");
    public static final TagKey<Enchantment> PASSIVE_ENDERMITE = enchantmentTagKeyOf("passive_endermite");
    public static final TagKey<Enchantment> PASSIVE_PHANTOM = enchantmentTagKeyOf("passive_phantom");
    public static final TagKey<Enchantment> PASSIVE_PIGLIN = enchantmentTagKeyOf("passive_piglin");
    public static final TagKey<Enchantment> PASSIVE_SHULKER = enchantmentTagKeyOf("passive_shulker");
    public static final TagKey<Enchantment> PASSIVE_SKELETON = enchantmentTagKeyOf("passive_skeleton");
    public static final TagKey<Enchantment> PASSIVE_SLIME = enchantmentTagKeyOf("passive_slime");
    public static final TagKey<Enchantment> PASSIVE_SPIDER = enchantmentTagKeyOf("passive_spider");
    public static final TagKey<Enchantment> PASSIVE_ZOMBIE = enchantmentTagKeyOf("passive_zombie");

    //For Logger
    public static final List<RegistryKey<Enchantment>> PASSIVE_ENCHANTMENTS = List.of(
            PASSIVE_BLAZE_ENCHANTMENT,
            PASSIVE_BREEZE_ENCHANTMENT,
            PASSIVE_CREEPER_ENCHANTMENT,
            PASSIVE_ENDERMAN_ENCHANTMENT,
            PASSIVE_ENDERMITE_ENCHANTMENT,
            PASSIVE_PHANTOM_ENCHANTMENT,
            PASSIVE_PIGLIN_ENCHANTMENT,
            PASSIVE_SHULKER_ENCHANTMENT,
            PASSIVE_SKELETON_ENCHANTMENT,
            PASSIVE_SLIME_ENCHANTMENT,
            PASSIVE_SPIDER_ENCHANTMENT,
            PASSIVE_ZOMBIE_ENCHANTMENT
    );


    //for RegistryKey and TagKey
    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    private static TagKey<Enchantment> enchantmentTagKeyOf(String id) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    }



