package com.bookmark_manager.impl;

import com.bookmark_manager.entity.Folder;
import com.bookmark_manager.repository.FolderRepository;
import com.bookmark_manager.service.impl.FolderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class FolderServiceImplTest {

  @Test
  public void fetchAll_folders_returns_folderList() {
    List<Folder> expectedFolders;
    expectedFolders = Arrays.asList(
            Folder.builder().id(1L).name("Folder1").build(),
            Folder.builder().id(2L).name("Folder2").build()
    );
    FolderRepository folderRepository = mock(FolderRepository.class);
    when(folderRepository.findAll()).thenReturn(expectedFolders);
    FolderServiceImpl folderService = new FolderServiceImpl();
    ReflectionTestUtils.setField(folderService, "folderRepository", folderRepository);
    List<Folder> actualFolders = folderService.fetchAllFolders();
    assertEquals(expectedFolders, actualFolders);
  }
  @Test
  public void fetch_folderById_returns_folder_when_valid_id() {
    Long folderId = 1L;
    Folder expectedFolder = Folder.builder()
            .id(folderId)
            .name("Test Folder")
            .build();

    FolderRepository folderRepository = mock(FolderRepository.class);
    when(folderRepository.findById(folderId)).thenReturn(Optional.of(expectedFolder));
    FolderServiceImpl folderService = new FolderServiceImpl();
    ReflectionTestUtils.setField(folderService, "folderRepository", folderRepository);
    Folder actualFolder = folderService.fetchFolderById(folderId);
    assertNotNull(actualFolder);
    assertEquals(expectedFolder.getId(), actualFolder.getId());
    assertEquals(expectedFolder.getName(), actualFolder.getName());
  }

  @Test
  public void delete_existing_folder() {
    Long folderId = 1L;
    Folder folder = new Folder();
    folder.setId(folderId);
    FolderServiceImpl folderService = new FolderServiceImpl();
    FolderRepository folderRepository = mock(FolderRepository.class);
    ReflectionTestUtils.setField(folderService, "folderRepository", folderRepository);
    when(folderRepository.findById(folderId)).thenReturn(Optional.of(folder));
    doNothing().when(folderRepository).delete(folder);
    folderService.deleteFolderById(folderId);
    verify(folderRepository).findById(folderId);
    verify(folderRepository).delete(folder);
  }

}
