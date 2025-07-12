//package diary.diarynew.controller;
//
//import diary.diarynew.dto.requestDTO.NoteRequestDTO;
//import diary.diarynew.dto.responseDTO.NoteResponseDTO;
//import diary.diarynew.service.NoteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController                       //controller ekk kiyla define karanne meken
//@RequestMapping(path = "/api/v1/note")
//@CrossOrigin
//public class NoteController {
//    @Autowired
//    NoteService noteService;
//
//    @PostMapping(path = "/savenote")
//    public String saveNote(@RequestBody NoteRequestDTO noteRequestDTO) {
//               noteService.saveNote(noteRequestDTO);
//                 return "success";
//
//    }
//
//
//    @GetMapping(path = "/get=all-notes")
//    public List<NoteResponseDTO> getAllNotes() {
//        List<NoteResponseDTO> allNotes =noteService.getAllNotes();
//        return allNotes;
//    }
//
//
////    @GetMapping(path = "/get-by-id",   params ="id")
////    public NoteResponseDTO getNoteById(@RequestParam(value = "id") int noteId) {
////           NoteResponseDTO noteResponseDTO=noteService.getNoteById(noteId);
////           return noteResponseDTO;
////    }
//
//    @GetMapping(path = "/get-by-id/{id}")
//    public NoteResponseDTO getNoteById(@PathVariable(value = "id") int noteId) {
//           NoteResponseDTO noteResponseDTO=noteService.getNoteById(noteId);
//           return noteResponseDTO;
//    }
//
//
//   @PutMapping(path = "/update/{id}")
//    public String updateNote(@RequestBody NoteRequestDTO noteRequestDTO, @PathVariable(value = "id") int noteId) {
//        String update=noteService.updateNote(noteId,noteRequestDTO);
//        return update;
//   }
//
//
//   @DeleteMapping(path = "/delete/{id}")
//    public String deleteNote(@PathVariable(value = "id") int noteId) {
//            String delete=noteService.deleteNote(noteId);
//            return delete;
//   }
//
//
//
//
//}
package diary.diarynew.controller;

import diary.diarynew.dto.requestDTO.NoteRequestDTO;
import diary.diarynew.dto.responseDTO.NoteResponseDTO;
import diary.diarynew.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/note")
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping(path = "/savenote")
    public String saveNote(@RequestBody NoteRequestDTO noteRequestDTO) {
        return noteService.saveNote(noteRequestDTO);
    }

    @GetMapping(path = "/get-all-notes")
    public List<NoteResponseDTO> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(path = "/get-by-id/{id}")
    public NoteResponseDTO getNoteById(@PathVariable(value = "id") int noteId) {
        return noteService.getNoteById(noteId);
    }

    @PutMapping(path = "/update/{id}")
    public String updateNote(@RequestBody NoteRequestDTO noteRequestDTO, @PathVariable(value = "id") int noteId) {
        return noteService.updateNote(noteId, noteRequestDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteNote(@PathVariable(value = "id") int noteId) {
        return noteService.deleteNote(noteId);
    }
}
