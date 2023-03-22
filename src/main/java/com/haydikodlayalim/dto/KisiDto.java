package com.haydikodlayalim.dto;

import com.haydikodlayalim.entities.Adres;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class KisiDto{

    private Long id;
    private String adi;
    private String soyadi;
    private List<String> adresleri;
}
