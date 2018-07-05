package br.com.opus;

import br.com.opus.model.Snippet;
import br.com.opus.model.Symptom;
import br.com.opus.service.SnippetService;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by andersonjso on 7/3/18.
 */
//@UsingDataSet (locations = "/br/com/opus/repository/Database.json", loadStrategy= LoadStrategyEnum.CLEAN_INSERT)
public class SnippetRepositoryTest extends AbstractRepositoryTest{

    SnippetService snippetServiceMock = mock(SnippetService.class);

    @Test
    public void shoudlSetMetadataFile(){

        String id = "5b36fa04ae13139dec2f24b0";
        Symptom symptom = new Symptom("smell", "Long Parameter List");
        Snippet snippet = new Snippet("anderson",
                "fileTest",
                "descriptionTest",
                symptom,
                id);

        when(snippetServiceMock.setMetadata(id, snippet)).thenReturn(snippet);

        Snippet snippedRetrieved = snippetServiceMock.setMetadata(id, snippet);

        assertTrue(snippedRetrieved.getUserName().equals("anderson"));
    }

//    @Test
//    public void getSymptomByType(){
//        List<Snippet> snippetsBySymptom = snippetService.getSnippetsBySymptom("Long Method");
//
//        assertTrue(snippetsBySymptom.size() == 1);
//    }
}