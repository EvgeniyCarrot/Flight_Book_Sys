import com.booking_system.util.MigrationUtil;
import com.booking_system.util.PropertiesUtil;

public class TestMain {
    static void main(String[] args) {
        MigrationUtil.migrate();
        System.out.println("Миграция прошла успешно");
        System.out.println(PropertiesUtil.get("db.pass") == null ? "Плохо" : "хорошо");
    }
}
