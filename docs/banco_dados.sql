create database listavip;

CREATE TABLE `convidado` (
  `id` int(11) NOT NULL,
  `nome` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `convidado` (`id`, `nome`, `email`, `telefone`) VALUES
(1, 'Lazaro Prates Junior', 'lazaro@gmail.com', '99998888'),
(2, 'Maria do Carmo', 'maria@gmail.com', '33442233'),
(4, 'Antonio da Silva', 'toni@hotmail.com', '99997777'),
(24, 'Caio Ferreira', 'caio.c.f@hotmail.com', '333333333');


ALTER TABLE `convidado`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `convidado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;