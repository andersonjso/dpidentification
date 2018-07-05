package br.com.opus.repository;

import br.com.opus.MongoUtils;
import br.com.opus.model.DesignProblem;
import br.com.opus.model.SetSymptoms;
import com.mongodb.Mongo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by andersonjso on 6/30/18.
 */
public class DesignProblemRepository {

    public List<DesignProblem> listDesignProblems(){
        List<DesignProblem> designProblems = StreamSupport.stream(MongoUtils.designProblems()
                .find().as(DesignProblem.class).spliterator(), false)
                .collect(Collectors.toList());

        return designProblems;

    }

    public DesignProblem updateDPWithSetExamples(String dpname, SetSymptoms setSymptomsList) {
        MongoUtils.designProblems().update("{name: #}", dpname).with("{$push: {setSymptoms: #}}", setSymptomsList);

        DesignProblem designProblem = MongoUtils.designProblems().findOne("{name: #}", dpname).as(DesignProblem.class);

        return designProblem;
    }
}
