package com.verinite.library.service;


import com.verinite.library.entity.Library;
import com.verinite.library.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private final LibraryRepo libraryRepo;

    public LibraryServiceImpl(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    @Override
    public List<Library> getAllLibrary() {
        List<Library> library = new ArrayList<>();
        libraryRepo.findAll().forEach(library1 -> library.add(library1));
        return library;
    }

    @Override
    public Library getLibraryByid(int id) {
        return libraryRepo.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Library library) {
       libraryRepo.save(library);
    }

    @Override
    public void delete(int id) {
       libraryRepo.deleteById(id);
    }

    @Override
    public void update(Library library, int libid) {
      libraryRepo.save(library);
    }




}





