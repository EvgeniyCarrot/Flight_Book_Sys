import com.booking_system.entities.Passenger;
import com.booking_system.entities.simple_entity.Birthday;
import com.booking_system.util.HibernateAndConnectionPoolUtil;
import com.booking_system.util.MigrationUtil;
import com.booking_system.util.PropertiesUtil;
import org.hibernate.Session;

import java.time.LocalDate;

public class TestMain {
    public static void main(String[] args) {
        MigrationUtil.migrate();
        System.out.println("Миграция прошла успешно");
        System.out.println(PropertiesUtil.get("db.pass") == null ? "Плохо" : "хорошо");

        System.out.println("\n--- Начало теста аудита ---");
        try (Session session = HibernateAndConnectionPoolUtil.getSessionFactory().openSession()) {
            var tx = session.beginTransaction();

            Passenger testPassenger = Passenger.builder()
                    .firstName("Тест")
                    .lastName("Аудит")
                    .passengerMail("test_audit@example.com")
                    .loyaltyCard(false)
                    .birthday(new Birthday(LocalDate.of(2000, 1, 1)))
                    .build();

            // ✅ ВАЖНО: Сначала добавляем сущность в сессию!
            session.persist(testPassenger);

            // ✅ ВАЖНО: Затем делаем flush, чтобы сработал PreInsertEventListener
            session.flush();
            System.out.println("Сущность отправлена в БД (flush). Проверь таблицу audit_log!");

            // ОТКАТ: отменяем запись в основную таблицу passenger
            tx.rollback();
            System.out.println("Основная транзакция отменена. Пассажир не создан.");
        }
        System.out.println("--- Тест завершен. Удали тестовую запись из audit_log вручную");
    }
}
