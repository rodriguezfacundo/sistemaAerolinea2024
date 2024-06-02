package sistemaAutogestion;

import sistemaAutogestion.Retorno;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */

    //TODOS LOS METODOS QUE RECIBEN PARAMETROS NO PUEDEN SER NULOS NI VACIOS.
    
    //pre: no debe ingresar parametros
    //post: : Crea la estructura necesaria para representar el sistema de Gestión.
    public Retorno crearSistemaDeAutogestion();
    //todo: ser mas especifico con las pre condiciones. poner que es lo que no controlo 
    
    //pre: recibe un nombre (String), pais (String), y cantMaxAviones (int y > 0)
    //post: : Registra la aerolínea, especificando la cantidad máxima de aviones que puede gestionar.
    //Devuelve ok si pudo registrar la aerolinea
    // Devuelve error 1 si ya existe una aerolinea con dicho nombre.
    // Devuelve error 2 si la cantidad de aviones es menor o igual a 0
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones);

    //pre: recibe un nombre (String)
    //post:  Elimina la aerolínea, siempre y cuando no tenga aviones registrados.
    // devuelve error 1 En caso de que no exista una aerolínea con dicho nombre
    // devuelve error 2 Si tiene aviones registrados.
    // Devuelve no implementada cuando aun no se implemento, retorno por defecto.
    public  Retorno eliminarAerolinea(String nombre);

    //pre: Recibe un codigo(String), una capacidad maxima(int mayor a 9 y multiplo de 3), y un nomAerolinea(String)
    //post: : Registra un avión dentro de la aerolínea, indicando la cantidad máxima de pasajeros que puede permitir
    //devuelve error 1 En caso de que ya exista dicho código de avión en la aerolínea.
    //devuelve error 2  Si la capacidad máxima es < que 9 pasajeros o no es múltiplo de 3
    //devuelve error 3 si no existe la aerolinea
    //devuelve error 4 Si al registrar el avión se supera la cantidad máxima soportada por la aerolínea
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);

    //pre: Recibe un nomAerolinea(String), y un codAvion(String)
    //post: Elimina el avión del sistema, siempre y cuando no tenga registrado ningún viaje con pasajes vendidos.
    // Devuelve error 1 En caso de que no exista la aerolínea
    // Devuelve error 2 - En caso de que no exista el código de avión dentro de la aerolínea.
    // Devuelve error 3  En caso de que tenga algún viaje con pasajes vendidos
    public Retorno  eliminarAvion(String nomAerolinea, String codAvion);

    //pre: Recibe un pasaporte(String), un nombre(String) y una edad(int de 7 caracteres).
    //post:  Se registra el cliente en el sistema. El pasaporte debe ser un código alfanumérico de 7 caracteres
    //Devuelve ok si pudo dar de alta el cliente.
    //Devuelve error 1 en caso de que la edad sea menor a 0
    //Devuelve error 2 en caso de que el numero de pasaporte sea <> a 7 caracteres
    //Devuelve error 3 en caso de que ya exista un cliente con dicho pasaporte.
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);

      
    //pre: Se debe ingresar un codigoVuelo(String), una aerolinea(String), un codAvion(String), un paisDestino(String)
    // un dia(int), un mes(int), un anio(int), cantPasajesEcon(int), cantPasajesPClase(int).
    //Todos los vuelos salen en un único horario (no será necesario verificar la correctitud
    //de la fecha ingresada)
    //post:  Se crea el vuelo en el sistema
    // Devuelve error 1 en caso de que ya exista el codigo de vuelo en el sistema
    //Devuelve error 2 en caso de que la aerolinea no exista en el sistema
    //Devuelve error 3 en caso de que el codigo de avion no exista dentro de la aerolinea
    //Devueve error 4 en caso de que ya exista un vuelo creado para ese avion en dicha fecha.
    //Devuelve error 5 – En caso de que las cantidades de pasajes (de cualquiera de las categorías) no sea
    // múltiplo de 3.
    //Devuelve error 6 - En caso de que la suma de los pasajes de ambas categorías supere la cant. máxima
    // permitida por el avión.
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String
            paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);

    //pre: Se debe ingresar un pasaporteCliente(String), un codigoVuelo(String) y una categoriaPasaje(int).
    //post: Se compra un pasaje para el cliente y la categoria elegida.
    //Devuelve error 1 En caso de que el pasaporte del cliente no exista
    //Devuelve error 2 En caso de que el código de vuelo no exista
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int
            categoríaPasaje);

    //pre: Se debe ingresar un pasaporteCliente(String), y un codigoVuelo(String).
    //post:Se realiza la devolución del pasaje comprado anteriormente por el cliente. En caso de existir clientes en lista de
    //espera, se le otorgará el pasaje al primero de la lista.
    //Devuelve error 1 caso de que exista el pasaporte del cliente
    //Devuelve error 2 caso de que no exista el código de vuelo
    //Devuelve error 3 en caso de que no exista una compra del cliente para dicho vuelo.
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);


      /*
    **************** LISTADO Y REPORTES **************************************
    */

    //pre: Tener una lista de aerolineas
    //post: Muestra la lista de aerolineas
    public Retorno listarAerolineas();

    //pre: Tener una lista de aviones, ingresar un nombre de aerolinea(String)
    //post: Se muestran todos los aviones de dicha aerolínea
    //Devuelve error 1 en caso de que no exista una aerolinea con dicho nombre.
    public Retorno listarAvionesDeAerolinea(String nombre);

    //pre: Tener una lista de clientes
    //post: Lista todos los clientes registrados en el sistema, según orden de registro (el último registrado debe mostrarse
    //primero)
    public Retorno listarClientes();

    //pre: Se listan todos los vuelos del sistema.
    //post: Se listan todos los vuelos del sistema. Se debe indicar el código de vuelo, la aerolínea a la que pertenece, el código de
    //avión y la cantidad de pasajes de cada categoría que fueron vendidos (en orden: Econ. y Prim.) y la cantidad que tiene disponible.
    public Retorno listarVuelos();

    //pre: Se debe ingresar un pasaporte(String).
    //post: Se deben mostrar todos los vuelos para los cuales el cliente compro pasajes, indicados con “CPR” (se deben incluir
    //también aquellos para los cuales realizó devolución de pasajes, indicándolo con “DEV”). Los últimos pasajes comprados son los
    //que deben mostrarse al inicio del reporte.
    //Devuelve error 1 en caso de que no exista el pasaporte del cliente.
    public Retorno vuelosDeCliente(String pasaporte);

    //pre: Se debe ingresar un nombreAerolinea(String)
    //post: Se deben mostrar todos los pasajes devueltos para dicha aerolínea, indicando el pasaporte del cliente y el vuelo.
    //Devuelve error 1 en caso de que no exista la aerolinea
    public Retorno  pasajesDevueltos(String nombreAerolinea);

    //pre: Se debe ingresar un codigo de vuelo(String).
    //post: Se debe mostrar la distribución de pasajeros en el avión, según las diferentes categorías de pasajes ofrecidos y
    //vendidos. Los asientos (pasajes) de primera clase se sitúan al principio del avión. Todos los aviones cuentan con filas de 3 asientos
    //cada uno.
    public Retorno vistaDeVuelo(String codigoVuelo);
     
}
