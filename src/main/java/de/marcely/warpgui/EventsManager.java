/**
* Adds a GUI for the essentials command /warp
* https://www.spigotmc.org/resources/essentials-warp-gui-opensource.13571/
*
* @author  Marcely1199
* @website https://marcely.de/ 
*/

package de.marcely.warpgui;

import java.util.Arrays;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.marcely.warpgui.command.WarpCommand;
import de.marcely.warpgui.config.ConfigValue;

public class EventsManager implements Listener {
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event){
		if(!ConfigValue.include_command_warps)
			return;
		
		final String[] parts = event.getMessage().split(" ");
		final String label = parts[0].replace("/", "");
		final String[] args = Arrays.copyOfRange(parts, 1, parts.length);
		
		if(label.equalsIgnoreCase("warps")){
			WarpCommand.onCommand(event.getPlayer(), label, args);
			
			event.setCancelled(true);
		}
	}
}
