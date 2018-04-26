package com.login.training;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    private TrainingRepository trainingRepository;

    public TrainingService (TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    Training addTraining (Training training) {
        return trainingRepository.save(training);
    }

    List<Training> getAllTrainings() {
        return trainingRepository.findAllByOrderByDateDesc();
    }

    List<Training> getAllUserTrainings(int id) { return trainingRepository.findByCreatorOrderByDateDesc(id); }

    public Long deleteTrainingById(long id) {
        return trainingRepository.deleteById(id);
    }

    Training getTrainingById(int trainingId) {
        return trainingRepository.findOne(trainingId);
    }

    List<Training> filterTraining (TrainingHelper trainingHelper){
        return ((Collection<Training>) trainingRepository.findAllByOrderByDateDesc())
                .stream()
                .filter(training -> typeMatch(training, trainingHelper))
                .filter(training -> dateMatch(training, trainingHelper))
                .collect(Collectors.toList());
    }

    public boolean typeMatch(Training training, TrainingHelper trainingHelper){
        if (trainingHelper.getType() == null || trainingHelper.getType().equals("")){
            return true;
        } else {
            return training.getType().toLowerCase().equals(trainingHelper.getType().toLowerCase());
        }
    }

    public boolean dateMatch(Training training, TrainingHelper trainingHelper){
        if (trainingHelper.getDate() == null || trainingHelper.getDate().equals("")){
            return true;
        } else {
            return training.getDate().toLowerCase().equals(trainingHelper.getDate().toLowerCase());
        }
    }
}
