-- ============================================================
-- Datos de login para las pruebas automatizadas (ejer14)
-- Base: digitalers2023  |  Motor: MySQL
-- ============================================================

USE digitalers2023;

-- 1) Crear la tabla
CREATE TABLE IF NOT EXISTS usuarios (
    id       INT          NOT NULL AUTO_INCREMENT,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    activo   TINYINT(1)   NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    UNIQUE KEY uq_usuarios_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2) Insertar los mismos datos que ejer11
INSERT INTO usuarios (email, password) VALUES
    ('maria@test.com', 'maria1234'),
    ('juan@test.com',  'juan1234'),
    ('test@test.com',  'test1234'),
    ('pedro@test.com', 'pedro1234');

-- 3) Verificacion
SELECT id, email, password, activo FROM usuarios ORDER BY id;

-- 4) La query que usa el DataProvider
SELECT email, password FROM usuarios WHERE activo = 1 ORDER BY id;

-- ------------------------------------------------------------
-- Utiles (opcionales)
-- ------------------------------------------------------------
-- Desactivar un usuario sin borrarlo (el test lo salteara):
--   UPDATE usuarios SET activo = 0 WHERE email = 'pedro@test.com';
-- Limpiar y recargar:
--   TRUNCATE TABLE usuarios;
-- Eliminar la tabla:
--   DROP TABLE IF EXISTS usuarios;
