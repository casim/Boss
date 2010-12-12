import com.sun.grizzly.tcp.Adapter;
import com.sun.grizzly.tcp.OutputBuffer;
import com.sun.grizzly.tcp.Request;
import com.sun.grizzly.tcp.Response;
import com.sun.grizzly.util.buf.ByteChunk;

import java.net.HttpURLConnection;

public class AlwaysReturn implements Adapter {
    private byte[] messageBody;

    public AlwaysReturn(HttpAnswer answer) {
        this.messageBody = answer.getBody().getBytes();
    }

    public void service(Request request, Response response) throws Exception {
        ByteChunk chunk = new ByteChunk();
        response.setContentLength(messageBody.length);
        response.setContentType("text/plain");
        chunk.append(messageBody, 0, messageBody.length);
        OutputBuffer buffer = response.getOutputBuffer();
        buffer.doWrite(chunk, response);
        response.finish();
    }

    public void afterService(Request request, Response response) throws Exception {

    }
}
