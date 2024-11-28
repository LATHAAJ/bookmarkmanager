package com.bookmark_manager.dto;

import com.bookmark_manager.entity.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FolderDto {
  private Long id;
  private String name;
  private List<Bookmark> bookmarks;
}
