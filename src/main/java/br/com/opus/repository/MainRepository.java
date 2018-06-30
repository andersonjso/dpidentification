package br.com.opus.repository;

import br.com.opus.MongoUtils;
import br.com.opus.model.Document;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by andersonjso on 6/27/18.
 */
public class MainRepository {

    public List<Document> listClasses(){
        List<Document> classes = StreamSupport.stream(MongoUtils.classes()
                .find().as(Document.class).spliterator(), false)
                .collect(Collectors.toList());

        return classes;
    }
}


/*
List<Exam> exams = StreamSupport.stream(MongoUtils.exams()
                .find("{readingSession.bignodule.0: {$exists: true}}")
                .skip(QUANTITY * (page -1))
                .limit(QUANTITY).as(Exam.class).spliterator(), false).collect(Collectors.toList());

        long totalExams = MongoUtils.exams()
                .count("{readingSession.bignodule.0: {$exists: true}}");

        long totalPages = (long) (Math.ceil(totalExams / (double) QUANTITY));

        return new ExamQueryResult(exams, totalPages);
 */