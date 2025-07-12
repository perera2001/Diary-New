package diary.diarynew.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "note")
@NoArgsConstructor
@Data
public class Note {

    @Id
    @Column(name ="note_id",length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;


    //@Temporal(TemporalType.DATE)  // Proper annotation for storing only the date
    @Column(name = "date", nullable = false)
    private LocalDate date;


    @Column(name = "topic", length = 255, nullable = false)
    private String topic;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    public Note() {
//    }
//
    public Note( LocalDate date, String topic, String content , User user ) {
        this.date = date;
        this.topic = topic;
        this.content = content;
        this.user = user;
    }
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
