package com.playdata.orderservice.product.controller;

import com.playdata.orderservice.common.dto.CommonResDto;
import com.playdata.orderservice.product.dto.ProductResDto;
import com.playdata.orderservice.product.dto.ProductSaveReqDto;
import com.playdata.orderservice.product.entity.Product;
import com.playdata.orderservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;


    //상품 등록 요청
    @PreAuthorize(("hasRole('ADMIN')"))
    @PostMapping("/create")

    public ResponseEntity<?> createProduct( ProductSaveReqDto dto) {

         /*
        상품 등록 요청은 여러 데이터와 함께 이미지가 전달될 것입니다.
        1. JS의 formData 객체를 통해 모든 데이터를 전달 (JSON 형태가 아니라, multipart/form-data 형식)
        2. JSON 형태로 전달 (이미지를 Base64 인코딩을 통해 문자열로 변환해서 전달)

        formData로 넘어오는 이미지 파일은 MultipartFile 형태로 받아주시면 됩니다.
        MultipartFile은 이미지의 정보(크기, 원본이름...), 지정된 경로로 파일 전송 기능을 제공합니다.
         */

        log.info("dto: {}", dto);
        Product product = productService.productCreate(dto);
        CommonResDto resDto = new CommonResDto(HttpStatus.CREATED, "상품등록성공", product.getId());
        return new  ResponseEntity<>(resDto, HttpStatus.CREATED);
    }

    // 요청방식: GET, 요청 URL: /product/list
    // 페이징이 필요합니다. 리턴은 ProductResDto 형태로 리턴됩니다.
    // ProductResDto(id, name, category, price, stockQuantity, imagePath)
    @GetMapping("/list")
    // 페이지 번호를 number로 주시면 안됨! page로 전달해 주셔야 합니다.
    // 사용자가 선택한 페이지 번호 -1을 클라이언트 단에서 해서 전달해 주셔야 합니다.
    public ResponseEntity<?> getAllProducts(Pageable pageable) {
        List<ProductResDto> resDtos = productService.productSelect(pageable);
        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "리스트 조회 성공", resDtos);
        return new  ResponseEntity<>(resDto, HttpStatus.OK);
    }
}
