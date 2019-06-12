-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-06-2019 a las 21:27:34
-- Versión del servidor: 10.1.39-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eeeee`
--
CREATE DATABASE IF NOT EXISTS `eeeee` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `eeeee`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barrios`
--

DROP TABLE IF EXISTS `barrios`;
CREATE TABLE IF NOT EXISTS `barrios` (
  `cod_barrio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_barrio` varchar(35) NOT NULL,
  `puntos_venta_cod_punto_venta` int(11) NOT NULL,
  PRIMARY KEY (`cod_barrio`),
  KEY `fk_barrios_puntos_venta1_idx` (`puntos_venta_cod_punto_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_credito`
--

DROP TABLE IF EXISTS `cliente_credito`;
CREATE TABLE IF NOT EXISTS `cliente_credito` (
  `cod_credito` int(11) NOT NULL AUTO_INCREMENT,
  `credito_abierto_cod_abierto` int(11) NOT NULL,
  `credito_cerrado_cod_cerrado` int(11) NOT NULL,
  PRIMARY KEY (`cod_credito`),
  KEY `fk_cliente_credito_credito_abierto1_idx` (`credito_abierto_cod_abierto`),
  KEY `fk_cliente_credito_credito_cerrado1_idx` (`credito_cerrado_cod_cerrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comision`
--

DROP TABLE IF EXISTS `comision`;
CREATE TABLE IF NOT EXISTS `comision` (
  `cod_comision` int(11) NOT NULL AUTO_INCREMENT,
  `comision_valor` int(11) DEFAULT NULL,
  `comision_meta` int(11) DEFAULT NULL,
  `personas_cod_identificacion` bigint(10) NOT NULL,
  PRIMARY KEY (`cod_comision`),
  KEY `fk_comision_personas1_idx` (`personas_cod_identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito_abierto`
--

DROP TABLE IF EXISTS `credito_abierto`;
CREATE TABLE IF NOT EXISTS `credito_abierto` (
  `cod_abierto` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_abierto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito_cerrado`
--

DROP TABLE IF EXISTS `credito_cerrado`;
CREATE TABLE IF NOT EXISTS `credito_cerrado` (
  `cod_cerrado` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(45) NOT NULL,
  `doc_cerrado` mediumblob NOT NULL,
  PRIMARY KEY (`cod_cerrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito_menu`
--

DROP TABLE IF EXISTS `credito_menu`;
CREATE TABLE IF NOT EXISTS `credito_menu` (
  `cod_credito_menu` int(11) NOT NULL AUTO_INCREMENT,
  `menu_cod_menu` int(11) NOT NULL,
  `credito_abierto_cod_abierto` int(11) NOT NULL,
  PRIMARY KEY (`cod_credito_menu`),
  KEY `fk_credito_menu_menu1_idx` (`menu_cod_menu`),
  KEY `fk_credito_menu_credito_abierto1_idx` (`credito_abierto_cod_abierto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
CREATE TABLE IF NOT EXISTS `ingresos` (
  `cod_ingreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` varchar(15) NOT NULL,
  `tiempo_en_sistema` varchar(10) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `usuarios_nick_name` int(11) NOT NULL,
  PRIMARY KEY (`cod_ingreso`),
  KEY `fk_ingresos_usuarios1_idx` (`usuarios_nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `malla_turnos`
--

DROP TABLE IF EXISTS `malla_turnos`;
CREATE TABLE IF NOT EXISTS `malla_turnos` (
  `cod_malla` int(11) NOT NULL AUTO_INCREMENT,
  `doc_malla` mediumblob NOT NULL,
  `personas_cod_identificacion` bigint(10) NOT NULL,
  PRIMARY KEY (`cod_malla`),
  KEY `fk_malla_turnos_personas1_idx` (`personas_cod_identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

DROP TABLE IF EXISTS `marcas`;
CREATE TABLE IF NOT EXISTS `marcas` (
  `cod_marca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `cod_menu` int(11) NOT NULL AUTO_INCREMENT,
  `menu` mediumblob NOT NULL,
  `precio1` int(11) NOT NULL,
  `precio2` int(11) NOT NULL,
  `precio3` int(11) NOT NULL,
  PRIMARY KEY (`cod_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menus_puntos_venta`
--

DROP TABLE IF EXISTS `menus_puntos_venta`;
CREATE TABLE IF NOT EXISTS `menus_puntos_venta` (
  `cod_menu_punto` int(11) NOT NULL,
  `menu_cod_menu` int(11) NOT NULL,
  `puntos_venta_cod_punto_venta` int(11) NOT NULL,
  PRIMARY KEY (`cod_menu_punto`),
  KEY `fk_menus_puntos_venta_menu1_idx` (`menu_cod_menu`),
  KEY `fk_menus_puntos_venta_puntos_venta1_idx` (`puntos_venta_cod_punto_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE IF NOT EXISTS `permisos` (
  `cod_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL,
  `icono` mediumblob NOT NULL,
  `cod_padre` int(11) NOT NULL,
  PRIMARY KEY (`cod_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `cod_identificacion` bigint(10) NOT NULL,
  `prirmer_nombre` varchar(25) NOT NULL,
  `segundo_nombre` varchar(25) DEFAULT NULL,
  `primer_apellido` varchar(25) NOT NULL,
  `segundo_apellido` varchar(25) DEFAULT NULL,
  `telefono` bigint(12) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `fecha_nacimiento` varchar(20) NOT NULL,
  `usuarios_nick_name` int(11) NOT NULL,
  `rol_cod_rol` int(11) NOT NULL,
  PRIMARY KEY (`cod_identificacion`),
  KEY `fk_personas_usuarios1_idx` (`usuarios_nick_name`),
  KEY `fk_personas_rol1_idx` (`rol_cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `cod_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(45) NOT NULL,
  `cantidad_producto` bigint(100) NOT NULL,
  PRIMARY KEY (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_menus`
--

DROP TABLE IF EXISTS `productos_menus`;
CREATE TABLE IF NOT EXISTS `productos_menus` (
  `cod_producto_menu` int(11) NOT NULL AUTO_INCREMENT,
  `producto_cod_producto` int(11) NOT NULL,
  `menu_cod_menu` int(11) NOT NULL,
  PRIMARY KEY (`cod_producto_menu`),
  KEY `fk_productos_menus_producto1_idx` (`producto_cod_producto`),
  KEY `fk_productos_menus_menu1_idx` (`menu_cod_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos_venta`
--

DROP TABLE IF EXISTS `puntos_venta`;
CREATE TABLE IF NOT EXISTS `puntos_venta` (
  `cod_punto_venta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_punto` varchar(45) NOT NULL,
  `direccion_punto` varchar(45) NOT NULL,
  `personas_cod_identificacion` bigint(10) NOT NULL,
  `marcas_cod_marca` int(11) NOT NULL,
  PRIMARY KEY (`cod_punto_venta`),
  KEY `fk_puntos_venta_personas1_idx` (`personas_cod_identificacion`),
  KEY `fk_puntos_venta_marcas1_idx` (`marcas_cod_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `cod_rol` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_rol` varchar(20) NOT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_permisos`
--

DROP TABLE IF EXISTS `roles_permisos`;
CREATE TABLE IF NOT EXISTS `roles_permisos` (
  `cod_rolper` int(11) NOT NULL AUTO_INCREMENT,
  `rol_cod_rol` int(11) NOT NULL,
  `permisos_cod_permiso` int(11) NOT NULL,
  PRIMARY KEY (`cod_rolper`),
  KEY `fk_roles_permisos_rol1_idx` (`rol_cod_rol`),
  KEY `fk_roles_permisos_permisos1_idx` (`permisos_cod_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `nick_name` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) NOT NULL,
  PRIMARY KEY (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `barrios`
--
ALTER TABLE `barrios`
  ADD CONSTRAINT `fk_barrios_puntos_venta1` FOREIGN KEY (`puntos_venta_cod_punto_venta`) REFERENCES `puntos_venta` (`cod_punto_venta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente_credito`
--
ALTER TABLE `cliente_credito`
  ADD CONSTRAINT `fk_cliente_credito_credito_abierto1` FOREIGN KEY (`credito_abierto_cod_abierto`) REFERENCES `credito_abierto` (`cod_abierto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_credito_credito_cerrado1` FOREIGN KEY (`credito_cerrado_cod_cerrado`) REFERENCES `credito_cerrado` (`cod_cerrado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comision`
--
ALTER TABLE `comision`
  ADD CONSTRAINT `fk_comision_personas1` FOREIGN KEY (`personas_cod_identificacion`) REFERENCES `personas` (`cod_identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `credito_menu`
--
ALTER TABLE `credito_menu`
  ADD CONSTRAINT `fk_credito_menu_credito_abierto1` FOREIGN KEY (`credito_abierto_cod_abierto`) REFERENCES `credito_abierto` (`cod_abierto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_credito_menu_menu1` FOREIGN KEY (`menu_cod_menu`) REFERENCES `menu` (`cod_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD CONSTRAINT `fk_ingresos_usuarios1` FOREIGN KEY (`usuarios_nick_name`) REFERENCES `usuarios` (`nick_name`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `malla_turnos`
--
ALTER TABLE `malla_turnos`
  ADD CONSTRAINT `fk_malla_turnos_personas1` FOREIGN KEY (`personas_cod_identificacion`) REFERENCES `personas` (`cod_identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `menus_puntos_venta`
--
ALTER TABLE `menus_puntos_venta`
  ADD CONSTRAINT `fk_menus_puntos_venta_menu1` FOREIGN KEY (`menu_cod_menu`) REFERENCES `menu` (`cod_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_menus_puntos_venta_puntos_venta1` FOREIGN KEY (`puntos_venta_cod_punto_venta`) REFERENCES `puntos_venta` (`cod_punto_venta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `fk_personas_rol1` FOREIGN KEY (`rol_cod_rol`) REFERENCES `rol` (`cod_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_personas_usuarios1` FOREIGN KEY (`usuarios_nick_name`) REFERENCES `usuarios` (`nick_name`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos_menus`
--
ALTER TABLE `productos_menus`
  ADD CONSTRAINT `fk_productos_menus_menu1` FOREIGN KEY (`menu_cod_menu`) REFERENCES `menu` (`cod_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_productos_menus_producto1` FOREIGN KEY (`producto_cod_producto`) REFERENCES `producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `puntos_venta`
--
ALTER TABLE `puntos_venta`
  ADD CONSTRAINT `fk_puntos_venta_marcas1` FOREIGN KEY (`marcas_cod_marca`) REFERENCES `marcas` (`cod_marca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_puntos_venta_personas1` FOREIGN KEY (`personas_cod_identificacion`) REFERENCES `personas` (`cod_identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `roles_permisos`
--
ALTER TABLE `roles_permisos`
  ADD CONSTRAINT `fk_roles_permisos_permisos1` FOREIGN KEY (`permisos_cod_permiso`) REFERENCES `permisos` (`cod_permiso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_roles_permisos_rol1` FOREIGN KEY (`rol_cod_rol`) REFERENCES `rol` (`cod_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
