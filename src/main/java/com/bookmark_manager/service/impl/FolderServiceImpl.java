package com.bookmark_manager.service.impl;

import com.bookmark_manager.dto.FolderDto;
import com.bookmark_manager.entity.Folder;
import com.bookmark_manager.mapper.FolderMapper;
import com.bookmark_manager.repository.FolderRepository;
import com.bookmark_manager.service.FolderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

  @Autowired
  private FolderRepository folderRepository;

  @Autowired
  private FolderMapper folderMapper;

  @Override
  public List<Folder> fetchAllFolders() {
    return folderRepository.findAll();
  }

  @Override
  public Folder fetchFolderById(Long folderId) {
    return folderRepository.findById(folderId).orElseThrow(() -> new EntityNotFoundException("Folder not found with id: " + folderId));
  }

  @Override
  public Folder createFolder(FolderDto folderDto) {
    return folderRepository.save(folderMapper.toEntity(folderDto));
  }

  @Override
  public Folder updateFolder(FolderDto folderDto, Long folderId) {
    Folder folder = this.fetchFolderById(folderId);
    folderMapper.updateFromDto(folderDto, folder);
    return folderRepository.save(folder);
  }

  @Override
  public void deleteFolderById(Long folderId) {
    folderRepository.deleteById(folderId);
  }
}
