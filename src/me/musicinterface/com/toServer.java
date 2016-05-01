package me.musicinterface.com;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class toServer
{
  public static void playToAll(String data)
  {
    for (Player p : ) {
      if (WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()) != null) {
        WebsocketServer.s.sendData(WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()), data);
      }
    }
  }
}