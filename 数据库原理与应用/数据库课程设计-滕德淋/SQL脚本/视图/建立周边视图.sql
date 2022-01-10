CREATE VIEW home_by_shop ( home_fid, shop_name, point ) AS SELECT
home.fid,
shop.`name`,
shop.point 
FROM
	home,
	shop 
WHERE
	round(
		6378.138 * 2 * asin(
			sqrt(
				pow(
					sin( ( Y ( home.point ) * pi() / 180- Y ( shop.point ) * pi() / 180 ) / 2 ),
					2 
					) + cos( Y ( home.point ) * pi() / 180 ) * cos( Y ( shop.point ) * pi() / 180 ) * pow(
					sin(( X ( home.point ) * pi() / 180 - X ( shop.point ) * pi() / 180 ) / 2 ),
					2 
				)) 
		) * 1000 
	)< 2000;
	
	
CREATE VIEW home_by_park ( home_fid, park_name, point ) AS SELECT
home.fid,
park.`name`,
park.point 
FROM
	home,
	park 
WHERE
	round(
		6378.138 * 2 * asin(
			sqrt(
				pow(
					sin( ( Y ( home.point ) * pi() / 180- Y ( park.point ) * pi() / 180 ) / 2 ),
					2 
					) + cos( Y ( home.point ) * pi() / 180 ) * cos( Y ( park.point ) * pi() / 180 ) * pow(
					sin(( X ( home.point ) * pi() / 180 - X ( park.point ) * pi() / 180 ) / 2 ),
					2 
				)) 
		) * 1000 
	)< 2000;
	
	
CREATE VIEW home_by_hospital ( home_fid, hospital_name, point ) AS SELECT
home.fid,
hospital.`name`,
hospital.point 
FROM
	home,
	hospital 
WHERE
	round(
		6378.138 * 2 * asin(
			sqrt(
				pow(
					sin( ( Y ( home.point ) * pi() / 180- Y ( hospital.point ) * pi() / 180 ) / 2 ),
					2 
					) + cos( Y ( home.point ) * pi() / 180 ) * cos( Y ( hospital.point ) * pi() / 180 ) * pow(
					sin(( X ( home.point ) * pi() / 180 - X ( hospital.point ) * pi() / 180 ) / 2 ),
					2 
				)) 
		) * 1000 
	)< 2000;
	
	
CREATE VIEW home_by_school ( home_fid, school_name, point ) AS SELECT
home.fid,
school.`名称`,
school.point 
FROM
	home,
	school 
WHERE
	round(
		6378.138 * 2 * asin(
			sqrt(
				pow(
					sin( ( Y ( home.point ) * pi() / 180- Y ( school.point ) * pi() / 180 ) / 2 ),
					2 
					) + cos( Y ( home.point ) * pi() / 180 ) * cos( Y ( school.point ) * pi() / 180 ) * pow(
					sin(( X ( home.point ) * pi() / 180 - X ( school.point ) * pi() / 180 ) / 2 ),
					2 
				)) 
		) * 1000 
	)< 2000;
	
	
CREATE VIEW home_by_transportandroad ( home_fid, transportandroad_name, point ) AS SELECT
home.fid,
transportandroad.`name`,
transportandroad.point 
FROM
	home,
	transportandroad 
WHERE
	round(
		6378.138 * 2 * asin(
			sqrt(
				pow(
					sin( ( Y ( home.point ) * pi() / 180- Y ( transportandroad.point ) * pi() / 180 ) / 2 ),
					2 
					) + cos( Y ( home.point ) * pi() / 180 ) * cos( Y ( transportandroad.point ) * pi() / 180 ) * pow(
					sin(( X ( home.point ) * pi() / 180 - X ( transportandroad.point ) * pi() / 180 ) / 2 ),
					2 
				)) 
		) * 1000 
	)< 2000;