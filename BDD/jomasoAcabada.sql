-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para jomaso
CREATE DATABASE IF NOT EXISTS `jomaso` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `jomaso`;

-- Volcando estructura para tabla jomaso.compite
CREATE TABLE IF NOT EXISTS `compite` (
  `id_equipos` int(11) NOT NULL,
  `id_torneo` int(11) NOT NULL,
  `fecha_checking` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  PRIMARY KEY (`id_equipos`,`id_torneo`),
  KEY `id_torneocompite` (`id_torneo`),
  CONSTRAINT `id_equiposcompite` FOREIGN KEY (`id_equipos`) REFERENCES `equipos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_torneocompite` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.deportes
CREATE TABLE IF NOT EXISTS `deportes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `admin` int(11) NOT NULL,
  `logo` blob DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adminequipo` (`admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.juega
CREATE TABLE IF NOT EXISTS `juega` (
  `id_usuario` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_deporte`),
  KEY `fk_laideporte` (`id_deporte`),
  CONSTRAINT `fk_laideporte` FOREIGN KEY (`id_deporte`) REFERENCES `deportes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_laidusuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.participa
CREATE TABLE IF NOT EXISTS `participa` (
  `id_usuario` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  PRIMARY KEY (`id_equipo`,`id_usuario`),
  KEY `fk_idusuario` (`id_usuario`),
  CONSTRAINT `fk_idequipo` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.practica
CREATE TABLE IF NOT EXISTS `practica` (
  `id_equipo` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL,
  PRIMARY KEY (`id_equipo`,`id_deporte`),
  KEY `fk_iddeportepractica` (`id_deporte`),
  CONSTRAINT `fk_iddeportepractica` FOREIGN KEY (`id_deporte`) REFERENCES `deportes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idequipopractica` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.torneos
CREATE TABLE IF NOT EXISTS `torneos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.trata
CREATE TABLE IF NOT EXISTS `trata` (
  `id_torneo` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL,
  PRIMARY KEY (`id_torneo`,`id_deporte`),
  KEY `id_deportetrata` (`id_deporte`),
  CONSTRAINT `id_deportetrata` FOREIGN KEY (`id_deporte`) REFERENCES `deportes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_torneotrata` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla jomaso.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `contrasenya` varchar(100) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `foto` blob DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
