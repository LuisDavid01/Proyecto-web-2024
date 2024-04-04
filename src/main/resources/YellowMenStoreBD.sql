
drop schema if exists yellow_men_store;
drop user if exists usuario;
CREATE SCHEMA yellow_men_store ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario'@'%' identified by 'admin';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on yellow_men_store.* to 'usuario'@'%';
flush privileges;

/* la tabla de categoria contiene categorias de productos*/
create table yellow_men_store.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  nombre_categoria VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table yellow_men_store.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  nombre_producto VARCHAR(30) NOT NULL,  
  talla_producto VARCHAR(10) NOT NULL, 
  precio double,
  ruta_imagen varchar(1024),
  
  PRIMARY KEY (id_producto),
  foreign key fk_producto_caregoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO  yellow_men_store.categoria (id_categoria,nombre_categoria,ruta_imagen) VALUES 
('1','camisas','https://caterpillarcr.com/cdn/shop/files/2610628_12815_Standard-Stone.jpg?v=1695391085'),
('2','pantalones','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg');

INSERT INTO  yellow_men_store.producto (id_producto,id_categoria,nombre_producto,talla_producto,precio,ruta_imagen) VALUES 
('1','1','camisa random','s','2500','https://caterpillarcr.com/cdn/shop/files/2610628_12815_Standard-Stone.jpg?v=1695391085'),
('2','2','pantalon random','l','4600','https://m.media-amazon.com/images/I/61r91j4LZyL._AC_UL1500_.jpg');