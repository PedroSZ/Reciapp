drop table if exists foto;
drop table if exists reporte;
drop table if exists ciudadano;


create table reporte(
id int primary key auto_increment,
folio varchar(10) not null,
reportenombre varchar(30),
descripcion varchar(200),
domicilio varchar(100),
cruce varchar(50),
referencia varchar(100),
fecha date,
estado varchar(10)
);

insert into reporte
(folio,reportenombre,descripcion,domicilio,cruce,referencia,fecha,estado)values
("FOL1020","Persona Agresiva","Persona ebria agresiva en la via publica con las personas al paso","Allende No. 50","Vallarta", "Frente a Telmex","2021-10-21","Nuevo"),
("FOL1021","Incendio","Incendio en el potrero de la aguja","Carretera Ameca-Mascot km12","No hay cruce", "Pasando el Rancho el Viento Negro","2021-10-21","En proceso"),
("FOL1022","Bache peligroso","Bache enorme en la calle Aldama","Aldama No.3","Cofradia", "Frente a la tienda Lagunitas","2021-10-21","Finalizado"),
("SP1023","Poste de Luz Caido","Cañera al paso tumbo poste de luz","16 de Septiembre No3","Rocha Garibay", "Frente a la llantera las 4 equinas","2021-10-21","Pendiente"),

("FOL1024","Desbordamiento","Persona ebria agresiva en la via publica con las personas al paso","Allende No. 50","Vallarta", "Frente a Telmex","2021-10-21","Nuevo"),
("FOL1025","Consulta general","abrirar en dia 16 de Septiembre","Presidencia de Ameca","No hay cruce", "Registro Civil","2021-10-21","Finalizado"),
("FOL1026","Mala atencion al público","No me quisieron atender en caja unica","Presidencia de ameca","No hay cruce", "Caja unica","2021-10-21","Finalizado"),
("FOL1027","Poste de Luz Caido","Cañera al paso tumbo poste de luz","16 de Septiembre No3","Rocha Garibay", "Frente a la llantera las 4 equinas","2021-10-21","Pendiente");

drop table if exists ciudadano;
create table ciudadano(
id int primary key auto_increment,
nombre varchar(50),
apellidop varchar(20),
apellidom varchar(20),
direccion varchar(200),
telefono varchar(13),
email varchar(50)
);

insert into ciudadano
(nombre,apellidop,apellidom,direccion,telefono,email)values
('JUAN JOSE','GARCIA','GARCIA','ROCHA GARIBAY 120 AMECA, JALISCO','3751241568','garcia@mail.com'),
('MANUEL','SANTOS','SOLANO','ALLENDE 220','3582147569','MANUEL@MAIL.COM'),
('MARIA','AGUILAR','ANDALON','ALDAMA 10','2458655555','MARIA@MAIL.COM'),
('ALEJANDRA','RAMOS','SALAZAR','LIMON 8','3698521478','ALEJANDRA@MAIL.COM'),
('JOEL','ORTEGA','VIÑEDO','ACACIA 8','778889952','JOEL@MAIL.COM');



alter table reporte
add column ciudadano_id int,
add foreign key (ciudadano_id) references ciudadano(id);

update reporte set ciudadano_id = 1 where id in (1,5);
update reporte set ciudadano_id = 2 where id in (2,7);
update reporte set ciudadano_id = 3 where id in (3);
update reporte set ciudadano_id = 4 where id in (4,8);
update reporte set ciudadano_id = 5 where id in (6);

alter table reporte
modify ciudadano_id int not null;

drop table if exists foto;
create table foto(
id int primary key auto_increment,
reporte_id int,
foto1 varchar(200),
foto2 varchar(200),
foto3 varchar(200),
foto4 varchar(200),
foto5 varchar(200),
foreign key (reporte_id) references reporte(id)
); 

insert into foto
(reporte_id,foto1,foto2,foto3,foto4,foto5)values
(1,'https://deconceptos.com/wp-content/uploads/2018/03/concepto-de-via-publica.jpg','https://deconceptos.com/wp-content/uploads/2018/03/concepto-de-via-publica.jpg','https://deconceptos.com/wp-content/uploads/2018/03/concepto-de-via-publica.jpg','https://deconceptos.com/wp-content/uploads/2018/03/concepto-de-via-publica.jpg','https://deconceptos.com/wp-content/uploads/2018/03/concepto-de-via-publica.jpg');

