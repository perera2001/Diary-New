package diary.diarynew.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteRequestDTO {
    private String topic;
    private String content;

//    public NoteRequestDTO() {
//    }
//
//    public NoteRequestDTO(String topic, String content) {
//        this.topic = topic;
//        this.content = content;
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
