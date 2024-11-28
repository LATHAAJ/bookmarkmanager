package com.bookmark_manager.controller;

import com.bookmark_manager.dto.FolderDto;
import com.bookmark_manager.entity.Folder;
import com.bookmark_manager.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/folders")
public class FolderController {
  @Autowired
  private FolderService folderService;

  @PostMapping
  public ResponseEntity<Folder> createFolder(@RequestBody FolderDto folderDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(folderService.createFolder(folderDto));
  }

  @PutMapping("/{folderId}")
  public ResponseEntity<Folder> updateFolder(@PathVariable Long folderId, @RequestBody FolderDto folderDto) {
    return ResponseEntity.ok(folderService.updateFolder(folderDto, folderId));
  }

  @DeleteMapping("/{folderId}")
  public ResponseEntity<Void> deleteFolder(@PathVariable Long folderId) {
    folderService.deleteFolderById(folderId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<Folder>> getAllFolders() {
    return ResponseEntity.ok(folderService.fetchAllFolders());
  }
}
