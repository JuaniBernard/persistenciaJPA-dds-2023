package com.um.tp1PersistenciaJPA.entidades;

import com.um.tp1PersistenciaJPA.enumeraciones.Estado;
import com.um.tp1PersistenciaJPA.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private TipoEnvio tipoEnvio;
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER) //Se agrega el parámetro "FetchType.EAGER"
    @JoinColumn(name = "Pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedidoed){

        detallePedidos.add(detallePedidoed);
    }
}
