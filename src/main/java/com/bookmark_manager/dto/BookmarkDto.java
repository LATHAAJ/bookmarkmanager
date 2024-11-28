package com.bookmark_manager.dto;

import com.bookmark_manager.entity.Folder;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarkDto {
  private Long id;

  @NotBlank(message = "Title is required")
  private String title;

  @NotBlank(message = "URL is required")
  private String url;

  private String description;

  private ZonedDateTime createdAt;

  private Folder folder;
}
