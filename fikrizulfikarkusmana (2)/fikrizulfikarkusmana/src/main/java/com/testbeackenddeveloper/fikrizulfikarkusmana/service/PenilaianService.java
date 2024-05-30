package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.Penilaian;
import com.testbeackenddeveloper.fikrizulfikarkusmana.repository.PenilaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenilaianService {

    @Autowired
    private PenilaianRepository penilaianRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<Penilaian> getAllPenilaian() {
        return penilaianRepository.findAll();
    }

    public Penilaian getPenilaianById(Long id) {
        return penilaianRepository.findById(id).orElse(null);
    }

    public Penilaian savePenilaian(Penilaian penilaian) {
        Penilaian savedPenilaian = penilaianRepository.save(penilaian);
        kafkaProducerService.sendPenilaianMessage("Created Penilaian with ID: " + savedPenilaian.getId() + " for user ID: " + savedPenilaian.getUserId());
        return savedPenilaian;
    }

    public void deletePenilaian(Long id) {
        penilaianRepository.deleteById(id);
    }
}
