CREATE TABLE audit_log (
    id BIGSERIAL PRIMARY KEY,
    entity_id VARCHAR(64) NOT NULL,
    entity_name VARCHAR(128) NOT NULL,
    event_time TIMESTAMP NOT NULL,
    entity_content JSONB NOT NULL,
    operation_type VARCHAR(32) NOT NULL
);

CREATE INDEX idx_entity_by_time_and_operation ON audit_log(event_time, operation_type);
