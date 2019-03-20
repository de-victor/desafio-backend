-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.6.42 - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para desafio_db
CREATE DATABASE IF NOT EXISTS `desafio_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `desafio_db`;

-- Copiando estrutura para tabela desafio_db.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `cur_nome` varchar(150) NOT NULL,
  `cur_fk_id_usu_coordenador` int(11) NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `uni_keys_nome_coor` (`cur_nome`,`cur_fk_id_usu_coordenador`),
  KEY `fk_curso_usuario1_idx` (`cur_fk_id_usu_coordenador`),
  CONSTRAINT `fk_curso_usuario1` FOREIGN KEY (`cur_fk_id_usu_coordenador`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.curso: ~0 rows (aproximadamente)
DELETE FROM `curso`;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Copiando estrutura para tabela desafio_db.disciplina
CREATE TABLE IF NOT EXISTS `disciplina` (
  `id_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `dis_fk_id_curso` int(11) NOT NULL,
  `dis_fk_id_usu_professor` int(11) NOT NULL,
  `dis_carga_horaria` int(11) DEFAULT NULL,
  `dis_nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_disciplina`),
  UNIQUE KEY `uni_keys_cur_prof` (`dis_fk_id_curso`,`dis_fk_id_usu_professor`),
  KEY `fk_disciplina_curso1_idx` (`dis_fk_id_curso`),
  KEY `fk_disciplina_usuario1_idx` (`dis_fk_id_usu_professor`),
  CONSTRAINT `fk_disciplina_curso1` FOREIGN KEY (`dis_fk_id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_usuario1` FOREIGN KEY (`dis_fk_id_usu_professor`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.disciplina: ~0 rows (aproximadamente)
DELETE FROM `disciplina`;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;

-- Copiando estrutura para tabela desafio_db.matriz_curricular
CREATE TABLE IF NOT EXISTS `matriz_curricular` (
  `id_matriz_cur` int(11) NOT NULL AUTO_INCREMENT,
  `matri_fk_id_sem` int(11) NOT NULL,
  `matri_fk_id_dis` int(11) NOT NULL,
  `matri_fk_id_curso` int(11) NOT NULL,
  PRIMARY KEY (`id_matriz_cur`),
  UNIQUE KEY `uni_keys_cur_sem_dis` (`matri_fk_id_sem`,`matri_fk_id_dis`,`matri_fk_id_curso`),
  KEY `fk_cursando_semestre1_idx` (`matri_fk_id_sem`),
  KEY `fk_cursando_disciplina1_idx` (`matri_fk_id_dis`),
  KEY `fk_matriz_curricular_curso1_idx` (`matri_fk_id_curso`),
  CONSTRAINT `fk_cursando_disciplina1` FOREIGN KEY (`matri_fk_id_dis`) REFERENCES `disciplina` (`id_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursando_semestre1` FOREIGN KEY (`matri_fk_id_sem`) REFERENCES `semestre` (`id_semestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matriz_curricular_curso1` FOREIGN KEY (`matri_fk_id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.matriz_curricular: ~0 rows (aproximadamente)
DELETE FROM `matriz_curricular`;
/*!40000 ALTER TABLE `matriz_curricular` DISABLE KEYS */;
/*!40000 ALTER TABLE `matriz_curricular` ENABLE KEYS */;

-- Copiando estrutura para tabela desafio_db.semestre
CREATE TABLE IF NOT EXISTS `semestre` (
  `id_semestre` int(11) NOT NULL AUTO_INCREMENT,
  `sem_ano` varchar(5) NOT NULL,
  `sem_perido` varchar(5) NOT NULL,
  PRIMARY KEY (`id_semestre`),
  UNIQUE KEY `uni_key_sem_per` (`sem_ano`,`sem_perido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.semestre: ~0 rows (aproximadamente)
DELETE FROM `semestre`;
/*!40000 ALTER TABLE `semestre` DISABLE KEYS */;
/*!40000 ALTER TABLE `semestre` ENABLE KEYS */;

-- Copiando estrutura para tabela desafio_db.tipo_usuario
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id_tipo_usu` int(11) NOT NULL AUTO_INCREMENT,
  `tip_descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`id_tipo_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.tipo_usuario: ~0 rows (aproximadamente)
DELETE FROM `tipo_usuario`;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`id_tipo_usu`, `tip_descricao`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'COORDENADOR'),
	(3, 'PROFESSOR'),
	(4, 'ALUNO');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;

-- Copiando estrutura para tabela desafio_db.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usu_matricula` varchar(25) NOT NULL,
  `usu_nome` varchar(250) NOT NULL,
  `usu_senha` varchar(50) NOT NULL,
  `usu_fk_tipo_usu` int(11) NOT NULL,
  `usu_token` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usu_matricula_UNIQUE` (`usu_matricula`),
  KEY `fk_usuario_tipo_usuario_idx` (`usu_fk_tipo_usu`),
  CONSTRAINT `fk_usuario_tipo_usuario` FOREIGN KEY (`usu_fk_tipo_usu`) REFERENCES `tipo_usuario` (`id_tipo_usu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio_db.usuario: ~0 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `usu_matricula`, `usu_nome`, `usu_senha`, `usu_fk_tipo_usu`, `usu_token`) VALUES
	(1, '1', 'ADMININSTRADOR', '202cb962ac59075b964b07152d234b70', 1, 'd0572253c0e7cdb85b13988712cb152e');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
