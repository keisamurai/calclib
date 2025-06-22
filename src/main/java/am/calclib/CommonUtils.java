package am.calclib;

import java.util.ArrayList;
import java.math.BigDecimal;

public class CommonUtils {
    @SafeVarargs
    public static <T> void checkInput(T... items) {
        int index = 0;
        ArrayList<String> errors = new ArrayList<>();
        for ( T item: items) {
            if (item == null) {
                errors.add("index: " + index + ", Input values must not be null");
            }
            if (item instanceof BigDecimal) {
                if (((BigDecimal)item).compareTo(BigDecimal.ZERO) < 0) {
                    errors.add("index: " + index + ", input must be a non-negative number:" + item);
                }
            } else if (item instanceof Integer) {
                if (((Integer)item < 0)) {
                    errors.add("index: " + index + ", input must be a non-negative: " + item);
                }
            } else {
                errors.add("index: " + index + ", Unsupported input type: " + item.getClass().getName());
            }
        };
        
        if (!errors.isEmpty()) {
            errors.forEach(System.out::println);
            throw new IllegalArgumentException("Input validation failed");
        }
    }
}
