CREATE TABLE IF NOT EXISTS `events` (
  `id` INTEGER PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `date` DATE NOT NULL,
  `description` VARCHAR(250)
);
