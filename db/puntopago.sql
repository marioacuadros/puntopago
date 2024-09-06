-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-09-2024 a las 17:59:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntopago`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operadores`
--

CREATE TABLE `operadores` (
  `id_operador` bigint(20) NOT NULL,
  `operador` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `operadores`
--

INSERT INTO `operadores` (`id_operador`, `operador`) VALUES
(3, 'Comcel Telmex - Claro'),
(2, 'Movistar'),
(1, 'Tigo'),
(4, 'Uff');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_documento`
--

CREATE TABLE `tipos_documento` (
  `id_tipo_documento` bigint(20) NOT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tipos_documento`
--

INSERT INTO `tipos_documento` (`id_tipo_documento`, `tipo_documento`) VALUES
(1, 'Cédula de ciudadanía'),
(3, 'Cédula de extrangería'),
(4, 'Pasaporte'),
(2, 'Tarjeta de identidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `id_vendedor` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `num_documento` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_documento_id_tipo_documento` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`id_vendedor`, `nombre`, `num_documento`, `telefono`, `tipo_documento_id_tipo_documento`) VALUES
(1, 'Pedro Vendedor', '1001100200', '3001002030', 1),
(2, 'Isabel Vendedora', '1001100201', '3002002030', 1),
(3, 'Pablo Otro Vendedor', '1001200201', '3003002030', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` bigint(20) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  `valor` bigint(20) DEFAULT NULL,
  `operador_id_operador` bigint(20) DEFAULT NULL,
  `vendedor_id_vendedor` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `celular`, `fecha`, `valor`, `operador_id_operador`, `vendedor_id_vendedor`) VALUES
(2, '3113121212', '2024/09/06', 50000, 3, 2),
(3, '3123131212', '2024-09-06 10:21:45', 300000, 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `operadores`
--
ALTER TABLE `operadores`
  ADD PRIMARY KEY (`id_operador`),
  ADD UNIQUE KEY `nombre` (`operador`) USING BTREE;

--
-- Indices de la tabla `tipos_documento`
--
ALTER TABLE `tipos_documento`
  ADD PRIMARY KEY (`id_tipo_documento`),
  ADD UNIQUE KEY `tipo_documento` (`tipo_documento`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`id_vendedor`),
  ADD KEY `FKiqojnfy5b5mdw2o9f8sou9861` (`tipo_documento_id_tipo_documento`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `FKrdut53cl98hk4ofsvppy6fhq2` (`operador_id_operador`),
  ADD KEY `FKknxgkt4qhp280v7v3ebd9nk51` (`vendedor_id_vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `operadores`
--
ALTER TABLE `operadores`
  MODIFY `id_operador` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipos_documento`
--
ALTER TABLE `tipos_documento`
  MODIFY `id_tipo_documento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `id_vendedor` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD CONSTRAINT `FKiqojnfy5b5mdw2o9f8sou9861` FOREIGN KEY (`tipo_documento_id_tipo_documento`) REFERENCES `tipos_documento` (`id_tipo_documento`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FKknxgkt4qhp280v7v3ebd9nk51` FOREIGN KEY (`vendedor_id_vendedor`) REFERENCES `vendedores` (`id_vendedor`),
  ADD CONSTRAINT `FKrdut53cl98hk4ofsvppy6fhq2` FOREIGN KEY (`operador_id_operador`) REFERENCES `operadores` (`id_operador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
