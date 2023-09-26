package gsonexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application {
    public static void main(String[] args) {
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(new Person("Patrik", "Norris")));
    }
}
