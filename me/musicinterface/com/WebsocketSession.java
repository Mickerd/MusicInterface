package me.musicinterface.com;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

public class WebsocketSessionManager
{
  private static WebsocketSessionManager sessionManager;
  private List<WebsocketSession> sessions = new ArrayList();
  
  public static WebsocketSessionManager getSessionManager()
  {
    if (sessionManager == null) {
      sessionManager = new WebsocketSessionManager();
    }
    return sessionManager;
  }
  
  public List<WebsocketSession> getSessions()
  {
    return this.sessions;
  }
  
  public void openSession(String host)
  {
    this.sessions.add(new WebsocketSession(host));
    Bukkit.getLogger().info("Opened Websocket session: " + getSessionByHost(host));
  }
  
  public void endSession(String host)
  {
    this.sessions.remove(getSessionByHost(host));
  }
  
  public void endSessionByName(String name)
  {
    this.sessions.remove(getSessionByName(name));
  }
  
  public WebsocketSession getSessionByHost(String host)
  {
    for (WebsocketSession s : this.sessions) {
      if (s.getHost() == host) {
        return s;
      }
    }
    return null;
  }
  
  public WebsocketSession getSessionByName(String name)
  {
    for (int i = 0; i < this.sessions.size(); i++)
    {
      Bukkit.getLogger().info("Session gotten:" + this.sessions.get(i));
      if (((WebsocketSession)this.sessions.get(i)).getName().equalsIgnoreCase(name)) {
        return (WebsocketSession)this.sessions.get(i);
      }
    }
    return null;
  }
  
  public void addSessionUsername(String host, String name)
  {
    Bukkit.getLogger().info("Attemption to update session with data: " + name + " and a host of: " + host);
    for (int i = 0; i < this.sessions.size(); i++) {
      if (((WebsocketSession)this.sessions.get(i)).getHost().equalsIgnoreCase(host))
      {
        ((WebsocketSession)this.sessions.get(i)).setName(name);
        Bukkit.getLogger().info("Updated Websocket session information: " + this.sessions.get(i));
      }
    }
  }
}
