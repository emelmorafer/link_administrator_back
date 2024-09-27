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


-- Estas 3 sentencias insertan los registros solo si no existen registros con el mismo nombre en la tabla categoria.

INSERT INTO categoria (nombre, descripcion, creationdate)
SELECT
'Youtuber Cinefilos',
'Es un creador de contenido en la plataforma YouTube que se especializa en el análisis, la crítica, y la discusión de películas y todo lo relacionado con el cine.',
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM categoria WHERE nombre = 'Youtuber Cinefilos');


INSERT INTO categoria (nombre, descripcion, creationdate)
SELECT
'Youtuber Politicos',
'Es un creador de contenido en la plataforma YouTube que se enfoca en temas relacionados con la política. Su contenido abarca una amplia gama de tópicos políticos.',
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM categoria WHERE nombre = 'Youtuber Politicos');


INSERT INTO categoria (nombre, descripcion, creationdate)
SELECT
'Youtuber Deportivos',
'Estos YouTubers producen videos que cubren una amplia variedad de aspectos deportivos, incluyendo noticias, análisis, comentarios, tutoriales y contenido entretenido relacionado con diferentes disciplinas deportivas.',
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM categoria WHERE nombre = 'Youtuber Deportivos');




INSERT INTO enlace (nombre, descripcion, enlace, id_categoria, creationdate)
SELECT
'Fuera de Foco',
'¿Amante del mundo del cine? Aquí te contamos qué tal están las películas en cartelera y las noticias más recientes del espectáculo.',
'https://www.youtube.com/@FueradeFoco/videos',
(SELECT id FROM categoria WHERE nombre = 'Youtuber Cinefilos'),
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM enlace WHERE nombre = 'Fuera de Foco');


INSERT INTO enlace (nombre, descripcion, enlace, id_categoria, creationdate)
SELECT
'The Top Comics',
'Canal donde podrás saber todo sobre Marvel, DC Comics y más franquicias de cómics. Curiosidades, tops y reseñas de tus películas y cómics favoritos.',
'https://www.youtube.com/@TheTopComicsOficial/videos',
(SELECT id FROM categoria WHERE nombre = 'Youtuber Cinefilos'),
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM enlace WHERE nombre = 'The Top Comics');


INSERT INTO enlace (nombre, descripcion, enlace, id_categoria, creationdate)
SELECT
'La Pulla',
'En Colombia nos sobran motivos para rabiar. La Pulla es un espacio de opinión para aportar contexto y reflexión a la fugaz indignación de los colombianos. Emberráquese con argumentos, emberráquese con nosotros.',
'https://www.youtube.com/@LaPulla/videos',
(SELECT id FROM categoria WHERE nombre = 'Youtuber Politicos'),
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM enlace WHERE nombre = 'La Pulla');


INSERT INTO enlace (nombre, descripcion, enlace, id_categoria, creationdate)
SELECT
'Me dicen Wally',
'Wally Opina es un reportaje semanal del formato Late Show con el objetivo de entretener y dar opinión acerca de los hechos políticos y de actualidad que suceden en Colombia.',
'https://www.youtube.com/@MeDicenWally/videos',
(SELECT id FROM categoria WHERE nombre = 'Youtuber Politicos'),
'2024-09-23 14:00:00'
WHERE NOT EXISTS (SELECT 1 FROM enlace WHERE nombre = 'Me dicen Wally');