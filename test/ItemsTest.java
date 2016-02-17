import org.junit.Test;
import play.mvc.Result;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ItemsTest {
	@Test
	public void listItems() {
		running(fakeApplication(), () -> {
			Result response = route(fakeRequest(controllers.routes.Items.list()));
			assertThat(status(response)).isEqualTo(OK);
			assertThat(contentAsString(response)).isEqualTo("[]");
		});
	}
}