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
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Splinter");

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Irlandesa");

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Uruguaya");

        r = miSistema.crearAerolinea("Aerolinea Iberia", "Espania", 36);
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Iberia");

    }

    @Test
    public void testCrearAerolineaError1() {
        precarga();
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Splinter, no pudo crearse");

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Irlandesa, no pudo crearse");

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Uruguaya, no pudo crearse");

        r = miSistema.crearAerolinea("Aerolinea Iberia", "Espania", 36);
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Iberia, no pudo crearse");

    }

    @Test

    public void testCrearAerolineaError2() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Francesa", "Francia", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

        r = miSistema.crearAerolinea("Aerolinea Inglesa", "Inglaterra", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

        r = miSistema.crearAerolinea("Aerolinea Paraguaya", "Paraguay", -10);
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

        r = miSistema.crearAerolinea("Aerolinea Cubana", "Cuba", -1);
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

    }

    @Test
    public void testEliminarAerolineaOk() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Uruguaya");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se elimino correctamente la Aerolinea Uruguaya");
    }

    @Test

    public void testEliminarAerolineaError1() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Venezolana");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No existe la Aerolinea Venezolana, no se pudo eliminar");

        r = miSistema.eliminarAerolinea("Aerolinea Lele");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No existe la Aerolinea Lele, no se pudo eliminar");

        r = miSistema.eliminarAerolinea("Aerolinea Instint");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No existe la Aerolinea Instint, no se pudo eliminar");

        r = miSistema.eliminarAerolinea("Aerolinea Piral");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No existe la Aerolinea Piral, no se pudo eliminar");
    }

    @Test

    public void testEliminarAerolineaError2() {
        precarga();
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes eliminar la aerolinea Irlandesa ya que contiene mas de un avion");
    }

    @Test
    public void testRegistrarAvionOk() {
        precarga();
        Retorno r = miSistema.registrarAvion("AVA123", 30, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion AVA123 en Aerolinea Splinter");

        r = miSistema.registrarAvion("SPI331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion SPI331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("ASUS666", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion ASUS666 en Aerolinea Splinter");

        r = miSistema.registrarAvion("EPOA331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion EPOA331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("LULU331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion LULU331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("PPP990", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion PPP990 en Aerolinea Splinter");

        r = miSistema.registrarAvion("QWER123", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion QWER123 en Aerolinea Splinter");

        r = miSistema.registrarAvion("AVEO3455", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion AVEO3455 en Aerolinea Splinter");

        r = miSistema.registrarAvion("ITIA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion ITIA1444 en Aerolinea Splinter");

        r = miSistema.registrarAvion("UTIOA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion UTIOA1444 en Aerolinea Splinter");

        r = miSistema.registrarAvion("SEC777", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion SEC777 en Aerolinea Splinter");

        r = miSistema.registrarAvion("333UVA", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion 333UVA en Aerolinea Splinter");

    }

    @Test
    public void testRegistrarAvionError1() {
        precarga();
        Retorno r = miSistema.registrarAvion("SEC777", 30, "Aerolinea Irlandesa");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe el avion SEC777 en Aerolinea Irlandesa, no se pudo registrar");

        r = miSistema.registrarAvion("IFF123", 30, "Aerolinea Irlandesa");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe el avion IFF123 en Aerolinea Irlandesa, no se pudo registrar");

    }

    @Test
    public void testRegistrarAvionError2() {
        precarga();
        Retorno r = miSistema.registrarAvion("UTU441", 5, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se puede registrar un avion donde su capacidad maxima sea < 9 o  % 3 != 0");

        r = miSistema.registrarAvion("UTE334", 11, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se puede registrar un avion donde su capacidad maxima sea < 9 o  % 3 !=");

        r = miSistema.registrarAvion("PPI333", 13, "Aerolinea Irlandesa");
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se puede registrar un avion donde su capacidad maxima sea < 9 o  % 3 !=");
    }

    @Test
    public void testRegistrarAvionError3() {
        Retorno r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Petrolera");
        assertEquals(Retorno.error3().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error3().resultado, "No se puede registrar un avion, la Aerolinea Petrolera no existe");

        r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Opticus");
        assertEquals(Retorno.error3().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error3().resultado, "No se puede registrar un avion, la Aerolinea Opticus no existe");

        r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Nectar");
        assertEquals(Retorno.error3().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error3().resultado, "No se puede registrar un avion, la Aerolinea Nectar no existe");

    }

    @Test
    public void testRegistrarAvionError4() {
        precarga();
        Retorno r = miSistema.registrarAvion("HHH333", 33, "Aerolinea Irlandesa");
        assertEquals(Retorno.error4().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error4().resultado, "No se puede registrar un avion que supera la cantidad maxima permitida de aviones en la aerolinea Irlandesa ");

    }

    @Test
    public void testEliminarAvionOk() {
        precarga();
        Retorno r = miSistema.eliminarAvion("Aerolinea Irlandesa", "IFF123");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se ha eliminado exitosamente el avion IFF123 de la Aerolina Irlandesa");

        r = miSistema.eliminarAvion("Aerolinea Irlandesa", "FFF000");
        assertEquals(Retorno.ok().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se ha eliminado exitosamente el avion FFF000 de la Aerolina Irlandesa");

    }

    @Test
    public void testEliminarAvionError1() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Noba", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se pudo eliminar el avion AVA999 ya que la Aerolina Noba no existe");

        r = miSistema.eliminarAvion("Aerolinea Ultra", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se pudo eliminar el avion AVA999 ya que la Aerolina Ultra no existe");

        r = miSistema.eliminarAvion("Aerolinea Ether", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se pudo eliminar el avion AVA999 ya que la Aerolina Ether no existe");

        r = miSistema.eliminarAvion("Aerolinea Lotus", "AVA999");
        assertEquals(Retorno.error1().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se pudo eliminar el avion AVA999 ya que la Aerolina Lotus no existe");

    }

    @Test
    public void testEliminarAvionError2() {
        precarga();
        Retorno r = miSistema.eliminarAvion("Aerolinea Irlandesa", "UVA443455");
        assertEquals(Retorno.error2().resultado, r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se pudo eliminar al avion UVA443455 ya que no existe registrado en la aerolinea Irlandesa");

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
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se listaron aviones ya que la Aerolinea Petrolera no existe");
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

    @Test
    public void testCrearAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {

        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR3() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Gol Brasil", "AA345");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
        assertEquals(Retorno.error2().resultado, r.resultado);

    }

    @Test
    public void testListarAerolineas() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAerolineas();
        assertEquals("Aerolineas Argentinas-Argentina-10|\nCopa Airlines-Panamá-30|\nDelta Air Lines-Estados Unidos-30|\nIberia-España-20|", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolinea() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA311-21|\nAA345-12|", r.valorString);

    }
    @Test
    public void testEliminarTodosLosAvionesYAgregarUnoNuevo() {
        // Crear una aerolínea y registrar algunos aviones
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
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

}
