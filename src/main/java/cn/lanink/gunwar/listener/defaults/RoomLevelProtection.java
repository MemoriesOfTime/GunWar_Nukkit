package cn.lanink.gunwar.listener.defaults;

import cn.lanink.gamecore.listener.BaseGameListener;
import cn.lanink.gunwar.room.base.BaseRoom;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.block.*;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityExplodeEvent;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.event.inventory.CraftItemEvent;
import cn.nukkit.event.inventory.InventoryPickupArrowEvent;
import cn.nukkit.event.inventory.StartBrewEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.event.player.PlayerFoodLevelChangeEvent;
import cn.nukkit.level.Level;

/**
 * 游戏地图保护
 * @author lt_name
 */
@SuppressWarnings("unused")
public class RoomLevelProtection extends BaseGameListener<BaseRoom> {

    /**
     * 物品合成事件
     * @param event 事件
     */
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        Level level = event.getPlayer() == null ? null : event.getPlayer().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 开始酿造事件
     * @param event 事件
     */
    @EventHandler
    public void onStartBrew(StartBrewEvent event) {
        Level level = event.getBrewingStand() == null ? null : event.getBrewingStand().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 方块放置事件
     * @param event 事件
     */
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Level level = event.getPlayer() == null ? null : event.getPlayer().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 方块破坏事件
     * @param event 事件
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Level level = event.getPlayer() == null ? null : event.getPlayer().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 方块自然衰落事件
     * @param event 事件
     */
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        Level level = event.getBlock() == null ? null : event.getBlock().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 方块被烧毁事件
     * @param event 事件
     */
    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        Level level = event.getBlock() == null ? null : event.getBlock().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 方块被点燃事件
     * @param event 事件
     */
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        Level level = event.getBlock() == null ? null : event.getBlock().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 实体爆炸事件
     * @param event 事件
     */
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        Level level = event.getEntity() == null ? null : event.getEntity().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 饥饿值变化事件
     * @param event 事件
     */
    @EventHandler
    public void onFoodLevelChange(PlayerFoodLevelChangeEvent event) {
        Level level = event.getPlayer() == null ? null : event.getPlayer().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 丢出物品事件
     * @param event 事件
     */
    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Level level = event.getPlayer() == null ? null : event.getPlayer().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 伤害事件
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDamage(EntityDamageEvent event) {
        Level level = event.getEntity() == null ? null : event.getEntity().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            for (EntityDamageEvent.DamageModifier modifier : EntityDamageEvent.DamageModifier.values()) {
                event.setDamage(0, modifier);
            }
        }
    }

    /**
     * 收起发射出去的箭事件
     * @param event 事件
     */
    @EventHandler
    public void onPickupArrow(InventoryPickupArrowEvent event) {
        Level level = event.getArrow() == null ? null : event.getArrow().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setCancelled();
        }
    }

    /**
     * 当一个抛射物击中物体时
     * @param event 事件
     */
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Level level = event.getEntity() == null ? null : event.getEntity().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.getEntity().close();
        }
    }

    /**
     * 玩家死亡事件
     * @param event 事件
     */
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Level level = event.getEntity() == null ? null : event.getEntity().getLevel();
        if (level != null && this.getListenerRooms().containsKey(level.getFolderName())) {
            event.setKeepInventory(true);
            event.setKeepExperience(true);
        }
    }

}
