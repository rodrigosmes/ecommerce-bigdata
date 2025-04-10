package com.ibmec.mall.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TransacaoResponse {
    private String status;
    private UUID codigoAutorizacao;
    private LocalDateTime dtTransacao;
    private String message;
}