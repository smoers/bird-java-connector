CREATE TABLE "auteurs" (
"id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"nom"  CHAR(100) NOT NULL,
"aliasauteur"  CHAR(100),
"biographie"  BLOB,
"photo"  CHAR(100),
"website"  CHAR(250),
"datecreation"  DATETIME,
"datenaissance"  DATE,
"prenom"  CHAR(100) NOT NULL,
"commentaire"  BLOB
);
CREATE TABLE "cycles" (
"id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"idauteur"  INTEGER,
"titrecycle"  CHAR(100),
"cycle"  BOOLEAN NOT NULL DEFAULT FALSE,
"datecreation"  DATETIME,
"nbrtome"  INTEGER,
"commentaire"  BLOB,
CONSTRAINT "f_auteurs_cycles" FOREIGN KEY ("idauteur") REFERENCES "auteurs" ("id") ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE "livres" (
"id"  INTEGER NOT NULL,
"idcycle"  INTEGER NOT NULL,
"titre"  CHAR(100) NOT NULL,
"style"  VARCHAR(250),
"presentation"  BLOB,
"pochette"  CHAR(200),
"editeur"  CHAR(100),
"collection"  CHAR(100),
"isbn"  CHAR(100),
"datecreation"  DATE,
PRIMARY KEY ("id" ASC),
CONSTRAINT "f_livres_cycles" FOREIGN KEY ("idcycle") REFERENCES "cycles" ("id") ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE "systeme" ("id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "valeur" VARCHAR(250) NOT NULL , "filtre" VARCHAR(250) NOT NULL , "supp" BOOL NOT NULL  DEFAULT FALSE);
CREATE VIEW "sys_auteurs_list" AS SELECT auteurs.id, auteurs.nom, auteurs.prenom, auteurs.aliasauteur  FROM auteurs;
CREATE VIEW `sys_cycles_livres_list`
-- This View created by Visual Query Builder - SQLite2009 Pro Enterprise Manager
-- Osen Kusnadi <support@osenxpsuite.net> - http://www.osenxpsuite.net
-- Created date: 2011-12-12 21:14:11 [smoers@PC07]
AS
SELECT 
      cycles.id,
      cycles.idauteur,
      livres.id,
      livres.idcycle,
      sys_style.id,
      cycles.titrecycle,
      cycles.cycle,
      livres.titre,
      sys_style.valeur,
      livres.editeur,
      livres.collection
      
FROM 
      cycles
      INNER JOIN livres ON (cycles.id = livres.idcycle)
      INNER JOIN sys_style ON (sys_style.id = livres.style);
CREATE VIEW "sys_style" AS select * from systeme where filtre='Style';
CREATE INDEX "idx_auteurs"
ON "auteurs" ("nom" ASC, "prenom" ASC);
CREATE INDEX "idx_cycle"
ON "cycles" ("titrecycle" ASC);
CREATE INDEX "idx_idauteur"
ON "cycles" ("idauteur" ASC);
CREATE INDEX "idx_systeme" ON "systeme" ("filtre" ASC);
