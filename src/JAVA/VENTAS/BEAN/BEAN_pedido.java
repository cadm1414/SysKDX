package JAVA.VENTAS.BEAN;

public class BEAN_pedido {

    String codigo_operacion, codigo_sucursal, periodo, mes, codigo_documento, serie_documento, numero_documento, fecha_emision, codigo_documento_ref,
            codigo_moneda, afecto_igv, codigo_igv, codigo_grupo, status, es_facturado, es_precio_igv, codigo_entidad, razon_social, tipo_documento_id,
            numero_documento_id, direccion, codigo_ubigeo, descripcion_ubigeo, codigo_pagador, nombre_pagador, codigo_vendedor, nombre_vendedor, forma_pago,
            observacion, es_domiciliado, fecha_registro;
    int dias_credito;

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    double tipo_cambio, porcentaje_detraccion, inafecto, base, igv, total, percepcion, total_documento, exonerado,
            importe_detraccion, inafecto_mn, base_mn, igv_mn, total_mn, percepcion_mn, total_documento_mn, exonerado_mn, importe_detraccion_mn;

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

    public double getInafecto_mn() {
        return inafecto_mn;
    }

    public void setInafecto_mn(double inafecto_mn) {
        this.inafecto_mn = inafecto_mn;
    }

    public double getBase_mn() {
        return base_mn;
    }

    public void setBase_mn(double base_mn) {
        this.base_mn = base_mn;
    }

    public double getIgv_mn() {
        return igv_mn;
    }

    public void setIgv_mn(double igv_mn) {
        this.igv_mn = igv_mn;
    }

    public double getTotal_mn() {
        return total_mn;
    }

    public void setTotal_mn(double total_mn) {
        this.total_mn = total_mn;
    }

    public double getPercepcion_mn() {
        return percepcion_mn;
    }

    public void setPercepcion_mn(double percepcion_mn) {
        this.percepcion_mn = percepcion_mn;
    }

    public double getTotal_documento_mn() {
        return total_documento_mn;
    }

    public void setTotal_documento_mn(double total_documento_mn) {
        this.total_documento_mn = total_documento_mn;
    }

    public double getExonerado_mn() {
        return exonerado_mn;
    }

    public void setExonerado_mn(double exonerado_mn) {
        this.exonerado_mn = exonerado_mn;
    }

    public double getImporte_detraccion_mn() {
        return importe_detraccion_mn;
    }

    public void setImporte_detraccion_mn(double importe_detraccion_mn) {
        this.importe_detraccion_mn = importe_detraccion_mn;
    }

}
