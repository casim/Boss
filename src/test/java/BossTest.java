import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Test;

public class BossTest {

    private static final int PORT = 8080;
    private Boss boss;

    @Test
    public void shouldAnswerHttpCall() throws Exception {
        boss = new Boss(PORT, new BlankScreen());
        HttpAnswer answer = Http.callOn(PORT);

        assertThat(answer,is(HttpAnswer.ok()));
    }

    @Test
    public void shouldAnswerWithHtmlDocument() throws Exception {
        HtmlScreen screen = new HtmlScreen();
        boss = new Boss(PORT, screen);
        assertThat(Http.callOn(PORT),is(HttpAnswer.with(screen.render())));
    }

    @After
    public void tearDown() throws Exception {
        boss.stop();
    }



}
