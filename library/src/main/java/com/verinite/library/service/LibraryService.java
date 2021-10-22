package com.verinite.library.service;

import com.verinite.library.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LibraryService {
 public List<Library> getAllLibrary();
 public Library getLibraryByid(int id);
 public void saveOrUpdate(Library library);
 public void delete(int id);
 public void update(Library library,int libid);
}


