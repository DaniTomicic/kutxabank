-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-03-2025 a las 09:35:32
-- Versión del servidor: 5.7.36
-- Versión de PHP: 8.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kutxabank`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `num_cuenta` varchar(10) NOT NULL,
  `saldo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`num_cuenta`, `saldo`) VALUES
('1111111111', 1000),
('2222222222', 500),
('3333333333', 800),
('4444444444', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas_clientes`
--

CREATE TABLE `cuentas_clientes` (
  `dni` varchar(9) NOT NULL,
  `num_cuenta` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuentas_clientes`
--

INSERT INTO `cuentas_clientes` (`dni`, `num_cuenta`) VALUES
('11111111A', '1111111111'),
('12345678A', '1111111111'),
('22222222B', '3333333333'),
('73496163Q', '4444444444'),
('22222222B', '2222222222');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id` varchar(3) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `importe` float NOT NULL,
  `num_cuenta` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` varchar(9) NOT NULL,
  `clave` varchar(6) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `clave`, `nombre`) VALUES
('11111111A', '111111', 'Uno'),
('12345678A', '123456', 'Guillermo'),
('22222222B', '222222', 'Dos'),
('73496163Q', '123456', 'Dani');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`num_cuenta`);

--
-- Indices de la tabla `cuentas_clientes`
--
ALTER TABLE `cuentas_clientes`
  ADD KEY `dni` (`dni`),
  ADD KEY `num_cuenta` (`num_cuenta`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `num_cuenta` (`num_cuenta`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentas_clientes`
--
ALTER TABLE `cuentas_clientes`
  ADD CONSTRAINT `cuentas_clientes_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cuentas_clientes_ibfk_2` FOREIGN KEY (`num_cuenta`) REFERENCES `cuentas` (`num_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`num_cuenta`) REFERENCES `cuentas` (`num_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
