package com.booking_system.audit;

import com.booking_system.entities.AuditEntity;
import com.booking_system.enums.Operation;
import com.booking_system.util.HibernateAndConnectionPoolUtil;
import com.booking_system.util.JsonMapper;
import org.hibernate.event.spi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AuditTableEventListener implements PreInsertEventListener, PreDeleteEventListener, PreUpdateEventListener {

    private static final Logger logger = LoggerFactory.getLogger(AuditTableEventListener.class);

    @Override
    public boolean onPreDelete(PreDeleteEvent preDeleteEvent) {
        return auditTable(preDeleteEvent, Operation.DELETE);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        return auditTable(preInsertEvent, Operation.INSERT);
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        return auditTable(preUpdateEvent, Operation.UPDATE);
    }

    public boolean auditTable(AbstractPreDatabaseOperationEvent event, Operation operation) {
        if (event.getEntity() instanceof AuditEntity) {
            return false;
        }

        String jsonObject = "{}";
        try {
            if (event instanceof PreUpdateEvent updateEvent) {
                jsonObject = writeUpdateJson(updateEvent);
            }
            if (event instanceof PreDeleteEvent deleteEvent) {
                jsonObject = JsonMapper.writeObjectAsString(deleteEvent.getEntity());
            }
            if (event instanceof PreInsertEvent insertEvent) {
                jsonObject = JsonMapper.writeObjectAsString(insertEvent.getEntity());
            }

            var auditLog = AuditEntity.builder()
                    .entityId(String.valueOf(event.getId()))
                    .entityName(event.getPersister().getEntityName())
                    .eventTime(LocalDateTime.now())
                    .entityContent(jsonObject)
                    .operation(operation)
                    .build();

            saveAuditLog(auditLog);
        } catch (Exception e) {
            logger.error("Ошибка при сохранении аудита для сущности: {} Ошибка: {}",
                    event.getPersister().getEntityName(), e.getMessage(), e);
        }
        return false;
    }

    private String writeUpdateJson(PreUpdateEvent updateEvent) {
        String[] properties = updateEvent.getPersister().getPropertyNames();
        Object[] oldState = updateEvent.getOldState();
        Object[] currentState = updateEvent.getState();

        Map<String, Map<String, Object>> changes = new HashMap<>();

        for(int i = 0; i < properties.length; i++) {
            if (oldState[i] == null && currentState[i] == null) continue;
            if (oldState[i] != null && currentState[i].equals(oldState[i])) continue;

            Map<String, Object> fieldChanged = new HashMap<>();
            fieldChanged.put("old", oldState[i]);
            fieldChanged.put("new", currentState[i]);
            changes.put(properties[i], fieldChanged);
        }
        return JsonMapper.writeObjectAsString(changes);
    }

    private void saveAuditLog(AuditEntity auditLog) {

        var factory = HibernateAndConnectionPoolUtil.getSessionFactory();

        try (var session = factory.openStatelessSession()) {
            session.beginTransaction();
            session.insert(auditLog);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Не удалось сохранить запись аудита для сущности: {} Ошибка: {} ",
                    auditLog.getEntityName(), e.getMessage(), e);
            System.err.println("Ошибка при сохранении аудита" + e.getMessage());
        }
    }
}
