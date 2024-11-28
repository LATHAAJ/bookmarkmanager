package com.bookmark_manager.service;

import com.bookmark_manager.dto.FolderDto;
import com.bookmark_manager.entity.Folder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FolderService {
  List<Folder> fetchAllFolders();

  Folder fetchFolderById(Long folderId);

  Folder createFolder(FolderDto folderDto);

  Folder updateFolder(FolderDto folderDto, Long folderId);

  void deleteFolderById(Long folderId);
}
