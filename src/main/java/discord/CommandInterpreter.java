package discord;

import entity.MusicState;

public class CommandInterpreter {

    private final static String PLAY = "!dplay";
    private final static String RESUME = "!dresume";
    private final static String SKIP = "!dskip";
    private final static String PAUSE = "!dpause";
    private final static MusicState DEFAULT_STATE = MusicState.Play;

    public MusicState interpret(String message) {
        String[] command = message.split(" ");
        String prefix = command[0];
        switch (prefix) {
            case PLAY:
                return MusicState.Play;
            case RESUME:
                return MusicState.Resume;
            case SKIP:
                return MusicState.Skip;
            case PAUSE:
                return MusicState.Pause;
        }
        return DEFAULT_STATE;
    }
}
