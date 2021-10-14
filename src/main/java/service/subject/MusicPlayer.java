package service.subject;

import entity.MusicQueue;
import entity.MusicState;
import util.OpusBufferUtil;

public class MusicPlayer extends AbstractSubject {

    private MusicState DEFAULT_STATE = MusicState.Play;
    private OpusBufferUtil opusBufferUtil;
    private MusicQueue musicQueue;

    public MusicPlayer() {
        setState(DEFAULT_STATE);
        this.opusBufferUtil = new OpusBufferUtil();
        this.musicQueue = new MusicQueue();
    }

    public MusicQueue getMusicQueue() {
        return this.musicQueue;
    }

    public void loadMusic() {
        opusBufferUtil.setupFrameLengthQueue();
        musicQueue.addTrack(opusBufferUtil.getFrameLengthQueue());
    }
}
