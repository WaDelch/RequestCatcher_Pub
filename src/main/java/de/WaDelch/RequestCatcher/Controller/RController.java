package de.WaDelch.RequestCatcher.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.WaDelch.RequestCatcher.Model.Request;
import de.WaDelch.RequestCatcher.Repository.ReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RController {

    @Autowired
    private ReqRepository reqRepos;


    @PostMapping("/getReq")
    public ResponseEntity saveRequest(@RequestBody String data) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> reqData = null;
            reqData = mapper.readValue(data, new TypeReference<HashMap<String, Object>>() {});
            Request req = new Request(reqData);
            reqRepos.save(req);
            System.out.println("HTTPRequest containing Webhook with id " + req.id + " was successfully caught.");
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (final Exception e) {
            System.out.println("Failed to catch HTTPRequest.");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showReq/{id}")
    public Request loadWH(@PathVariable Integer id) {
        return reqRepos.findById((long) id);
    }
}