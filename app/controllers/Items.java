package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.*;

public class Items extends Controller {
    
    static final Shop shop = Shop.Shop;
    
    public static Result list() {
        return ok(views.html.list.render(shop.list()));
    }

	public static Result createForm() {
		return ok(views.html.addForm.render(Form.form(CreateItem.class)));
	}

	@BodyParser.Of(BodyParser.FormUrlEncoded.class)
    public static Result create() {
		Form<CreateItem> submission = Form.form(CreateItem.class).bindFromRequest();
		if (submission.hasErrors()) {
			return badRequest(views.html.addForm.render(submission));
		}

		CreateItem createItem;
		
		try {
			createItem = submission.get();
		} catch (RuntimeException e) {
			return badRequest();
		} 
		
		Item item = shop.create(createItem.name, createItem.price);
		if (item != null) {
			return ok(views.html.details.render(item));
		} else {
			return internalServerError();
		}
    }
    
    public static Result details(Long id) {
        Item item = shop.get(id);
        if(item != null) {
            return ok(views.html.details.render(item));
        } else {
            return notFound();
        }
    }
    
	@BodyParser.Of(BodyParser.Json.class)
    public static Result update(Long id) {
		JsonNode json = request().body().asJson();
		
		CreateItem updateItem;
		try {
			updateItem = Json.fromJson(json, CreateItem.class);
		} catch (RuntimeException e) {
			return badRequest();
		}
		
        Item item = shop.update(id, updateItem.name, updateItem.price);
		if (item != null) {
			return ok(Json.toJson(item));
		} else {
			return internalServerError();
		}
    }
    
    public static Result delete(Long id) {
        return status(NOT_IMPLEMENTED);
    }
}