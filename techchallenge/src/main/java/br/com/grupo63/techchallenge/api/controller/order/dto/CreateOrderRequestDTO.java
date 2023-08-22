package br.com.grupo63.techchallenge.api.controller.order.dto;

import br.com.grupo63.techchallenge.controller.dto.ClientControllerDTO;
import br.com.grupo63.techchallenge.controller.dto.OrderControllerDTO;
import br.com.grupo63.techchallenge.controller.dto.OrderItemControllerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDTO {

    private Long clientId;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Item {
        private Long id;
        private Long quantity;
    }

    private List<Item> items;

    public OrderControllerDTO toDomainDto(Long clientId) {
        OrderControllerDTO orderDTO = new OrderControllerDTO();

        ClientControllerDTO clientDTO = new ClientControllerDTO();
        clientDTO.setId(clientId);
        orderDTO.setClient(clientDTO);

        if (items != null) {
            orderDTO.setItems(items.stream()
                    .map(i -> new OrderItemControllerDTO(i.quantity, null, i.id))
                    .collect(Collectors.toList()));
        }
        return orderDTO;
    }

}
