-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: farmer_buddy_info
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `tbl_district`
--

DROP TABLE IF EXISTS `tbl_district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_district` (
  `districtid` int NOT NULL AUTO_INCREMENT,
  `districtname` varchar(70) NOT NULL,
  `croptypeids` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`districtid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_district`
--

LOCK TABLES `tbl_district` WRITE;
/*!40000 ALTER TABLE `tbl_district` DISABLE KEYS */;
INSERT INTO `tbl_district` VALUES (1,'Ahamednagar','1,2,3'),(2,'Akola','2,3,4'),(3,'Amravati','1,3'),(4,'Aurangabad','2,4'),(5,'Bhandara','1,3,4'),(6,'Beed','1,2,3,4'),(7,'Buldhana','2,3,4'),(8,'Chandrapur','2,4'),(9,'Dhule','3,4'),(10,'Gadchiroli','1,4'),(11,'Gondiia','1,2,3'),(12,'Hingoli','2,3'),(13,'Jalgaon','1,4'),(14,'Jalana','1,3,4'),(15,'Kolhapur','2,4'),(16,'Latur','1,2,3,4'),(17,'Mumbai','2,4'),(18,'Nanded','2,3,4'),(19,'Nandurbar','1'),(20,'Nasik','1,2,3'),(21,'Osmanabad','2,3,4'),(22,'Parbhani','2,3,4'),(23,'Pune','1,3'),(24,'Raigarh','2,4'),(25,'Ratnagiri','3'),(26,'Sangali','2,4'),(27,'Satara','1,2,3'),(28,'Sindhudurg','1,3,4'),(29,'Solapur','2,3,4'),(30,'Thane','3,4'),(31,'Wardha','1,2,3'),(32,'Washim','2,3,4'),(33,'Yawatmal','2,3,4');
/*!40000 ALTER TABLE `tbl_district` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-27 23:51:09
