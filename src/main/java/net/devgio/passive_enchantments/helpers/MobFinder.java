package net.devgio.passive_enchantments.helpers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.*;
import java.util.Set;


public class MobFinder {

    public boolean mobFinder(LivingEntity mob) {
        Set<Class<? extends LivingEntity>> allowedMobs = Set.of(
                AllayEntity.class, ArmadilloEntity.class, AxolotlEntity.class,
                BatEntity.class, BeeEntity.class, CamelEntity.class, CatEntity.class,
                ChickenEntity.class, CodEntity.class, CowEntity.class, DolphinEntity.class,
                DonkeyEntity.class, FoxEntity.class, FrogEntity.class, GlowSquidEntity.class,
                GoatEntity.class, IronGolemEntity.class, LlamaEntity.class, MerchantEntity.class,
                MooshroomEntity.class, MuleEntity.class, OcelotEntity.class, PandaEntity.class,
                ParrotEntity.class, PigEntity.class, PolarBearEntity.class, PufferfishEntity.class,
                RabbitEntity.class, SalmonEntity.class, SheepEntity.class, SnifferEntity.class,
                SnowGolemEntity.class, SquidEntity.class, StriderEntity.class, TadpoleEntity.class,
                TraderLlamaEntity.class, TropicalFishEntity.class, TurtleEntity.class, VillagerEntity.class,
                WanderingTraderEntity.class, WolfEntity.class
        );

        return allowedMobs.contains(mob.getClass());
    }

}
