MERGE INTO Premium
    KEY (ID)
    VALUES (1, 1.0, 0.5, 1.0, 1.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (2, 2.0, 2.5, 2.0, 2.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
           (3, 3.0, 3.5, 3.0, 3.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);