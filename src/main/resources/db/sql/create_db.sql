DROP TABLE IF EXISTS shipment;

CREATE TABLE shipment
(
    id           SERIAL      NOT NULL,
    status       VARCHAR(50) NOT NULL,
    managerId    VARCHAR(50) NOT NULL,
    driverId     VARCHAR(50) NOT NULL,
    deadlineDate TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);