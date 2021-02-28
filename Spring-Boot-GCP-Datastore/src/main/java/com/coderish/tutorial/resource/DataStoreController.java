package com.coderish.tutorial.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataStoreController {

    protected Logger logger = LoggerFactory.getLogger(DataStoreController.class.getName());

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getEntity() {
        logger.info("Inside getEntity##");
        try {
            return new ResponseEntity("No Data", new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
