package br.com.grupo63.techchallenge.core.application.usecase.dto;

import br.com.grupo63.techchallenge.core.domain.model.client.Client;
import br.com.grupo63.techchallenge.core.domain.model.order.OrderItem;
import br.com.grupo63.techchallenge.core.domain.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDTO extends AbstractUseCaseDomainDTO<OrderItem> {

    private Long quantity;
    private Double price;
    private Long productId;

    public static OrderItemDTO toDto(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setPrice(orderItem.getPrice());
        orderItemDTO.setProductId(orderItem.getProduct().getId());

        return orderItemDTO;
    }

    public void fillDomain(OrderItem orderItem) {
        orderItem.setQuantity(quantity);
        orderItem.setPrice(price);
        if (orderItem.getProduct() == null)
            orderItem.setProduct(new Product(productId));
    }
}
