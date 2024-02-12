-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: puma
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `memberID` int NOT NULL,
  `memberName` varchar(60) NOT NULL,
  `memberAddress` varchar(100) NOT NULL,
  `memberPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`memberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'Ted Conrad','ted@amail.com','5678'),(2,'Ellen Browning','ellen@amail.com','9245'),(3,'Gorrister Strong','gorry@amail.com','1062'),(4,'Benny Rios','ben@amail.com','4367'),(5,'Nimdok Brady','doktor@amail.com','1488'),(6,'Frankie Soto','frank@amail.com','5555'),(7,'Tiffany Barber','tiffany@amail.com','3128'),(8,'Sydney Harris','sidney@amail.com','6783'),(9,'Gustavo Fischer','callmegus@amail.com','3290'),(10,'Bear Manning','bigman@amail.com','8973'),(11,'Khaleesi Duarte','khaleesi@amail.com','5324'),(12,'Walter White','heisenberg@amail.com','7891'),(13,'Jesse Pinkman','cptcook@amail.com','2314'),(14,'Mike Ehrmantraut','halfmeasure@amail.com','7568'),(15,'Skyler White','ted@amail.com','8976'),(16,'Jeremy Waller','jeremy@amail.com','3212'),(17,'Phillip Hogan','philips@amail.com','1239'),(18,'Jolie Conner','jolly@amail.com','5469'),(19,'Chase Patrick','chasethebro@amail.com','6781'),(20,'Jimmy Mcgill','bettercall@amail.com','7893'),(21,'Joseph Joestar','bestjojo@amail.com','3544'),(22,'Reese Washington','reese@amail.com','9783'),(23,'Jane Sherman','jane@amail.com','4363'),(24,'Helen Lee','helen@amail.com','4781'),(25,'Lorenzo Daniels','lorenzo@amail.com','1287'),(26,'Alexandra Hinton','alex@amail.com','6780'),(27,'Marcus Duncan','mark@amail.com','8976'),(28,'Gabriel Holt','gabby@amail.com','3508'),(29,'Vance Pope','vance@amaiil.com','4598'),(30,'Ahmet Mehmet Yusuf','ahmetyusuf@amail.com','123'),(31,'Berk','berk@amail.com','asd'),(32,'Mert','mert@amail.com','123');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-08  0:16:57
