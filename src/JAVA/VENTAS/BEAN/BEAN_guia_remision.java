package JAVA.VENTAS.BEAN;

public class BEAN_guia_remision {

    String codigo_operacion, codigo_sucursal, periodo, mes, codigo_documento, serie_documento, numero_documento, fecha_emision, codigo_documento_ref, serie_documento_ref, numero_documento_ref,
            codigo_moneda, afecto_igv, codigo_igv, codigo_grupo, status, es_facturado, es_precio_igv, codigo_entidad, razon_social, tipo_documento_id, es_pedido,
            numero_documento_id, direccion, codigo_ubigeo, descripcion_ubigeo, codigo_pagador, nombre_pagador, codigo_vendedor, nombre_vendedor, forma_pago, codigo_pedido,
            observacion, es_domiciliado, fecha_registro, codigo_transportista, nombre_transportista, numero_licencia, razon_social_trans, ruc_trans,tipo_operacion,
            codigo_vehiculo, marca, numero_civ, codigo_vehiculo_2, marca_2, numero_civ_2, codigo_direccion_pl, nombre_direccion_pl, punto_llegada, codigo_ubigeo_pl, descripcion_ubigeo_pl;

    int dias_credito;
    double tipo_cambio, porcentaje_detraccion, inafecto, base, igv, total, percepcion, total_documento, exonerado,
            importe_detraccion;

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getEs_pedido() {
        return es_pedido;
    }

    public void setEs_pedido(String es_pedido) {
        this.es_pedido = es_pedido;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getCodigo_operacion() {
        return codigo_operacion;
    }

    public void setCodigo_operacion(String codigo_operacion) {
        this.codigo_operacion = codigo_operacion;
    }

    public String getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(String codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getCodigo_documento() {
        return codigo_documento;
    }

    public void setCodigo_documento(String codigo_documento) {
        this.codigo_documento = codigo_documento;
    }

    public String getSerie_documento() {
        return serie_documento;
    }

    public void setSerie_documento(String serie_documento) {
        this.serie_documento = serie_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getCodigo_documento_ref() {
        return codigo_documento_ref;
    }

    public void setCodigo_documento_ref(String codigo_documento_ref) {
        this.codigo_documento_ref = codigo_documento_ref;
    }

    public String getSerie_documento_ref() {
        return serie_documento_ref;
    }

    public void setSerie_documento_ref(String serie_documento_ref) {
        this.serie_documento_ref = serie_documento_ref;
    }

    public String getNumero_documento_ref() {
        return numero_documento_ref;
    }

    public void setNumero_documento_ref(String numero_documento_ref) {
        this.numero_documento_ref = numero_documento_ref;
    }

    public String getCodigo_moneda() {
        return codigo_moneda;
    }

    public void setCodigo_moneda(String codigo_moneda) {
        this.codigo_moneda = codigo_moneda;
    }

    public String getAfecto_igv() {
        return afecto_igv;
    }

    public void setAfecto_igv(String afecto_igv) {
        this.afecto_igv = afecto_igv;
    }

    public String getCodigo_igv() {
        return codigo_igv;
    }

    public void setCodigo_igv(String codigo_igv) {
        this.codigo_igv = codigo_igv;
    }

    public String getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(String codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEs_facturado() {
        return es_facturado;
    }

    public void setEs_facturado(String es_facturado) {
        this.es_facturado = es_facturado;
    }

    public String getEs_precio_igv() {
        return es_precio_igv;
    }

    public void setEs_precio_igv(String es_precio_igv) {
        this.es_precio_igv = es_precio_igv;
    }

    public String getCodigo_entidad() {
        return codigo_entidad;
    }

    public void setCodigo_entidad(String codigo_entidad) {
        this.codigo_entidad = codigo_entidad;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(String tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public String getNumero_documento_id() {
        return numero_documento_id;
    }

    public void setNumero_documento_id(String numero_documento_id) {
        this.numero_documento_id = numero_documento_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo_ubigeo() {
        return codigo_ubigeo;
    }

    public void setCodigo_ubigeo(String codigo_ubigeo) {
        this.codigo_ubigeo = codigo_ubigeo;
    }

    public String getDescripcion_ubigeo() {
        return descripcion_ubigeo;
    }

    public void setDescripcion_ubigeo(String descripcion_ubigeo) {
        this.descripcion_ubigeo = descripcion_ubigeo;
    }

    public String getCodigo_pagador() {
        return codigo_pagador;
    }

    public void setCodigo_pagador(String codigo_pagador) {
        this.codigo_pagador = codigo_pagador;
    }

    public String getNombre_pagador() {
        return nombre_pagador;
    }

    public void setNombre_pagador(String nombre_pagador) {
        this.nombre_pagador = nombre_pagador;
    }

    public String getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEs_domiciliado() {
        return es_domiciliado;
    }

    public void setEs_domiciliado(String es_domiciliado) {
        this.es_domiciliado = es_domiciliado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getCodigo_transportista() {
        return codigo_transportista;
    }

    public void setCodigo_transportista(String codigo_transportista) {
        this.codigo_transportista = codigo_transportista;
    }

    public String getNombre_transportista() {
        return nombre_transportista;
    }

    public void setNombre_transportista(String nombre_transportista) {
        this.nombre_transportista = nombre_transportista;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public String getRazon_social_trans() {
        return razon_social_trans;
    }

    public void setRazon_social_trans(String razon_social_trans) {
        this.razon_social_trans = razon_social_trans;
    }

    public String getRuc_trans() {
        return ruc_trans;
    }

    public void setRuc_trans(String ruc_trans) {
        this.ruc_trans = ruc_trans;
    }

    public String getCodigo_vehiculo() {
        return codigo_vehiculo;
    }

    public void setCodigo_vehiculo(String codigo_vehiculo) {
        this.codigo_vehiculo = codigo_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumero_civ() {
        return numero_civ;
    }

    public void setNumero_civ(String numero_civ) {
        this.numero_civ = numero_civ;
    }

    public String getCodigo_vehiculo_2() {
        return codigo_vehiculo_2;
    }

    public void setCodigo_vehiculo_2(String codigo_vehiculo_2) {
        this.codigo_vehiculo_2 = codigo_vehiculo_2;
    }

    public String getMarca_2() {
        return marca_2;
    }

    public void setMarca_2(String marca_2) {
        this.marca_2 = marca_2;
    }

    public String getNumero_civ_2() {
        return numero_civ_2;
    }

    public void setNumero_civ_2(String numero_civ_2) {
        this.numero_civ_2 = numero_civ_2;
    }

    public String getCodigo_direccion_pl() {
        return codigo_direccion_pl;
    }

    public void setCodigo_direccion_pl(String codigo_direccion_pl) {
        this.codigo_direccion_pl = codigo_direccion_pl;
    }

    public String getNombre_direccion_pl() {
        return nombre_direccion_pl;
    }

    public void setNombre_direccion_pl(String nombre_direccion_pl) {
        this.nombre_direccion_pl = nombre_direccion_pl;
    }

    public String getPunto_llegada() {
        return punto_llegada;
    }

    public void setPunto_llegada(String punto_llegada) {
        this.punto_llegada = punto_llegada;
    }

    public String getCodigo_ubigeo_pl() {
        return codigo_ubigeo_pl;
    }

    public void setCodigo_ubigeo_pl(String codigo_ubigeo_pl) {
        this.codigo_ubigeo_pl = codigo_ubigeo_pl;
    }

    public String getDescripcion_ubigeo_pl() {
        return descripcion_ubigeo_pl;
    }

    public void setDescripcion_ubigeo_pl(String descripcion_ubigeo_pl) {
        this.descripcion_ubigeo_pl = descripcion_ubigeo_pl;
    }

    public int getDias_credito() {
        return dias_credito;
    }

    public void setDias_credito(int dias_credito) {
        this.dias_credito = dias_credito;
    }

    public double getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(double tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public double getPorcentaje_detraccion() {
        return porcentaje_detraccion;
    }

    public void setPorcentaje_detraccion(double porcentaje_detraccion) {
        this.porcentaje_detraccion = porcentaje_detraccion;
    }

    public double getInafecto() {
        return inafecto;
    }

    public void setInafecto(double inafecto) {
        this.inafecto = inafecto;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(double percepcion) {
        this.percepcion = percepcion;
    }

    public double getTotal_documento() {
        return total_documento;
    }

    public void setTotal_documento(double total_documento) {
        this.total_documento = total_documento;
    }

    public double getExonerado() {
        return exonerado;
    }

    public void setExonerado(double exonerado) {
        this.exonerado = exonerado;
    }

    public double getImporte_detraccion() {
        return importe_detraccion;
    }

    public void setImporte_detraccion(double importe_detraccion) {
        this.importe_detraccion = importe_detraccion;
    }

}
