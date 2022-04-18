package br.com.centouro.centouro.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductsPostRequestBody {


    private String name;

    private String descr;


    private Long storage;


    private Double unitPrice;



}
