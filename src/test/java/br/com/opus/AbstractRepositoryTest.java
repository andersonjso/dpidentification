package br.com.opus;

import com.github.fakemongo.Fongo;
import com.google.inject.Inject;
import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created by andersonjso on 7/3/18.
 */
public class AbstractRepositoryTest {


    @ClassRule
    public static InMemoryMongoDb inMemoryMongoDb = InMemoryMongoDb.InMemoryMongoRuleBuilder
            .newInMemoryMongoDbRule().build();

    @Rule
    public MongoDbRule remoteMongoDbRule = newMongoDbRule().defaultEmbeddedMongoDb("dpidentificationdasd");

    @Inject
    private static MongoClient mongoClient;

}
