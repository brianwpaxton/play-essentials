package controllers;

import models.CreateItem;
import models.Item;
import models.Shop;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import java.util.Collection;

public class Application extends Controller {

  public static Result index()  {
    return ok(views.html.main.render());
  }

  public static Result details(Long id) {
    Item item = Shop.Shop.get(id);
    if (item != null) {
      return ok(views.html.details.render(item));
    } else {
      return notFound();
    }
  }

  public static Result list() {
    Collection<Item> items = Shop.Shop.list();
    return ok(views.html.list.render(items));
  }

  public static  Result addForm() {
    Form<CreateItem> form = Form.form(CreateItem.class);
    return ok(views.html.addForm.render(form));
  }

}
