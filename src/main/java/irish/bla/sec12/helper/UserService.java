package irish.bla.sec12.helper;

import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {
    private static Map<String,String> map = Map.of(
            "sam","std",
            "mike","prime"
    );

    public static Function<Context,Context> userCategoryContext() {
        return context -> {
            String user = context.get("user").toString();
            String category = map.get(user);
            return context.put("category",category);
        };
    }
}
