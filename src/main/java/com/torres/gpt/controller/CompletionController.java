package com.torres.gpt.controller;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.torres.gpt.GPT;
import com.torres.gpt.IChatCompletionOptions;
import com.torres.gpt.IMessage;

@RestController
@RequestMapping("/completion")
public class CompletionController {

    @PostMapping()
    public ResponseEntity getCompletions(@RequestBody ArrayList<IMessage> request){

        JSONArray req = new JSONArray(request);

    try {
        GPT gpt = new GPT();
        IChatCompletionOptions options = new IChatCompletionOptions(true, "gpt4",false, 5);
        JSONObject response = gpt.fetchData(req, options);
        req.put(new JSONObject(new IMessage("assistant", response.getString("gpt"))));
        JSONArray messages = new JSONArray(req);  
        return ResponseEntity.ok(messages.toString());
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(new JSONObject().put("error", e.getMessage()));
    }
   }
}

