DROP TABLE IF EXISTS shipment;

CREATE TABLE shipment
(
    id           SERIAL      NOT NULL,
    status       VARCHAR(25) NOT NULL,
    managerId    VARCHAR(25) NOT NULL,
    driverId     VARCHAR(25) NOT NULL,
    deadlineDate TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);