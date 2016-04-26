import models.Item;
import models.Shop;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.WithApplication;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.*;

public class ItemsTest extends WithApplication {

    @Override
    protected FakeApplication provideFakeApplication() {
        return fakeApplication(inMemoryDatabase());
    }

    @Test
	public void addItem() {
        Item item = Shop.Shop.create("Item", 1.23);
        assertNotNull(item);
        assertThat(item.name).isEqualTo("Item");


    }

}