package cz.fel.omo.smarthome.configurations;

/**
 * The type Gson.
 */
public class Gson {
    public static com.google.gson.Gson gson = new com.google.gson.Gson();
    
    /**
     * To json string.
     *
     * @param object the object
     * @return the string
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }
    
    /**
     * From json t.
     *
     * @param <T>  the type parameter
     * @param json the json
     * @param type the type
     * @return the object
     */
    public static <T> T fromJson(String json, T type) {
        return (T) gson.fromJson(json, type.getClass());
    }
}
