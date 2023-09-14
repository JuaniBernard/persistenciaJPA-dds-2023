# persistenciaJPA-dds-2023

## TP1 - Persistencia en JPA

Este trabajo se basa en el ejercicio visto en clase el 13-09-2023, a esta versión se le agregaron las modificaciones sugeridas:

* En el método "mostrarPedidos" de la clase "Cliente" se agregó un loop "for" para mostrar detalles del pedido.

* En la clase "Pedido" se agregó el parámetro "fetch = FetchType.EAGER" en la relación "OneToMany" con la clase "DetallePedido".

* En la enumeración "Estado" se agregó la opción "Listo".
