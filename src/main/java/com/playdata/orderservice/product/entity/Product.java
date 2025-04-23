package com.playdata.orderservice.product.entity;

import com.playdata.orderservice.common.entity.BaseTimeEntity;
import com.playdata.orderservice.product.dto.ProductResDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_product")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int price;
    private int stockQuantity;
    @Setter //이미지 경로만 setter 세팅
    private String imagePath;

    public ProductResDto toProductResDto() {
        ProductResDto resDto = new ProductResDto().builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .imagePath(this.imagePath)
                .build();
        return resDto;
    }
}
