
public class Note {
    private String noteTitle;
    private String noteContent;


    public Note(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public Note(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteContent(String content) {
        this.noteContent = content;
    }

    public String getNoteContent() {
        return noteContent;
    }

    //
//    public Note searchNote(String notesTitle)
//
//    public boolean writeNote(Note notes)
//
//    public Note readNote(String title)

}
