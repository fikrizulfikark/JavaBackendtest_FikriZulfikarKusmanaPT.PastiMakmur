package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.MataPelajaran;
import com.testbeackenddeveloper.fikrizulfikarkusmana.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MataPelajaranService {

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<MataPelajaran> getAllMataPelajaran() {
        return mataPelajaranRepository.findAll();
    }

    public MataPelajaran getMataPelajaranById(int id) {
        return mataPelajaranRepository.findById(id).orElse(null);
    }

    public MataPelajaran saveMataPelajaran(MataPelajaran mataPelajaran) {
        MataPelajaran savedMataPelajaran = mataPelajaranRepository.save(mataPelajaran);
        kafkaProducerService.sendMataPelajaranMessage("Created MataPelajaran with ID: " + savedMataPelajaran.getId() + " and name: " + savedMataPelajaran.getName());
        return savedMataPelajaran;
    }

    public void deleteMataPelajaran(int id) {
        mataPelajaranRepository.deleteById(id);
    }
}
