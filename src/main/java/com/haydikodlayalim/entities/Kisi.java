package com.haydikodlayalim.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="kisi")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kisi{

    @Id
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_kisi",allocationSize = 1)
    private Long id;

    @Column(name="adi",length = 100)
    private String adi;

    @Column(name="soyadi",length = 100)
    private String soyadi;


    @OneToMany//birden fazla adrese gidebildiği için onetomany yaptık
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresleri;


}
