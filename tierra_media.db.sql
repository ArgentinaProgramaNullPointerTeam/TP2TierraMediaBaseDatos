CREATE TABLE IF NOT EXISTS "usuario" (
	"id_usuario"	INTEGER,
	"nombre"	TEXT NOT NULL,
	"dinero_disponible"	INTEGER NOT NULL,
	"tiempo_disponible"	INTEGER NOT NULL,
	"tipo_atraccion"	TEXT NOT NULL,
	PRIMARY KEY("id_usuario" AUTOINCREMENT)
);


INSERT INTO usuario(nombre, dinero_disponible, tiempo_disponible, tipo_atraccion) VALUES

 ('Eowyn', '10', '8','Aventura'),
 ('Gandalf', '100', '5', 'Paisaje'),
 ('Sam', '36', '8','Degustacion'), 
 ('Galandriel', '5', '6','Paisaje'),
 ('Millonario', '1000', '1000', 'Aventura');



CREATE TABLE IF NOT EXISTS "atraccion" (
	"id_atraccion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	"costo_visita"	INTEGER NOT NULL,
	"cupo"	INTEGER NOT NULL,
	"tiempo_visita"	INTEGER NOT NULL,
	"tipo_atraccion"	TEXT,
	PRIMARY KEY("id_atraccion" AUTOINCREMENT)
);

INSERT INTO atraccion(nombre, costo_visita,cupo,tiempo_visita,tipo_atraccion) VALUES
 ('Moria', '10', '6', '2', 'Aventura'),
 ('Minas Tirith', '5', '25', '2.5', 'Paisaje'),
 ('La comarca', '3', '150', '6.5', 'Degustacion'),
 ('Mordor', '25', '4', '3', 'Aventura'), 
 ('Abismo de Helm', '5', '15', '2', 'Paisaje'),
 ('Lothlórien', '35', '30', '1', 'Degustacion'),
 ('Erebor', '12', '32', '3', 'Paisaje'), 
 ('Bosque Negro', '3', '12', '4','Aventura'),                                                                                                                             
 ('La Acotada', '5', '3', '1', 'Aventura');


CREATE TABLE IF NOT EXISTS "promocion" (
	"id_promocion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"tipo_promocion"	TEXT,
	"descuento_AXB"	INTEGER,
	"descuento_porcentual"	INTEGER,
	"descuento_absoluta"	TEXT,
	"tipo_atraccion"	INTEGER,
	"atraccion1"	INT,
	"atraccion2"	INT,
	"atraccion3"	INT,
	PRIMARY KEY("id_promocion" AUTOINCREMENT),
	FOREIGN KEY("descuento_AXB") REFERENCES "atraccion"("id_atraccion")
);



INSERT INTO promocion(nombre,tipo_promocion, descuento_porcentual, tipo_atraccion,atraccion1, atraccion2) VALUES
 ('Pack Aventura', 'Porcentual', '0.2','Aventura','8','4');

INSERT INTO promocion(nombre,tipo_promocion, descuento_absoluta, tipo_atraccion,atraccion1, atraccion2) VALUES
   ('Pack Degustacion', 'Absoluta', '36', 'Degustacion','6','3');

INSERT INTO promocion(nombre, tipo_promocion, descuento_AXB, tipo_atraccion, atraccion1, atraccion2, atraccion3) VALUES
('Pack Paisaje', 'AXB', 7, 'Paisaje','2','5','7'),
('Pack Aventura Recargado', 'AXB', 9, 'Aventura', '8','4','9');


CREATE TABLE IF NOT EXISTS "atraccionesPorPromocion" (
	"id_atraccion"	INTEGER NOT NULL,
	"id_promocion"	INTEGER NOT NULL,
	FOREIGN KEY("id_atraccion") REFERENCES "atraccion"("id_atraccion"),
	FOREIGN KEY("id_promocion") REFERENCES "promocion"("id_promocion")
);

INSERT INTO atraccionesPorPromocion(id_atraccion,id_promocion) VALUES
   ('8', '1'),
   ('4', '1'),
   ('6', '2'),
   ('3', '2'),
   ('2', '3'),
   ('5', '3'),
   ('7', '3'),
   ('8', '4'),
   ('4', '4'),
   ('9', '4');

CREATE TABLE IF NOT EXISTS "itinerario" (
	"id_itinerario"	INTEGER NOT NULL,
	"id_usuario"	INTEGER NOT NULL,
	"id_atraccion"	INTEGER,
	"id_promocion"	INTEGER,
	PRIMARY KEY("id_itinerario"),
	FOREIGN KEY("id_usuario") REFERENCES "usuario"("id_usuario"),
	FOREIGN KEY("id_atraccion") REFERENCES "atraccion"("id_atraccion"),
	FOREIGN KEY("id_promocion") REFERENCES "promocion"("id_promocion")
);
