CREATE SCHEMA IF NOT EXISTS toDoList DEFAULT CHARACTER SET utf8 ;
USE toDoList ;

-- -----------------------------------------------------
-- Table toDoList.tarea
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS toDoList.tarea (
  tar_id INT NOT NULL AUTO_INCREMENT,
  tar_name VARCHAR(70) NOT NULL,
  PRIMARY KEY (tar_id),
  UNIQUE INDEX tar_id_UNIQUE (tar_id ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table toDoList.sub_tarea
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS toDoList.sub_tarea (
  sub_id INT NOT NULL AUTO_INCREMENT,
  sub_name VARCHAR(100) NOT NULL,
  sub_complete TINYINT NOT NULL DEFAULT 0,
  tarea_tar_id INT NOT NULL,
  PRIMARY KEY (sub_id),
  UNIQUE INDEX sub_id_UNIQUE (sub_id ASC) VISIBLE,
  INDEX fk_sub_tarea_tarea_idx (tarea_tar_id ASC) VISIBLE,
  CONSTRAINT fk_sub_tarea_tarea
    FOREIGN KEY (tarea_tar_id)
    REFERENCES toDoList.tarea (tar_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;