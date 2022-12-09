package emanondev.itemedit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.List;
import java.util.stream.Collectors;

public final class UtilMiniMessage {

    public static String serialize(Component component) {
        return MiniMessage.miniMessage().serialize(component);
    }

    public static List<String> serialize(List<Component> component) {
        return component.stream().map(MiniMessage.miniMessage()::serialize).collect(Collectors.toList());
    }

    public static Component deserialize(String miniMessage) {
        return MiniMessage.miniMessage().deserialize(miniMessage);
    }

    public static List<Component> deserialize(List<String> miniMessages) {
        return miniMessages.stream().map(MiniMessage.miniMessage()::deserialize).collect(Collectors.toList());
    }
}
