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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `C_ID` varchar(4) NOT NULL,
  `C_LName` varchar(20) DEFAULT NULL,
  `C_FName` varchar(20) DEFAULT NULL,
  `C_Address` varchar(40) DEFAULT NULL,
  `Cell_Num` varchar(10) DEFAULT NULL,
  `C_Email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('1001','Asperilla','Archangel','Rizal Avenue','9295556354','archangelis20@hotmail.com'),('1002','Pedroso','Sheryll','148-C Haig Street','9285555882','pedroso024@gmail.com'),('1003','Aquino','Romel','4848 Rosal St.','9246432112','aquino420@yahoo.com'),('1004','Kwan','Joren','Alc Realty Building 1200','9461222313','kwanjoren09@gmail.com'),('1005','Go','Liza','668 Muelle De Binondo, Binondo','9573012345','lizago910@yahoo.com'),('1006','Weng','Anna','National Highway','9456230124','wenganna06@gmail.com'),('1007','Leh','Margaret','Caloocan City','9572012335','margaretleh023@gmail.com'),('1008','Lui','Emily','Chins Express','9670238123','emilylui@gmail.com'),('1009','Mendez-Ella','Jojo','Downtown Center Building','9750782612','jojomendezella@outlook.com'),('1010','Edilynbenting','Maria','1855 Eastwood Avenue','9674506703','mariaedilynbenting@yahoo.com'),('1011','Dong','Yang Zhang','J.P. Laurel Avenue','9057123562','yangzhangdong@gmail.com'),('1012','Bulayo','Mitsy Anne','71 N. Zamora Street','9670345123','mitsyannebulayo@hotmail.com'),('1013','Gonzales','Elaine','Reparo Road, Potrero','9145321267','elainegonzales@gmail.com'),('1014','Dela Cruz','Dennis','Ayala Center, Business Park','9608645345','dennisdelacruz@outlook.com'),('1015','Nicholas','Ron','A. Soriano','9680384671','ronnicholas014@gmail.com'),('1016','Mateo','John Carlo','71 N. Zamora Street','9780784451','johncarlomateo@yahoo.com'),('1017','Chung','Diane','648 Herbosa Street 1000','9707894512','dianechung@outlook.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-03  2:04:04
