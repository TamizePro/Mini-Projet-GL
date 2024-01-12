-- Base de données
drop database if exists `gilles_bourama_alain`;
create database `gilles_bourama_alain`;
use `gilles_bourama_alain`;

-- Création des tables suivant notre diagramme des classes
-- Compte dao is ok
create table `Compte`
(
    `login` varchar(16) NOT NULL PRIMARY KEY,
    `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Note dao is ok
create table `Note`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `note_value`  float,
    `etd_absent` char(1),
    CONSTRAINT `ck_etd_absent` CHECK (`etd_absent` IN ('T', 'F'))
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Professeur dao is ok
create table `Professeur`
(
    `code` bigint NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL,
    `specialite` varchar(16) NOT NULL,
    `compte_login` varchar(16) NOT NULL,
    FOREIGN KEY (`compte_login`) REFERENCES `Compte`(`login`) on update cascade on delete cascade,
    UNIQUE(`compte_login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- admin dao is ok
create table `Admin`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL,
    `compte_login` varchar(16) NOT NULL,
    FOREIGN KEY (`compte_login`) REFERENCES `Compte`(`login`) on update cascade on delete cascade,
    UNIQUE(`compte_login`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Modalite_Evaluation DAO is ok
create table `Modalite_Evaluation`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `coef` float NOT NULL,
    `code_note` int,
    FOREIGN KEY (`code_note`) REFERENCES `Note`(`code`) on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Element_Module DAO is ok
create table `Element_Module`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `coef` float NOT NULL,
    `validation` char(1) DEFAULT 'F',
    `code_modal` int,
    CONSTRAINT `ck_validation` CHECK (`validation` IN ('T', 'F')),
    FOREIGN KEY (`code_modal`) REFERENCES `Modalite_Evaluation`(`code`) on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Module DAO is ok
create table `Module`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `semestre` char(2) NOT NULL,
    `validation` char(1) DEFAULT 'F',
    `code_elmodul` int,
    CONSTRAINT `ck_validation` CHECK (`validation` IN ('T', 'F')),
    FOREIGN KEY (`code_elmodul`) REFERENCES `Element_Module`(`code`) on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Filiere dao is ok
create table `Filiere`
(
    `code` int NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL,
    `code_modul` int,
    FOREIGN KEY (`code_modul`) REFERENCES `Module`(`code`) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Etudiant dao is ok
create table `Etudiant`
(
    `code` bigint NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL,
    `code_note` int,
    FOREIGN KEY (`code_note`) REFERENCES `Note`(`code`) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Etd_elementmodul DAO is ok
create table `Etd_elementmodul`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `code_etd` bigint NOT NULL,
    `code_elementmodul` int NOT NULL,
    FOREIGN KEY (`code_etd`) REFERENCES `Etudiant`(`code`) on update cascade on delete cascade,
    FOREIGN KEY (`code_elementmodul`) REFERENCES `Element_Module`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 
create table `Filiere_elementmodul`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `code_filiere` int NOT NULL,
    `code_elementmodul` int NOT NULL,
    FOREIGN KEY (`code_filiere`) REFERENCES `Filiere`(`code`) on update cascade on delete cascade,
    FOREIGN KEY (`code_elementmodul`) REFERENCES `Element_Module`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Ajout d'un compte administrateur
insert into `Compte` values("admin_admin", "3dd408f20375d691865c823a2cb5b15c");
insert into `Admin`(`nom`, `prenom`, `compte_login`) values("GNEME", "Gilles", "admin_admin");

-- Ajout données de test
insert into `Compte` values("bourama", "hello");
insert into `Compte` values("gg", "ggpwd");
insert into `Compte` values('alain', 'hello');
insert into `Etudiant`(`code`, `nom`, `prenom`) values(20, "gg", "ggg");
insert into `Etudiant`(`code`, `nom`, `prenom`) values(21, "Test", "test");
insert into `Filiere`(`code`, `nom`) values(2, "IRIC");
insert into `Filiere`(`code`, `nom`) values(3, "GI");
insert into `Professeur` values(13, "Nom", "Prenom", "Maths", "bourama");
insert into `Professeur` values(14, "Nomd", "Prenoms", "Maths", "admin_admin");
insert into `Professeur` values(11, "Nom", "Prenom", "Maths", "alain");
-- insert into `Note`(`note_value`, `etd_absent`) values(20, 'F'); --for ModaliteEvaluationDAOTest
