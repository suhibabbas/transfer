CREATE TABLE `trasfer`.`transfer` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `to_acc` INT NULL,
    `from_acc` INT NULL,
    `amount` INT NULL,
    PRIMARY KEY (`id`));