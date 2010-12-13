import com.sun.grizzly.tcp.OutputBuffer;
import com.sun.grizzly.tcp.Response;
import com.sun.grizzly.util.buf.ByteChunk;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpAnswer {
    private static final int OK = 200;
    private static final String EMPTY_BODY = "";
    private int status;
    private String body;
    private String contentType;

    public HttpAnswer(int status, String body, String contentType) {
        this.status = status;
        this.body = body;
        this.contentType = contentType;
    }

    public static HttpAnswer with(String body) {
        return new HttpAnswer(OK, body, "text/html");
    }

    public static HttpAnswer ok() {
        return new HttpAnswer(OK, EMPTY_BODY, "text/html");
    }

    public void writeTo(Response response) throws IOException {
        response.setStatus(status);
        response.setContentType(contentType);
        response.doWrite(bodyAsByteChunk());
    }

    private ByteChunk bodyAsByteChunk() throws UnsupportedEncodingException {
        ByteChunk chunk = new ByteChunk(body.length());
        chunk.setBytes(body.getBytes("UTF-8"), 0, body.length());
        return chunk;
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
