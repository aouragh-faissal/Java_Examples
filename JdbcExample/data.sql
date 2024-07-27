DROP DATABASE IF EXISTS WebStore;
CREATE DATABASE WebStore;
USE WebStore;


-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	IdUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login				varchar(20)	NOT NULL,
	Password			varchar(20)	NOT NULL,
	ConnectionNumber	int(4)		NOT NULL DEFAULT 0
) ;

INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 1, 'Anderson',	'Neo' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 2, 'Skywalker',	'Luke' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 3, 'Plissken',	'Snake' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 4, 'Ripley',		'Ellen' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 5, 'Bond',		'James' );