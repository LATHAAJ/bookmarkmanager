package com.bookmark_manager.controller;

import com.bookmark_manager.dto.BookmarkDto;
import com.bookmark_manager.entity.Bookmark;
import com.bookmark_manager.service.BookmarkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookmarks")
public class BookmarkController {
  @Autowired
  private BookmarkService bookmarkService;

  @PostMapping
  public ResponseEntity<Bookmark> createBookmark(@Valid @RequestBody BookmarkDto bookmarkDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookmarkService.createBookmark(bookmarkDto));
  }

  @PutMapping("/{bookmarkId}")
  public ResponseEntity<Bookmark> updateBookmark(@PathVariable Long bookmarkId, @Valid @RequestBody BookmarkDto bookmarkDto) {
    return ResponseEntity.ok(bookmarkService.updateBookmark(bookmarkDto, bookmarkId));
  }

  @DeleteMapping("/{bookmarkId}")
  public ResponseEntity<Void> deleteBookmark(@PathVariable Long bookmarkId) {
    bookmarkService.deleteBookmarkById(bookmarkId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<Bookmark>> getAllBookMarks() {
    return ResponseEntity.ok(bookmarkService.fetchAllBookmarks());
  }

  @PostMapping("/{bookmarkId}/folders/{folderId}")
  public ResponseEntity<Bookmark> addBookmarkToFolder(@PathVariable Long bookmarkId, @PathVariable Long folderId) {
    return ResponseEntity.ok(bookmarkService.addBookmarkToFolder(bookmarkId, folderId));
  }

}
