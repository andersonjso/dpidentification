package br.com.opus;

import br.com.opus.model.DesignProblem;
import br.com.opus.model.SetSymptoms;
import br.com.opus.model.Symptom;
import br.com.opus.service.DesignProblemService;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andersonjso on 7/3/18.
 */
@UsingDataSet (locations = "/br/com/opus/repository/Database.json")
public class DesignProblemsRepositoryTest extends AbstractRepositoryTest{

    DesignProblemService designProblemService = new DesignProblemService();

    @Test
    public void shouldListAllDesignProblems(){
        Assert.assertTrue(designProblemService.listDesignProblems().size() == 6);
    }

    @Test
    public void shouldUpdateSymptomsExampleWithSet(){

        SetSymptoms setSymptoms = new SetSymptoms("userTe2st");

        Symptom symptom = new Symptom("smell", "Intensive Coupling");

        List<Symptom> symptomList = new ArrayList();
        symptomList.add(symptom);

        setSymptoms.setSymptoms(symptomList);

        DesignProblem designProblem = designProblemService.updateDPWithSetExamples("Componente Sobrecarregado", setSymptoms);

        Assert.assertTrue(designProblem.getSetSymptoms().size() == 0);


    }
}
