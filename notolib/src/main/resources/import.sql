INSERT INTO person (person_type,first_name,last_name,email,phone_number)
VALUES
  ("N","Notary","Notary","notary@gmail.com","06 97 95 28 15"),
  ("N","Reese","Velez","rutrum@yahoo.org","06 97 95 28 15"),
  ("N","Orlando","Ware","diam.luctus@aol.org","04 33 77 18 84"),
  ("N","Kimberley","Cantu","molestie.in@yahoo.couk","07 33 51 73 31"),
  ("N","Lucas","Ross","eu.arcu@protonmail.edu","04 34 77 06 98"),
  ("N","Anjolie","Skinner","tellus.nunc@outlook.edu","06 68 63 24 34"),
  ("N","Joshua","Serrano","non.cursus@hotmail.com","01 82 32 07 07"),
  ("N","Bevis","Harrell","ornare.in.faucibus@protonmail.com","08 34 07 40 42"),
  ("N","Naida","Roth","mattis.ornare@outlook.couk","06 08 91 43 03"),
  ("N","Kelly","Stark","odio.etiam.ligula@google.net","06 61 53 34 60"),
  ("N","Melodie","Phillips","proin.ultrices@protonmail.net","09 31 45 16 64"),
  ("N","Samson","Villarreal","neque.pellentesque.massa@outlook.ca","08 20 41 36 98"),
  ("N","Raymond","Gates","arcu.sed@protonmail.org","02 16 87 41 14"),
  ("N","Nomlanga","Rush","sapien.molestie@outlook.com","02 62 30 56 72"),
  ("N","Madeson","Francis","etiam.bibendum.fermentum@yahoo.edu","08 25 55 85 47"),
  ("N","Deirdre","Preston","erat.neque.non@google.com","05 56 72 62 87"),
  ("N","Erich","Guerrero","convallis@outlook.couk","04 71 66 58 62"),
  ("N","Liberty","Beach","dui.augue.eu@hotmail.net","05 11 28 94 49"),
  ("N","Yoshi","Haley","risus.duis@yahoo.org","06 93 28 85 57"),
  ("N","Forrest","Branch","urna.suscipit@protonmail.ca","01 34 44 31 15"),
  ("A","Acquirer","Acquirer","acquirer@gmail.com","06 97 95 28 15"),
  ("A","Plato","Harris","natoque@outlook.com","02 24 73 15 78"),
  ("A","Charissa","Todd","magna.a@protonmail.ca","05 38 15 89 24"),
  ("A","Constance","Nash","mollis.integer.tincidunt@icloud.net","06 81 21 72 47"),
  ("A","Chastity","Padilla","lacus.nulla.tincidunt@aol.com","03 63 25 97 27"),
  ("A","Isaac","Byrd","turpis@hotmail.com","07 41 68 15 01"),
  ("A","Riley","Fuller","iaculis.aliquet@google.edu","02 41 81 40 77"),
  ("A","Amy","Carey","mi.lorem@yahoo.ca","09 77 98 76 28"),
  ("A","Jacob","Duncan","phasellus.elit@icloud.ca","04 26 98 07 73"),
  ("A","Kirk","Carey","pede.ultrices.a@icloud.couk","09 38 54 22 44"),
  ("A","Kristen","Greene","quisque.porttitor.eros@aol.org","05 12 21 97 94"),
  ("A","Chanda","Benton","duis.dignissim@google.org","05 36 78 73 37"),
  ("A","Autumn","Adkins","egestas.duis.ac@google.ca","04 80 47 76 15"),
  ("A","Jana","Best","phasellus@outlook.org","05 98 55 53 29"),
  ("A","Hasad","Boyer","egestas.nunc@google.ca","02 65 13 21 11"),
  ("A","Nasim","Ray","lacinia.orci@protonmail.edu","02 04 68 83 38"),
  ("A","Delilah","Davidson","ullamcorper@protonmail.net","01 25 32 62 58"),
  ("A","Kiona","Sparks","ut@icloud.com","03 37 96 65 02"),
  ("A","Daniel","Joyner","massa@google.com","02 74 74 77 46"),
  ("A","Nayda","Mcgee","augue.malesuada@aol.edu","04 86 30 45 65");

INSERT INTO time_slot (day_of_week,start_time,end_time,person_id)
VALUES
    ("MONDAY","10:23","16:03",1),
    ("MONDAY","11:20","16:03",1),
    ("TUESDAY","10:23","16:03",1),
    ("TUESDAY","11:20","16:03",1),
    ("WEDNESDAY","10:23","16:03",1),
    ("WEDNESDAY","11:20","16:03",1),
    ("THURSDAY ","10:23","16:03",1),
    ("THURSDAY","11:20","16:03",1),
    ("FRIDAY","11:13","14:45",1),
    ("FRIDAY","10:55","16:20",1),
    ("SATURDAY","10:55","16:20",1),
    ("SATURDAY","11:20","16:20",1),
    ("SUNDAY","11:20","16:20",1),
    ("SUNDAY","11:50","16:20",1),
    ("WEDNESDAY","11:44","14:38",3),
    ("FRIDAY","13:45","14:08",11),
    ("THURSDAY","9:32","14:15",5),
    ("WEDNESDAY","10:23","16:03",20),
    ("FRIDAY","12:32","16:40",17),
    ("TUESDAY","13:14","14:23",19),
    ("SATURDAY","11:20","16:16",10),
    ("MONDAY","11:33","18:00",15),
    ("THURSDAY","11:17","15:01",8),
    ("THURSDAY","13:13","18:46",4),
    ("SUNDAY","13:50","17:40",4),
    ("SATURDAY","11:23","14:35",10),
    ("TUESDAY","11:21","17:56",19),
    ("WEDNESDAY","10:29","15:11",19),
    ("TUESDAY","11:18","15:54",3),
    ("SATURDAY","11:06","15:38",11),
    ("TUESDAY","12:41","17:10",5),
    ("SATURDAY","11:38","14:49",20),
    ("MONDAY","11:26","16:20",1),
    ("WEDNESDAY","12:18","18:27",13),
    ("SUNDAY","13:37","17:23",5),
    ("FRIDAY","12:12","17:38",10),
    ("SUNDAY","10:13","18:59",13),
    ("WEDNESDAY","12:10","17:31",3),
    ("WEDNESDAY","13:34","16:27",2),
    ("FRIDAY","11:24","18:17",11),
    ("FRIDAY","12:52","15:47",13),
    ("MONDAY","10:09","17:07",11),
    ("WEDNESDAY","11:58","17:47",7),
    ("FRIDAY","11:10","17:59",13),
    ("SUNDAY","13:59","16:34",10),
    ("SUNDAY","12:26","17:38",3),
    ("WEDNESDAY","13:17","15:02",8),
    ("MONDAY","10:57","18:16",11),
    ("THURSDAY","9:46","16:46",17),
    ("WEDNESDAY","12:18","18:05",8),
    ("WEDNESDAY","13:34","15:46",18),
    ("SATURDAY","11:28","17:47",13),
    ("SATURDAY","10:49","15:27",18);

INSERT INTO booking (date,timeSlot_time_slot_id,acquirer_person_id)
VALUES
    ("2022-01-02",36,24),
    ("2022-01-01",10,28),
    ("2021-12-30",39,26),
    ("2022-01-20",35,30),
    ("2022-01-12",27,36),
    ("2022-01-20",4,35),
    ("2021-12-21",10,32),
    ("2021-12-09",33,29),
    ("2021-12-26",20,36),
    ("2022-01-27",33,27),
    ("2022-01-26",25,28),
    ("2022-01-04",33,40),
    ("2021-12-11",5,25),
    ("2022-01-16",21,25),
    ("2021-12-13",15,37),
    ("2022-01-20",23,35),
    ("2021-12-19",11,29),
    ("2022-01-31",8,22),
    ("2021-12-16",20,22),
    ("2022-01-05",2,39);

INSERT INTO lodging (person_id,title,description,price,picture)
VALUES
    (NULL,"Jolie maison avec terrasse","consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt",227690,"https:/www.appartement.org/wp-content/uploads/2019/11/195449379.jpg"),
    (NULL,"Immeuble contemporain","Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis",282084,"https:/cdn.pixabay.com/photo/2013/10/12/18/05/villa-194671_960_720.jpg"),
    (NULL,"Appartement 5eme ??tage","eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam",189377,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Immeuble contemporain","magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet lectus quis",310480,"https:/www.lesservicesdemacarte.fr/wp-content/uploads/2020/06/ac8d3f464de61fcf2923d258b4c57545481a7079_paris11-oberkampf-appartement-cuisine-web-min.jpg"),
    (NULL,"Immeuble contemporain","ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate,",375601,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Appartement 5eme ??tage","orci, in consequat enim diam vel arcu. Curabitur ut odio vel est tempor bibendum. Donec",378738,"https:/www.appartement.org/wp-content/uploads/2019/11/195449379.jpg"),
    (NULL,"Maison bord de mer","aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus",112491,"https:/www.appartement.org/wp-content/uploads/2019/11/195449379.jpg"),
    (NULL,"Appartement chic","mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac",246870,"https:/www.lesservicesdemacarte.fr/wp-content/uploads/2020/06/ac8d3f464de61fcf2923d258b4c57545481a7079_paris11-oberkampf-appartement-cuisine-web-min.jpg"),
    (NULL,"Maison r??nov??e","nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices",223446,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Immeuble contemporain","sed turpis nec mauris blandit mattis. Cras eget nisi dictum augue malesuada malesuada. Integer id",221015,"https:/www.appartement.org/wp-content/uploads/2019/11/195449379.jpg"),
    (NULL,"Maison r??nov??e","erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum.",274736,"https:/content-cdn.trucs-et-astuces.co/2018/10/maison.png"),
    (NULL,"Appartement chic","Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus",116042,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Appartement chic","lorem eu metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue,",226203,"https:/content-cdn.trucs-et-astuces.co/2018/10/maison.png"),
    (NULL,"Appartement 5eme ??tage","Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt pede ac urna. Ut",181293,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Maison bord de mer","euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu",163438,"https:/www.maisons-mca.com/wp-content/uploads/terrasse-maison.jpg"),
    (NULL,"Maison r??nov??e","ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae Donec tincidunt. Donec",235131,"https:/maison-monde.com/wp-content/uploads/2017/03/olivette-antigua-1.jpg"),
    (NULL,"Immeuble contemporain","sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque",222780,"https:/cdn.pixabay.com/photo/2013/10/12/18/05/villa-194671_960_720.jpg"),
    (NULL,"Maison r??nov??e","libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis,",323772,"https:/www.lesservicesdemacarte.fr/wp-content uploads/2020/06/ac8d3f464de61fcf2923d258b4c57545481a7079_paris11-oberkampf-appartement-cuisine-web-min.jpg"),
    (NULL,"Immeuble contemporain","ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum",309569,"https:/maison-monde.com/wp-content/uploads/2017/03/olivette-antigua-1.jpg"),
    (NULL,"Maison bord de mer","nunc risus varius orci, in consequat enim diam vel arcu. Curabitur ut odio vel est",347260,"https:/content-cdn.trucs-et-astuces.co/2018/10/maison.png");



