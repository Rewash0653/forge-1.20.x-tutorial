package net.djwolf.mccourse.enchantment;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningThornsEnchantment extends Enchantment {

    protected LightningThornsEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if(!pTarget.level().isClientSide){
            if(pLevel == 1) {
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
            }
            if(pLevel == 2) {
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
            }
            if(pLevel == 3) {
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pTarget.level(), (ItemStack) null, null, pAttacker.blockPosition(), MobSpawnType.TRIGGERED, true, true);
            }
        }



        super.doPostHurt(pTarget, pAttacker, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
