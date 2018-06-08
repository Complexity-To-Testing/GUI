-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-05-2018 a las 20:59:33
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbtfg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mutante_test_proyecto`
--

CREATE TABLE `mutante_test_proyecto` (
  `id` int(11) NOT NULL,
  `idProyecto` int(11) NOT NULL,
  `idTest` int(11) NOT NULL,
  `clase` varchar(200) COLLATE utf16_spanish_ci NOT NULL,
  `mutante` varchar(200) COLLATE utf16_spanish_ci NOT NULL,
  `killed` varchar(40) COLLATE utf16_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `id` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf16_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test_proyecto`
--

CREATE TABLE `test_proyecto` (
  `id` int(11) NOT NULL,
  `idProyecto` int(11) NOT NULL,
  `nombreTest` varchar(40) COLLATE utf16_spanish_ci NOT NULL,
  `killed` int(11) NOT NULL,
  `numMutants` int(11) NOT NULL,
  `time` double NOT NULL,
  `percent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mutante_test_proyecto`
--
ALTER TABLE `mutante_test_proyecto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `test_proyecto`
--
ALTER TABLE `test_proyecto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mutante_test_proyecto`
--
ALTER TABLE `mutante_test_proyecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161003;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=400;

--
-- AUTO_INCREMENT de la tabla `test_proyecto`
--
ALTER TABLE `test_proyecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=468;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
