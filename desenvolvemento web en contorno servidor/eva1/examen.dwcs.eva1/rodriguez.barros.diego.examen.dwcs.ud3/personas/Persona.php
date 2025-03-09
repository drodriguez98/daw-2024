<?php

// Clase abstracta base para todas las personas

abstract class Persona {

    // Atributos comunes para todas las personas

    protected $nombre;
    protected $apellido1;
    protected $apellido2;
    protected $fechaNacimiento;
    protected $dni;
    protected $direccion;
    protected $telefonos;
    protected $sexo;

    // Contador de objetos creados

    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo) {
        $this->nombre = $nombre;
        $this->apellido1 = $apellido1;
        $this->apellido2 = $apellido2;
        $this->fechaNacimiento = $fechaNacimiento;
        $this->dni = $dni;
        $this->direccion = $direccion;
        $this->telefonos = $telefonos;
        $this->sexo = $sexo;
        self::$contador++;
    }

    // Getters y Setters para los atributos comunes

    public function getNombre() { return $this->nombre; }
    public function setNombre($nombre) { $this->nombre = $nombre; }
    public function getApellido1() { return $this->apellido1; }
    public function setApellido1($apellido1) { $this->apellido1 = $apellido1; }
    public function getApellido2() { return $this->apellido2; }
    public function setApellido2($apellido2) { $this->apellido2 = $apellido2; }
    public function getFechaNacimiento() { return $this->fechaNacimiento; }
    public function setFechaNacimiento($fechaNacimiento) { $this->fechaNacimiento = $fechaNacimiento; }
    public function getDni() { return $this->dni; }
    public function setDni($dni) { $this->dni = $dni; }
    public function getDireccion() { return $this->direccion; }
    public function setDireccion($direccion) { $this->direccion = $direccion; }
    public function getTelefonos() { return $this->telefonos; }
    public function setTelefonos($telefonos) { $this->telefonos = $telefonos; }
    public function getSexo() { return $this->sexo; }
    public function setSexo($sexo) { $this->sexo = $sexo; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $nombres = ["Juan", "Ana", "Luis", "María"];
        $apellidos = ["Gómez", "Pérez", "López", "Rodríguez"];
        $sexos = ["M", "F"];
        $nombre = $nombres[array_rand($nombres)];
        $apellido1 = $apellidos[array_rand($apellidos)];
        $apellido2 = $apellidos[array_rand($apellidos)];
        $fechaNacimiento = rand(1980, 2010) . "-" . rand(1, 12) . "-" . rand(1, 28);
        $dni = "12345678" . chr(rand(65, 90));
        $direccion = "Calle Falsa 123";
        $telefonos = [rand(600000000, 699999999)];
        $sexo = $sexos[array_rand($sexos)];
        self::$contador++;

        return [
            'nombre' => $nombre,
            'apellido1' => $apellido1,
            'apellido2' => $apellido2,
            'fechaNacimiento' => $fechaNacimiento,
            'dni' => $dni,
            'direccion' => $direccion,
            'telefonos' => $telefonos,
            'sexo' => $sexo
        ];

    }

    // Método que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return "Nombre: $this->nombre $this->apellido1 $this->apellido2, DNI: $this->dni, Dirección: $this->direccion, Sexo: $this->sexo"; }

    // Método trabajar

    public function trabajar() { return "Soy una persona trabajando."; }

}

// Clase para Administrativos

class Administrativo extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $cursosCompletados;
    protected $sueldo;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $cursosCompletados, $sueldo) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->cursosCompletados=$cursosCompletados;
        $this->sueldo=$sueldo;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getCursosCompletados() { return $this->cursosCompletados; }
    public function setCursosCompletados($cursosCompletados) { $this->cursosCompletados = $cursosCompletados; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }

    // Método heredado de la clase Persona para generar un objeto al azar

    public static function generarAlAzar() {

        $cursos=["ASIR", "DAW", "DAM", "Panadería y Repostería"];
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40);
        $cursosCompletados = $cursos[array_rand($cursos)];
        $sueldo = rand(900, 2000);
        
        return new Administrativo(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $cursosCompletados,
            $sueldo
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Método para convertir a string los datos de un objeto

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Cursos completados: $this->cursosCompletados, Sueldo: $this->sueldo"; }

    // Método para comprobar que la lógica se está aplicando correctamente para cada objeto

    public function trabajar() { return $this->sexo == "F" ? "Soy una administrativa y estoy gestionando tareas administrativas." : "Soy un administrativo y estoy gestionando tareas administrativas."; }
}

// Clase para Tecnicos

class Tecnico extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $certificacionesObtenidas;
    protected $sueldo;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $certificacionesObtenidas, $sueldo) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->certificacionesObtenidas = $certificacionesObtenidas;
        $this->sueldo = $sueldo;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getCertificacionesObtenidas() { return $this->certificacionesObtenidas; }
    public function setCertificacionesObtenidas($certificacionesObtenidas) { $this->certificacionesObtenidas = $certificacionesObtenidas; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $certificaciones=["Google Certified Professional Cloud Architect", "AWS Certified Solutions Architect", "CISM – Certified Information Security Manager", "CRISC – Certified in Risk and Information Systems Control"];
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40); // Años en la empresa aleatorio 
        $certificacionesObtenidas = $certificaciones[array_rand($certificaciones)];
        $sueldo = rand(900, 2000);
        return new Tecnico(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $certificacionesObtenidas,
            $sueldo
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Certificaciones obtenidas: $this->certificacionesObtenidas, Sueldo: $this->sueldo"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una tecnica y estoy dando soporte." : "Soy un tecnico y estoy dando soporte."; }

}

// Clase para Personal de Limpieza

class PersonalLimpieza extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $sueldo;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $sueldo) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->sueldo = $sueldo;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40); // Años en la empresa aleatorio
        $sueldo = rand(900, 2000);
        return new PersonalLimpieza(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $sueldo
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Sueldo: $this->sueldo"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una trabajadora de limpieza y estoy limpiando en el instituto." : "Soy un trabajador de limpieza y estoy limpiando en el instituto."; }

}

// Clase para Repartidores

class Repartidor extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $sueldo;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $sueldo) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->sueldo = $sueldo;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40); // Años en la empresa aleatorio
        $sueldo = rand(900, 2000);
        return new Repartidor(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $sueldo
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Sueldo: $this->sueldo"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una repartidora y estoy repartiendo comida rápida." : "Soy un repartidor y estoy repartiendo comida rápida."; }

}

// Clase para Gerentes

class Gerente extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $nivel;
    protected $sueldo;
    protected $plusPorBeneficios;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $nivel, $sueldo, $plusPorBeneficios) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->nivel = $nivel;
        $this->sueldo = $sueldo;
        $this->plusPorBeneficios = $plusPorBeneficios;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getNivel() { return $this->nivel; }
    public function setNivel($nivel) { $this->nivel = $nivel; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }
    public function getPlusPorBeneficios() { return $this->plusPorBeneficios; }
    public function setPlusPorBeneficios($plusPorBeneficios) { $this->plusPorBeneficios = $plusPorBeneficios; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $niveles = ['N1', 'N2', 'N3', 'N4'];
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40); // Años en la empresa aleatorio
        $nivel = $niveles[array_rand($niveles)];
        $sueldo = rand(900, 2000);
        $plusPorBeneficios = rand(5, 15);
        return new Gerente(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $nivel,
            $sueldo,
            $plusPorBeneficios
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Nivel: $this->nivel, Sueldo: $this->sueldo, Plus por beneficios: $this->plusPorBeneficios"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una gerente y estoy monitoreando el trabajo de los demás." : "Soy un gerente y estoy monitoreando el trabajo de los demás."; }

}

// Clase para Comerciales

class Comercial extends Persona {

    // Atributos específicos

    protected $aniosEmpresa;
    protected $nivel;
    protected $sueldo;
    protected $plusPorVenta;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $aniosEmpresa, $nivel, $sueldo, $plusPorVenta) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->aniosEmpresa = $aniosEmpresa;
        $this->nivel = $nivel;
        $this->sueldo = $sueldo;
        $this->plusPorVenta = $plusPorVenta;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getAniosEmpresa() { return $this->aniosEmpresa; }
    public function setAniosEmpresa($aniosEmpresa) { $this->aniosEmpresa = $aniosEmpresa; }
    public function getNivel() { return $this->nivel; }
    public function setNivel($nivel) { $this->nivel = $nivel; }
    public function getSueldo() { return $this->sueldo; }
    public function setSueldo($sueldo) { $this->sueldo = $sueldo; }
    public function getPlusPorVenta() { return $this->plusPorVenta; }
    public function setPlusPorVenta($plusPorVenta) { $this->plusPorVenta = $plusPorVenta; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $niveles = ['N1', 'N2', 'N3', 'N4'];
        $persona = parent::generarAlAzar();
        $aniosEmpresa = rand(1, 40); // Años en la empresa aleatorio
        $nivel = $niveles[array_rand($niveles)];
        $sueldo = rand(900, 2000);
        $plusPorVenta = rand(5, 15);
        return new Comercial(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $aniosEmpresa,
            $nivel,
            $sueldo,
            $plusPorVenta
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Años en la empresa: $this->aniosEmpresa, Nivel: $this->nivel, Sueldo: $this->sueldo, Plus por venta: $this->plusPorVenta"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una comercial y estoy vendiendo cosas." : "Soy un comercial y estoy vendiendo cosas."; }

}

// Clase para Autónomos

class Autonomo extends Persona {

    // Atributos específicos

    protected $disponibilidad;
    protected $precioHorasServicio;
    protected $rama;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $disponibilidad, $precioHorasServicio, $rama) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->disponibilidad = $disponibilidad;
        $this->precioHorasServicio = $precioHorasServicio;
        $this->rama = $rama;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getDisponibilidad() { return $this->disponibilidad; }
    public function setDisponibilidad($disponibilidad) { $this->disponibilidad = $disponibilidad; }
    public function getPrecioHorasServicio() { return $this->precioHorasServicio; }
    public function setPrecioHorasServicio($precioHorasServicio) { $this->precioHorasServicio = $precioHorasServicio; }
    public function getRama() { return $this->rama; }
    public function setRama($rama) { $this->rama = $rama; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $dias = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes'];
        $ramas = ['Freelance', 'Societario/a', 'Agrario/a', 'Colaborador/a'];
        $persona = parent::generarAlAzar();
        $disponibilidad = $dias[array_rand($dias)];
        $precioHorasServicio = rand(5, 15);
        $rama = $ramas[array_rand($ramas)];
        return new Autonomo(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $disponibilidad,
            $precioHorasServicio,
            $rama
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Disponibilidad: $this->disponibilidad, Precio Horas Servicio: $this->precioHorasServicio, Rama: $this->rama"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una autónoma y trabajo por cuenta propia." : "Soy un autónomo y trabajo por cuenta propia."; }

}

// Clase para Formadores

class Formador extends Persona {

    // Atributos específicos

    protected $disponibilidad;
    protected $precioHorasServicio;
    protected $rama;
    private static $contador = 0;

    // Constructor

    public function __construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo, $disponibilidad, $precioHorasServicio, $rama) {
        parent::__construct($nombre, $apellido1, $apellido2, $fechaNacimiento, $dni, $direccion, $telefonos, $sexo);
        $this->disponibilidad = $disponibilidad;
        $this->precioHorasServicio = $precioHorasServicio;
        $this->rama = $rama;
        self::$contador++;
    }

    // Getters y setters para los atributos específicos

    public function getDisponibilidad() { return $this->disponibilidad; }
    public function setDisponibilidad($disponibilidad) { $this->disponibilidad = $disponibilidad; }
    public function getPrecioHorasServicio() { return $this->precioHorasServicio; }
    public function setPrecioHorasServicio($precioHorasServicio) { $this->precioHorasServicio = $precioHorasServicio; }
    public function getRama() { return $this->rama; }
    public function setRama($rama) { $this->rama = $rama; }

    // Generar un objeto con datos aleatorios

    public static function generarAlAzar() {
        $persona = parent::generarAlAzar();
        $dias = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes'];
        $ramas = ['Freelance', 'Societario/a', 'Agrario/a', 'Colaborador/a'];
        $disponibilidad = $dias[array_rand($dias)];
        $precioHorasServicio = rand(5, 15);
        $rama = $ramas[array_rand($ramas)];
        return new Formador(
            $persona['nombre'],
            $persona['apellido1'],
            $persona['apellido2'],
            $persona['fechaNacimiento'],
            $persona['dni'],
            $persona['direccion'],
            $persona['telefonos'],
            $persona['sexo'],
            $disponibilidad,
            $precioHorasServicio,
            $rama
        );
    }

    // Método heredado de la clase Persona que devuelve el número de objetos creados

    public static function numeroObjetosCreado() { return self::$contador; }

    // Implementación de __toString

    public function __toString() { return parent::__toString() . ", Disponibilidad: $this->disponibilidad, Precio Horas Servicio: $this->precioHorasServicio, Rama: $this->rama"; }

    // Método trabajar

    public function trabajar() { return $this->sexo == "F" ? "Soy una formadora y trabajo enseñando cosas a la gente." : "Soy un formador y trabajo enseñando cosas a la gente."; }

}

// Script para crear 100 objetos aleatorios generando un número aleatorio para determinar la clase (1: Administrativo, 2: Profesorado, 3: Tecnico, etc.)

for ($i = 0; $i < 100; $i++) {

    $claseAleatoria = rand(1, 8); //
    
    switch ($claseAleatoria) {
        case 1:
            $admin = Administrativo::generarAlAzar();
            echo $admin->__toString() . PHP_EOL;
            echo $admin->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 2:
            $tec = Tecnico::generarAlAzar();
            echo $tec->__toString() . PHP_EOL;
            echo $tec->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 3:
            $rep = Repartidor::generarAlAzar();
            echo $rep->__toString() . PHP_EOL;
            echo $rep->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 4:
            $ger = Gerente::generarAlAzar();
            echo $ger->__toString() . PHP_EOL;
            echo $ger->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 5:
            $com = Comercial::generarAlAzar();
            echo $com->__toString() . PHP_EOL;
            echo $com->trabajar() . PHP_EOL;
            echo "\n"; 
            break;
        case 6:
            $aut = Autonomo::generarAlAzar();
            echo $aut->__toString() . PHP_EOL;
            echo $aut->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 7:
            $form = Formador::generarAlAzar();
            echo $form->__toString() . PHP_EOL;
            echo $form->trabajar() . PHP_EOL;
            echo "\n";
            break;
        case 8:
            $limp = PersonalLimpieza::generarAlAzar();
            echo $limp->__toString() . PHP_EOL;
            echo $limp->trabajar() . PHP_EOL;
            echo "\n";
            break;
    }
}

// Mostrar en pantalla el número de objetos creados de cada tipo

echo "Objetos de Administrativo creados: " . Administrativo::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Tecnico creados: " . Tecnico::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Repartidor creados: " . Repartidor::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Gerente creados: " . Gerente::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Comercial creados: " . Comercial::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Autonomo creados: " . Autonomo::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de Formador creados: " . Formador::numeroObjetosCreado() . PHP_EOL;
echo "Objetos de PersonalLimpieza creados: " . PersonalLimpieza::numeroObjetosCreado() . PHP_EOL;

?>