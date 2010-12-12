import com.sun.grizzly.http.SelectorThread;

import java.io.IOException;

public class Boss {
    private SelectorThread selectorThread;

    public static void main(String... args) throws Exception{
        new Boss(11111,new HtmlScreen());
    }

    public Boss(int port, Screen screen) throws IOException, InstantiationException {
        selectorThread = new SelectorThread();
        selectorThread.setPort(port);
        HttpAnswer answer = HttpAnswer.with(screen.render());
        selectorThread.setAdapter(new AlwaysReturn(answer));
        selectorThread.listen();
    }

    public void stop() {
        selectorThread.stopEndpoint();
    }
}
