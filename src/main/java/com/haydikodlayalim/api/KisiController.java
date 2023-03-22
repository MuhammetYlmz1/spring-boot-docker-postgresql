package com.haydikodlayalim.api;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.service.KisiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kisi")
@Api(value = "Kisi Api documantation")
public class KisiController{
    private KisiService service;

    @Autowired
    public KisiController(KisiService service){
        this.service = service;
    }

    @PostMapping("/save")
  //  @ApiOperation(value = "Yeni Kisi ekleme metodu")
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(service.save(kisiDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<KisiDto>> tumunuListele(){
        return ResponseEntity.ok(service.getAll());
    }


}
