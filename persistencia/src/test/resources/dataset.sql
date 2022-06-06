insert into ciudad values (1, "Armenia", "cuidad.jpg");
insert into ciudad values (2, "Cartagena", "cuidad.jpg");
insert into ciudad values (3, "Cali", "cuidad.jpg");
insert into ciudad values (4, "Medellin", "cuidad.jpg");

insert into administrador values ("123456","12345","sebas123@gmail.com","Sebastian Mejia", "1");
insert into administrador values ("456564","12345","carlos123@gmail.com","Carlos Mauricio", "2");
insert into administrador values ("756743","12345","santiago@gmail.com","Santiago Quedaza", "3");

insert into administrador_hotel values ("1","12345","sebas123@gmail.com","Sebastian Mejia","1","123456");
insert into administrador_hotel values ("2","12345","JairoHenao@gmail.com","Jairo Henao", "2","123456");
insert into administrador_hotel values ("3","12345","JabierCubillos@gmail.com","Jabier Cubillos", "3","456564");
insert into administrador_hotel values ("4","12345","HenaoOscar@gmail.com","Osacar Henao", "4","756743");

insert into usuario values ("1234432", "12345", "Manuel123@correo.com","Manuel Mejia",1);
insert into usuario values ("423456", "12345", "Fabian123@correo.com","Fabian Mejia",2);
insert into usuario values ("323455", "12345", "Carlos123@correo.com","Carlos Soto",3);
insert into usuario values ("2289434", "12345", "Rodrigo123@correo.com","Rodrigo Perez",1);
insert into usuario values ("926564", "12345", "Pedro123@correo.com","Pedro Muriel",1);
insert into usuario values ("7234634", "12345", "JuanMiguel23@correo.com","Juan Miguel Ossa",4);

insert into usuario_telefono values ("423456","33456513");
insert into usuario_telefono values ("1234432","124256211");
insert into usuario_telefono values ("323455","32334513");
insert into usuario_telefono values ("2289434","323443213");
insert into usuario_telefono values ("926564","124234511");
insert into usuario_telefono values ("7234634","323443213");

insert into hotel values(1,"excelente","cra 02 #23-11","hotel Tertulia",4,"324234241","1",1);
insert into hotel values(2,"excelente","cra 02 #2-31","hotel Armenia",3,"324334241","1",1);
insert into hotel values(3,"excelente","cra 12 #2-21","hotel Cartagena",4,"314234241","2",2);
insert into hotel values(4,"excelente","cra 13 #3-31","hotel Cartagena 2",5,"32437241","2",2);
insert into hotel values(5,"excelente","cra 5 #43-10","hotel Cali",4,"334424241","2",3);
insert into hotel values(6,"excelente","cra 9 #34-56","hotel Cali Mirador",3,"31432241","2",3);
insert into hotel values(7,"excelente","cra 32 #8-21","hotel Medellin",5,"31243241","3",4);
insert into hotel values(8,"excelente","cra 24 #7-19","hotel Medallo",3,"31232341","3",4);

insert into cama values (1,1);
insert into cama values (2,2);
insert into cama values (3,3);
insert into cama values (4,4);
insert into cama values (5,5);

insert into caracteristica values (1,"balcon","2");
insert into caracteristica values (2,"pasillo","2");
insert into caracteristica values (3,"aire acondicionado","2");
insert into caracteristica values (4,"tv deportes, jaccusi","1");
insert into caracteristica values (5,"vip","1");
insert into caracteristica values (6,"almuerzo y cena incluida","1");
insert into caracteristica values (7,"piscina","1");
insert into caracteristica values (8,"buffet","1");
insert into caracteristica values (9,"sala de juegos","1");

insert into habitacion values(1,1,"disponible","101",45.000,1);
insert into habitacion values(2,2,"disponible","102",85.000,1);
insert into habitacion values(3,1,"disponible","103",45.000,1);
insert into habitacion values(4,3,"disponible","104",125.000,1);
insert into habitacion values(5,1,"disponible","201",45.000,1);
insert into habitacion values(6,2,"disponible","202",85.000,1);
insert into habitacion values(7,4,"disponible","203",155.000,1);
insert into habitacion values(8,2,"disponible","204",85.000,1);
insert into habitacion values(9,1,"disponible","101",45.000,2);
insert into habitacion values(10,3,"disponible","102",105.000,2);
insert into habitacion values(11,1,"disponible","103",45.000,2);
insert into habitacion values(12,2,"disponible","104",85.000,2);
insert into habitacion values(13,1,"disponible","201",45.000,2);
insert into habitacion values(14,5,"disponible","202",185.000,2);
insert into habitacion values(15,1,"disponible","203",45.000,2);
insert into habitacion values(16,2,"disponible","204",85.000,2);
insert into habitacion values(17,1,"disponible","101",45.000,3);
insert into habitacion values(18,2,"disponible","102",85.000,3);
insert into habitacion values(19,1,"disponible","103",45.000,3);
insert into habitacion values(20,2,"disponible","104",85.000,3);
insert into habitacion values(21,1,"disponible","201",45.000,3);
insert into habitacion values(22,2,"disponible","202",85.000,3);
insert into habitacion values(23,1,"disponible","203",45.000,3);
insert into habitacion values(24,2,"disponible","204",85.000,3);
insert into habitacion values(25,1,"disponible","101",45.000,4);
insert into habitacion values(26,2,"disponible","102",85.000,4);
insert into habitacion values(27,1,"disponible","103",45.000,4);
insert into habitacion values(28,2,"disponible","104",85.000,4);
insert into habitacion values(29,1,"disponible","201",45.000,4);
insert into habitacion values(30,2,"disponible","202",85.000,4);
insert into habitacion values(31,1,"disponible","203",45.000,4);
insert into habitacion values(32,2,"disponible","204",85.000,4);
insert into habitacion values(33,1,"disponible","101",45.000,5);
insert into habitacion values(34,2,"disponible","102",85.000,5);
insert into habitacion values(35,1,"disponible","103",45.000,5);
insert into habitacion values(36,3,"disponible","104",125.000,5);
insert into habitacion values(37,1,"disponible","201",45.000,5);
insert into habitacion values(38,2,"disponible","202",85.000,5);
insert into habitacion values(39,4,"disponible","203",155.000,5);
insert into habitacion values(40,2,"disponible","204",85.000,5);
insert into habitacion values(41,1,"disponible","101",45.000,6);
insert into habitacion values(42,3,"disponible","102",105.000,6);
insert into habitacion values(43,1,"disponible","103",45.000,6);
insert into habitacion values(44,2,"disponible","104",85.000,6);
insert into habitacion values(45,1,"disponible","201",45.000,6);
insert into habitacion values(46,5,"disponible","202",185.000,6);
insert into habitacion values(47,1,"disponible","203",45.000,6);
insert into habitacion values(48,2,"disponible","204",85.000,6);
insert into habitacion values(49,1,"disponible","101",45.000,7);
insert into habitacion values(50,2,"disponible","102",85.000,7);
insert into habitacion values(51,1,"disponible","103",45.000,7);
insert into habitacion values(52,2,"disponible","104",85.000,7);
insert into habitacion values(53,1,"disponible","201",45.000,7);
insert into habitacion values(54,2,"disponible","202",85.000,7);
insert into habitacion values(55,1,"disponible","203",45.000,7);
insert into habitacion values(56,2,"disponible","204",85.000,7);
insert into habitacion values(57,1,"disponible","101",45.000,8);
insert into habitacion values(58,2,"disponible","102",85.000,8);
insert into habitacion values(59,1,"disponible","103",45.000,8);
insert into habitacion values(60,2,"disponible","104",85.000,8);
insert into habitacion values(61,1,"disponible","201",45.000,8);
insert into habitacion values(62,2,"disponible","202",85.000,8);
insert into habitacion values(63,1,"disponible","203",45.000,8);
insert into habitacion values(64,2,"disponible","204",85.000,8);


insert into habitacion_camas values(1,1);
insert into habitacion_camas values(2,2);
insert into habitacion_camas values(3,3);
insert into habitacion_camas values(4,4);
insert into habitacion_camas values(5,5);
insert into habitacion_camas values(6,1);
insert into habitacion_camas values(7,2);
insert into habitacion_camas values(8,3);
insert into habitacion_camas values(9,4);
insert into habitacion_camas values(10,5);
insert into habitacion_camas values(11,3);
insert into habitacion_camas values(12,3);
insert into habitacion_camas values(13,3);
insert into habitacion_camas values(14,4);
insert into habitacion_camas values(15,5);
insert into habitacion_camas values(16,1);
insert into habitacion_camas values(17,1);
insert into habitacion_camas values(18,1);
insert into habitacion_camas values(19,1);
insert into habitacion_camas values(20,2);
insert into habitacion_camas values(21,2);
insert into habitacion_camas values(22,2);
insert into habitacion_camas values(23,2);
insert into habitacion_camas values(24,2);
insert into habitacion_camas values(25,2);
insert into habitacion_camas values(26,2);
insert into habitacion_camas values(27,2);
insert into habitacion_camas values(28,2);
insert into habitacion_camas values(29,2);
insert into habitacion_camas values(30,3);
insert into habitacion_camas values(31,3);
insert into habitacion_camas values(32,3);
insert into habitacion_camas values(33,3);
insert into habitacion_camas values(34,3);
insert into habitacion_camas values(35,3);
insert into habitacion_camas values(36,3);
insert into habitacion_camas values(37,3);
insert into habitacion_camas values(38,3);
insert into habitacion_camas values(39,3);
insert into habitacion_camas values(40,4);
insert into habitacion_camas values(41,4);
insert into habitacion_camas values(42,4);
insert into habitacion_camas values(43,4);
insert into habitacion_camas values(44,4);
insert into habitacion_camas values(45,4);
insert into habitacion_camas values(46,4);
insert into habitacion_camas values(47,4);
insert into habitacion_camas values(48,4);
insert into habitacion_camas values(49,4);
insert into habitacion_camas values(50,5);
insert into habitacion_camas values(51,5);
insert into habitacion_camas values(52,5);
insert into habitacion_camas values(53,5);
insert into habitacion_camas values(54,5);
insert into habitacion_camas values(55,5);
insert into habitacion_camas values(56,5);
insert into habitacion_camas values(57,5);
insert into habitacion_camas values(58,5);
insert into habitacion_camas values(59,5);
insert into habitacion_camas values(60,3);
insert into habitacion_camas values(61,4);
insert into habitacion_camas values(62,2);
insert into habitacion_camas values(63,4);
insert into habitacion_camas values(64,3);


insert into habitacion_caracteristicas values(1,1);
insert into habitacion_caracteristicas values(2,2);
insert into habitacion_caracteristicas values(3,3);
insert into habitacion_caracteristicas values(4,3);
insert into habitacion_caracteristicas values(5,2);
insert into habitacion_caracteristicas values(6,4);
insert into habitacion_caracteristicas values(7,5);
insert into habitacion_caracteristicas values(8,6);
insert into habitacion_caracteristicas values(9,6);
insert into habitacion_caracteristicas values(10,5);
insert into habitacion_caracteristicas values(11,4);
insert into habitacion_caracteristicas values(12,3);
insert into habitacion_caracteristicas values(13,6);
insert into habitacion_caracteristicas values(14,4);
insert into habitacion_caracteristicas values(15,5);
insert into habitacion_caracteristicas values(16,1);
insert into habitacion_caracteristicas values(17,3);
insert into habitacion_caracteristicas values(18,6);
insert into habitacion_caracteristicas values(19,4);
insert into habitacion_caracteristicas values(20,5);
insert into habitacion_caracteristicas values(21,4);
insert into habitacion_caracteristicas values(22,3);
insert into habitacion_caracteristicas values(23,3);
insert into habitacion_caracteristicas values(24,6);
insert into habitacion_caracteristicas values(25,6);
insert into habitacion_caracteristicas values(26,4);
insert into habitacion_caracteristicas values(27,3);
insert into habitacion_caracteristicas values(28,4);
insert into habitacion_caracteristicas values(29,1);
insert into habitacion_caracteristicas values(30,3);
insert into habitacion_caracteristicas values(31,5);
insert into habitacion_caracteristicas values(32,6);
insert into habitacion_caracteristicas values(33,4);
insert into habitacion_caracteristicas values(34,3);
insert into habitacion_caracteristicas values(35,5);
insert into habitacion_caracteristicas values(36,1);
insert into habitacion_caracteristicas values(37,4);
insert into habitacion_caracteristicas values(38,3);
insert into habitacion_caracteristicas values(39,5);
insert into habitacion_caracteristicas values(40,6);
insert into habitacion_caracteristicas values(41,4);
insert into habitacion_caracteristicas values(42,3);
insert into habitacion_caracteristicas values(43,6);
insert into habitacion_caracteristicas values(44,1);
insert into habitacion_caracteristicas values(45,4);
insert into habitacion_caracteristicas values(46,4);
insert into habitacion_caracteristicas values(47,2);
insert into habitacion_caracteristicas values(48,1);
insert into habitacion_caracteristicas values(49,3);
insert into habitacion_caracteristicas values(50,5);
insert into habitacion_caracteristicas values(51,6);
insert into habitacion_caracteristicas values(52,4);
insert into habitacion_caracteristicas values(53,3);
insert into habitacion_caracteristicas values(54,5);
insert into habitacion_caracteristicas values(55,6);
insert into habitacion_caracteristicas values(56,1);
insert into habitacion_caracteristicas values(57,6);
insert into habitacion_caracteristicas values(58,4);
insert into habitacion_caracteristicas values(59,3);
insert into habitacion_caracteristicas values(60,6);
insert into habitacion_caracteristicas values(61,3);
insert into habitacion_caracteristicas values(62,2);
insert into habitacion_caracteristicas values(63,6);
insert into habitacion_caracteristicas values(64,4);



insert into comentario values ("1",5,"muy buena atencion","2022-03-20", 1,"1234432");
insert into comentario values ("2",4,"excelente comida","2022-04-20", 2,"423456");
insert into comentario values ("3",3,"buen servicio","2022-04-21", 3,"323455");
insert into comentario values ("4",4,"buena atencion","2022-04-22", 4,"2289434");
insert into comentario values ("5",2," agua caliente","2022-05-01", 5,"926564");
insert into comentario values ("6",3,"buen servicio","2022-04-21", 6,"7234634");
insert into comentario values ("7",4,"buena atencion ","2022-04-22", 7,"323455");
insert into comentario values ("8",2," agua caliente","2022-05-01", 8,"926564");

insert into foto values ("1","foto.jpg",null,1);
insert into foto values ("2","foto.jpg",null,2);
insert into foto values ("3","foto.jpg",null,3);
insert into foto values ("4","foto.jpg",null,4);
insert into foto values ("5","foto.jpg",null,5);
insert into foto values ("6","foto.jpg",null,6);
insert into foto values ("7","foto.jpg",null,7);
insert into foto values ("8","foto.jpg",null,8);

insert into hotel_caracteristicas values (1,"9");
insert into hotel_caracteristicas values (2,"7");
insert into hotel_caracteristicas values (3,"8");
insert into hotel_caracteristicas values (4,"6");
insert into hotel_caracteristicas values (5,"8");
insert into hotel_caracteristicas values (6,"7");
insert into hotel_caracteristicas values (7,"9");
insert into hotel_caracteristicas values (8,"7");



insert into vuelo values ("abc1","vuelosDia", "programado",5,"123456",1,2);
insert into vuelo values ("ssdaw","vuelosDia", "programado",5,"123456",2,3);
insert into vuelo values ("dafsf","vuelosDia", "programado",6,"123456",3,4);
insert into vuelo values ("sdgr","AviVuelos", "programado",5,"456564",4,1);
insert into vuelo values ("fgdgr","AviVuelos", "programado",6,"456564",2,4);
insert into vuelo values ("acec","AviVuelos", "programado",6,"456564",1,3);
insert into vuelo values ("csvr","AviaTour", "programado",6,"756743",3,1);
insert into vuelo values ("fvssd","AviaTour", "programado",8,"756743",1,4);
insert into vuelo values ("c3dsfr","AviaTour", "programado",5,"756743",2,3);

insert into silla values ("1",80.000);
insert into silla values ("2",80.000);
insert into silla values ("3",80.000);
insert into silla values ("4",80.000);
insert into silla values ("5",90.000);
insert into silla values ("6",90.000);
insert into silla values ("7",90.000);
insert into silla values ("8",90.000);
insert into silla values ("9",90.000);
insert into silla values ("10",90.000);
insert into silla values ("11",90.000);
insert into silla values ("12",90.000);
insert into silla values ("13",80.000);
insert into silla values ("14",80.000);
insert into silla values ("15",80.000);
insert into silla values ("16",80.000);
insert into silla values ("17",120.000);
insert into silla values ("18",120.000);
insert into silla values ("19",120.000);
insert into silla values ("20",120.000);

insert into vuelo_sillas values ("abc1","1");
insert into vuelo_sillas values ("abc1","2");
insert into vuelo_sillas values ("abc1","3");
insert into vuelo_sillas values ("abc1","4");
insert into vuelo_sillas values ("abc1","5");
insert into vuelo_sillas values ("ssdaw","1");
insert into vuelo_sillas values ("ssdaw","2");
insert into vuelo_sillas values ("ssdaw","3");
insert into vuelo_sillas values ("ssdaw","4");
insert into vuelo_sillas values ("ssdaw","5");
insert into vuelo_sillas values ("dafsf","1");
insert into vuelo_sillas values ("dafsf","2");
insert into vuelo_sillas values ("dafsf","3");
insert into vuelo_sillas values ("dafsf","4");
insert into vuelo_sillas values ("dafsf","5");
insert into vuelo_sillas values ("dafsf","6");
insert into vuelo_sillas values ("sdgr","1");
insert into vuelo_sillas values ("sdgr","2");
insert into vuelo_sillas values ("sdgr","3");
insert into vuelo_sillas values ("sdgr","4");
insert into vuelo_sillas values ("sdgr","5");
insert into vuelo_sillas values ("abc1","1");
insert into vuelo_sillas values ("fgdgr","2");
insert into vuelo_sillas values ("fgdgr","3");
insert into vuelo_sillas values ("fgdgr","4");
insert into vuelo_sillas values ("fgdgr","5");
insert into vuelo_sillas values ("fgdgr","6");
insert into vuelo_sillas values ("acec","1");
insert into vuelo_sillas values ("acec","2");
insert into vuelo_sillas values ("acec","3");
insert into vuelo_sillas values ("acec","4");
insert into vuelo_sillas values ("acec","5");
insert into vuelo_sillas values ("acec","6");
insert into vuelo_sillas values ("csvr","1");
insert into vuelo_sillas values ("csvr","2");
insert into vuelo_sillas values ("csvr","3");
insert into vuelo_sillas values ("csvr","4");
insert into vuelo_sillas values ("csvr","5");
insert into vuelo_sillas values ("csvr","6");
insert into vuelo_sillas values ("fvssd","1");
insert into vuelo_sillas values ("fvssd","2");
insert into vuelo_sillas values ("fvssd","3");
insert into vuelo_sillas values ("fvssd","4");
insert into vuelo_sillas values ("fvssd","5");
insert into vuelo_sillas values ("fvssd","6");
insert into vuelo_sillas values ("fvssd","7");
insert into vuelo_sillas values ("fvssd","8");
insert into vuelo_sillas values ("c3dsfr","1");
insert into vuelo_sillas values ("c3dsfr","2");
insert into vuelo_sillas values ("c3dsfr","3");
insert into vuelo_sillas values ("c3dsfr","4");
insert into vuelo_sillas values ("c3dsfr","5");

insert into reserva values ("1",2,205.000,"reservado","2022-03-28","2022-03-24","2022-03-20",1,"1234432");
insert into reserva values ("2",3,245.500,"reservado","2022-04-18","2022-04-10","2022-04-02",2,"423456");
insert into reserva values ("3",2,305.500,"reservado","2022-03-20","2022-03-12","2022-03-01",3,"323455");
insert into reserva values ("4",1,235.500,"reservado","2022-05-28","2022-0-26","2022-05-02",4,"2289434");
insert into reserva values ("5",2,455.500,"reservado","2022-01-26","2022-01-20","2022-01-10",5,"926564");
insert into reserva values ("6",3,675.500,"reservado","2022-02-03","2022-02-01","2022-01-16",6,"7234634");

insert into reserva_habitacion values ("1",45.000,1,"1");
insert into reserva_habitacion values ("2",85.000,2,"5");
insert into reserva_habitacion values ("3",85.000,12,"1");
insert into reserva_habitacion values ("4",45.000,13,"3");
insert into reserva_habitacion values ("5",150.000,23,"2");
insert into reserva_habitacion values ("6",105.000,16,"6");

insert into hotel_reservas values (1,"1");
insert into hotel_reservas values (2,"2");
insert into hotel_reservas values (3,"4");
insert into hotel_reservas values (4,"3");
insert into hotel_reservas values (5,"6");
insert into hotel_reservas values (6,"5");




insert into reserva_silla values ("1",280.000,"1","1");
insert into reserva_silla values ("2",380.000,"1","2");
insert into reserva_silla values ("3",90.000,"2","5");
insert into reserva_silla values ("4",90.000,"2","5");
insert into reserva_silla values ("5",90.000,"2","5");
insert into reserva_silla values ("6",90.000,"3","9");
insert into reserva_silla values ("7",90.000,"3","10");
insert into reserva_silla values ("8",80.000,"4","15");
insert into reserva_silla values ("9",120.000,"5","17");
insert into reserva_silla values ("10",120.000,"5","18");
insert into reserva_silla values ("11",90.000,"6","6");
insert into reserva_silla values ("12",90.000,"6","7");
insert into reserva_silla values ("13",90.000,"6","8");












