CREATE DEFINER=`root`@`localhost` PROCEDURE `select_avg`(in home_avg VARCHAR(32))
BEGIN
	SELECT AVG(totalprize) from house WHERE `name`=home_avg ;
END




