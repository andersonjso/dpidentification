package br.com.opus;

import br.com.opus.model.Document;
import br.com.opus.model.SourceFile;
import br.com.opus.model.Symptom;
import br.com.opus.service.MainService;
import com.github.fakemongo.Fongo;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.mongodb.DB;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by andersonjso on 7/3/18.
 */

public class ClassesRepositoryTest extends AbstractRepositoryTest{

    MainService mainServiceMock = mock(MainService.class);

    @Test
    public void shouldListAllClasses() {
        Document class1 = new Document();
        Document class2 = new Document();
        Document class3 = new Document();

        List<Document> classes = new ArrayList<>();
        classes.add(class1);
        classes.add(class2);
        classes.add(class3);

        when(mainServiceMock.listClasses(new ArrayList<>())).thenReturn(classes);

        mainServiceMock.listClasses(new ArrayList<>());

        assertTrue(mainServiceMock.listClasses(new ArrayList<>()).size() == 3);
    }

    @Test
    public void shouldGetClassByName(){

        SourceFile sourceFile = new SourceFile("file", "teste", "myFile");
        Symptom symptomLM = new Symptom("smell", "Long Method");
        Symptom symptomGC = new Symptom("smell", "God Class");

        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(symptomGC);
        symptoms.add(symptomLM);
        Document classDP = new Document(sourceFile, symptoms);

        when(mainServiceMock.getClassDP("myFile")).thenReturn(classDP);

        Document myFile = mainServiceMock.getClassDP("myFile");

        assertTrue(myFile.getSourceFile().getName().equals("myFile"));
        assertFalse(myFile.getSourceFile().getName().equals("myFile2"));


    }
}