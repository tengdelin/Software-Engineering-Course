CREATE DEFINER=`root`@`localhost` PROCEDURE `select_order`()
BEGIN
	SELECT * from house ORDER BY totalprize DESC;
END