import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class HtmlScreenBehaviorTest {

    @Test
    public void shouldRenderAnHtmlDocument() throws Exception {
        assertThat(new HtmlScreen().render(),is("<html><body></body></html>") );
    }
}
