
CREATE TABLE IF NOT EXISTS dashboards (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `createdAt` TIMESTAMP NOT NULL DEFAULT NOW(),
    `updatedAt` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (`id`)
);

ALTER TABLE dashboards
    ADD `title` VARCHAR(255) NOT NULL;

INSERT INTO dashboards (`title`) VALUES ('first title');
INSERT INTO dashboards (`title`) VALUES ('second title');
INSERT INTO dashboards (`title`) VALUES ('third title');