package d3ath5643.antiEndermanGrief;

import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Used to drop the block that an enderman has, set the held block 
 * when an enderman spawn, and stop an enderman from placing a block.
 * 
 * @author d3ath5643
 * @version 1.0
 */
public class AEGListener implements Listener {

    private AEGMain plugin;
    
    public AEGListener(AEGMain plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e)
    {
        if(plugin.dropBlock && e.getEntityType() == EntityType.ENDERMAN)
        {
            Enderman entity = (Enderman) e.getEntity();
            if(entity.getCarriedMaterial().getItemType() != Material.AIR)
            {
              ItemStack heldItem = new ItemStack(entity.getCarriedMaterial().getItemType());
              entity.getWorld().dropItem(entity.getLocation(), heldItem);  
            }
        }
    }
    
    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent e)
    {
        if(plugin.setSpawnBlock && e.getEntityType() == EntityType.ENDERMAN)
            ((Enderman) e.getEntity()).setCarriedMaterial(plugin.spawnBlock);
    }
    
    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e)
    {
        if(plugin.setSpawnBlock && e.getEntityType() == EntityType.ENDERMAN)
            e.setCancelled(true);
    }    
}
