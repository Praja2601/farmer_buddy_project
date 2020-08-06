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
-- Table structure for table `tbl_userdetail`
--

DROP TABLE IF EXISTS `tbl_userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_userdetail` (
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` decimal(12,0) DEFAULT NULL,
  `userid` int NOT NULL,
  `userdetailid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userdetailid`),
  KEY `userid` (`userid`),
  CONSTRAINT `tbl_userdetail_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `tbl_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_userdetail`
--

LOCK TABLES `tbl_userdetail` WRITE;
/*!40000 ALTER TABLE `tbl_userdetail` DISABLE KEYS */;
INSERT INTO `tbl_userdetail` VALUES ('Arul','Kumar','arulkumar@gmail.com',7845122356,1,1),('Prajakta','Yadav','prajaktayadav@gmail.com',9887542176,2,2),('Gauri','Deshmukh','gaurideshmukh@gmail.com',8888754217,3,3),('Aniruddha','Yadav','aniruddhayadav@gmail.com',9688754217,4,4),('Komal','Mithari','komal@gmail.com',7875726413,5,5),('Ajay','Yadav','ajay@gmail.com',9988776757,12,6),('Uday','Yadav','undefined',9764318753,13,7),('undefined','Jadhav','hari@gmail.com',7654876598,14,8),('Sneha','Mithari','sneha@gmail.com',7654321876,15,9),('Ketaki','Khegare','ketaki@gmail.com',7845986532,17,10);
/*!40000 ALTER TABLE `tbl_userdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-06 15:52:58
