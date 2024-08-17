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
    public static final RegistryKey<Enchantment> PASSIVE_PIGLIN_ENCHANTMENT = Enchantments.of("passive_piglin");
    public static final RegistryKey<Enchantment> PASSIVE_ENDERMAN_ENCHANTMENT = Enchantments.of("passive_enderman");
    public static final RegistryKey<Enchantment> PASSIVE_PHANTOM_ENCHANTMENT = Enchantments.of("passive_phantom");
    public static final RegistryKey<Enchantment> PASSIVE_ZOMBIE_ENCHANTMENT = Enchantments.of("passive_zombie");
    public static final RegistryKey<Enchantment> PASSIVE_BLAZE_ENCHANTMENT = Enchantments.of("passive_blaze");
    public static final RegistryKey<Enchantment> PASSIVE_SKELETON_ENCHANTMENT = Enchantments.of("passive_skeleton");

    //Enchantment Tags, used instead of getting level
    public static final TagKey<Enchantment> PASSIVE_PIGLIN = enchantmentTagKeyOf("passive_piglin");
    public static final TagKey<Enchantment> PASSIVE_ENDERMAN = enchantmentTagKeyOf("passive_enderman");
    public static final TagKey<Enchantment> PASSIVE_PHANTOM = enchantmentTagKeyOf("passive_phantom");
    public static final TagKey<Enchantment> PASSIVE_ZOMBIE = enchantmentTagKeyOf("passive_zombie");
    public static final TagKey<Enchantment> PASSIVE_BLAZE = enchantmentTagKeyOf("passive_blaze");
    public static final TagKey<Enchantment> PASSIVE_SKELETON = enchantmentTagKeyOf("passive_skeleton");

    //For Logger
    public static final List<RegistryKey<Enchantment>> PASSIVE_ENCHANTMENTS = List.of(PASSIVE_ENDERMAN_ENCHANTMENT, PASSIVE_PHANTOM_ENCHANTMENT, PASSIVE_ZOMBIE_ENCHANTMENT, PASSIVE_PIGLIN_ENCHANTMENT, PASSIVE_BLAZE_ENCHANTMENT, PASSIVE_SKELETON_ENCHANTMENT);


    //for RegistryKey and TagKey
    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    private static TagKey<Enchantment> enchantmentTagKeyOf(String id) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    }



