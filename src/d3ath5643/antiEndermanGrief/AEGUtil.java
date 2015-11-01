package d3ath5643.antiEndermanGrief;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * Holds any utility functions used for this plugin.
 * 
 * @author d3ath5643
 * @version 1.0
 */
public class AEGUtil {
    
    public static void createConfig(AEGMain plugin)
    {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
    
    public static void loadConfig(AEGMain plugin)
    {
        String matString = plugin.getConfig().getString("spawnBlockMat");
        Material spawnBlockMat = Material.getMaterial(matString);
        byte spawnBlockData = Byte.parseByte(plugin.getConfig().getString("spawnBlockData"));
        
        if(spawnBlockMat == null)
        {
            plugin.getLogger().warning("Could not find a matching material for " + matString + 
                                       ". Use F3 + h to find the proper name");
        }
        else
        {
            plugin.spawnBlock = new MaterialData(spawnBlockMat, spawnBlockData);
            plugin.dropBlock = plugin.getConfig().getBoolean("dropBlockOnDeath");
        }
        
        if(plugin.spawnBlock.getItemType() == Material.AIR)
            plugin.setSpawnBlock = false;
        else
            plugin.dropBlock = false;
    }
}
