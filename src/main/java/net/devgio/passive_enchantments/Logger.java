package net.devgio.passive_enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import static net.devgio.passive_enchantments.enchantments.Enchantments.PASSIVE_ENCHANTMENTS;

public class Logger {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("Passive Enchantments");



    public static void logger() {

        for (RegistryKey<Enchantment> enchantment : PASSIVE_ENCHANTMENTS) {

            String nameold = enchantment.getValue().toString();

            String[] name1 = nameold.split(":");

            String[] name2 = name1[1].split("_");

            String name3 =  StringUtils.capitalize(name2[0]);
            String name4 =  StringUtils.capitalize(name2[1]);


            String name = String.join(" ", name3, name4);

            Logger.LOGGER.info("Registered Enchantment: " + name);
        }


    }


}
