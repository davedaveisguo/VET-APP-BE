package com.controller;


import com.enums.AnimalStatus;
import com.enums.RequestStatus;
import com.model.*;
import com.repository.AnimalDao;
import com.repository.RequestDao;
import com.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestDao requestRepository;


    @Autowired
    private UserDao userRepository;


    @Autowired
    private AnimalDao animalRepository;





    @RequestMapping(value = "/getallrequests", method = RequestMethod.GET)
    public ResponseTemplate fetchAllRequest(@RequestParam(value = "userid") Long userId, HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();

        List<Request> requests = userRepository.findById(userId).get().getRequests();

        ret.setData(requests);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("find all req succ");

        return ret;
    }


    @RequestMapping(value = "/getallrequestsForAdmin", method = RequestMethod.GET)
    public ResponseTemplate fetchAllRequestForAdmin(HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();

        Iterable<Request> requests = requestRepository.findAll();

        ret.setData(requests);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("find all req for admin succ");

        return ret;
    }


    @RequestMapping(value = "/updateRequestById", method = RequestMethod.GET)
    public ResponseTemplate updateRequest(@RequestParam(value = "reqId") int id, @RequestParam(value = "status") String status, @RequestParam(value = "type") String type, HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();
        Request requestfromdb = requestRepository.findById(id).get();

        if(type.equals(ERole.ROLE_ADMIN.toString())){
            requestfromdb.setAdminstatus(RequestStatus.valueOf(status));
        }else if(type.equals(ERole.ROLE_ANIMALHTTECH.toString())) {
            requestfromdb.setTechstatus(RequestStatus.valueOf(status));
        }

        int animalId = requestfromdb.getAnimal().getId();
        // get animal repo
        Animal animalFromDb = animalRepository.findById(animalId).get();
        if(requestfromdb.getAdminstatus().equals(RequestStatus.APPROVED) && requestfromdb.getTechstatus().equals(RequestStatus.APPROVED))
        {
            animalFromDb.setStatus(AnimalStatus.Unavailable);
        }else if(requestfromdb.getAdminstatus().equals(RequestStatus.DECLINED) && requestfromdb.getTechstatus().equals(RequestStatus.DECLINED))
        {
            animalFromDb.setStatus(AnimalStatus.Available);
        }

        animalRepository.save(animalFromDb);
        requestRepository.save(requestfromdb);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("update request succ");

        return ret;
    }



    @RequestMapping(value = "/deleteRequest", method = RequestMethod.DELETE)
    public ResponseTemplate deleteRequest(@RequestParam("id") int id, HttpServletRequest request) {
        ResponseTemplate ret = new ResponseTemplate();
        if(requestRepository.existsById(id)){
            // if id exists user can be deleted
            requestRepository.deleteById(id);
            ret.setCode(HttpStatus.OK.value());
            ret.setMessage("delete req succ");
        }else{
            ret.setCode(HttpStatus.BAD_REQUEST.value());
            ret.setMessage("req does not exist cannot be deleted");
        }
        return ret;
    }


}
