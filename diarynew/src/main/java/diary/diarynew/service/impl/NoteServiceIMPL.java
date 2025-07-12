////package diary.diarynew.service.impl;
////
////import diary.diarynew.dto.requestDTO.NoteRequestDTO;
////import diary.diarynew.dto.responseDTO.NoteResponseDTO;
////import diary.diarynew.entity.Note;
////import diary.diarynew.repo.NoteRepo;
////import diary.diarynew.repo.UserRepo;
////import diary.diarynew.service.NoteService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.time.LocalDate;
////import java.util.ArrayList;
////import java.util.List;
////
////@Service
////public class NoteServiceIMPL implements NoteService {
////    @Autowired
////    private NoteRepo noteRepo;
////    @Autowired
////    private UserRepo userRepo;
////    @Override
////    public String saveNote(NoteRequestDTO noteRequestDTO) {
////
////        Note note = new Note(
////                LocalDate.now(),
////              noteRequestDTO.getTopic(),
////              noteRequestDTO.getContent(),
////
////
////
////        );
////
////        noteRepo.save(note);
////        return "success";
////
////
////    }
////
////    @Override
////    public List<NoteResponseDTO> getAllNotes() {
////           List<Note> allNotes = noteRepo.findAll();
////           List<NoteResponseDTO> allNoteResponseDTOList = new ArrayList<>();
////           if(allNotes.size()>0) {
////              for (Note note : allNotes) {
////           NoteResponseDTO noteResponseDTO = new NoteResponseDTO(
////                    note.getNoteId(),
////                    note.getDate(),
////                   note.getTopic(),
////                   note.getContent()
////           );
////                  allNoteResponseDTOList.add(noteResponseDTO);
////              }
////              return allNoteResponseDTOList;
////           }else{
////               throw new RuntimeException("No MakeOrder found");
////
////           }
////
////
////    }
////
////    @Override
////    public NoteResponseDTO getNoteById(int noteId) {
////          if(noteRepo.existsById(noteId)) {
////               Note note=noteRepo.getReferenceById(noteId);
////               NoteResponseDTO noteResponseDTO = new NoteResponseDTO(
////                        note.getNoteId(),
////                       note.getDate(),
////                       note.getTopic(),
////                       note.getContent()
////               );
////               return noteResponseDTO;
////          }else{
////             throw new RuntimeException("No Note found");
////          }
////
////    }
////
////    @Override
////    public String updateNote(int noteId, NoteRequestDTO noteRequestDTO) {
////           if(noteRepo.existsById(noteId)) {
////               Note note=noteRepo.getReferenceById(noteId);
////               note.setDate(LocalDate.now());
////               note.setTopic(noteRequestDTO.getTopic());
////               note.setContent(noteRequestDTO.getContent());
////               noteRepo.save(note);
////               return "success";
////
////           }else{
////               throw new RuntimeException("No Note found");
////           }
////    }
////
////    @Override
////    public String deleteNote(int noteId) {
////          if(noteRepo.existsById(noteId)) {
////              noteRepo.deleteById(noteId);
////              return "success";
////          }else{
////              throw new RuntimeException("No Note found");
////          }
////    }
////
////
////}
//package diary.diarynew.service.impl;
//
//import diary.diarynew.dto.requestDTO.NoteRequestDTO;
//import diary.diarynew.dto.responseDTO.NoteResponseDTO;
//import diary.diarynew.entity.Note;
//import diary.diarynew.entity.User;
//import diary.diarynew.repo.NoteRepo;
//import diary.diarynew.repo.UserRepo;
//import diary.diarynew.service.NoteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class NoteServiceIMPL implements NoteService {
//
//    private final NoteRepo noteRepo;
//    private final UserRepo userRepo;
//
//    @Autowired
//    public NoteServiceIMPL(NoteRepo noteRepo, UserRepo userRepo) {
//        this.noteRepo = noteRepo;
//        this.userRepo = userRepo;
//    }
//
//    // Save note linked to current user
//    @Override
//    public String saveNote(NoteRequestDTO noteRequestDTO) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Note note = new Note(
//                LocalDate.now(),
//                noteRequestDTO.getTopic(),
//                noteRequestDTO.getContent(),
//                user
//        );
//
//        noteRepo.save(note);
//        return "success";
//    }
//
//    // Get all notes for current user
//    @Override
//    public List<NoteResponseDTO> getAllNotes() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        List<Note> userNotes = noteRepo.findByUser(user);
//
//        List<NoteResponseDTO> responseList = new ArrayList<>();
//        for (Note note : userNotes) {
//            responseList.add(new NoteResponseDTO(
//                    note.getNoteId(),
//                    note.getDate(),
//                    note.getTopic(),
//                    note.getContent()
//            ));
//        }
//        return responseList;
//    }
//
//    // Get note by id only if belongs to current user
//    @Override
//    public NoteResponseDTO getNoteById(int noteId) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Note note = noteRepo.findById(noteId)
//                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
//                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));
//
//        return new NoteResponseDTO(
//                note.getNoteId(),
//                note.getDate(),
//                note.getTopic(),
//                note.getContent()
//        );
//    }
//
//    // Update note if it belongs to current user
//    @Override
//    public String updateNote(int noteId, NoteRequestDTO noteRequestDTO) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Note note = noteRepo.findById(noteId)
//                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
//                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));
//
//        note.setDate(LocalDate.now());
//        note.setTopic(noteRequestDTO.getTopic());
//        note.setContent(noteRequestDTO.getContent());
//        noteRepo.save(note);
//
//        return "success";
//    }
//
//    // Delete note if it belongs to current user
//    @Override
//    public String deleteNote(int noteId) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Note note = noteRepo.findById(noteId)
//                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
//                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));
//
//        noteRepo.delete(note);
//
//        return "success";
//    }
//}
package diary.diarynew.service.impl;

import diary.diarynew.dto.requestDTO.NoteRequestDTO;
import diary.diarynew.dto.responseDTO.NoteResponseDTO;
import diary.diarynew.entity.Note;
import diary.diarynew.entity.User;
import diary.diarynew.repo.NoteRepo;
import diary.diarynew.repo.UserRepo;
import diary.diarynew.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceIMPL implements NoteService {

    private final NoteRepo noteRepo;
    private final UserRepo userRepo;

    @Autowired
    public NoteServiceIMPL(NoteRepo noteRepo, UserRepo userRepo) {
        this.noteRepo = noteRepo;
        this.userRepo = userRepo;
    }

    @Override
    public String saveNote(NoteRequestDTO noteRequestDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = new Note(
                LocalDate.now(),
                noteRequestDTO.getTopic(),
                noteRequestDTO.getContent(),
                user
        );

        noteRepo.save(note);
        return "success";
    }

    @Override
    public List<NoteResponseDTO> getAllNotes() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Note> userNotes = noteRepo.findByUser(user);
        List<NoteResponseDTO> responseList = new ArrayList<>();
        for (Note note : userNotes) {
            responseList.add(new NoteResponseDTO(
                    note.getNoteId(),
                    note.getDate(),
                    note.getTopic(),
                    note.getContent()
            ));
        }
        return responseList;
    }

    @Override
    public NoteResponseDTO getNoteById(int noteId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = noteRepo.findById(noteId)
                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));

        return new NoteResponseDTO(
                note.getNoteId(),
                note.getDate(),
                note.getTopic(),
                note.getContent()
        );
    }

    @Override
    public String updateNote(int noteId, NoteRequestDTO noteRequestDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = noteRepo.findById(noteId)
                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));

        note.setDate(LocalDate.now());
        note.setTopic(noteRequestDTO.getTopic());
        note.setContent(noteRequestDTO.getContent());
        noteRepo.save(note);

        return "success";
    }

    @Override
    public String deleteNote(int noteId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = noteRepo.findById(noteId)
                .filter(n -> n.getUser().getUserId().equals(user.getUserId()))
                .orElseThrow(() -> new RuntimeException("Note not found or access denied"));

        noteRepo.delete(note);
        return "success";
    }
}
