package com.testbeackenddeveloper.fikrizulfikarkusmana.controller;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.Penilaian;
import com.testbeackenddeveloper.fikrizulfikarkusmana.service.PenilaianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/penilaian")
@Api(value = "Penilaian Management System", tags = "Penilaian Management")
public class PenilaianController {

    @Autowired
    private PenilaianService penilaianService;

    @ApiOperation(value = "View a list of all penilaian", response = List.class)
    @GetMapping
    public List<Penilaian> getAllPenilaian() {
        return penilaianService.getAllPenilaian();
    }

    @ApiOperation(value = "Get penilaian by ID", response = Penilaian.class)
    @GetMapping("/{id}")
    public Penilaian getPenilaianById(@PathVariable Long id) {
        return penilaianService.getPenilaianById(id);
    }

    @ApiOperation(value = "Create a new penilaian", response = Penilaian.class)
    @PostMapping
    public Penilaian createPenilaian(@RequestBody Penilaian penilaian) {
        return penilaianService.savePenilaian(penilaian);
    }

    @ApiOperation(value = "Delete a penilaian")
    @DeleteMapping("/{id}")
    public void deletePenilaian(@PathVariable Long id) {
        penilaianService.deletePenilaian(id);
    }
}
