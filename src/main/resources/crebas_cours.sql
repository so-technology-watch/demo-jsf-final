/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  28/02/2017 10:51:17                      */
/*==============================================================*/

drop table if exists Note;

drop table if exists Cours;

drop table if exists Eleve;

drop table if exists TypeMention;

drop table if exists TypeSexe;


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
   SEXE                 int(5) not null,
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
   CODE_MENTION         int(5),
   primary key (ID_ELEVE, ID_COURS)
);

alter table Note add constraint FK_COURS_APOUR_NOTES foreign key (ID_COURS)
      references Cours (ID_COURS) on delete restrict on update restrict;

alter table Note add constraint FK_ELEVE_APOUR_NOTES foreign key (ID_ELEVE)
      references Eleve (ID_ELEVE) on delete restrict on update restrict;

/*==============================================================*/
/* Table : TypeMention                                                 */
/*==============================================================*/
create table TypeMention
(
   ID_MENTION           int(5) not null,
   LABEL_MENTION        varchar(150) not null,
   primary key (ID_MENTION)
);

alter table Note add constraint FK_NOTE_APOUR_MENTION foreign key (CODE_MENTION)
      references TypeMention (ID_MENTION) on delete restrict;
      
/*==============================================================*/
/* Table : TypeSexe                                                 */
/*==============================================================*/
create table TypeSexe
(
   ID_SEXE           int(5) not null,
   LABEL_SEXE        varchar(150) not null,
   primary key (ID_SEXE)
);

alter table Eleve add constraint FK_ELEVE_APOUR_SEXE foreign key (SEXE)
      references TypeSexe (ID_SEXE) on delete restrict;

      
/*==============================================================*/
/* INSERT                                                 */
/*==============================================================*/
      
INSERT INTO `typesexe` (`ID_SEXE`, `LABEL_SEXE`) VALUES ('1', 'Homme'), ('2', 'Femme');
INSERT INTO `typemention` (`ID_MENTION`, `LABEL_MENTION`) VALUES ('1', 'Faible'), ('2', 'Insuffisant'), ('3', 'Passable'), ('4', 'Assez bien'), ('5', 'Bien'), ('6', 'Trés Bien'), ('7', 'Excellent');