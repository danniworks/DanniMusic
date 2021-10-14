package entity;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

public class MusicQueue {

    private Queue<ArrayDeque<ByteBuffer>> queue = new ArrayDeque<>();

    public ArrayDeque<ByteBuffer> getFirstTrack() {
        return queue.poll();
    }

    public void addTrack(ArrayDeque track) {
        queue.add(track);
    }

}
