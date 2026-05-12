CREATE TABLE IF NOT EXISTS CATEGORIAS (
    id_categoria INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS PRODUCTOS (
    id_producto INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT UNSIGNED NOT NULL DEFAULT 0,
    imagen_url VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    id_categoria INT UNSIGNED,
    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (id_categoria)
        REFERENCES CATEGORIAS(id_categoria)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS DEPARTAMENTOS (
    id_departamento INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS CIUDADES (
    id_ciudad INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_departamento INT UNSIGNED NOT NULL,
    CONSTRAINT fk_ciudad_departamento
        FOREIGN KEY (id_departamento)
        REFERENCES DEPARTAMENTOS(id_departamento)
        ON UPDATE CASCADE,
    CONSTRAINT uq_ciudad_departamento
        UNIQUE(nombre, id_departamento)
);

CREATE TABLE IF NOT EXISTS USUARIOS (
    id_usuario INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    contrasena_hash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS DIRECCIONES (
    id_direccion INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNSIGNED NOT NULL,
    id_ciudad INT UNSIGNED NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    barrio VARCHAR(100),
    codigo_postal VARCHAR(20),
    referencia TEXT,
    CONSTRAINT fk_direccion_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES USUARIOS(id_usuario)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_direccion_ciudad
        FOREIGN KEY (id_ciudad)
        REFERENCES CIUDADES(id_ciudad)
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS METODOS_PAGO (
    id_metodo_pago INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS ESTADOS_FACTURA (
    id_estado_factura INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS FACTURAS (
    id_factura INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNSIGNED NOT NULL,
    id_estado_factura INT UNSIGNED NOT NULL,
    fecha_factura DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    nombre_cliente VARCHAR(150) NOT NULL,
    telefono_cliente VARCHAR(20),
    direccion_envio VARCHAR(255) NOT NULL,
    barrio_envio VARCHAR(100),
    ciudad_envio VARCHAR(100),
    departamento_envio VARCHAR(100),
    subtotal DECIMAL(10,2) NOT NULL,
    IVA DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    notas_factura TEXT,
    CONSTRAINT fk_factura_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES USUARIOS(id_usuario)
        ON UPDATE CASCADE,
    CONSTRAINT fk_factura_estado
        FOREIGN KEY (id_estado_factura)
        REFERENCES ESTADOS_FACTURA(id_estado_factura)
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS DETALLES_FACTURA (
    id_detalle INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_factura INT UNSIGNED NOT NULL,
    id_producto INT UNSIGNED,
    nombre_producto VARCHAR(150) NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_detalle_factura
        FOREIGN KEY (id_factura)
        REFERENCES FACTURAS(id_factura)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (id_producto)
        REFERENCES PRODUCTOS(id_producto)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS PAGOS_FACTURA (
    id_pago INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_factura INT UNSIGNED NOT NULL,
    id_metodo_pago INT UNSIGNED NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    referencia_pago VARCHAR(150),
    estado_pago ENUM(
        'pendiente',
        'completado',
        'fallido',
        'reembolsado'
    ) NOT NULL DEFAULT 'pendiente',
    fecha_pago DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_pago_factura
        FOREIGN KEY (id_factura)
        REFERENCES FACTURAS(id_factura)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_pago_metodo
        FOREIGN KEY (id_metodo_pago)
        REFERENCES METODOS_PAGO(id_metodo_pago)
        ON UPDATE CASCADE
);
