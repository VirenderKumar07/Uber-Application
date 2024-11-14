INSERT INTO app_user (name, email, password)
VALUES
    ('ArunSharma', 'arun@gmail.com', 'arunsharma'),
    ('DeepakSingh', 'deepak@gmail.com', 'deepaksingh'),
    ('RaviKumar', 'ravi@gmail.com', 'ravikumar'),
    ('SureshVerma', 'suresh@gmail.com', 'sureshverma'),
    ('AmitJoshi', 'amit@gmail.com', 'amitjoshi'),
    ('VijayPatel', 'vijay@gmail.com', 'vijaypatel'),
    ('PoojaMehta', 'pooja@gmail.com', 'poojamehta'),
    ('AnjaliGupta', 'anjali@gmail.com', 'anjaligupta'),
    ('KaranYadav', 'karan@gmail.com', 'karanyadav'),
    ('NidhiSingh', 'nidhi@gmail.com', 'nidhisingh'),
    ('ShreyaSharma', 'shreya@gmail.com', 'shreyasharma'),
    ('RohitJain', 'rohit@gmail.com', 'rohitjain'),
    ('RakeshChopra', 'rakesh@gmail.com', 'rakeshchopra'),
    ('PriyaRana', 'priya@gmail.com', 'priyarana'),
    ('RahulKohli', 'rahul@gmail.com', 'rahulkohli'),
    ('SanjayShah', 'sanjay@gmail.com', 'sanjayshah'),
    ('SnehaPillai', 'sneha@gmail.com', 'snehapillai'),
    ('ManojNaik', 'manoj@gmail.com', 'manojnaik');


INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(10, 'DRIVER'),
(11, 'DRIVER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(16, 'RIDER'),
(17, 'RIDER'),
(18, 'DRIVER');


INSERT INTO rider (user_id, rating) VALUES
(1,4.9);


INSERT INTO driver (user_id, rating, available, current_location) VALUES
(2, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),
(3, 4.8, true, ST_GeomFromText('POINT(77.2167 28.6667)', 4326)),
(4, 4.6, true, ST_GeomFromText('POINT(77.2273 28.6353)', 4326)),
(5, 4.9, true, ST_GeomFromText('POINT(77.2500 28.5500)', 4326)),
(6, 4.3, true, ST_GeomFromText('POINT(77.2000 28.6200)', 4326)),
(7, 4.4, true, ST_GeomFromText('POINT(77.2800 28.5900)', 4326)),
(8, 4.5, true, ST_GeomFromText('POINT(77.2600 28.6800)', 4326)),
(9, 4.6, true, ST_GeomFromText('POINT(77.2200 28.6400)', 4326)),
(10, 4.7, true, ST_GeomFromText('POINT(77.2700 28.6700)', 4326)),
(11, 4.8, true, ST_GeomFromText('POINT(77.2400 28.6100)', 4326)),
(12, 4.2, true, ST_GeomFromText('POINT(77.2300 28.6600)', 4326)),
(13, 4.1, true, ST_GeomFromText('POINT(77.1900 28.6000)', 4326)),
(14, 4.0, true, ST_GeomFromText('POINT(77.1800 28.6300)', 4326)),
(15, 4.5, true, ST_GeomFromText('POINT(77.1500 28.6500)', 4326)),
(16, 4.3, true, ST_GeomFromText('POINT(77.1200 28.6700)', 4326)),
(17, 4.6, true, ST_GeomFromText('POINT(77.1700 28.6800)', 4326)),
(18, 4.4, true, ST_GeomFromText('POINT(77.1400 28.6900)', 4326));

INSERT INTO wallet (user_id, balance) VALUES
(1, 100),
(2, 500);
