-- Base de données
drop database if exists `gilles_bourama_alain`;
create database `gilles_bourama_alain`;
use `gilles_bourama_alain`;

-- Création des tables suivant notre diagramme des classes
create table `Compte`
(
    `login` varchar(16) NOT NULL PRIMARY KEY,
    `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `Filiere`
(
    `code` int NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `Etudiant`
(
    `code` bigint NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `Professeur`
(
    `code` bigint NOT NULL PRIMARY KEY,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL,
    `specialite` varchar(16) NOT NULL,
    `compte_login` varchar(16) NOT NULL,
    FOREIGN KEY (`compte_login`) REFERENCES `Compte`(`login`) on update cascade on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `Admin`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `prenom` varchar(16) NOT NULL,
    `compte_login` varchar(16) NOT NULL,
    FOREIGN KEY (`compte_login`) REFERENCES `Compte`(`login`) on update cascade on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Module`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `semestre` char(2) NOT NULL,
    `validation` char(1) DEFAULT 'F',
    `code_filiere` int NOT NULL,
    CONSTRAINT `ck_validation` CHECK (`validation` IN ('T', 'F')),
    FOREIGN KEY (`code_filiere`) REFERENCES `Filiere`(`code`) on update cascade on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Element_Module`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `coef` tinyint NOT NULL,
    `validation` char(1) DEFAULT 'F',
    `code_prof` bigint NOT NULL,
    `code_modul` int NOT NULL,
    CONSTRAINT `ck_validation` CHECK (`validation` IN ('T', 'F')),
    FOREIGN KEY (`code_prof`) REFERENCES `Professeur`(`code`) on update cascade,
    FOREIGN KEY (`code_modul`) REFERENCES `Module`(`code`) on update cascade on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Modalite_Evaluation`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `nom` varchar(16) NOT NULL,
    `coef` tinyint NOT NULL,
    `code_elmodul` int NOT NULL,
    FOREIGN KEY (`code_elmodul`) REFERENCES `Element_Module`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Note`
(
    `code` int PRIMARY KEY AUTO_INCREMENT,
    `note_value`  tinyint,
    `etd_absent` char(1),
    `code_etd` bigint NOT NULL,
    `code_modaleval` int NOT NULL,
    FOREIGN KEY (`code_etd`) REFERENCES `Etudiant`(`code`) on update cascade on delete cascade,
    FOREIGN KEY (`code_modaleval`) REFERENCES `Modalite_Evaluation`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Etd_elementmodul`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `code_etd` bigint NOT NULL,
    `code_elementmodul` int NOT NULL,
    FOREIGN KEY (`code_etd`) REFERENCES `Etudiant`(`code`) on update cascade on delete cascade,
    FOREIGN KEY (`code_elementmodul`) REFERENCES `Element_Module`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `Filiere_elementmodul`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `code_filiere` int NOT NULL,
    `code_elementmodul` int NOT NULL,
    FOREIGN KEY (`code_filiere`) REFERENCES `Filiere`(`code`) on update cascade on delete cascade,
    FOREIGN KEY (`code_elementmodul`) REFERENCES `Element_Module`(`code`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Ajout d'un compte administrateur
insert into `Compte` values("admin_admin", "21232f297a57a5a743894a0e4a801fc3");
insert into `Admin`(`nom`, `prenom`, `compte_login`) values("GNEME", "Gilles", "admin_admin");

-- Ajout données de test
insert into `Compte` values("bourama", "hello");
insert into `Compte` values("gg", "ggpwd");
