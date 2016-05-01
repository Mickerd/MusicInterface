package me.musicinterface.com;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Url
  implements CommandExecutor
{
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    FileConfiguration file = m.f;
    Player p = (Player)arg0;
    String url = String.valueOf(file.get("url"));
    List<String> message = file.getStringList("message");
    arg0.sendMessage("http://audio.casrietveld.nl/index.html?name=" + p.getName());
    

    return false;
  }
}
