package diary.diarynew.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteResponseDTO {

    private int noteId;
    private LocalDate date;
    private String topic;
    private String content;

//    public NoteResponseDTO() {
//    }
//
//    public NoteResponseDTO(int noteId, LocalDate date, String topic, String content) {
//        this.noteId = noteId;
//        this.date = date;
//        this.topic = topic;
//        this.content = content;
//    }
//
//    public int getNoteId() {
//        return noteId;
//    }
//
//    public void setNoteId(int noteId) {
//        this.noteId = noteId;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public String getTopic() {
//        return topic;
//    }
//
//    public void setTopic(String topic) {
//        this.topic = topic;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}
