package com.um.tp1PersistenciaJPA;

import com.um.tp1PersistenciaJPA.entidades.*;
import com.um.tp1PersistenciaJPA.enumeraciones.Estado;
import com.um.tp1PersistenciaJPA.enumeraciones.FormaPago;
import com.um.tp1PersistenciaJPA.enumeraciones.Tipo;
import com.um.tp1PersistenciaJPA.enumeraciones.TipoEnvio;
import com.um.tp1PersistenciaJPA.repositorios.ClienteRepository;
import com.um.tp1PersistenciaJPA.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Tp1PersistenciaJpaApplication {
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1PersistenciaJpaApplication.class, args);
		System.out.println("Probando TP1 Persistencia en JPA");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			//crear instancia rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesas")
					.build();
			//crear instancias de productos
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa con Cheddar")
					.precioVta(2000)
					.precioCompra(1200)
					.stockActual(50)
					.stockMin(3)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipo(Tipo.Insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa con Bacon")
					.precioVta(2200)
					.precioCompra(1500)
					.stockActual(32)
					.stockMin(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipo(Tipo.Insumo)
					.build();
			//agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			//guardar rubro
			rubroRepository.save(rubro1);
			//Crear instancia Cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Tony")
					.apellido("Soprano")
					.mail("tony@mail")
					.telefono("123456")
					.build();
			//Crear instancia domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Mulberry St")
					.numero(6538)
					.localidad("Newark")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Washington St")
					.numero(1223)
					.localidad("Manhattan")
					.build();
			//agregar domicilios a cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			//Crear Instancia Detalle Pedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(4000)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(2200)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(6000)
					.build();
			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString1 = "2023-09-13";
			String fechaString2 = "2023-09-17";
			// Parsear la cadena en un objeto Date
			Date fecha1 = formatoFecha.parse(fechaString1);
			Date fecha2 = formatoFecha.parse(fechaString2);
			//Crear Instancia Pedido
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha1)
					.total(6200)
					.estado(Estado.Entregado)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha2)
					.total(6000)
					.estado(Estado.Entregado)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			//Crear instancias de factura
			Factura factura1 = Factura.builder()
					.fecha(fecha1)
					.total(5800)
					.numero(1)
					.dto(400)
					.formaPago(FormaPago.Efectivo)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha2)
					.total(5400)
					.numero(2)
					.dto(600)
					.formaPago(FormaPago.Efectivo)
					.build();
			//Agregar detalles al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);
			//agregar pedidos al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			//vincular el detalle pedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			//vincular factura con pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			//guardar cliente
			clienteRepository.save(cliente1);

			//recuperar objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//recuperar Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getMail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}
		};
	}
}
