import models.Shop;
import play.Application;
import play.GlobalSettings;

/**
 * Created by bpaxton on 23/02/2016.
 */
public class Global extends GlobalSettings {
    @Override
    public void onStart(Application app) {
        super.onStart(app);
        if (Shop.Shop.list().isEmpty()) {
            Shop.Shop.create("An Item", 10.34);
            Shop.Shop.create("Another Item", 9.99);
        }
    }
}
