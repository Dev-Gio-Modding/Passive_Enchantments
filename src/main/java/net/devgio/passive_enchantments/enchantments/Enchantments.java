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
    public static final RegistryKey<Enchantment> PASSIVE_PIGLINS_ENCHANTMENT = Enchantments.of("passive_piglins");
    public static final RegistryKey<Enchantment> PASSIVE_ENDERMEN_ENCHANTMENT = Enchantments.of("passive_piglins");
    public static final RegistryKey<Enchantment> PASSIVE_PHANTOMS_ENCHANTMENT = Enchantments.of("passive_piglins");
    public static final RegistryKey<Enchantment> PASSIVE_ZOMBIES_ENCHANTMENT = Enchantments.of("passive_zombies");

    //Enchantment Tags, used instead of getting level
    public static final TagKey<Enchantment> PASSIVE_PIGLINS = enchantmentTagKeyOf("passive_piglins");
    public static final TagKey<Enchantment> PASSIVE_ENDERMEN = enchantmentTagKeyOf("passive_endermen");
    public static final TagKey<Enchantment> PASSIVE_PHANTOMS = enchantmentTagKeyOf("passive_phantoms");
    public static final TagKey<Enchantment> PASSIVE_ZOMBIES = enchantmentTagKeyOf("passive_zombies");

    //For Logger
    public static final List<RegistryKey<Enchantment>> PASSIVE_ENCHANTMENTS = List.of(PASSIVE_ENDERMEN_ENCHANTMENT, PASSIVE_PHANTOMS_ENCHANTMENT, PASSIVE_ZOMBIES_ENCHANTMENT, PASSIVE_PIGLINS_ENCHANTMENT);


    //for RegistryKey and TagKey
    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    private static TagKey<Enchantment> enchantmentTagKeyOf(String id) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(PassiveEnchantments.MOD_ID, id));
    }

    }



