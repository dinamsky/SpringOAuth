package com.dinamsky.Spring.OAuth.controllers;

import com.dinamsky.Spring.OAuth.entities.Note;
import com.dinamsky.Spring.OAuth.entities.User;
import com.dinamsky.Spring.OAuth.repositories.NoteRepository;
import com.dinamsky.Spring.OAuth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class NoteController
{
    @Autowired
    private NoteRepository noteRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/notes")
    public String notes(Principal principal,Model model)
    {
        User user = (User) userService.loadUserByUsername(principal.getName());
        List<Note> notes = noteRepo.findByUserId(user.getId());
        model.addAttribute("notes", notes);
        model.addAttribute("user",user);

        return "notes";
    }

    @PostMapping("/addnote")
    public String addNote(Principal principal,String title, String note)
    {
        User user = (User) userService.loadUserByUsername(principal.getName());
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setNote(note);
        newNote.setUserId(user.getId());
        noteRepo.save(newNote);

        return "redirect:/notes";
    }
}