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
 * @author facundo
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
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo satisfactoriamente el sistema de auto gestion");

    }

    @Test
    public void testCrearAerolineaOk() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Splinter");

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Irlandesa");

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se creo la nueva aerolinea Aerolina Uruguaya");

    }
    @Test
    public void testCrearAerolineaError1() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Splinter", "Italia", 12);
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Splinter, no pudo crearse");

        r = miSistema.crearAerolinea("Aerolinea Irlandesa", "Irlanda", 3);
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Irlandesa, no pudo crearse");

        r = miSistema.crearAerolinea("Aerolinea Uruguaya", "Uruguay", 10);
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe la aerolinea Uruguaya, no pudo crearse");

    }
    @Test

    public void testCrearAerolineaError2() {
        Retorno r = miSistema.crearAerolinea("Aerolinea Francesa", "Francia", 0);
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

        r = miSistema.crearAerolinea("Aerolinea Inglesa", "Inglaterra", -3);
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

        r = miSistema.crearAerolinea("Aerolinea Paraguaya", "Paraguay", -10);
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes registar una aerolinea sin aviones:(");

    }

    @Test
    public void testEliminarAerolineaOk() {
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Uruguaya");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se elimino correctamente la Aerolinea Uruguaya");
    }

    @Test

    public void testEliminarAerolineaError1() {
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Venezolana");
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No existe la Aerolinea Venezolana");
    }
    @Test

    public void testEliminarAerolineaError2() {
        Retorno r = miSistema.eliminarAerolinea("Aerolinea Splinter");
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No puedes eliminar la aerolinea Splinter ya que contiene mas de un avion");
    }

    @Test
    public void testRegistrarAvionOk() {
        Retorno r = miSistema.registrarAvion("AVA123", 30, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion AVA123 en Aerolinea Splinter");

        r = miSistema.registrarAvion("SPI331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion SPI331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("ASUS666", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion ASUS666 en Aerolinea Splinter");

        r = miSistema.registrarAvion("EPOA331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion EPOA331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("LULU331", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion LULU331 en Aerolinea Splinter");

        r = miSistema.registrarAvion("PPP990", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion PPP990 en Aerolinea Splinter");

        r = miSistema.registrarAvion("QWER123", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion QWER123 en Aerolinea Splinter");

        r = miSistema.registrarAvion("AVEO3455", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion AVEO3455 en Aerolinea Splinter");

        r = miSistema.registrarAvion("ITIA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion ITIA1444 en Aerolinea Splinter");

        r = miSistema.registrarAvion("UTIOA1444", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion UTIOA1444 en Aerolinea Splinter");

        r = miSistema.registrarAvion("SEC777", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion SEC777 en Aerolinea Splinter");

        r = miSistema.registrarAvion("333UVA", 45, "Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se registro el avion 333UVA en Aerolinea Splinter");


    }
    @Test
    public void testRegistrarAvionError1() {
        Retorno r = miSistema.registrarAvion("AVA123", 30, "Aerolinea Splinter");
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "Ya existe el avion AVA123 en Aerolinea Splinter, no se pudo registrar");

    }
    @Test
    public void testRegistrarAvionError2() {
        Retorno r = miSistema.registrarAvion("UTU441", 5, "Aerolinea Splinter");
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se puede registrar un avion donde su capacidad maxima sea < 9 o  % 3 != 0");
    }
    @Test
    public void testRegistrarAvionError3() {
        Retorno r = miSistema.registrarAvion("AVA123", 0, "Aerolinea Petrolera");
        assertEquals(Retorno.error3().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error3().resultado, "No se puede registrar un avion, la Aerolinea Petrolera no existe");

    }
    @Test
    public void testRegistrarAvionError4() {
        Retorno r = miSistema.registrarAvion("HHH333", 33, "Aerolinea Splinter");
        assertEquals(Retorno.error4().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error4().resultado, "No se puede registrar un avion que supera la cantidad maxima permitida de la Aeroliena Splinter ");

    }

    @Test
    public void testEliminarAvionOk() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Splinter", "AVA123");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se ha eliminado exitosamente el avion AVA123 de la Aerolina Splinter");

    }
    @Test
    public void testEliminarAvionError1() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Noba", "AVA999");
        assertEquals(Retorno.error1().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error1().resultado, "No se pudo eliminar el avion AVA999 ya que la Aerolina Noba no existe");

    }
    @Test
    public void testEliminarAvionError2() {
        Retorno r = miSistema.eliminarAvion("Aerolinea Splinter", "UVA443455");
        assertEquals(Retorno.error2().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.error2().resultado, "No se pudo eliminar al avion UVA443455 ya que no existe registrado en la aerolinea Splinter");

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
        Retorno r = miSistema.listarAerolineas();
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se listan todas las aerolineas del sistema");
    }


    @Test
    public void testListarAvionesDeAerolineaOk() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Aerolinea Splinter");
        assertEquals(Retorno.ok().resultado,r.resultado);
        prueba.ver(r.resultado, Retorno.ok().resultado, "Se listan todos los aviones de la Aerolina Splinter");

    }
    @Test
    public void testListarAvionesDeAerolineaError1() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Aerolinea Petrolera");
        assertEquals(Retorno.error1().resultado,r.resultado);
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


}
