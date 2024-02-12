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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `bookID` int NOT NULL,
  `bookName` varchar(100) NOT NULL,
  `bookAuthor` varchar(45) NOT NULL,
  `bookGenre` varchar(30) NOT NULL,
  `bookLength` int NOT NULL,
  `bookDate` date NOT NULL,
  `bookStatus` tinyint NOT NULL,
  PRIMARY KEY (`bookID`),
  UNIQUE KEY `bookName` (`bookName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Çalıkuşu','Reşat Nuri Güntekin','Romance',497,'2016-05-12',0),(2,'Tutunamayanlar','Oğuz Atay','Postmodern',723,'2019-02-09',0),(3,'Jane Eyre','Charlotte Brontë','Romance',632,'2015-06-03',0),(4,'Do Androids Dream of Electric Sheep?','Philip Kindred Dick','Science Fiction',261,'2015-11-22',1),(5,'The Pilgrim\'s Progress','James Bunyan','Religious Allegory',184,'2012-08-14',0),(6,'War of the Worlds','Herbert George Wells','Science Fiction',248,'2017-01-29',1),(7,'Of Mice and Men','John Steinbeck','American Realism',126,'2016-06-17',1),(8,'Les Misérables','Victor Hugo','Drama',405,'2009-08-03',1),(9,'Novum Organum','Francis Bacon','Philosophy',272,'2011-08-05',0),(10,'The History of the Decline and Fall of the Roman Empire','Edward Gibbon','History',3237,'2004-06-04',0),(11,'Clockwork Orange','Anthony Burgess','Dystopia',171,'2019-09-13',1),(12,'Physics for Scientists and Engineers 4th Edition','Douglas Giancoli','Physics',1328,'2018-04-30',0),(14,'Nutuk','Mustafa Kemal Atatürk','Politics',738,'2011-06-07',0),(15,'The Martian','Andy Weir','Science Fiction',416,'2018-04-22',1),(16,'Metamorphosis','Franz Kafka','Existantialism',74,'2020-10-15',1),(17,'The Catcher in the Rye','J. D. Salinger','Psychological',115,'2007-12-05',0),(18,'Death in Venice','Thomas Mann','Psychological',80,'2003-04-13',1),(19,'Hamlet','William Shakespeare','Drama',268,'2020-10-15',1),(20,'1984','George Orwell','Dystopia',350,'2015-06-04',0),(21,'To Kill a Mockingbird','Harper Lee','Drama',358,'2004-08-24',0),(22,'Lord of the Rings: The Fellowship of the Ring','J. R. R. Tolkien','Fantasy',510,'2007-08-15',1),(23,'Chronicle of a Death Foretold','Gabriel Garcia Márquez','Thriller',107,'2015-03-21',0),(24,'Animal Farm','George Orwell','Allegory',152,'2009-11-03',0),(25,'Pride and Prejudice','Jane Austen','Romance',496,'2017-05-17',1),(26,'Fahrenheit 451','Ray Bradbury','Dystopia',272,'2011-09-25',1),(27,'Frankestein','Mary Shelley','Gothic Fiction',166,'2013-08-18',1),(28,'Little Women','Louisa May Alcott','Children\'s Literature',280,'2020-04-15',0),(29,'Kürk Mantolu Madonna','Sabahattin Ali','Romance',160,'2015-12-27',0),(30,'The Great Gatsby','F. Scott Fitzgerald','Drama',180,'2018-04-07',1),(31,'The Hitchhiker’s Guide to the Galaxy','Douglas Adams','Science Fiction',621,'2014-09-12',1),(32,'American Psycho','Bret Easton Ellis','Satire',399,'2017-01-29',1),(33,'Don Quixote','Miguel de Cervantes','Satire',1023,'2021-07-11',0),(34,'The Iliad','Homer','Mythology',848,'2003-03-04',1),(35,'Inferno','Dante Alighieri','Religious Allegory',490,'2007-06-16',0),(36,'Crime and Punishment','Fyodor Dostoevsky','Psychological Fiction',671,'2010-08-28',1),(37,'Brave New World','Aldous Huxley','Dystopia',268,'2008-11-04',1),(38,'Romeo and Juliet','William Shakespeare','Romance',281,'2019-10-19',1),(39,'The Adventures of Tom Sawyer','Mark Twain','Children\'s Literature',244,'2014-04-14',0),(40,'The Little Prince','Antoine de Saint-Exupéry','Children\'s Literature',96,'2008-12-31',0),(41,'Dr. Jekyll and Mr. Hyde','Robert Louis Stevenson','Horror',139,'2006-05-17',1),(42,'The Picture of Dorian Gray','Oscar Wilde','Gothic Fiction',272,'2011-11-29',1),(43,'Dracula','Bram Stoker','Horror',418,'2002-01-08',1),(44,'The Shining','Stephen King','Horror',497,'2004-12-15',1),(45,'The Hobbit','J.R.R. Tolkien','Fantasy',366,'2021-09-26',0),(46,'The Lord of the Rings: The Two Towers','J.R.R. Tolkien','Fantasy',428,'2021-10-14',1),(47,'The Lord of the Rings: Return of The King','J.R.R. Tolkien','Fantasy',411,'2022-01-13',1),(48,'Dune','Frank Herbert','Science Fiction',658,'2001-09-17',1),(49,'Foundation','Isaac Asimov','Science Fiction',244,'2002-08-13',0),(50,'Jurassic Park','Michael Crichton','Science Fiction',466,'2013-03-12',1),(51,'Jaws','Peter Benchley','Horror',320,'2017-05-19',1),(52,'The Hunchback Of Notre Dame','Victor Hugo','Drama',940,'2012-08-15',0),(53,'The Count of Monte Cristo','Alexandre Dumas','Historical Fiction',1276,'2016-07-07',1),(54,'Anna Karenina','Leo Tolstoy','Historical Fiction',964,'2008-06-28',1),(55,'The Brothers Karamazov','Fyodor Dostoevsky','Drama',796,'2017-10-13',1),(56,'The Adventures of Huckleberry Finn','Mark Twain','Children\'s Literature',280,'2004-04-22',1),(57,'Das Kapital','Karl Marx','Politics',356,'2010-08-01',1),(58,'The Prince','Niccolo Machiavelli','Politics',198,'2018-06-01',1),(59,'The Social Contract','Jean-Jacques Rousseau','Politics',411,'2019-06-18',0),(60,'Robinson Crusoe','Daniel Defoe','Adventure',377,'2001-12-15',1),(61,'Gulliver\'s Travels','Jonathan Swift','Satire',292,'2016-05-28',1),(62,'Moby Dick','Herman Melville','Adventure',563,'2009-07-04',1),(63,'Ulysses','James Joyce','Modernism',732,'2017-01-11',0),(64,'A Tale of Two Cities','Charles Dickens','Historical Fiction',489,'2008-01-03',1),(65,'The Odyssey','Homer','Mythology',541,'2012-10-25',1),(66,'The Hunger Games','Suzanne Collins','Dystopia',374,'2019-07-20',1),(67,'Fifty Shades of Grey','E.L. James','Romance',356,'2012-05-10',1),(68,'Murder on the Orient Express','Agatha Christie','Mystery',274,'2008-12-09',1),(69,'The Hound of the Baskervilles','Arthur Conan Doyle','Mystery',256,'2006-07-05',1),(70,'The Three Musketeers','Alexandre Dumas','Historical Fiction',625,'2020-04-16',0),(71,'The Handmaid’s Tale','Margaret Atwood','Dystopia',314,'2005-04-27',1),(72,'The Book Thief','Markus Zusak','Historical Fiction',592,'2020-06-23',1),(73,'2001: A Space Odyssey','Arthur C. Clarke','Science Fiction',297,'2016-09-08',1),(74,'Meditations','Marcus Aurelius','Philosophy',254,'2003-06-26',0),(75,'The Symposium','Plato','Philosophy',90,'2019-11-28',0),(76,'The Alchemist','Paulo Coelho','Fantasy',182,'2013-06-24',1),(77,'Batman: The Long Halloween','Jeph Loeb','Comic',46,'2019-12-02',1),(78,'Batman: The Dark Knight Returns','Frank Miller','Comic',197,'2022-02-21',0),(79,'Sapiens: A Brief History of Humankind','Yuval Noah Harari','History',512,'2017-01-28',0),(80,'The Lean Startup','Eric Ries','Business',299,'2012-01-12',1),(81,'Diary of a Wimpy Kid','Jeff Kinney','Children\'s Literature',226,'2014-12-04',1),(82,'The Old Man and the Sea','Ernest Hemingway','Adventure',96,'2020-08-22',1),(83,'Great Expectations','Charles Dickens','Drama',544,'2016-07-14',1),(84,'The Stranger','Albert Camus','Philosophy',159,'2005-03-16',0),(85,'Notes from Underground','Fyodor Dostoevsky','Philosophy',136,'2009-07-25',1),(86,'Nausea','Jean-Paul Sartre','Philosophy',178,'2022-02-07',1),(87,'Life of Pi','Yann Martel','Fantasy',460,'2017-11-27',1),(88,'Gone with the Wind','Margaret Mitchell','Romance',1037,'2008-01-20',0),(89,'Wuthering Heights','Emily Brontë','Romance',464,'2003-03-24',1),(90,'One Hundred Years of Solitude','Gabriel García Márquez','Fantasy',417,'2021-11-08',1),(91,'East of Eden','John Steinbeck','Historical Fiction',601,'2018-11-18',1),(92,'Digital Fortress','Dan Brown','Mystery',510,'2002-09-01',0),(93,'Kitap','Yazar','History',100,'2023-10-10',1),(94,'Kitap2','Yazar','History',101,'2023-01-01',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
