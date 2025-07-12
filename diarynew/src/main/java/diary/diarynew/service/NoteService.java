package diary.diarynew.service;

import diary.diarynew.dto.requestDTO.NoteRequestDTO;
import diary.diarynew.dto.responseDTO.NoteResponseDTO;

import java.util.List;

public interface NoteService {
    String saveNote(NoteRequestDTO noteRequestDTO);

    List<NoteResponseDTO> getAllNotes();

    NoteResponseDTO getNoteById(int noteId);

    String updateNote(int noteId, NoteRequestDTO noteRequestDTO);

    String deleteNote(int noteId);
}
