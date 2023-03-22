package com.haydikodlayalim.service;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entities.Adres;
import com.haydikodlayalim.entities.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import com.haydikodlayalim.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiManager implements KisiService{
    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;



    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {


        final Kisi kisi=new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisiDb=kisiRepository.save(kisi);
        List<Adres> list=new ArrayList<>();
        kisiDto.getAdresleri().forEach(item->{
            Adres adres=new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            list.add(adres);

        });
        adresRepository.saveAll(list);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }



    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler=kisiRepository.findAll();
        List<KisiDto> kisiDtos=new ArrayList<>();
        kisiler.forEach(kisi -> {
            KisiDto kisiDto=new KisiDto();
            kisiDto.setId(kisi.getId());
            kisiDto.setAdi(kisi.getAdi());
            kisiDto.setSoyadi(kisi.getSoyadi());
            kisiDto.setAdresleri(kisi.getAdresleri().stream().map(Adres::getAdres)
                    .collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });

        return kisiDtos;
    }

}
