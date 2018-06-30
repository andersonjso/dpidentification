package br.com.opus.repository;

import br.com.opus.DTO.SymptomDTO;
import br.com.opus.MongoUtils;
import br.com.opus.model.Document;
import br.com.opus.model.Symptom;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.jongo.Aggregate;
import org.jongo.ResultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by andersonjso on 6/29/18.
 */
public class SymptomRepository {

    public List<Symptom> listSymptoms() {

        List<Symptom> symptoms = StreamSupport.stream(MongoUtils.symptoms()
                .find().as(Symptom.class).spliterator(), false)
                .collect(Collectors.toList());

        return symptoms;
    }

    public List<SymptomDTO> groupSymptomsByType(){
        Aggregate.ResultsIterator<SymptomDTO> symptomDTOResultsIterator = MongoUtils.symptoms()
                .aggregate("{$group: {'_id': '$type', 'symptoms': {$push: {_id: '$_id', type: '$type', value: '$value', description: '$description'}}}}")
                .and("{$project: {_id: 0, type: '$_id', symptoms: '$symptoms'}}").as(SymptomDTO.class);

        List<SymptomDTO> symptomsDTOs = new ArrayList<>();

        if (symptomDTOResultsIterator.hasNext()){
            symptomsDTOs = StreamSupport.stream(symptomDTOResultsIterator.spliterator(), false).collect(Collectors.toList());
        }

        return symptomsDTOs;
    }

    /*
    ﻿db.getCollection('symptoms').aggregate([{$group: {_id: "$type", symptoms: {$push: {_id: "$_id", type: '$type', value: '$value', description: '$description'}}}},
{$project: {_id: 0, type: "$_id", symptoms: "$symptoms"}}])
     */


    /*
        public Schedule groupDevicesByClient(LocalDate refDate) {
        DateTime startDate = refDate.toDateTimeAtStartOfDay();
        DateTime endDate = startDate.withTime(23, 59, 59, 999);
        Aggregate.ResultsIterator<ScheduleClientDTO> results = MeyerCollections.devices()
                .aggregate("{$match: {'nextReading.refDate': {$gte: #, $lte: #}}}", startDate.toDate(), endDate.toDate())
                .and("{$group: {'_id': {client: '$link.client', model: '$model'}, " +
                        "devices: {$push: {serialCode: '$serialCode', address: '$address', complement: '$complement'}}}}")
                .and("{$group: {'_id': {client: '$_id.client'}, " +
                        "models: {$push: {name: '$_id.model.name', devices: '$devices'}}}}")
                .and("{$project: {_id: '$_id.client._id', name: '$_id.client.fullName', code: '$_id.client.code', models: '$models'}}")
                .as(ScheduleClientDTO.class);

        if (results.hasNext()) {
            List<ScheduleClientDTO> collect = StreamSupport
                    .stream(results.spliterator(), false).collect(Collectors.toList());
            return new Schedule(refDate.toDate(), collect);
        } else {
            return new Schedule(refDate.toDate(), Collections.emptyList());
        }
    }
     */
}
