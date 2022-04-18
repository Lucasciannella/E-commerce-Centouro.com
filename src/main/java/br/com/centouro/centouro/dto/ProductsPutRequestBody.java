package br.com.centouro.centouro.dto;


import lombok.Data;

@Data
public class ProductsPutRequestBody {

    private Long id;

    private String name;

    private String descr;

    private Long  storage;

    private Double unitPrice;


}
