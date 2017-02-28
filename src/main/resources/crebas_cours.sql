/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  28/02/2017 10:51:17                      */
/*==============================================================*/


drop table if exists Cours;

drop table if exists Eleve;

drop table if exists Note;

/*==============================================================*/
/* Table : Cours                                                */
/*==============================================================*/
create table Cours
(
   ID_COURS             int(5) not null auto_increment,
   LIBELLE              varchar(254),
   NB_HEURES            int,
   primary key (ID_COURS)
);

/*==============================================================*/
/* Table : Eleve                                                */
/*==============================================================*/
create table Eleve
(
   ID_ELEVE             int(5) not null auto_increment,
   NOM                  varchar(250) not null,
   PRENOM               varchar(250),
   EMAIL                varchar(150) not null,
   PASSWORD             varchar(254),
   CODE_POSTAL          int,
   CODE_DEPARTEMENT     int,
   SEXE                 int,
   DATE_INSCRIPTION     datetime,
   primary key (ID_ELEVE)
);

/*==============================================================*/
/* Table : Note                                                 */
/*==============================================================*/
create table Note
(
   ID_COURS             int(5) not null,
   ID_ELEVE             int(5) not null,
   NOTE_OBTENUE         numeric(8,0) not null,
   DATE_EXAMEN          datetime not null,
   CODE_MENTION         int,
   primary key (ID_ELEVE, ID_COURS)
);

alter table Note add constraint FK_COURS_APOUR_NOTES foreign key (ID_COURS)
      references Cours (ID_COURS) on delete restrict on update restrict;

alter table Note add constraint FK_ELEVE_APOUR_NOTES foreign key (ID_ELEVE)
      references Eleve (ID_ELEVE) on delete restrict on update restrict;

