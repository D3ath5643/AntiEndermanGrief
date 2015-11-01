package d3ath5643.antiEndermanGrief;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for Anti-EndermanGrief Plugin. 
 * This will handle all the initialization need for this plugin.
 * 
 * @author d3ath5643
 * @version 1.0
 */
public class AEGMain extends JavaPlugin {

    public boolean setSpawnBlock = true, dropBlock = false;
    public MaterialData spawnBlock = new MaterialData(Material.BARRIER);
    
    @Override
    public void onEnable()
    {
        new AEGListener(this);
        AEGUtil.createConfig(this);
        AEGUtil.loadConfig(this);
    }
    
    @Override
    public void onDisable()
    {
    }
    
}
