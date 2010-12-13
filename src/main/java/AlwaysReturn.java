import com.sun.grizzly.tcp.Adapter;
import com.sun.grizzly.tcp.OutputBuffer;
import com.sun.grizzly.tcp.Request;
import com.sun.grizzly.tcp.Response;
import com.sun.grizzly.util.buf.ByteChunk;

import java.io.IOException;

public class AlwaysReturn implements Adapter {
    private HttpAnswer answer;

    public AlwaysReturn(HttpAnswer answer) {
        this.answer = answer;
    }

    public void service(Request request, Response response) throws Exception {
        answer.writeTo(response);
    }

    public void afterService(Request request, Response response) throws Exception {}
}
