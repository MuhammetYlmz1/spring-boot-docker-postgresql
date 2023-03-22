package com.haydikodlayalim.entities;

import lombok.*;
import org.hibernate.service.spi.InjectService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="kisi_adres")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable{
    
    @Id
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_kisi_adres",allocationSize = 1)
    private Long id;

    @Column(name="adres",length = 255)
    private String adres;

    @Enumerated
    private AdresTip adresTip;
    @Column(name = "aktik_mi")
    private Boolean aktif;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip{
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }

}
