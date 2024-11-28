package com.bookmark_manager.service;

import com.bookmark_manager.dto.BookmarkDto;
import com.bookmark_manager.entity.Bookmark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookmarkService {
  List<Bookmark> fetchAllBookmarks();

  Bookmark fetchBookmarkById(Long bookmarkId);

  Bookmark createBookmark(BookmarkDto bookmarkDto);

  Bookmark updateBookmark(BookmarkDto bookmarkDto, Long bookmarkId);

  Bookmark addBookmarkToFolder(Long bookmarkId, Long folderId);

  void deleteBookmarkById(Long bookmarkId);

}
