package com.testbeackenddeveloper.fikrizulfikarkusmana.controller;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.MataPelajaran;
import com.testbeackenddeveloper.fikrizulfikarkusmana.service.MataPelajaranService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mata-pelajaran")
@Api(value = "Mata Pelajaran Management System", tags = "Mata Pelajaran Management")
public class MataPelajaranController {

    @Autowired
    private MataPelajaranService mataPelajaranService;

    @ApiOperation(value = "View a list of all mata pelajaran", response = List.class)
    @GetMapping
    public List<MataPelajaran> getAllMataPelajaran() {
        return mataPelajaranService.getAllMataPelajaran();
    }

    @ApiOperation(value = "Get mata pelajaran by ID", response = MataPelajaran.class)
    @GetMapping("/{id}")
    public MataPelajaran getMataPelajaranById(@PathVariable int id) {
        return mataPelajaranService.getMataPelajaranById(id);
    }

    @ApiOperation(value = "Create a new mata pelajaran", response = MataPelajaran.class)
    @PostMapping
    public MataPelajaran createMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        return mataPelajaranService.saveMataPelajaran(mataPelajaran);
    }

    @ApiOperation(value = "Delete a mata pelajaran")
    @DeleteMapping("/{id}")
    public void deleteMataPelajaran(@PathVariable int id) {
        mataPelajaranService.deleteMataPelajaran(id);
    }
}
