package me.musicinterface.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandHandler
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("Please specify some more arguments!");
    }
    else if (args.length > 0)
    {
      if (args[0].equalsIgnoreCase("toplayer"))
      {
        Player p = Bukkit.getPlayer(args[1]);
        toPlayer.playToPlayer(p, args[2]);
      }
    }
    else if (args.length > 0)
    {
      if (args[0].equalsIgnoreCase("stop"))
      {
        Player p = Bukkit.getPlayer(args[1]);
        toPlayer.playToPlayer(p, "s");
      }
    }
    else if (args.length > 0)
    {
      if (args[0].equalsIgnoreCase("toserver")) {
        for (Player p : Bukkit.getOnlinePlayers()) {
          toServer.playToAll(args[1]);
        }
      }
      return false;
    }
    return false;
  }
}
