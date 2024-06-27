package net.djwolf.mccourse.event;

import net.djwolf.mccourse.MCCourseMod;
import net.djwolf.mccourse.command.ReturnHomeCommand;
import net.djwolf.mccourse.command.SetHomeCommand;
import net.djwolf.mccourse.enchantment.ModEnchantments;
import net.djwolf.mccourse.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if (pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }

        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("mccourse.homepos",
                event.getOriginal().getPersistentData().getIntArray("mccourse.homepos"));
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Sheep) {
            if (event.getSource().getDirectEntity() instanceof Player player) {
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() != Items.AIR) {
                    MCCourseMod.LOGGER.info("Sheep was hit with " + player.getItemInHand(InteractionHand.MAIN_HAND).getItem() + " by " + player.getName().getString());
                } else if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.AIR) {
                    MCCourseMod.LOGGER.info("Sheep was hit by " + player.getName().getString());
                }

            }
        }
    }

    @SubscribeEvent
    public static void test(ProjectileImpactEvent event){
        Player player = ((Player) event.getProjectile().getOwner());
        Entity arrow = event.getEntity();
        if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof BowItem || player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof CrossbowItem) {
            if(player.getItemInHand(InteractionHand.MAIN_HAND).isEnchanted()){
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(ModEnchantments.BOW_TELEPORT.get()) > 0){
                    event.getProjectile().getOwner().teleportTo(arrow.getX(), arrow.getY(), arrow.getZ());
                }
            }

        }
    }


}