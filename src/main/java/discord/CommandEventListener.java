package discord;

import entity.MusicState;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import service.observer.DiscordAudioHandler;
import service.subject.MusicPlayer;

public class CommandEventListener extends ListenerAdapter implements Executor {

        private CommandInterpreter commandInterpreter;
        private MusicPlayer musicPlayer;
        private DiscordAudioHandler discordAudioHandler;

        public CommandEventListener() {
                this.commandInterpreter = new CommandInterpreter();
                this.musicPlayer = new MusicPlayer();
                this.discordAudioHandler = new DiscordAudioHandler(musicPlayer);
        }

        @Override
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
                if(event.getAuthor().isBot()) return;
                String command = event.getMessage().getContentRaw();
                try {
                        execute(event, commandInterpreter.interpret(command));
                } catch (Exception e) {

                }
        }

        @Override
        public void execute(GuildMessageReceivedEvent event, MusicState state) {
                if (MusicState.class.isInstance(state)) {
                        musicPlayer.loadMusic();
                        discordAudioHandler.setCurrentTrack(musicPlayer.getMusicQueue().getFirstTrack());
                        VoiceChannel voiceChannel = event.getMember().getVoiceState().getChannel();
                        AudioManager audioManager = event.getGuild().getAudioManager();
                        audioManager.setSendingHandler(discordAudioHandler);
                        audioManager.openAudioConnection(voiceChannel);
                        state.execute(musicPlayer);
                }
        }
}
