package JSONs;

import CourtObjects.IJudgment;
import CourtObjects.Judgment;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JudgmentCreator {

    public List<Judgment> createJudgment(String jsons){
    //    ArrayList<Judgment> judgments= new ArrayList<Judgment>();
        Gson gson = new Gson();
        Type jsonListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(jsons, jsonListType);
    }

    public List<Judgment> createAllJudgmentList(List<String> stringJudgementList){
        List<Judgment> judgments = new ArrayList<>();
        for(String json : stringJudgementList){
            List<Judgment> listToAdd = createJudgment(json);
            for(Judgment j : listToAdd){
                judgments.add(j);
            }
        }
        return judgments;
    }

    public List<IJudgment> convertToInterface(List<Judgment> judgments){
        List<IJudgment> iJudgments = new LinkedList<>();
        for (Judgment judgment : judgments){
            iJudgments.add(judgment);
        }
        return iJudgments;
    }


}
