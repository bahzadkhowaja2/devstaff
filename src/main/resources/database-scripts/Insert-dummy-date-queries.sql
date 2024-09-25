
-- Insert into crop_type
INSERT INTO crop_type (crop_name) VALUES 
('Wheat'),
('Corn'),
('Soybean');

-- Insert into farm
INSERT INTO farm (farm_name) VALUES 
('Sunny Farm'),
('Green Valley'),
('Riverdale Farms');

-- Insert into field
INSERT INTO field (field_name, farm_id) VALUES 
('Field A', 1),
('Field B', 2),
('Field C', 3);

-- Insert into harvested
INSERT INTO harvested (season, crop_type_id, actual_amount, field_id) VALUES 
('SPRING', 1, 1200.50, 1),
('SUMMER', 2, 1500.75, 2),
('WINTER', 3, 900.30, 3);

-- Insert into planted
INSERT INTO planted (season, crop_type_id, planted_area, expected_amount, field_id) VALUES 
('SPRING', 1, '50 acres', 1300.00, 1),
('Summer', 2, '60 acres', 1600.00, 2),
('WINTER', 3, '40 acres', 1000.00, 3);

