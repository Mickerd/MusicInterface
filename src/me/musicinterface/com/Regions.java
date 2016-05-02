package me.musicinterface.com;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class Regions
  implements Listener
{
  @EventHandler(priority=EventPriority.NORMAL)
  public void onRegionEnter(RegionEnterEvent e)
  {
    ProtectedRegion r = e.getRegion();
    e.getPlayer().performCommand("interface toplayer " + e.getPlayer().getName() + " " + r.getId());
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onRegionLeae(RegionLeaveEvent e)
  {
    e.getPlayer().performCommand("interface toplayer " + e.getPlayer().getName() + " stop");
  }
}
