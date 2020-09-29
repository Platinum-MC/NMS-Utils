/* 
 * PMC-NMS-Utils
 * Copyright © 2020 Platinum MC
 * 
 * PMC-NMS-Utils is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * PMC-NMS-Utils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with PMC-NMS-Utils. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Lesser General Public License.
 */
package com.platinum_mc.nms;

import java.util.Objects;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBar {

	private final String message;
	
	private ActionBar(String message) {
		this.message = message;
	}
	
	public static ActionBar of(String message) {
		return new ActionBar(Objects.requireNonNull(message, "message"));
	}
	
	public void sendTo(Player player) {
		PacketPlayOutChat packet = new PacketPlayOutChat(
				IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}"), (byte) 2);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
	
}
