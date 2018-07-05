package br.com.opus.service;

import br.com.opus.model.DesignProblem;
import br.com.opus.model.SetSymptoms;
import br.com.opus.repository.DesignProblemRepository;

import java.util.List;

/**
 * Created by andersonjso on 6/30/18.
 */
public class DesignProblemService {

    private DesignProblemRepository designProblemRepository = new DesignProblemRepository();

    public List<DesignProblem> listDesignProblems(){
        return designProblemRepository.listDesignProblems();
    }

    public DesignProblem updateDPWithSetExamples(String dpname, SetSymptoms setSymptomsList) {
        return designProblemRepository.updateDPWithSetExamples (dpname, setSymptomsList);
    }
}
