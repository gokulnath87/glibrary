package com.verinite.library.controller;

import com.verinite.library.entity.Library;
import com.verinite.library.repository.LibraryRepo;
import com.verinite.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class LibraryController {
    @Autowired
    private final LibraryService libraryService;
    private  final LibraryRepo libraryRepo;

    public LibraryController(LibraryService libraryService, LibraryRepo libraryRepo) {
        this.libraryService = libraryService;
        this.libraryRepo = libraryRepo;
    }

    @GetMapping("/library")
    private List<Library> getAllLibrary(){
        return libraryService.getAllLibrary();
    }
    @GetMapping("/library/{libid}")
    private Library getLibrary(@PathVariable("libid")int libid)
    {
        return libraryService.getLibraryByid(libid);
    }
    @DeleteMapping("/library")
    private void deleteLibrary(@PathVariable("libid")int libid){
        libraryService.delete(libid);
    }
    @PostMapping("/library")
    private int savelibrary(@RequestBody Library library){
        libraryService.saveOrUpdate(library);
        return library.getLibid();
    }
    @PutMapping("/library")
    private Library update(@RequestBody Library library)
    {
        libraryService.saveOrUpdate(library);
        return library;
    }
    @PatchMapping("rental/patch/id/{id}/{bookname}/{issuername}")
    ResponseEntity<Library> patchDetails(@PathVariable int id, @PathVariable String bookname, @PathVariable String issuername)
    {
        try {
            Library li = libraryRepo.findById(id).get();
            li.setBookname(bookname);
            li.setIssuername(issuername);
            return new ResponseEntity<Library>(libraryRepo.save(li), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    }

