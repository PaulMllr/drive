INSERT INTO vehicle_manufacturer VALUES
('toyota_id', CURRENT_TIMESTAMP ,'Toyota'),
('mb_id', CURRENT_TIMESTAMP ,'Mercedes-Benz'),
('ch_id', CURRENT_TIMESTAMP ,'Chevrolet');

INSERT INTO vehicle_model VALUES
('model1',CURRENT_TIMESTAMP , 'Supra', 'toyota_id','JDM'),
('model2',CURRENT_TIMESTAMP , 'Celica', 'toyota_id','JDM'),
('model3',CURRENT_TIMESTAMP , 'Land Cruiser', 'toyota_id','JDM'),
('model4',CURRENT_TIMESTAMP , 'Land Cruiser Prado', 'toyota_id','JDM'),
('model5',CURRENT_TIMESTAMP , 'E-Class', 'mb_id','NORTH_AMERICA'),
('model6',CURRENT_TIMESTAMP , 'C-Class', 'mb_id','NORTH_AMERICA'),
('model7',CURRENT_TIMESTAMP , 'S-Class', 'mb_id','NORTH_AMERICA');

INSERT INTO vehicle_model_generation VALUES
('gen1', CURRENT_TIMESTAMP, 'W210', 1996, 2002, 'model5'),
('gen2', CURRENT_TIMESTAMP, 'W211', 2003, 2009, 'model5'),
('gen3', CURRENT_TIMESTAMP, 'W212', 2009, 2016, 'model5'),
('gen4', CURRENT_TIMESTAMP, 'W213', 2016, 2019, 'model5');







