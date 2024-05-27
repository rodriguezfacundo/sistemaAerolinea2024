/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author facundo y fernando
 */
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
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo satisfactoriamente el sistema de auto gestion");

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
        
        //eliminar todo los aviones y registrar uno nuevo
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
        assertEquals(Retorno.error2().resultado, r.resultado); // Esperamos un error porque el avión no existe

    }
    
    /*
    Para la segunda entrega
    @Test
    public void testEliminarAvionError3() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Splinter", "UVA-443");
        assertEquals(Retorno.error3().resultado,r.resultado);
    }
     */
    @Test
    public void testRegistrarCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testCrearVuelo() {
        //Completar para segunda entrega
    }

    @Test
    public void testComprarPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testDevolverPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testListarAerolineasOk() {
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
        //Completar para segunda entrega
    }

    @Test
    public void testListarVuelos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVuelosDeCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testPasajesDevueltos() {
        //Completar para segunda entrega
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

    }

}
