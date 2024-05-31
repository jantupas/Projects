-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: xialanshaomai
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Ord_ID` varchar(5) NOT NULL,
  `C_ID` varchar(4) DEFAULT NULL,
  `Prod_ID` varchar(3) DEFAULT NULL,
  `Ord_Qty` varchar(2) DEFAULT NULL,
  `Ord_Cost` varchar(250) DEFAULT NULL,
  `Date_Ord` varchar(20) DEFAULT NULL,
  `Trans_ID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Ord_ID`),
  KEY `C_ID` (`C_ID`),
  KEY `Prod_ID` (`Prod_ID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Prod_ID`) REFERENCES `product` (`Prod_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('12345','1001','111','4','880','2022-02-12','1111'),('12346','1002','222','8','1440','2022-01-30','1112'),('12347','1003','333','2','300','2022-04-12','1113'),('12348','1004','444','4','1360','2022-02-23','1114'),('12349','1005','555','8','2720','2022-03-04','1115'),('12350','1006','666','3','1140','2022-01-24','1116'),('12351','1007','111','1','220','2022-02-06','1117'),('12352','1008','222','5','900','2022-02-21','1118'),('12353','1009','333','4','600','2022-02-21','1119'),('12354','1010','444','2','680','2022-04-07','1120'),('12355','1011','555','5','1700','2022-01-06','1121'),('12356','1012','666','6','2280','2022-03-21','1122'),('12357','1013','111','2','440','2022-01-20','1123'),('12358','1014','222','4','720','2022-02-26','1124'),('12359','1015','333','5','750','2022-01-24','1125'),('12360','1016','444','2','888','2022-04-12','1126'),('12361','1017','555','4','1360','2022-03-17','1127');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-03  2:04:05
