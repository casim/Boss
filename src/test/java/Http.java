import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public class Http {
    private static final String HOST = "http://localhost";

    public static HttpAnswer callOn(int port) throws IOException {
        WebClient client = new WebClient();
        Page page = client.getPage(HOST + ":" + port);

        String content = page.getWebResponse().getContentAsString("UTF-8");
        int status = page.getWebResponse().getStatusCode();
        return new HttpAnswer(status, content, "text/html");
    }
}
