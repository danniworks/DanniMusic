package server;

import discord.CommandEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class BotServer {

    private final String ACTIVITY = "!dplay";
    private JDABuilder jdaBuilder;
    private JDA jda;

    //Temp Var
    private String token = "";

    public BotServer() {
        CommandEventListener eventListener = new CommandEventListener();
        this.jdaBuilder = JDABuilder.createDefault(token,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_VOICE_STATES)
                .addEventListeners(eventListener)
                .setActivity(Activity.playing(ACTIVITY));
    }

    public void init() throws LoginException, InterruptedException {
        this.jda = jdaBuilder.build();
        jda.awaitReady();
    }

    public static void main(String[] args) {
        BotServer server = new BotServer();
        try {
            server.init();
        } catch (LoginException e) {
            //TODO
        } catch (InterruptedException e) {
            //TODO
        }
    }
}
