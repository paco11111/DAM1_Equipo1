CREATE DATABASE  IF NOT EXISTS `Base_Datos_Reto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */;
USE `Base_Datos_Reto`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 192.168.1.109    Database: Base_Datos_Reto
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) CHARACTER SET utf8 NOT NULL,
  `descripcion` text CHARACTER SET utf8 DEFAULT NULL,
  `etapa` enum('ESO','Bachillerato','FPGS','FPGM','FPB','FPCE') CHARACTER SET utf8 NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idCurso`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'ESO1','Educacion Secundaria Obligatoria 1º','ESO',1),(2,'ESO2','Educacion Secundaria Obligatoria 2º','ESO',1),(3,'ESO3','Educacion Secundaria Obligatoria 3º','ESO',1),(4,'ESO4','Educacion Secundaria Obligatoria 4º','ESO',1),(5,'BCH1','Bachillerato 1º','Bachillerato',1),(6,'BCH2','Bachillerato 2º','Bachillerato',1),(7,'FM1','FabricaciÃ³n y montaje 1º','FPGM',1),(9,'MV1','Mantenimiento de Vehiculos 1º','FPGM',1),(10,'MV2','Mantenimiento de Vehiculos 2º','FPGM',1),(11,'CAR1','Carroceria 1º','FPGM',1),(12,'CAR2','Carroceria 2º','FPGM',1),(13,'EVA1','ElectromecÃ¡nica de Vehiculos Automoviles 1º','FPGM',1),(14,'EVA2','ElectromecÃ¡nica de Vehiculos Automoviles 2º','FPGM',1),(15,'SMR1','Sistemas Microinformaticos y Redes 1º','FPGM',1),(16,'SMR2','Sistemas Microinformaticos y Redes 2º','FPGM',1),(17,'AF1','Administracion y Finanzas 1º','FPGS',1),(18,'AF2','Administracion y Finanzas 2º','FPGS',1),(19,'DAM1','Desarrollo de Aplicaciones Multiplataforma 1º','FPGS',1),(20,'DAM2','Desarrollo de Aplicaciones Multiplataforma 2º','FPGS',1),(21,'DAW1','Desarrollo de Aplicaciones Web 1º','FPGS',1),(22,'DAW2','Desarrollo de Aplicaciones Web 2º','FPGS',1),(23,'DFM1','Diseño en Fabricacion Mecanica 1º','FPGS',1),(24,'DFM2','Diseño en Fabricacion Mecanica 2º','FPGS',1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` char(3) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `idProfesorJefe` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  UNIQUE KEY `idDepartamentos_UNIQUE` (`idDepartamento`),
  KEY `fk_profesorJefe_idx` (`idProfesorJefe`),
  CONSTRAINT `fk_profesorJefe` FOREIGN KEY (`idProfesorJefe`) REFERENCES `profesores` (`idProfesor`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'BIO','Biología y Geografia',1),(2,'DIB','Dibujo',NULL),(3,'ECO','Economía',NULL),(4,'EF','Educación Física',NULL),(5,'FIL','Filosofía',NULL),(6,'FQ','Física y Química',NULL),(7,'FRA','Francés',NULL),(8,'GH','Geografía e Historia',NULL),(9,'ING','Ingles',NULL),(10,'LAT','Latín',NULL),(11,'LEN','Lengua Castellana y Literatura',NULL),(12,'MAT','Matemáticas',NULL),(13,'MUS','Música',NULL),(14,'TEC','Tecnología',NULL),(15,'AG','Administración y Gestión',NULL),(16,'FOL','Formación y Orientación Laboral',NULL),(17,'INF','Informática y Comunicaciones',NULL),(18,'FM','Fabricación Mecánica',NULL),(19,'TMV','Transporte y Mantenimiento de Vehículos',NULL);
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) CHARACTER SET utf8 NOT NULL,
  `numero_alumnos` int(11) DEFAULT NULL,
  `idCurso` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idGrupo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `Id_Curso_grupo` (`idCurso`),
  CONSTRAINT `Id_Curso_grupo` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'ESOA',22,1,1),(2,'ESO1B',21,1,1),(3,'ESO1C',20,1,1),(4,'ESO1D',22,1,1),(5,'ESO2A',19,2,1),(6,'ESO2B',21,2,1),(7,'ESO2C',20,2,1),(8,'ESO2D',19,2,1),(9,'ESO3A',25,3,1),(10,'ESO3B',24,3,1),(11,'ESO3C',25,3,1),(12,'ESO4A',19,4,1),(13,'ESO4B',18,4,1),(14,'ESO4C',18,4,1),(15,'ESO4D',17,4,1),(16,'BCH1HCS',21,5,1),(17,'BCH1CT',22,5,1),(18,'BCH2HCS',20,6,1),(19,'BDH2CT',19,6,1),(20,'FM1',24,7,1),(22,'MV1',25,9,1),(23,'MV2',15,10,1),(24,'CAR1',25,11,1),(25,'CAR2',16,12,1),(26,'EVA1',24,13,1),(27,'EVA2',14,14,1),(28,'SMR1',28,15,1),(29,'SMR2',19,16,1),(30,'AF1',24,17,1),(31,'AF2',25,18,1),(32,'DAM1',28,19,1),(33,'DAM2',35,20,1),(34,'DAW1',24,21,1),(35,'DAW2',18,22,1),(36,'DFM1',16,23,1),(37,'DFM2',9,24,1),(38,'ESO2Z',17,1,1);
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idprofes_participantes`
--

DROP TABLE IF EXISTS `idprofes_participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idprofes_participantes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProfe` int(11) NOT NULL,
  `idSolicitud` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_profe_sol` (`id`,`idSolicitud`,`idProfe`),
  KEY `fk_profe_id_idx` (`idProfe`),
  KEY `fk_sol_id_idx` (`idSolicitud`),
  CONSTRAINT `fk_profe_id` FOREIGN KEY (`idProfe`) REFERENCES `profesores` (`idProfesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sol_id` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idprofes_participantes`
--

LOCK TABLES `idprofes_participantes` WRITE;
/*!40000 ALTER TABLE `idprofes_participantes` DISABLE KEYS */;
INSERT INTO `idprofes_participantes` VALUES (51,1,1),(52,2,2),(53,3,3);
/*!40000 ALTER TABLE `idprofes_participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idprofes_responsables`
--

DROP TABLE IF EXISTS `idprofes_responsables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idprofes_responsables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProfe` int(11) NOT NULL,
  `idSolicitud` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_profe_sol` (`id`,`idSolicitud`,`idProfe`),
  KEY `fk_profes_responsables_idx` (`idProfe`),
  KEY `fk_solocitud_id_idx` (`idSolicitud`),
  CONSTRAINT `fk_profes_responsables` FOREIGN KEY (`idProfe`) REFERENCES `profesores` (`idProfesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_solocitud_id` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idprofes_responsables`
--

LOCK TABLES `idprofes_responsables` WRITE;
/*!40000 ALTER TABLE `idprofes_responsables` DISABLE KEYS */;
INSERT INTO `idprofes_responsables` VALUES (2,5,4),(3,6,5),(4,7,6);
/*!40000 ALTER TABLE `idprofes_responsables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logprofesores`
--

DROP TABLE IF EXISTS `logprofesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logprofesores` (
  `idLogProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` char(32) DEFAULT NULL,
  `idProfesor` int(11) NOT NULL,
  `ocupacion` enum('SUPERUSUARIO','ADMINISTRADOR','EQUIPO_DIRECTIBO','PROFESOR') DEFAULT NULL,
  PRIMARY KEY (`idLogProfesor`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_logprofesor_profesor_idx` (`idProfesor`),
  KEY `fk_logprofesores_profesores_idx` (`idProfesor`),
  CONSTRAINT `fk_logprofesores_profesores` FOREIGN KEY (`idProfesor`) REFERENCES `profesores` (`idProfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logprofesores`
--

LOCK TABLES `logprofesores` WRITE;
/*!40000 ALTER TABLE `logprofesores` DISABLE KEYS */;
INSERT INTO `logprofesores` VALUES (1,'alejandro.carreraruiz@educantabria.es','202cb962ac59075b964b07152d234b70',4,'ADMINISTRADOR'),(2,'david.benitoalmeida@educantabria.es',NULL,11,'PROFESOR'),(3,'david.sanchezjunco@educantabria.es',NULL,14,'PROFESOR'),(4,'fjtruebaroja01@educantabria.es',NULL,12,'PROFESOR'),(5,'luism.serranoceballos@educantabria.es',NULL,2,'PROFESOR'),(6,'lulu.ortiz01@educantabria.es',NULL,5,'PROFESOR'),(7,'marcos.fernandezvallejo@educantabria.es',NULL,7,'PROFESOR'),(8,'mgomezarro01@educantabria.es',NULL,9,'PROFESOR'),(9,'mgutierrez95@educantabria.es',NULL,13,'PROFESOR'),(10,'olatz.sanmiguelmart@educantabria.es',NULL,3,'PROFESOR'),(11,'pablo.sanzcampo@educantabria.es',NULL,1,'PROFESOR'),(12,'rreigadasfo01@educantabria.es',NULL,6,'PROFESOR'),(13,'vmartinezba01@educantabria.es',NULL,15,'PROFESOR'),(14,'yescuderova01@educantabria.es',NULL,10,'PROFESOR');
/*!40000 ALTER TABLE `logprofesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 NOT NULL,
  `apellidos` varchar(45) CHARACTER SET utf8 NOT NULL,
  `DNI` char(9) CHARACTER SET utf8 NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  KEY `fk_profesores_IdDepartamento_idx` (`idDepartamento`),
  CONSTRAINT `fk_profesor_departamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamentos` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'Pablo','Sanz Campo','22221940W',1,1),(2,'Luis Manuel','Serrano Ceballos','84434964K',12,1),(3,'Olatz','San Miguel Martinez','04266894X',12,1),(4,'Alejandro','Carrera Ruiz','21156345S',17,1),(5,'Lulu','Ortiz Royuela','63568530G',17,1),(6,'Raul','Reigadas Fonfria','17394999M',12,1),(7,'Marcos','Fernandez Vallejo','58388245M',11,1),(9,'Manuel','Gomez Arronte','78117930Y',6,1),(10,'Yolanda','Escudero Valdes','08845506J',17,1),(11,'David','Benito Almeida','65003264B',3,1),(12,'Francisco Jose','Trueba Rojas','55452491Y',12,1),(13,'Maria','Gutierrez Castañeda','68567981Z',17,1),(14,'David','Sanchez Junco','03719263F',5,1),(15,'Victoria','Martinez Balbas','53554206S',8,1);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes` (
  `idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitante` int(11) NOT NULL,
  `actividad` varchar(100) NOT NULL,
  `tipo_actividad` enum('extraescolar','complementaria') NOT NULL,
  `previsto_programacion` tinyint(4) NOT NULL,
  `requiere_transporte` tinyint(4) NOT NULL,
  `comentario_transporte` text DEFAULT NULL,
  `finicio` date NOT NULL,
  `ffinal` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time DEFAULT NULL,
  `alojamiento` tinyint(4) NOT NULL,
  `comentario_alojamiento` text DEFAULT NULL,
  `comentarios_adicionales` text DEFAULT NULL,
  `estado` enum('SOLICITADA','DENEGADA','APROBADA','REALIZADA') NOT NULL DEFAULT 'SOLICITADA',
  `comentario_estado` text DEFAULT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `fk_Solicitudes_Profesores1_idx` (`idSolicitante`),
  CONSTRAINT `fk_solicitudes_profesores` FOREIGN KEY (`idSolicitante`) REFERENCES `profesores` (`idProfesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (1,1,'Ruta','complementaria',1,0,'bus','2024-05-10','2024-05-10','10:00:00','14:00:00',0,NULL,NULL,'APROBADA',NULL),(2,2,'Teatro','complementaria',1,0,NULL,'2023-04-07','2024-04-07','11:00:00','13:00:00',0,NULL,NULL,'APROBADA',NULL),(3,9,'Baloncesto','extraescolar',0,0,NULL,'2024-05-14','2024-05-14','09:00:00','12:30:00',0,NULL,NULL,'APROBADA',NULL),(4,6,'Natación','complementaria',1,0,'andando','2024-05-11','2024-05-11','11:30:00','13:30:00',0,NULL,NULL,'APROBADA',NULL),(5,7,'Museo','extraescolar',0,0,NULL,'2024-05-15','2024-05-15','12:00:00','14:00:00',0,NULL,NULL,'DENEGADA',NULL),(6,4,'Fútbol','extraescolar',0,0,NULL,'2024-04-07','2024-04-07','09:30:00','11:30:00',0,NULL,NULL,'APROBADA',NULL),(7,1,'Caminar','extraescolar',1,0,'Vuela','2024-05-13','2024-05-13','17:19:26','17:19:26',0,'','','APROBADA','En espera'),(8,4,'Cocinar','extraescolar',1,0,'Comentarios sobre el transporte','2024-05-26','2024-05-27','08:00:00','14:00:00',1,'Comentarios sobre el alojamiento','','SOLICITADA','');
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_aprobadas`
--

DROP TABLE IF EXISTS `solicitudes_aprobadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_aprobadas` (
  `idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `actividad` varchar(50) NOT NULL,
  `tipo_actividad` enum('extraescolar','complementaria') NOT NULL,
  `requiere_transporte` tinyint(4) NOT NULL,
  `empresa_transporte` varchar(45) DEFAULT NULL,
  `importe_transporte` double DEFAULT NULL,
  `comentario_transporte` text DEFAULT NULL,
  `finicio` date NOT NULL,
  `ffinal` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time DEFAULT NULL,
  `alojamiento` tinyint(4) NOT NULL,
  `comentario_alojamiento` text DEFAULT NULL,
  `comentarios_adicionales` text DEFAULT NULL,
  `estado` enum('aprobada','realizada') NOT NULL,
  `comentario_estado` text DEFAULT NULL,
  `comentario_actividad` text DEFAULT NULL,
  PRIMARY KEY (`idSolicitud`),
  UNIQUE KEY `fk_idSolicitud_aprobada_idx` (`idSolicitud`),
  CONSTRAINT `fk_idSolicitud_aprobada` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_aprobadas`
--

LOCK TABLES `solicitudes_aprobadas` WRITE;
/*!40000 ALTER TABLE `solicitudes_aprobadas` DISABLE KEYS */;
INSERT INTO `solicitudes_aprobadas` VALUES (1,'Teatro','complementaria',0,NULL,0,NULL,'2023-04-07','2024-04-07','11:00:00','13:00:00',0,NULL,NULL,'aprobada',NULL,NULL);
/*!40000 ALTER TABLE `solicitudes_aprobadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_has_cursos`
--

DROP TABLE IF EXISTS `solicitudes_has_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_has_cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitud` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sol_curso` (`idSolicitud`,`idCurso`),
  KEY `fk_Solicitudes_has_Cursos_Solicitudes1_idx` (`idSolicitud`),
  KEY `fk_Curso_has_idCurso` (`idCurso`),
  CONSTRAINT `fk_Curso_has_idCurso` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitudes_has_Cursos_Solicitudes1` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_has_cursos`
--

LOCK TABLES `solicitudes_has_cursos` WRITE;
/*!40000 ALTER TABLE `solicitudes_has_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudes_has_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_has_grupos`
--

DROP TABLE IF EXISTS `solicitudes_has_grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_has_grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitud` int(11) NOT NULL,
  `idGrupo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sol_grupos` (`id`,`idSolicitud`,`idGrupo`),
  KEY `fk_Solicitudes_has_Grupos_Solicitudes1_idx` (`idSolicitud`),
  KEY `fk_solicitudes_has_GrupoId` (`idGrupo`),
  CONSTRAINT `fk_Solicitudes_has_Grupos_Solicitudes1` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_solicitudes_has_GrupoId` FOREIGN KEY (`idGrupo`) REFERENCES `grupos` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_has_grupos`
--

LOCK TABLES `solicitudes_has_grupos` WRITE;
/*!40000 ALTER TABLE `solicitudes_has_grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudes_has_grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_has_transporte`
--

DROP TABLE IF EXISTS `solicitudes_has_transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_has_transporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitud` int(11) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sol_transporte` (`id`,`idSolicitud`,`idTransporte`),
  KEY `fk_Solicitudes_has_Transporte_Transporte1_idx` (`idTransporte`),
  KEY `fk_Solicitudes_has_Transporte_Solicitudes1_idx` (`idSolicitud`),
  CONSTRAINT `fk_Solicitudes_has_Transporte_Solicitudes1` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Solicitudes_has_Transporte_Transporte1` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_has_transporte`
--

LOCK TABLES `solicitudes_has_transporte` WRITE;
/*!40000 ALTER TABLE `solicitudes_has_transporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudes_has_transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transporte`
--

DROP TABLE IF EXISTS `transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporte` (
  `idTransporte` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_transporte` varchar(20) NOT NULL,
  `descripcion` text DEFAULT NULL,
  PRIMARY KEY (`idTransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (1,'Avion','AirEuropa'),(2,'Bus','AirEuropa'),(3,'Tren','AirEuropa'),(4,'Barco','AirEuropa'),(13,'',''),(14,' Tren','');
/*!40000 ALTER TABLE `transporte` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22  0:44:07
