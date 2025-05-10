CREATE TABLE PERSONA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100),
    identificacion VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE FACTURA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE DEFAULT CURRENT_DATE,
    monto DECIMAL(10, 2),
    persona_id BIGINT NOT NULL,
    CONSTRAINT fk_factura_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);
