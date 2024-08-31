package net.devgio.passive_enchantments.mixin.aggressive;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChickenEntity.class)
public abstract class ChickenMixin extends MobEntity {
//doesnt work
    @Unique
    ChickenEntity mob = (ChickenEntity) (Object) this;
    protected ChickenMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals",at = @At("HEAD"))
    protected void initAttack(CallbackInfo ci){
    this.goalSelector.add(1, new MeleeAttackGoal(mob, 1.00, false));
    this.goalSelector.add(2, new ActiveTargetGoal<>(mob, PlayerEntity.class, true, true));


    }


}
