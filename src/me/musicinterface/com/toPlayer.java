package me.musicinterface.com;

import org.bukkit.entity.Player;

public class toPlayer
{
  public static void playToPlayer(Player p, String data)
  {
    if (WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()) != null) {
      WebsocketServer.s.sendData(WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()), data);
    }
  }
}
