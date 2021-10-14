package util;

import org.gagravarr.opus.OpusAudioData;
import org.gagravarr.opus.OpusFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public class OpusBufferUtil {

    private String path = "C:\\Users\\Daniel\\Desktop\\DanniMusic\\example\\DanniMusic\\src\\main\\java\\util\\out.opus";
    private File file = new File(path);
    private ArrayDeque<ByteBuffer> frameLengthQueue = new ArrayDeque<>();

    public void setupFrameLengthQueue() {
        try {
            OpusFile opusFile = new OpusFile(file);
            OpusAudioData opusData;
            while ((opusData = opusFile.getNextAudioPacket()) != null) {
                byte[] bytes = opusData.getData();
                ByteBuffer frame = ByteBuffer.wrap(bytes);
                frameLengthQueue.add(frame);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayDeque<ByteBuffer> getFrameLengthQueue() {
        return frameLengthQueue;
    }
}
