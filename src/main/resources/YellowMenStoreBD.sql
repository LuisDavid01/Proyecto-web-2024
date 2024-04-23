
drop schema if exists yellow_men_store;
drop user if exists usuario;
CREATE SCHEMA yellow_men_store ;

/*usuario definido con la contraseña admin"*/
create user 'usuario'@'%' identified by 'admin';

/*se le dan privilegios a usuario/
grant all privileges on yellow_men_store.* to 'usuario'@'%';
flush privileges;

/* tabla categoria sobre productos*/
create table yellow_men_store.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  nombre_categoria VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
/* tabla productos referencian a categoria con el id_categoria*/
create table yellow_men_store.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  nombre_producto VARCHAR(30) NOT NULL,  
  detalle VARCHAR(300) NOT NULL, 
  talla_producto VARCHAR(10) NOT NULL, 
  precio double,
  ruta_imagen varchar(1024),
  
  PRIMARY KEY (id_producto),
  foreign key fk_producto_caregoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
/* tabla de los usuarios empleados/administradores*/
create table yellow_men_store.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL,  
  password varchar(512) NOT NULL, 
 nombre varchar(30) NOT NULL,
 apellidos varchar(30) NOT NULL,
 correo varchar(25) NULL,
 telefono varchar(25) NULL,
  ruta_imagen varchar(1024),
  
  PRIMARY KEY (id_usuario)
  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
/* asigna rol a usuarios*/
create table yellow_men_store.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  id_usuario INT,
  
  
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table yellow_men_store.valoraciones (
  id_valoracion INT NOT NULL AUTO_INCREMENT,
  id_usuario int NOT NULL,
  id_producto INT NOT NULL,
  puntuacion varchar(5) NOT NULL,
  comentario varchar(500),
  fecha_valoracion date NOT NULL,
  
  
  PRIMARY KEY (id_valoracion),
  foreign key fk_valoracion_usuario (id_usuario) references usuario(id_usuario),
  foreign key fk_valoracion_producto (id_producto) references producto(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table yellow_men_store.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,
  direccion varchar(50) NOT NULL,
  codigo_postal varchar(10) NOT NULL,
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table yellow_men_store.venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_producto INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references factura(id_factura),
  foreign key fk_ventas_producto (id_producto) references producto(id_producto) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table yellow_men_store.promociones (
  id_promocion INT NOT NULL AUTO_INCREMENT,
  nombre varchar(40) NOT NULL,
  descripcion varchar(100) NOT NULL,
  descuento double NOT NULL,
  activo boolean,
  
  
  PRIMARY KEY (id_promocion)
  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO  yellow_men_store.categoria (id_categoria,nombre_categoria,ruta_imagen) VALUES 
('1','camisas','https://caterpillarcr.com/cdn/shop/files/2610628_12815_Standard-Stone.jpg?v=1695391085'),
('2','pantalones','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg'),
('3','camisas oversize','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg'),
('4','pantalones oversize','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg'),
('5','pantalones cargo','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg');

INSERT INTO  yellow_men_store.producto (id_producto,id_categoria,nombre_producto,detalle,talla_producto,precio,ruta_imagen) VALUES 
('1','1','camisa random','Camisa oversize hecha de algodon','s','2500','https://caterpillarcr.com/cdn/shop/files/2610628_12815_Standard-Stone.jpg?v=1695391085'),
('2','2','pantalon random','pantalon techwear de algodon','l','4600','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg'),
('3','3','camisa blanca oversize','camisa blanca con detalle verde','s-xl','7000','https://gw.alicdn.com/bao/uploaded/i1/2206588314948/O1CN01b6qAy91mQEgR3NQJx_!!2206588314948-0-C2M.jpg_220x10000q90.jpg_.webp'),
('4','3','camisa oversize mujer','camisa blanca toy story','s-xl','6000','https://img.alicdn.com/imgextra/i1/2214291567330/O1CN011FfEy6241C6hgBgDV_!!2214291567330-0-scmitem176000.jpg'),
('5','4','pantalon oversize unisex','pantalon crema pliegue','m-xl','12000','https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/2657134748/O1CN01UpVorC1kwdG8y4LmE_!!0-item_pic.jpg_.webp'),
('6','1','camisa algodon','camisa de algodon grueso de alta calidad','xs-xl','8000','https://img.alicdn.com/imgextra/i3/2212289861878/O1CN01hOhoe91PkAlHQgCsk_!!2212289861878-0-scmitem176000.jpg'),
('7','4','pantalon oversize mujer','pantalon ancho de algodon','xs-l','10000','https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/1042106813/O1CN01ooFuS120CPGWKRNvY_!!1042106813.jpg_.webp'),
('8','5','pantalon cargo','pantalon recto de algodon','m-xxl','13000','https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/2213029077632/O1CN01GloCtc26FVdVfdL5V_!!2213029077632.jpg_.webp');


INSERT INTO yellow_men_store.usuario(id_usuario,username,password,nombre,apellidos,correo,telefono,ruta_imagen) VALUES
('1','juan','123','juan','miguel','jmiguel@gmail.com','123456678','https://dudewipes.com/cdn/shop/articles/gigachad.jpg?v=1667928905&width=1000'),
('2','mateo','456','mateo','miguel','mmiguel@gmail.com','87654321','https://res.cloudinary.com/jerrick/image/upload/d_642250b563292b35f27461a7.png,f_jpg,fl_progressive,q_auto,w_1024/6483bb973b8f65001ea4755f.jpg');

INSERT INTO yellow_men_store.rol(id_rol,nombre,id_usuario) VALUES
('1','ROLE_ADMIN','1'),
('2','ROLE_USER','2');

INSERT INTO yellow_men_store.valoraciones(id_valoracion,id_usuario,id_producto,puntuacion,comentario,fecha_valoracion) VALUES
('1','1','1','5','Muy buena compra!!!','2024-03-15'),
('2','1','2','3','Paquete un poco goleado','2024-01-15'),
('3','1','3','4','un poco mas grande de lo normal, recomiendo comprar una talla menos','2024-04-01'),
('4','1','4','2','El color es diferente al mostrado en las opciones','2024-03-03'),
('5','1','5','5','Me quedo perfecto','2024-02-15');

INSERT INTO yellow_men_store.promociones(id_promocion,nombre,descripcion,descuento,activo) VALUES
('1','promocion de verano','Promocion de 2000 colones','2000',true),
('2','promocion de viernes negro','Promocion de 5000 colones','5000',false),
('3','promocion de invierno','Promocion de 2500 colones','2500',false);
