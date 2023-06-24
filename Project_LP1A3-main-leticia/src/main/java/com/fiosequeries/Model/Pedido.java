package com.fiosequeries.Model;
import com.fiosequeries.enums.SituacaoEnum;
import com.fiosequeries.enums.TipoPagamentoEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Pedido extends Orcamento{

    @Column(name = "dataEntrega")
    private LocalDate dataEntrega;

    @Column(name = "pago")
    private boolean pago = false;

    @Column(name = "dataPagamento")
    private LocalDate dataPagamento;

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao;

    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamento;

    public Pedido() {
    }

    public Long getId(){
        return super.getId();
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


}
