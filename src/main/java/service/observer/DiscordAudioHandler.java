package service.observer;

import entity.MusicState;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import org.jetbrains.annotations.Nullable;
import service.subject.MusicPlayer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public class DiscordAudioHandler extends AbstractObserver implements AudioSendHandler {

    public ArrayDeque<ByteBuffer> currentTrack;

    public DiscordAudioHandler(MusicPlayer musicPlayer) {
        this.subject = musicPlayer;
        this.subject.attach(this);
    }

    public void setCurrentTrack(ArrayDeque<ByteBuffer> track) {
        currentTrack = track;
    }

    @Override
    public void update() {
        //TODO
    }

    @Override
    public boolean canProvide() {
        if (subject.getState() == MusicState.Play || subject.getState() == MusicState.Resume) {
            if (currentTrack.size() > 0) {
                return true;
            } else {
                return false;
            }
        } else if (subject.getState() == MusicState.Pause) {
            return false;
        }
        return false;
    }

    @Nullable
    @Override
    public ByteBuffer provide20MsAudio() {
        ByteBuffer frame = currentTrack.pollLast();
        return frame;
    }
}
