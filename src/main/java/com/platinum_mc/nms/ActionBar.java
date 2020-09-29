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
