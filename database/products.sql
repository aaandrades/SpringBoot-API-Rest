
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `idproduct` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Mechanic Keyboard','60'),(3,'Ryzen 5 3400g','310'),(4,'Ram 8Gb 3200 mhz','60'),(9,'Mouse Gamer','100'),(11,'Bye from YouTube','1');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;