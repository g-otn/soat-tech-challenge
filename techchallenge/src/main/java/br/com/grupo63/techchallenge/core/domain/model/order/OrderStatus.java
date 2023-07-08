package br.com.grupo63.techchallenge.core.domain.model.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {
    RECEIVED("Recebido"), PREPARING("Em preparação"), READY("Pronto"), FINISHED("Finalizado");

    private final String name;

}
