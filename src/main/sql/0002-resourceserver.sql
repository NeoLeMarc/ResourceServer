-- MySQL dump 10.17  Distrib 10.3.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: resourceserver
-- ------------------------------------------------------
-- Server version	10.3.23-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary table structure for view `current_rki_covid19_case`
--

DROP TABLE IF EXISTS `current_rki_covid19_case`;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_case`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_rki_covid19_case` (
  `Altersgruppe` tinyint NOT NULL,
  `Altersgruppe2` tinyint NOT NULL,
  `AnzahlFall` tinyint NOT NULL,
  `AnzahlGenesen` tinyint NOT NULL,
  `AnzahlTodesfall` tinyint NOT NULL,
  `Bundesland` tinyint NOT NULL,
  `Datenstand` tinyint NOT NULL,
  `Geschlecht` tinyint NOT NULL,
  `IdBundesland` tinyint NOT NULL,
  `IdLandkreis` tinyint NOT NULL,
  `IstErkrankungsbeginn` tinyint NOT NULL,
  `Landkreis` tinyint NOT NULL,
  `Meldedatum` tinyint NOT NULL,
  `NeuGenesen` tinyint NOT NULL,
  `NeuerFall` tinyint NOT NULL,
  `NeuerTodesfall` tinyint NOT NULL,
  `ObjectId` tinyint NOT NULL,
  `Refdatum` tinyint NOT NULL,
  `DatensatzDatum` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `current_rki_covid19_fallsterblichkeit`
--

DROP TABLE IF EXISTS `current_rki_covid19_fallsterblichkeit`;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_fallsterblichkeit`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_rki_covid19_fallsterblichkeit` (
  `DatensatzDatum` tinyint NOT NULL,
  `Landkreis` tinyint NOT NULL,
  `AnzahlFaelle` tinyint NOT NULL,
  `AnzahlTote` tinyint NOT NULL,
  `Fallsterblichkeit` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `current_rki_covid19_fallsterblichkeit_kalenderwoche`
--

DROP TABLE IF EXISTS `current_rki_covid19_fallsterblichkeit_kalenderwoche`;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_fallsterblichkeit_kalenderwoche`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_rki_covid19_fallsterblichkeit_kalenderwoche` (
  `Kalenderwoche` tinyint NOT NULL,
  `AnzahlFaelle` tinyint NOT NULL,
  `AnzahlTote` tinyint NOT NULL,
  `Fallsterblichkeit` tinyint NOT NULL,
  `FallsterblichkeitProzent` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `rki_covid19_case`
--

DROP TABLE IF EXISTS `rki_covid19_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rki_covid19_case` (
  `Altersgruppe` varchar(20) DEFAULT NULL,
  `Altersgruppe2` varchar(20) DEFAULT NULL,
  `AnzahlFall` int(11) DEFAULT NULL,
  `AnzahlGenesen` int(11) DEFAULT NULL,
  `AnzahlTodesfall` int(11) DEFAULT NULL,
  `Bundesland` varchar(30) DEFAULT NULL,
  `Datenstand` datetime DEFAULT NULL,
  `Geschlecht` varchar(15) DEFAULT NULL,
  `IdBundesland` int(11) DEFAULT NULL,
  `IdLandkreis` varchar(15) DEFAULT NULL,
  `IstErkrankungsbeginn` int(11) DEFAULT NULL,
  `Landkreis` varchar(200) DEFAULT NULL,
  `Meldedatum` datetime DEFAULT NULL,
  `NeuGenesen` int(11) DEFAULT NULL,
  `NeuerFall` int(11) DEFAULT NULL,
  `NeuerTodesfall` int(11) DEFAULT NULL,
  `ObjectId` int(11) NOT NULL,
  `Refdatum` datetime DEFAULT NULL,
  `DatensatzDatum` date NOT NULL,
  PRIMARY KEY (`DatensatzDatum`,`ObjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rki_covid19_case`
--

LOCK TABLES `rki_covid19_case` WRITE;
/*!40000 ALTER TABLE `rki_covid19_case` DISABLE KEYS */;
/*!40000 ALTER TABLE `rki_covid19_case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `rki_covid19_fallsterblichkeit`
--

DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit`;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rki_covid19_fallsterblichkeit` (
  `DatensatzDatum` tinyint NOT NULL,
  `Landkreis` tinyint NOT NULL,
  `AnzahlFaelle` tinyint NOT NULL,
  `AnzahlTote` tinyint NOT NULL,
  `Fallsterblichkeit` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rki_covid19_fallsterblichkeit_kalenderwoche`
--

DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche`;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rki_covid19_fallsterblichkeit_kalenderwoche` (
  `DatensatzDatum` tinyint NOT NULL,
  `Kalenderwoche` tinyint NOT NULL,
  `AnzahlFaelle` tinyint NOT NULL,
  `AnzahlTote` tinyint NOT NULL,
  `Fallsterblichkeit` tinyint NOT NULL,
  `FallsterblichkeitProzent` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`
--

DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe` (
  `DatensatzDatum` tinyint NOT NULL,
  `Kalenderwoche` tinyint NOT NULL,
  `Altersgruppe` tinyint NOT NULL,
  `AnzahlFaelle` tinyint NOT NULL,
  `AnzahlTote` tinyint NOT NULL,
  `Fallsterblichkeit` tinyint NOT NULL,
  `FallsterblichkeitProzent` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `current_rki_covid19_case`
--

/*!50001 DROP TABLE IF EXISTS `current_rki_covid19_case`*/;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_case`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_rki_covid19_case` AS select `rki_covid19_case`.`Altersgruppe` AS `Altersgruppe`,`rki_covid19_case`.`Altersgruppe2` AS `Altersgruppe2`,`rki_covid19_case`.`AnzahlFall` AS `AnzahlFall`,`rki_covid19_case`.`AnzahlGenesen` AS `AnzahlGenesen`,`rki_covid19_case`.`AnzahlTodesfall` AS `AnzahlTodesfall`,`rki_covid19_case`.`Bundesland` AS `Bundesland`,`rki_covid19_case`.`Datenstand` AS `Datenstand`,`rki_covid19_case`.`Geschlecht` AS `Geschlecht`,`rki_covid19_case`.`IdBundesland` AS `IdBundesland`,`rki_covid19_case`.`IdLandkreis` AS `IdLandkreis`,`rki_covid19_case`.`IstErkrankungsbeginn` AS `IstErkrankungsbeginn`,`rki_covid19_case`.`Landkreis` AS `Landkreis`,`rki_covid19_case`.`Meldedatum` AS `Meldedatum`,`rki_covid19_case`.`NeuGenesen` AS `NeuGenesen`,`rki_covid19_case`.`NeuerFall` AS `NeuerFall`,`rki_covid19_case`.`NeuerTodesfall` AS `NeuerTodesfall`,`rki_covid19_case`.`ObjectId` AS `ObjectId`,`rki_covid19_case`.`Refdatum` AS `Refdatum`,`rki_covid19_case`.`DatensatzDatum` AS `DatensatzDatum` from `rki_covid19_case` where `rki_covid19_case`.`DatensatzDatum` = (select max(`rki_covid19_case`.`DatensatzDatum`) from `rki_covid19_case`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `current_rki_covid19_fallsterblichkeit`
--

/*!50001 DROP TABLE IF EXISTS `current_rki_covid19_fallsterblichkeit`*/;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_fallsterblichkeit`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_rki_covid19_fallsterblichkeit` AS select `rki_covid19_fallsterblichkeit`.`DatensatzDatum` AS `DatensatzDatum`,`rki_covid19_fallsterblichkeit`.`Landkreis` AS `Landkreis`,`rki_covid19_fallsterblichkeit`.`AnzahlFaelle` AS `AnzahlFaelle`,`rki_covid19_fallsterblichkeit`.`AnzahlTote` AS `AnzahlTote`,`rki_covid19_fallsterblichkeit`.`Fallsterblichkeit` AS `Fallsterblichkeit` from `resourceserver`.`rki_covid19_fallsterblichkeit` where `rki_covid19_fallsterblichkeit`.`DatensatzDatum` = (select max(`rki_covid19_fallsterblichkeit`.`DatensatzDatum`) from `resourceserver`.`rki_covid19_fallsterblichkeit`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `current_rki_covid19_fallsterblichkeit_kalenderwoche`
--

/*!50001 DROP TABLE IF EXISTS `current_rki_covid19_fallsterblichkeit_kalenderwoche`*/;
/*!50001 DROP VIEW IF EXISTS `current_rki_covid19_fallsterblichkeit_kalenderwoche`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_rki_covid19_fallsterblichkeit_kalenderwoche` AS select `rki_covid19_fallsterblichkeit_kalenderwoche`.`Kalenderwoche` AS `Kalenderwoche`,`rki_covid19_fallsterblichkeit_kalenderwoche`.`AnzahlFaelle` AS `AnzahlFaelle`,`rki_covid19_fallsterblichkeit_kalenderwoche`.`AnzahlTote` AS `AnzahlTote`,`rki_covid19_fallsterblichkeit_kalenderwoche`.`Fallsterblichkeit` AS `Fallsterblichkeit`,`rki_covid19_fallsterblichkeit_kalenderwoche`.`FallsterblichkeitProzent` AS `FallsterblichkeitProzent` from `resourceserver`.`rki_covid19_fallsterblichkeit_kalenderwoche` where `rki_covid19_fallsterblichkeit_kalenderwoche`.`DatensatzDatum` = (select max(`resourceserver`.`rki_covid19_case`.`DatensatzDatum`) from `resourceserver`.`rki_covid19_case`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rki_covid19_fallsterblichkeit`
--

/*!50001 DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit`*/;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rki_covid19_fallsterblichkeit` AS select `sub`.`DatensatzDatum` AS `DatensatzDatum`,`sub`.`Landkreis` AS `Landkreis`,count(0) AS `AnzahlFaelle`,sum(`sub`.`todesfall`) AS `AnzahlTote`,sum(`sub`.`todesfall`) / count(0) AS `Fallsterblichkeit` from (select `inn`.`DatensatzDatum` AS `DatensatzDatum`,`inn`.`Landkreis` AS `Landkreis`,if(`inn`.`AnzahlTodesfall` > 0,1,0) AS `todesfall` from `resourceserver`.`rki_covid19_case` `inn`) `sub` group by `sub`.`DatensatzDatum`,`sub`.`Landkreis` order by sum(`sub`.`todesfall`) / count(0) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rki_covid19_fallsterblichkeit_kalenderwoche`
--

/*!50001 DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche`*/;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rki_covid19_fallsterblichkeit_kalenderwoche` AS select `inn`.`DatensatzDatum` AS `DatensatzDatum`,week(`inn`.`Meldedatum`) AS `Kalenderwoche`,count(0) AS `AnzahlFaelle`,sum(`inn`.`todesfall`) AS `AnzahlTote`,sum(`inn`.`todesfall`) / count(0) AS `Fallsterblichkeit`,sum(`inn`.`todesfall`) / count(0) * 100 AS `FallsterblichkeitProzent` from (select `resourceserver`.`rki_covid19_case`.`DatensatzDatum` AS `DatensatzDatum`,`resourceserver`.`rki_covid19_case`.`Meldedatum` AS `Meldedatum`,if(`resourceserver`.`rki_covid19_case`.`AnzahlTodesfall` > 0,1,0) AS `todesfall` from `resourceserver`.`rki_covid19_case`) `inn` group by `inn`.`DatensatzDatum`,week(`inn`.`Meldedatum`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`
--

/*!50001 DROP TABLE IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`*/;
/*!50001 DROP VIEW IF EXISTS `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rki_covid19_fallsterblichkeit_kalenderwoche_altersgruppe` AS select `inn`.`DatensatzDatum` AS `DatensatzDatum`,week(`inn`.`Meldedatum`) AS `Kalenderwoche`,`inn`.`Altersgruppe` AS `Altersgruppe`,count(0) AS `AnzahlFaelle`,sum(`inn`.`todesfall`) AS `AnzahlTote`,sum(`inn`.`todesfall`) / count(0) AS `Fallsterblichkeit`,sum(`inn`.`todesfall`) / count(0) * 100 AS `FallsterblichkeitProzent` from (select `resourceserver`.`rki_covid19_case`.`DatensatzDatum` AS `DatensatzDatum`,`resourceserver`.`rki_covid19_case`.`Altersgruppe` AS `Altersgruppe`,`resourceserver`.`rki_covid19_case`.`Meldedatum` AS `Meldedatum`,if(`resourceserver`.`rki_covid19_case`.`AnzahlTodesfall` > 0,1,0) AS `todesfall` from `resourceserver`.`rki_covid19_case`) `inn` group by `inn`.`DatensatzDatum`,week(`inn`.`Meldedatum`),`inn`.`Altersgruppe` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-09 15:31:22
