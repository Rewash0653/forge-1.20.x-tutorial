package net.djwolf.mccourse.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class ExplodeItem extends Item {

    public ExplodeItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            //int radius = 1;
            //BlockPos playerPos = pPlayer.blockPosition();
            //for (int x = -radius; x <= radius; x++) {
                //for (int y = -radius; y <= radius; y++) {
                    //for (int z = -radius; z <= radius; z++) {
                        //BlockPos pos = playerPos.offset(x, y, z);
                        //BlockPos firePos = pos.above();
                        //BlockState blockState = pLevel.getBlockState(pos);
            pLevel.explode(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), 5.0f, Level.ExplosionInteraction.TNT);
                        //if ((pLevel.isEmptyBlock(firePos) || pLevel.getBlockState(firePos) == Blocks.GRASS.defaultBlockState()) && blockState.isFaceSturdy(pLevel, pos, Direction.UP)) {
                            //pLevel.setBlock(firePos, Blocks.FIRE.defaultBlockState(), 11);
                        //}
                        //pPlayer.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 3, false, false), pPlayer);
                        //pPlayer.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2000000000, 1, false, false), pPlayer);


                    }





        return super.use(pLevel, pPlayer, pUsedHand);
    }
}