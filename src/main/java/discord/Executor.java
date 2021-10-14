package discord;

import entity.MusicState;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface Executor {
    void execute(GuildMessageReceivedEvent event, MusicState state);
}
