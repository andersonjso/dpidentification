package br.com.opus.repository;

import br.com.opus.MongoUtils;
import br.com.opus.model.Snippet;
import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.bson.types.ObjectId;
import org.jooby.Upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by andersonjso on 6/29/18.
 */
public class SnippetRepository {
    private GridFS gfsSnippet = new GridFS(MongoUtils.databaseTest, "snippets");

    public String uploadFile(Upload file) {

        try {
            InputStream inputStream = new FileInputStream(file.file());

            GridFSInputFile sourceCode = gfsSnippet.createFile(inputStream);

            sourceCode.save();

            return sourceCode.getId().toString();

        } catch (IOException e) {

        }


        return null;
    }

    public Snippet setMetadata(String id, Snippet snippetData) {
        GridFSDBFile file = gfsSnippet.findOne(new ObjectId(id));

        BasicDBObject meta = new BasicDBObject("username", snippetData.getUserName());

        meta.append("description", snippetData.getDescription());
        meta.append("fileName", snippetData.getFileName());
        meta.append("idSourceFile", snippetData.getIdSourceFile());

        file.setMetaData(meta);

        MongoUtils.snippets().save(snippetData);

        return snippetData;
    }

    public List<Snippet> getSnippetsBySymptom(String value) {
        List<Snippet> snippets = StreamSupport.stream(MongoUtils.snippets().find("{symptom.value: #}", value)
                .as(Snippet.class).spliterator(), false)
                .collect(Collectors.toList());

        return snippets;
    }

    public String retrieveSourceCode(String id) {
        GridFSDBFile file = gfsSnippet.findOne(new ObjectId(id));

        Scanner scanner = new Scanner(file.getInputStream()).useDelimiter("\\A");

        return scanner.hasNext() ? scanner.next() : "";
    }


//
//    public Snippet saveSnippet(){
//
//
//    }


}
