-- data.sql

CREATE TABLE IF NOT EXISTS categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    creationdate DATETIME
);

CREATE TABLE IF NOT EXISTS enlace (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    enlace VARCHAR(255),
    id_categoria INT NOT NULL,
    creationdate DATETIME
);


-- Estas 2 sentencias insertan los registros solo si no existen registros con el mismo nombre en la tabla categoria.

INSERT INTO categoria (nombre, descripcion, creationdate)
SELECT 'Youtuber Cinefilos', 'Youtubers que hablan de cine', '2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM categoria WHERE nombre = 'Youtuber Cinefilos');

INSERT INTO categoria (nombre, descripcion, creationdate)
SELECT 'Youtuber Politicos', 'Youtubers que hablan de politica', '2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM categoria WHERE nombre = 'Youtuber Politicos');