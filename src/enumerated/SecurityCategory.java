package enumerated;

import net.mindview.util.Enums;

/**
 * Created by nanca on 10/4/2017.
 * More succinct subcategorization of enums.
 */
enum SecurityCategory {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }
        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelecion() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " +
                    category.randomSelecion());
        }
    }
}
