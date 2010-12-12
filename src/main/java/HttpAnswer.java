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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HttpAnswer answer = (HttpAnswer) o;

        if (status != answer.status) return false;
        if (body != null ? !body.equals(answer.body) : answer.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Status: %d, Body: %s",status,body);
    }

    public String getBody() {
        return body;
    }
}
