MERGE INTO TYPE_CLASS
    KEY(ID)
    VALUES (1, 'Business', 1.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (2, 'Truck', 1.5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (3, 'Comfort', 2.5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

MERGE INTO REGION
    KEY(ID)
    VALUES (1, 'Federal1', 'County1', 'City1', 1234, 'Location1', 1.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (2, 'Federal2', 'County2', 'City2', 1235, 'Location2', 2.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (3, 'Federal3', 'County3', 'City3', 1236, 'Location3', 3.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (4, 'Federal4', 'County4', 'City4', 1234, 'Location4', 4.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);