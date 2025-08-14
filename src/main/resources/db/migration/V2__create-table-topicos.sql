CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    nombre_curso VARCHAR(100) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
        ON DELETE CASCADE
);