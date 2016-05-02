package me.musicinterface.com;

import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.java_websocket.server.WebSocketServer;

public class m
  extends JavaPlugin
{
  public static FileConfiguration f = null;
  
  public void onEnable()
  {
    getCommand("interface").setExecutor(new commandHandler());
    getCommand("url").setExecutor(new Url());
    f = getConfig();
    Bukkit.getServer().getPluginManager().registerEvents(new Regions(), this);
    try
    {
      WebsocketServer.runServer();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    saveConfig();
    reloadConfig();
  }
  
  public void onDisable()
  {
    saveConfig();
    reloadConfig();
  }
}
