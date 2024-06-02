package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest {

    private Sistema miSistema;
    Prueba prueba = new Prueba();

    public IObligatorioTest() {
    }

    @Before
    public void setUp() {
        this.miSistema = new Sistema();
    }

    @Test
    public void testCrearSistemaDeGestionOk() {
        Retorno r = miSistema.crearSistemaDeAutogestion();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaOk() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Iberia", "Espania", 36);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
         // Eliminar todas las aerolíneas y crear una nueva
         //elimino una a una las aerolineas
        r = miSistema.eliminarAerolinea("Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolinea Irlandesa");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolinea Uruguaya");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolinea Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Delta Air Lines");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Copa Airlines");
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Verificar que no haya aerolíneas registradas
        r = miSistema.listarAerolineas();
        assertEquals("", r.valorString); // No hay aerolíneas registradas

        // Agregar una nueva aerolínea
        r = miSistema.crearAerolinea("Nueva Aerolinea", "Nuevo País", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Verificar que la aerolínea se haya registrado correctamente
        r = miSistema.listarAerolineas();
        assertEquals("Nueva Aerolinea-Nuevo País-20|", r.valorString); // La aerolínea se ha registrado correctamente

    }

    @Test
    public void testCrearAerolineaError1() {
        precarga();
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Iberia", "Espania", 36);
        assertEquals(Retorno.error1().resultado, r.resultado);

    }

    @Test

    public void testCrearAerolineaError2() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Francesa", "Francia", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Inglesa", "Inglaterra", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Paraguaya", "Paraguay", -10);
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Cubana", "Cuba", -1);
        assertEquals(Retorno.error2().resultado, r.resultado);

    }

    @Test
    public void testEliminarAerolineaOk() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Uruguaya");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.eliminarAerolinea("Aerolinea Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.eliminarAerolinea("Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test

    public void testEliminarAerolineaError1() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Venezolana");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAerolinea("Aerolinea Lele");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAerolinea("Aerolinea Instint");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAerolinea("Aerolinea Piral");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test

    public void testEliminarAerolineaError2() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOk() {
        precarga();
        Retorno r = miSistema.registrarAvion("AVA123", 30, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("SPI331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("ASUS666", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("EPOA331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("LULU331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("PPP990", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("QWER123", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AVEO3455", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("ITIA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("UTIOA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("SEC777", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("333UVA", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        //eliminar todos los aviones y registrar uno nuevo
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA001", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA002", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA003", 30, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Eliminar todos los aviones registrados
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA001");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA002");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA003");
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Verificar que no haya aviones registrados
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("", r.valorString); // No hay aviones registrados

        // Agregar un nuevo avión
        r = miSistema.registrarAvion("AA999", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Verificar que el avión se haya registrado correctamente
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA999-15|", r.valorString); // El avión AA999 se ha registrado correctamente

    }

    @Test
    public void testRegistrarAvionError1() {
        precarga();
        Retorno r = miSistema.registrarAvion("SEC777", 30, "Aerolinea Irlandesa");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.registrarAvion("IFF123", 30, "Aerolinea Irlandesa");
        assertEquals(Retorno.error1().resultado, r.resultado);
        

    }

    @Test
    public void testRegistrarAvionError2() {
        precarga();
        Retorno r = miSistema.registrarAvion("UTU441", 5, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.registrarAvion("UTE334", 11, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.registrarAvion("PPI333", 13, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionError3() {
        Retorno r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Petrolera");
        assertEquals(Retorno.error3().resultado, r.resultado);

        r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Opticus");
        assertEquals(Retorno.error3().resultado, r.resultado);

        r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Nectar");
        assertEquals(Retorno.error3().resultado, r.resultado);

        r = miSistema.crearAerolinea("Aerolinea Ejemplo", "País Ejemplo", 15);
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Intentar agregar aviones con asientos menores a 10
        r = miSistema.registrarAvion("ABC123", 5, "Aerolinea Ejemplo");
        assertEquals(Retorno.error2().resultado, r.resultado); // Se espera un error debido a que el número de asientos es menor a 10

        r = miSistema.registrarAvion("XYZ456", 8, "Aerolinea Ejemplo");
        assertEquals(Retorno.error2().resultado, r.resultado); // Se espera un error debido a que el número de asientos es menor a 10

        r = miSistema.registrarAvion("LMN789", 20, "Aerolinea Ejemplo");
        assertEquals(Retorno.error2().resultado, r.resultado); // Se espera Error porque el número de asientos no es múltiplo de 3

        r = miSistema.listarAvionesDeAerolinea("Aerolinea Ejemplo");
        assertEquals("", r.valorString); // Verificar que no se haya agregado ningún avión

        r = miSistema.listarAvionesDeAerolinea("Aerolinea Ejemplo");
        assertEquals("", r.valorString); // No  deben haber aviones registrados

    }

    @Test
    public void testRegistrarAvionError4() {
        precarga();
        Retorno r = miSistema.registrarAvion("HHH333", 33, "Aerolinea Irlandesa");
        assertEquals(Retorno.error4().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionOk() {
        precarga();
        Retorno r = miSistema.eliminarAvion("Aerolinea Irlandesa", "IFF123");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.eliminarAvion("Aerolinea Irlandesa", "FFF000");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionError1() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Noba", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAvion("Aerolinea Ultra", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAvion("Aerolinea Ether", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.eliminarAvion("Aerolinea Lotus", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionError2() {
        precarga();
        Retorno r = miSistema.eliminarAvion("Aerolinea Irlandesa", "UVA443455");
        assertEquals(Retorno.error2().resultado, r.resultado); 
    }
    
    
    @Test
    public void testEliminarAvionError3() {
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.comprarPasaje("A123456", "VUELO-SEC1", 1);
        r = miSistema.eliminarAvion("Aerolinea Irlandesa", "SEC777");
        assertEquals(Retorno.error3().resultado,r.resultado);
    }
     
    @Test
    public void testRegistrarClienteOk() {
        Retorno r = miSistema.registrarCliente("A123456", "Facundo Rodriguez", 21);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
        r = miSistema.registrarCliente("B234567", "Mariana Gonzalez", 25);
        assertEquals(Retorno.ok().resultado, r.resultado); 

        r = miSistema.registrarCliente("C345678", "Juan Perez", 30);
        assertEquals(Retorno.ok().resultado, r.resultado); 

        r = miSistema.registrarCliente("D456789", "Laura Martinez", 0);
        assertEquals(Retorno.ok().resultado, r.resultado); 

        r = miSistema.registrarCliente("E567890", "Carlos Lopez", 35);
        assertEquals(Retorno.ok().resultado, r.resultado); 

        r = miSistema.registrarCliente("F678901", "Ana Fernandez", 28);
        assertEquals(Retorno.ok().resultado, r.resultado); 

    }
    
    @Test
    public void testRegistrarClienteError1(){
        Retorno r = miSistema.registrarCliente("A123456", "Facundo Rodriguez", -1);
        assertEquals(Retorno.error1().resultado, r.resultado); 
        
        r = miSistema.registrarCliente("B234567", "Mariana Gonzalez", -2);
        assertEquals(Retorno.error1().resultado, r.resultado); 

        r = miSistema.registrarCliente("C345678", "Juan Perez", -100);
        assertEquals(Retorno.error1().resultado, r.resultado); 

        r = miSistema.registrarCliente("D456789", "Laura Martinez", -12);
        assertEquals(Retorno.error1().resultado, r.resultado); 

        r = miSistema.registrarCliente("E567890", "Carlos Lopez", -4);
        assertEquals(Retorno.error1().resultado, r.resultado); 

        r = miSistema.registrarCliente("F678901", "Ana Fernandez", -1);
        assertEquals(Retorno.error1().resultado, r.resultado); 
    }
    
    @Test
    public void testRegistrarClienteError2(){
        Retorno r = miSistema.registrarCliente("A1234", "Facundo Rodriguez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 
        
        r = miSistema.registrarCliente("B23456734", "Mariana Gonzalez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 

        r = miSistema.registrarCliente("C34567", "Juan Perez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 

        r = miSistema.registrarCliente("D4567894", "Laura Martinez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 

        r = miSistema.registrarCliente("E56789044", "Carlos Lopez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 

        r = miSistema.registrarCliente("F67", "Ana Fernandez", 0);
        assertEquals(Retorno.error2().resultado, r.resultado); 
    }
    
    @Test
    public void testRegistrarClienteError3(){
        this.precarga();
        Retorno r = miSistema.registrarCliente("A123456", "Facundo Rodriguez", 21);
        assertEquals(Retorno.error3().resultado, r.resultado); 
        
        r = miSistema.registrarCliente("B234567", "Mariana Gonzalez", 25);
        assertEquals(Retorno.error3().resultado, r.resultado); 

        r = miSistema.registrarCliente("C345678", "Juan Perez", 30);
        assertEquals(Retorno.error3().resultado, r.resultado); 

        r = miSistema.registrarCliente("D456789", "Laura Martinez", 0);
        assertEquals(Retorno.error3().resultado, r.resultado); 

        r = miSistema.registrarCliente("E567890", "Carlos Lopez", 35);
        assertEquals(Retorno.error3().resultado, r.resultado); 

        r = miSistema.registrarCliente("F678901", "Ana Fernandez", 28);
        assertEquals(Retorno.error3().resultado, r.resultado); 
    }

    @Test
    public void testCrearVueloOk() {
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        assertEquals(Retorno.ok().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 6, 3, 2025, 33, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Irlandesa", "IFF123", "Colombia", 30, 3, 2025, 33, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Irlandesa", "IFF123", "Colombia", 19, 3, 2025, 33, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
    @Test
    public void testCrearVueloError1() {
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 8, 10, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Irlandesa", "IFF123", "Colombia", 6, 1, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Irlandesa", "IFF123", "Colombia", 29, 12, 2025, 33, 12);
        
        
        //Aqui hacemos los test para el error 1;
        r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.error1().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        assertEquals(Retorno.error1().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error1().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Irlandesa", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Irlandesa", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
    @Test
    public void testCrearVueloError2(){
        this.precarga();
         Retorno r  = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Hujalo", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.error2().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Tiitpo", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        assertEquals(Retorno.error2().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Hadduka", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error2().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Polopo", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Lituana", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Jersula", "IFF123", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error2().resultado, r.resultado);
        
    }
    
    @Test
    public void testCrearVueloError3(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SSAL303", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.error3().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "LLSF-2", "Uruguay", 7, 12, 2025, 27, 18);
        assertEquals(Retorno.error3().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SFSK4J", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error3().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IIPL34", "Colombia", 6, 3, 2025, 33, 12);
        assertEquals(Retorno.error3().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Irlandesa", "IFF12111", "Colombia", 30, 3, 2025, 33, 12);
        assertEquals(Retorno.error3().resultado, r.resultado);
        
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Irlandesa", "IFFF3341", "Colombia", 19, 3, 2025, 33, 12);
        assertEquals(Retorno.error3().resultado, r.resultado);
    }
    
    @Test
    public void testCrearVueloError4(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        
         r = miSistema.crearVuelo("VUELO-3310", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.error4().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-4491", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        assertEquals(Retorno.error4().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-1348", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        assertEquals(Retorno.error4().resultado, r.resultado); 
    }
    
    @Test
    public void testCrearVueloError5(){
        this.precarga();
        
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 10, 35);
        assertEquals(Retorno.error5().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 35, 10);
        assertEquals(Retorno.error5().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 5, 40);
        assertEquals(Retorno.error5().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 6, 3, 2025, 20, 25);
        assertEquals(Retorno.error5().resultado, r.resultado);
    }
    
    @Test
    public void testCrearVueloError6(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 39, 9);
        assertEquals(Retorno.error6().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 33, 15);
        assertEquals(Retorno.error6().resultado, r.resultado); 

        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 42, 6);
        assertEquals(Retorno.error6().resultado, r.resultado); 
        
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 6, 3, 2025, 36, 12);
        assertEquals(Retorno.error6().resultado, r.resultado);
    }

    @Test
    public void testComprarPasajeOk() {
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
    //30 en categoria economica
        r = miSistema.comprarPasaje("A123456", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("B234567", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("C345678", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("D456789", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("E567890", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("F678901", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("G789012", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("H890123", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("I901234", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("J012345", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("K123456", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("L234567", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("M345678", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("N456789", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("R890123", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("S901234", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("T012345", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("U123456", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("V234567", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("X456789", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("Y567890", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("Z678901", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("A789012", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("B890123", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("C901234", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //En espera primera clase;
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);

        // 15 compras adicionales en categoría premium
        r = miSistema.comprarPasaje("D012345", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("E123456", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("F234567", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("G345678", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("H456789", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("I567890", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("J678901", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("K789012", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("L890123", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("M901234", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("N012345", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("O123456", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("P234567", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("Q345678", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("R456789", "VUELO-SEC1", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
    @Test
    public void testComprarPasajeError1(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
        r = miSistema.comprarPasaje("AFF3456", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("BBBB567", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("CCCC678", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("DDDDI89", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("HGFA890", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
    @Test
    public void testComprarPasajeError2(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
    //30 en categoria economica
        r = miSistema.comprarPasaje("A123456", "VUELO-SSSASF3", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.comprarPasaje("B234567", "VUELO-LLAS3", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.comprarPasaje("C345678", "VUELO-SSF33", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.comprarPasaje("D456789", "VUELO-HHSSSL2", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.comprarPasaje("E567890", "VUELO-ASEE2", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.comprarPasaje("F678901", "VUELO-SEC440", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasaje() {
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.comprarPasaje("A123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("D456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("E567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("F678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("G789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("H890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("I901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("J012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("K123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("L234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("M345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("N456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("R890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("S901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("T012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("U123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("V234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("X456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Y567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Z678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("A789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("D012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("E123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("F234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("G345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("H456789", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("I567890", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("J678901", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("K789012", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("L890123", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("M901234", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("N012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("O123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("P234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("Q345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("R456789", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("B890123", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("Z678901", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("Y567890", "VUELO-SEC1", 2);

        //Recien aca probamos el test devolver pasaje.
        r = miSistema.devolverPasaje("D012345", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("D456789", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("E567890", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("E123456", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("A123456", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("K123456", "VUELO-SEC1");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }
    
    @Test
    public void testDevolverPasajeError1(){
        this.precarga();
        Retorno r = miSistema.devolverPasaje("SSFA330", "");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.devolverPasaje("SSFA440", "");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.devolverPasaje("LLSA334", "");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.devolverPasaje("ASFF344", "");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.devolverPasaje("0042KDD", "");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
     @Test
     public void testDevolverPasajeError2(){
        this.precarga();
        Retorno r = miSistema.devolverPasaje("A123456", "LLAO1333");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.devolverPasaje("F234567", "IFF013KK");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.devolverPasaje("J678901", "LSFSA03");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.devolverPasaje("G345678", "LLS34J");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.devolverPasaje("S567890", "JJSAL33");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testListarAerolineasOk() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~AEROLINEAS~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        precarga();
        Retorno r = miSistema.listarAerolineas();
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("Aerolinea Iberia-Espania-36|\n"
                + "Aerolinea Irlandesa-Irlanda-3|\n"
                + "Aerolinea Splinter-Italia-12|\n"
                + "Aerolinea Uruguaya-Uruguay-10|", r.valorString);
        System.out.println(r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolineaOk() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~AVIONES DE AEROLINEA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        precarga();
        Retorno r = miSistema.listarAvionesDeAerolinea("Aerolinea Irlandesa");
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("FFF000-45|\n"
                + "IFF123-45|\n"
                + "SEC777-45|", r.valorString);
        System.out.println(r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolineaError1() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Aerolinea Petrolera");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.listarAvionesDeAerolinea("Aerolinea Spac");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.listarAvionesDeAerolinea("Aerolinea Indu");
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.listarAvionesDeAerolinea("Aerolinea Polaca");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testListarClientes() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~CLIENTES~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.precarga();
        Retorno r = miSistema.listarClientes();
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("S567890-Martin Alvarez-27|\n" +
                 "R456789-Adriana Rojas-24|\n" +
                 "Q345678-Felipe Carrillo-30|\n" +
                 "P234567-Renata Castro-26|\n" +
                 "O123456-Esteban Molina-32|\n" +
                 "N012345-Camila Fuentes-29|\n" +
                 "M901234-Guillermo Avila-31|\n" +
                 "L890123-Veronica Salinas-25|\n" +
                 "K789012-Alfonso Campos-33|\n" +
                 "J678901-Paula Medina-28|\n" +
                 "I567890-Oscar Leon-34|\n" +
                 "H456789-Alejandra Villalobos-22|\n" +
                 "G345678-Francisco Paredes-30|\n" +
                 "F234567-Victoria Jimenez-27|\n" +
                 "E123456-Mauricio Ortega-26|\n" +
                 "D012345-Sara Lopez-29|\n" +
                 "C901234-Hector Navarro-31|\n" +
                 "B890123-Daniela Nunez-23|\n" +
                 "A789012-Andres Romero-28|\n" +
                 "Z678901-Monica Gil-32|\n" +
                 "Y567890-Pablo Rios-27|\n" +
                 "X456789-Isabel Mendoza-24|\n" +
                 "W345678-Roberto Vega-33|\n" +
                 "V234567-Natalia Torres-25|\n" +
                 "U123456-Sergio Luna-29|\n" +
                 "T012345-Lucia Gomez-26|\n" +
                 "S901234-Javier Morales-30|\n" +
                 "R890123-Gabriela Flores-22|\n" +
                 "Q789012-Fernando Ortiz-34|\n" +
                 "P678901-Carla Mendez-28|\n" +
                 "O567890-Diego Blanco-32|\n" +
                 "N456789-Valeria Soto-20|\n" +
                 "M345678-Ricardo Castro-33|\n" +
                 "L234567-Patricia Ruiz-27|\n" +
                 "K123456-Miguel Silva-31|\n" +
                 "J012345-Elena Soto-24|\n" +
                 "I901234-Jorge Diaz-29|\n" +
                 "H890123-Sofia Herrera-23|\n" +
                 "G789012-Luis Ramirez-26|\n" +
                 "F678901-Ana Fernandez-28|\n" +
                 "E567890-Carlos Lopez-35|\n" +
                 "D456789-Laura Martinez-22|\n" +
                 "C345678-Juan Perez-30|\n" +
                 "B234567-Mariana Gonzalez-25|\n" +
                 "A123456-Facundo Rodriguez-21|\n", r.valorString);
        System.out.println(r.valorString);
    }

    @Test
    public void testListarVuelos() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~VUELOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.crearVuelo("VUELO-SEC2", "Aerolinea Irlandesa", "SEC777", "Uruguay", 7, 12, 2025, 27, 18);
        r = miSistema.crearVuelo("VUELO-SEC3", "Aerolinea Irlandesa", "SEC777", "Colombia", 10, 3, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF1", "Aerolinea Irlandesa", "IFF123", "Colombia", 6, 3, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF2", "Aerolinea Irlandesa", "IFF123", "Colombia", 30, 3, 2025, 33, 12);
        r = miSistema.crearVuelo("VUELO-IFF3", "Aerolinea Irlandesa", "IFF123", "Colombia", 19, 3, 2025, 33, 12);
        
        r = miSistema.listarVuelos();
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("VUELO-SEC1-Aerolinea Irlandesa-SEC777-0-0-45|\n" +
                 "VUELO-SEC2-Aerolinea Irlandesa-SEC777-0-0-45|\n" +
                 "VUELO-SEC3-Aerolinea Irlandesa-SEC777-0-0-45|\n" +
                 "VUELO-IFF1-Aerolinea Irlandesa-IFF123-0-0-45|\n" +
                 "VUELO-IFF2-Aerolinea Irlandesa-IFF123-0-0-45|\n" +
                 "VUELO-IFF3-Aerolinea Irlandesa-IFF123-0-0-45|", r.valorString);
        System.out.println(r.valorString);
    }

    @Test
    public void testVuelosDeClienteOk() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~PASAJES COMPRADOS POR CLIENTE Veronica Salinas ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.crearVuelo("VUELO-LO34", "Aerolinea Irlandesa", "IFF123", "Irlanda", 4, 10, 2024, 30, 15);
        r = miSistema.crearVuelo("VUELO-IAA12", "Aerolinea Irlandesa", "IFF123", "Irlanda", 4, 10, 2026, 30, 15);
        r = miSistema.crearVuelo("VUELO-666HL", "Aerolinea Irlandesa", "IFF123", "Irlanda", 13, 11, 2026, 30, 15);
        
        r = miSistema.comprarPasaje("L890123", "VUELO-IAA12", 1);
        r = miSistema.comprarPasaje("L890123", "VUELO-666HL", 2);
        r = miSistema.comprarPasaje("L890123", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("L890123", "VUELO-LO34", 2);
        
        r = miSistema.devolverPasaje("L890123", "VUELO-666HL");
        r = miSistema.devolverPasaje("L890123", "VUELO-LO34");

        
        r = miSistema.vuelosDeCliente("L890123");
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("VUELO-LO34-DEV|\n" +
                 "VUELO-SEC1-CPR|\n"+
                 "VUELO-666HL-DEV|\n"+
                 "VUELO-IAA12-CPR|\n", r.valorString);
        System.out.println(r.valorString);
    }
    
    @Test
    public void testVuelosDeClienteError1(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.comprarPasaje("LLAS344", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("JJJSL34", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.comprarPasaje("SSGG843", "VUELO-SEC1", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testPasajesDevueltosOk() {
        System.out.println("~~~~~~~~~~~~~~~~PASAJES DEVUELTOS DE AEROLINEA IRLANDESA~~~~~~~~~~~~~~~");
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.comprarPasaje("A123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("D456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("E567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("F678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("G789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("H890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("I901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("J012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("K123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("L234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("M345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("N456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("R890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("S901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("T012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("U123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("V234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("X456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Y567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Z678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("A789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        // 15 compras adicionales en categoría premium
        r = miSistema.comprarPasaje("D012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("E123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("F234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("G345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("H456789", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("I567890", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("J678901", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("K789012", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("M901234", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("N012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("O123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("P234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("Q345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("R456789", "VUELO-SEC1", 2);
        r = miSistema.devolverPasaje("L890123", "VUELO-SEC1");
        r = miSistema.devolverPasaje("R456789", "VUELO-SEC1");
        r = miSistema.devolverPasaje("O123456", "VUELO-SEC1");
        r = miSistema.devolverPasaje("J678901", "VUELO-SEC1");
        r = miSistema.devolverPasaje("F234567", "VUELO-SEC1");
        r = miSistema.devolverPasaje("C901234", "VUELO-SEC1");
        r = miSistema.devolverPasaje("O567890", "VUELO-SEC1");
        r = miSistema.devolverPasaje("B234567", "VUELO-SEC1");
        r = miSistema.devolverPasaje("F678901", "VUELO-SEC1");
        r = miSistema.devolverPasaje("Z678901", "VUELO-SEC1");
        r = miSistema.pasajesDevueltos("Aerolinea Irlandesa");
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("Z678901-VUELO-SEC1|\n" +
                 "F678901-VUELO-SEC1|\n"+
                 "B234567-VUELO-SEC1|\n"+
                 "O567890-VUELO-SEC1|\n"+
                 "C901234-VUELO-SEC1|\n"+
                 "F234567-VUELO-SEC1|\n"+
                 "J678901-VUELO-SEC1|\n"+
                 "O123456-VUELO-SEC1|\n"+
                 "R456789-VUELO-SEC1|", r.valorString);
        System.out.println(r.valorString);
    }
    @Test
    public void testPasajesDevueltosError1(){
        this.precarga();
        Retorno r = miSistema.crearVuelo("VUELO-SEC1", "Aerolinea Irlandesa", "SEC777", "Egipto", 19, 5, 2024, 30, 15);
        r = miSistema.comprarPasaje("A123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("D456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("E567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("F678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("G789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("H890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("I901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("J012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("K123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("L234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("M345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("N456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("R890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("S901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("T012345", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("U123456", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("V234567", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("X456789", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Y567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Z678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("A789012", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("B890123", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("C901234", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("W345678", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("O567890", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("P678901", "VUELO-SEC1", 1);
        r = miSistema.comprarPasaje("Q789012", "VUELO-SEC1", 1);
        // 15 compras adicionales en categoría premium
        r = miSistema.comprarPasaje("D012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("E123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("F234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("G345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("H456789", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("I567890", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("J678901", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("K789012", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("M901234", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("N012345", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("O123456", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("P234567", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("Q345678", "VUELO-SEC1", 2);
        r = miSistema.comprarPasaje("R456789", "VUELO-SEC1", 2);
        r = miSistema.devolverPasaje("L890123", "VUELO-SEC1");
        r = miSistema.devolverPasaje("R456789", "VUELO-SEC1");
        r = miSistema.devolverPasaje("O123456", "VUELO-SEC1");
        r = miSistema.devolverPasaje("J678901", "VUELO-SEC1");
        r = miSistema.devolverPasaje("F234567", "VUELO-SEC1");
        r = miSistema.devolverPasaje("C901234", "VUELO-SEC1");
        r = miSistema.devolverPasaje("O567890", "VUELO-SEC1");
        r = miSistema.devolverPasaje("B234567", "VUELO-SEC1");
        r = miSistema.devolverPasaje("F678901", "VUELO-SEC1");
        r = miSistema.devolverPasaje("Z678901", "VUELO-SEC1");
        r = miSistema.pasajesDevueltos("Aerolinea Estupenda");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.pasajesDevueltos("Aerolinea Otalo");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.pasajesDevueltos("Aerolinea Iulas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testVistaDeVuelo() {
        //Completar para segunda entrega
    }
   


    private void precarga() {
        //Datos paises
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        r = miSistema.crearAerolinea("Aerolinea Iberia", "Espania", 36);
        //Datos aviones
        r = miSistema.registrarAvion("SEC777", 45, "Aerolinea Irlandesa");
        r = miSistema.registrarAvion("IFF123", 45, "Aerolinea Irlandesa");
        r = miSistema.registrarAvion("FFF000", 45, "Aerolinea Irlandesa");
        
        r = miSistema.registrarCliente("A123456", "Facundo Rodriguez", 21);
        r = miSistema.registrarCliente("B234567", "Mariana Gonzalez", 25);
        r = miSistema.registrarCliente("C345678", "Juan Perez", 30);
        r = miSistema.registrarCliente("D456789", "Laura Martinez", 22);
        r = miSistema.registrarCliente("E567890", "Carlos Lopez", 35);
        r = miSistema.registrarCliente("F678901", "Ana Fernandez", 28);
        r = miSistema.registrarCliente("G789012", "Luis Ramirez", 26);
        r = miSistema.registrarCliente("H890123", "Sofia Herrera", 23);
        r = miSistema.registrarCliente("I901234", "Jorge Diaz", 29);
        r = miSistema.registrarCliente("J012345", "Elena Soto", 24);
        r = miSistema.registrarCliente("K123456", "Miguel Silva", 31);
        r = miSistema.registrarCliente("L234567", "Patricia Ruiz", 27);
        r = miSistema.registrarCliente("M345678", "Ricardo Castro", 33);
        r = miSistema.registrarCliente("N456789", "Valeria Soto", 20);
        r = miSistema.registrarCliente("O567890", "Diego Blanco", 32);
        r = miSistema.registrarCliente("P678901", "Carla Mendez", 28);
        r = miSistema.registrarCliente("Q789012", "Fernando Ortiz", 34);
        r = miSistema.registrarCliente("R890123", "Gabriela Flores", 22);
        r = miSistema.registrarCliente("S901234", "Javier Morales", 30);
        r = miSistema.registrarCliente("T012345", "Lucia Gomez", 26);
        r = miSistema.registrarCliente("U123456", "Sergio Luna", 29);
        r = miSistema.registrarCliente("V234567", "Natalia Torres", 25);
        r = miSistema.registrarCliente("W345678", "Roberto Vega", 33);
        r = miSistema.registrarCliente("X456789", "Isabel Mendoza", 24);
        r = miSistema.registrarCliente("Y567890", "Pablo Rios", 27);
        r = miSistema.registrarCliente("Z678901", "Monica Gil", 32);
        r = miSistema.registrarCliente("A789012", "Andres Romero", 28);
        r = miSistema.registrarCliente("B890123", "Daniela Nunez", 23);
        r = miSistema.registrarCliente("C901234", "Hector Navarro", 31);
        r = miSistema.registrarCliente("D012345", "Sara Lopez", 29);
        r = miSistema.registrarCliente("E123456", "Mauricio Ortega", 26);
        r = miSistema.registrarCliente("F234567", "Victoria Jimenez", 27);
        r = miSistema.registrarCliente("G345678", "Francisco Paredes", 30);
        r = miSistema.registrarCliente("H456789", "Alejandra Villalobos", 22);
        r = miSistema.registrarCliente("I567890", "Oscar Leon", 34);
        r = miSistema.registrarCliente("J678901", "Paula Medina", 28);
        r = miSistema.registrarCliente("K789012", "Alfonso Campos", 33);
        r = miSistema.registrarCliente("L890123", "Veronica Salinas", 25);
        r = miSistema.registrarCliente("M901234", "Guillermo Avila", 31);
        r = miSistema.registrarCliente("N012345", "Camila Fuentes", 29);
        r = miSistema.registrarCliente("O123456", "Esteban Molina", 32);
        r = miSistema.registrarCliente("P234567", "Renata Castro", 26);
        r = miSistema.registrarCliente("Q345678", "Felipe Carrillo", 30);
        r = miSistema.registrarCliente("R456789", "Adriana Rojas", 24);
        r = miSistema.registrarCliente("S567890", "Martin Alvarez", 27);
    }

}
