package com.dinamsky.Spring.OAuth.repositories;

import com.dinamsky.Spring.OAuth.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByUserId(Long userId);
}
